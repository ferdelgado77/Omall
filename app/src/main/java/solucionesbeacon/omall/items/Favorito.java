package solucionesbeacon.omall.items;
public class Favorito {
    public final String id;
    public final String details;
    public String getId() {
        return id;
    }
    public String getDetails() {
        return details;
    }
    public Favorito(String id,  String details) {
        this.id = id;
        this.details = details;
    }
}
