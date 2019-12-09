/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasControlador;

import TemasDAO.InformeDAO;
import TemasVO.InformeVO;
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
@WebServlet(name = "Controlador_Informe", urlPatterns = {"/Informe"})
public class Controlador_Informe extends HttpServlet {

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
         String id_informe = request.getParameter("txtInforme");
         String idf_asamblea = request.getParameter("select");
         String nombre_informe = request.getParameter("txtnombre_Informe");
         String redactor_informe = request.getParameter("txtredactor_Informe");
         String fecha_informe = request.getParameter("txtfecha_Informe");
         String estado_informe = request.getParameter("txtestado");
         
         
         InformeVO infVO = new InformeVO (id_informe,idf_asamblea,nombre_informe,redactor_informe,
         fecha_informe,estado_informe);
         InformeDAO infDAO = new InformeDAO(infVO);
           switch(opcion)
        {
               case 1:
                if (infDAO.agregarRegistro()) {
                    
                    request.setAttribute("mensajeExito", "<script>alert('¡El informe se Registro correctamete')</script>");
                    request.getRequestDispatcher("registrar_acta.jsp").forward(request, response);
                }
                else
                {
                    request.setAttribute("mensajeError", "<script>alert('¡El informe no pudo ser Registrado correctamete')</script>");
                    request.getRequestDispatcher("registrar_informe.jsp").forward(request, response);

                }
                
                
                break;
                
                case 2: // consultar
                InformeVO inVO = InformeDAO.consultarId(id_informe);
                if (inVO != null) {
                    request.setAttribute("voLLeno", inVO);
                    request.getRequestDispatcher("actualizar_informe.jsp").forward(request, response);
                    
                }else{
                    request.setAttribute("mensajeError", "El informe no  "
                            + "existe");
                    request.getRequestDispatcher("consultar_informe.jsp").forward(request, response);
                }
            break;
            
            case 3: // Eliminar Registro
                if (infDAO.EliminarRegistro()) {
                    request.setAttribute("mensajeExito", "El informe se "
                            + "elimino correctamente");
                }else{
                    request.setAttribute("mensajeError", "El informe no se "
                            + "elimino correctamente");
                }
                request.getRequestDispatcher("eliminar_informe.jsp").forward(request, response);
                break;
                
             case 4: // actualizar Registro
                if (infDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El informe se "
                            + "actualizo correctamente");
                }else{
                    request.setAttribute("mensajeError", "El informe no se "
                            + "actualizo correctamente");
                }
                request.getRequestDispatcher("consultar_informe.jsp").forward(request, response);
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
