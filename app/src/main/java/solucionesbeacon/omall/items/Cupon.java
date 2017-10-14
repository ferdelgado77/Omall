package solucionesbeacon.omall.items;

/**
 * Created by Fernando Delgado on 14/10/2017.
 */

public class Cupon {
    public  Integer idCupon;
    public  String txtEnc;
    public   String txtDet;

    public Cupon(Integer id,  String encabezado,String estado) {
        this.idCupon = id;
        this.txtEnc = encabezado  ;
        this.txtDet = estado;
    }
    public void setIdCupon(Integer idCupon) {
        this.idCupon = idCupon;
    }
    public void setTxtEnc(String textEnc) {
        this.txtEnc = textEnc;
    }
    public void setTxtDet(String textDet) {
        this.txtDet = textDet;
    }
    public Integer getIdCupon() {
        return idCupon;
    }
    public String getTxtEnc() {
        return txtEnc;
    }
    public String getTxtDet() {
        return txtDet;
    }
}
