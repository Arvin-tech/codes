<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="AutoCenter.aspx.cs" Inherits="AutoCenter.AutoCenter" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Auto Center</title>
    <style type="text/css">
        .auto-style1 {
            width: 100%;
            height: 254px;
        }
        .auto-style2 {
            width: 381px;
        }
        .auto-style4 {
            width: 100px;
        }
        .auto-style5 {
            width: 160px;
        }
        .auto-style6 {
            width: 381px;
            text-align: left;
        }
        .auto-style7 {
            width: 160px;
            text-align: right;
        }
        .auto-style8 {
            width: 381px;
            text-align: left;
            height: 25px;
        }
        .auto-style9 {
            width: 160px;
            text-align: right;
            height: 25px;
        }
        .auto-style10 {
            width: 100px;
            height: 25px;
        }
        .auto-style11 {
            height: 25px;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

</head>
<body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
    
    <form id="form1" runat="server">
        <div>
            <table class="auto-style1">
                <tr>
                    <td class="auto-style2">
                        <strong>
                        <asp:Label ID="Label1" runat="server" Text="Accessories"></asp:Label>
                        </strong>
                    </td>
                    <td class="auto-style7">
                        <asp:Label ID="Label3" runat="server" Text="Car Sales Price
                            "></asp:Label>
                    </td>
                    <td class="auto-style4">
                        <asp:TextBox ID="CarSalesPriceTextBox" placeholder="Enter base price" runat="server" input type="text" class="form-control"></asp:TextBox>                        
                    </td>
                    <td>
                        <asp:RequiredFieldValidator ID="CarSalesRequiredFieldValidator" runat="server" ErrorMessage="Field Required!" ControlToValidate="CarSalesPriceTextBox" ForeColor="Red"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style6">
                        <asp:CheckBox ID="StereoSystemCheckBox" runat="server" GroupName="AccessoriesGroup"  Text="Stereo System" OnCheckedChanged="StereoSystemCheckBox_CheckedChanged" />
                    </td>
                    <td class="auto-style7">
                        <asp:Label ID="Label4" runat="server" Text="Accessories and Finish
                            "></asp:Label>
                    </td>
                    <td class="auto-style4">
                        <asp:Label ID="AccessoriesLabel" runat="server"></asp:Label>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style8">
                        <asp:CheckBox ID="LeatherInteriorCheckBox" runat="server" GroupName="AccessoriesGroup" Text="Leather Interior" OnCheckedChanged="LeatherInteriorCheckBox_CheckedChanged" />
                    </td>
                    <td class="auto-style9">
                        <asp:Label ID="Label5" runat="server" Text="Subtotal"></asp:Label>
                    </td>
                    <td class="auto-style10">
                        <asp:Label ID="SubtotalLabel" runat="server"></asp:Label>
                    </td>
                    <td class="auto-style11"></td>
                </tr>
                <tr>
                    <td class="auto-style6">
                        <asp:CheckBox ID="ComputerNavigationCheckBox" runat="server" GroupName="AccessoriesGroup" Text="Computer Navigation" OnCheckedChanged="ComputerNavigationCheckBox_CheckedChanged" />
                    </td>
                    <td class="auto-style7">
                        <asp:Label ID="Label6" runat="server" Text="Sales Tax (8%)"></asp:Label>
                    </td>
                    <td class="auto-style4">
                        <asp:Label ID="SalesTaxLabel" runat="server"></asp:Label>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style2">
                        <strong>
                        <asp:Label ID="Label2" runat="server" Text="Finish"></asp:Label>
                        </strong>
                    </td>
                    <td class="auto-style7">
                        <asp:Label ID="Label7" runat="server" Text="Total"></asp:Label>
                    </td>
                    <td class="auto-style4">
                        <asp:Label ID="TotalLabel" runat="server"></asp:Label>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style2">
                        <asp:RadioButton ID="StandardRadioButton" GroupName="FinishGroup" runat="server" Text="Standard" OnCheckedChanged="StandardRadioButton_CheckedChanged" />
                        <asp:RadioButton ID="PearlizedRadioButton" GroupName="FinishGroup"  runat="server" Text="Pearlized" OnCheckedChanged="PearlizedRadioButton_CheckedChanged" />
                        <asp:RadioButton ID="CustomizedDetailingRadioButton" GroupName="FinishGroup"  runat="server" Text="Customized Detailing" OnCheckedChanged="CustomizedDetailingRadioButton_CheckedChanged" />
                    </td>
                    <td class="auto-style7">
                        <asp:Label ID="Label8" runat="server" Text="Trade in Allowance"></asp:Label>
                    </td>
                    <td class="auto-style4">
                        <asp:TextBox ID="TradeInAllowanceTextBox" placeholder="Enter any amount" runat="server" input type="text" class="form-control" ></asp:TextBox>
                    </td>
                    <td>
                        &nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style2">
                        &nbsp;</td>
                    <td class="auto-style7">
                        <strong>
                        <asp:Label ID="Label9" runat="server" Text="Amount Due"></asp:Label>
                        </strong>
                    </td>
                    <td class="auto-style4">
                        <asp:Label ID="AmountDueLabel" runat="server"></asp:Label>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style2">
                        &nbsp;</td>
                    <td class="auto-style5">
                        &nbsp;</td>
                    <td class="auto-style4">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style2">&nbsp;</td>
                    <td class="auto-style5">&nbsp;</td>
                    <td class="auto-style4">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="4">                      
                        <asp:Button ID="CalculateButton" runat="server" Text="Calculate" OnClick="CalculateButton_Click" type="button" class="btn btn-primary" />
                        <asp:Button ID="ClearButton" runat="server" Text="Clear" OnClick="ClearButton_Click" type="button" class="btn btn-primary" />
                        <asp:Button ID="ExitButton" runat="server" Text="Exit" OnClick="ExitButton_Click" type="button" class="btn btn-primary" />
                    </td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
