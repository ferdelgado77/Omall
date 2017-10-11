package solucionesbeacon.omall;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import solucionesbeacon.omall.dummy.DummyContent;
import solucionesbeacon.omall.items.Comercio;
import solucionesbeacon.omall.items.Comercios;
import solucionesbeacon.omall.items.Favorito;

public class MainActivity extends AppCompatActivity
        implements FragFavoritos.OnFragmentInteractionListener,
        ItemFragment.OnListFragmentInteractionListener,
        SubscripFragment.OnListFragmentInteractionListener,
        FavoritosFragment.OnListFragmentInteractionListener,
        ContCupones.OnFragmentInteractionListener{

    final Fragment FRAGFAVORITOS= new FavoritosFragment();
     Fragment CONTCUPO;
    Fragment  FRAGSUBSCRIP;

    Class fragmentClass=null;
    FragmentManager fragmentManager = null;
    FragmentTransaction fragmentTransaction;





    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.FRTEMP, FRAGFAVORITOS);
                        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        fragmentTransaction.addToBackStack("FRFAVORITOS");
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_dashboard:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.FRTEMP,  CONTCUPO);
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    fragmentTransaction.addToBackStack("FRCONTCUPO");
                    fragmentTransaction.commit();
                    return true;

                case R.id.navigation_notifications:
                    fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.FRTEMP, FRAGSUBSCRIP);
                        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        fragmentTransaction.addToBackStack("FRSUSCRIP");
                    fragmentTransaction.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //FRAGFAVORITOS = new FavoritosFragment();
        //CONTCUPO = new ContCupones();
        CONTCUPO = (Fragment) ContCupones.newInstance("A","B");
        FRAGSUBSCRIP = new SubscripFragment();
        navigation.setSelectedItemId(R.id.navigation_home);


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(Comercio item) {
        System.out.println("DATOS DATOS DATOS");
    }

    @Override
    public void onListFragmentInteraction(Favorito item) {
       BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        CONTCUPO = (Fragment) ContCupones.newInstance("A",item.getDetails());
        navigation.setSelectedItemId(R.id.navigation_dashboard);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
    }
}
