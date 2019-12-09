<%-- 
    Document   : registrar_usuario
    Created on : 20/08/2019, 09:59:21 AM
    Author     : mp4ma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
        <link rel="stylesheet" href="estiloregistrarusuario.css">
        <meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
        <title>Registrar Usuario</title>

    </head>

    <body>       
        <form class="formulario" method="post" action="Usuario">
            <h1>Registrate</h1>
            <div class="contenedor">

                <div class="input-contenedor">
                    <i class="fas fa-user icon"></i>
                    <input type="text" name="textcelId" placeholder="Cedula">
                    <br>
                </div>


                
                
              



                <div class="input-contenedor">
                    <i class="fas fa-key icon"></i>
                    <input type="password" name="textpasswordusu" placeholder="Contraseña" >
                </div>

                <button class="button">Registrar</button>
                <input type="hidden" name="opcion" value="1">
                <br>
                <p>Al registrarte, aceptas nuestras Condiciones de uso y Política de privacidad.</p>
                <p>¿Ya tienes una cuenta?<a class="link" href="InicioSesion.jsp">Iniciar Sesion</a></p>
            </div>
        </form>

        <div style="color: red">
            <%if (request.getAttribute("MensajeExito") != null) {%>
            ${MensajeExito}
            <%} else {%>
        </div>
        <div style ="color: blue">

            ${MensajeError}
            <%}%>
        </div>  
    </body>
</html>
