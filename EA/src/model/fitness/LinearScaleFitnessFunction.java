/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.fitness;

import model.Individual;
import java.util.function.Function;

/**
 *
 * @author auswise
 */
public class LinearScaleFitnessFunction implements Function<Individual,Double> {

    Function<Individual,Double> fitnessFunction;
    double a,b;

    public LinearScaleFitnessFunction(Function<Individual, Double> fitnessFunction, double a, double b) {
        this.fitnessFunction = fitnessFunction;
        this.a = a;
        this.b = b;
    }
    
    @Override
    public Double apply(Individual t) {
        return a*fitnessFunction.apply(t)+b;
    }
    
    
}
