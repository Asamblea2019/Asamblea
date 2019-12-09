package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class InicioSesion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Iniciar Sesion</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"estiloiniciosesion.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("         <link rel=\"icon\" href=\"img/LOGO1.jpg\">\n");
      out.write("   <!-- Bootstrap CSS -->\n");
      out.write("   <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("   <!-- animate CSS -->\n");
      out.write("   <link rel=\"stylesheet\" href=\"css/animate.css\">\n");
      out.write("   <!-- owl carousel CSS -->\n");
      out.write("   <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\">\n");
      out.write("   <!-- themify CSS -->\n");
      out.write("   <link rel=\"stylesheet\" href=\"css/themify-icons.css\">\n");
      out.write("   <!-- flaticon CSS -->\n");
      out.write("   <link rel=\"stylesheet\" href=\"css/flaticon.css\">\n");
      out.write("   <!-- magnific-popup CSS -->\n");
      out.write("   <link rel=\"stylesheet\" href=\"css/magnific-popup.css\">\n");
      out.write("   <!-- font awesome CSS -->\n");
      out.write("   <link rel=\"stylesheet\" href=\"fontawesome/css/all.min.css\">\n");
      out.write("\n");
      out.write("    \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <section class=\"banner_part\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"contenedor\" >\n");
      out.write("            \n");
      out.write("            <div class=\"login\" >\n");
      out.write("                <article class=\"fondo\">\n");
      out.write("                   \n");
      out.write("                    <form class=\"fondo2\" method=\"post\" action=\"Usuario\">\n");
      out.write("                        <h3>Inicio de Sesión</h3><br><br>\n");
      out.write("                        <img src=\"img/LogoFinal.png\" alt=\"Usuario\"><br><br>\n");
      out.write("                        <input class=\"Diseño\" type=\"text\" placeholder=\"Cedula\" name=\"textcelId\">\n");
      out.write("                        <input class=\"Diseño\" type=\"password\" placeholder=\"Contraseña\" name=\"textpasswordusu\">\n");
      out.write("                        <br>\n");
      out.write("                     \n");
      out.write("                        <input class=\"boton\" type=\"submit\" name=\"inicio\" value=\"Iniciar sesión\">\n");
      out.write("            <input type=\"hidden\" name=\"opcion\" value=\"3\">\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("                    <a href=\"contraseña1.jsp\"> recuperar contraseña</a>\n");
      out.write("          </article>\n");
      out.write("         <div style=\"color: red\">\n");
      out.write("            ");
if (request.getAttribute("MensajeExito") != null) {
      out.write("\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            \n");
      out.write("         </div>\n");
      out.write("         </div>\n");
      out.write("         </div>\n");
      out.write("             </div>\n");
      out.write("   </section>\n");
      out.write("  \n");
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
