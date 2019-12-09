/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TemasVO;

/**
 *
 * @author mp4ma
 */
public class UsuarioVO {
    
     String cel_usu, tipo_usu, password_usu, estado_usu;
     
       public UsuarioVO(){
    }

    

    public void setCel_usu(String cel_usu) {
        this.cel_usu = cel_usu;
    }

    public void setTipo_usu(String tipo_usu) {
        this.tipo_usu = tipo_usu;
    }

    public void setPassword_usu(String password_usu) {
        this.password_usu = password_usu;
    }

    public String getCel_usu() {
        return cel_usu;
    }

    public String getTipo_usu() {
        return tipo_usu;
    }

    public String getPassword_usu() {
        return password_usu;
    }
         public UsuarioVO(String cel_usu, String tipo_usu, String password_usu, String estado_usu) {
        this.cel_usu = cel_usu;
        this.tipo_usu = tipo_usu;
        this.password_usu = password_usu;
        this.estado_usu= estado_usu;
    }

    public String getEstado_usu() {
        return estado_usu;
    }

    public void setEstado_usu(String estado_usu) {
        this.estado_usu = estado_usu;
    }
       
    
}
