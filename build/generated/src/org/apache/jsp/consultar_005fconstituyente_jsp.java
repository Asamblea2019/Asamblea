package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import TemasDAO.ConstituyenteDAO;
import TemasVO.ConstituyenteVO;

public final class consultar_005fconstituyente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("   <title>Constituyente</title>\n");
      out.write("   <link rel=\"icon\" href=\"img/LOGO1.jpg\">\n");
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
      out.write("   <!-- style CSS -->\n");
      out.write("   <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("   <link href=\"css/estilo1.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("   <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header class=\"main_menu home_menu\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("         <div class=\"row\">\n");
      out.write("            <div class=\"col-lg-12\">\n");
      out.write("               <nav class=\"navbar navbar-expand-lg navbar-light\">\n");
      out.write("                   <a class=\"navbar-brand\" href=\"index.html\"> <img src=\"img/LogoFinal.png\" alt=\"logo\"  width=\"200px\" height=\"50px\"> </a>\n");
      out.write("                  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\"\n");
      out.write("                     aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                     <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                  </button>\n");
      out.write("                  <div class=\"collapse navbar-collapse main-menu-item\" id=\"navbarNav\">\n");
      out.write("                     <ul class=\"navbar-nav\">\n");
      out.write("                         <li class=\"nav-item dropdown\">\n");
      out.write("                           <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\"\n");
      out.write("                              data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                              Registrar\n");
      out.write("                           </a>\n");
      out.write("                           <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                              <a class=\"dropdown-item\" href=\"Registrar_asamblea.jsp\">Registrar Asamblea</a>\n");
      out.write("                              <a class=\"dropdown-item\" href=\"Registrar_Constituyente.jsp\">Registrar Constituyente</a>\n");
      out.write("                              <a class=\"dropdown-item\" href=\"Registrar_multa.jsp\">Registrar Multa</a>\n");
      out.write("                              <a class=\"dropdown-item\" href=\"registrar_pregunta.jsp\">Registrar Pregunta</a>\n");
      out.write("                              <a class=\"dropdown-item\" href=\"registrar_tema.jsp\">Registrar Tema</a>\n");
      out.write("                              <a class=\"dropdown-item\" href=\"registrar_usuario.jsp\">Registrar Usuario</a>\n");
      out.write("                              <a class=\"dropdown-item\" href=\"registrar_informe.jsp\">Registrar Informe</a>\n");
      out.write("                              <a class=\"dropdown-item\" href=\"registrar_acta.jsp\">Registrar Acta</a>\n");
      out.write("                              <a class=\"dropdown-item\" href=\"respuesta.jsp\">Registrar Respuesta</a>\n");
      out.write("                              <a class=\"dropdown-item\" href=\"registrar_asistencia.jsp\">Registrar Asistencia</a>\n");
      out.write("                              <a class=\"dropdown-item\" href=\"registrar_votos.jsp\">Registrar Votos</a>\n");
      out.write("\n");
      out.write("                           </div>\n");
      out.write("                        </li>\n");
      out.write("                         \n");
      out.write("                        <li class=\"nav-item dropdown\">\n");
      out.write("                           <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\"\n");
      out.write("                              data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                              Consultar\n");
      out.write("                           </a>\n");
      out.write("                           <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                              <a class=\"dropdown-item\" href=\"consultar_Asamblea.jsp\">Consultar Asamblea</a>\n");
      out.write("                              <a class=\"dropdown-item\" href=\"consultar_constituyente.jsp\">Consultar Constituyente</a>\n");
      out.write("                              <a class=\"dropdown-item\" href=\"consultar_multa.jsp\">Consultar Multa</a>\n");
      out.write("                              <a class=\"dropdown-item\" href=\"consultar_pregunta.jsp\">Consultar Pregunta</a>\n");
      out.write("                              <a class=\"dropdown-item\" href=\"consultar_acta.jsp\">Consultar Acta</a>\n");
      out.write("                              <a class=\"dropdown-item\" href=\"consultar_asistencia.jsp\">Consultar Asistencia</a>\n");
      out.write("                              <a class=\"dropdown-item\" href=\"consultar_informe.jsp\">Consultar Informe</a>\n");
      out.write("                              <a class=\"dropdown-item\" href=\"consultar_tema.jsp\">Consultar Tema</a>\n");
      out.write("                              \n");
      out.write("                              <a class=\"dropdown-item\" href=\"Recuperar _contraseña.jsp\">Consultar Usuario</a>\n");
      out.write("\n");
      out.write("                             \n");
      out.write("\n");
      out.write("                           </div>\n");
      out.write("                        </li>\n");
      out.write("                        <form method=\"post\" action=\"Estilofin.jsp\">\n");
      out.write("                            \n");
      out.write("                        <li class=\"nav-item dropdown\">\n");
      out.write("                           <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\"\n");
      out.write("                              data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                              Perfil\n");
      out.write("                           </a>\n");
      out.write("                           <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                               <a class=\"dropdown-item\" href=\"InicioSesion.jsp\" name=\"Salir\" ");
