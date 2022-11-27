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
        String role;
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
                thisRow["USERID"] = UserIdTxt.Text;
                thisRow["USERNAME"] = UserNameTxt.Text;
                thisRow["USERPASSWORD"] = ConfirmPassTxt.Text;

                //checkboxes
                if (AdminRB.Checked == true)
                {
                    role = "Admin";
                    thisRow["USERROLE"] = AdminRB.Text;
                }
                else if(DoctorRB.Checked == true)
                {
                    role = "Doctor";
                    thisRow["USERROLE"] = DoctorRB.Text;
                }
                else if(NurseRB.Checked == true)
                {
                    role = "Nurse";
                    thisRow["USERROLE"] = NurseRB.Text;
                }
                    
                ScriptManager.RegisterClientScriptBlock(this, this.GetType(), "alertMessage", "alert('Entries Successfully Recorded!')", true);
                thisSet.Tables["USERS"].Rows.Add(thisRow);
                thisAdapter.Update(thisSet, "USERS");
            }
            else
            {
                ScriptManager.RegisterClientScriptBlock(this, this.GetType(), "alertMessage", "alert('Duplicate Entries!')", true);
                UserIdTxt.Focus();
            }

            UserIdTxt.Text = " ";
            UserNameTxt.Text = " ";
            PasswordTxt.Text = " ";
            ConfirmPassTxt.Text = " ";
            AdminRB.Checked = false;
            DoctorRB.Checked = false;
            NurseRB.Checked = false;
            displayData(); //display at data grid realtime manner
        }

        public void displayData()
        {
            //retrieve at datagrid
            SqlCommand gridCommand = new SqlCommand("SELECT * FROM USERS", connectionString);
            SqlDataAdapter gridAdapter = new SqlDataAdapter(gridCommand);
            DataSet dataSet = new DataSet();
            gridAdapter.Fill(dataSet);
            //GridView1.DataSource = dataSet;
            GridView1.DataBind();
        }
    }
}