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
public class InformeVO {
    private String inId;
    private String inIdfAsamblea;
    private String inNombre;
    private String inRedactor;
    private String inFecha;
    private String inEstado;
    
    public InformeVO(String inId, String inIdfAsamblea, String inNombre, String inRedactor, String inFecha, String inEstado){
        this.inId = inId;
        this.inIdfAsamblea = inIdfAsamblea;
        this.inNombre = inNombre;
        this.inRedactor = inRedactor;
        this.inFecha = inFecha;
        this.inEstado = inEstado;
    }

    public String getInEstado() {
        return inEstado;
    }

    public void setInEstado(String inEstado) {
        this.inEstado = inEstado;
    }

    public String getInId() {
        return inId;
    }

    public void setInId(String inId) {
        this.inId = inId;
    }

    public String getInIdfAsamblea() {
        return inIdfAsamblea;
    }

    public void setInIdfAsamblea(String inIdfAsamblea) {
        this.inIdfAsamblea = inIdfAsamblea;
    }

    public String getInNombre() {
        return inNombre;
    }

    public void setInNombre(String inNombre) {
        this.inNombre = inNombre;
    }

    public String getInRedactor() {
        return inRedactor;
    }

    public void setInRedactor(String inRedactor) {
        this.inRedactor = inRedactor;
    }

    public String getInFecha() {
        return inFecha;
    }

    public void setInFecha(String inFecha) {
        this.inFecha = inFecha;
    }
    
    public InformeVO(){
    }
    
    
    
}
