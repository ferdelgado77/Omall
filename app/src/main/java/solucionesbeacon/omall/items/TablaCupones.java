package solucionesbeacon.omall.items;

import java.util.ArrayList;
import java.util.List;

public class TablaCupones {
    List<Cupon> ListaCupones = new ArrayList<Cupon>();
    public TablaCupones(){
        super();
    }

    public  List<Cupon> DATOS() {
        ListaCupones.add(new Cupon(1,"Datos del cupon","uno"));
        ListaCupones.add(new Cupon(2,"Este texto es para ver ladiferencia","dos"));
        ListaCupones.add(new Cupon(3,"CON ESTE OTRO TEXTO","tres"));
        ListaCupones.add(new Cupon(4,"VEAMOS A VER COMO SE NOTA LA DIFERENCIA ENTRE LOS DIFERENTES","cuatro"));
        ListaCupones.add(new Cupon(5,"TEXTOS DEFINIDOS EN LA PLATAFORMA DE LOS BEACONS SIN EMBARGO ESTO DEPENDERA DEL DATO FINAL","cinco"));

        return ListaCupones;


    }

}
