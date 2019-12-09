/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasControlador;

import TemasDAO.Conteo_VotosDAO;
import TemasVO.Conteo_VotosVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fugo5
 */
@WebServlet(name = "ControladorConteoVotos", urlPatterns = {"/ConteoVotos"})
public class ControladorConteoVotos extends HttpServlet {

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
        
        int opcion = Integer.parseInt(request.getParameter("Opcion"));
        String CONTID = request.getParameter("txtContId");
        String CONTIDFPREGUNTA = request.getParameter("txtContPregunta");
        String CONTTOTAL = request.getParameter("txtContTotal");
        Conteo_VotosVO contVO = new Conteo_VotosVO(CONTID, CONTIDFPREGUNTA, CONTTOTAL);
        Conteo_VotosDAO contDAO = new Conteo_VotosDAO(contVO);
        
        switch(opcion)
        {
               case 1:
                if (contDAO.agregarRegistro()) {
                    
                    request.setAttribute("MensajeExito", "¡El informe se Registro correctamete");
                    request.getRequestDispatcher("registrar_acta.jsp").forward(request, response);
                }
                else
                {
                    request.setAttribute("MensajeError", "¡El informe no se registro correctamete");
                    request.getRequestDispatcher("registrar_informe.jsp").forward(request, response);
                }
                
                
                break;
                
                case 2: // consultar
                Conteo_VotosVO concVO = Conteo_VotosDAO.consultarId(CONTID);
                if (concVO != null) {
                    request.setAttribute("voLLeno", concVO);
                    request.getRequestDispatcher("actualizar_informe.jsp").forward(request, response);
                    
                }else{
                    request.setAttribute("mensajeError", "El informe no  "
                            + "existe");
                    request.getRequestDispatcher("consultar_informe.jsp").forward(request, response);
                }
            break;
            
            case 3: // Eliminar Registro
                if (contDAO.EliminarRegistro()) {
                    request.setAttribute("mensajeExito", "El informe se "
                            + "elimino correctamente");
                }else{
                    request.setAttribute("mensajeError", "El informe no se "
                            + "elimino correctamente");
                }
                request.getRequestDispatcher("eliminar_informe.jsp").forward(request, response);
                break;
                
             case 4: // actualizar Registro
                if (contDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El informe se "
                            + "actualizo correctamente");
                }else{
                    request.setAttribute("mensajeError", "El informe no se "
                            + "actualizo correctamente");
                }
                request.getRequestDispatcher("actualizar_informe.jsp").forward(request, response);
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
