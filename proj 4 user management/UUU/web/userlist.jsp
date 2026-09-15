<%-- 
    Document   : userlist
    Created on : 14 Sept 2026, 7:27:46 pm
    Author     : Dell
--%>

<%@page import="Project.ConnectionProvider" %>
<%@page import="java.sql.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User  List</title>
        <style>
            hr{
                width: 70%
            }
        </style>
    </head>
    <body>
        <div id="wrapper" style="font-size:30px">

            <table class="table table-bordered table-hover tble-responsive-sm"
                   style="width: 50%; margin-left: auto">
                <thead>
                    <tr class="bg-dark">
                        <th style="font-size: 50px" class="text-center text-white" colspan="3">User List</th>
                    </tr>
                </thead>

                <tbody>
                    <tr class="table-primary">
                        <td class="text-center"><strong>NAME</strong></td>
                        <td class="text-center"><strong>EMAIL</strong></td>
                        <td class="text-center"><strong>CONTACT</strong></td>
                        <td class="text-center"><strong>DOMAIN</strong></td>
                        <td></td>
                        <td></td>
                    </tr>

                    <%@page import="java.sql.*" %>    
                    <%
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/uuu?useSSL=false", "root", "Root!2#4");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("select * from user");
                    %><%
                        while (rs.next()) { %>

                    <%

                    %>

                    <tr style="font-size: 30px">
                        <td class="text-center"><%out.println(rs.getString(1)); %></td>
                        <td class="text-center"><%out.println(rs.getString(2)); %></td>
                        <td class="text-center"><%out.println(rs.getString(3)); %></td>
                        <td class="text-center"><%out.println(rs.getString(4));%></td>
                        <td><a href="remove.jsp?email=<%=rs.getString(2)%>">Remove</a></td>
                        <td><a href="edit.jsp?email=<%=rs.getString(2)%>">Edit</a></td>
                    </tr>

                    <%
                        }
                    %>

                </tbody>
            </table>
        </div>


        <div class="font-size:30px">
            <a href="registration.jsp">ADD NEW</a>
        </div>

    </body>
</html>
