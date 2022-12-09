<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="PatientForm.aspx.cs" Inherits="Pediatric.PatientForm" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 100%;
        }
        .auto-style2 {
            height: 24px;
        }
        .auto-style5 {
            height: 24px;
            width: 171px;
        }
        .auto-style6 {
            width: 171px;
        }
        .auto-style7 {
            margin-bottom: 0px;
        }
        .auto-style8 {
            height: 24px;
            width: 181px;
        }
        .auto-style9 {
            width: 181px;
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
                    <td class="auto-style8"></td>
                    <td class="auto-style5"></td>
                    <td class="auto-style2"></td>
                </tr>
                <tr>
                    <td class="auto-style9">Patient Code</td>
                    <td class="auto-style6">
                        <asp:TextBox ID="PatientCodeTextBox" runat="server" input type="text" class="form-control" Height="24px"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="PatientCodeTextBox" ErrorMessage="Patient Code Required!" ForeColor="Red"></asp:RequiredFieldValidator>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9">Patient Name</td>
                    <td class="auto-style6">
                        <asp:TextBox ID="PatientNameTextBox" runat="server" input type="text" class="form-control" Height="24px"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="PatientNameTextBox" ErrorMessage="Name Required!" ForeColor="Red"></asp:RequiredFieldValidator>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9">Patient Age</td>
                    <td class="auto-style6">
                        <asp:TextBox ID="PatientAgeTextBox" runat="server" input type="text" class="form-control" Height="24px"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ControlToValidate="PatientAgeTextBox" ErrorMessage="Age Required!" ForeColor="Red"></asp:RequiredFieldValidator>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9">&nbsp;</td>
                    <td class="auto-style6">
                        <asp:Button ID="SaveButton" runat="server" Text="Save
                            " OnClick="SaveButton_Click" Width="110px" type="button" class="btn btn-primary" Height="35px"/>
                    </td>
                    <td>
                        &nbsp;</td>
                </tr>
                <tr>
                    <td colspan="3">
                        
                        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns ="False" DataKeyNames="PATIENTCODE" DataSourceID="SqlDataSource1" Height="16px" Width="853px" CssClass="auto-style7" OnSelectedIndexChanged="GridView1_SelectedIndexChanged" AllowSorting="True"  BackColor="LightGoldenrodYellow" BorderColor="Tan" BorderWidth="1px" CellPadding="2" ForeColor="Black" GridLines="None">
                            <AlternatingRowStyle BackColor="PaleGoldenrod" />
                            <Columns>                 
                                <asp:CommandField ShowDeleteButton="True" />
                                <asp:BoundField DataField="PATIENTCODE" HeaderText="PATIENTCODE" ReadOnly="True" SortExpression="PATIENTCODE" />
                                <asp:BoundField DataField="PATIENTNAME" HeaderText="PATIENTNAME" SortExpression="PATIENTNAME" />
                                <asp:BoundField DataField="PATIENTAGE" HeaderText="PATIENTAGE" SortExpression="PATIENTAGE" />              
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
                        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:ELDNETConnectionString %>" SelectCommand="SELECT [PATIENTCODE], [PATIENTNAME], [PATIENTAGE] FROM [PATIENTINFOFILE]" ConflictDetection="CompareAllValues" DeleteCommand="DELETE FROM [PATIENTINFOFILE] WHERE [PATIENTCODE] = @original_PATIENTCODE AND (([PATIENTNAME] = @original_PATIENTNAME) OR ([PATIENTNAME] IS NULL AND @original_PATIENTNAME IS NULL)) AND (([PATIENTAGE] = @original_PATIENTAGE) OR ([PATIENTAGE] IS NULL AND @original_PATIENTAGE IS NULL))" InsertCommand="INSERT INTO [PATIENTINFOFILE] ([PATIENTCODE], [PATIENTNAME], [PATIENTAGE]) VALUES (@PATIENTCODE, @PATIENTNAME, @PATIENTAGE)" OldValuesParameterFormatString="original_{0}" UpdateCommand="UPDATE [PATIENTINFOFILE] SET [PATIENTNAME] = @PATIENTNAME, [PATIENTAGE] = @PATIENTAGE WHERE [PATIENTCODE] = @original_PATIENTCODE AND (([PATIENTNAME] = @original_PATIENTNAME) OR ([PATIENTNAME] IS NULL AND @original_PATIENTNAME IS NULL)) AND (([PATIENTAGE] = @original_PATIENTAGE) OR ([PATIENTAGE] IS NULL AND @original_PATIENTAGE IS NULL))">
                            <DeleteParameters>
                                <asp:Parameter Name="original_PATIENTCODE" Type="String" />
                                <asp:Parameter Name="original_PATIENTNAME" Type="String" />
                                <asp:Parameter Name="original_PATIENTAGE" Type="Int16" />
                            </DeleteParameters>
                            <InsertParameters>
                                <asp:Parameter Name="PATIENTCODE" Type="String" />
                                <asp:Parameter Name="PATIENTNAME" Type="String" />
                                <asp:Parameter Name="PATIENTAGE" Type="Int16" />
                            </InsertParameters>
                            <UpdateParameters>
                                <asp:Parameter Name="PATIENTNAME" Type="String" />
                                <asp:Parameter Name="PATIENTAGE" Type="Int16" />
                                <asp:Parameter Name="original_PATIENTCODE" Type="String" />
                                <asp:Parameter Name="original_PATIENTNAME" Type="String" />
                                <asp:Parameter Name="original_PATIENTAGE" Type="Int16" />
                            </UpdateParameters>
                        </asp:SqlDataSource>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
