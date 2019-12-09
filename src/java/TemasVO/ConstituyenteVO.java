/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasVO;

/**
 *
 * @author Cristian
 */
public class ConstituyenteVO {

    public String getCedula_Constituyente() {
        return cedula_Constituyente;
    }

    public void setCedula_Constituyente(String cedula_Constituyente) {
        this.cedula_Constituyente = cedula_Constituyente;
    }

    public String getCedulaf_Usuario() {
        return cedulaf_Usuario;
    }

    public void setCedulaf_Usuario(String cedulaf_Usuario) {
        this.cedulaf_Usuario = cedulaf_Usuario;
    }

    public String getNombre_Constituyete() {
        return nombre_Constituyete;
    }

    public void setNombre_Constituyete(String nombre_Constituyete) {
        this.nombre_Constituyete = nombre_Constituyete;
    }

    public String getApellido_Constituyente() {
        return apellido_Constituyente;
    }

    public void setApellido_Constituyente(String apellido_Constituyente) {
        this.apellido_Constituyente = apellido_Constituyente;
    }

    public String getCorreo_Constituyente() {
        return correo_Constituyente;
    }

    public void setCorreo_Constituyente(String correo_Constituyente) {
        this.correo_Constituyente = correo_Constituyente;
    }

    public String getCel_Constituyente() {
        return cel_Constituyente;
    }

    public void setCel_Constituyente(String cel_Constituyente) {
        this.cel_Constituyente = cel_Constituyente;
    }


    
    String cedula_Constituyente,cedulaf_Usuario,nombre_Constituyete,
            apellido_Constituyente,correo_Constituyente,cel_Constituyente,
             estado_Constituyenye, poder;
    
    public ConstituyenteVO (){}
    
    public ConstituyenteVO(String cedula_Constituyente,String cedulaf_Usuario,
    String nombre_Constituyete,String apellido_Constituyente,String correo_Constituyente,
    String cel_Constituyente,String estado_Constituyente, String poder )
    {
        this.cedula_Constituyente=cedula_Constituyente;
        this.cedulaf_Usuario=cedulaf_Usuario;
        this.nombre_Constituyete=nombre_Constituyete;
        this.apellido_Constituyente=apellido_Constituyente;
        this.correo_Constituyente=correo_Constituyente;
        this.cel_Constituyente=cel_Constituyente;
        this.estado_Constituyenye=estado_Constituyente;
        this.poder=poder;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public String getEstado_Constituyenye() {
        return estado_Constituyenye;
    }

    public void setEstado_Constituyenye(String estado_Constituyenye) {
        this.estado_Constituyenye = estado_Constituyenye;
    }
}

