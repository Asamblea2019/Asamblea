/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasVO;

/**
 *
 * @author mp4ma
 */
public class VotosVO {
    
    String Id_Votacion, Idf_Tema, tipo_Votacion, estado_Votacion;
    
    
    
     public VotosVO(){
    
    
    }

    public VotosVO(String Id_Votacion, String Idf_Tema, String tipo_Votacion, String estado_Votacion) {
        this.Id_Votacion = Id_Votacion;
        this.Idf_Tema = Idf_Tema;
        this.tipo_Votacion = tipo_Votacion;
        this.estado_Votacion = estado_Votacion;
    }

    public String getEstado_Votacion() {
        return estado_Votacion;
    }

    public void setEstado_Votacion(String estado_Votacion) {
        this.estado_Votacion = estado_Votacion;
    }

    public void setId_Votacion(String Id_Votacion) {
        this.Id_Votacion = Id_Votacion;
    }

    public void setIdf_Tema(String Idf_Tema) {
        this.Idf_Tema = Idf_Tema;
    }

    public void setTipo_Votacion(String tipo_Votacion) {
        this.tipo_Votacion = tipo_Votacion;
    }

    public String getId_Votacion() {
        return Id_Votacion;
    }

    public String getIdf_Tema() {
        return Idf_Tema;
    }

    public String getTipo_Votacion() {
        return tipo_Votacion;
    }
    
     
}
