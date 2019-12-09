package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registrar_005fusuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/all.css\" >\n");
      out.write("        <link rel=\"stylesheet\" href=\"estiloregistrarusuario.css\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0\">\n");
      out.write("        <title>Registrar Usuario</title>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>       \n");
      out.write("        <form class=\"formulario\" method=\"post\" action=\"Usuario\">\n");
      out.write("            <h1>Registrate</h1>\n");
      out.write("            <div class=\"contenedor\">\n");
      out.write("\n");
      out.write("                <div class=\"input-contenedor\">\n");
      out.write("                    <i class=\"fas fa-user icon\"></i>\n");
      out.write("                    <input type=\"text\" name=\"textcelId\" placeholder=\"Cedula\">\n");
      out.write("                    <br>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                \n");
      out.write("                \n");
      out.write("              \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"input-contenedor\">\n");
      out.write("                    <i class=\"fas fa-key icon\"></i>\n");
      out.write("                    <input type=\"password\" name=\"textpasswordusu\" placeholder=\"Contraseña\" >\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <button class=\"button\">Registrar</button>\n");
      out.write("                <input type=\"hidden\" name=\"opcion\" value=\"1\">\n");
      out.write("                <br>\n");
      out.write("                <p>Al registrarte, aceptas nuestras Condiciones de uso y Política de privacidad.</p>\n");
      out.write("                <p>¿Ya tienes una cuenta?<a class=\"link\" href=\"InicioSesion.jsp\">Iniciar Sesion</a></p>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <div style=\"color: red\">\n");
      out.write("            ");
if (request.getAttribute("MensajeExito") != null) {
      out.write("\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            ");
} else {
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div style =\"color: blue\">\n");
      out.write("\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </div>  \n");
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
