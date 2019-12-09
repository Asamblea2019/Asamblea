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
public class PreguntaVO {

    public void setId_pregunta(String id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public void setIdf_votacion(String idf_votacion) {
        this.idf_votacion = idf_votacion;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getId_pregunta() {
        return id_pregunta;
    }

    public String getIdf_votacion() {
        return idf_votacion;
    }

    public String getPregunta() {
        return pregunta;
    }

    public PreguntaVO() {
    }

    public PreguntaVO(String id_pregunta, String idf_votacion, String pregunta, String estado_pregunta) {
        this.id_pregunta = id_pregunta;
        this.idf_votacion = idf_votacion;
        this.pregunta = pregunta;
        this.estado_pregunta = estado_pregunta;
    }

    public String getEstado_pregunta() {
        return estado_pregunta;
    }

    public void setEstado_pregunta(String estado_pregunta) {
        this.estado_pregunta = estado_pregunta;
    }
    String id_pregunta, idf_votacion, pregunta, estado_pregunta;
}
