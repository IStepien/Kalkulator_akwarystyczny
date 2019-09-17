package com.example.kalkulator_akwarystyczny;



import lombok.Data;

@Data
public class CalculatorOne {

    private Double gradeSum;

    Double calculateConcentration(ElementsForCalc element) {
        return 1 + element.ratioForConcentration * (element.concentration/100) / element.percentageForConcentration;
    }

    private Double calculateMass(ElementsForCalc element) {
        Double result;
        if(element.equals(ElementsForCalc.ACIDUM_CITRICUM)){
            result = ElementsForCalc.ACIDUM_CITRICUM.quantity;
        }else{
        result = calculateConcentration(element) * element.quantity;}
        return result;


    }

    public Double calculateAcidQuantity(ElementsForCalc element) {
        Double result = 0.0;
        gradeSum=0.0;
           if (element.equals(ElementsForCalc.ACIDUM_CITRICUM)) {

             result=  ElementsForCalc.ACIDUM_CITRICUM.quantity/ ElementsForCalc.ACIDUM_CITRICUM.molarMass*2;
            }
            else if (element.equals(ElementsForCalc.HCl)|| element.equals(ElementsForCalc.HNO3)||element.equals(ElementsForCalc.VINEGAR)){
                result = (element.concentration/100)* calculateMass(element) / element.molarMass;
            }
            else {
                result = calculateMass(element)*(element.concentration/100)/element.molarMass*2;
            }
            gradeSum += result;


        return result;
    }

    public Double calculateReductionOfCarbonateHardness(Double waterQuantity) {
        return Math.round(gradeSum * 28.0 / 10 * 1000) / waterQuantity;

    }

}
