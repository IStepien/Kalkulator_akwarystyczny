package com.example.kalkulator_akwarystyczny;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class CalculatorOneDetailActivity extends AppCompatActivity {
    @BindView(R.id.button_additionalInfo)
    Button button_additonalInfo;
    @BindView(R.id.editText_HCl)
    EditText HCl_quantity;
    @BindView(R.id.editText_H2SO4)
    EditText H2SO4_quantity;
    @BindView(R.id.editText_HNO3)
    EditText HNO3_quantity;
    @BindView(R.id.editText_H3PO4)
    EditText H3PO4_quantity;
    @BindView(R.id.editText_citricAcid)
    EditText citricAcid_quantity;
    @BindView(R.id.editText_vinegar)
    EditText vinegar_quantity;
    @BindView(R.id.editText_HClconcentration)
    EditText HClconcentration;
    @BindView(R.id.editText_H2SO4concentration)
    EditText H2SO4concentration;
    @BindView(R.id.editText_HNO3concentration)
    EditText HNO3concentration;
    @BindView(R.id.editText_H3PO4concentration)
    EditText H3PO4concentration;
    @BindView(R.id.editText_vinegarConcentration)
    EditText vinegarConcentration;
    @BindView((R.id.editText_waterQuantity))
    EditText waterQuantity;
    @BindView((R.id.textView_calcOne_result))
    TextView calcOneResult;
    String[] editTexts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator1_detail);
        ButterKnife.bind(this);


        button_additonalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdditionalInfoActivity.class);
                startActivity(intent);
            }
        });


        onInputChange();
    }

    @OnTextChanged({R.id.editText_HCl, R.id.editText_HClconcentration, R.id.editText_H2SO4, R.id.editText_H2SO4concentration,
            R.id.editText_HNO3, R.id.editText_HNO3concentration, R.id.editText_H3PO4, R.id.editText_H3PO4concentration,
            R.id.editText_vinegar, R.id.editText_vinegarConcentration, R.id.editText_citricAcid, R.id.editText_waterQuantity})
    public void onInputChange() {
        editTexts = new String[]{(HCl_quantity.getText().toString()), (HClconcentration.getText().toString()),
                (H2SO4_quantity.getText().toString()), (H2SO4concentration.getText().toString()),
                (HNO3_quantity.getText().toString()), (HNO3concentration.getText().toString()),
                (H3PO4_quantity.getText().toString()), (H3PO4concentration.getText().toString()),
                (citricAcid_quantity.getText().toString()), (vinegar_quantity.getText().toString()),
                (vinegarConcentration.getText().toString()), (waterQuantity.getText().toString())};

        setToZeroIfEmpty(editTexts);

        ElementsForCalcOne.HCl.setQuantity(Double.valueOf(editTexts[0]));
        ElementsForCalcOne.HCl.setConcentration(Double.valueOf(editTexts[1]));

        ElementsForCalcOne.H2SO4.setQuantity(Double.valueOf(editTexts[2]));
        ElementsForCalcOne.H2SO4.setConcentration(Double.valueOf(editTexts[3]));

        ElementsForCalcOne.HNO3.setQuantity(Double.valueOf(editTexts[4]));
        ElementsForCalcOne.HNO3.setConcentration(Double.valueOf(editTexts[5]));

        ElementsForCalcOne.H3PO4.setQuantity(Double.valueOf(editTexts[6]));
        ElementsForCalcOne.H3PO4.setConcentration(Double.valueOf(editTexts[7]));

        ElementsForCalcOne.ACIDUM_CITRICUM.setQuantity(Double.valueOf(editTexts[8]));

        ElementsForCalcOne.VINEGAR.setQuantity(Double.valueOf(editTexts[9]));
        ElementsForCalcOne.VINEGAR.setConcentration(Double.valueOf(editTexts[10]));

        List<ElementsForCalcOne> elements = new ArrayList<>(Arrays.asList(ElementsForCalcOne.HCl, ElementsForCalcOne.H2SO4,
                ElementsForCalcOne.HNO3, ElementsForCalcOne.H3PO4, ElementsForCalcOne.ACIDUM_CITRICUM, ElementsForCalcOne.VINEGAR));


        CalculatorOne calculatorOne = new CalculatorOne();
        calculatorOne.calculateAcidQuantity(elements);
        Double waterQuantity = Double.valueOf(editTexts[11]);
        calcOneResult.setText((calculatorOne.calculateReductionOfCarbonateHardness(waterQuantity)).toString());
    }

    private void setToZeroIfEmpty(String[] editTexts) {
        for (int i = 0; i < editTexts.length; i++) {

            if (editTexts[i].equals("")) {
                editTexts[i] = "0.0";

            }


        }
    }

}
