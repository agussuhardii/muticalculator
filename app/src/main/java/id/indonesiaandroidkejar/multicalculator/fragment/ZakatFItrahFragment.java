package id.indonesiaandroidkejar.multicalculator.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import id.indonesiaandroidkejar.multicalculator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZakatFItrahFragment extends Fragment {
    Button btnCalc;
    EditText editBeras;
    TextView txtValues;


    public ZakatFItrahFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zakat_fitrah, container, false);

        btnCalc = (Button) view.findViewById(R.id.btnCalc);
        txtValues = (TextView) view.findViewById(R.id.txtValues);
        editBeras = (EditText) view.findViewById(R.id.editHargaBeras);


        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateZakatFitra();
            }
        });
        return view;
    }


    public void calculateZakatFitra() {
        Double bahanPokok = Double.valueOf(editBeras.getText().toString());
        Double result = bahanPokok * 3.5;
        txtValues.setText(result.toString());
        //editBeras.setText(null);
    }

}
