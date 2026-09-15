<!DOCTYPE html>
<html>
    <head>
        <title>User Details</title>
    </head>
    <body>
        <div style="font-size: 30px">
            ADD USER
        </div>
        <br><br>
        <div id="container">
            <div class="signup">
                <form action="registrationaction.jsp"
                      method="post" style="font-size: 30px">

                    Enter name:
                    <input type="text" name="name" placeholder="Enter name" required
                           style="font-size: 30px"> <br><br>
                    
                    Enter Email:
                    <input type="email" name="email" placeholder="Enter email" required
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
                    if ("valid".equals(msg)) {
                %>

                <h1>Successfully Registered!!</h1>

                <%
                    }
                %>

                <%
                    if ("invalid".equals(msg)) {
                %>
                <h1>Something went wrong! Try again!</h1>
                <%}
                %>

            </div>
        </div>
    </body>
</html>
