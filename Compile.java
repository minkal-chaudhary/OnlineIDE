import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Compile extends HttpServlet
{
public Compile()
{
	
}
public void service (HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();

String path="E:\\AJAX\\Online java compiler";
System.out.println(path+"real");
String fileName=req.getParameter("className")+".java";


FileOutputStream fout=new FileOutputStream(new File(fileName));
FileOutputStream fout1=new FileOutputStream(new File("E:\\AJAX\\Online\\WEB-INF\\files\\classes\\"+fileName));

byte b[]=req.getParameter("code").getBytes();
fout.write(b);
fout1.write(b);
String command="C:\\bea\\jdk1.8.0_131\\bin\\javac -d E:\\AJAX\\online\\WEB-INF\\files\\classes E:\\AJAX\\online\\WEB-INF\\files\\classes\\"+fileName;

Process error=Runtime.getRuntime().exec(command);

BufferedReader err=new BufferedReader(new InputStreamReader(error.getErrorStream()));

String result="";

while(true)
{
  String temp=err.readLine();
  if(temp!=null)
  {result+=temp;
   result+="\n";
  }
  else
  {
  break;
  
  }
}
if(result.equals(""))
{
out.println("compiled SuccesFully");
err.close();
}
//fout.close();
out.println(result);
}

}