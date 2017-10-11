package solucionesbeacon.omall;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import solucionesbeacon.omall.FavoritosFragment.OnListFragmentInteractionListener;
import solucionesbeacon.omall.dummy.DummyContent.DummyItem;
import solucionesbeacon.omall.items.Favorito;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class FavoritosRecyclerViewAdapter extends RecyclerView.Adapter<FavoritosRecyclerViewAdapter.ViewHolder> {
    private final List<Favorito> mValues;
    Context CONTEXTO;

    private final OnListFragmentInteractionListener mListener;

    public FavoritosRecyclerViewAdapter(List<Favorito> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_itemfavoritos, parent, false);
        CONTEXTO =parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        String DATO;
        DATO=mValues.get(position).details;
        holder.mDetailsView.setText(mValues.get(position).details);
        /*holder.mDetailsView.setText(Html.fromHtml("<p align=right> <b> "
                + "<br>" +DATO + "  </br> "
                +  "  </b> </p>"));*/

        String IMAGEN = mValues.get(position).details;
        Integer iid = CONTEXTO.getResources().getIdentifier(IMAGEN,"drawable",CONTEXTO.getPackageName());
        holder.LOGOFAV.setImageResource(iid);


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                   /* CharSequence text = holder.mIdView.getText();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(CONTEXTO, text, duration);
                    toast.show();*/
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
        public final TextView mDetailsView;
        public final ImageView LOGOFAV;
        public Favorito mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mDetailsView = (TextView) view.findViewById(R.id.details);
            LOGOFAV = (ImageView) view.findViewById(R.id.LogoFav);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mDetailsView.getText() + "'";
        }
    }

    public void VerMensajes(){
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(CONTEXTO, text, duration);
        toast.show();
    }




}
