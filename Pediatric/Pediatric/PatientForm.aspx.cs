using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;

namespace Pediatric
{
    public partial class PatientForm : System.Web.UI.Page
    {
        SqlConnection connectionString = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=C:\Users\Acer\Documents\ELDNET.mdf;Integrated Security=True;Connect Timeout=30");

        protected void Page_Load(object sender, EventArgs e)
        {

            ValidationSettings.UnobtrusiveValidationMode = UnobtrusiveValidationMode.None;
            if (!IsPostBack)
            {
                displayData();
            }
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
                thisRow["PATIENTCODE"] = PatientCodeTextBox.Text;
                thisRow["PATIENTNAME"] = PatientNameTextBox.Text;
                thisRow["PATIENTAGE"] = PatientAgeTextBox.Text;

                Response.Write("<script> alert('Entries Successfully Recorded!');</script>");
                thisSet.Tables["PATIENTINFOFILE"].Rows.Add(thisRow);
                thisAdapter.Update(thisSet, "PATIENTINFOFILE");         
            }
            else
            { 
                Response.Write("<script> alert('Duplicate Entries');</script>");
                PatientCodeTextBox.Focus();
            }

            //clear textboxt after save 
            PatientCodeTextBox.Text="";
            PatientNameTextBox.Text="";
            PatientAgeTextBox.Text="";
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
    }
}