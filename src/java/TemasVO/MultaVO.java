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
public class MultaVO {

    public MultaVO(String id_multa, String idf_asistencia,String cedulaf_constituyente, String descripcion_multa, String pago_multa, String fecha_multa, String fecha_pago,String estado_multa) {
        this.id_multa = id_multa;
        this.idf_asistencia = idf_asistencia;
        this.cedulaf_constituyente = cedulaf_constituyente;
        this.descripcion_multa = descripcion_multa;
        this.pago_multa = pago_multa;
        this.fecha_multa = fecha_multa;
        this.fecha_pago = fecha_pago;
        this.estado_multa = estado_multa;
    }

    public String getEstado_multa() {
        return estado_multa;
    }

    public void setEstado_multa(String estado_multa) {
        this.estado_multa = estado_multa;
    }

    public String getCedulaf_constituyente() {
        return cedulaf_constituyente;
    }

    public void setCedulaf_constituyente(String cedulaf_constituyente) {
        this.cedulaf_constituyente = cedulaf_constituyente;
    }

    public String getId_multa() {
        return id_multa;
    }

    public void setId_multa(String id_multa) {
        this.id_multa = id_multa;
    }

    public String getIdf_asistencia() {
        return idf_asistencia;
    }

    public void setIdf_asistencia(String idf_asistencia) {
        this.idf_asistencia = idf_asistencia;
    }

    public String getDescripcion_multa() {
        return descripcion_multa;
    }

    public void setDescripcion_multa(String descripcion_multa) {
        this.descripcion_multa = descripcion_multa;
    }

    public String getPago_multa() {
        return pago_multa;
    }

    public void setPago_multa(String pago_multa) {
        this.pago_multa = pago_multa;
    }

    public String getFecha_multa() {
        return fecha_multa;
    }

    public void setFecha_multa(String fecha_multa) {
        this.fecha_multa = fecha_multa;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    private String id_multa;
    private String idf_asistencia;
    private String cedulaf_constituyente;
    private String descripcion_multa;
    private String pago_multa;
    private String fecha_multa;
    private String fecha_pago;
    private String estado_multa;

    public MultaVO() {
    }

}
