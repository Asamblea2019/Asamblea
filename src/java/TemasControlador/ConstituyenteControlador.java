/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasControlador;
import TemasDAO.ConstituyenteDAO;
import TemasDAO.UsuarioDAO;
import TemasVO.ConstituyenteVO;
import TemasVO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian
 */
@WebServlet(name = "ControladorTemas", urlPatterns = {"/Constituyente"})
public class ConstituyenteControlador extends HttpServlet {

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
         String cedula_Constituyente = request.getParameter("select");
         String cedulaf_Usuario = request.getParameter("select");
         String nombre_Constituyete = request.getParameter("txtnombre_Constituyete");
         String apellido_Constituyente = request.getParameter("txtapellido_Constituyente");
         String correo_Constituyente = request.getParameter("txtcorreo_Constituyente");
         String cel_Constituyente = request.getParameter("txtcel_Constituyente");
         String estado_Constituyente = request.getParameter("txtestado");
          String poder = request.getParameter("txtpoder");
         
         String cel_usu = request.getParameter("select");
         String tipo_usu = request.getParameter("texttipousu");
         String password_usu = request.getParameter("textpasswordusu");
         String estado_usu = "Activo";
         


         
         ConstituyenteVO tVO = new ConstituyenteVO (cedula_Constituyente,cedulaf_Usuario,nombre_Constituyete,apellido_Constituyente,
         correo_Constituyente,cel_Constituyente,estado_Constituyente,poder);
         ConstituyenteDAO tDAO = new ConstituyenteDAO(tVO);
         
         UsuarioVO usuVO = new UsuarioVO(cel_usu, tipo_usu, password_usu, estado_usu);
         UsuarioDAO usuDAO = new UsuarioDAO(usuVO);
           switch(opcion)
        {
               case 1:
                if (tDAO.agregarRegistro() && usuDAO.actualizarestado()) {
                    
                    request.setAttribute("mensajeExito", "<script>alert('¡El constituyente se Registro correctamete')</script>");
                    request.getRequestDispatcher("registrar_resi.jsp").forward(request, response);
                }
                else
                {
                    request.setAttribute("mensajeError", "<script>alert('¡El constituyente no pudo ser Registrado correctamete')</script>");
                    request.getRequestDispatcher("Registrar_Constituyente.jsp").forward(request, response);

                }
                   
                
                break;
                
                case 2: // consultar
                ConstituyenteVO constVO = ConstituyenteDAO.consultarId(cedula_Constituyente);
                if (constVO != null) {
                    request.setAttribute("voLLeno", constVO);
                    request.getRequestDispatcher("actualizar_constituyente.jsp").forward(request, response);
                    
                }else{
                    request.setAttribute("mensajeError", "El constituyente no  "
                            + "existe");
                    request.getRequestDispatcher("consultar_constituyente.jsp").forward(request, response);
                }
            break;
            
            case 3: // Eliminar Registro
                if (tDAO.EliminarRegistro()) {
                    request.setAttribute("mensajeExito", "El constituyente se "
                            + "elimino correctamente");
                }else{
                    request.setAttribute("mensajeError", "El constituyente no se "
                            + "elimino correctamente");
                }
                request.getRequestDispatcher("eliminar_constituyente.jsp").forward(request, response);
                break;
                
             case 4: // actualizar Registro
                if (tDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El constituyente se "
                            + "actualizo correctamente");
                }else{
                    request.setAttribute("mensajeError", "El constituyente no se "
                            + "actualizo correctamente");
                }
                request.getRequestDispatcher("actualizar_constituyente.jsp").forward(request, response);
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
