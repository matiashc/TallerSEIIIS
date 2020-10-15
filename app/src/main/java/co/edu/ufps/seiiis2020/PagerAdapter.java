package co.edu.ufps.seiiis2020;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private int numTabs;
    public PagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs = numTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TiendaFragment();
            case 1:
                return new MapaFragment();
            case 2:
                return new PerfilFragment();
            default:
                return null;
        }


    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
