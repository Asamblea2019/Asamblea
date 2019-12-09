/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasDAO;

import TemasVO.ResidenciaVO;
import Util.Conexion;
import Util.InterfaceCRUD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ResidenciaDAO extends Conexion implements InterfaceCRUD{
    
    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;
    
    private String idResi = "";
    private String cedulafConstituyente = "";
    private String apartamento = "";
    private String estado = "";
    private boolean operaciones = false;
    
    public ResidenciaDAO (ResidenciaVO resiVO){
        super();
        try {
            con = this.Conectar();
            stm = con.createStatement();
            
            idResi=resiVO.getIdResi();
            cedulafConstituyente=resiVO.getCedulafConstituyente();
            apartamento=resiVO.getApartamento();
            estado=resiVO.getEstado();
        } catch (Exception e) {
            System.out.println("!Error" +e.toString());
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
             stm.executeUpdate("call insertar_residencia(null,'"+cedulafConstituyente+"','"+apartamento+"','Activo'); ");
             operaciones=true;

        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        
        return operaciones;
    }

    @Override
    public boolean actualizarRegistro() {
        try{
            stm.executeUpdate("call modificar_residencia ('"+idResi+"','"+cedulafConstituyente+"','"+apartamento+"','"+estado+"');");
            operaciones=true;
            
        }  catch (Exception e) {
            System.out.println("Error"+e.toString());
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
    public static ResidenciaVO consultarId (String idResi){
        ResidenciaVO resiVO = null; 
            try {
                Conexion conbd = new Conexion();
                Connection con = conbd.Conectar();
                Statement puente = con.createStatement();
                
                ResultSet mensajero = puente.executeQuery("call consultar_residencia ('"+idResi+"'); ");
                while (mensajero.next()) {                    
                    resiVO = new ResidenciaVO(idResi, mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));
                }
                mensajero.close();
                puente.close();
            } catch (Exception e) {
                System.out.println("¡Error!"+ e.toString());
            }
            return resiVO;
        }
    public ArrayList <ResidenciaVO> listar(){
         
         Conexion conBd= new Conexion();
         ArrayList<ResidenciaVO> listaResi = new ArrayList<>();
         
         try {
            stm = conBd.Conectar().createStatement();
            rs = stm.executeQuery("select * from residencia order by cedulaf_constituyente");
            
            while(rs.next()){
                ResidenciaVO resiVO = new ResidenciaVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                
                listaResi.add(resiVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaResi;
    }
    public ResidenciaDAO(){}
    
}
