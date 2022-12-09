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
          
            string sql = "SELECT * FROM USERS";
            SqlDataAdapter thisAdapter = new SqlDataAdapter(sql, connectionString);
            SqlCommandBuilder commandBuilder = new SqlCommandBuilder(thisAdapter);

            DataSet thisSet = new DataSet();
            thisAdapter.MissingSchemaAction = MissingSchemaAction.AddWithKey;
            thisAdapter.Fill(thisSet, "USERS"); //RAM

            //findrow
            DataRow findRow = thisSet.Tables["USERS"].Rows.Find(UserIdTxt.Text);
            if (findRow == null)
            {
                DataRow thisRow = thisSet.Tables["USERS"].NewRow();
                //textboxes
                thisRow["USERNAME"] = UserIdTxt.Text;
                thisRow["USERFIRSTNAME"] = FirstNameTxt.Text;
                thisRow["USERLASTNAME"] = LastNameTxt.Text;
                thisRow["USERPASSWORD"] = ConfirmPassTxt.Text;

                //dropdown input
                if (DropDownList1.SelectedValue == "Admin")
                {              
                    thisRow["USERROLE"] = DropDownList1.SelectedValue;
                }
                else if(DropDownList1.SelectedValue == "Doctor")
                {
                    thisRow["USERROLE"] = DropDownList1.SelectedValue;
                }
                else if(DropDownList1.SelectedValue == "Nurse")
                {
                    thisRow["USERROLE"] = DropDownList1.SelectedValue;
                }
          
                Response.Write("<script> alert('Entries Successfully Recorded!');</script>");
                thisSet.Tables["USERS"].Rows.Add(thisRow);
                thisAdapter.Update(thisSet, "USERS");
            }
            else
            {
                Response.Write("<script> alert('Duplicate Entries!');</script>");
                UserIdTxt.Focus();
            }

            UserIdTxt.Text = " ";
            FirstNameTxt.Text = " ";
            LastNameTxt.Text = " ";
            PasswordTxt.Text = " ";
            ConfirmPassTxt.Text = " ";           
        }

       
    }
}