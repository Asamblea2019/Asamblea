/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasControlador;

import TemasDAO.ActaDAO;
import TemasVO.ActaVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "Controlador_Acta", urlPatterns = {"/Acta"})
public class Controlador_Acta extends HttpServlet {

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
         String id_acta = request.getParameter("txtid_acta");
         String idf_informe = request.getParameter("select");
         String descripcion_acta = request.getParameter("txtdescripcion_acta");
         String registro_acta = request.getParameter("txtregistro_acta");
         String fecha_acta = request.getParameter("txtfecha_acta");
         String estado_acta = request.getParameter("txtestado");
    
    
    ActaVO actVO = new ActaVO (id_acta,idf_informe,descripcion_acta,registro_acta,fecha_acta,estado_acta);
         ActaDAO actDAO = new ActaDAO(actVO);
         
           switch(opcion)
        {
               case 1:
                if (actDAO.agregarRegistro()) {
                    
                    request.setAttribute("mensajeExito", "<script>alert('¡El acta se Registro correctamete')</script>");
                    request.getRequestDispatcher("consultar_acta.jsp").forward(request, response);
                }
                else
                {
                    request.setAttribute("mensajeError", "<script>alert('¡El acta no pudo ser Registrada correctamete')</script>");
                    request.getRequestDispatcher("Registrar_acta.jsp").forward(request, response);

                }
                
                
                break;
                
                case 2: // consultar
                ActaVO acVO = ActaDAO.consultarId(id_acta);
                if (acVO != null) {
                    request.setAttribute("voLLeno", acVO);
                    request.getRequestDispatcher("actualizar_informe.jsp").forward(request, response);
                    
                }else{
                    request.setAttribute("mensajeError", "El acta no  "
                            + "existe");
                    request.getRequestDispatcher("consultar_acta.jsp").forward(request, response);
                }
            break;
            
            case 3: // Eliminar Registro
                if (actDAO.EliminarRegistro()) {
                    request.setAttribute("mensajeExito", "El acta se "
                            + "elimino correctamente");
                }else{
                    request.setAttribute("mensajeError", "El acta no se "
                            + "elimino correctamente");
                }
                request.getRequestDispatcher("eliminar_acta.jsp").forward(request, response);
                break;
                
             case 4: // actualizar Registro
                if (actDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El acta se "
                            + "actualizo correctamente");
                }else{
                    request.setAttribute("mensajeError", "El acta no se "
                            + "actualizo correctamente");
                }
                request.getRequestDispatcher("actualizar_acta.jsp").forward(request, response);
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
    


