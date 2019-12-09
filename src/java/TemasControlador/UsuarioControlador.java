/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasControlador;

import TemasDAO.UsuarioDAO;
import TemasVO.UsuarioVO;
import static com.sun.codemodel.JOp.mod;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mp4ma
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario"})
public class UsuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
          int opcion = Integer.parseInt(request.getParameter("opcion"));
         String cel_usu = request.getParameter("textcelId");
         String tipo_usu = request.getParameter("texttipousu");
         String password_usu = request.getParameter("textpasswordusu");
         String estado_usu = request.getParameter("textEstado");
            
         
            UsuarioVO usuVO = new UsuarioVO(cel_usu, tipo_usu, password_usu, estado_usu);
         UsuarioDAO usuDAO = new UsuarioDAO(usuVO);
         
          
        switch(opcion){

            case 1://agregar registro
                if (usuDAO.agregarRegistro()) {
                    request.setAttribute("MensajeExito", "<script>alert('¡El usuario se reguistró corectamente!')</script>");
                    
                }else{
                  request.setAttribute("MensajeError", "<script>alert('¡El usuario NO pudo ser registrado correctamente!')</script>");
                }
                request.getRequestDispatcher("registrar_usuario.jsp").forward(request, response);
                
                break;
                
                 case 3://Validar ingreso
                
                if (usuDAO.validarIngreso(cel_usu, password_usu)) {
                    
                     HttpSession miSession = request.getSession(true);
                    UsuarioVO session = UsuarioDAO.sesion(cel_usu);
                    miSession.setAttribute("usuario", session);
                    request.getRequestDispatcher("Estilofin.jsp").forward(request, response);
                }else{
                    request.setAttribute("mensajeError", "<script>alert('El usuaario y/o contraseña incorrectos')</script>");
                    request.getRequestDispatcher("InicioSesion.jsp").forward(request, response);
                }
                break;
                
                case 2: // consulta
                UsuarioVO uvo = usuDAO.consultarId(cel_usu);

                if (uvo != null) {
                    request.setAttribute("volleno", uvo);
                    

                } else {
                    request.setAttribute("mensajeError", "El usuario NO existe:¡ "+cel_usu+"!");
                    request.getRequestDispatcher("contraseña1.jsp").forward(request, response);

                }
                request.getRequestDispatcher("contraseña.jsp").forward(request, response);
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
