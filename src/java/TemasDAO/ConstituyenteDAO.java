/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasDAO;

import TemasVO.ConstituyenteVO;
import Util.Conexion;
import Util.InterfaceCRUD;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Cristian
 */
public class ConstituyenteDAO extends Conexion implements InterfaceCRUD {

    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private boolean operaciones = false;

    private String cedula_Constituyente = "";
    private String cedulaf_Usuario = "";
    private String nombre_Constituyete = "";
    private String apellido_Constituyente = "";
    private String correo_Constituyente = "";
    private String cel_Constituyente = "";
    private String estado_Constituyente = "";
    private String poder="";

    
    public ConstituyenteDAO(ConstituyenteVO Tvo) {
        super();
        try {
            con = this.Conectar();
            stm = con.createStatement();
            
            
            cedula_Constituyente = Tvo.getCedula_Constituyente();
            cedulaf_Usuario = Tvo.getCedulaf_Usuario();
            nombre_Constituyete = Tvo.getNombre_Constituyete();
            apellido_Constituyente = Tvo.getApellido_Constituyente();
            correo_Constituyente = Tvo.getCorreo_Constituyente();
            cel_Constituyente = Tvo.getCel_Constituyente();
            estado_Constituyente = Tvo.getEstado_Constituyenye();
            poder= Tvo.getPoder();
        } catch (Exception e) {
            System.out.println("!Error" + e.toString());
        }

    }

    @Override
    public boolean agregarRegistro() {
       
        try {
            stm.executeUpdate("call insertar_constituyente ('"+cedula_Constituyente+"','"+cedulaf_Usuario+"','"+nombre_Constituyete+"','"+apellido_Constituyente+"'"
                    + ",'"+correo_Constituyente+"','"+cel_Constituyente+"','Activo','"+poder+"');");
             operaciones=true;
            
        } catch (Exception e) {
        }

        return operaciones;
    }

    @Override
    public boolean actualizarRegistro() {
        try{
            stm.executeUpdate("call modificar_constituyente ('"+cedula_Constituyente+"','"+cedulaf_Usuario+"','"+nombre_Constituyete+"','"+apellido_Constituyente+"'"
                    +",'"+correo_Constituyente+"','"+cel_Constituyente+"','"+estado_Constituyente+"','"+poder+"');");
            operaciones=true;
            
        }  catch (Exception e) {
            
        } 
        return operaciones;
    }
    
    public boolean actualizarestado() {
        try{
            stm.executeUpdate("UPDATE `constituyente` SET `estado_constituyente` = 'Inactivo' WHERE `cedula_constituyente` = '"+cedula_Constituyente+"'");
                    
            operaciones=true;
            
        }  catch (Exception e) {
            
        } 
        return operaciones;
    }


    @Override
    public boolean EliminarRegistro() {
        try{
            stm.executeUpdate("call eliminar_constituyente ('"+cedula_Constituyente+"');");
            
            operaciones = true;
        }  catch (Exception e) {
        } 
        return operaciones;
    }

    @Override
    public boolean BuscarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
    public static ConstituyenteVO consultarId (String Cedula_Constituyente){
        ConstituyenteVO constVO = null; 
            try {
                Conexion conbd = new Conexion();
                Connection con = conbd.Conectar();
                Statement puente = con.createStatement();
                
                ResultSet mensajero = puente.executeQuery("call consultar_constituyen ('"+Cedula_Constituyente+"'); ");
                while (mensajero.next()) {                    
                    constVO = new ConstituyenteVO (Cedula_Constituyente, mensajero.getString(2), mensajero.getString(3),mensajero.getString(4),mensajero.getString(5),mensajero.getString(6),mensajero.getString(7),mensajero.getString(8));
                }
                mensajero.close();
                puente.close();
            } catch (Exception e) {
                System.out.println("¡Error!"+ e.toString());
            }
            return constVO;
        }
    public ArrayList <ConstituyenteVO> listar(){
         
         Conexion conBd= new Conexion();
         ArrayList<ConstituyenteVO> listaConstituyente = new ArrayList<>();
         
         try {
            stm = conBd.Conectar().createStatement();
            rs = stm.executeQuery("select*from constituyente ;");
            
            while(rs.next()){
                ConstituyenteVO consVO = new ConstituyenteVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                
                listaConstituyente.add(consVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaConstituyente;
    }
    public ArrayList <ConstituyenteVO> listarCons(){
         
         Conexion conBd= new Conexion();
         ArrayList<ConstituyenteVO> listaConstituyente = new ArrayList<>();
         
         try {
            stm = conBd.Conectar().createStatement();
            rs = stm.executeQuery("select constituyente.*,apartamento from constituyente inner join residencia on constituyente.cedula_Constituyente=residencia.cedulaf_Constituyente where estado_constituyente = 'Activo';");
            
            while(rs.next()){
                ConstituyenteVO consVO = new ConstituyenteVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                rs.getString(5),rs.getString(6),rs.getString(9),rs.getString(8));
                
                listaConstituyente.add(consVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaConstituyente;
    }
    public ConstituyenteDAO(){}

}