session.invalidate();
      out.write(">Cerrar Sesion</a>\n");
      out.write("                            \n");
      out.write("                           </div>\n");
      out.write("                        </li>\n");
      out.write("                        </form>\n");
      out.write("                     </ul>\n");
      out.write("                  </div>\n");
      out.write("               </nav>\n");
      out.write("            </div>\n");
      out.write("         </div>\n");
      out.write("      </div>\n");
      out.write("   </header>\n");
      out.write("        \n");
      out.write("        <section class=\"banner_part\">\n");
      out.write("            <div class=\"container\" id=\"cotainer\">\n");
      out.write("                <div id=\"Contenedor-form\">   \n");
      out.write("                    \n");
      out.write("\t   <center>\n");
      out.write("            <h1>Constituyente</h1><br>\n");
      out.write("            <form method=\"post\" action=\"Constituyente\">\n");
      out.write("                <table class=\"table\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th>\n");
      out.write("                            Cedula<br><br>\n");
      out.write("                            <select name=\"select\" class=\"form-control\"  >\n");
      out.write("                                <option>SELECCIONE</option>\n");
      out.write("                                ");

                                    ConstituyenteVO consVO = new ConstituyenteVO();
                                    ConstituyenteDAO consDAO = new ConstituyenteDAO();

                                    ArrayList<ConstituyenteVO> listaCONS = consDAO.listarCons();

                                    for (int i = 0; i < listaCONS.size(); i++) {

                                        consVO = listaCONS.get(i);
                                
      out.write("\n");
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( consVO.getCedulaf_Usuario());
      out.write('"');
      out.write('>');
      out.print( consVO.getNombre_Constituyete());
      out.write(' ');
      out.print( consVO.getApellido_Constituyente());
      out.write("</option>\n");
      out.write("\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </th>\n");
      out.write("                    </tr>\n");
      out.write("                </table><br>\n");
      out.write("                <button class=\"btn btn-outline-primary\">Consultar</button><br><br>\n");
      out.write("                <input type=\"hidden\" name=\"opcion\" value=\"2\">\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("            <a href=\"Registrar_Constituyente.jsp\">Atrás</a><br><br>\n");
      out.write("            <a href=\"../src/java/TemasControlador/ControladorTemas.java\"></a>\n");
      out.write("            \n");
      out.write("            <form id=\"Table\"> \n");
      out.write("                \n");
      out.write("                <table class=\"table\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th scope=\"col\">CEDULA</th>\n");
      out.write("                        <th scope=\"col\">NOMBRE</th>\n");
      out.write("                        <th scope=\"col\">APELLIDO</th>\n");
      out.write("                        <th scope=\"col\">CORREO</th>\n");
      out.write("                        <th scope=\"col\">CELULAR</th>\n");
      out.write("                        <th scope=\"col\">RESISDENCIA</th>\n");
      out.write("                        <th scope=\"col\">REPRESENTANTE</th>\n");
      out.write("                        \n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                    ");

                        ConstituyenteVO constVO = new ConstituyenteVO();
                        ConstituyenteDAO constDAO = new ConstituyenteDAO();
                        
                        ArrayList<ConstituyenteVO> listaConstituyentes = constDAO.listarCons();
                        

                        for (int i = 0; i < listaConstituyentes.size(); i++) {
                            
                            constVO = listaConstituyentes.get(i);
                    
      out.write("\n");
      out.write("                    \n");
      out.write("                    <tr>\n");
      out.write("                        \n");
      out.write("                        <th scope=\"row\">");
      out.print( constVO.getCedulaf_Usuario());
      out.write("</th>\n");
      out.write("                        <td>");
      out.print( constVO.getNombre_Constituyete());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( constVO.getApellido_Constituyente());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( constVO.getCorreo_Constituyente());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( constVO.getCel_Constituyente());
      out.write("</td>\n");
      out.write("                        \n");
      out.write("                        <td>");
      out.print( constVO.getEstado_Constituyenye());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( constVO.getPoder());
      out.write("</td>\n");
      out.write("                        \n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    \n");
      out.write("                </table><br><br>\n");
      out.write("                    \n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("                                                                                   \n");
      out.write("            <div style=\"color:red;\">\n");
      out.write("            ");
if (request.getAttribute("mensajeError")!=null){ 
      out.write("\n");
      out.write("              \n");
      out.write("            \n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("    \n");
      out.write("                ");
}
      out.write("\n");
      out.write("                \n");
      out.write("            \n");
      out.write("            </div>\n");
      out.write("        </center>\n");
      out.write("                <center>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-outline-primary\">Menu <a href=\"Estilofin.jsp\"</a></button>\n");
      out.write("               </center>\n");
      out.write("               </div>\n");
      out.write("      </div>\n");
      out.write("   </section>\n");
      out.write("   <!--::banner part end::-->\n");
      out.write("      \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <!-- jquery plugins here-->\n");
      out.write("   <script src=\"js/jquery-1.12.1.min.js\"></script>\n");
      out.write("   <!-- popper js -->\n");
      out.write("   <script src=\"js/popper.min.js\"></script>\n");
      out.write("   <!-- bootstrap js -->\n");
      out.write("   <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("   <!-- magnific js -->\n");
      out.write("   <script src=\"js/jquery.magnific-popup.min.js\"></script>\n");
      out.write("   <!-- carousel js -->\n");
      out.write("   <script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("   <!-- easing js -->\n");
      out.write("   <script src=\"js/jquery.easing.min.js\"></script>\n");
      out.write("   <!--masonry js-->\n");
      out.write("   <script src=\"js/masonry.pkgd.min.js\"></script>\n");
      out.write("   <script src=\"js/masonry.pkgd.js\"></script>\n");
      out.write("   <!--form validation js-->\n");
      out.write("   <script src=\"js/jquery.nice-select.min.js\"></script>\n");
      out.write("\t<script src=\"js/contact.js\"></script>\n");
      out.write("\t<script src=\"js/jquery.ajaxchimp.min.js\"></script>\n");
      out.write("\t<script src=\"js/jquery.form.js\"></script>\n");
      out.write("\t<script src=\"js/jquery.validate.min.js\"></script>\n");
      out.write("\t<script src=\"js/mail-script.js\"></script>\n");
      out.write("   <!-- counter js -->\n");
      out.write("   <script src=\"js/jquery.counterup.min.js\"></script>\n");
      out.write("   <script src=\"js/waypoints.min.js\"></script>\n");
      out.write("   <!-- custom js -->\n");
      out.write("   <script src=\"js/custom.js\"></script>\n");
      out.write("<script src=\"js/archivo.js\"> </script>        \n");
      out.write("       \n");
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
