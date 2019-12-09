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
public class ActaVO {
    
    private String id_acta;
    private String idf_informe;
    private String descripcion_acta;
    private String registro_acta;
    private String fecha_acta;
    private String estado_acta;
    
    public ActaVO(String id_acta, String idf_informe, String descripcion_acta, String registro_acta, String fecha_acta, String estado_Acta){
        this.id_acta = id_acta;
        this.idf_informe = idf_informe;
        this.descripcion_acta = descripcion_acta;
        this.registro_acta = registro_acta;
        this.fecha_acta = fecha_acta;
        this.estado_acta = estado_Acta;
    }

    public String getEstado_acta() {
        return estado_acta;
    }

    public void setEstado_acta(String estado_acta) {
        this.estado_acta = estado_acta;
    }

    public String getId_acta() {
        return id_acta;
    }

    public void setId_acta(String id_acta) {
        this.id_acta = id_acta;
    }

    public String getIdf_informe() {
        return idf_informe;
    }

    public void setIdf_informe(String idf_informe) {
        this.idf_informe = idf_informe;
    }

    public String getDescripcion_acta() {
        return descripcion_acta;
    }

    public void setDescripcion_acta(String descripcion_acta) {
        this.descripcion_acta = descripcion_acta;
    }

    public String getRegistro_acta() {
        return registro_acta;
    }

    public void setRegistro_acta(String registro_acta) {
        this.registro_acta = registro_acta;
    }

    public String getFecha_acta() {
        return fecha_acta;
    }

    public void setFecha_acta(String fecha_acta) {
        this.fecha_acta = fecha_acta;
    }
    
    public ActaVO(){}
      
    
}
