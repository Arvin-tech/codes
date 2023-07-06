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
        .auto-style9 {
            width: 199px;
            height: 39px;
            text-align: right;
        }
        .auto-style11 {
            height: 39px;
        }
        .auto-style12 {
            width: 199px;
            text-align: right;
        }
        .auto-style13 {
            text-align: center;
        }
        .auto-style14 {
            width: 199px;
            text-align: right;
            height: 37px;
        }
        .auto-style16 {
            height: 37px;
        }
        .auto-style17 {
            height: 23px;
        }
        .auto-style24 {
            height: 24px;
            width: 46px;
        }
        .auto-style25 {
            width: 46px;
        }
        .auto-style27 {
            width: 46px;
            height: 39px;
        }
        .auto-style29 {
            width: 46px;
            height: 23px;
        }
        .auto-style38 {
            height: 24px;
            width: 199px;
        }
        .auto-style39 {
            width: 199px;
            height: 23px;
        }
        .auto-style40 {
            width: 199px;
        }
        .auto-style52 {
            height: 24px;
            width: 73px;
        }
        .auto-style53 {
            width: 73px;
        }
        .auto-style55 {
            height: 39px;
            width: 73px;
        }
        .auto-style56 {
            height: 37px;
            width: 73px;
        }
        .auto-style57 {
            height: 23px;
            width: 73px;
        }
        .auto-style58 {
            text-align: center;
            width: 73px;
        }
        .auto-style59 {
            height: 24px;
            width: 20px;
        }
        .auto-style60 {
            width: 20px;
        }
        .auto-style62 {
            height: 39px;
            width: 20px;
        }
        .auto-style63 {
            height: 37px;
            width: 20px;
        }
        .auto-style64 {
            height: 23px;
            width: 20px;
        }
        .auto-style65 {
            text-align: center;
            width: 20px;
        }
        .auto-style66 {
            width: 199px;
            height: 57px;
            text-align: right;
        }
        .auto-style68 {
            width: 46px;
            height: 57px;
            text-align: right;
        }
        .auto-style71 {
            height: 57px;
            width: 20px;
        }
        .auto-style72 {
            height: 57px;
            width: 73px;
        }
        .auto-style73 {
            height: 57px;
        }
        .auto-style74 {
            height: 24px;
            width: 14px;
        }
        .auto-style75 {
            width: 14px;
        }
        .auto-style76 {
            height: 57px;
            width: 14px;
        }
        .auto-style77 {
            height: 39px;
            width: 14px;
        }
        .auto-style78 {
            height: 23px;
            width: 14px;
        }
        .auto-style79 {
            height: 24px;
            width: 77px;
        }
        .auto-style80 {
            width: 77px;
        }
        .auto-style81 {
            width: 77px;
            height: 57px;
        }
        .auto-style82 {
            width: 77px;
            height: 39px;
        }
        .auto-style83 {
            width: 77px;
            height: 23px;
        }
        .auto-style85 {
            width: 46px;
            text-align: right;
        }
        .auto-style86 {
            height: 24px;
            width: 6px;
        }
        .auto-style87 {
            width: 6px;
        }
        .auto-style88 {
            height: 57px;
            width: 6px;
        }
        .auto-style89 {
            height: 39px;
            width: 6px;
        }
        .auto-style90 {
            height: 23px;
            width: 6px;
        }
        .auto-style91 {
            width: 46px;
            height: 39px;
            text-align: right;
        }
        </style>
    
