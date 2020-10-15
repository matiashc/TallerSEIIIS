package co.edu.ufps.seiiis2020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TiendaAdapter extends RecyclerView.Adapter<TiendaAdapter.TiendaViewHolder>{
    private Context context;
    private ArrayList<Tienda> tiendas;
    private int curso;

    public TiendaAdapter(Context context, ArrayList<Tienda> tiendas, int curso) {
        this.context = context;
        this.tiendas = tiendas;
        this.curso = curso;
    }

    @NonNull
    @Override
    public TiendaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview,parent,false);
        return new TiendaViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull TiendaViewHolder holder, int position) {
        holder.tituloTienda.setText(tiendas.get(position).getNombre());
        holder.descripcionTienda.setText(tiendas.get(position).getDescripcion());
        holder.telefono.setText(tiendas.get(position).getTelefono());
        holder.horario.setText(tiendas.get(position).getHorario());
        Picasso.get().load(tiendas.get(position).getImagen()).into(holder.imagenTienda);
    }

    @Override
    public int getItemCount() {
        return tiendas.size();
    }

    static class TiendaViewHolder extends RecyclerView.ViewHolder{
        TextView tituloTienda;
        TextView descripcionTienda;
        ImageView imagenTienda;
        TextView telefono;
        TextView horario;
        public TiendaViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloTienda = itemView.findViewById(R.id.titulotienda);
            descripcionTienda = itemView.findViewById(R.id.descripciontienda);
            imagenTienda = itemView.findViewById(R.id.imagentienda);
            telefono = itemView.findViewById(R.id.telefono);
            horario = itemView.findViewById(R.id.horario);
        }
    }
}
