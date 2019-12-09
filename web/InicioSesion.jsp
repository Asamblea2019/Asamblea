<%-- 
    Document   : InicioSesion
    Created on : 22/08/2019, 02:56:41 PM
    Author     : mp4ma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesion</title>
        <link rel="stylesheet" href="estiloiniciosesion.css">
        <link rel="stylesheet" href="css/style.css">
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

    
    </head>
    <body>
    <section class="banner_part">
      <div class="container">
        <div class="contenedor" >
            
            <div class="login" >
                <article class="fondo">
                   
                    <form class="fondo2" method="post" action="Usuario">
                        <h3>Inicio de Sesión</h3><br><br>
                        <img src="img/LogoFinal.png" alt="Usuario"><br><br>
                        <input class="Diseño" type="text" placeholder="Cedula" name="textcelId">
                        <input class="Diseño" type="password" placeholder="Contraseña" name="textpasswordusu">
                        <br>
                     
                        <input class="boton" type="submit" name="inicio" value="Iniciar sesión">
            <input type="hidden" name="opcion" value="3">
            
        </form>
                    <a href="contraseña1.jsp"> recuperar contraseña</a>
          </article>
         <div style="color: red">
            <%if (request.getAttribute("MensajeExito") != null) {%>
            ${MensajeExito}
            <%}%>
            
         </div>
         </div>
         </div>
             </div>
   </section>
  
    </body>
</html>
