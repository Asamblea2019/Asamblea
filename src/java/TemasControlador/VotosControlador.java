/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasControlador;


import TemasDAO.VotosDAO;

import TemasVO.VotosVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mp4ma
 */
@WebServlet(name = "VotosControlador", urlPatterns = {"/Votos"})
public class VotosControlador extends HttpServlet {

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
         String id_votacion = request.getParameter("textId_Votacion");
         String idf_tema = request.getParameter("select");
         String tipo_votacion = request.getParameter("texttipo_Votacion");
         String estado_votacion = request.getParameter("txtestado");
            
         VotosVO votosVO = new VotosVO(id_votacion, idf_tema, tipo_votacion,estado_votacion);
        VotosDAO votosDAO = new VotosDAO(votosVO);
         
        
              switch(opcion){

            case 1://agregar registro
                if (votosDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "<script>alert('¡¡El voto se registró corectamente!')</script>");
                    request.getRequestDispatcher("registrar_votos.jsp").forward(request, response);
                }else{
                  request.setAttribute("mensajeError", "<script>alert('¡¡El voto NO pudo ser registrado correctamente!')</script>");
                  request.getRequestDispatcher("registrar_votos.jsp").forward(request, response);
                }
                
                break;
              
              case 2: // consultar
                VotosVO tmVO = VotosDAO.consultarId(id_votacion);
                if (tmVO != null) {
                    request.setAttribute("voLLeno", tmVO);
                    request.getRequestDispatcher("registrar_pregunta.jsp").forward(request, response);
                    
                }else{
                    request.setAttribute("mensajeError", "La pregunta no  "
                            + "existe");
                    request.getRequestDispatcher("consultar_pregunta.jsp").forward(request, response);
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
