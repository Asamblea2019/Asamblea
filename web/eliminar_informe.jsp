<%-- 
    Document   : consultar_constituyente
    Created on : 27/08/2019, 01:02:20 AM
    Author     : Mateo Coronado
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="TemasDAO.InformeDAO"%>
<%@page import="TemasVO.InformeVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <title>Informe</title>
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
        <header class="main_menu home_menu">
      <div class="container">
         <div class="row">
            <div class="col-lg-12">
               <nav class="navbar navbar-expand-lg navbar-light">
                   <a class="navbar-brand" href="index.html"> <img src="img/LogoFinal.png" alt="logo"  width="200px" height="50px"> </a>
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
                              <a class="dropdown-item" href="Registrar_multa.jsp">Registrar Multa</a>                                                            <a class="dropdown-item" href="Registrar_multa.jsp">Registrar Multa</a>
                              <a class="dropdown-item" href="Registrar_informe.jsp">Registrar Informe</a>
                              <a class="dropdown-item" href="registrar_pregunta.jsp">Registrar Pregunta</a>
                              <a class="dropdown-item" href="Registrar_respuesta.jsp">Registrar Respuesta</a>
                              <a class="dropdown-item" href="registrar_tema.jsp">Registrar Tema</a>
                              <a class="dropdown-item" href="registrar_usuario.jsp">Registrar Usuario</a>
                              <a class="dropdown-item" href="registrar_votos.jsp">Registrar Votos</a>

                           </div>
                            <li class="nav-item dropdown">
                           <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                              data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              Actualizar
                           </a>
                           <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                              <a class="dropdown-item" href="actualizar_asamblea.jsp">Actualizar Asamblea</a>
                              <a class="dropdown-item" href="actualizar_constituyente.jsp">Actualizar Constituyente</a>
                              <a class="dropdown-item" href="actualizar_multa.jsp">Actualizar Multa</a>
                              <a class="dropdown-item" href="actualizar_pregunta.jsp">Actualizar Pregunta</a>
                              <a class="dropdown-item" href="actualizar_tema.jsp">Actualizar Tema</a>
                              <a class="dropdown-item" href="actualizar_informe.jsp">Actualizar Informe</a>
                             

                           </div>
                        </li>
                        <li class="nav-item dropdown">
                           <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                              data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              Consultar
                           </a>
                           <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                              <a class="dropdown-item" href="consultar_Asamblea.jsp">Constultar Asamblea</a>
                              <a class="dropdown-item" href="consultar_constituyente.jsp">Constultar Constituyente</a>
                              <a class="dropdown-item" href="consultar_multa.jsp">Constultar Multa</a>
                              <a class="dropdown-item" href="consultar_pregunta.jsp">Constultar Pregunta</a>
                              <a class="dropdown-item" href="consultar_tema.jsp">Constultar Tema</a>
                             

                           </div>
                        </li>
                         <li class="nav-item dropdown">
                           <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                              data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              Eliminar
                           </a>
                           <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                              <a class="dropdown-item" href="eliminar_asamblea.jsp">Eliminar Asamblea</a>
                              <a class="dropdown-item" href="eliminar_constituyente.jsp">Eliminar Constituyente</a>
                              <a class="dropdown-item" href="eliminar_multa.jsp">Eliminar Multa</a>
                              <a class="dropdown-item" href="eliminar_pregunta.jsp">Eliminar Pregunta</a>
                              <a class="dropdown-item" href="eliminar_tema.jsp">Eliminar Tema</a>
                             

                           </div>
                        </li>
                        
                     </ul>
                  </div>
               </nav>
            </div>
         </div>
      </div>
   </header>
        
        <section class="banner_part">
            <div class="container" id="cotainer">
                <div id="Contenedor-form">   
                    
	   <center>
            <h1>Eliminar Informe</h1><br>
            <form method="post" action="Informe">
                <table border="1">
                    <tr>
                        <th>
                            ID INFORME<br><br>
                            <input type="text" name="txtId">
                        </th>
                    </tr>
                </table><br>
                <button class="btn btn-outline-primary">Eliminar</button><br><br>
                <input type="hidden" name="opcion" value="3">
            </form>
            
            <a href="Registrar_Constituyente.jsp">Atrás</a><br><br>
            <a href="../src/java/TemasControlador/ControladorTemas.java"></a>
            
            <form id="Table"> 
                
                <table border="1">
                    <tr>
                        <th>ID INFORME</th>
                        <th>ID ASAMBLEA</th>
                        <th>NOMBRE DE INFORME</th>
                        <th>REDACTOR</th>
                        <th>FECHA</th>
                        
                    </tr>
                    
                    <%
                         InformeVO infVO = new InformeVO();
                        InformeDAO infDAO = new InformeDAO();
                        
                        ArrayList<InformeVO> listaInforme = infDAO.listar();
                        

                        for (int i = 0; i < listaInforme.size(); i++InformeVO) {
                            
                            infVO = listaInforme.get(i);
                    %>
                    
                    <tr>
                        <td><%= infVO.getInId()%></td>
                        <td><%= infVO.getInIdfAsamblea()%></td>
                        <td><%= infVO.getInNombre()%></td>
                        <td><%= infVO.getInRedactor()%></td>
                        <td><%= infVO.getInFecha()%></td>
                    </tr>
                    
                    <%}%>
                    
                </table><br><br>
                    
            </form>
            
                                                                                   
            <div style="color:red;">
            <%if (request.getAttribute("mensajeError")!=null){ %>
              
            
            ${mensajeError}    
                <%}%>
                
            
            </div>
        </center>
                <center>
                    <button type="button" class="btn btn-outline-primary">Menu <a href="Estilofin.jsp"</a></button>
               </center>
               </div>
      </div>
   </section>
   <!--::banner part end::-->
      
    
    
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
<script src="js/archivo.js"> </script>        
       
    </body>
</html>
