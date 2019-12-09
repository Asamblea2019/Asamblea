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
public class Conteo_VotosVO {
    
    private String contId;
    private String contIdfPregunta;
    private String contTotal;
    
    public Conteo_VotosVO(String contId, String contIdfPregunta, String contTotal){
        this.contId = contId;
        this.contIdfPregunta = contIdfPregunta;
        this.contTotal = contTotal;
    }

    public String getContId() {
        return contId;
    }

    public void setContId(String contId) {
        this.contId = contId;
    }

    public String getContIdfPregunta() {
        return contIdfPregunta;
    }

    public void setContIdfPregunta(String contIdfPregunta) {
        this.contIdfPregunta = contIdfPregunta;
    }

    public String getContTotal() {
        return contTotal;
    }

    public void setContTotal(String contTotal) {
        this.contTotal = contTotal;
    }
    
    public Conteo_VotosVO(){}
    
    
    
}
