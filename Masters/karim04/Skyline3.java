import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;







public class Skyline3 extends HttpServlet 

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
  System.out.println("error loading this driver:cnfe22");
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

                String c = request.getParameter("Booking_no");


                      String D = null;
                      String E = null;  
                      String F = null;
                      String I = null;
                      String J = null;
                      String G =  null; 
                      String H = null;





      if (request.getParameter("action").equals("login"))

              {

               out.println("<HTML>");


                out.println("<BODY bgcolor=\"#F6CEF5\">");


                out.println("<FORM METHOD=\"POST\" ACTION=\"http://www3.unl.ac.uk:8186/ada0804/servlet/Skyline3?action=submit\">");


                out.println("<H1>SKYLINE AIRWAYS</H1><p>");


                out.println("Enter your Name as shown on your Passpsrt: <INPUT TYPE=TEXT NAME=\"name\"> <BR>");


                   out.println("Enter your Booking Number: <INPUT TYPE=TEXT NAME=\"Booking_no\"> <BR>");



                         out.println("<INPUT TYPE=\"SUBMIT\" VALUE=\"Submit\">");


                                  out.println("</FORM>");



                              out.println("</BODY>");

		}
                                     out.println("</HTML>");





                     if (request.getParameter("action").equals("submit"))

                      {


	
             try   {

              Statement statement = connection.createStatement();

String Q = "select plane_no,departure_date,departure_time,flight_from,destination,arrival_time,arrival_date from bookings,flights where flights.flight_no=bookings.flight_no and bookings.booking_no='"+ c +"'";

                   ResultSet rs = statement.executeQuery(Q);
                          

                   
                                                       
                    if(rs.next())
                   
                   {
                       D = rs.getString("plane_no");
                       E = rs.getString("departure_date");  
                       F = rs.getString("departure_time");
                       I = rs.getString("flight_from");
                       J = rs.getString("destination");
                       G = rs.getString("arrival_date");  
                       H = rs.getString("arrival time");
                                                                  
               out.println("i am fine");
                         
                                                 
                       }
                    //out.println("i am fine10");

                    out.println("reserve item  : "+ D +"?<br>");






                     statement.close();
      }
catch (Exception e) 
	{
  out.println(e.getMessage());
  out.println("error loading this driver:cnfe2");
        }



}


 } catch (Exception e) {out.println(e); e.printStackTrace(out);}


        }        
                         
 } 

                                
                 

     