<%@page import="TemasDAO.AsistenciaDAO"%>
<%@page import="TemasVO.AsistenciaVO"%>
<%@page import="TemasDAO.AsambleaDAO"%>
<%@page import="TemasVO.AsambleaVO"%>
<%@page import="TemasDAO.ConstituyenteDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="TemasVO.ConstituyenteVO"%>
<%-- 
    Document   : Registrar_asamblea
    Created on : 15-ago-2019, 15:53:29
    Author     : APRENDIZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Multa</title>
        <link rel="icon" href="img/LOGO1.jpg">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- animate CSS -->
        <link rel="stylesheet" href="css/animate.css">
        <!-- owl carousel CSS -->
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <!-- themify CSS -->
        <link rel="stylesheet" href="css/themify-icons.css">
        <!-- flaticon CSS -->
        <link rel="stylesheet" href="css/flaticon.css">
        <!-- magnific-popup CSS -->
        <link rel="stylesheet" href="css/magnific-popup.css">
        <!-- font awesome CSS -->
        <link rel="stylesheet" href="fontawesome/css/all.min.css">
        <!-- style CSS -->
        <link rel="stylesheet" href="css/style.css">
        <link href="css/estilo1.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <!--::menu part start::-->
        <header class="main_menu home_menu">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <nav class="navbar navbar-expand-lg navbar-light">
                            <a class="navbar-brand" href="InicioSesion.jsp"> <img src="img/LogoFinal.png" alt="logo"  width="200px" height="50px"> </a>
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse main-menu-item" id="navbarNav">
                                <ul class="navbar-nav">
                                     <li class="nav-item dropdown">
                           <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                              data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              Registrar
                           </a>
                           <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                              <a class="dropdown-item" href="Registrar_asamblea.jsp">Registrar Asamblea</a>
                              <a class="dropdown-item" href="Registrar_Constituyente.jsp">Registrar Constituyente</a>
                              <a class="dropdown-item" href="Registrar_multa.jsp">Registrar Multa</a>
                              <a class="dropdown-item" href="registrar_pregunta.jsp">Registrar Pregunta</a>
                              <a class="dropdown-item" href="registrar_tema.jsp">Registrar Tema</a>
                              <a class="dropdown-item" href="registrar_usuario.jsp">Registrar Usuario</a>
                              <a class="dropdown-item" href="registrar_informe.jsp">Registrar Informe</a>
                              <a class="dropdown-item" href="registrar_acta.jsp">Registrar Acta</a>
                              <a class="dropdown-item" href="respuesta.jsp">Registrar Respuesta</a>
                              <a class="dropdown-item" href="registrar_asistencia.jsp">Registrar Asistencia</a>
                              <a class="dropdown-item" href="registrar_votos.jsp">Registrar Votos</a>

                           </div>
                        </li>
                         
                        <li class="nav-item dropdown">
                           <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                              data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              Consultar
                           </a>
                           <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                              <a class="dropdown-item" href="consultar_Asamblea.jsp">Consultar Asamblea</a>
                              <a class="dropdown-item" href="consultar_constituyente.jsp">Consultar Constituyente</a>
                              <a class="dropdown-item" href="consultar_multa.jsp">Consultar Multa</a>
                              <a class="dropdown-item" href="consultar_pregunta.jsp">Consultar Pregunta</a>
                              <a class="dropdown-item" href="consultar_acta.jsp">Consultar Acta</a>
                              <a class="dropdown-item" href="consultar_asistencia.jsp">Consultar Asistencia</a>
                              <a class="dropdown-item" href="consultar_informe.jsp">Consultar Informe</a>
                              <a class="dropdown-item" href="consultar_tema.jsp">Consultar Tema</a>
                              
                              
                              <a class="dropdown-item" href="Recuperar _contraseña.jsp">Consultar Usuario</a>

                             

                           </div>
                        </li>
                        <form method="post" action="Estilofin.jsp">
                            
                        <li class="nav-item dropdown">
                           <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                              data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              Perfil
                           </a>
                           <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                               <a class="dropdown-item" href="InicioSesion.jsp" name="Salir" <%session.invalidate();%>>Cerrar Sesion</a>
                            
                           </div>
                        </li>
                        </form>

                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </header>

        <section class="banner_part">
            <div class="container">
                <div id="Contenedor-form">   


                    <center>

                        <H1>Registro De Multa</H1>

                        <form method="post" action="Multa" class="needs-validation" novalidate="">


                            <label>Asistencia</label>
                        <select name="txtIdfAsistencia" class="form-control" >
                            <%
                                AsistenciaVO asiVO = new AsistenciaVO();
                                AsistenciaDAO asiDAO = new AsistenciaDAO();

                                ArrayList<AsistenciaVO> listaAsistencia = asiDAO.listar();

                                for (int i = 0; i < listaAsistencia.size(); i++) {

                                    asiVO = listaAsistencia.get(i);
                            %>

                            <option value="<%= asiVO.getId_asistencia()%>"><%= asiVO.getCedulaf_Constituyente()%></option>

                            <%}%>






                        </select>
                            

                            <label>NOMBRE</label><br>
                            <select name="select" class="form-control"  >
                                <%
                                    ConstituyenteVO consVO = new ConstituyenteVO();
                                    ConstituyenteDAO consDAO = new ConstituyenteDAO();

                                    ArrayList<ConstituyenteVO> listaCONS = consDAO.listar();

                                    for (int i = 0; i < listaCONS.size(); i++) {

                                        consVO = listaCONS.get(i);
                                %>

                                <option value="<%= consVO.getCedulaf_Usuario()%>"><%= consVO.getNombre_Constituyete()%> <%= consVO.getApellido_Constituyente()%></option>

                                <%}%>






                            </select>
                            <br>

                            <div id="Contenedor">  
                                <label for="validationCustom01">DESCRIPCIÓN MULTA</label><br>
                                <textarea class="form-control"  id="validationCustom01" rows="3" style="height: 150px" name="txtDescripcionMulta" required="" pattern="[A-Za-z ]+"  maxlength="125"></textarea>         
                            </div>


                            <label for="validationCustom02">PAGO MULTA</label><br>
                            <input type="number" id="validationCustom02" class="form-control" placeholder="1,000,000" name="txtPagoMulta" required=""><br>




                            <label for="validationCustom03">FECHA MULTA</label><br>
                            <input class="form-control" id="validationCustom03" type="DATE" name="datfecha_multa" required=""><br>
                            <label for="validationCustom04">FECHA PAGO</label><br>
                            <input class="form-control" id="validationCustom04" type="date" name="datfecha_pago" required=""><br>        
                            <div id="Botones" style="width: 100%; float: left;">
                                <div>
                                    <button  class="btn btn-outline-primary">Registrar</button></div><br>
                                <input type="hidden" name="opcion" value="1">
                            </div><br><br>
                        </form> 


                        <div id="Botones">

                            <button type="button" class="btn btn-outline-primary">Menu <a href="Estilofin.jsp"</a></button>       
                        </div>
                    </center>







                </div>
            </div>
        </section>
        <!--::banner part end::-->

        <%
            if (request.getAttribute("mensajeError") != null) {
        %>
        ${mensajeError}
        <%    } else if (request.getAttribute("mensajeExito") != null) {%>
        ${mensajeExito}
        <%  }%>


        <!-- jquery plugins here-->
        <script src="js/jquery-1.12.1.min.js"></script>
        <!-- popper js -->
        <script src="js/popper.min.js"></script>
        <!-- bootstrap js -->
        <script src="js/bootstrap.min.js"></script>
        <!-- magnific js -->
        <script src="js/jquery.magnific-popup.min.js"></script>
        <!-- carousel js -->
        <script src="js/owl.carousel.min.js"></script>
        <!-- easing js -->
        <script src="js/jquery.easing.min.js"></script>
        <!--masonry js-->
        <script src="js/masonry.pkgd.min.js"></script>
        <script src="js/masonry.pkgd.js"></script>
        <!--form validation js-->
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/contact.js"></script>
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="js/jquery.form.js"></script>
        <script src="js/jquery.validate.min.js"></script>
        <script src="js/mail-script.js"></script>
        <!-- counter js -->
        <script src="js/jquery.counterup.min.js"></script>
        <script src="js/waypoints.min.js"></script>
        <!-- custom js -->
        <script src="js/custom.js"></script>
        <script src="js/archivo.js"></script>
    </body>

</html>