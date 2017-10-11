package solucionesbeacon.omall;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import solucionesbeacon.omall.items.Comercio;
import solucionesbeacon.omall.items.Favorito;
import solucionesbeacon.omall.dummy.DummyContent;
import solucionesbeacon.omall.dummy.DummyContent.DummyItem;
import solucionesbeacon.omall.items.Favorito;
import solucionesbeacon.omall.items.TablaComercios;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class FavoritosFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private  SharedPreferences sharedPref;
    private  List<Favorito> ListaFavoritos = new ArrayList<Favorito>();
    FavoritosRecyclerViewAdapter ADAFAV;
    //NECESITO ACCESAR LA LISTA ORIGINAL PARA VER EL NOMBRE DEL LOGO
    List<Comercio> LISTAComercios = new ArrayList<Comercio>();
    TablaComercios TBLCOM;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FavoritosFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static FavoritosFragment newInstance(int columnCount) {
        FavoritosFragment fragment = new FavoritosFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        //sharedPref = this.getContext().getSharedPreferences("SUSCRIPCIONES", MODE_PRIVATE);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPref = this.getContext().getSharedPreferences("SUSCRIPCIONES", MODE_PRIVATE);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_itemfavoritos_list, container, false);
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            //ActualizaListado();
            ADAFAV = new FavoritosRecyclerViewAdapter(ListaFavoritos, mListener);
            recyclerView.setAdapter(ADAFAV);
            ADAFAV.notifyDataSetChanged();
            //recyclerView.setAdapter(new FavoritosRecyclerViewAdapter( DummyContent.ITEMS, mListener));
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        sharedPref = this.getContext().getSharedPreferences("SUSCRIPCIONES", MODE_PRIVATE);
        TBLCOM = new TablaComercios();
        LISTAComercios = TBLCOM.DATOS();
        ActualizaListado();
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Favorito item);
    }

    public void ActualizaListado(){
        ListaFavoritos.clear();
        for(int i=1; i<10; i++){
            boolean FAVORITO =sharedPref.getBoolean(Integer.toString(i),false);
            if (FAVORITO==true){

                ListaFavoritos.add(new Favorito(Integer.toString(i),LISTAComercios.get(i-1).getDetails()));
            }
        }
        }



    @Override
    public void onResume() {
        super.onResume();
        ActualizaListado();


    }
}
