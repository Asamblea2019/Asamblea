/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasControlador;

import TemasDAO.AsambleaDAO;
import TemasVO.AsambleaVO;
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
@WebServlet(name = "Controlador_Asamblea", urlPatterns = {"/Asamblea"})
public class Controlador_Asamblea extends HttpServlet {

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
        String id_Asamblea = request.getParameter("id_Asamblea");
        String tipo_Asamblea = request.getParameter("tipo_Asamblea");
        String fecha_Asamblea = request.getParameter("fecha_Asamblea");
        String descripcion_Asamblea = request.getParameter("descripcion_Asamblea");
        String estado_Asamblea = request.getParameter("estado_Asamblea");

        AsambleaVO asaVO = new AsambleaVO(id_Asamblea, tipo_Asamblea, fecha_Asamblea,descripcion_Asamblea,estado_Asamblea);
        AsambleaDAO asaDAO = new AsambleaDAO(asaVO);

        switch (opcion) {
            case 1: //Agregar Registro
                if (asaDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "<script>alert('¡La asamblea se registro correctamente!')</script>");
                    request.getRequestDispatcher("registrar_tema.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "<script>alert('¡La asamblea NO pudo ser registrada correctamente!')</script>");
                    request.getRequestDispatcher("Registrar_asamblea.jsp").forward(request, response);
                }
                
                break;
                
                case 2: // consultar
                AsambleaVO asmVO = AsambleaDAO.consultarId(id_Asamblea);
                if (asmVO != null) {
                    request.setAttribute("voLLeno", asmVO);
                    request.getRequestDispatcher("actualizar_asamblea.jsp").forward(request, response);
                    
                }else{
                    request.setAttribute("mensajeError", "La asamblea no  "
                            + "existe");
                    request.getRequestDispatcher("consultar_Asamblea.jsp").forward(request, response);
                }
            break;
            
            case 3: // Eliminar Registro
                if (asaDAO.EliminarRegistro()) {
                    request.setAttribute("mensajeExito", "La asamblea se "
                            + "elimino correctamente");
                }else{
                    request.setAttribute("mensajeError", "La asamblea no se "
                            + "elimino correctamente");
                }
                request.getRequestDispatcher("Registrar_Asamblea.jsp").forward(request, response);
                break;
                
             case 4: // actualizar Registro
                if (asaDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "La asamblea se "
                            + "actualizo correctamente");
                }else{
                    request.setAttribute("mensajeError", "La asamblea no se "
                            + "actualizo correctamente");
                }
                request.getRequestDispatcher("actualizar_asamblea.jsp").forward(request, response);
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
