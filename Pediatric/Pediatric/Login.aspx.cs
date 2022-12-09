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
    public partial class Login : System.Web.UI.Page
    {
        String connectionString = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=C:\Users\Acer\Documents\ELDNET.mdf;Integrated Security=True;Connect Timeout=30";
        Users user = new Users(); //Users class object

        protected void Page_Load(object sender, EventArgs e)
        {
            ValidationSettings.UnobtrusiveValidationMode = UnobtrusiveValidationMode.None;
        }

        protected void LoginButton_Click(object sender, EventArgs e)
        {  
            SqlConnection con = new SqlConnection(connectionString);
            con.Open();
            
            SqlCommand command = new SqlCommand();
            command.Connection = con;
            command.CommandText = "SELECT * FROM USERS WHERE USERNAME = '" + UsernameTxt.Text + "'";

            DataTable dt = new DataTable();

            SqlDataReader reader = command.ExecuteReader();
            if (reader.Read())
            {
                if(UsernameTxt.Text.Equals(reader["USERNAME"].ToString()) && PasswordTxt.Text.Equals(reader["USERPASSWORD"].ToString()))
                {
                    dt.Load(reader); //fetch data row from users table
                    DataRow row = dt.Rows[0];
                    user.Username = row["USERNAME"].ToString();
                    user.Firstname = row["USERFIRSTNAME"].ToString();

                    //close login form and open a form
                    //Response.Redirect("formname.aspx");

                    //if successful login
                    Response.Write("<script> alert('Login Succesful!');</script>");
                    
                }
            }
            else
            {
                Response.Write("<script> alert('Can't Login!');</script>");
            }
        }
    }
}