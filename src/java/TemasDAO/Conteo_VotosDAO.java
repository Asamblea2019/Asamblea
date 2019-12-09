/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasDAO;

import TemasVO.Conteo_VotosVO;
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
public class Conteo_VotosDAO extends Conexion implements InterfaceCRUD{
    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;
    private String contId = "";
    private String contIdfPregunta = "";
    private String contTotal = "";
    
    private boolean operaciones=false;
    
    public Conteo_VotosDAO(Conteo_VotosVO contVO){
        super();
        try {
           con = this.Conectar();
           stm = con.createStatement();
            
            contId = contVO.getContId();
            contIdfPregunta = contVO.getContIdfPregunta();
            contTotal = contVO.getContTotal();
            
        } catch (Exception e) {
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
             stm.executeUpdate("call insertar_conteo (null,'"+contIdfPregunta+"','"+contTotal+"'); ");
             operaciones=true;

        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        
        return operaciones;    }

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
    public static Conteo_VotosVO consultarId (String contId){
        Conteo_VotosVO contVO = null; 
            try {
                Conexion conbd = new Conexion();
                Connection con = conbd.Conectar();
                Statement puente = con.createStatement();
                
                ResultSet mensajero = puente.executeQuery("call consultar_conteo ('"+contId+"'); ");
                while (mensajero.next()) {                    
                    contVO = new Conteo_VotosVO (contId, mensajero.getString(2), mensajero.getString(3));
                }
                mensajero.close();
                puente.close();
            } catch (Exception e) {
                System.out.println("¡Error!"+ e.toString());
            }
            return contVO;
        }
    public ArrayList <Conteo_VotosVO> listar(){
         
         Conexion conBd= new Conexion();
         ArrayList<Conteo_VotosVO> listaConteo = new ArrayList<>();
         
         try {
            stm = conBd.Conectar().createStatement();
            rs = stm.executeQuery("select*from conteo_votos;");
            
            while(rs.next()){
                Conteo_VotosVO contVO = new Conteo_VotosVO(rs.getString(1),rs.getString(2),rs.getString(3));
                
                listaConteo.add(contVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaConteo;
    }
    public Conteo_VotosDAO(){}

   
    
}
