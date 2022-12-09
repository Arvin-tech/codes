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
            width: 207px;
        }
        .auto-style7 {
            width: 172px;
        }
        .auto-style8 {
            width: 207px;
            height: 23px;
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
            width: 207px;
            height: 25px;
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
            width: 207px;
            height: 26px;
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
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <table class="auto-style1">
                <tr>
                    <td class="auto-style6">&nbsp;</td>
                    <td class="auto-style3">&nbsp;</td>
                    <td class="auto-style4">&nbsp;</td>
                    <td class="auto-style7">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style6">Prescription No.</td>
                    <td class="auto-style3">
                        <asp:TextBox ID="PrescriptionNoTextBox" runat="server"></asp:TextBox>
                    </td>
                    <td class="auto-style4">Consultation No.</td>
                    <td class="auto-style7">
                        <asp:TextBox ID="ConsultationNoTextBox" runat="server"></asp:TextBox>
                        &nbsp;</td>
                    <td>
                        Date<asp:TextBox ID="TextBox3" runat="server"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style6">&nbsp;</td>
                    <td class="auto-style3">&nbsp;</td>
                    <td class="auto-style4">&nbsp;</td>
                    <td class="auto-style7">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style6">Patient Code</td>
                    <td class="auto-style3">
                        <asp:TextBox ID="PatientCodeTextBox" runat="server"></asp:TextBox>
                    </td>
                    <td class="auto-style4">&nbsp;</td>
                    <td class="auto-style7">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style6">Patient Name</td>
                    <td class="auto-style3">
                        <asp:Label ID="PatientNameLabel" runat="server" Text=""></asp:Label>
                    </td>
                    <td class="auto-style4">&nbsp;</td>
                    <td class="auto-style7">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style6">Address</td>
                    <td class="auto-style3">
                        <asp:Label ID="PatientAddressLabel" runat="server" Text=""></asp:Label>
                    </td>
                    <td class="auto-style4">&nbsp;</td>
                    <td class="auto-style7">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style6">Age</td>
                    <td class="auto-style3">
                        <asp:Label ID="AgeLabel" runat="server" Text=""></asp:Label>
                    </td>
                    <td class="auto-style4">&nbsp;</td>
                    <td class="auto-style7">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style8"></td>
                    <td class="auto-style9"></td>
                    <td class="auto-style10">
                        </td>
                    <td class="auto-style11">
                        </td>
                    <td class="auto-style12"></td>
                </tr>
                <tr>
                    <td class="auto-style8">
                        Medicine to Prescribe</td>
                    <td class="auto-style9"></td>
                    <td class="auto-style10">
                        </td>
                    <td class="auto-style11">
                        </td>
                    <td class="auto-style12"></td>
                </tr>
                <tr>
                    <td class="auto-style8">Medicine Code</td>
                    <td class="auto-style9">
                        <asp:TextBox ID="TextBox4" runat="server"></asp:TextBox>
                    </td>
                    <td class="auto-style10">
                        </td>
                    <td class="auto-style11">
                        </td>
                    <td class="auto-style12"></td>
                </tr>
                <tr>
                    <td class="auto-style13">Quantity</td>
                    <td class="auto-style14">
                        <asp:TextBox ID="TextBox5" runat="server"></asp:TextBox>
                    </td>
                    <td class="auto-style15">
                        </td>
                    <td class="auto-style16">
                        </td>
                    <td class="auto-style17"></td>
                </tr>
                <tr>
                    <td class="auto-style19">Remarks</td>
                    <td class="auto-style20">
                        <asp:TextBox ID="TextBox2" runat="server" Width="209px"></asp:TextBox>
                    </td>
                    <td class="auto-style21">
                        </td>
                    <td class="auto-style22">
                    </td>
                    <td class="auto-style23"></td>
                </tr>
                <tr>
                    <td colspan="5">
                        <asp:GridView ID="GridView1" runat="server" Height="99px" Width="773px">
                        </asp:GridView>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style6">&nbsp;</td>
                    <td class="auto-style3">&nbsp;</td>
                    <td class="auto-style4">
                        &nbsp;</td>
                    <td class="auto-style7">
                        &nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style6">Prepared By</td>
                    <td class="auto-style3">
                        <asp:TextBox ID="TextBox6" runat="server"></asp:TextBox>
                    </td>
                    <td class="auto-style4">
                        <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
                    </td>
                    <td class="auto-style7">
                        &nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style6">&nbsp;</td>
                    <td class="auto-style3">&nbsp;</td>
                    <td class="auto-style4">
                        <asp:Button ID="SaveButton" runat="server" Text="Save" OnClick="SaveButton_Click" />
                        <asp:Button ID="SearchButton" runat="server" Text="Search" OnClick="SearchButton_Click" />
                        <asp:Button ID="ClearButton" runat="server" Text="Clear" />
                    </td>
                    <td class="auto-style7">
                        &nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
