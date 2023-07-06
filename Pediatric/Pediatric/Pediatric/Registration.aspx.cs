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
    public partial class Registration : System.Web.UI.Page
    {
        SqlConnection connectionString = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=C:\Users\Acer\Documents\ELDNET.mdf;Integrated Security=True;Connect Timeout=30");

        protected void Page_Load(object sender, EventArgs e)
        {
            ValidationSettings.UnobtrusiveValidationMode = UnobtrusiveValidationMode.None;           
        }

        protected void SubmitButton_Click(object sender, EventArgs e)
        {         
            string sql = "SELECT * FROM EMPLOYEEFILE";
            SqlDataAdapter thisAdapter = new SqlDataAdapter(sql, connectionString);
            SqlCommandBuilder commandBuilder = new SqlCommandBuilder(thisAdapter);

            DataSet thisSet = new DataSet();
            thisAdapter.MissingSchemaAction = MissingSchemaAction.AddWithKey;
            thisAdapter.Fill(thisSet, "EMPLOYEEFILE"); //RAM

            //findrow
            DataRow findRow = thisSet.Tables["EMPLOYEEFILE"].Rows.Find(UserCodeTxt.Text);
            if (findRow == null)
            {
                DataRow thisRow = thisSet.Tables["EMPLOYEEFILE"].NewRow();
                //textboxes
                thisRow["EMPLOYEECODE"] = UserCodeTxt.Text;
                thisRow["EMPUSERNAME"] = UserNameTxt.Text;
                thisRow["EMPFNAME"] = FirstNameTxt.Text;
                thisRow["EMPLNAME"] = LastNameTxt.Text;
                thisRow["EMPMNAME"] = MiddleNameTxt.Text;
                thisRow["EMPPASSWORD"] = ConfirmPassTxt.Text;
                thisRow["EMPSTATUS"] = "AC";

                //dropdown input
                if (PositionDropDownList.SelectedIndex == 1)
                {
                    thisRow["EMPPOSITION"] = "Admin";
                }
                else if(PositionDropDownList.SelectedIndex == 2)
                {
                    thisRow["EMPPOSITION"] = "Doctor";                 
                }
                else if(PositionDropDownList.SelectedIndex == 3)
                {
                    thisRow["EMPPOSITION"] = "Nurse";
                }
          
                Response.Write("<script> alert('Entries Successfully Recorded!');</script>");
                thisSet.Tables["EMPLOYEEFILE"].Rows.Add(thisRow);
                thisAdapter.Update(thisSet, "EMPLOYEEFILE");
            }
            else
            {
                Response.Write("<script> alert('Duplicate Entries!');</script>");
                UserCodeTxt.Focus();
            }

            //clear inputs, reset list
            UserCodeTxt.Text = " ";
            UserNameTxt.Text = " ";
            FirstNameTxt.Text = " ";
            LastNameTxt.Text = " ";
            MiddleNameTxt.Text = " ";
            PositionDropDownList.SelectedIndex = 0;
            PasswordTxt.Text = " ";
            ConfirmPassTxt.Text = " ";           
        }

        protected void LinkButton1_Click(object sender, EventArgs e)
        {
            Response.Redirect("Login.aspx");
        }
    }
}