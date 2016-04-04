import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;







public class skyline extends HttpServlet 

{

Connection connection;



public void init()


          {


              try  {


	Class.forName("oracle.jdbc.driver.OracleDriver");

	connection = DriverManager.getConnection ("jdbc:oracle:thin:karim04/karim04zz@eden:1521:design01");
    	}
catch (Exception e) 
	{
  System.out.println(e.getMessage());
  System.out.println("error loading this driver:cnfe");
        }


           }

      public void doGet(HttpServletRequest request, HttpServletResponse response)
                      throws IOException, ServletException
		{
                      doPost(request,response);
                }

    
              
      public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException


                
{


    
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 





try{ 
        
                    String name = request.getParameter("id"); 

          
                 HttpSession s= request.getSession(true);


                s.setAttribute("name",name); // creating a session









      if (request.getParameter("action").equals("login"))

              {

               out.println("<HTML>");


                out.println("<BODY bgcolor=\"#F6CEF5\">");


                out.println("<FORM METHOD=\"POST\" ACTION=\"http://www3.unl.ac.uk:8186/ada0804/servlet/skyline?action=submit\">");


                out.println("<H1>SKYLINE AIRWAYS</H1><p>");


                out.println("Enter your User Name: <INPUT TYPE=TEXT NAME=\"name\"> <BR>");


                   out.println("Enter your Password: <INPUT TYPE=TEXT NAME=\"Password\"> <BR>");



                         out.println("<INPUT TYPE=\"SUBMIT\" VALUE=\"Submit\">");


                                  out.println("</FORM>");



                              out.println("</BODY>");

		}
                                     out.println("</HTML>");









     if (request.getParameter("action").equals("submit"))

     {

        out.println("<HTML>");


                out.println("<BODY bgcolor=\"#F6CEF5\">");


                out.println("<FORM METHOD=\"POST\" ACTION=\"http://www3.unl.ac.uk:8186/ada0804/sky.html\">");


                out.println("<H1>SKYLINE AIRWAYS</H1><p>");


                out.println("Enter CUSTOMER NAME: <INPUT TYPE=TEXT NAME=\"name\"> <BR><BR><BR>");


                   out.println("Enter CUSTOMER email address: <INPUT TYPE=TEXT NAME=\"email\"> <BR><BR><BR>");


                    out.println("Enter CUSTOMER address: <INPUT TYPE=TEXT NAME=\"address\"> <BR><BR><BR>");


                      out.println("Enter CUSTOMER telephone number: <INPUT TYPE=TEXT NAME=\"telephone\"> <BR><BR><BR>");


                         out.println("Enter CUSTOMER CARD DETAILS: <INPUT TYPE=TEXT NAME=\"card details\"> <BR><BR><BR>");



                        

                         out.println("<INPUT TYPE=\"SUBMIT\" VALUE=\"ENTER\">");


                                  out.println("</FORM>");



                              out.println("</BODY>");

		}
                                     out.println("</HTML>");



















 } catch (Exception e) {out.println(e); e.printStackTrace(out);}


        }        
                         
 } 

                                
                 

     