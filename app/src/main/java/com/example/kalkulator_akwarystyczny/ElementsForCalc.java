package com.example.kalkulator_akwarystyczny;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum ElementsForCalc {

    HCl(36.5, 35.5, 0.2, 0.39, 0.0, 0.0),
    H2SO4(98.0, 96.0, 0.84, 0.985, 0.0, 0.0),
    HNO3(63.0, 62.0, 0.41, 0.675, 0.0, 0.0),
    H3PO4(98.0, 95.0, 0.58, 0.75, 0.0, 0.0),
    VINEGAR(60.5, 59.5, 0.49, 0.995, 0.0, 0.0),
    ACIDUM_CITRICUM(210.027, 208.0, 0.0, 0.0, 0.0, 0.0);

    public final Double molarMass;
    public final Double anion;
    public final Double ratioForConcentration;
    public final Double percentageForConcentration;
    public Double concentration;
    public Double quantity;

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setConcentration(Double concentration) {
        this.concentration = concentration;
    }

}
