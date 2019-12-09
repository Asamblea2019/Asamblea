/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasDAO;

import TemasVO.MultaVO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Util.Conexion;
import Util.InterfaceCRUD;

/**
 *
 * @author fugo5
 */public class MultaDAO extends Conexion implements InterfaceCRUD {


    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;

    private boolean operacion = false;

    private String id_multa = "";
    private String idf_asistencia = "";
    private String cedulaf_constituyente = "";
    private String descripcion_multa = "";
    private String pago_multa = "";
    private String fecha_multa = "";
    private String fecha_pago = "";
    private String estado_multa="";

    public MultaDAO(MultaVO multaVO) {

        super();

        try {

            con = this.Conectar();
            stm = con.createStatement();

            id_multa = multaVO.getId_multa();
            idf_asistencia = multaVO.getIdf_asistencia();
            cedulaf_constituyente = multaVO.getCedulaf_constituyente();
            descripcion_multa = multaVO.getDescripcion_multa();
            pago_multa = multaVO.getPago_multa();
            fecha_multa = multaVO.getFecha_multa();
            fecha_pago = multaVO.getFecha_pago();
            estado_multa = multaVO.getEstado_multa();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    @Override
    public boolean agregarRegistro() {
        
         try {
             stm.executeUpdate("call insertar_multa (null,'"+idf_asistencia+"','"+cedulaf_constituyente+"','"+descripcion_multa+"'"
                     + ",'"+pago_multa+"','"+fecha_multa+"','"+fecha_pago+"','Activo');");
             operacion=true;

        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        
        return operacion;
        
    }

    @Override
    public boolean actualizarRegistro() {
       try{
            stm.executeUpdate("call modificar_multa('"+id_multa+"','"+idf_asistencia+"','"+cedulaf_constituyente+"','"+descripcion_multa+"'"
                    +",'"+pago_multa+"','"+fecha_multa+"','"+fecha_pago+"','"+estado_multa+"');");
            operacion=true;
            
        }  catch (Exception e) {
            
        } 
        return operacion;
    }

    @Override
    public boolean BuscarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarRegistro() {
         try{
            stm.executeUpdate("call eliminar_multa ('"+id_multa+"');");
            
            operacion = true;
        }  catch (Exception e) {
        } 
        return operacion;
    }
    
    public static MultaVO consultarId (String id_Multa){
        MultaVO mulVO = null; 
            try {
                Conexion conbd = new Conexion();
                Connection con = conbd.Conectar();
                Statement puente = con.createStatement();
                
                ResultSet mensajero = puente.executeQuery("call consultar_multa ('"+id_Multa+"'); ");
                while (mensajero.next()) {                    
                    mulVO = new MultaVO (id_Multa, mensajero.getString(2), mensajero.getString(3),mensajero.getString(4), mensajero.getString(5),mensajero.getString(6), mensajero.getString(7), mensajero.getString(8));
                }
                mensajero.close();
                puente.close();
            } catch (Exception e) {
                System.out.println("¡Error!"+ e.toString());
            }
            return mulVO;
        }
    public ArrayList <MultaVO> listar(){
         
         Conexion conBd= new Conexion();
         ArrayList<MultaVO> listaMulta = new ArrayList<>();
         
         try {
            stm = conBd.Conectar().createStatement();
            rs = stm.executeQuery("select * from multa where estado_multa= 'Activo'");
            
            while(rs.next()){
                MultaVO multVO = new MultaVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                
                listaMulta.add(multVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaMulta;
    }
    public MultaDAO(){}




}
