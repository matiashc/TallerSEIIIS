package co.edu.ufps.seiiis2020;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TiendaFragment extends Fragment {
    private static final String TAG ="TiendaFragment" ;
    FirebaseDatabase database;
    DatabaseReference myRef;
    TiendaAdapter tiendaAdapter;
    RecyclerView recyclerViewTienda;
    FloatingActionButton nuevaTienda;
    public TiendaFragment() {
        // Required empty public constructor
    }

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_tienda, container, false);
        recyclerViewTienda = view.findViewById(R.id.recyclerviewtienda);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        LinearLayoutManager linearLayout = new LinearLayoutManager(getContext());
        linearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewTienda.setLayoutManager(linearLayout);
        tiendaAdapter = new TiendaAdapter(getActivity(),cargarDatosFirebase(),R.layout.cardview);
        recyclerViewTienda.setAdapter(tiendaAdapter);
        nuevaTienda = view.findViewById(R.id.btnuevatienda);
        nuevaTienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irNuevaTienda();
            }
        });
        return view;
        
    }

    private void irNuevaTienda() {
        Intent intent = new Intent(getActivity(), NuevaTiendaActivity.class);
        startActivity(intent);

    }

    public ArrayList<Tienda> cargarDatosFirebase(){
        final ArrayList<Tienda> tiendas = new ArrayList<>();
        // Read from the database
        myRef.child("tiendas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tiendas.clear();
                if (dataSnapshot.exists()){
                    for(DataSnapshot data: dataSnapshot.getChildren()){
                        Tienda reporte = data.getValue(Tienda.class);
                        tiendas.add(reporte);
                        tiendaAdapter.notifyDataSetChanged();

                    }
                }
                //Log.d(TAG, "Value is: ");
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        // Write a message to the database

        return tiendas;
    }
}