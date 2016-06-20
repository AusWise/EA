package model.mutations;


import java.util.Random;
import model.Population;
import java.util.function.Consumer;
import model.Individual;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author auswise
 */
public abstract class Mutation implements Consumer<Population> {
    protected static Random RANDOM = new Random();

    double probality;
    
    public Mutation(double probality) {
        this.probality=probality;
    }

    @Override
    public void accept(Population population) {
        for(int i=0;i<population.size();i++)
            if(RANDOM.nextDouble()<probality)
                mutate(population.get(i));
    }
    
    protected void mutate(Individual individual){
        int n = RANDOM.nextInt(individual.length());
        individual.set(n, Math.abs(individual.get(n)-1));
    }

    public double getProbality() {
        return probality;
    }

    public void setProbality(double probality) {
        this.probality = probality;
    }
}
