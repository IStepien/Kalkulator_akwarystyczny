package com.example.kalkulator_akwarystyczny;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CalculatorOneDetailActivity extends AppCompatActivity {
    @BindView(R.id.button_additionalInfo) Button button_additonalInfo;

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

    }

}
