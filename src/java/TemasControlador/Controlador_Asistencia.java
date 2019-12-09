/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasControlador;

import TemasDAO.AsistenciaDAO;
import TemasDAO.ConstituyenteDAO;
import TemasVO.AsistenciaVO;
import TemasVO.ConstituyenteVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mateo Coronado
 */
@WebServlet(name = "Controlado_Asistencia", urlPatterns = {"/Asistencia"})
public class Controlador_Asistencia extends HttpServlet {

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
        String id_Asistencia = request.getParameter("id_Asistencia");
        String idf_Asamblea = request.getParameter("select");
        String cedulaf_Constituyente = request.getParameter("nombre");

        String cedula_Constituyente = request.getParameter("nombre");
        String cedulaf_Usuario = request.getParameter("nombre");
        String nombre_Constituyete = request.getParameter("txtnombre_Constituyete");
        String apellido_Constituyente = request.getParameter("txtapellido_Constituyente");
        String correo_Constituyente = request.getParameter("txtcorreo_Constituyente");
        String cel_Constituyente = request.getParameter("txtcel_Constituyente");
        String estado_Constituyente = "Inactivo";
        String poder = "txtpoder";

        AsistenciaVO asisVO = new AsistenciaVO(id_Asistencia, idf_Asamblea, cedulaf_Constituyente);
        AsistenciaDAO asisDAO = new AsistenciaDAO(asisVO);

        ConstituyenteVO tVO = new ConstituyenteVO(cedula_Constituyente, cedulaf_Usuario, nombre_Constituyete, apellido_Constituyente,
                correo_Constituyente, cel_Constituyente,  estado_Constituyente,poder);
        ConstituyenteDAO tDAO = new ConstituyenteDAO(tVO);

        switch (opcion) {
            case 1: //Agregar Registro
                if (asisDAO.agregarRegistro() && tDAO.actualizarestado()) {

                    request.setAttribute("mensajeExito", "<script>alert('La Asistencia se registro correctamente!')</script>");
                    request.getRequestDispatcher("registrar_asistencia.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "<script>alert('La Asistencia NO pudo ser registrada correctamente!')</script>");
                    request.getRequestDispatcher("registrar_asistencia.jsp").forward(request, response);
                }

                break;

            case 2: // consultar
                AsistenciaVO asiVO = AsistenciaDAO.consultarId(id_Asistencia);
                if (asisVO != null) {
                    request.setAttribute("voLLeno", "La Asistencia se registro correctamente!");
                    request.getRequestDispatcher("actualizar_asistencia.jsp").forward(request, response);

                } else {
                    request.setAttribute("mensajeError", "La Asistencia no  "
                            + "existe");
                    request.getRequestDispatcher("consultar_asistencia.jsp").forward(request, response);
                }
                break;

            case 3: // Eliminar Registro
                if (asisDAO.EliminarRegistro()) {
                    request.setAttribute("mensajeExito", "La Asistencia se "
                            + "elimino correctamente");
                } else {
                    request.setAttribute("mensajeError", "La Asistencia no se "
                            + "elimino correctamente");
                }
                request.getRequestDispatcher("Registrar_Asistencia.jsp").forward(request, response);
                break;

            case 4: // actualizar Registro
                if (asisDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "La Asistencia se "
                            + "actualizo correctamente");
                } else {
                    request.setAttribute("mensajeError", "La Asistencia no se "
                            + "actualizo correctamente");
                }
                request.getRequestDispatcher("actualizar_asistencia.jsp").forward(request, response);
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
