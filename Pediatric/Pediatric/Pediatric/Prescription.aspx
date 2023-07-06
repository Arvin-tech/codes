<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Prescription.aspx.cs" Inherits="Pediatric.Prescription" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 100%;
        }
        .auto-style3 {
            width: 205px;
        }
        .auto-style4 {
            width: 152px;
        }
        .auto-style6 {
            width: 483px;
        }
        .auto-style7 {
            width: 172px;
        }
        .auto-style8 {
            width: 483px;
            height: 23px;
            text-align: right;
        }
        .auto-style9 {
            width: 205px;
            height: 23px;
        }
        .auto-style10 {
            width: 152px;
            height: 23px;
        }
        .auto-style11 {
            width: 172px;
            height: 23px;
        }
        .auto-style12 {
            height: 23px;
        }
        .auto-style13 {
            width: 483px;
            height: 25px;
            text-align: right;
        }
        .auto-style14 {
            width: 205px;
            height: 25px;
        }
        .auto-style15 {
            width: 152px;
            height: 25px;
        }
        .auto-style16 {
            width: 172px;
            height: 25px;
        }
        .auto-style17 {
            height: 25px;
        }
        .auto-style19 {
            width: 483px;
            height: 26px;
            text-align: right;
        }
        .auto-style20 {
            width: 205px;
            height: 26px;
        }
        .auto-style21 {
            width: 152px;
            height: 26px;
        }
        .auto-style22 {
            width: 172px;
            height: 26px;
        }
        .auto-style23 {
            height: 26px;
        }
        .auto-style24 {
            width: 483px;
            text-align: right;
        }
        .auto-style25 {
            width: 152px;
            text-align: right;
        }
        .auto-style26 {
            width: 483px;
            height: 27px;
            text-align: right;
        }
        .auto-style27 {
            width: 205px;
            height: 27px;
        }
        .auto-style29 {
            width: 172px;
            height: 27px;
        }
        .auto-style30 {
            height: 27px;
        }
        .auto-style31 {
            width: 205px;
            text-align: center;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <table class="auto-style1">
                <tr>
                    <td class="auto-style6" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style31" style="font-family: 'Tw Cen MT Condensed'; font-size: x-large;"><strong>PRESCRIPTION</strong></td>
                    <td class="auto-style4" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style24" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style3" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style25" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style24" style="font-family: 'Tw Cen MT Condensed'"><strong>Prescription No.</strong></td>
                    <td class="auto-style3" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="PrescriptionNoTextBox" runat="server"></asp:TextBox>
                    </td>
                    <td class="auto-style25" style="font-family: 'Tw Cen MT Condensed'"><strong>Consultation No.</strong></td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="ConsultationNoTextBox" runat="server"></asp:TextBox>
                        </td>
                    <td style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style26" style="font-family: 'Tw Cen MT Condensed'"><strong>Patient Code</strong></td>
                    <td class="auto-style27" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="PatientCodeTextBox" runat="server"></asp:TextBox>
                    </td>
                    <td class="auto-style25" style="font-family: 'Tw Cen MT Condensed'"><strong>Date</strong></td>
                    <td class="auto-style29" style="font-family: 'Tw Cen MT Condensed'"><asp:TextBox ID="TextBox3" runat="server" TextMode="Date"></asp:TextBox>
                    </td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style30"></td>
                </tr>
                <tr>
                    <td class="auto-style24" style="font-family: 'Tw Cen MT Condensed'"><strong>Patient Name</strong></td>
                    <td class="auto-style3" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="PatientNameLabel" runat="server" Text=""></asp:Label>
                    </td>
                    <td class="auto-style4" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'"><strong>Address</strong></td>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="PatientAddressLabel" runat="server" Text=""></asp:Label>
                    </td>
                    <td class="auto-style10" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style12"></td>
                </tr>
                <tr>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'"><strong>Age</strong></td>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="AgeLabel" runat="server" Text=""></asp:Label>
                    </td>
                    <td class="auto-style10" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style12"></td>
                </tr>
                <tr>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td class="auto-style10" style="font-family: 'Tw Cen MT Condensed'">
                        </td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">
                        </td>
                    <td class="auto-style12" style="font-family: 'Tw Cen MT Condensed'"></td>
                </tr>
                <tr>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">
                        <strong>Medicine to Prescribe</strong></td>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td class="auto-style10" style="font-family: 'Tw Cen MT Condensed'">
                        </td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">
                        </td>
                    <td class="auto-style12" style="font-family: 'Tw Cen MT Condensed'"></td>
                </tr>
                <tr>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'"><strong>Medicine Code</strong></td>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="TextBox4" runat="server"></asp:TextBox>
                    </td>
                    <td class="auto-style10" style="font-family: 'Tw Cen MT Condensed'">
                        </td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">
                        </td>
                    <td class="auto-style12" style="font-family: 'Tw Cen MT Condensed'"></td>
                </tr>
                <tr>
                    <td class="auto-style13" style="font-family: 'Tw Cen MT Condensed'"><strong>Quantity</strong></td>
                    <td class="auto-style14" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="TextBox5" runat="server"></asp:TextBox>
                    </td>
                    <td class="auto-style15" style="font-family: 'Tw Cen MT Condensed'">
                        </td>
                    <td class="auto-style16" style="font-family: 'Tw Cen MT Condensed'">
                        </td>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'"></td>
                </tr>
                <tr>
                    <td class="auto-style19" style="font-family: 'Tw Cen MT Condensed'"><strong>Remarks</strong></td>
                    <td class="auto-style20" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="TextBox2" runat="server" Width="119px"></asp:TextBox>
                    </td>
                    <td class="auto-style21" style="font-family: 'Tw Cen MT Condensed'">
                        </td>
                    <td class="auto-style22" style="font-family: 'Tw Cen MT Condensed'">
                    </td>
                    <td class="auto-style23" style="font-family: 'Tw Cen MT Condensed'"></td>
                </tr>
                <tr>
                    <td colspan="5" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:GridView ID="GridView1" runat="server" Height="99px" Width="773px">
                        </asp:GridView>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style6" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style3" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style4" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style24" style="font-family: 'Tw Cen MT Condensed'"><strong>Prepared By</strong></td>
                    <td class="auto-style3" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Label ID="PreparedByLabel" runat="server" Text=""></asp:Label>
                    </td>
                    <td class="auto-style4" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style6" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style3" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style4" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Button ID="SaveButton" runat="server" Text="Save" OnClick="SaveButton_Click" />
                        <asp:Button ID="SearchButton" runat="server" Text="Search" OnClick="SearchButton_Click" />
                        <asp:Button ID="ClearButton" runat="server" Text="Clear" />
                    </td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
