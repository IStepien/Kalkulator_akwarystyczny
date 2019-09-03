package com.example.kalkulator_akwarystyczny;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorOneDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator1_detail);

        final Double aquariumCapacity = 100.0;
        final Double dailyDose = 10.0;
        final Double fertilizerQuantity = 200.0;

        final EditText editText_Kquantity = findViewById(R.id.editText_Kquantity);
        final EditText editText_NOquantity = findViewById(R.id.editText_NOquantity);
        final EditText editText_POquantity = findViewById(R.id.editText_POquantity);
        final EditText editText_MGquantity = findViewById(R.id.editText_MGquantity);

        Button btnCalculate = findViewById(R.id.button);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double Kquantity = Double.valueOf(editText_Kquantity.getText().toString());
                Double NOquantity = Double.valueOf(editText_NOquantity.getText().toString());
                Double POquantity = Double.valueOf(editText_POquantity.getText().toString());
                Double MGquantity = Double.valueOf(editText_MGquantity.getText().toString());

                CalculatorOne calculatorOne = new CalculatorOne(aquariumCapacity, dailyDose, fertilizerQuantity, Kquantity, NOquantity, POquantity, MGquantity);

                TextView K2SO4 = findViewById(R.id.textView_K2SO4);
                TextView KCl = findViewById(R.id.textView_KCl);
                TextView KH2PO4 = findViewById(R.id.textView_KH2PO4);
                TextView KNO3 = findViewById(R.id.textView_KNO3);
                TextView MgSO4x7H2O = findViewById(R.id.textView_MgSO4x7H2O);
                TextView calcDescription = findViewById(R.id.textView_calcOne_description);
                calcDescription.setText(R.string.calcOne_description);
//
//                K2SO4.setText(calculatorOne.calculateK2SO4().toString());
//                KCl.setText(calculatorOne.calculateKCl().toString());
//                KH2PO4.setText(calculatorOne.calculateKH2PO4().toString());
//                KNO3.setText(calculatorOne.calculateKNO3().toString());
//                MgSO4x7H2O.setText(calculatorOne.calculateMgSO4x7H2O().toString());
            }
        });


    }

}
