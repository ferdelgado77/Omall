package solucionesbeacon.omall;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import solucionesbeacon.omall.items.Comercio;
import solucionesbeacon.omall.SubscripFragment.OnListFragmentInteractionListener;
import solucionesbeacon.omall.items.Favorito;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class SubscripItemAdapter extends RecyclerView.Adapter<SubscripItemAdapter.ViewHolder> {
    private final List<Comercio> mValues;
    Context CONTEXTO;
    SharedPreferences sharedPref;
    private final OnListFragmentInteractionListener mListener;
    public SubscripItemAdapter(List<Comercio> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_itemsubscrip, parent, false);
        CONTEXTO =parent.getContext();
        sharedPref = CONTEXTO.getSharedPreferences("SUSCRIPCIONES", MODE_PRIVATE);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.SUSCRITO.setChecked(mValues.get(position).estado);
        String IMAGEN = mValues.get(position).details;
        Integer iid = CONTEXTO.getResources().getIdentifier(IMAGEN,"drawable",CONTEXTO.getPackageName());
        holder.LOGO.setImageResource(iid);


        holder.SUSCRITO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Comercio comcom;
                comcom = mValues.get(position);
                comcom.estado = holder.SUSCRITO.isChecked();
                mValues.set(position, comcom);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean(Integer.toString(position), comcom.estado);
                editor.commit();

           }
        });

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public final Switch SUSCRITO;
        public final ImageView LOGO;
        public Comercio mItem;
        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
            LOGO = (ImageView) view.findViewById(R.id.Logo);
            SUSCRITO = (Switch) view.findViewById(R.id.SUSCRITO);
        }
        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
