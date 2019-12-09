/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasControlador;

import TemasDAO.MultaDAO;
import TemasVO.MultaVO;
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
@WebServlet(name = "Controlador_Multa", urlPatterns = {"/Multa"})
public class Controlador_Multa extends HttpServlet {

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
         String id_multa = request.getParameter("txtIdMulta");
        String idf_asistencia = request.getParameter("txtIdfAsistencia");
        String cedulaf_constituyente = request.getParameter("select");
        String descripcion_multa = request.getParameter("txtDescripcionMulta");
        String pago_multa = request.getParameter("txtPagoMulta");
        String fecha_multa = request.getParameter("datfecha_multa");
        String fecha_pago = request.getParameter("datfecha_pago");
        String estado_multa = request.getParameter("txtestado");
        

        MultaVO mulVO = new MultaVO(id_multa, idf_asistencia, cedulaf_constituyente,descripcion_multa, pago_multa, fecha_multa, fecha_pago,estado_multa);
        MultaDAO mulDAO = new MultaDAO(mulVO);

        switch (opcion) {
            case 1: //Agregar Registro
                if (mulDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "<script>alert('La multa se registró correctamente!')</script>");
                    request.getRequestDispatcher("Registrar_multa.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "<script>alert('La multa NO pudo ser registrado correctamente!')</script>");
                    request.getRequestDispatcher("Registrar_multa.jsp").forward(request, response);
                }
                
                break;
                
             case 2: // consultar
                MultaVO multVO = MultaDAO.consultarId(id_multa);
                if (multVO != null) {
                    request.setAttribute("voLLeno", multVO);
                    request.getRequestDispatcher("actualizar_multa.jsp").forward(request, response);
                    
                }else{
                    request.setAttribute("mensajeError", "La multa no  "
                            + "existe");
                    request.getRequestDispatcher("consultar_multa.jsp").forward(request, response);
                }
            break;
            case 3: // Eliminar Registro
                if (mulDAO.EliminarRegistro()) {
                    request.setAttribute("mensajeExito", "La multa se "
                            + "elimino correctamente");
                }else{
                    request.setAttribute("mensajeError", "La multa no se "
                            + "elimino correctamente");
                }
                request.getRequestDispatcher("Registrar_multa.jsp").forward(request, response);
                break;
             case 4: // actualizar Registro
                if (mulDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "multa se "
                            + "actualizo correctamente");
                    request.getRequestDispatcher("consultar_multa.jsp").forward(request, response);
                }else{
                    request.setAttribute("mensajeError", "multa no se "
                            + "actualizo correctamente");
                }
                request.getRequestDispatcher("actualizar_multa.jsp").forward(request, response);
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
