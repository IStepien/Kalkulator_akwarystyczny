package com.example.kalkulator_akwarystyczny;

import android.util.Log;

import java.util.List;

import lombok.Data;

@Data
public class CalculatorOne {

    private Double gradeSum;

    private Double calculateConcentration(ElementsForCalcOne element) {
        return 1 + element.ratioForConcentration * (element.concentration/100) / element.percentageForConcentration;
    }

    private Double calculateMass(ElementsForCalcOne element) {
        Double result;
        if(element.equals(ElementsForCalcOne.ACIDUM_CITRICUM)){
            result = ElementsForCalcOne.ACIDUM_CITRICUM.quantity;
        }else{
        result = calculateConcentration(element) * element.quantity;}
        return result;


    }

    public Double calculateAcidQuantity(List<ElementsForCalcOne> elementsList) {
        Double result = 0.0;
        gradeSum=0.0;
        for (ElementsForCalcOne element : elementsList
        ) {
            if (element.equals(ElementsForCalcOne.ACIDUM_CITRICUM)) {

             result=  ElementsForCalcOne.ACIDUM_CITRICUM.quantity/ElementsForCalcOne.ACIDUM_CITRICUM.molarMass*2;
            }
            else if (element.equals(ElementsForCalcOne.HCl)|| element.equals(ElementsForCalcOne.HNO3)||element.equals(ElementsForCalcOne.VINEGAR)){
                result = (element.concentration/100)* calculateMass(element) / element.molarMass;
            }
            else {
                result = calculateMass(element)*(element.concentration/100)/element.molarMass*2;
            }
            gradeSum += result;
        }

        return result;
    }

    public Double calculateReductionOfCarbonateHardness(Double waterQuantity) {
        return Math.round(gradeSum * 28.0 / 10 * 1000) / waterQuantity;

    }

}
