            /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasDAO;

import TemasVO.InformeVO;
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
public class InformeDAO extends Conexion implements InterfaceCRUD{
    private Connection conexion = null;
    private Statement stm = null;
    private ResultSet mensajero = null;
    
    private String inId = "";
    private String inIdfAsamblea = "";
    private String inNombre = "";
    private String inRedactor = "";
    private String inFecha = "";
    private String inEstado="";
    
    private boolean operaciones=false;
    
    public InformeDAO(InformeVO infVO){
        super();
        try {
            conexion = this.Conectar();
            stm = conexion.createStatement();
            
            inId = infVO.getInId();
            inIdfAsamblea = infVO.getInIdfAsamblea();
            inNombre = infVO.getInNombre();
            inRedactor = infVO.getInRedactor();
            inFecha = infVO.getInFecha();
            inEstado = infVO.getInEstado();
            
        } catch (Exception e) {
        }
    }

   
    @Override
    public boolean EliminarRegistro() {
         try{
            stm.executeUpdate("call eliminar_informe ('"+inId+"');");
            
            operaciones = true;
        }  catch (Exception e) {
        } 
        return operaciones;
    }

    @Override
    public boolean agregarRegistro() {
        try {
        
           stm.executeUpdate("call insertar_informe (null,'"+inIdfAsamblea+"','"+inNombre+"','"+inRedactor+"','"+inFecha+"','Activo');");
           operaciones=true;
        } catch (Exception e) {
            System.out.println("Error¡"+e.toString());
        }
        return operaciones;
    }

    @Override
    public boolean actualizarRegistro() {
        try{
            stm.executeUpdate("call modificar_informe ('"+inId+"','"+inIdfAsamblea+"','"+inNombre+"','"+inRedactor+"','"+inFecha+"','"+inEstado+"');");
            operaciones=true;
            
        }  catch (Exception e) {
            
        } 
        return operaciones;
    }

    @Override
    public boolean BuscarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
     public static InformeVO consultarId (String Id_Informe){
        InformeVO infoVO = null; 
            try {
                Conexion conbd = new Conexion();
                Connection con = conbd.Conectar();
                Statement puente = con.createStatement();
                
                ResultSet mensajero = puente.executeQuery("call consultar_informe ('"+Id_Informe+"'); ");
                while (mensajero.next()) {                    
                    infoVO = new InformeVO(Id_Informe, mensajero.getString(2), mensajero.getString(3),mensajero.getString(4),mensajero.getString(5),mensajero.getString(6));
                }
                mensajero.close();
                puente.close();
            } catch (Exception e) {
                System.out.println("¡Error!"+ e.toString());
            }
            return infoVO;
        }
    public ArrayList <InformeVO> listar(){
         
         Conexion conBd= new Conexion();
         ArrayList<InformeVO> listaInforme = new ArrayList<>();
         
         try {
            stm = conBd.Conectar().createStatement();
            mensajero = stm.executeQuery("select*from informe INNER JOIN asamblea ON informe.idf_Asamblea = asamblea.id_Asamblea where estado_informe= 'Activo';");
            
            while(mensajero.next()){
                InformeVO infVO = new InformeVO(mensajero.getString(1),mensajero.getString(9),mensajero.getString(3),mensajero.getString(4),
                mensajero.getString(5),mensajero.getString(6));
                
                listaInforme.add(infVO);
            }
        } catch (Exception e) {
            System.out.println("¡Error!"+ e.toString());
            }
        return listaInforme;
    }
    public InformeDAO(){}
}
