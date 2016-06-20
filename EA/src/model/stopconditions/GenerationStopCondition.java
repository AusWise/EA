package model.stopconditions;


import model.stopconditions.StopCondition;
import model.GeneticAlgorithm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author auswise
 */
public class GenerationStopCondition implements StopCondition{

    int generation;

    public GenerationStopCondition(int generation) {
        this.generation = generation;
    }
    
    @Override
    public boolean test(GeneticAlgorithm alghorithm) {
        return alghorithm.getGeneration()>generation;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }
}