</head>
<body>
    
    <form id="form1" runat="server" autocomplete="off">
        <div>
            <table class="auto-style1">
                <tr>
                    <td class="auto-style38" style="font-family: 'Tw Cen MT Condensed'">
                        
                        <strong>Logged in as: </strong><asp:Label ID="UserLabel" runat="server" Text=""></asp:Label>
                    </td>
                    <td class="auto-style79" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style24" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style86" style="font-family: 'Tw Cen MT Condensed'"><strong>PATIENT REGISTRATION</strong></td>
                    <td class="auto-style74" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style59" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style52" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style2" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:LinkButton ID="HomeLinkButton" runat="server" CausesValidation="False" OnClick="HomeLinkButton_Click">Home</asp:LinkButton>
                    </td>
                    <td class="auto-style2" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:LinkButton ID="LogoutLinkButton" runat="server" OnClick="LogoutLinkButton_Click" CausesValidation="False">Logout</asp:LinkButton>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style12" style="font-family: 'Tw Cen MT Condensed'"><strong>Patient Code</strong></td>
                    <td class="auto-style80" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="PatientCodeTextBox" runat="server"  Height="24px" Width="105px" PlaceHolder="PAT00"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="PatientCodeTextBox" ErrorMessage="Patient Code Required!" ForeColor="Red"></asp:RequiredFieldValidator>
                    </td>
                    <td class="auto-style85" style="font-family: 'Tw Cen MT Condensed'">
                        <strong>Firstname</strong></td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style87">
                        <asp:TextBox ID="PatientFirstnameTextBox" runat="server"  Height="24px" Width="105px"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="PatientFirstnameTextBox" ErrorMessage="Firstname Required!" ForeColor="Red"></asp:RequiredFieldValidator>
                    </td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style75">&nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style60"><strong>Lastname</strong></td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style53">
                        <asp:TextBox ID="PatientLastnameTextbox" runat="server" Height="24px" Width="105px"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" ErrorMessage="Lastname Required!" ControlToValidate="PatientLastnameTextbox" ForeColor="Red"></asp:RequiredFieldValidator>
                    </td>
                    <td style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style66" style="font-family: 'Tw Cen MT Condensed'"><strong>Middlename</strong></td>
                    <td class="auto-style81" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="PatientMiddlenameTextbox" runat="server" Height="24px" Width="105px"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" ErrorMessage="Middlename Required!" ControlToValidate="PatientMiddlenameTextbox" ForeColor="Red"></asp:RequiredFieldValidator>
                    </td>
                    <td class="auto-style68" style="font-family: 'Tw Cen MT Condensed'">
                        <strong>Age</strong></td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style88">
                        <asp:TextBox ID="PatientAgeTextBox" runat="server"  Height="24px" Width="105px"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ControlToValidate="PatientAgeTextBox" ErrorMessage="Age Required!" ForeColor="Red"></asp:RequiredFieldValidator>
                    </td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style76">&nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style71"><strong>Gender</strong></td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style72">
                        <asp:RadioButton ID="MaleRadioButton" runat="server" Text="Male" GroupName="Gender" />
                        <asp:RadioButton ID="FemaleRadioButton" runat="server" Text="Female" GroupName="Gender" />
                    </td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style73"></td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style73">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'"><strong>Birthdate</strong></td>
                    <td class="auto-style82" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="BirthdateTextbox" runat="server" Height="24px" Width="105px" TextMode="Date"></asp:TextBox>
                        </td>
                    <td class="auto-style91" style="font-family: 'Tw Cen MT Condensed'">
                        <strong>Address</strong></td>
                    <td class="auto-style89" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="AddressTextbox" runat="server" Height="24px" Width="105px"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator6" runat="server" ErrorMessage="Address Required!" ForeColor="Red" ControlToValidate="AddressTextbox"></asp:RequiredFieldValidator>
                        </td>
                    <td class="auto-style77" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td class="auto-style62" style="font-family: 'Tw Cen MT Condensed'"><strong>Telephone</strong></td>
                    <td class="auto-style55" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="TelephoneTextbox" runat="server" Height="24px" Width="105px"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator7" runat="server" ErrorMessage="Telephone Required!" ForeColor="Red"  ControlToValidate="TelephoneTextbox"></asp:RequiredFieldValidator>
                        </td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'"><strong>Father&#39;s Name</strong></td>
                    <td class="auto-style82" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="FathersNameTextbox" runat="server" Height="24px" Width="105px"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator10" runat="server" ErrorMessage="Required!" ForeColor="Red" ControlToValidate="FathersNameTextbox"></asp:RequiredFieldValidator>
                        </td>
                    <td class="auto-style91" style="font-family: 'Tw Cen MT Condensed'">
                        <strong>Height (cm)</strong></td>
                    <td class="auto-style89" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="HeightTextbox" runat="server" Height="24px" Width="105px"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator8" runat="server" ErrorMessage="Height Required!" ForeColor="Red" ControlToValidate="HeightTextbox"></asp:RequiredFieldValidator>
                        </td>
                    <td class="auto-style77" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style62" style="font-family: 'Tw Cen MT Condensed'"><strong>Weight (kg)</strong></td>
                    <td class="auto-style55" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="WeightTextbox" runat="server" Height="24px" Width="105px"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator9" runat="server" ErrorMessage="Weight Required!" ForeColor="Red" ControlToValidate="WeightTextbox"></asp:RequiredFieldValidator>
                        </td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'"><strong>Mother&#39;s Name</strong></td>
                    <td class="auto-style82" style="font-family: 'Tw Cen MT Condensed'">
                        <asp:TextBox ID="MothersNameTextbox" runat="server" Height="24px" Width="105px"></asp:TextBox>
                        <asp:RequiredFieldValidator ID="RequiredFieldValidator11" runat="server" ErrorMessage="Required!" ForeColor="Red" ControlToValidate="MothersNameTextbox"></asp:RequiredFieldValidator>
                        </td>
                    <td class="auto-style27" style="font-family: 'Tw Cen MT Condensed'">
                        </td>
                    <td class="auto-style89" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td class="auto-style77" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td class="auto-style62" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td class="auto-style55" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style9" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style82" style="font-family: 'Tw Cen MT Condensed'">
                        <strong>Registered Patients:</strong></td>
                    <td class="auto-style27" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style89" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style77" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style62" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style55" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style11" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style12" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style13" style="font-family: 'Tw Cen MT Condensed'" colspan="6">
                        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" CellPadding="3" DataKeyNames="PATCODE" DataSourceID="SqlDataSource1" ForeColor="Black" GridLines="Vertical" Width="651px" BackColor="White" BorderColor="#999999" BorderStyle="Solid" BorderWidth="1px">
                            <AlternatingRowStyle BackColor="#CCCCCC" />
                            <Columns>
                                <asp:CommandField ShowDeleteButton="True" />
                                <asp:BoundField DataField="PATCODE" HeaderText="PATCODE" ReadOnly="True" SortExpression="PATCODE" />
                                <asp:BoundField DataField="PATFNAME" HeaderText="PATFNAME" SortExpression="PATFNAME" />
                                <asp:BoundField DataField="PATLNAME" HeaderText="PATLNAME" SortExpression="PATLNAME" />
                                <asp:BoundField DataField="PATMNAME" HeaderText="PATMNAME" SortExpression="PATMNAME" />
                                <asp:BoundField DataField="PATAGE" HeaderText="PATAGE" SortExpression="PATAGE" />
                                <asp:BoundField DataField="PATGENDER" HeaderText="PATGENDER" SortExpression="PATGENDER" />
                                <asp:BoundField DataField="PATBDATE" HeaderText="PATBDATE" SortExpression="PATBDATE" DataFormatString="{0:d}" />
                                <asp:BoundField DataField="PATADDR" HeaderText="PATADDR" SortExpression="PATADDR" />
                                <asp:BoundField DataField="PATTEL" HeaderText="PATTEL" SortExpression="PATTEL" />
                                <asp:BoundField DataField="PATFATHNAME" HeaderText="PATFATHNAME" SortExpression="PATFATHNAME" />
                                <asp:BoundField DataField="PATMOTHNAME" HeaderText="PATMOTHNAME" SortExpression="PATMOTHNAME" />
                                <asp:BoundField DataField="PATHEIGHT" HeaderText="PATHEIGHT" SortExpression="PATHEIGHT" />
                                <asp:BoundField DataField="PATWEIGHT" HeaderText="PATWEIGHT" SortExpression="PATWEIGHT" />
                                <asp:BoundField DataField="PATSTATUS" HeaderText="PATSTATUS" SortExpression="PATSTATUS" />
                            </Columns>
                            <FooterStyle BackColor="#CCCCCC" />
                            <HeaderStyle BackColor="Black" Font-Bold="True" ForeColor="White" />
                            <PagerStyle BackColor="#999999" ForeColor="Black" HorizontalAlign="Center" />
                            <SelectedRowStyle BackColor="#000099" Font-Bold="True" ForeColor="White" />
                            <SortedAscendingCellStyle BackColor="#F1F1F1" />
                            <SortedAscendingHeaderStyle BackColor="#808080" />
                            <SortedDescendingCellStyle BackColor="#CAC9C9" />
                            <SortedDescendingHeaderStyle BackColor="#383838" />
                        </asp:GridView>
                    </td>
                    <td style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style14" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style16" style="font-family: 'Tw Cen MT Condensed'" colspan="4">
                        
                        <asp:Button ID="SaveButton" runat="server" Text="Save
                            " OnClick="SaveButton_Click" Width="56px" type="button" class="btn btn-primary" Height="31px"/>
                        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:ELDNETConnectionString %>" DeleteCommand="DELETE FROM [PATIENTINFOFILE] WHERE [PATCODE] = @PATCODE" InsertCommand="INSERT INTO [PATIENTINFOFILE] ([PATCODE], [PATFNAME], [PATLNAME], [PATMNAME], [PATAGE], [PATGENDER], [PATBDATE], [PATADDR], [PATTEL], [PATFATHNAME], [PATMOTHNAME], [PATHEIGHT], [PATWEIGHT], [PATSTATUS]) VALUES (@PATCODE, @PATFNAME, @PATLNAME, @PATMNAME, @PATAGE, @PATGENDER, @PATBDATE, @PATADDR, @PATTEL, @PATFATHNAME, @PATMOTHNAME, @PATHEIGHT, @PATWEIGHT, @PATSTATUS)" SelectCommand="SELECT * FROM [PATIENTINFOFILE]" UpdateCommand="UPDATE [PATIENTINFOFILE] SET [PATFNAME] = @PATFNAME, [PATLNAME] = @PATLNAME, [PATMNAME] = @PATMNAME, [PATAGE] = @PATAGE, [PATGENDER] = @PATGENDER, [PATBDATE] = @PATBDATE, [PATADDR] = @PATADDR, [PATTEL] = @PATTEL, [PATFATHNAME] = @PATFATHNAME, [PATMOTHNAME] = @PATMOTHNAME, [PATHEIGHT] = @PATHEIGHT, [PATWEIGHT] = @PATWEIGHT, [PATSTATUS] = @PATSTATUS WHERE [PATCODE] = @PATCODE">
                            <DeleteParameters>
                                <asp:Parameter Name="PATCODE" Type="String" />
                            </DeleteParameters>
                            <InsertParameters>
                                <asp:Parameter Name="PATCODE" Type="String" />
                                <asp:Parameter Name="PATFNAME" Type="String" />
                                <asp:Parameter Name="PATLNAME" Type="String" />
                                <asp:Parameter Name="PATMNAME" Type="String" />
                                <asp:Parameter Name="PATAGE" Type="String" />
                                <asp:Parameter Name="PATGENDER" Type="String" />
                                <asp:Parameter DbType="Date" Name="PATBDATE" />
                                <asp:Parameter Name="PATADDR" Type="String" />
                                <asp:Parameter Name="PATTEL" Type="String" />
                                <asp:Parameter Name="PATFATHNAME" Type="String" />
                                <asp:Parameter Name="PATMOTHNAME" Type="String" />
                                <asp:Parameter Name="PATHEIGHT" Type="String" />
                                <asp:Parameter Name="PATWEIGHT" Type="String" />
                                <asp:Parameter Name="PATSTATUS" Type="String" />
                            </InsertParameters>
                            <UpdateParameters>
                                <asp:Parameter Name="PATFNAME" Type="String" />
                                <asp:Parameter Name="PATLNAME" Type="String" />
                                <asp:Parameter Name="PATMNAME" Type="String" />
                                <asp:Parameter Name="PATAGE" Type="String" />
                                <asp:Parameter Name="PATGENDER" Type="String" />
                                <asp:Parameter Name="PATBDATE" DbType="Date" />
                                <asp:Parameter Name="PATADDR" Type="String" />
                                <asp:Parameter Name="PATTEL" Type="String" />
                                <asp:Parameter Name="PATFATHNAME" Type="String" />
                                <asp:Parameter Name="PATMOTHNAME" Type="String" />
                                <asp:Parameter Name="PATHEIGHT" Type="String" />
                                <asp:Parameter Name="PATWEIGHT" Type="String" />
                                <asp:Parameter Name="PATSTATUS" Type="String" />
                                <asp:Parameter Name="PATCODE" Type="String" />
                            </UpdateParameters>
                        </asp:SqlDataSource>
                    </td>
                    <td class="auto-style63" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style56" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style16" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style16" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style39" style="font-family: 'Tw Cen MT Condensed'"></td>
                    <td class="auto-style83" style="font-family: 'Tw Cen MT Condensed'">
                        </td>
                    <td class="auto-style29" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style90">
                        </td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style78">
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style64">
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style57">
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style17">
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style17">
                        &nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style40" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style80" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style25" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style87">
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style75">
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style60">
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style53">
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style40" style="font-family: 'Tw Cen MT Condensed'">&nbsp;</td>
                    <td class="auto-style13" style="font-family: 'Tw Cen MT Condensed'" colspan="4">
                        &nbsp;</td>
                    <td class="auto-style65" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style58" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style13" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                    <td class="auto-style13" style="font-family: 'Tw Cen MT Condensed'">
                        &nbsp;</td>
                </tr>
                <tr>
                    <td colspan="4" style="font-family: 'Tw Cen MT Condensed'">
                        
                        <div class="auto-style13">
                        
                        </div>
                    </td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style75">
                        
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style60">
                        
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style53">
                        
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'">
                        
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'">
                        
                        &nbsp;</td>
                </tr>
                <tr>
                    <td colspan="4" style="font-family: 'Tw Cen MT Condensed'" class="auto-style17">
                        
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style78">
                        
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style64">
                        
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style57">
                        
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style17">
                        
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style17">
                        
                        &nbsp;</td>
                </tr>
                <tr>
                    <td colspan="4" style="font-family: 'Tw Cen MT Condensed'">
                        
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style75">
                        
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style60">
                        
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'" class="auto-style53">
                        
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'">
                        
                        &nbsp;</td>
                    <td style="font-family: 'Tw Cen MT Condensed'">
                        
                        &nbsp;</td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
