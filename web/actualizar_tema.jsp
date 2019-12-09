<%-- 
    Document   : actualizar_tema
    Created on : 28/08/2019, 01:17:26 AM
    Author     : Mateo Coronado
--%>
<%@page import="TemasVO.TemasVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
     <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <title>Tema</title>
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
        <h1>Actualizar Tema</h1>
        <form method="post" action="Temas">
            <% 
                TemasVO teVO = (TemasVO)request.getAttribute("voLLeno");
                if(teVO !=null){
                
            %>
            
            <table border="1">
                  <tr>
                      <td>Numero de tema</td>
                      <td><input type="text" name="txtid_tema" value="<%= teVO.getId_Tema()%>" readonly=""></td>
                  </tr>
                  <tr>
                      <td>Numero de asamblea</td>
                      <td><input type="text" name="select" value="<%= teVO.getIdf_Asamblea()%>"></td>
                  </tr>
                  <tr>
                      <td>Descripción</td>
                      <td><input type="text" name="txttema_Asamblea" value="<%= teVO.getTema()%>" pattern="[A-Za-z ]+"  maxlength="300"></td>
                  </tr>
                  <tr>
                                    <td>Estado</td>
                                    <td>
                                        <select name="txtestado" >
                                            <option value="Activo">Activo</option>
                                            <option value="Inactivo">Inactivo</option>
                                        </select>
                                    </td>
                                </tr>
                  
                  
                  
                </table><br>
                <%}%>
                <button>Actualizar</button>
                
                <input type="hidden" name="opcion" value="4">
                
                
        </form><br>
        
        <button>Menu <a href="Estilofin.jsp"</a></button>
        
        <a href="consultar_tema.jsp" value="2">Atras</a>
            
        <div style="color:red;">
        <% 
            if (request.getAttribute("mensajeError")!=null) {%>
                
            ${mensajeError}    
                
                <%}else{%>
                </div>
                <div style="color:green;">
            ${mensajeExito}    
                <%}%>
        </div>    
        
        <%
            //HttpSession miSesion =(HttpSession)request.getSession();
            //UsuarioVO usuVO = (UsuarioVO)miSesion.getAttribute("voLLeno");
        %>
        
        
         
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
