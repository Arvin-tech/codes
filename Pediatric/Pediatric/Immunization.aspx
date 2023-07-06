<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Immunization.aspx.cs" Inherits="Pediatric.Immunization" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 100%;
        }
        .auto-style7 {
            width: 37px;
        }
        .auto-style8 {
            width: 42px;
        }
        .auto-style11 {
            width: 132px;
        }
        .auto-style12 {
            width: 198px;
            text-align: right;
        }
        .auto-style14 {
            width: 393px;
        }
        .auto-style15 {
            width: 393px;
            text-align: right;
        }
        .auto-style17 {
            width: 185px;
        }
        .auto-style18 {
            text-align: center;
        }  

        .auto-style20 {
            width: 87px;
            text-align: right;
        }
        .auto-style21 {
            width: 87px;
        }
        .auto-style22 {
            width: 393px;
            text-align: right;
            text-decoration: underline;
        }
        .auto-style23 {
            width: 198px;
        }

    </style>
</head>
<body>
    <form id="form1" runat="server" autocomplete="off">
        <div>
            <table class="auto-style1">
                <tr>
                    <td class="auto-style14" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'"><strong style="font-size: x-large">IMMUNIZATION FORM</strong></td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:LinkButton ID="HomeLinkButton" runat="server" CausesValidation="False" OnClick="HomeLinkButton_Click">Home</asp:LinkButton>
                    </td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:LinkButton ID="LogoutLinkButton" runat="server" CausesValidation="False" OnClick="LogoutLinkButton_Click">Logout</asp:LinkButton>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style15" style="font-family: 'Tw Cen MT Condensed'">Immunization No.&nbsp;</td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="ImmunizationNoTextBox" runat="server" Width="85px" PlaceHolder="IMM00"></asp:TextBox>
                        <asp:Button ID="SearchImmunizationButton" runat="server" Text="Search" OnClick="SearchImmunizationButton_Click" />
                    </td>
                    <td class="auto-style12" style="font-family: 'Tw Cen MT Condensed'">Date&nbsp;</td>
                    <td class="auto-style20" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="DateTextBox" runat="server" Width="85px" TextMode="Date"></asp:TextBox>
                    </td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style22" style="font-family: 'Tw Cen MT Condensed'"><strong>Patient Information</strong></td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style12" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style15" style="font-family: 'Tw Cen MT Condensed'">Patient Code</td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="PatientCodeTextBox" runat="server" Width="85px" PlaceHolder="PAT00"></asp:TextBox>
                        <asp:Button ID="SearchPatientButton" runat="server" Text="Search" OnClick="SearchPatientButton_Click" CausesValidation="False" />
                        <asp:RequiredFieldValidator ID="PatientRequiredFieldValidator" runat="server" ErrorMessage="Patient Code Required" ForeColor="Red" ControlToValidate="PatientCodeTextBox"></asp:RequiredFieldValidator>
                    </td>
                    <td class="auto-style12" style="font-family: 'Tw Cen MT Condensed'">Weight(kg)</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="WeightTextBox" runat="server" Width="85px"></asp:TextBox>
                    </td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style15" style="font-family: 'Tw Cen MT Condensed'">Patient Name</td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="NameLabel" runat="server" BackColor="#FFCC99"></asp:Label>
                    </td>
                    <td class="auto-style12" style="font-family: 'Tw Cen MT Condensed'">Height(cm)</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="HeightTextBox" runat="server" Width="85px"></asp:TextBox>
                    </td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style15" style="font-family: 'Tw Cen MT Condensed'">Address</td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="AddressLabel" runat="server" BackColor="#FFCC99"></asp:Label>
                    </td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style15" style="font-family: 'Tw Cen MT Condensed'">Telephone</td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="TelephoneLabel" runat="server" BackColor="#FFCC99"></asp:Label>
                    </td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style15" style="font-family: 'Tw Cen MT Condensed'">Father&#39;s Name</td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="FathersNameLabel" runat="server" BackColor="#FFCC99"></asp:Label>
                    </td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style15" style="font-family: 'Tw Cen MT Condensed'">Mother&#39;s Name</td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="MothersNameLabel" runat="server" BackColor="#FFCC99"></asp:Label>
                    </td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style15" style="font-family: 'Tw Cen MT Condensed'">Gender</td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="GenderLabel" runat="server" BackColor="#FFCC99"></asp:Label>
                    </td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style15" style="font-family: 'Tw Cen MT Condensed'">Birthday</td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="BirthdayLabel" runat="server" BackColor="#FFCC99"></asp:Label>
                    </td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style15" style="font-family: 'Tw Cen MT Condensed'">Age</td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="AgeLabel" runat="server" BackColor="#FFCC99"></asp:Label>
                    </td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style22" style="font-family: 'Tw Cen MT Condensed'"><strong>Vaccine Information</strong></td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style15" style="font-family: 'Tw Cen MT Condensed'">Vaccine Code</td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="VaccineCodeTextBox" runat="server" Width="85px" PlaceHolder="VAX00"></asp:TextBox>
                        <asp:Button ID="SearchVaccineButton" runat="server" Text="Search" OnClick="SearchVaccineButton_Click" CausesValidation="False" />
                        <asp:RequiredFieldValidator ID="VaccineRequiredFieldValidator" runat="server" ErrorMessage="Vaccine Code Required" ForeColor="Red" ControlToValidate="VaccineCodeTextBox"></asp:RequiredFieldValidator>
                    </td>
                    <td class="auto-style12" style="font-family: 'Tw Cen MT Condensed'">Dose</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="DoseTextBox" runat="server" Width="85px"></asp:TextBox>
                    </td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style15" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" colspan="6" class="auto-style18">
                        <asp:GridView ID="GridView1" runat="server" ShowHeaderWhenEmpty="true" EmptyDataText="<span style='color: red;'>VACCINE NOT FOUND!</span>" Width="551px">
                        </asp:GridView>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style15" style="font-family: 'Tw Cen MT Condensed'"><strong>Prepared By</strong></td>
                    <td style="font-family: 'Tw Cen MT Condensed'" colspan="6">
                        <asp:Label ID="PreparedByLabel" runat="server" Text=""></asp:Label>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style15" style="font-family: 'Tw Cen MT Condensed'"><strong>Immunized By</strong></td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="ImmunizedByLabel" runat="server" Text=""></asp:Label>
                    </td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style15" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Button ID="SaveButton" runat="server" Text="Save" OnClick="SaveButton_Click" />
                        <asp:Button ID="ClearButton" runat="server" Text="Clear" OnClick="ClearButton_Click" CausesValidation="False" />
                    </td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
