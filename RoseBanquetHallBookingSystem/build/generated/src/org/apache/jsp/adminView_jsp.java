package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bookingsystem.Hall;
import java.util.ArrayList;
import bookingsystem.HallDAO;

public final class adminView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("            \n");
      out.write("            *{text-align: center;}\n");
      out.write("            table, tr, td {border: 1px solid black;}\n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <img src=\"images/flower.png\"  height=\"60\" width=\"60\" id=\"#upper_left\">\n");
      out.write("        <h1>Rose Banquet Halls Admin Management</h1>\n");
      out.write("        <form action=\"BookingSystemServlet\" method=\"GET\">\n");
      out.write("            Add New Hall : <br>\n");
      out.write("            Enter Hall ID: <input type=\"text\" name=\"hallID\"> <br>\n");
      out.write("            Enter Hall Name: <input type=\"text\" name=\"hallName\"> <br> \n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"Add New Hall\">\n");
      out.write("        </form><br>\n");
      out.write("        \n");
      out.write("        <h2>List of Halls in the system: </h2>         \n");
      out.write("        Hall Name:\n");
      out.write("        <table align=\"center\" id=\"table\">\n");
      out.write("            ");

                HallDAO hallDAO= new HallDAO();
                ArrayList<Hall> halls= hallDAO.retrieveAllHalls();
                for(Hall h: halls){
            
      out.write("\n");
      out.write("            <tr> \n");
      out.write("                <td>");
 out.println(h.getHallName()); 
      out.write("</td>                    \n");
      out.write("                <td><form action=\"BookingSystemServlet\" method=\"GET\" >\n");
      out.write("                        <input type=\"hidden\" name=\"deleteHallID\" value=\"");
      out.print(h.getHallID());
      out.write("\">\n");
      out.write("                        <button type=\"submit\" name=\"action\" value=\"delete\">\n");
      out.write("                            <img src=\"images/bin.png\" height=\"12\" >\n");
      out.write("                        </button>\n");
      out.write("                    </form>\n");
      out.write("                </td>\n");
      out.write("                </tr>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </table>  \n");
      out.write("        <a href=\"index.jsp\">Back to Main Page</a>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
