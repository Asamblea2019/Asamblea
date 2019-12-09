/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasDAO;

import TemasVO.TemasVO;
import Util.Conexion;
import Util.InterfaceCRUD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 *
 * @author Cristian
 */
public class TemasDAO extends Conexion implements InterfaceCRUD {

    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;

    private String id_Tema = "";
    private String idf_Asamblea = "";
    private String tema = "";
    private String estado_tema="";

    private boolean operaciones = false;

    public TemasDAO (TemasVO tVO)
    {
        super();
        try {
            con = this.Conectar();
            stm = con.createStatement();
            
            id_Tema=tVO.getId_Tema();
            idf_Asamblea=tVO.getIdf_Asamblea();
            tema=tVO.getTema();
            estado_tema=tVO.getEstado_tema();
            
        } catch (Exception e) {
            System.out.println("!Error" +e.toString());
        }
    }

    @Override
    public boolean agregarRegistro() {
         try {
             stm.executeUpdate("call insertar_tema(null,'"+idf_Asamblea+"','"+tema+"','Activo'); ");
             operaciones=true;

        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        
        return operaciones;
    }

    @Override
    public boolean actualizarRegistro() {
    try{
            stm.executeUpdate("call modificar_tema ('"+id_Tema+"','"+idf_Asamblea+"','"+tema+"','"+estado_tema+"');");
            operaciones=true;
            
        }  catch (Exception e) {
            System.out.println("Error"+e.toString());
        } 
        return operaciones;
    }    

    @Override
   public boolean EliminarRegistro() {
        try{
            stm.executeUpdate("call eliminar_tema'"+id_Tema+"'");
            
            operaciones = true;
        }  catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
        } 
        return operaciones;
    }

    @Override
    public boolean BuscarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static TemasVO consultarId (String id_Tema){
        TemasVO temVO = null; 
            try {
                Conexion conbd = new Conexion();
                Connection con = conbd.Conectar();
                Statement puente = con.createStatement();
                
                ResultSet mensajero = puente.executeQuery("call consultar_tema ('"+id_Tema+"'); ");
                while (mensajero.next()) {                    
                    temVO = new TemasVO (id_Tema, mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));
                }
                mensajero.close();
                puente.close();
            } catch (Exception e) {
                System.out.println("¡Error!"+ e.toString());
            }
            return temVO;
        }
    public ArrayList <TemasVO> listar(){
         
         Conexion conBd= new Conexion();
         ArrayList<TemasVO> listaTemas = new ArrayList<>();
         
         try {
            stm = conBd.Conectar().createStatement();
            rs = stm.executeQuery("select * from tema INNER JOIN asamblea ON asamblea.id_Asamblea = tema.idf_Asamblea where estado_tema= 'Activo'");
            
            while(rs.next()){
                TemasVO temVO = new TemasVO(rs.getString(1),rs.getString(7),rs.getString(3),rs.getString(4));
                
                listaTemas.add(temVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaTemas;
    }
    
    public ArrayList <TemasVO> select(){
         
         Conexion conBd= new Conexion();
         ArrayList<TemasVO> listaTemas = new ArrayList<>();
         
         try {
            stm = conBd.Conectar().createStatement();
            rs = stm.executeQuery("select * from tema where estado_tema= 'Activo'");
            
            while(rs.next()){
                TemasVO temVO = new TemasVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                
                listaTemas.add(temVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaTemas;
    }
    
    public TemasDAO(){
    }
}
