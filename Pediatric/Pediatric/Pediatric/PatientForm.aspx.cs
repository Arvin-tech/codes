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
    public partial class PatientForm : System.Web.UI.Page
    {
        SqlConnection connectionString = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=C:\Users\Acer\Documents\ELDNET.mdf;Integrated Security=True;Connect Timeout=30");
        public String username;

        protected void Page_Load(object sender, EventArgs e)
        {

            ValidationSettings.UnobtrusiveValidationMode = UnobtrusiveValidationMode.None;
            if (!IsPostBack)
            {
                displayData();
            }
            //UserLabel.Text = " " + Session["username"]; 
            username = (string)Session["username"];
            displayLoggedInUserData(); //method call, display in label
        }

        protected void SaveButton_Click(object sender, EventArgs e)
        {
              
            string sql = "SELECT * FROM PATIENTINFOFILE";
            SqlDataAdapter thisAdapter = new SqlDataAdapter(sql, connectionString);
            SqlCommandBuilder commandBuilder = new SqlCommandBuilder(thisAdapter);

            DataSet thisSet = new DataSet();
            thisAdapter.MissingSchemaAction = MissingSchemaAction.AddWithKey;
            thisAdapter.Fill(thisSet, "PATIENTINFOFILE"); //RAM

            //findrow
            DataRow findRow = thisSet.Tables["PATIENTINFOFILE"].Rows.Find(PatientCodeTextBox.Text);
            if (findRow == null)
            {
                DataRow thisRow = thisSet.Tables["PATIENTINFOFILE"].NewRow();
                thisRow["PATCODE"] = PatientCodeTextBox.Text;
                thisRow["PATFNAME"] = PatientFirstnameTextBox.Text;
                thisRow["PATMNAME"] = PatientMiddlenameTextbox.Text;
                thisRow["PATLNAME"] = PatientLastnameTextbox.Text;
                thisRow["PATAGE"] = PatientAgeTextBox.Text;
              
                if (MaleRadioButton.Checked == true)
                    thisRow["PATGENDER"] = "M";
                else if (FemaleRadioButton.Checked == true)
                    thisRow["PATGENDER"] = "F";

                thisRow["PATBDATE"] = BirthdateTextbox.Text;
                thisRow["PATADDR"] = AddressTextbox.Text;
                thisRow["PATTEL"] = TelephoneTextbox.Text;
                thisRow["PATFATHNAME"] = FathersNameTextbox.Text;
                thisRow["PATMOTHNAME"] = MothersNameTextbox.Text;
                thisRow["PATHEIGHT"] = HeightTextbox.Text;
                thisRow["PATWEIGHT"] = WeightTextbox.Text;
                thisRow["PATSTATUS"] = "AC"; //active

                int age = Convert.ToInt32(PatientAgeTextBox.Text);
                if (age >= 19)
                {
                    thisRow["PATSTATUS"] = "IN";
                }

                Response.Write("<script> alert('Entries Successfully Recorded!');</script>");
                thisSet.Tables["PATIENTINFOFILE"].Rows.Add(thisRow);
                thisAdapter.Update(thisSet, "PATIENTINFOFILE");         
            }
            else
            { 
                Response.Write("<script> alert('Duplicate Entries');</script>");
                PatientCodeTextBox.Focus();
            }

            clearData();
            displayData();

        }

        public void displayData()
        {
            //retrieve at datagrid
            SqlCommand gridCommand = new SqlCommand("SELECT * FROM PATIENTINFOFILE", connectionString);
            SqlDataAdapter gridAdapter = new SqlDataAdapter(gridCommand);
            DataSet dataSet = new DataSet();
            gridAdapter.Fill(dataSet);
            //GridView1.DataSource = dataSet;
            GridView1.DataBind();
        }

        public void clearData()
        {
            //clear textboxes
            PatientCodeTextBox.Text = " ";
            PatientFirstnameTextBox.Text = " ";
            PatientMiddlenameTextbox.Text = " ";
            PatientLastnameTextbox.Text = " ";
            PatientAgeTextBox.Text = " ";
            MaleRadioButton.Checked = false;
            FemaleRadioButton.Checked = false;
            BirthdateTextbox.Text = " ";
            AddressTextbox.Text = " ";
            TelephoneTextbox.Text = " ";
            FathersNameTextbox.Text = " ";
            MothersNameTextbox.Text = " ";
            HeightTextbox.Text = " ";
            WeightTextbox.Text = " ";
        }

        protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
        {
        
        }

        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            //deletebutton
            int rowIndex = ((GridViewRow)(sender as Control).NamingContainer).RowIndex;
            int patientCode = Convert.ToInt32(GridView1.Rows[rowIndex].Cells[1].Text);
            connectionString.Open();
            SqlCommand thisCommand = new SqlCommand("Delete from PATIENTINFOFILE where PATIENTCODE='" + patientCode + "'", connectionString);
            thisCommand.ExecuteNonQuery();
            connectionString.Close();
        }

        public void displayLoggedInUserData()
        {        
            connectionString.Open();
            string sql = "SELECT * FROM EMPLOYEEFILE WHERE EMPUSERNAME ='" + username + "'";

            SqlCommand searchCommand = new SqlCommand(sql, connectionString);
            SqlDataReader searchReader = searchCommand.ExecuteReader();

            if (searchReader.Read())
            {
                UserLabel.Text = searchReader["EMPLOYEECODE"].ToString() + " " + searchReader["EMPFNAME"].ToString();
            }
            connectionString.Close();
            searchReader.Close();
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