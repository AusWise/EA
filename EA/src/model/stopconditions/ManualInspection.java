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
public class ManualInspection implements StopCondition{

    boolean stop=false;
    
    @Override
    public boolean test(GeneticAlgorithm algorithm) {
        return stop;
    }
    
    public void stop(){
        stop=true;
    }
}