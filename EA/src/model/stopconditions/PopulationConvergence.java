/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.stopconditions;

import model.GeneticAlgorithm;

/**
 *
 * @author auswise
 */
public class PopulationConvergence implements StopCondition {

    private double q;

    public PopulationConvergence(double q) {
        this.q = q;
    }
   
    @Override
    public boolean test(GeneticAlgorithm algorithm) {
        return algorithm.getPopulation().fitnessAverage()<=q;
    }
    
}
