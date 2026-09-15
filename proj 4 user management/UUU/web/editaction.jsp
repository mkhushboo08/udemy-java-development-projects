<%@page import="Project.ConnectionProvider"%>
<%@page import="java.sql.*"%>

<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String mobile = request.getParameter("mobilenumber");
    String domain = request.getParameter("domain");

    try {
        Connection con = ConnectionProvider.getCon();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from user where email='" + email + "'");
        while (rs.next()) {
            st.executeUpdate("UPDATE user SET name='" + name
                    + "', mobile='" + mobile
                    + "', domain='" + domain
                    + "' WHERE email='" + email + "'");
            response.sendRedirect("edit.jsp?msg=done&email=" + email);
        }
    } catch (Exception e) {
        System.out.println(e);
    }
%>
