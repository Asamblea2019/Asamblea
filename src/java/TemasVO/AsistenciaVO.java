/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasVO;

/**
 *
 * @author Mateo Coronado
 */
public class AsistenciaVO {

    public String getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(String id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public String getIdf_asamblea() {
        return idf_asamblea;
    }

    public void setIdf_asamblea(String idf_asamblea) {
        this.idf_asamblea = idf_asamblea;
    }

    public String getCedulaf_Constituyente() {
        return cedulaf_Constituyente;
    }

    public void setCedulaf_Constituyente(String cedulaf_Constituyente) {
        this.cedulaf_Constituyente = cedulaf_Constituyente;
    }

    public AsistenciaVO(String id_asistencia, String idf_asamblea, String cedulaf_Constituyente) {
        this.id_asistencia = id_asistencia;
        this.idf_asamblea = idf_asamblea;
        this.cedulaf_Constituyente = cedulaf_Constituyente;
    }

    public AsistenciaVO() {
    }
    String id_asistencia, idf_asamblea, cedulaf_Constituyente;
}
