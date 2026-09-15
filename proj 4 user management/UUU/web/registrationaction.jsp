<%@page import="Project.ConnectionProvider"%>
<%@page import="java.sql.*"%>

<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String mobilenumber = request.getParameter("mobilenumber");
    String domain = request.getParameter("domain");

    try {
        Connection con = ConnectionProvider.getCon();
        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO user (name, email, mobile, domain) VALUES (?, ?, ?, ?)"
        );
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, mobilenumber);
        ps.setString(4, domain);
        ps.executeUpdate();
        response.sendRedirect("registration.jsp?msg=valid");
    } catch (Exception e) {
        System.out.println(e);
        response.sendRedirect("registration.jsp?msg=invalid");
    }
%>
