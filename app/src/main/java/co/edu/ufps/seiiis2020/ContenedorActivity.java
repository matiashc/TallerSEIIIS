package co.edu.ufps.seiiis2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class ContenedorActivity extends AppCompatActivity {
    TabItem tienda;
    TabItem perfil;
    TabItem mapa;
    TabLayout tabs;
    ViewPager contenedor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor);
        tienda = findViewById(R.id.tienda);
        perfil = findViewById(R.id.perfil);
        mapa = findViewById(R.id.mapa);
        tabs = findViewById(R.id.tabs);
        contenedor = findViewById(R.id.contenedor);
        // para realizar el menu
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabs.getTabCount());
        contenedor.setAdapter(pagerAdapter);
        contenedor.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));

    }
}