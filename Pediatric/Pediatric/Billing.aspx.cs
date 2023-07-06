using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Web.Security;

namespace Pediatric
{
    public partial class Billing : System.Web.UI.Page
    {
        String connectionString = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=C:\Users\Acer\Documents\ELDNET.mdf;Integrated Security=True;Connect Timeout=30";
        public String username;
        public bool found = false;

        protected void Page_Load(object sender, EventArgs e)
        {                
            username = (string)Session["username"];
            displayLoggedInUserData(); //method call, display in label
        }

        protected void SaveButton_Click(object sender, EventArgs e)
        {
            int consultPrice = 500;
            int immunizationPrice = 800;
            int totalAmount=0;
            string inputtedDateString = " ";
            DateTime inputtedDate;

            SqlConnection billingCon = new SqlConnection(connectionString);
            string sql = "SELECT * FROM BILLINGHEADERFILE";

            SqlDataAdapter sqlDataAdapter = new SqlDataAdapter(sql, connectionString);
            SqlCommandBuilder commandBuilder = new SqlCommandBuilder(sqlDataAdapter);

            DataSet thisSet = new DataSet();
            sqlDataAdapter.MissingSchemaAction = MissingSchemaAction.AddWithKey;
            sqlDataAdapter.Fill(thisSet, "BILLINGHEADERFILE"); //RAM

            //findrow
            DataRow findRow = thisSet.Tables["BILLINGHEADERFILE"].Rows.Find(BillingNoTextBox.Text);
            if(findRow == null)
            {                        
                DataRow thisRow = thisSet.Tables["BILLINGHEADERFILE"].NewRow();

                thisRow["BILLHNO"] = BillingNoTextBox.Text;
                thisRow["BILLHPATCODE"] = PatientCodeTextBox.Text;
                //date 
                if (DateTime.TryParse(inputtedDateString, out inputtedDate))
                {
                    if (inputtedDate < DateTime.Now)
                    {
                        Response.Write("<script> alert('Invalid Date');</script>");
                    }
                    else
                    {
                        thisRow["BILLHDATE"] = DateTextBox.Text; 
                    }
                }
                //service type
                if (ConsultationCheckBox.Checked == true && ImmunizationCheckBox.Checked == true)
                {
                    totalAmount = consultPrice + immunizationPrice;
                    TotalAmountLabel.Text = totalAmount.ToString();
                    thisRow["BILLHTOTAMT"] = TotalAmountLabel.Text;
                }
                else if (ConsultationCheckBox.Checked == true)
                {

                    totalAmount += consultPrice;
                    TotalAmountLabel.Text = totalAmount.ToString();
                    thisRow["BILLHTOTAMT"] = TotalAmountLabel.Text;
                }
                else if (ImmunizationCheckBox.Checked == true)
                {
                    totalAmount += immunizationPrice;
                    TotalAmountLabel.Text = totalAmount.ToString();
                    thisRow["BILLHTOTAMT"] = TotalAmountLabel.Text;
                }

                thisRow["BILLHPREPBY"] = PreparedByLabel.Text;
                thisRow["BILLHSTAT"] = "OP"; //OP and CL

                Response.Write("<script> alert('Successfully Saved!');</script>");
                thisSet.Tables["BILLINGHEADERFILE"].Rows.Add(thisRow);
                sqlDataAdapter.Update(thisSet, "BILLINGHEADERFILE");

                clearData();
            }
            else
            {
                Response.Write("<script> alert('Duplicate Entries!');</script>");
                BillingNoTextBox.Focus();
            }
          

        }

        protected void ClearButton_Click(object sender, EventArgs e)
        {
            BillingNoTextBox.Text = "";
            PatientCodeTextBox.Text = "";
            ImmunizationNoTextBox.Text = "";
            FirstNameLabel.Text = "";
            MiddleNameLabel.Text = "";
            LastNameLabel.Text = "";
            AgeLabel.Text = "";
        }

