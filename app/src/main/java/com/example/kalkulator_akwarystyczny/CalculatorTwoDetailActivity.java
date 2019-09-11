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

public class CalculatorTwoDetailActivity extends AppCompatActivity {
    @BindView(R.id.button_calcTwo_additionalInfo)
    Button button_additionalInfo;
    @BindView(R.id.editText_calcTwo_acidConcentration)
    EditText acidConcentration;
    @BindView((R.id.editText_calcTwo_acidQuantity))
    EditText acidQuantity;
    @BindView(R.id.editText_calcTwo_acidTargetConcentration)
    EditText acidTargetConcentration;
    @BindView( (R.id.textView_calcTwo_waterQuantity_HCL))
    TextView waterQuantity_HCL;
    @BindView( (R.id.textView_calcTwo_waterQuantity_H2SO4))
    TextView waterQuantity_H2SO4;
    @BindView( (R.id.textView_calcTwo_waterQuantity_HNO3))
    TextView waterQuantity_HNO3;
    @BindView( (R.id.textView_calcTwo_waterQuantity_H3PO4))
    TextView waterQuantity_H3PO4;
    @BindView( (R.id.textView_calcTwo_waterQuantity_vinegar))
    TextView waterQuantity_vinegar;
    @BindView((R.id.textView_calcTwo_totalQuantity_HCL))
    TextView totalQuantity_HCL;
    @BindView((R.id.textView_calcTwo_totalQuantity_H2SO4))
    TextView totalQuantity_H2SO4;
    @BindView((R.id.textView_calcTwo_totalQuantity_HNO3))
    TextView totalQuantity_HNO3;
    @BindView((R.id.textView_calcTwo_totalQuantity_H3PO4))
    TextView totalQuantity_H3PO4;
    @BindView((R.id.textView_calcTwo_totalQuantity_vinegar))
    TextView totalQuantity_vinegar;
    String[] editTexts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator2_detail);

        ButterKnife.bind(this);

        button_additionalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdditionalInfoActivity.class);
                startActivity(intent);
            }
        });
      if(!acidConcentration.getText().toString().isEmpty()&&!acidQuantity.getText().toString().isEmpty()&&!acidTargetConcentration.getText().toString().isEmpty()) {
          onInputChange();
      }
    }
    @OnTextChanged({R.id.editText_calcTwo_acidConcentration, R.id.editText_calcTwo_acidQuantity, R.id.editText_calcTwo_acidTargetConcentration})
    public void onInputChange() {
        editTexts = new String[]{acidConcentration.getText().toString(),
                acidQuantity.getText().toString(),
                acidTargetConcentration.getText().toString()};

        setToZeroIfEmpty(editTexts);

        List<ElementsForCalc> elements = new ArrayList<>(Arrays.asList(ElementsForCalc.HCl, ElementsForCalc.H2SO4,
                ElementsForCalc.HNO3,  ElementsForCalc.H3PO4, ElementsForCalc.VINEGAR ));

        for (ElementsForCalc element: elements) {
            element.setConcentration(Double.valueOf(editTexts[0]));
        }

        CalculatorTwo calculatorTwo = new CalculatorTwo();
        calculatorTwo.setAcidQuantity(Double.valueOf(editTexts[1]));
        calculatorTwo.setTargetConcentration(Double.valueOf(editTexts[2]));
        List<Double> waterQuantityResults = calculatorTwo.calculateWaterQuantity(elements);
        List<Double> waterQuantityResultsValidated = new ArrayList<>();

        for (Double value: waterQuantityResults) {
                        if(value.isNaN()||value.isInfinite()){
                value=0.0;
            }
            waterQuantityResultsValidated.add(value);
        }

        waterQuantity_HCL.setText(waterQuantityResultsValidated.get(0).toString());
        waterQuantity_H2SO4.setText(waterQuantityResultsValidated.get(1).toString());
        waterQuantity_HNO3.setText(waterQuantityResultsValidated.get(2).toString());
        waterQuantity_H3PO4.setText(waterQuantityResultsValidated.get(3).toString());
        waterQuantity_vinegar.setText(waterQuantityResultsValidated.get(4).toString());

        List<Double> totalQuantityResults = calculatorTwo.calculateTotalQuantity(elements);

        totalQuantity_HCL.setText(totalQuantityResults.get(0).toString());
        totalQuantity_H2SO4.setText(totalQuantityResults.get(1).toString());
        totalQuantity_HNO3.setText(totalQuantityResults.get(2).toString());
        totalQuantity_H3PO4.setText(totalQuantityResults.get(3).toString());
        totalQuantity_vinegar.setText(totalQuantityResults.get(4).toString());
    }



    private void setToZeroIfEmpty(String[] editTexts) {
        for (int i = 0; i < editTexts.length; i++) {

            if (editTexts[i].isEmpty()) {
                editTexts[i] = "0.0";
            }


        }
    }

    }

