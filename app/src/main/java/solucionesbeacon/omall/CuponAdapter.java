package solucionesbeacon.omall;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import solucionesbeacon.omall.items.Cupon;

/**
 * Created by Fernando Delgado on 14/10/2017.
 */

public class CuponAdapter extends ArrayAdapter<Cupon> {
    Context context;
    int layoutResourceId;
    List<Cupon> data ;
    public CuponAdapter(Context context, int layoutResourceId, List<Cupon> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CuponAdapter.CuponHolder FILA;
        if (row==null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            FILA = new CuponHolder();
            FILA.tvENCABEZADO =(TextView)row.findViewById(R.id.txtEncCupon);
            FILA.tvDetalle =(TextView)row.findViewById(R.id.txtDetCupon);
            row.setTag(FILA);

        }
        else{
            FILA= (CuponHolder)row.getTag();
             }
             Cupon CuponActual=data.get(position);
             FILA.tvENCABEZADO.setText(CuponActual.txtEnc);
             FILA.tvDetalle.setText(CuponActual.txtDet);
        return row;
    }



    static class CuponHolder
    {
        TextView tvENCABEZADO;
        TextView tvDetalle;

    }


}
