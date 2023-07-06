using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Web.Security;
using System.Data;
using System.Configuration;

namespace Pediatric
{
    public partial class Immunization : System.Web.UI.Page
    {
        SqlConnection connectionString = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=C:\Users\Acer\Documents\ELDNET.mdf;Integrated Security=True;Connect Timeout=30");
        public String username;
        bool found = false;

        protected void Page_Load(object sender, EventArgs e)
        {
            ValidationSettings.UnobtrusiveValidationMode = UnobtrusiveValidationMode.None;
            username = (string)Session["username"];
            displayLoggedInUserData(); //method call, display in label
        }

        protected void SaveButton_Click(object sender, EventArgs e)
        {
            string inputtedDateString = " ";
            DateTime inputtedDate;
            string sql = "SELECT * FROM IMMUNIZATIONHEADERTABLE";

            SqlDataAdapter thisDataAdapter = new SqlDataAdapter(sql, connectionString);

            SqlCommandBuilder immunizationCommandBuilder = new SqlCommandBuilder(thisDataAdapter);
            DataSet immunizationDataSet = new DataSet();
            thisDataAdapter.MissingSchemaAction = MissingSchemaAction.AddWithKey; //set primary key
            thisDataAdapter.Fill(immunizationDataSet, "IMMUNIZATIONHEADERTABLE");

            DataRow immunizationFindRow = immunizationDataSet.Tables["IMMUNIZATIONHEADERTABLE"].Rows.Find(ImmunizationNoTextBox.Text);
            if (immunizationFindRow == null)
            {

                DataRow immunizationDataRow = immunizationDataSet.Tables["IMMUNIZATIONHEADERTABLE"].NewRow();
                immunizationDataRow["IMMHIMMUNO"] = ImmunizationNoTextBox.Text;//immunization number                                  
                immunizationDataRow["IMMHDATE"] = DateTextBox.Text;//date and time                                         
                immunizationDataRow["IMMHPATCODE"] = PatientCodeTextBox.Text;//Patient Code
                immunizationDataRow["IMMHPATWEIGHT"] = WeightTextBox.Text.ToString();//weight of patient 
                immunizationDataRow["IMMHPATHEIGHT"] = HeightTextBox.Text.ToString();//Height of patient  
                immunizationDataRow["IMMHPREPBY"] = PreparedByLabel.Text;//Prapared By
                immunizationDataRow["IMMHIMMUBY"] = ImmunizedByLabel.Text;//Immunized By
                immunizationDataRow["IMMHSTAT"] = "AC";

                immunizationDataSet.Tables["IMMUNIZATIONHEADERTABLE"].Rows.Add(immunizationDataRow);
                thisDataAdapter.Update(immunizationDataSet, "IMMUNIZATIONHEADERTABLE");
                clearData();
                Response.Write("<script> alert('Entries Recorded!');</script>");
            }
            else
            {
                Response.Write("<script> alert('Duplicate Entries!');</script>");
            }
        }

        protected void ClearButton_Click(object sender, EventArgs e)
        {
            ImmunizationNoTextBox.Text = "";
            PatientCodeTextBox.Text = "";
            HeightTextBox.Text = "";
            WeightTextBox.Text = "";
            VaccineCodeTextBox.Text = "";
            DoseTextBox.Text = "";
        }   

        protected void HomeLinkButton_Click(object sender, EventArgs e)
        {
            Response.Redirect("Home.aspx");
        }

        protected void LogoutLinkButton_Click(object sender, EventArgs e)
        {
            FormsAuthentication.SignOut();
            Response.Redirect("Login.aspx");
        }

        protected void SearchImmunizationButton_Click(object sender, EventArgs e)
        {
            bool found = false;

            string sql = "SELECT * FROM IMMUNIZATIONHEADERTABLE WHERE IMMHIMMUNO = '" + ImmunizationNoTextBox.Text + "'";

            SqlCommand thisCommand = new SqlCommand(sql, connectionString);
            connectionString.Open();

            SqlDataReader thisReader = thisCommand.ExecuteReader();
            while (thisReader.Read())
            {
                if (thisReader["IMMHIMMUNO"].ToString().Trim() == ImmunizationNoTextBox.Text.Trim())
                {
                    found = true;
                    Response.Write("<script> alert('Immunization Number Already Exist!');</script>");
                    ImmunizationNoTextBox.Text = "";
                    ImmunizationNoTextBox.Focus();
                }
            }
        }

