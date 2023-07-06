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
            width: 273px;
            text-align: center;
            height: 25px;
        }
        .auto-style6 {
            text-align: center;
            height: 25px;
            width: 547px;
        }
        .auto-style9 {
            width: 569px;
            text-align: right;
        }
        .auto-style10 {
            width: 213px;
            text-align: right;
        }
        .auto-style12 {
            width: 569px;
        }
        .auto-style14 {
            width: 569px;
            height: 25px;
        }
        .auto-style17 {
            width: 547px;
        }
        .auto-style20 {
            width: 79px;
            height: 25px;
        }
        .auto-style21 {
            width: 79px;
        }
        .auto-style22 {
            width: 213px;
            height: 25px;
            text-align: right;
        }
        .auto-style23 {
            width: 213px;
        }
        .auto-style24 {
            width: 273px;
        }
        .auto-style25 {
            width: 569px;
            text-align: right;
            height: 23px;
        }
        .auto-style26 {
            width: 547px;
            height: 23px;
        }
        .auto-style27 {
            width: 273px;
            height: 23px;
        }
        .auto-style28 {
            width: 213px;
            height: 23px;
        }
        .auto-style29 {
            width: 79px;
            height: 23px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server" autocomplete="off">
        <div>
            <table class="auto-style1">
                <tr>
                    <td class="auto-style14" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td class="auto-style6" style="font-family: 'Tw Cen MT Condensed'"><strong style="font-size: x-large">BILLING FORM</strong></td>
                    <td class="auto-style5" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style22" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:LinkButton ID="HomeLinkButton" runat="server" CausesValidation="False" OnClick="HomeLinkButton_Click">Home</asp:LinkButton>
                    </td>
                    <td class="auto-style20" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:LinkButton ID="LogoutLinkButton" runat="server" OnClick="LogoutLinkButton_Click">Logout</asp:LinkButton>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'"><strong>Billing No.</strong></td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="BillingNoTextBox" runat="server" Width="62px" Placeholder="BIL00"></asp:TextBox>
                        <asp:Button ID="SearchBillingButton" runat="server" Text="Search bill" OnClick="SearchBillingButton_Click" />
                    </td>
                    <td class="auto-style24" style="font-family: 'Tw Cen MT Condensed'"><strong>Date</strong><asp:TextBox ID="DateTextBox" runat="server" Width="89px"  TextMode="Date"></asp:TextBox>
                    </td>
                    <td class="auto-style10" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'"><strong>Patient Code</strong></td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="PatientCodeTextBox" runat="server" Width="60px" Placeholder="PAT00"></asp:TextBox>
                        <asp:Button ID="SearchPatientButton" runat="server" Text="Search patient" Width="96px" OnClick="SearchPatientButton_Click" />
                    </td>
                    <td class="auto-style24" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style25" style="font-family: 'Tw Cen MT Condensed'"><strong>Firstname</strong></td>
                    <td class="auto-style26" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="FirstNameLabel" runat="server" BackColor="#FFCC99"></asp:Label>
                    </td>
                    <td class="auto-style27" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td class="auto-style28" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td class="auto-style29" style="font-family: 'Tw Cen MT Condensed'"></td>
                </tr>
                <tr>
                    <td class="auto-style25" style="font-family: 'Tw Cen MT Condensed'"><strong>Middlename</strong></td>
                    <td class="auto-style26" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="MiddleNameLabel" runat="server" BackColor="#FFCC99"></asp:Label>
                    </td>
                    <td class="auto-style27" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style28" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style29" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'"><strong>Lastname</strong></td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="LastNameLabel" runat="server" BackColor="#FFCC99"></asp:Label>
                    </td>
                    <td class="auto-style24" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'"><strong>Age</strong></td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="AgeLabel" runat="server" BackColor="#FFCC99"></asp:Label>
                    </td>
                    <td class="auto-style24" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'">
                        <strong>Service Type</strong></td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:CheckBox ID="ConsultationCheckBox" runat="server" GroupName="ServiceType"  Text="Consultation" />
                        <asp:CheckBox ID="ImmunizationCheckBox" runat="server" GroupName="ServiceType" Text="Immunization" />
                    </td>
                    <td class="auto-style24" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'"><strong>Immunization No.</strong></td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="ImmunizationNoTextBox" runat="server" Width="79px" Placeholder="IMM00"></asp:TextBox>
                    </td>
                    <td class="auto-style24" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style12" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style24" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'"><strong>Prepared By</strong></td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="PreparedByLabel" runat="server" Text=""></asp:Label>
                    </td>
                    <td class="auto-style24" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'"><strong>Total Amount</strong></td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="TotalAmountLabel" runat="server" Text=""></asp:Label>
                    </td>
                    <td class="auto-style24" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Button ID="SaveButton" runat="server" Text="Save" OnClick="SaveButton_Click" />
                        <asp:Button ID="ClearButton" runat="server" Text="Clear" OnClick="ClearButton_Click" />
                    </td>
                    <td class="auto-style24" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
