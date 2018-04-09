

<%@ page import="java.util.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="java.io.*" %>

<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
		<%

			java.sql.Connection con;
			java.sql.Statement statement;
			java.sql.ResultSet resultset;
			con = null;
			

			String first_name = request.getParameter("first_name");
			String last_name = request.getParameter("last_name");
			String identification = request.getParameter("id");

			// Copied From database1.jsp provided in class
			String url= "jdbc:jtds:sqlserver://acaddb/RJB_GG";
			String id= "sa";
			String pass = "Op4SQLclass";

			try{ //trying to connecting to the database

				Class.forName("net.sourceforge.jtds.jdbc.Driver");
				con = java.sql.DriverManager.getConnection(url, id, pass); //entering the databse link, username and password

			}catch(ClassNotFoundException cnfex){
				cnfex.printStackTrace();

			}
			statement = con.createStatement();
			String command = "INSERT INTO PERSONS VALUES('"+identification+"'"+","+"'"+first_name+"'"+","+"'"+last_name+"')";  //string concatination "INSERT INTO PERSONS VALUES(66977, 'tytiyom', 'ppklopm')";

			int sucess = statement.executeUpdate(command);
			resultset = statement.executeQuery("select * from PERSONS");

			%>
			<h1>These Are The Records Present</h1>
			<TABLE BORDER="1">
                <TR>
                    <TH>ID</TH>
                    <TH>First Name</TH>
                    <TH>Last Name</TH>
                </TR>
            <%
            while(resultset.next()){ 
        	%>
                <TR>
                    <TD> <%= resultset.getString(1) %> </TD>
                    <TD> <%= resultset.getString(2) %> </TD>
                    <TD> <%= resultset.getString(3) %> </TD>
               </TR>
     
        <% 
            } 
        %>
        </TABLE>

        <a href="add.html">Back to Insert Form</a>
</body>
</html>