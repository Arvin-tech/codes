<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Billing.aspx.cs" Inherits="Pediatric.Billing" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 100%;
        }
        .auto-style5 {
            width: 77px;
            text-align: center;
            height: 25px;
        }
        .auto-style6 {
            text-align: center;
            height: 25px;
            width: 396px;
        }
        .auto-style9 {
            width: 115px;
            text-align: left;
        }
        .auto-style10 {
            width: 60px;
            text-align: right;
        }
        .auto-style11 {
            margin-left: 0px;
        }
        .auto-style12 {
            width: 115px;
        }
        .auto-style14 {
            width: 115px;
            height: 25px;
        }
        .auto-style15 {
            width: 60px;
            height: 25px;
        }
        .auto-style16 {
            height: 25px;
        }
        .auto-style17 {
            width: 396px;
        }
        .auto-style18 {
            width: 77px;
        }
        .auto-style19 {
            width: 60px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <table class="auto-style1">
                <tr>
                    <td class="auto-style14"></td>
                    <td class="auto-style6">&nbsp;</td>
                    <td class="auto-style5">&nbsp;</td>
                    <td class="auto-style15"></td>
                    <td class="auto-style16"></td>
                </tr>
                <tr>
                    <td class="auto-style9">Billing No.</td>
                    <td class="auto-style17">
                        <asp:TextBox ID="BillingNoTextBox" runat="server" Width="62px"></asp:TextBox>
                    </td>
                    <td class="auto-style18">Date</td>
                    <td class="auto-style10">
                        <asp:TextBox ID="DateTextBox" runat="server" Width="89px" TextMode="Date"></asp:TextBox>
                    </td>
                    <td>
                        &nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9">Patient Code</td>
                    <td class="auto-style17">
                        <asp:TextBox ID="PatientCodeTextBox" runat="server" Width="60px"></asp:TextBox>
                    </td>
                    <td class="auto-style18">&nbsp;</td>
                    <td class="auto-style19">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9">Patient Name</td>
                    <td class="auto-style17">
                        <asp:Label ID="PatientNameLabel" runat="server" Text=""></asp:Label>
                    </td>
                    <td class="auto-style18">&nbsp;</td>
                    <td class="auto-style19">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9">Age</td>
                    <td class="auto-style17">
                        <asp:Label ID="AgeLabel" runat="server" Text=""></asp:Label>
                    </td>
                    <td class="auto-style18">&nbsp;</td>
                    <td class="auto-style19">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style12">Service Type</td>
                    <td class="auto-style17">&nbsp;</td>
                    <td class="auto-style18">&nbsp;</td>
                    <td class="auto-style19">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style12">
                        <asp:CheckBox ID="ConsultationCheckBox" runat="server" GroupName="ServiceType"  Text="Consultation" />
                    </td>
                    <td class="auto-style17">
                        <asp:CheckBox ID="ImmunizationCheckBox" runat="server" GroupName="ServiceType" Text="Immunization" />
                    </td>
                    <td class="auto-style18">&nbsp;</td>
                    <td class="auto-style19">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style12">Immunization No.</td>
                    <td class="auto-style17">
                        <asp:TextBox ID="ImmunizationNoTextBox" runat="server"></asp:TextBox>
                    </td>
                    <td class="auto-style18">&nbsp;</td>
                    <td class="auto-style19">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style12">&nbsp;</td>
                    <td class="auto-style17">
                        <asp:GridView ID="GridView1" runat="server" CssClass="auto-style11" Height="83px" Width="434px">
                        </asp:GridView>
                    </td>
                    <td class="auto-style18">&nbsp;</td>
                    <td class="auto-style19">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style12">Prepared By</td>
                    <td class="auto-style17">
                        <asp:Label ID="PreparedByLabel" runat="server" Text=""></asp:Label>
                    </td>
                    <td class="auto-style18">Total Amount</td>
                    <td class="auto-style19">
                        <asp:Label ID="TotalAmountLabel" runat="server" Text=""></asp:Label>
                    </td>
                    <td>
                        &nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style12">&nbsp;</td>
                    <td class="auto-style17">
                        &nbsp;</td>
                    <td class="auto-style18">
                        <asp:Button ID="SaveButton" runat="server" Text="Save" OnClick="SaveButton_Click" />
                    </td>
                    <td class="auto-style19">
                        <asp:Button ID="ClearButton" runat="server" Text="Clear" OnClick="ClearButton_Click" />
                    </td>
                    <td>
                        &nbsp;</td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
