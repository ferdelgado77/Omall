package solucionesbeacon.omall;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContCupones.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContCupones#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContCupones extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Context CONTEXTO;
    //contexto desde la casa subamoslo
    // segunda subida
    // TERCERA SUBIDA
    // LA CUARTA ES LA VENCIDA
    // veamos a ver si la quinta
       public void setmParam1(String mParam1) {
        this.mParam1 = mParam1;
    }

    public void setmParam2(String mParam2) {
        this.mParam2 = mParam2;
    }

    public String getmParam1() {

        return mParam1;
   }

    public String getmParam2() {
        return mParam2;
    }

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView   cc;

    private OnFragmentInteractionListener mListener;

    public ContCupones() {
           //cc = (TextView) this.getActivity().findViewById(R.id.CODTIENDA);
        // Required empty public constructor DESDE LA CASA
    }


    // TODO: Rename and change types and number of parameters
    public static ContCupones newInstance(String param1, String param2) {
        ContCupones fragment = new ContCupones();
        Bundle args = new Bundle();

        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inf = inflater.inflate(R.layout.fragment_cont_cupones, container, false);
        cc= (TextView)inf.findViewById(R.id.CODTIENDA);
        ImageView IV = (ImageView)inf.findViewById(R.id.imageView);
        CONTEXTO = this.getContext();
          // solo para ver si lo sube bien como
//ESTAMOS VIENDO
              Integer iid = CONTEXTO.getResources().getIdentifier(mParam2,"drawable",CONTEXTO.getPackageName());
        cc.setText(mParam2);
        IV.setImageResource(iid);
        return inf;


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
