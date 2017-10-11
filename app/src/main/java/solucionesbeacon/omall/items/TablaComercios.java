package solucionesbeacon.omall.items;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fernando Delgado on 25/09/2017.
 */

public class TablaComercios {
    List<Comercio> LISTAComercios = new ArrayList<Comercio>();
    public TablaComercios(){
        super();
    }

    public  List<Comercio> DATOS() {
        LISTAComercios.add(new Comercio("1","Primero","big",false));
        LISTAComercios.add(new Comercio("2","Segundo","burger",false));
        LISTAComercios.add(new Comercio("3","Tercero","chipotle",false));
        LISTAComercios.add(new Comercio("4","Cuarto","cuadritos",false));
        LISTAComercios.add(new Comercio("5","Quinto","pe",false));
        LISTAComercios.add(new Comercio("6","Sexto","small",false));
        LISTAComercios.add(new Comercio("7","Septimo","starbucks",false));
        LISTAComercios.add(new Comercio("8","Octavo","tiny",false));
        LISTAComercios.add(new Comercio("9","Noveno","visa",false));
        return LISTAComercios;


    }
}
