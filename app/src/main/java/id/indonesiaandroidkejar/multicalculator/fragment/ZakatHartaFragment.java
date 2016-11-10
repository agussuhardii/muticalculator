package id.indonesiaandroidkejar.multicalculator.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.indonesiaandroidkejar.multicalculator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZakatHartaFragment extends Fragment {


    public ZakatHartaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_zakat_harta, container, false);
        return view;
    }

}
