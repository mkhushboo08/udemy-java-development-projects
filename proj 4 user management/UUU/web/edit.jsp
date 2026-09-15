<!DOCTYPE html>
<html>
    <head>
        <title>Edit User Details</title>
    </head>
    <body>
        <%
            String email = request.getParameter("email");
        %>

        <div class="font-size:30px">
            Edit User
        </div>

        <div id="container">
            <div class="signup" style="font-size: 30px">
                Email: <%out.println(email);%>
                <form action="editaction.jsp?email=<%out.println(email);%>"
                      method="post" style="font-size: 30px">

                    Enter name:
                    <input type="text" name="name" placeholder="Enter name" required
                           style="font-size: 30px"> <br><br>

                    Enter Mobile Number:
                    <input type="number" name="mobilenumber" placeholder="Enter mobile number" required
                           style="font-size: 30px"> <br><br>

                    Enter Domain:
                    <input type="text" name="domain" placeholder="Enter domain" required
                           style="font-size: 30px"> <br><br>

                    <input type="submit" value="Submit"
                           style="font-size: 30px">
                </form>

                <h2><a href="userlist.jsp">User List</a></h2>
            </div>
            <div class="whysign" style="font-size: 30px">
                <%
                    String msg = request.getParameter("msg");
                    if ("done".equals(msg)) {
                %>

                <h1>Successfully edited!</h1>
                
                <%
                    }
                %>

            </div>
        </div>

    </body>
</html>
