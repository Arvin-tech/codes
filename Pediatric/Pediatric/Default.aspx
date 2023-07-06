<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="Pediatric.Login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 100%;
        }
        .auto-style2 {
            width: 172px;
        }
        .auto-style4 {
            width: 575px;
            text-align: right;
        }
        .auto-style5 {
            width: 172px;
            text-align: center;
        }
        .auto-style6 {
            width: 575px;
            height: 34px;
        }
        .auto-style7 {
            width: 172px;
            height: 34px;
        }
        .auto-style8 {
            height: 34px;
        }
        .auto-style9 {
            width: 575px;
            text-align: right;
            height: 26px;
        }
        .auto-style10 {
            width: 172px;
            height: 26px;
        }
        .auto-style11 {
            height: 26px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server" autocomplete="off">
        <div>
            <table class="auto-style1" >
                <tr>
                    <td class="auto-style4" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style5" style="font-family: 'Tw Cen MT Condensed'">
                        <strong style="font-size: x-large">LOGIN</strong></td>
                    <td style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'"><strong>Username</strong></td>
                    <td class="auto-style10" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="UsernameTxt" runat="server"></asp:TextBox>
                    </td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style11">
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="Username required!" ForeColor="Red" ControlToValidate="UsernameTxt"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style4" style="font-family: 'Tw Cen MT Condensed'"><strong>Password</strong></td>
                    <td class="auto-style2" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="PasswordTxt" runat="server" TextMode="Password"></asp:TextBox>
                        <asp:Label ID="ErrorLabel" runat="server" ForeColor="Red" Text="Wrong credentials!"></asp:Label>
                    </td>
                    <td style="font-family: 'Tw Cen MT Condensed'">
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="Password Required!" ForeColor="Red" ControlToValidate="PasswordTxt"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style6" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:Button ID="LoginButton" runat="server" Text="Login" OnClick="LoginButton_Click" />
                    </td>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">
                        </td>
                </tr>
                <tr>
                    <td class="auto-style6" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style7" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:LinkButton ID="SignUpLinkButton" runat="server" CausesValidation="False" OnClick="SignUpLinkButton_Click">Dont have an account? Click Here!</asp:LinkButton>
                    </td>
                    <td class="auto-style8" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
