<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Registration.aspx.cs" Inherits="Pediatric.Registration" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 100%;
        }
        .auto-style2 {
            width: 574px;
        }
        .auto-style3 {
            width: 176px;
        }
        .auto-style4 {
            width: 574px;
            text-align: right;
        }
        .auto-style8 {
            width: 574px;
            text-align: right;
            height: 27px;
        }
        .auto-style9 {
            width: 176px;
            height: 27px;
        }
        .auto-style10 {
            height: 27px;
        }
        .auto-style11 {
            width: 574px;
            text-align: right;
            height: 29px;
        }
        .auto-style12 {
            width: 176px;
            height: 29px;
        }
        .auto-style13 {
            height: 29px;
        }
        .auto-style14 {
            width: 574px;
            height: 21px;
        }
        .auto-style15 {
            width: 176px;
            height: 21px;
            text-align: center;
        }
        .auto-style16 {
            height: 21px;
        }
        .auto-style17 {
            width: 574px;
            text-align: right;
            height: 28px;
        }
        .auto-style18 {
            width: 176px;
            height: 28px;
        }
        .auto-style19 {
            height: 28px;
        }
    </style>
  
</head>
<body>
    
    <form id="form1" runat="server" autocomplete="off">
        <div>
            <table class="auto-style1">
                <tr>
                    <td class="auto-style14" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td class="auto-style15" style="font-family: 'Tw Cen MT Condensed'"><strong style="font-size: x-large">REGISTRATION</strong></td>
                    <td class="auto-style16" style="font-family: 'Tw Cen MT Condensed'"></td>
                </tr>
                <tr>
                    <td class="auto-style4" style="font-family: 'Tw Cen MT Condensed'"><strong>ID Number</strong></td>
                    <td class="auto-style3" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="UserCodeTxt" runat="server" class="form-control" Width="150px" Height="30px"></asp:TextBox>
                    </td>
                    <td style="font-family: 'Tw Cen MT Condensed'">
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator6" runat="server" ErrorMessage="ID Number required!" ForeColor="Red" ControlToValidate="UserCodeTxt"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'"><strong>Username</strong></td>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="UserNameTxt" runat="server" class="form-control" Width="150px" Height="30px"></asp:TextBox>
                    </td>
                    <td class="auto-style10" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="Username Required!" ForeColor="Red" ControlToValidate="UserNameTxt"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style17" style="font-family: 'Tw Cen MT Condensed'"><strong>Firstname</strong></td>
                    <td class="auto-style18" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="FirstNameTxt" runat="server" class="form-control" Width="150px" Height="30px"></asp:TextBox>
                    </td>
                    <td class="auto-style19" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="Firstname Required!" ForeColor="red" ControlToValidate="FirstNameTxt"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style4" style="font-family: 'Tw Cen MT Condensed'"><strong>Lastname</strong></td>
                    <td class="auto-style3" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="LastNameTxt" runat="server" class="form-control" Width="150px" Height="30px"></asp:TextBox>
                    </td>
                    <td style="font-family: 'Tw Cen MT Condensed'">
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" ErrorMessage="Lastname Required!" ForeColor="Red" ControlToValidate="LastNameTxt"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style4" style="font-family: 'Tw Cen MT Condensed'"><strong>&nbsp;Middlename</strong></td>
                    <td class="auto-style3" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="MiddleNameTxt" runat="server"  class="form-control" Width="150px" Height="30px"></asp:TextBox>
                    </td>
                    <td style="font-family: 'Tw Cen MT Condensed'">
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator8" runat="server" ErrorMessage="Middlename Required!" ForeColor="Red" ControlToValidate="MiddleNameTxt"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'"><strong>Position</strong></td>
                    <td class="auto-style12" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:DropDownList ID="PositionDropDownList" runat="server" Height="25px" Width="155px">
                            <asp:ListItem Value="0">Select</asp:ListItem>
                            <asp:ListItem Value="1">Admin</asp:ListItem>
                            <asp:ListItem Value="2">Doctor</asp:ListItem>
                            <asp:ListItem Value="3">Nurse</asp:ListItem>
                        </asp:DropDownList>
                        <asp:CompareValidator ID="CompareValidator2" runat="server"  ControlToValidate="PositionDropDownList" ErrorMessage="Please select a position" ForeColor="Red" Operator="NotEqual" ValueToCompare="0" Type="Integer" ></asp:CompareValidator>
                    </td>
                    <td class="auto-style13" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator7" runat="server" ControlToValidate="PositionDropDownList" ErrorMessage="Please select a position" ForeColor="Red"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style4" style="font-family: 'Tw Cen MT Condensed'"><strong>Password</strong></td>
                    <td class="auto-style3" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="PasswordTxt" runat="server" TextMode="Password" class="form-control" Width="150px" Height="30px"></asp:TextBox>
                    </td>
                    <td style="font-family: 'Tw Cen MT Condensed'">
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ErrorMessage="Password Required!" ForeColor="red" ControlToValidate="PasswordTxt"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style4" style="font-family: 'Tw Cen MT Condensed'"><strong>Confirm Password</strong></td>
                    <td class="auto-style3" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="ConfirmPassTxt" runat="server" TextMode="Password" class="form-control" Width="150px" Height="30px"></asp:TextBox>
                        <asp:CompareValidator ID="CompareValidator1" runat="server" ErrorMessage="Passwords must match!" ForeColor="Red" ControlToCompare="PasswordTxt" ControlToValidate="ConfirmPassTxt"></asp:CompareValidator>
                    </td>
                    <td style="font-family: 'Tw Cen MT Condensed'">
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" ErrorMessage="Confirm Password Required!" ForeColor="Red" ControlToValidate="ConfirmPassTxt"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style2" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style3" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Button ID="SubmitButton" runat="server" Text="Submit" OnClick="SubmitButton_Click" class="btn btn-primary" Height="33px" Width="82px"/>
                    </td>
                    <td style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style2" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style3" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:LinkButton ID="LinkButton1" runat="server" CausesValidation="False" OnClick="LinkButton1_Click">Go Back</asp:LinkButton>
                    </td>
                    <td style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="3" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
