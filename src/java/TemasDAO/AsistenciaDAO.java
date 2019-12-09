/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasDAO;

import TemasVO.AsistenciaVO;
import Util.Conexion;
import Util.InterfaceCRUD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Mateo Coronado
 */
public class AsistenciaDAO extends Conexion implements InterfaceCRUD{
     private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;
    
    private String id_Asistencia ="";
    private String idf_Asamblea ="";
    private String cedulaf_Constituyente ="";
    
    private boolean operaciones = false;
    
    public AsistenciaDAO (AsistenciaVO asisVO){
        super();
        try {
            con = this.Conectar();
            stm = con.createStatement();
            
            id_Asistencia=asisVO.getId_asistencia();
            idf_Asamblea=asisVO.getIdf_asamblea();
            cedulaf_Constituyente=asisVO.getCedulaf_Constituyente();
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            stm.executeUpdate("call insertar_asistencia (null,'"+idf_Asamblea+"','"+cedulaf_Constituyente+"'); ");
             operaciones=true;
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        return operaciones;
    }

    @Override
    public boolean actualizarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean BuscarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public static AsistenciaVO consultarId (String id_asistencia){
        AsistenciaVO asisVO = null; 
           try {
                Conexion conbd = new Conexion();
                Connection con = conbd.Conectar();
                Statement puente = con.createStatement();
                
                ResultSet mensajero = puente.executeQuery("call consultar_asistencia ('"+id_asistencia+"'); "); 
               while (mensajero.next()) {                    
                    asisVO = new AsistenciaVO (id_asistencia, mensajero.getString(2), mensajero.getString(3));
                }
                mensajero.close();
                puente.close();
            } catch (Exception e) {
                System.out.println("¡Error!"+ e.toString());
            }
            return asisVO;
        }
    public ArrayList <AsistenciaVO> listar(){
         
         Conexion conBd= new Conexion();
         ArrayList<AsistenciaVO> listaAsistencia = new ArrayList<>();
         
         try {
            stm = conBd.Conectar().createStatement();
                rs = stm.executeQuery("select * from ASISTENCIA inner join asamblea on asamblea.id_Asamblea = asistencia.idf_Asamblea;");
            
            while(rs.next()){
                AsistenciaVO asisVO = new AsistenciaVO(rs.getString(1),rs.getString(6),rs.getString(3));
                
                listaAsistencia.add(asisVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaAsistencia;
    }
    public AsistenciaDAO(){}
}
