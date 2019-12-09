/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasControlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import TemasDAO.PreguntaDAO;
import TemasVO.PreguntaVO;

/**
 *
 * @author Mateo Coronado
 */
@WebServlet(name = "Controlador_Pregunta", urlPatterns = {"/Pregunta"})
public class Controlador_Pregunta extends HttpServlet {

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
         String id_pregunta = request.getParameter("txtid_Pregunta");
         String idf_votacion = request.getParameter("select");
         String pregunta = request.getParameter("txtPregunta");
         String estado_pregunta = request.getParameter("txtestado");
         
         PreguntaVO preVO = new PreguntaVO(id_pregunta, idf_votacion, pregunta,estado_pregunta);
         PreguntaDAO preDAO = new PreguntaDAO(preVO);
           switch(opcion)
        {
               case 1:
                if (preDAO.agregarRegistro()) {
                    
                    request.setAttribute("mensajeExito", "<script>alert('¡La pregunta se Agrego correctamete')</script>");
                    request.getRequestDispatcher("registrar_pregunta.jsp").forward(request, response);
                }
                else
                {
                    request.setAttribute("mensajeError", "<script>alert('¡La pregunta no pudo ser agregada correctamete')</script>");
                    request.getRequestDispatcher("registrar_pregunta.jsp").forward(request, response);
                }
                
                
                break;
                case 2: // consultar
                PreguntaVO pVO = PreguntaDAO.consultarId(id_pregunta);
                if (pVO != null) {
                    request.setAttribute("voLLeno", pVO);
                    request.getRequestDispatcher("actualizar_pregunta.jsp").forward(request, response);
                    
                }else{
                    request.setAttribute("mensajeError", "La pregunta no  "
                            + "existe");
                    request.getRequestDispatcher("consultar_pregunta.jsp").forward(request, response);
                }
            break;
            case 3: // Eliminar Registro
                if (preDAO.EliminarRegistro()) {
                    request.setAttribute("mensajeExito", "La pregunta se "
                            + "elimino correctamente");
                }else{
                    request.setAttribute("mensajeError", "La pregunta no se "
                            + "elimino correctamente");
                }
                request.getRequestDispatcher("Registrar_pregunta.jsp").forward(request, response);
                break;
                
                case 4: // actualizar Registro
                if (preDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "La pregunta se "
                            + "actualizo correctamente");
                }else{
                    request.setAttribute("mensajeError", "La pregunta no se "
                            + "actualizo correctamente");
                }
                request.getRequestDispatcher("actualizar_pregunta.jsp").forward(request, response);
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
