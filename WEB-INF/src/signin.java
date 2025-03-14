+import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class signin extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
PrintWriter out=res.getWriter();
res.setContentType("text/html");
String uname=req.getParameter("t1");
String pass=req.getParameter("t2");
String email=req.getParameter("t3");
String add=req.getParameter("t4");
long mobile=Long.parseLong(req.getParameter("t5"));

try
{
 Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
PreparedStatement pst=con.prepareStatement("insert into signin values(?,?,?,?,?)");
pst.setString(1,uname);
pst.setString(2,pass);
pst.setString(3,email);
pst.setString(4,add);
pst.setLong(5,mobile);

int i=pst.executeUpdate();
if(i==1)
{
RequestDispatcher rd=req.getRequestDispatcher("success.html");
rd.include(req,res);
}
}
catch(Exception e)
{
out.println(e);
}
}
}