        protected void SearchPatientButton_Click(object sender, EventArgs e)
        {
            connectionString.Open();
            string sql = "SELECT * FROM PATIENTINFOFILE";
            
            SqlCommand patientCommand = new SqlCommand(sql, connectionString);
            patientCommand.CommandText = "SELECT * FROM PATIENTINFOFILE WHERE PATCODE = '" + PatientCodeTextBox.Text + "'";

            SqlDataReader searchReader = patientCommand.ExecuteReader();

            while (searchReader.Read())
            {
                if (searchReader["PATSTATUS"].ToString().Trim() == "IN")
                {
                    Response.Write("<script> alert('Patient is already inactive!');</script>");
                    found = true;
                    clearData();
                    break;
                }
                if (searchReader["PATCODE"].ToString().Trim() == PatientCodeTextBox.Text.Trim() && searchReader["PATSTATUS"].ToString().Trim() == "AC")
                {
                    found = true;
                    NameLabel.Text = searchReader["PATFNAME"].ToString() + searchReader["PATLNAME"].ToString();
                    AddressLabel.Text = searchReader["PATADDR"].ToString();
                    TelephoneLabel.Text = searchReader["PATTEL"].ToString();
                    FathersNameLabel.Text = searchReader["PATFATHNAME"].ToString();
                    MothersNameLabel.Text = searchReader["PATMOTHNAME"].ToString();
                    GenderLabel.Text = searchReader["PATGENDER"].ToString();
                    BirthdayLabel.Text = searchReader["PATBDATE"].ToString();                  
                    AgeLabel.Text = searchReader["PATAGE"].ToString();

                }
            }
            if(found == false)
            {
                Response.Write("<script> alert('Patient Code not found!');</script>");
                PatientCodeTextBox.Text = " ";
            }
            //close objects
            connectionString.Close();
            searchReader.Close();
        }

        protected void SearchVaccineButton_Click(object sender, EventArgs e)
        {
            string sql = "SELECT * FROM VACCINEFILE";
            connectionString.Open();

            SqlCommand vaxCommand = new SqlCommand(sql, connectionString);
            vaxCommand.CommandText = "SELECT * FROM VACCINEFILE WHERE VAXCODE = '" + VaccineCodeTextBox.Text + "'";

            SqlDataReader searchReader = vaxCommand.ExecuteReader();

            while (searchReader.Read())
            {    
                if (searchReader["VAXCODE"].ToString().Trim() == VaccineCodeTextBox.Text.Trim())
                {
                    found = true;
                    displayData();
                }
            }
            if (found == false)
            {
                displayData();
            }
            //close objects
            connectionString.Close();
            searchReader.Close();
        }

        public void displayData()
        {
            string con = ConfigurationManager.ConnectionStrings["ELDNETConnectionString"].ConnectionString;
            SqlConnection sqlcon = new SqlConnection(con);
            sqlcon.Open();
            SqlCommand sqlcommand = new SqlCommand();
            string query = "SELECT * FROM VACCINEFILE WHERE VAXCODE LIKE '%' + @VAXCODE + '%'";
            sqlcommand.CommandText = query;
            sqlcommand.Connection = sqlcon;
            sqlcommand.Parameters.AddWithValue("VAXCODE", VaccineCodeTextBox.Text);
            DataTable dt = new DataTable();
            SqlDataAdapter sda = new SqlDataAdapter(sqlcommand);
            sda.Fill(dt);
            GridView1.DataSource = dt;
            GridView1.DataBind();
        }

        public void displayLoggedInUserData()
        {

            connectionString.Open();
            string sql = "SELECT * FROM EMPLOYEEFILE WHERE EMPUSERNAME ='" + username + "'";

            SqlCommand searchCommand = new SqlCommand(sql, connectionString);
            SqlDataReader searchReader = searchCommand.ExecuteReader();

            if (searchReader.Read()) //["EMPUSERNAME"].ToString() == username)
            {
                PreparedByLabel.Text = searchReader["EMPLOYEECODE"].ToString() + " " + searchReader["EMPFNAME"].ToString();
                ImmunizedByLabel.Text = searchReader["EMPLOYEECODE"].ToString() + " " + searchReader["EMPFNAME"].ToString();
            }
            connectionString.Close();
            searchReader.Close();
        }

        public void clearData()
        {
            ImmunizationNoTextBox.Text = "";
            PatientCodeTextBox.Text = "";
            HeightTextBox.Text = "";
            WeightTextBox.Text = "";
            VaccineCodeTextBox.Text = "";
            DoseTextBox.Text = "";
            NameLabel.Text = "";
            AddressLabel.Text = "";
            TelephoneLabel.Text = "";
            FathersNameLabel.Text = "";
            MothersNameLabel.Text = "";
            GenderLabel.Text = "";
            BirthdayLabel.Text = "";
            AgeLabel.Text = "";
        
        }


    }
}