        protected void SearchBillingButton_Click(object sender, EventArgs e)
        {
            SqlConnection billingCon = new SqlConnection(connectionString);
            string sql = "SELECT * FROM BILLINGHEADERFILE WHERE BILLHNO = '" + BillingNoTextBox.Text + "'";

            SqlCommand command = new SqlCommand(sql, billingCon);
            billingCon.Open(); 

            SqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                if (reader["BILLHNO"].ToString().Trim() == BillingNoTextBox.Text.Trim())
                {
                    found = true;
                    Response.Write("<script> alert('Billing Number already in the file');</script>");
                    BillingNoTextBox.Text = " ";
                    BillingNoTextBox.Focus();
                }
                else
                {
                    Response.Write("<script> alert('Billing Number Not yet in the file, continue filling out the form');</script>");
                }
            }
        }
        

        protected void SearchPatientButton_Click(object sender, EventArgs e)
        {
            SqlConnection patientCon = new SqlConnection(connectionString);
            string sql = "SELECT * FROM PATIENTINFOFILE";
            patientCon.Open();

            SqlCommand patientCommand = new SqlCommand(sql, patientCon);
            patientCommand.CommandText = "SELECT * FROM PATIENTINFOFILE WHERE PATCODE = '" + PatientCodeTextBox.Text + "'";

            SqlDataReader searchReader = patientCommand.ExecuteReader();

            while (searchReader.Read())
            {
                if(searchReader["PATSTATUS"].ToString().Trim() == "IN")
                {
                    Response.Write("<script> alert('Patient is already inactive!');</script>");
                    found = true;
                    clearData();             
                    break;
                }
                if(searchReader["PATCODE"].ToString().Trim() == PatientCodeTextBox.Text.Trim() && searchReader["PATSTATUS"].ToString().Trim() == "AC")
                {
                    found = true;
                    FirstNameLabel.Text = searchReader["PATFNAME"].ToString();
                    MiddleNameLabel.Text = searchReader["PATMNAME"].ToString();
                    LastNameLabel.Text = searchReader["PATLNAME"].ToString();
                    AgeLabel.Text = searchReader["PATAGE"].ToString();

                }
                            
            }  
            if(found == false)
            {
                Response.Write("<script> alert('Patient Code not found!');</script>");
                PatientCodeTextBox.Text = " ";
            }
            //close objects
            patientCon.Close();
            searchReader.Close();
        }   

        public void displayLoggedInUserData()
        {
            SqlConnection con = new SqlConnection(connectionString);
            con.Open();
            string sql = "SELECT * FROM EMPLOYEEFILE WHERE EMPUSERNAME ='"+username+"'";

            SqlCommand searchCommand = new SqlCommand(sql, con);
            SqlDataReader searchReader = searchCommand.ExecuteReader();
        
            if (searchReader.Read()) //["EMPUSERNAME"].ToString() == username)
            {       
                PreparedByLabel.Text = searchReader["EMPLOYEECODE"].ToString()+ " " + searchReader["EMPFNAME"].ToString();  
            }
            con.Close();
            searchReader.Close();
        }

        public void clearData()
        {
            BillingNoTextBox.Text = "";
            PatientCodeTextBox.Text = "";
            ImmunizationNoTextBox.Text = "";
            FirstNameLabel.Text = "";
            MiddleNameLabel.Text = "";
            LastNameLabel.Text = "";
            AgeLabel.Text = "";
            ConsultationCheckBox.Checked = false;
            ImmunizationCheckBox.Checked = false;
            TotalAmountLabel.Text = " ";

        }

        protected void LogoutLinkButton_Click(object sender, EventArgs e)
        {
            FormsAuthentication.SignOut();
            Response.Redirect("Login.aspx");
        }

        protected void HomeLinkButton_Click(object sender, EventArgs e)
        {
            Response.Redirect("Home.aspx");
        } 

    }
}