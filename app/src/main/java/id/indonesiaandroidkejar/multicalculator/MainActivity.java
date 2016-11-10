package id.indonesiaandroidkejar.multicalculator;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import id.indonesiaandroidkejar.multicalculator.fragment.AboutFragment;
import id.indonesiaandroidkejar.multicalculator.fragment.CalculatorFragment;
import id.indonesiaandroidkejar.multicalculator.fragment.ComputerNetworkFragment;
import id.indonesiaandroidkejar.multicalculator.fragment.ZakatFItrahFragment;
import id.indonesiaandroidkejar.multicalculator.fragment.ZakatHartaFragment;
import id.indonesiaandroidkejar.multicalculator.fragment.ZakatProfesiFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        loadFragment(new CalculatorFragment());

    }

    @Override
    public void onBackPressed() {
        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/
        exit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            //return true;
            loadFragment(new AboutFragment());
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_simple_calculator) {
            loadFragment(new CalculatorFragment());

        } else if (id == R.id.nav_zakat_fitra) {
            loadFragment(new ZakatFItrahFragment());

        } else if (id == R.id.nav_zakat_pekerjaan) {
            loadFragment(new ZakatProfesiFragment());

        } else if (id == R.id.nav_zakat_harta) {
            loadFragment(new ZakatHartaFragment());

        } else if (id == R.id.nav_network_calculator) {
            loadFragment(new ComputerNetworkFragment());

        } else if (id == R.id.nav_exit) {
            exit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //load Fragment
    private void loadFragment(Fragment fr) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFR, fr);
        transaction.commit();
    }

    //confirm Exit
    public void exit() {
        final AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("Keluar");
        msg.setMessage("Keluar Dari Aplikasi");
        msg.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                System.exit(0);
            }
        });
        msg.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        msg.show();
    }


}
