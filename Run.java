import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Run extends HttpServlet
{

public void service (HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();

String path="E:\\AJAX\\Online java compiler";
System.out.println(path+"real");
String fileName=req.getParameter("className").trim();


String command="C://bea//jdk1.8.0_131//bin//java -cp E://AJAX//online//WEB-INF//files//classes// "+fileName;

Process p1=Runtime.getRuntime().exec(command);
try
{
p1.waitFor();
BufferedReader br2=new BufferedReader(new InputStreamReader(p1.getErrorStream()));
BufferedReader br3=new BufferedReader(new InputStreamReader(p1.getInputStream()));

String result1="";
while(true)
{String temp=br2.readLine();
if(temp!=null)
{

result1+=temp;
result1+="\n";
}
else
break;
}



String result2="";
while(true)
{String temp1=br3.readLine();
if(temp1!=null)
{
result2+=temp1;
result2+="\n";
}
else
break;
}
out.println(result1 +" "+result2);

}catch(Exception e){}

}
}