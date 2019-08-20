package com.example.kalkulator_akwarystyczny;

import lombok.Data;

@Data
public class CalculatorOne {

    private Double aquariumCapacity;
    private Double dailyDose;
    private Double fertilizerQuantity;
    private Double Kquantity;
    private Double NOquantity;
    private Double POquantity;
    private Double MGquantity;

    public CalculatorOne(Double aquariumCapacity, Double dailyDose, Double fertilizerQuantity, Double Kquantity, Double NOquantity, Double POquantity, Double MGquantity) {
        this.aquariumCapacity = aquariumCapacity;
        this.dailyDose = dailyDose;
        this.fertilizerQuantity = fertilizerQuantity;
        this.Kquantity = Kquantity;
        this.NOquantity = NOquantity;
        this.POquantity = POquantity;
        this.MGquantity = MGquantity;
    }

    public Double calculateK2SO4() {
        return calculateKgForK() / calculateKation(Element.K);
    }

    public Double calculateKCl() {
       return calculateKgForK()/ calculateKation(Element.KCl);

    }

    public Double calculateKNO3() {
        return counted(NOquantity, Element.NO3);
    }

    public Double calculateKH2PO4() {
        return counted(POquantity, Element.PO4);
    }

    public Double calculateMgSO4x7H2O() {
        return calculateCapacity(MGquantity)/ calculateKation(Element.MG)*fertilizerQuantity / 1000;
    }

    private Double calculateKgForK() {
        return (calculateCapacity(Kquantity) * fertilizerQuantity / 1000) - calculateKg(NOquantity, Element.NO3)
                - calculateKg(POquantity, Element.PO4);
    }

    private Double calculateKg(Double elementQuantity, Element element) {
        return counted(elementQuantity, element) * calculateKation(element);
    }

    private Double calculateCapacity(Double elementQuantity) {
        return elementQuantity * aquariumCapacity / (7 * dailyDose);
    }

    private Double calculateAnion(Element element) {
        return element.anion / element.molarMass;

    }

    private Double calculateKation(Element element) {
        return element.kation / element.molarMass;
    }

    private Double counted(Double elementQuantity, Element element) {
        return calculateCapacity(elementQuantity) / calculateAnion(element) * fertilizerQuantity / 1000;
    }
}
