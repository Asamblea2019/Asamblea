/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasVO;

/**
 *
 * @author Cristian
 */
public class TemasVO {

    

    public String getId_Tema() {
        return id_Tema;
    }

    public void setId_Tema(String id_Tema) {
        this.id_Tema = id_Tema;
    }

    public String getIdf_Asamblea() {
        return idf_Asamblea;
    }

    public void setIdf_Asamblea(String idf_Asamblea) {
        this.idf_Asamblea = idf_Asamblea;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

   
   String id_Tema ,idf_Asamblea ,tema, estado_tema;
   
    public TemasVO(){}
    
    public TemasVO (String id_Tema,String idf_Asamblea ,String tema, String estado_tema){
        this.id_Tema=id_Tema;
        this.idf_Asamblea=idf_Asamblea;
        this.tema=tema;
        this.estado_tema=estado_tema;
    }

    public String getEstado_tema() {
        return estado_tema;
    }

    public void setEstado_tema(String estado_tema) {
        this.estado_tema = estado_tema;
    }
    
}
