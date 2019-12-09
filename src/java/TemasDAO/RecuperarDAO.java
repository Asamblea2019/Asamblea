/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasDAO;

import TemasVO.UsuarioVO;
import Util.Conexion;
import Util.InterfaceCRUD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mp4ma
 */
public class RecuperarDAO extends Conexion implements InterfaceCRUD{
    
     private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;

    private String cel_Usu= "", tipo_usu = "", password_usu = "";

    private boolean operaciones = false;
    
     public RecuperarDAO(UsuarioVO usuVO) {

        super();
        try {
            
            con = this.Conectar();
            stm = con.createStatement();
            
             cel_Usu = usuVO.getCel_usu();
            tipo_usu = usuVO.getTipo_usu();
            password_usu = usuVO.getPassword_usu();
             } 
            catch (Exception e) {
            System.out.println("!Error¡"+e.toString());
        }
     }

    @Override
    public boolean agregarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        public static UsuarioVO consultarId (String id){
        UsuarioVO asmVO = null; 
           try {
                Conexion conbd = new Conexion();
                Connection con = conbd.Conectar();
                Statement puente = con.createStatement();
                
                ResultSet mensajero = puente.executeQuery("call consultar_usuario=('"+id+"'); "); 
               while (mensajero.next()) {                    
                    asmVO = new UsuarioVO (id, mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));
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
                rs = stm.executeQuery("select * from usuario");
            
            while(rs.next()){
                UsuarioVO UsuVO = new UsuarioVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                
                listaUsuario.add(UsuVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaUsuario;
        
}
}
