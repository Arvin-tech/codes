<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="Pediatric.Home" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 100%;
        }
        .auto-style2 {
            width: 164px;
        }
        .auto-style3 {
            width: 164px;
            height: 23px;
        }
        .auto-style4 {
            height: 23px;
        }
        .auto-style5 {
            width: 627px;
        }
        .auto-style6 {
            height: 23px;
            width: 627px;
        }
        .auto-style7 {
            width: 100px;
        }
        .auto-style8 {
            width: 100px;
            height: 23px;
        }
        .auto-style9 {
            width: 627px;
            text-align: right;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <table class="auto-style1">
                <tr>
                    <td class="auto-style2" style="font-family: &quot;Tw Cen MT Condensed&quot;"><strong style="font-size: x-large">Menu</strong></td>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'"><strong>Logged in as:</strong></td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="PreparedByLabel" runat="server" Text=""></asp:Label>
                    </td>
                    <td style="font-family: 'Tw Cen MT Condensed'">
                        <asp:LinkButton ID="LogoutLinkButton" runat="server" OnClick="LogoutLinkButton_Click">Logout</asp:LinkButton>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style2" style="font-family: &quot;Tw Cen MT Condensed&quot;">
                        <asp:LinkButton ID="PatientLinkButton" runat="server" OnClick="PatientLinkButton_Click">Patient Registration</asp:LinkButton>
                    </td>
                    <td class="auto-style5">&nbsp;</td>
                    <td class="auto-style7">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style2" style="font-family: &quot;Tw Cen MT Condensed&quot;">
                        <asp:LinkButton ID="BillingLinkButton" runat="server" OnClick="BillingLinkButton_Click">Billing</asp:LinkButton>
                    </td>
                    <td class="auto-style5">&nbsp;</td>
                    <td class="auto-style7">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style3" style="font-family: &quot;Tw Cen MT Condensed&quot;">
                        <asp:LinkButton ID="ImmunizationLinkButton" runat="server" OnClick="LinkButton3_Click">Immunization</asp:LinkButton>
                    </td>
                    <td class="auto-style6"></td>
                    <td class="auto-style8">&nbsp;</td>
                    <td class="auto-style4"></td>
                </tr>
                <tr>
                    <td class="auto-style3" style="font-family: &quot;Tw Cen MT Condensed&quot;">
                        <asp:LinkButton ID="PrescriptionLinkButton" runat="server" OnClick="PrescriptionLinkButton_Click">Prescription</asp:LinkButton>
                    </td>
                    <td class="auto-style6"></td>
                    <td class="auto-style8">&nbsp;</td>
                    <td class="auto-style4"></td>
                </tr>
                <tr>
                    <td class="auto-style2" style="font-family: &quot;Tw Cen MT Condensed&quot;">
                        &nbsp;</td>
                    <td class="auto-style5">&nbsp;</td>
                    <td class="auto-style7">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style2">
                        &nbsp;</td>
                    <td class="auto-style5">&nbsp;</td>
                    <td class="auto-style7">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
