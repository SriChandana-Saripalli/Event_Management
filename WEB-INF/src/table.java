import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
public class table extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
PrintWriter out=res.getWriter();
res.setContentType("text/html");
long m1=Long.parseLong(req.getParameter("t1"));
long c1=Long.parseLong(req.getParameter("t2"));
long m2=Long.parseLong(req.getParameter("t3"));
long c2=Long.parseLong(req.getParameter("t4"));
long m3=Long.parseLong(req.getParameter("t5"));
long c3=Long.parseLong(req.getParameter("t6"));
long m4=Long.parseLong(req.getParameter("t7"));
long c4=Long.parseLong(req.getParameter("t8"));
long m5=Long.parseLong(req.getParameter("t9"));
long c5=Long.parseLong(req.getParameter("t10"));
try
{
 Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
PreparedStatement pst=con.prepareStatement("insert into add_marks values(?,?,?,?,?,?,?,?,?,?)");
pst.setLong(1,m1);
pst.setLong(2,c1);
pst.setLong(3,m2);
pst.setLong(4,c2);
pst.setLong(5,m3);
pst.setLong(6,c3);
pst.setLong(7,m4);
pst.setLong(8,c4);
pst.setLong(9,m5);
pst.setLong(10,c5);
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


