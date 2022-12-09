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
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" inte8grity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
    <form id="form1" runat="server">
        <div>
            <table class="auto-style1">
                <tr>
                    <td class="auto-style14"></td>
                    <td class="auto-style15"><strong>USER REGISTRATION</strong></td>
                    <td class="auto-style16"></td>
                </tr>
                <tr>
                    <td class="auto-style4">Username</td>
                    <td class="auto-style3">
                        <asp:TextBox ID="UserIdTxt" runat="server" class="form-control" Width="150px" Height="30px"></asp:TextBox>
                    </td>
                    <td>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="Username Required!" ForeColor="Red" ControlToValidate="UserIdTxt"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style8">Firstname</td>
                    <td class="auto-style9">
                        <asp:TextBox ID="FirstNameTxt" runat="server" class="form-control" Width="150px" Height="30px"></asp:TextBox>
                    </td>
                    <td class="auto-style10">
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="Firstname Required!" ForeColor="red" ControlToValidate="FirstNameTxt"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style8">Lastname</td>
                    <td class="auto-style9">
                        <asp:TextBox ID="LastNameTxt" runat="server" class="form-control" Width="150px" Height="30px"></asp:TextBox>
                    </td>
                    <td class="auto-style10">
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" ErrorMessage="Lastname Required!" ForeColor="Red" ControlToValidate="LastNameTxt"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style4">Role</td>
                    <td class="auto-style3">
                        <asp:DropDownList ID="DropDownList1" runat="server" Height="25px" Width="155px">
                            <asp:ListItem>Select</asp:ListItem>
                            <asp:ListItem>Admin</asp:ListItem>
                            <asp:ListItem>Doctor</asp:ListItem>
                            <asp:ListItem>Nurse</asp:ListItem>
                        </asp:DropDownList>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style4">&nbsp;Password</td>
                    <td class="auto-style3">
                        <asp:TextBox ID="PasswordTxt" runat="server" TextMode="Password" class="form-control" Width="150px" Height="30px"></asp:TextBox>
                    </td>
                    <td>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ErrorMessage="Password Required!" ForeColor="red" ControlToValidate="PasswordTxt"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style11">Confirm Password</td>
                    <td class="auto-style12">
                        <asp:TextBox ID="ConfirmPassTxt" runat="server" TextMode="Password" class="form-control" Width="150px" Height="30px"></asp:TextBox>
                        <asp:CompareValidator ID="CompareValidator1" runat="server" ErrorMessage="Passwords must match!" ForeColor="Red" ControlToCompare="PasswordTxt" ControlToValidate="ConfirmPassTxt"></asp:CompareValidator>
                    </td>
                    <td class="auto-style13">
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" ErrorMessage="Confirm Password Required!" ForeColor="Red" ControlToValidate="ConfirmPassTxt"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style2">&nbsp;</td>
                    <td class="auto-style3">
                        <asp:Button ID="SubmitButton" runat="server" Text="Submit" OnClick="SubmitButton_Click" class="btn btn-primary" Height="33px" Width="82px"/>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="3">
                        &nbsp;</td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
