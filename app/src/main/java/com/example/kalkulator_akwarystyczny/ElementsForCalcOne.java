package com.example.kalkulator_akwarystyczny;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ElementsForCalcOne {

    K(39.1),

    NO3(62.01),

    PO4(95.0),

    MG(24.3),

    KCl(74.55),

    HCl(36.5),
    H2SO4(98.0),
    HNO3(63.0),
    H3PO4(98.0),
    CH3COOH(60.5),
    ACIDUM_CITRICUM(210.027);

    public final Double molarMass;


}
