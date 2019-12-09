/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasControlador;
import TemasDAO.TemasDAO;
import TemasVO.TemasVO;
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
@WebServlet(name = "ControladorTemas", urlPatterns = {"/Temas"})
public class ControladorTemas extends HttpServlet {

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
         String id_Tema = request.getParameter("txtid_tema");
         String idf_Asamblea = request.getParameter("select");
         String tema = request.getParameter("txttema_Asamblea");
         String estado_Tema = request.getParameter("txtestado");
         
         TemasVO tVO = new TemasVO (id_Tema,idf_Asamblea,tema,estado_Tema);
         TemasDAO tDAO = new TemasDAO(tVO);
           switch(opcion)
        {
               case 1:
                if (tDAO.agregarRegistro()) {
                    
                    request.setAttribute("mensajeExito", "<script>alert('¡El Tema se registro correctamete')</script>");
                     request.getRequestDispatcher("registrar_tema.jsp").forward(request, response);
                    
                }
                else
                {
                    request.setAttribute("mensajeError", "<script>alert('¡El tema no pudo ser registrado correctamete')</script>");
                    request.getRequestDispatcher("registrar_tema.jsp").forward(request, response);
                    
                }
               
                
                break;
                case 2: // consultar
                TemasVO temVO = TemasDAO.consultarId(id_Tema);
                if (temVO != null) {
                    request.setAttribute("voLLeno", temVO);
                    request.getRequestDispatcher("actualizar_tema.jsp").forward(request, response);
                    
                }else{
                    request.setAttribute("mensajeError", "El tema no  "
                            + "existe");
                    request.getRequestDispatcher("consultar_tema.jsp").forward(request, response);
                }
                request.getRequestDispatcher("consultar_tema.jsp").forward(request, response);
            break;
            case 3: // Eliminar Registro
                if (tDAO.EliminarRegistro()) {
                    request.setAttribute("mensajeExito", "El tema se "
                            + "elimino correctamente");
                }else{
                    request.setAttribute("mensajeError", "El tema no se "
                            + "elimino correctamente");
                }
                request.getRequestDispatcher("registrar_tema.jsp").forward(request, response);
                break;
                
                case 4: // actualizar Registro
                if (tDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El tema se "
                            + "actualizo correctamente");
                }else{
                    request.setAttribute("mensajeError", "El tema no se "
                            + "actualizo correctamente");
                }
                request.getRequestDispatcher("actualizar_tema.jsp").forward(request, response);
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
