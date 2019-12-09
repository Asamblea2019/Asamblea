/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasDAO;

import Util.Conexion;
import TemasVO.ActaVO;
import Util.InterfaceCRUD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author APRENDIZ
 */
public class ActaDAO extends Conexion implements InterfaceCRUD{
    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;
    
    private String id_acta = "";
    private String idf_informe = "";
    private String descripcion_acta = "";
    private String registro_acta = "";
    private String fecha_acta = "";
    private String estado_acta ="";

    private boolean operaciones = false;
    
    
     public ActaDAO(ActaVO actVO) {
        super();
        try {
        con = this.Conectar();
        stm = con.createStatement();
        
        
        id_acta=actVO.getId_acta();
        idf_informe=actVO.getIdf_informe();
        descripcion_acta= actVO.getDescripcion_acta();
        registro_acta=actVO.getRegistro_acta();
        fecha_acta= actVO.getFecha_acta();
        estado_acta=actVO.getEstado_acta();
        
        
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        
    }
    @Override
    public boolean agregarRegistro() {
        
         try {
             stm.executeUpdate("call insertar_acta (null,'"+idf_informe+"','"+descripcion_acta+"','"+registro_acta+"','"+fecha_acta+"','Activo'); ");
             operaciones=true;

        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        
        return operaciones;
    }
        
    

    @Override
    public boolean actualizarRegistro() {
            try{
            stm.executeUpdate("call modificar_acta ('"+idf_informe+"','"+descripcion_acta+"','"+registro_acta+"'"
                    +",'"+fecha_acta+"','"+estado_acta+"');");
            operaciones=true;
            
        }  catch (Exception e) {
            
        } 
        return operaciones;
    }    

    @Override
    public boolean EliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean BuscarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static ActaVO consultarId (String id_acta){
        ActaVO actVO = null; 
            try {
                Conexion conbd = new Conexion();
                Connection con = conbd.Conectar();
                Statement puente = con.createStatement();
                
                ResultSet mensajero = puente.executeQuery("call consultar_acta ('"+id_acta+"'); ");
                while (mensajero.next()) {                    
                    actVO = new ActaVO (id_acta, mensajero.getString(2), mensajero.getString(3),mensajero.getString(4),mensajero.getString(5),mensajero.getString(6));
                }
                mensajero.close();
                puente.close();
            } catch (Exception e) {
                System.out.println("¡Error!"+ e.toString());
            }
            return actVO;
        }
    public ArrayList <ActaVO> listar(){
         
         Conexion conBd= new Conexion();
         ArrayList<ActaVO> listaActa = new ArrayList<>();
         
         try {
            stm = conBd.Conectar().createStatement();
            rs = stm.executeQuery("select *,fecha_informe from acta inner join informe on acta.idf_Informe = informe.id_Informe where estado_Acta= 'Activo';");
            
            while(rs.next()){
                ActaVO actVO = new ActaVO(rs.getString(1),rs.getString(11),rs.getString(3),rs.getString(4),
                rs.getString(5),rs.getString(6));
                
                listaActa.add(actVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaActa;
    }
    public ActaDAO(){}
    
}
