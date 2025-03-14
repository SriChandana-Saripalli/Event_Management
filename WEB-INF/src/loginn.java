import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class login extends GenericServlet
{
public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
{
PrintWriter out=res.getWriter();
String u=req.getParameter("t1");
String p=req.getParameter("t2");
res.setContentType("text/html");
try
{
 Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from signin");
int flag=0;
while(rs.next())
{
if(u.equals(rs.getString(1)) && p.equals(rs.getString(2)))
{
flag=1;
break;
}
}
if(flag==1)
{
RequestDispatcher rd=req.getRequestDispatcher("validd");
rd.forward(req,res);
}
else
{
out.println("<h3>Sorry! username and password details are not found</h3>");
RequestDispatcher rd=req.getRequestDispatcher("login.html");
rd.include(req,res);
}
con.close();
}
catch(Exception e)
{
out.println(e);
}
}
}