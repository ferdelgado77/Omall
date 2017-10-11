package solucionesbeacon.omall;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import solucionesbeacon.omall.dummy.DummyContent;
import solucionesbeacon.omall.dummy.DummyContent.DummyItem;
import solucionesbeacon.omall.items.Comercios;
import solucionesbeacon.omall.items.Comercio;
import solucionesbeacon.omall.items.TablaComercios;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
public class SubscripFragment extends Fragment {
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    List<Comercio> LISTAComercios = new ArrayList<Comercio>();
    SubscripItemAdapter ADAComercios;
    SharedPreferences sharedPref;
    TablaComercios TBLCOM;

    public SubscripFragment() {
    }
    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static SubscripFragment newInstance(int columnCount) {
        SubscripFragment fragment = new SubscripFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        sharedPref = this.getContext().getSharedPreferences("SUSCRIPCIONES", MODE_PRIVATE);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        TBLCOM = new TablaComercios();
        LISTAComercios = TBLCOM.DATOS();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_itemsubscrip_list, container, false);
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            for(Comercio CLISTA : LISTAComercios){
                boolean SUSCRITO =  sharedPref.getBoolean(CLISTA.getId().toString(),false);
                LISTAComercios.get(Integer.parseInt(CLISTA.getId())-1).setEstado(SUSCRITO);
            }
            ADAComercios = new SubscripItemAdapter(LISTAComercios, mListener);
            recyclerView.setAdapter(ADAComercios);
            ADAComercios.notifyDataSetChanged();

        }
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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


    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPref.edit();
        for(Comercio CLISTA : LISTAComercios){
            editor.putBoolean(CLISTA.getId(), CLISTA.isEstado());
        }
        editor.commit();



    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Comercio item);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // BARREMOS LA LISTA DE COMERCIOS PARA VER CUANTOS ESTAN CON
        // UN CHECK Y GUARAMOS CADA UNO CON SU RESPECTIVA POSICION
        SharedPreferences.Editor editor = sharedPref.edit();
        for(Comercio CLISTA : LISTAComercios){
             editor.putBoolean(CLISTA.getId(), CLISTA.isEstado());
        }
        editor.commit();

        super.onSaveInstanceState(outState);
    }

}
