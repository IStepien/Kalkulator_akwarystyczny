package com.example.kalkulator_akwarystyczny;

import lombok.Data;

@Data
public class CalculatorOne {

//    private Double aquariumCapacity;
//    private Double dailyDose;
//    private Double fertilizerQuantity;
//    private Double Kquantity;
//    private Double NOquantity;
//    private Double POquantity;
//    private Double MGquantity;
//
//    public CalculatorOne(Double aquariumCapacity, Double dailyDose, Double fertilizerQuantity, Double Kquantity, Double NOquantity, Double POquantity, Double MGquantity) {
//        this.aquariumCapacity = aquariumCapacity;
//        this.dailyDose = dailyDose;
//        this.fertilizerQuantity = fertilizerQuantity;
//        this.Kquantity = Kquantity;
//        this.NOquantity = NOquantity;
//        this.POquantity = POquantity;
//        this.MGquantity = MGquantity;


//    public Double calculateK2SO4() {
//        return calculateKgForK() / calculateKation(ElementsForCalcOne.K);
//    }
//
//    public Double calculateKCl() {
//        return calculateKgForK() / calculateKation(ElementsForCalcOne.KCl);
//
//    }
//
//    public Double calculateKNO3() {
//        return counted(NOquantity, ElementsForCalcOne.NO3);
//    }
//
//    public Double calculateKH2PO4() {
//        return counted(POquantity, ElementsForCalcOne.PO4);
//    }

//    public Double calculateMgSO4x7H2O() {
//        return calculateCapacity(MGquantity) / calculateKation(ElementsForCalcOne.MG) * fertilizerQuantity / 1000;
//    }

//    private Double calculateKgForK() {
//        return (calculateCapacity(Kquantity) * fertilizerQuantity / 1000) - calculateKg(NOquantity, ElementsForCalcOne.NO3)
//                - calculateKg(POquantity, ElementsForCalcOne.PO4);
//    }

//    private Double calculateKg(Double elementQuantity, ElementsForCalcOne elementsForCalcOne) {
//        return counted(elementQuantity, elementsForCalcOne) * calculateKation(elementsForCalcOne);
//    }

//    private Double calculateCapacity(Double elementQuantity) {
//        return elementQuantity * aquariumCapacity / (7 * dailyDose);
//    }

//    private Double calculateAnion(ElementsForCalcOne elementsForCalcOne) {
//        return elementsForCalcOne.anion / elementsForCalcOne.molarMass;
//
//    }

//    private Double calculateKation(ElementsForCalcOne elementsForCalcOne) {
//        Double molarMass = elementsForCalcOne.molarMass;
//        Double kation=0.0;
//        switch (elementsForCalcOne){
//            case K:
//                molarMass = elementsForCalcOne.molarMass * 4.46;
//                kation=78.2;
//                break;
//            case KCl:
//                molarMass=74.55;
//                kation=39.1;
//                break;
//            case NO3:
//                molarMass=101.1;
//                kation=39.1;
//                break;
//        }
//
//
//        return kation / molarMass;
//    }

//    private Double counted(Double elementQuantity, ElementsForCalcOne elementsForCalcOne) {
//        return calculateCapacity(elementQuantity) / calculateAnion(elementsForCalcOne) * fertilizerQuantity / 1000;
//    }
}
