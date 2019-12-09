/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasControlador;

import TemasDAO.ResidenciaDAO;
import TemasVO.ResidenciaVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "Controlador_Resi", urlPatterns = {"/Resi"})
public class Controlador_Resi extends HttpServlet {

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
         String id_Resi = request.getParameter("id_resi");
         String cedulaf_constituyente = request.getParameter("select");
         String apartamento = request.getParameter("apartamento");
         String estado_resi = request.getParameter("estado");
         
         ResidenciaVO resiVO = new ResidenciaVO(id_Resi, cedulaf_constituyente, apartamento, estado_resi);
         ResidenciaDAO resiDAO = new ResidenciaDAO(resiVO);
         
         switch(opcion)
        {
               case 1:
                if (resiDAO.agregarRegistro()) {
                    
                    request.setAttribute("mensajeExito", "<script>alert('¡La residencia se registro correctamete')</script>");
                     request.getRequestDispatcher("registrar_resi.jsp").forward(request, response);
                    
                }
                else
                {
                    request.setAttribute("mensajeError", "<script>alert('¡La residencia no pudo ser registrado correctamete')</script>");
                    request.getRequestDispatcher("registrar_resi.jsp").forward(request, response);
                    
                }
               
                
                break;
                case 2: // consultar
                ResidenciaVO resVO = ResidenciaDAO.consultarId(id_Resi);
                if (resVO != null) {
                    request.setAttribute("voLLeno", resVO);
                    request.getRequestDispatcher("actualizar_resi.jsp").forward(request, response);
                    
                }else{
                    request.setAttribute("mensajeError", "La residencia no  "
                            + "existe");
                    request.getRequestDispatcher("consultar_resi.jsp").forward(request, response);
                }
                request.getRequestDispatcher("consultar_resi.jsp").forward(request, response);
            break;
           
                
                case 4: // actualizar Registro
                if (resiDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "La residencia se "
                            + "actualizo correctamente");
                }else{
                    request.setAttribute("mensajeError", "La residencia no se "
                            + "actualizo correctamente");
                }
                request.getRequestDispatcher("actualizar_resi.jsp").forward(request, response);
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
