/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasDAO;

import TemasVO.PreguntaVO;
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
 * @author Mateo Coronado
 */
public class PreguntaDAO extends Conexion implements InterfaceCRUD{
    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;
    
    private String id_pregunta ="";
    private String idf_votacion="";
    private String pregunta="";
    private String estado_pregunta="";
    
    private boolean operaciones = false;
    
    public PreguntaDAO (PreguntaVO preVO)
    {
        super();
        try {
            con = this.Conectar();
            stm = con.createStatement();
            
            id_pregunta=preVO.getId_pregunta();
            idf_votacion=preVO.getIdf_votacion();
            pregunta=preVO.getPregunta();
            estado_pregunta=preVO.getEstado_pregunta();
            
        } catch (Exception e) {
            System.out.println("!Error" +e.toString());
        }
    }

    @Override
    public boolean agregarRegistro() {
          try {
            stm.executeUpdate("call insertar_pregunta (null ,'"+idf_votacion+"','"+pregunta+"','Activo'); ");
             operaciones=true;
            
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }

        return operaciones;
    }

    @Override
    public boolean actualizarRegistro() {
        try{
            stm.executeUpdate("call modificar_pregunta ('"+id_pregunta+"','"+idf_votacion+"','"+pregunta+"','"+estado_pregunta+"');");
            operaciones=true;
            
        }  catch (Exception e) {
            
        } 
        return operaciones;        
    }

    @Override
    public boolean EliminarRegistro() {
        try{
            stm.executeUpdate("call eliminar_pregunta'"+id_pregunta+"'");
            
            operaciones = true;
        }  catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
        } 
        return operaciones;
    }
    public boolean actualizarEsta() {
        try{
            stm.executeUpdate("UPDATE `pregunta` SET `estado_pregunta` = 'Inactivo' WHERE `id_pregunta` = '"+id_pregunta+"'");
            
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
    
     public static PreguntaVO consultarId (String id_pregunta){
        PreguntaVO preVO = null; 
            try {
                Conexion conbd = new Conexion();
                Connection con = conbd.Conectar();
                Statement puente = con.createStatement();
                
                ResultSet mensajero = puente.executeQuery("call consultar_pregunta ('"+id_pregunta+"'); ");
                while (mensajero.next()) {                    
                    preVO = new PreguntaVO (id_pregunta, mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));
                }
                mensajero.close();
                puente.close();
            } catch (Exception e) {
                System.out.println("¡Error!"+ e.toString());
            }
            return preVO;
        }
    public ArrayList <PreguntaVO> listar(){
         
         Conexion conBd= new Conexion();
         ArrayList<PreguntaVO> listaPreguntas = new ArrayList<>();
         
         try {
            stm = conBd.Conectar().createStatement();
            rs = stm.executeQuery("select id_pregunta,tipo_votacion,pregunta,estado_pregunta from pregunta as p inner join votacion as v on p.idf_votacion=v.id_votacion  where estado_pregunta= 'Activo';");
            
            while(rs.next()){
                PreguntaVO preVO = new PreguntaVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                
                listaPreguntas.add(preVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaPreguntas;
    }
    public ArrayList <PreguntaVO> selectCons(){
         
         Conexion conBd= new Conexion();
         ArrayList<PreguntaVO> listaPreguntas = new ArrayList<>();
         
         try {
            stm = conBd.Conectar().createStatement();
            rs = stm.executeQuery("select * from pregunta INNER join votacion on pregunta.idf_Votacion=votacion.id_Votacion  WHERE estado_pregunta= 'Activo' ; ;");
            
            while(rs.next()){
                PreguntaVO preVO = new PreguntaVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                
                listaPreguntas.add(preVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaPreguntas;
    }
    public ArrayList <PreguntaVO> selectAdmi(){
         
         Conexion conBd= new Conexion();
         ArrayList<PreguntaVO> listaPreguntas = new ArrayList<>();
         
         try {
            stm = conBd.Conectar().createStatement();
            rs = stm.executeQuery("select * from pregunta INNER join votacion on pregunta.idf_Votacion=votacion.id_Votacion  WHERE tipo_votacion= 'Administrativa' ; ;");
            
            while(rs.next()){
                PreguntaVO preVO = new PreguntaVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                
                listaPreguntas.add(preVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaPreguntas;
    }
    public PreguntaDAO(){
    }
}
