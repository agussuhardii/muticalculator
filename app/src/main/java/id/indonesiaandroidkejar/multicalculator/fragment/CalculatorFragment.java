package id.indonesiaandroidkejar.multicalculator.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import id.indonesiaandroidkejar.multicalculator.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment {

    Button nol, satu, dua, tiga, empat, lima, enam, tuju, delapan, sembilan;
    Button tambah, kali, bagi, kurang, samaDeangan, kembali, c;
    EditText editValues;

    String values;
    char op;


    public CalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        loadXML(view);
        onClickButton();
        return view;
    }

    //load xml ID
    public void loadXML(View v) {
        nol = (Button) v.findViewById(R.id.btnNol);
        satu = (Button) v.findViewById(R.id.btnSatu);
        dua = (Button) v.findViewById(R.id.btnDua);
        tiga = (Button) v.findViewById(R.id.btnTiga);
        empat = (Button) v.findViewById(R.id.btnEmpat);
        lima = (Button) v.findViewById(R.id.btnLima);
        enam = (Button) v.findViewById(R.id.btnEnam);
        tuju = (Button) v.findViewById(R.id.btnTujuh);
        delapan = (Button) v.findViewById(R.id.btnDelapan);
        sembilan = (Button) v.findViewById(R.id.btnSembilan);

        tambah = (Button) v.findViewById(R.id.btnPlus);
        kali = (Button) v.findViewById(R.id.btnKali);
        bagi = (Button) v.findViewById(R.id.btnBagi);
        kurang = (Button) v.findViewById(R.id.btnmin);
        samaDeangan = (Button) v.findViewById(R.id.btnEquals);
        c = (Button) v.findViewById(R.id.btnC);

        editValues = (EditText) v.findViewById(R.id.editValues);
    }

    public void onClickButton() {
        values = editValues.getText().toString();

        nol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editValues.setText(editValues.getText().toString() + "0");
            }
        });
        satu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editValues.setText(editValues.getText().toString() + "1");
            }
        });
        dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editValues.setText(editValues.getText().toString() + "2");
            }
        });
        tiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editValues.setText(editValues.getText().toString() + "3");
            }
        });
        empat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editValues.setText(editValues.getText().toString() + "4");
            }
        });
        lima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editValues.setText(editValues.getText().toString() + "5");
            }
        });
        enam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editValues.setText(editValues.getText().toString() + "6");
            }
        });
        tuju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editValues.setText(editValues.getText().toString() + "7");
            }
        });
        delapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editValues.setText(editValues.getText().toString() + "8");
            }
        });
        sembilan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editValues.setText(editValues.getText().toString() + "9");
            }
        });
        //operasi
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editValues.setText(editValues.getText().toString() + "+");
            }
        });
        kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editValues.setText(editValues.getText().toString() + "X");
            }
        });
        bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editValues.setText(editValues.getText().toString() + ":");
            }
        });
        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editValues.setText(editValues.getText().toString() + "-");
            }
        });
        //delete text
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editValues.getText().toString().trim().equalsIgnoreCase("")) {
                    String s = editValues.getText().toString();
                    editValues.setText(s.substring(0, s.length() - 1));
                }
            }
        });
        samaDeangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editValues.getText().toString();
                float[] angka = pisahkan(s);
                hitung(angka);
            }
        });
    }

    private float[] pisahkan(String s) {
        float[] e = new float[2];
        int p = s.indexOf('X');
        op = 'X';
        if (p < 0) {
            p = s.indexOf(':');
            op = ':';
        }
        if (p < 0) {
            p = s.indexOf('+');
            op = '+';
        }
        if (p < 0) {
            p = s.indexOf('-');
            op = '-';
        }
        String s1 = s.substring(0, p);
        String s2 = s.substring(p + 1, s.length());
        e[0] = Float.parseFloat(s1.trim());
        e[1] = Float.parseFloat(s2.trim());
        return e;
    }

    private void hitung(float[] a) {
        float h = 0.0f;
        switch (op) {
            case ('X'): {
                h = a[0] * a[1];
                break;
            }
            case (':'): {
                h = a[0] / a[1];
                break;
            }
            case ('+'): {
                h = a[0] + a[1];
                break;
            }
            case ('-'): {
                h = a[0] - a[1];
                break;
            }
            default: {
            }
        }
        editValues.setText(String.valueOf(h));
    }


}
