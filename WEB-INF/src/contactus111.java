import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class contactus111 extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
PrintWriter out=res.getWriter();
res.setContentType("text/html");
String name=req.getParameter("t1");
String roll=req.getParameter("t2");
String branch=req.getParameter("t3");
try
{
 Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
PreparedStatement pst=con.prepareStatement("insert into contact1 values(?,?,?)");
pst.setString(1,name);
pst.setString(2,roll);
pst.setString(3,branch);
int i=pst.executeUpdate();
if(i==1)
{
RequestDispatcher rd=req.getRequestDispatcher("suc1.html");
rd.include(req,res);
}
}
catch(Exception e)
{
out.println(e);
}
}
}


