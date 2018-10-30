package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tutorial_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Tutorial</title>\n");
      out.write("        <style>\n");
      out.write("            *{\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("           img { \n");
      out.write("            padding:1px;border:thin solid black;\n");
      out.write("            }\n");
      out.write("            h2{\n");
      out.write("                color: #760e32;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Tutorial!</h1>\n");
      out.write("        <h2>A</h2>\n");
      out.write("        <img src=\"images/t1.png\" width=\"500\" height=\"500\" ><br>\n");
      out.write("        <h2>B</h2><br>\n");
      out.write("        <img src=\"images/t2.png\" width=\"500\" height=\"500\"><br>\n");
      out.write("        <h2>C</h2><br>\n");
      out.write("        <img src=\"images/t3.png\" width=\"500\" height=\"500\"><br>\n");
      out.write("        <h2>D</h2><br>\n");
      out.write("        <img src=\"images/t4.png\" width=\"500\" height=\"500\"><br>\n");
      out.write("        <h2>E</h2><br>\n");
      out.write("        <img src=\"images/t5.png\" width=\"500\" height=\"500\"><br>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
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
