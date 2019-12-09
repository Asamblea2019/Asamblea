/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasVO;

/**
 *
 * @author APRENDIZ
 */
public class AsambleaVO {
    
    private String id_Asamblea;
    private String tipo_Asamblea; 
    private String fecha_Asamblea; 
    private String descripcion_Asamblea;
    private String estado_Asamblea;

    
 public AsambleaVO() {
        
    }
 public AsambleaVO(String id_Asamblea, String tipo_Asamblea, String fecha_Asamblea, String descripcion_Asamblea, String estado_Asamblea) {
        this.id_Asamblea= id_Asamblea;
        this.tipo_Asamblea=tipo_Asamblea;
        this.fecha_Asamblea=fecha_Asamblea;
        this.descripcion_Asamblea = descripcion_Asamblea;
        this.estado_Asamblea = estado_Asamblea;
        
    }

    public String getEstado_Asamblea() {
        return estado_Asamblea;
    }

    public void setEstado_Asamblea(String estado_Asamblea) {
        this.estado_Asamblea = estado_Asamblea;
    }
    public String getId_Asamblea() {
        return id_Asamblea;
    }

    public void setId_Asamblea(String id_Asamblea) {
        this.id_Asamblea = id_Asamblea;
    }

    public String getTipo_Asamblea() {
        return tipo_Asamblea;
    }

    public void setTipo_Asamblea(String tipo_Asamblea) {
        this.tipo_Asamblea = tipo_Asamblea;
    }

    public String getFecha_Asamblea() {
        return fecha_Asamblea;
    }

    public void setFecha_Asamblea(String fecha_Asamblea) {
        this.fecha_Asamblea = fecha_Asamblea;
    }

    public String getDescripcion_Asamblea() {
        return descripcion_Asamblea;
    }

    public void setDescripcion_Asamblea(String descripcion_Asamblea) {
        this.descripcion_Asamblea = descripcion_Asamblea;
    }

   
    

    

}
