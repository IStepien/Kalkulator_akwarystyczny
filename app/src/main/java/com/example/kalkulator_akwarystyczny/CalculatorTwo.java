package com.example.kalkulator_akwarystyczny;



import java.util.ArrayList;
import java.util.List;

public class CalculatorTwo extends CalculatorOne {
    Double acidQuantity;
    Double targetConcentration;


    public void setAcidQuantity(Double acidQuantity) {
        this.acidQuantity = acidQuantity;

    }
    public void setTargetConcentration(Double targetConcentration) {
        this.targetConcentration = targetConcentration;
    }

    private Double calculateMass(ElementsForCalc element) {

        return calculateConcentration(element) * acidQuantity;
    }


    public List calculateWaterQuantity(List<ElementsForCalc> elements) {
        List<Double> waterQuantityResult = new ArrayList<>();
        long result;
        for (ElementsForCalc element: elements
             ) {

           result= Math.round((calculateMass(element) /((targetConcentration/100)/(element.concentration/100-targetConcentration/100))));
           waterQuantityResult.add(Double.valueOf(result));

        }
        return waterQuantityResult;
    }

    public List calculateTotalQuantity(List<ElementsForCalc> elements) {
        List<Double> totalQuantityResult = new ArrayList<>();
        Double result;
        for (ElementsForCalc element: elements
        ) {
            result= Math.round((calculateMass(element) /((targetConcentration/100)/(element.concentration/100-targetConcentration/100))))+acidQuantity;
            totalQuantityResult.add(result);
        }


        return totalQuantityResult;
    }

   }
