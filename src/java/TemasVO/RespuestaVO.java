/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasVO;

/**
 *
 * @author fugo5
 */
public class RespuestaVO {
    private String resId;
    private String resIdfPregunta;
    private String resRespuesta;
    private String resEstado;
    
    public RespuestaVO(String resId, String resIdfPregunta, String resRespuesta, String resEstado)
    {
        this.resId = resId;
        this.resIdfPregunta = resIdfPregunta;
        this.resRespuesta = resRespuesta;
        this.resEstado = resEstado;
    }

    public String getResEstado() {
        return resEstado;
    }

    public void setResEstado(String resEstado) {
        this.resEstado = resEstado;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getResIdfPregunta() {
        return resIdfPregunta;
    }

    public void setResIdfPregunta(String resIdfPregunta) {
        this.resIdfPregunta = resIdfPregunta;
    }

    public String getResRespuesta() {
        return resRespuesta;
    }

    public void setResRespuesta(String resRespuesta) {
        this.resRespuesta = resRespuesta;
    }
    public RespuestaVO(){}
}
