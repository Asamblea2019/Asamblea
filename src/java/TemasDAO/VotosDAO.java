/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasDAO;

import TemasVO.VotosVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Util.Conexion;
import Util.InterfaceCRUD;
import java.sql.CallableStatement;
import java.util.ArrayList;
/**
 *
 * @author mp4ma
 */
public class VotosDAO  extends Conexion implements InterfaceCRUD {

    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;

    
     private String Id_Votacion= "";
      private String Idf_Tema = "";
       private String tipo_Votacion="";
       private String estado_Votacion="";
    
     
     private boolean operaciones = false;
     
        public VotosDAO(VotosVO votosVO) {

        super();
        try {
            
            con = this.Conectar();
            stm = con.createStatement();
            
             Id_Votacion = votosVO.getId_Votacion();
            Idf_Tema = votosVO.getIdf_Tema();
            tipo_Votacion = votosVO.getTipo_Votacion();
            estado_Votacion=votosVO.getEstado_Votacion();
              
            } catch (Exception e) {
            System.out.println("!Error¡"+e.toString());
        }
     }
     
    @Override
    public boolean agregarRegistro() {
      try {
             stm.executeUpdate("call insertar_votacion (null,'"+Idf_Tema+"','"+tipo_Votacion+"','Activo'); ");
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
    
     public static VotosVO consultarId (String Id_Votacion){
        VotosVO voVO = null; 
            try {
                Conexion conbd = new Conexion();
                Connection con = conbd.Conectar();
                Statement puente = con.createStatement();
                
                ResultSet mensajero = puente.executeQuery("call consultar_votacion ('"+Id_Votacion+"'); ");
                while (mensajero.next()) {                    
                    voVO = new VotosVO (Id_Votacion, mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));
                }
                mensajero.close();
                puente.close();
            } catch (Exception e) {
                System.out.println("¡Error!"+ e.toString());
            }
            return voVO;
        }
    public ArrayList <VotosVO> listar(){
         
         Conexion conBd= new Conexion();
         ArrayList<VotosVO> listaVotos = new ArrayList<>();
         
         try {
            stm = conBd.Conectar().createStatement();
            rs = stm.executeQuery("select * from votacion");
            
            while(rs.next()){
                VotosVO voVO = new VotosVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                
                listaVotos.add(voVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaVotos;
    }
    public ArrayList <VotosVO> listarTema(){
         
         Conexion conBd= new Conexion();
         ArrayList<VotosVO> listaVotos = new ArrayList<>();
         
         try {
            stm = conBd.Conectar().createStatement();
            rs = stm.executeQuery("select votacion.*,tema from votacion INNER join tema on tema.id_Tema=votacion.idf_Tema");
            
            while(rs.next()){
                VotosVO voVO = new VotosVO(rs.getString(1),rs.getString(2),rs.getString(5),rs.getString(4));
                
                listaVotos.add(voVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaVotos;
    }
    public VotosDAO(){
    }
    
}
