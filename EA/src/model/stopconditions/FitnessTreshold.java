/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.stopconditions;

import model.GeneticAlgorithm;
import java.util.Collections;

/**
 *
 * @author auswise
 */
public class FitnessTreshold implements StopCondition {

    private double minimum;

    public FitnessTreshold(double minimum) {
        this.minimum = minimum;
    }
    
    @Override
    public boolean test(GeneticAlgorithm algorithm) {
        return algorithm.getPopulation().max().fitness<=minimum;
    }
    
}
