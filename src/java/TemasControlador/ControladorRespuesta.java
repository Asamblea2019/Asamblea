/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasControlador;

import TemasDAO.PreguntaDAO;
import TemasDAO.RespuestaDAO;
import TemasVO.PreguntaVO;
import TemasVO.RespuestaVO;
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
@WebServlet(name = "ControladorRespuesta", urlPatterns = {"/Respuesta"})
public class ControladorRespuesta extends HttpServlet {

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
        String RESID = request.getParameter("txtResId");
        String RESIDFPREGUNTA = request.getParameter("id_pregunta");
        String RESRESPUESTA = request.getParameter("resupesta");
        String RESESTADO = request.getParameter("txtResEstado");
        RespuestaVO resVO = new RespuestaVO(RESID, RESIDFPREGUNTA, RESRESPUESTA, RESESTADO);
        RespuestaDAO resDAO = new RespuestaDAO(resVO);
        
        String id_pregunta = request.getParameter("id_pregunta");
         String idf_votacion = request.getParameter("select");
         String pregunta = request.getParameter("txtPregunta");
         String estado_pregunta = request.getParameter("txtestado");
         
         PreguntaVO preVO = new PreguntaVO(id_pregunta, idf_votacion, pregunta,estado_pregunta);
         PreguntaDAO preDAO = new PreguntaDAO(preVO);
        
         switch(opcion)
        {
               case 1:
                if (resDAO.agregarRegistro()&& preDAO.actualizarEsta()) {
                    
                    request.setAttribute("mensajeExito", "<script>alert('¡El voto se registro correctamete')</script>");
                    request.getRequestDispatcher("tema.jsp").forward(request, response);
                }
                else
                {
                    request.setAttribute("mensajeError", "<script>alert('¡El voto no pudo ser Registrado correctamete')</script>");
                    request.getRequestDispatcher("tema.jsp").forward(request, response);

                }
                
                
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
