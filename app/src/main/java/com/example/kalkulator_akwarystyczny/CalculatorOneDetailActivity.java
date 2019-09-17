package com.example.kalkulator_akwarystyczny;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;


public class CalculatorOneDetailActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @BindView(R.id.button_calcOne_additionalInfo)
    Button button_additionalInfo;
    @BindView((R.id.editText_waterQuantity))
    EditText waterQuantity;
    @BindView(R.id.editText_acidQuantity)
    EditText acidQuantity;
    @BindView((R.id.editText_acidConcentration))
    EditText acidConcentration;
    @BindView((R.id.textView_calcOne_result))
    TextView calcOneResult;
    @BindView((R.id.spinner_calcOne_acid))
    Spinner spinner;
    @BindView(R.id.textView_calcOne_unit)
    TextView calcOne_unit;
    String[] editTexts;
    ElementsForCalc element;
    View currentLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator1_detail);
        ButterKnife.bind(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.acid_array, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            currentLayout = findViewById(R.id.constraintlayout_calcOne);
        } else {
            currentLayout = findViewById(R.id.scrollView_calcOne);
        }


        button_additionalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdditionalInfoActivity.class);
                startActivity(intent);
            }
        });
        element = ElementsForCalc.HCl;


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String acid = (String) parent.getItemAtPosition(position);

        switch (acid) {
            case ("kwas solny, HCl"):
                acidConcentration.setEnabled(true);
                calcOne_unit.setText(R.string.textView_calcOne_tableContentDescription_unit);
                break;
            case ("kwas siarkowy, H2SO4"):
                element = ElementsForCalc.H2SO4;
                acidConcentration.setEnabled(true);
                calcOne_unit.setText(R.string.textView_calcOne_tableContentDescription_unit);
                break;
            case ("kwas azotowy, HNO3"):
                element = ElementsForCalc.HNO3;
                acidConcentration.setEnabled(true);
                calcOne_unit.setText(R.string.textView_calcOne_tableContentDescription_unit);
                break;
            case ("kwas ortofosforowy, H3PO4"):
                element = ElementsForCalc.H3PO4;
                acidConcentration.setEnabled(true);
                calcOne_unit.setText(R.string.textView_calcOne_tableContentDescription_unit);
                break;
            case ("kwas octowy (ocet)"):
                element = ElementsForCalc.VINEGAR;
                acidConcentration.setEnabled(true);
                calcOne_unit.setText(R.string.textView_calcOne_tableContentDescription_unit);
                break;
            case ("kwas cytrynowy (krystaliczny)"):
                element = ElementsForCalc.ACIDUM_CITRICUM;
                acidConcentration.setEnabled(false);
                calcOne_unit.setText(R.string.textView_calcOne_tableContentDescription_unitG);
        }
        onInputChange();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @OnTextChanged({R.id.editText_waterQuantity, R.id.editText_acidConcentration, R.id.editText_acidQuantity})
    public void onInputChange() {

        editTexts = new String[]{acidConcentration.getText().toString(), acidQuantity.getText().toString(),
                waterQuantity.getText().toString()};
        setToZeroIfEmpty(editTexts);

        Double concentration = Double.valueOf(editTexts[0]);
        if (concentration > 10.0 && element != ElementsForCalc.ACIDUM_CITRICUM) {
            Snackbar snackbar = Snackbar.make(currentLayout, R.string.calcOne_concentrationWarning, Snackbar.LENGTH_LONG);
            snackbar.show();
        }

        if (element == ElementsForCalc.ACIDUM_CITRICUM) {
            Snackbar snackbar = Snackbar.make(currentLayout, R.string.calcOne_citricAcidWarning, Snackbar.LENGTH_LONG);
            snackbar.show();
        }

        element.setConcentration(concentration);
        element.setQuantity(Double.valueOf(editTexts[1]));

        CalculatorOne calculatorOne = new CalculatorOne();
        calculatorOne.calculateAcidQuantity(element);
        Double reductionOfCarbonateHardness = calculatorOne.calculateReductionOfCarbonateHardness(Double.valueOf(editTexts[2]));
        NumberFormat formatter = new DecimalFormat("#0.00");
        if (reductionOfCarbonateHardness.isInfinite() || reductionOfCarbonateHardness.isNaN()) {
            calcOneResult.setText("invalid");
        } else {
            calcOneResult.setText(formatter.format(reductionOfCarbonateHardness));
        }
    }

    private void setToZeroIfEmpty(String[] editTexts) {
        for (int i = 0; i < editTexts.length; i++) {

            if (editTexts[i].equals("")) {
                editTexts[i] = "0.0";
                Log.i("setToZero", "value" + editTexts[i]);
            }
        }

    }
}
