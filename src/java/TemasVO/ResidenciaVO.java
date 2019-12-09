/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasVO;

/**
 *
 * @author USER
 */
public class ResidenciaVO {

    public String getIdResi() {
        return idResi;
    }

    public void setIdResi(String idResi) {
        this.idResi = idResi;
    }

    public String getCedulafConstituyente() {
        return cedulafConstituyente;
    }

    public void setCedulafConstituyente(String cedulafConstituyente) {
        this.cedulafConstituyente = cedulafConstituyente;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ResidenciaVO(String idResi, String cedulafConstituyente, String apartamento, String estado) {
        this.idResi = idResi;
        this.cedulafConstituyente = cedulafConstituyente;
        this.apartamento = apartamento;
        this.estado = estado;
    }
    String idResi, cedulafConstituyente, apartamento, estado;
    public ResidenciaVO(){}
}
