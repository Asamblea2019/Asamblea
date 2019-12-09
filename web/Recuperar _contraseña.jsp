<%-- 
    Document   : Recuperar contraseña
    Created on : 28/09/2019, 10:42:11 AM
    Author     : mp4ma
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="TemasDAO.UsuarioDAO"%>
<%@page import="TemasVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <title>Asamblea</title>
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
    
    <div class="container" >
        
         
         <div id="Contenedor-form">  
	
    <body>
    <center>
        
      <form method="post" action="Recuperar">
              
             
            </form>
        
            
            
            <form>
                <table border="1">
                    <tr>
                        <th>Cedula</th>
                        <th> Tipo Usuario</th>
                        <th>Contraseña</th>
                        
                        
                    </tr>
                    
                    <%
                        UsuarioVO usuvo = new UsuarioVO();
                        UsuarioDAO asmDAO = new UsuarioDAO();
                        
                        ArrayList<UsuarioVO> listaUsuario = asmDAO.listar();
                        

                        for (int i = 0; i < listaUsuario.size(); i++) {
                            
                            usuvo = listaUsuario.get(i);
                    %>
                    
                    <tr>
                        <td><%= usuvo.getCel_usu()%></td>
                        <td><%= usuvo.getTipo_usu()%></td>
                        <td><%= usuvo.getPassword_usu()%></td>
                       
                    </tr>
                    
                    <%}%>
                    
                </table><br> 
            </form>
           

        
         <div style="color: red">
            <%if (request.getAttribute("MensajeExito") != null) {%>
            ${MensajeExito}
            <%}%>
         </div>
         <a href="registrar_usuario.jsp">Atrás</a><br>
            <a href="../src/java/TemasControlador/ControladorTemas.java"></a><br>
             </center>
    </body>
</html>
