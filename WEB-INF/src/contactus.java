import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class contactus extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
PrintWriter out=res.getWriter();
res.setContentType("text/html");
String name=req.getParameter("t1");
String email=req.getParameter("t2");
long mobile=Long.parseLong(req.getParameter("t3"));
String subject=req.getParameter("t4");
String message=req.getParameter("t5");
try
{
 Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
PreparedStatement pst=con.prepareStatement("insert into contact values(?,?,?,?,?)");
pst.setString(1,name);
pst.setString(2,email);
pst.setLong(3,mobile);
pst.setString(4,subject);
pst.setString(5,message);

int i=pst.executeUpdate();
if(i==1)
{
RequestDispatcher rd=req.getRequestDispatcher("success_1.html");
rd.include(req,res);
}
}
catch(Exception e)
{
out.println(e);
}
}
}


