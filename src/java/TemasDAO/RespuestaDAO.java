/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasDAO;

import TemasVO.RespuestaVO;
import Util.Conexion;
import Util.InterfaceCRUD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author fugo5
 */
public class RespuestaDAO extends Conexion implements InterfaceCRUD{
    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;
    
    private String resId = "";
    private String resIdfPregunta = "";
    private String resRespuesta = "";
    private String resEstado="";
    
    
    private boolean operaciones=false;
    
    public RespuestaDAO(RespuestaVO resVO){
        super();
        try {
            conexion = this.Conectar();
            puente = conexion.createStatement();
            
            resId = resVO.getResId();
            resIdfPregunta = resVO.getResIdfPregunta();
            resRespuesta = resVO.getResRespuesta();
            resEstado = resVO.getResEstado();
            
        } catch (Exception e) {
        }
    }

   
    @Override
    public boolean EliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregarRegistro() {
    try {
             puente.executeUpdate("call insertar_respuesta (null,'"+resIdfPregunta+"','"+resRespuesta+"','Activo'); ");
             operaciones=true;

        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        
        return operaciones;    }

    @Override
    public boolean actualizarRegistro() {
        try{
            puente.executeUpdate("call modificar_respuesta ('"+resId+"',"+resIdfPregunta+"','"+resRespuesta+"','"+resEstado+"');");
            operaciones=true;
            
        }  catch (Exception e) {
            
        } 
        return operaciones;    
    }

    @Override
    public boolean BuscarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static RespuestaVO consultarId (String resId){
        RespuestaVO resVO = null; 
            try {
                Conexion conbd = new Conexion();
                Connection con = conbd.Conectar();
                Statement puente = con.createStatement();
                
                ResultSet mensajero = puente.executeQuery("call consultar_respuesta ('"+resId+"'); ");
                while (mensajero.next()) {                    
                    resVO = new RespuestaVO (resId, mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));
                }
                mensajero.close();
                puente.close();
            } catch (Exception e) {
                System.out.println("¡Error!"+ e.toString());
            }
            return resVO;
        }
    public ArrayList <RespuestaVO> listar(){
         
         Conexion conBd= new Conexion();
         ArrayList<RespuestaVO> listaRespuesta = new ArrayList<>();
         
         try {
            puente = conBd.Conectar().createStatement();
            mensajero = puente.executeQuery("SELECT pregunta FROM respuesta INNER JOIN pregunta on respuesta.idf_Pregunta=pregunta.id_Pregunta where respuesta.idf_Pregunta=pregunta.id_Pregunta ;");
            
            while(mensajero.next()){
                RespuestaVO resVO = new RespuestaVO(mensajero.getString(1),mensajero.getString(1),mensajero.getString(1),mensajero.getString(1));
                
                listaRespuesta.add(resVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaRespuesta;
    }
    public ArrayList <RespuestaVO> contar(){
         
         Conexion conBd= new Conexion();
         ArrayList<RespuestaVO> listaRespuesta = new ArrayList<>();
         
         try {
            puente = conBd.Conectar().createStatement();
            mensajero = puente.executeQuery("SELECT COUNT(id_Respuesta) FROM respuesta;");
            
            while(mensajero.next()){
                RespuestaVO resVO = new RespuestaVO(mensajero.getString(1),mensajero.getString(1),mensajero.getString(1),mensajero.getString(1));
                
                listaRespuesta.add(resVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaRespuesta;
    }
    
    public ArrayList <RespuestaVO> listarSi(){
         
         Conexion conBd= new Conexion();
         ArrayList<RespuestaVO> listaRespuesta = new ArrayList<>();
         
         try {
            puente = conBd.Conectar().createStatement();
            mensajero = puente.executeQuery("SELECT COUNT(id_Respuesta) FROM respuesta WHERE respuesta='si'");
            
            while(mensajero.next()){
                RespuestaVO resVO = new RespuestaVO(mensajero.getString(1),mensajero.getString(1),mensajero.getString(1),mensajero.getString(1));
                
                listaRespuesta.add(resVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaRespuesta;
    }
    
    public ArrayList <RespuestaVO> listarNo(){
         
         Conexion conBd= new Conexion();
         ArrayList<RespuestaVO> listaRespuesta = new ArrayList<>();
         
         try {
            puente = conBd.Conectar().createStatement();
            mensajero = puente.executeQuery("SELECT COUNT(id_Respuesta) FROM respuesta WHERE respuesta='no'");
            
            while(mensajero.next()){
                RespuestaVO resVO = new RespuestaVO(mensajero.getString(1),mensajero.getString(1),mensajero.getString(1),mensajero.getString(1));
                
                listaRespuesta.add(resVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaRespuesta;
    }
    
    public ArrayList <RespuestaVO> listarAdmi(){
         
         Conexion conBd= new Conexion();
         ArrayList<RespuestaVO> listaRespuesta = new ArrayList<>();
         
         try {
            puente = conBd.Conectar().createStatement();
            mensajero = puente.executeQuery("SELECT id_Respuesta, COUNT(id_Respuesta), respuesta, estado_respuesta FROM respuesta INNER JOIN pregunta on respuesta.idf_Pregunta=pregunta.id_Pregunta inner join votacion on pregunta.idf_votacion=votacion.id_votacion INNER join tema on tema.id_Tema=votacion.idf_Tema where tipo_votacion='Administrativa';");
            
            while(mensajero.next()){
                RespuestaVO resVO = new RespuestaVO(mensajero.getString(1),mensajero.getString(2),mensajero.getString(3),mensajero.getString(4));
                
                listaRespuesta.add(resVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaRespuesta;
    }
    public RespuestaDAO(){
    }
    
}
