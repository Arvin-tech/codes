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
            width: 262px;
        }
        .auto-style3 {
            width: 240px;
        }
        .auto-style4 {
            width: 262px;
            text-align: right;
        }
        .auto-style8 {
            width: 262px;
            text-align: right;
            height: 27px;
        }
        .auto-style9 {
            width: 240px;
            height: 27px;
        }
        .auto-style10 {
            height: 27px;
        }
        .auto-style11 {
            width: 262px;
            text-align: right;
            height: 29px;
        }
        .auto-style12 {
            width: 240px;
            height: 29px;
        }
        .auto-style13 {
            height: 29px;
        }
        .auto-style14 {
            width: 262px;
            height: 21px;
        }
        .auto-style15 {
            width: 240px;
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
                    <td class="auto-style4">User ID</td>
                    <td class="auto-style3">
                        <asp:TextBox ID="UserIdTxt" runat="server" class="form-control" Width="150px" Height="30px"></asp:TextBox>
                    </td>
                    <td>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="Field Required!" ForeColor="Red" ControlToValidate="UserIdTxt"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style8">User Name</td>
                    <td class="auto-style9">
                        <asp:TextBox ID="UserNameTxt" runat="server" class="form-control" Width="150px" Height="30px"></asp:TextBox>
                    </td>
                    <td class="auto-style10">
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="Field Required!" ForeColor="red" ControlToValidate="UserNameTxt"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style4">Role</td>
                    <td class="auto-style3">
                        <asp:RadioButton ID="AdminRB" runat="server" text="Admin" GroupName="RolesGroup" />
                        <asp:RadioButton ID="DoctorRB" runat="server" Text="Doctor" GroupName="RolesGroup" />
                        <asp:RadioButton ID="NurseRB" runat="server" text="Nurse" GroupName="RolesGroup" />
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style4">&nbsp;Password</td>
                    <td class="auto-style3">
                        <asp:TextBox ID="PasswordTxt" runat="server" TextMode="Password" class="form-control" Width="150px" Height="30px"></asp:TextBox>
                    </td>
                    <td>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ErrorMessage="Field Required!" ForeColor="red" ControlToValidate="PasswordTxt"></asp:RequiredFieldValidator>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style11">Confirm Password</td>
                    <td class="auto-style12">
                        <asp:TextBox ID="ConfirmPassTxt" runat="server" TextMode="Password" class="form-control" Width="150px" Height="30px"></asp:TextBox>
                        <asp:CompareValidator ID="CompareValidator1" runat="server" ErrorMessage="Passwords must match!" ForeColor="Red" ControlToCompare="PasswordTxt" ControlToValidate="ConfirmPassTxt"></asp:CompareValidator>
                    </td>
                    <td class="auto-style13">
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" ErrorMessage="Field Required!" ForeColor="Red" ControlToValidate="ConfirmPassTxt"></asp:RequiredFieldValidator>
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
                        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataKeyNames="USERID" DataSourceID="SqlDataSource1" Width="792px" BackColor="LightGoldenrodYellow" BorderColor="Tan" BorderWidth="1px" CellPadding="2" ForeColor="Black" GridLines="None">
                            <AlternatingRowStyle BackColor="PaleGoldenrod" />
                            <Columns>
                                <asp:CommandField ShowDeleteButton="True" />
                                <asp:BoundField DataField="USERID" HeaderText="USERID" ReadOnly="True" SortExpression="USERID" />
                                <asp:BoundField DataField="USERNAME" HeaderText="USERNAME" SortExpression="USERNAME" />
                                <asp:BoundField DataField="USERPASSWORD" HeaderText="USERPASSWORD" SortExpression="USERPASSWORD" />
                                <asp:BoundField DataField="USERROLE" HeaderText="USERROLE" SortExpression="USERROLE" />
                            </Columns>
                            <FooterStyle BackColor="Tan" />
                            <HeaderStyle BackColor="Tan" Font-Bold="True" />
                            <PagerStyle BackColor="PaleGoldenrod" ForeColor="DarkSlateBlue" HorizontalAlign="Center" />
                            <SelectedRowStyle BackColor="DarkSlateBlue" ForeColor="GhostWhite" />
                            <SortedAscendingCellStyle BackColor="#FAFAE7" />
                            <SortedAscendingHeaderStyle BackColor="#DAC09E" />
                            <SortedDescendingCellStyle BackColor="#E1DB9C" />
                            <SortedDescendingHeaderStyle BackColor="#C2A47B" />
                        </asp:GridView>
                        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConflictDetection="CompareAllValues" ConnectionString="<%$ ConnectionStrings:ELDNETConnectionString %>" DeleteCommand="DELETE FROM [USERS] WHERE [USERID] = @original_USERID AND (([USERNAME] = @original_USERNAME) OR ([USERNAME] IS NULL AND @original_USERNAME IS NULL)) AND (([USERPASSWORD] = @original_USERPASSWORD) OR ([USERPASSWORD] IS NULL AND @original_USERPASSWORD IS NULL)) AND (([USERROLE] = @original_USERROLE) OR ([USERROLE] IS NULL AND @original_USERROLE IS NULL))" InsertCommand="INSERT INTO [USERS] ([USERID], [USERNAME], [USERPASSWORD], [USERROLE]) VALUES (@USERID, @USERNAME, @USERPASSWORD, @USERROLE)" OldValuesParameterFormatString="original_{0}" SelectCommand="SELECT * FROM [USERS]" UpdateCommand="UPDATE [USERS] SET [USERNAME] = @USERNAME, [USERPASSWORD] = @USERPASSWORD, [USERROLE] = @USERROLE WHERE [USERID] = @original_USERID AND (([USERNAME] = @original_USERNAME) OR ([USERNAME] IS NULL AND @original_USERNAME IS NULL)) AND (([USERPASSWORD] = @original_USERPASSWORD) OR ([USERPASSWORD] IS NULL AND @original_USERPASSWORD IS NULL)) AND (([USERROLE] = @original_USERROLE) OR ([USERROLE] IS NULL AND @original_USERROLE IS NULL))">
                            <DeleteParameters>
                                <asp:Parameter Name="original_USERID" Type="String" />
                                <asp:Parameter Name="original_USERNAME" Type="String" />
                                <asp:Parameter Name="original_USERPASSWORD" Type="String" />
                                <asp:Parameter Name="original_USERROLE" Type="String" />
                            </DeleteParameters>
                            <InsertParameters>
                                <asp:Parameter Name="USERID" Type="String" />
                                <asp:Parameter Name="USERNAME" Type="String" />
                                <asp:Parameter Name="USERPASSWORD" Type="String" />
                                <asp:Parameter Name="USERROLE" Type="String" />
                            </InsertParameters>
                            <UpdateParameters>
                                <asp:Parameter Name="USERNAME" Type="String" />
                                <asp:Parameter Name="USERPASSWORD" Type="String" />
                                <asp:Parameter Name="USERROLE" Type="String" />
                                <asp:Parameter Name="original_USERID" Type="String" />
                                <asp:Parameter Name="original_USERNAME" Type="String" />
                                <asp:Parameter Name="original_USERPASSWORD" Type="String" />
                                <asp:Parameter Name="original_USERROLE" Type="String" />
                            </UpdateParameters>
                        </asp:SqlDataSource>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
