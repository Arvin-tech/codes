using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Drawing;

namespace AutoCenter
{
    public partial class AutoCenter : System.Web.UI.Page
    {
        private readonly double TAXRATE = .08;
        private double tax;  
        private double accessoriesAndFinish;
        private double subtotal;
        private double total;
        private double amountDue;
        //accessories
        private double stereoSystem = 425.76;
        private double leatherInterior = 987.41;
        private double computerNavigation = 1741.23;
        //exterior finish
        private double standard = 0.00; //no additional charge
        private double pearlized = 345.72;
        private double customized = 599.99;

        protected void Page_Load(object sender, EventArgs e)
        {
            ValidationSettings.UnobtrusiveValidationMode = UnobtrusiveValidationMode.None;
        }

        protected void CalculateButton_Click(object sender, EventArgs e)
        {
           
            int tradeAmount=0;
            if(int.TryParse(TradeInAllowanceTextBox.Text, out tradeAmount));
            int basePrice;
            basePrice = Convert.ToInt32(CarSalesPriceTextBox.Text);

            //accessories
            if(StereoSystemCheckBox.Checked == true)
            {
                subtotal = subtotal + stereoSystem;
                accessoriesAndFinish = accessoriesAndFinish + stereoSystem;
            }
            if(LeatherInteriorCheckBox.Checked == true)
            {
                subtotal = subtotal + leatherInterior;
                accessoriesAndFinish = accessoriesAndFinish + leatherInterior;
            }
            if (ComputerNavigationCheckBox.Checked == true )
            {
                subtotal = subtotal + computerNavigation;
                accessoriesAndFinish = accessoriesAndFinish + computerNavigation;
            }      
            //finish
            if(StandardRadioButton.Checked == true)
            {
                subtotal = subtotal + standard;
                accessoriesAndFinish = accessoriesAndFinish + standard;
            }
            else if(PearlizedRadioButton.Checked == true)
            {
                subtotal = subtotal + pearlized;
                accessoriesAndFinish = accessoriesAndFinish + pearlized;
            }
            else if(CustomizedDetailingRadioButton.Checked == true)
            {
                subtotal = subtotal + customized;
                accessoriesAndFinish = accessoriesAndFinish + customized;
            }
            //outputs
            AccessoriesLabel.Text = accessoriesAndFinish.ToString();
            subtotal = subtotal + basePrice;
            SubtotalLabel.Text = subtotal.ToString();
            total = subtotal * TAXRATE + subtotal;
            TotalLabel.Text = total.ToString(); 
            tax = subtotal * TAXRATE;
            SalesTaxLabel.Text = tax.ToString();
            amountDue = tradeAmount - total;
            AmountDueLabel.Text = amountDue.ToString();

            Response.Write("Calculated!");
        }

        protected void ClearButton_Click(object sender, EventArgs e)
        {
            //clear checkbox
            if(StereoSystemCheckBox.Checked)
                StereoSystemCheckBox.Checked = false;    
            else if(LeatherInteriorCheckBox.Checked)
                LeatherInteriorCheckBox.Checked = false; 
            else if(ComputerNavigationCheckBox.Checked)
                ComputerNavigationCheckBox.Checked = false;

            //clear radiobuttons
            StandardRadioButton.Checked = false;
            PearlizedRadioButton.Checked = false;
            CustomizedDetailingRadioButton.Checked = false;
            //clear textboxes
            CarSalesPriceTextBox.Text = " ";
            TradeInAllowanceTextBox.Text = " ";
            //clear labels
            AccessoriesLabel.Text = " ";
            SubtotalLabel.Text = " ";
            SalesTaxLabel.Text = " ";
            TotalLabel.Text = " ";
            AmountDueLabel.Text = " ";
        }

        protected void ExitButton_Click(object sender, EventArgs e)
        {
            System.Environment.Exit(0);
        }

        protected void StandardRadioButton_CheckedChanged(object sender, EventArgs e)
        {
            if(StandardRadioButton.Checked == true)
            {
                PearlizedRadioButton.Checked = false; 
                CustomizedDetailingRadioButton.Checked = false;
            }
        }

        protected void PearlizedRadioButton_CheckedChanged(object sender, EventArgs e)
        {
            if(PearlizedRadioButton.Checked == true)
            {
                StandardRadioButton.Checked = false;
                CustomizedDetailingRadioButton.Checked = false;
            }
        }

        protected void CustomizedDetailingRadioButton_CheckedChanged(object sender, EventArgs e)
        {
            if(CustomizedDetailingRadioButton.Checked == true)
            {
                StandardRadioButton.Checked = false;
                PearlizedRadioButton.Checked = false;
            }
        }

        protected void StereoSystemCheckBox_CheckedChanged(object sender, EventArgs e)
        {

        }

        protected void LeatherInteriorCheckBox_CheckedChanged(object sender, EventArgs e)
        {

        }

        protected void ComputerNavigationCheckBox_CheckedChanged(object sender, EventArgs e)
        {

        }
    }
}