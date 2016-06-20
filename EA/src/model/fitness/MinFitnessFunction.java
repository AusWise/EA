/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.fitness;

import java.util.function.Function;
import model.Individual;

/**
 *
 * @author auswise
 */
public class MinFitnessFunction implements Function<Individual, Double> {

    double max;
    Function<Individual, Double> fitnessFunction;
    
    @Override
    public Double apply(Individual t) {
        double y = fitnessFunction.apply(t);
        return y>max ? 0 : max-y;
    }

    public MinFitnessFunction(double max, Function<Individual, Double> fitnessFunction) {
        this.max = max;
        this.fitnessFunction = fitnessFunction;
    }
}
