package com.example.kalkulator_akwarystyczny;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Element {

    K(174.258, 0.0, 78.2),

    NO3(101.1, 62.01, 39.1),

    PO4(136.09, 94.97, 39.1),

    MG(246.48, 0.0, 24.31),

    KCl(74.55, 0.0, 39.098);

    public final Double molarMass;
    public final Double anion;
    public final Double kation;

}
