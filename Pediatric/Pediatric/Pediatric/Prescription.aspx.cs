using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;

namespace Pediatric
{
    public partial class Prescription : System.Web.UI.Page
    {
        String connectionString = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=C:\Users\Acer\Documents\ELDNET.mdf;Integrated Security=True;Connect Timeout=30";
        public String username;

        protected void Page_Load(object sender, EventArgs e)
        {
            username = (string)Session["username"];
            displayLoggedInUserData(); //method call, display in label
        }

        protected void SaveButton_Click(object sender, EventArgs e)
        {
            string sql = "SELECT * FROM PRESCRIPTIONHEADERFILE";
            SqlDataAdapter thisAdapter = new SqlDataAdapter(sql, connectionString);
            SqlCommandBuilder commandBuilder = new SqlCommandBuilder(thisAdapter);

            DataSet thisSet = new DataSet();
            thisAdapter.MissingSchemaAction = MissingSchemaAction.AddWithKey;
            thisAdapter.Fill(thisSet, "PRESCRIPTIONHEADERFILE"); //RAM

            //findrow
            DataRow findRow = thisSet.Tables["PRESCRIPTIONHEADERFILE"].Rows.Find(PrescriptionNoTextBox.Text);
            if (findRow == null)
            {
                DataRow thisRow = thisSet.Tables["PRESCRIPTIONHEADERFILE"].NewRow();
                thisRow["PRESHCODE"] = PrescriptionNoTextBox.Text;
                thisRow["PRESHCONSNO"] = ConsultationNoTextBox.Text;
                thisRow["PRESHPATCODE"] = PatientCodeTextBox.Text;
                
                ScriptManager.RegisterClientScriptBlock(this, this.GetType(), "alertMessage", "alert('Entries Successfully Recorded!')", true);
                thisSet.Tables["PRESCRIPTIONHEADERFILE"].Rows.Add(thisRow);
                thisAdapter.Update(thisSet, "PRESCRIPTIONHEADERFILE");
            }
            else
            {
                ScriptManager.RegisterClientScriptBlock(this, this.GetType(), "alertMessage", "alert('Duplicate Entries!')", true);
                PrescriptionNoTextBox.Focus();
            }

            //clear textboxt after save         
            PrescriptionNoTextBox.Text = "";
            ConsultationNoTextBox.Text = "";
            PatientCodeTextBox.Text = "";
        }

        protected void SearchButton_Click(object sender, EventArgs e)
        {
            bool found = false;

            SqlConnection searchConnection = new SqlConnection(connectionString);
            string sql = "SELECT * FROM PATIENTINFOFILE WHERE PATIENTCODE = '" + PatientCodeTextBox.Text + "'";
            searchConnection.Open();
            SqlCommand searchCommand = new SqlCommand(sql, searchConnection);
            SqlDataReader searchReader = searchCommand.ExecuteReader();

            
            while (searchReader.Read())
            {
                if (searchReader["PATIENTCODE"].ToString().Trim() == PatientCodeTextBox.Text.Trim())
                {
                    found = true;
                    PatientNameLabel.Text = searchReader["PATIENTNAME"].ToString();
                    //PatientAddressLabel.Text = searchReader["PATIENTADDRESS"].ToString();
                    AgeLabel.Text = searchReader["PATIENTAGE"].ToString();
                }
                else
                {
                    Response.Write("<script> alert('Patient Code not found!');</script>");
                }
                   
            }

            searchConnection.Close();
            searchReader.Close();

        }

        public void displayLoggedInUserData()
        {
            SqlConnection con = new SqlConnection(connectionString);
            con.Open();
            string sql = "SELECT * FROM EMPLOYEEFILE WHERE EMPUSERNAME ='" + username + "'";

            SqlCommand searchCommand = new SqlCommand(sql, con);
            SqlDataReader searchReader = searchCommand.ExecuteReader();

            if (searchReader.Read()) 
            {
                PreparedByLabel.Text = searchReader["EMPLOYEECODE"].ToString() + " " + searchReader["EMPFIRSTNAME"].ToString();
            }
            con.Close();
            searchReader.Close();
        }
    }
}