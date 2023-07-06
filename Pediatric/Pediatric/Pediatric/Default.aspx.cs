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
        
        protected void Page_Load(object sender, EventArgs e)
        {
            ValidationSettings.UnobtrusiveValidationMode = UnobtrusiveValidationMode.None;
            ErrorLabel.Visible = false;       
        }

        protected void LoginButton_Click(object sender, EventArgs e)
        {
            SqlConnection con = new SqlConnection(connectionString);
            con.Open();
            string query = "SELECT COUNT(*) FROM EMPLOYEEFILE WHERE EMPUSERNAME=@username AND EMPPASSWORD=@password";

            SqlCommand command = new SqlCommand(query, con);
            command.Parameters.AddWithValue("@username", UsernameTxt.Text.Trim());
            command.Parameters.AddWithValue("@password", PasswordTxt.Text.Trim());
            int count = Convert.ToInt32(command.ExecuteScalar());
            if (count == 1)
            {
                Session["username"] = UsernameTxt.Text;
                Response.Redirect("Home.aspx"); //proceed form
            }
            else
            {
                ErrorLabel.Visible = true; //wrong credentials
            }
            
        }

        protected void SignUpLinkButton_Click(object sender, EventArgs e)
        {
            Response.Redirect("Registration.aspx");
        }
    }
}