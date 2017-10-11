package solucionesbeacon.omall.items;

/**
 * Created by Fernando Delgado on 25/09/2017.
 */

public class Comercio {
    public final String id;
    //public final String content;
    public final String details;
    public  boolean estado;

    public String getId() {
        return id;
    }

//    public String getContent() {
//        return content;
//    }

   public String getDetails() {
        return details;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }



    public Comercio(String id, String content, String details,boolean estado) {
        this.id = id;
//        this.content = content;
        this.details = details;
        this.estado = estado;
    }

    //@Override
//    public String toString() {
//        return content;
//    }
}
