/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasDAO;

import Util.Conexion;
import Util.InterfaceCRUD;
import java.sql.*;
import TemasVO.AsambleaVO;
import java.util.ArrayList;


public class AsambleaDAO extends Conexion implements InterfaceCRUD {

    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;

    private String id_Asamblea = "";
    private String tipo_Asamblea = "";
    private String fecha_Asamblea = "";
    private String descripcion_Asamblea = "";
    private String estado_Asamblea = "";

    
    private boolean operaciones = false;

    public AsambleaDAO(AsambleaVO asaVO) {
        super();
        try {
        con = this.Conectar();
        stm = con.createStatement();
        
        
        id_Asamblea=asaVO.getId_Asamblea();
        tipo_Asamblea=asaVO.getTipo_Asamblea();
        fecha_Asamblea=asaVO.getFecha_Asamblea();
        descripcion_Asamblea=asaVO.getDescripcion_Asamblea();
        estado_Asamblea = asaVO.getEstado_Asamblea();
        
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        
    }

    @Override
    public boolean agregarRegistro() {
        try {
             stm.executeUpdate("call insertar_asamblea (null,'"+tipo_Asamblea+"','"+fecha_Asamblea+"','"+descripcion_Asamblea+"','Activo'); ");
             operaciones=true;

        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        
        return operaciones;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
             stm.executeUpdate("call modificar_asamblea ('"+id_Asamblea+"','"+tipo_Asamblea+"','"+fecha_Asamblea+"','"+descripcion_Asamblea+"','"+estado_Asamblea+"'); ");
             operaciones=true;

        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        
        return operaciones;
    }

    @Override
    public boolean BuscarRegistro() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public boolean EliminarRegistro() {
        try{
            stm.executeUpdate("call eliminar_asamblea ('"+id_Asamblea+"')");
            
            operaciones = true;
        }  catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
        } 
        return operaciones;
    }
    
    public static AsambleaVO consultarId (String id_asamblea){
        AsambleaVO asmVO = null; 
           try {
                Conexion conbd = new Conexion();
                Connection con = conbd.Conectar();
                Statement puente = con.createStatement();
                
                ResultSet mensajero = puente.executeQuery("call consultar_asamblea ('"+id_asamblea+"'); "); 
               while (mensajero.next()) {                    
                    asmVO = new AsambleaVO (id_asamblea, mensajero.getString(2), mensajero.getString(3),mensajero.getString(4),mensajero.getString(5));
                }
                mensajero.close();
                puente.close();
            } catch (Exception e) {
                System.out.println("¡Error!"+ e.toString());
            }
            return asmVO;
        }
    public ArrayList <AsambleaVO> listar(){
         
         Conexion conBd= new Conexion();
         ArrayList<AsambleaVO> listaAsamblea = new ArrayList<>();
         
         try {
            stm = conBd.Conectar().createStatement();
                rs = stm.executeQuery("select * from asamblea where estado_asamblea= 'Activo';");
            
            while(rs.next()){
                AsambleaVO asmVO = new AsambleaVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                
                listaAsamblea.add(asmVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaAsamblea;
    }
    public AsambleaDAO(){}

}
