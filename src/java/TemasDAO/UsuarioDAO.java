/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasDAO;

import TemasVO.ConstituyenteVO;
import TemasVO.UsuarioVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Util.Conexion;
import Util.InterfaceCRUD;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.CallableStatement;
import java.util.ArrayList;
import javax.ws.rs.core.Request;


/**
 *
 * @author mp4ma
 */
public class UsuarioDAO extends Conexion implements InterfaceCRUD{
    
    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;

    private String cel_Usu= "", tipo_usu = "", password_usu = "",estado_usu="";

    private boolean operaciones = false;
    
     public UsuarioDAO(UsuarioVO usuVO) {

        super();
        try {
            
            con = this.Conectar();
            stm = con.createStatement();
            
             cel_Usu = usuVO.getCel_usu();
            tipo_usu = usuVO.getTipo_usu();
            password_usu = usuVO.getPassword_usu();
            estado_usu = usuVO.getEstado_usu();
             } 
            catch (Exception e) {
            System.out.println("!Error¡"+e.toString());
        }
     }

    @Override
    public boolean agregarRegistro() {
        try {
        
           stm.executeUpdate("call insertar_usuario('"+cel_Usu+"','Coopropietario','Inactivo','"+password_usu+"')");
           operaciones=true;
        } catch (Exception e) {
            System.out.println("Error¡"+e.toString());
        }
        return operaciones;
    }
    
    
    public boolean validarIngreso(String cedula, String password){
        try {
            con = this.Conectar();
            stm = con.createStatement();
            rs = stm.executeQuery("select * from Usuario where "
                    + "cedula_Usuario='"+cedula+"'and pass='"+password+"'" );
            
            if (rs.next()) {
                  
                
                operaciones = true;
            }
            this.Desconectar();
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
    return operaciones;
    
    }
    
      public static UsuarioVO sesion(String cedula) 
      {
          UsuarioVO Inicio =null;
          try {
            Conexion con= new Conexion();
            Connection conexion= con.Conectar();
            Statement stm =conexion.createStatement();
            ResultSet rs = stm.executeQuery("Select * from usuario where cedula_Usuario= '"+cedula+"'");
              while (rs.next()) {                  
                  Inicio = new UsuarioVO (rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                  
              }
              stm.close();
              rs.close();
              
          } catch (Exception e) {
             System.out.println("Error"+e.toString());
          }
          return Inicio;
      }
     
   
   

   
    public boolean actualizarRegistro() {
        try{
            stm.executeUpdate("call modificar_usuario ('"+cel_Usu+"','"+tipo_usu+"','"+estado_usu+"','"+password_usu+"')");
                    
            operaciones=true;
            
        }  catch (Exception e) {
            
        } 
        return operaciones;
    }
    public boolean actualizarestado() {
        try{
            stm.executeUpdate("UPDATE `usuario` SET `estado` = 'Activo' WHERE `cedula_Usuario` = '"+cel_Usu+"'");
                    
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
    
    public boolean verificarcel(String cedula){
        try {
            con = this.Conectar();
            stm = con.createStatement();
            rs = stm.executeQuery("select * from usuario where "
                    + "cedula_Usuario='"+cedula+"'");
            
            if (rs.next()) {
                operaciones = true;
            }
            this.Desconectar();
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
    return operaciones;
    
    }
        public  UsuarioVO consultarId (String id){
        UsuarioVO asmVO = null; 
           try {
                Conexion conbd = new Conexion();
                Connection con = conbd.Conectar();
                Statement puente = con.createStatement();
                
                ResultSet mensajero = puente.executeQuery("call consultar_usuario=('"+id+"'); "); 
               while (mensajero.next()) {                    
                    asmVO = new UsuarioVO (id, mensajero.getString(2), mensajero.getString(3),mensajero.getString(4));
                }
                mensajero.close();
                puente.close();
            } catch (Exception e) {
                System.out.println("¡Error!"+ e.toString());
            }
            return asmVO;
        }
        public ArrayList <UsuarioVO> listar(){
         
         Conexion conBd= new Conexion();
         ArrayList<UsuarioVO> listaUsuario = new ArrayList<>();
         
         try {
            stm = conBd.Conectar().createStatement();
                rs = stm.executeQuery("select * from usuario ");
            
            while(rs.next()){
                UsuarioVO UsuVO = new UsuarioVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                
                listaUsuario.add(UsuVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaUsuario;
        
}       public ArrayList <UsuarioVO> listarUsu(){
         
         Conexion conBd= new Conexion();
         ArrayList<UsuarioVO> listaUsuario = new ArrayList<>();
         
         try {
            stm = conBd.Conectar().createStatement();
                rs = stm.executeQuery("select * from usuario where estado = 'Inactivo'");
            
            while(rs.next()){
                UsuarioVO UsuVO = new UsuarioVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                
                listaUsuario.add(UsuVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaUsuario;
        
}

    
    
    
    
    public UsuarioDAO(){}
 }

