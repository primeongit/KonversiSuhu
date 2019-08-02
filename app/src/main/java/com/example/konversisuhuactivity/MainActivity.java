package com.example.konversisuhuactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//inisialisasi/binding awal dari layout
    Spinner spinAsal;
    Spinner spinTujuan;
    EditText txtInput;
    TextView txtHasil;
    Button btnKonversi;
//variabel
    String suhuAsal;
    String suhuTujuan;
    Double strHitung;
    Double doubleSuhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set id
        txtInput = findViewById(R.id.txtInput);
        txtHasil = findViewById(R.id.txtHasil);
        btnKonversi = findViewById(R.id.btnKonversi);
        spinAsal = findViewById(R.id.spinAsal);
        spinTujuan = findViewById(R.id.spinTujuan);

        btnKonversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suhuAsal = spinAsal.getSelectedItem().toString();
                suhuTujuan = spinTujuan.getSelectedItem().toString();
                doubleSuhu = Double.parseDouble(txtInput.getText().toString());
                txtHasil.setText(hitung());
            }
        });
    }
    public String hitung(){
        if(suhuAsal.equals("Celcius") && suhuTujuan.equals("Kelvin")){
            strHitung = doubleSuhu + 273.15;
        }
        else if (suhuAsal.equals("Celcius") && suhuTujuan.equals("Fahrenheit")){
            strHitung = (doubleSuhu*1.8) + 32;
        }
        else if (suhuAsal.equals("Celcius") && suhuTujuan.equals("Celcius")){
            strHitung = doubleSuhu;
        }
        else if (suhuAsal.equals("Fahrenheit") && suhuTujuan.equals("Fahrenheit")){
            strHitung = doubleSuhu;
        }
        else if (suhuAsal.equals("Fahrenheit") && suhuTujuan.equals("Celcius")){
            strHitung = (doubleSuhu-32) / 1.8;
        }
        else if (suhuAsal.equals("Fahrenheit") && suhuTujuan.equals("Kelvin")){
            strHitung = (doubleSuhu-32) * 5/9 + 273.15;
        }
        else if (suhuAsal.equals("Kelvin") && suhuTujuan.equals("Kelvin")){
            strHitung = doubleSuhu;
        }
        else if (suhuAsal.equals("Kelvin") && suhuTujuan.equals("Fahrenheit")){
            strHitung = (doubleSuhu-273.15) * 9/5 + 32;
        }
        else if (suhuAsal.equals("Kelvin") && suhuTujuan.equals("Celcius")){
            strHitung = doubleSuhu - 273.15;
        }
        return strHitung.toString();
    }

}
