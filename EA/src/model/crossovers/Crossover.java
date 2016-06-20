package model.crossovers;


import java.util.Random;
import model.Population;
import java.util.function.Consumer;
import model.Individual;
import static model.crossovers.OnePointCrossover.RANDOM;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author auswise
 */
public abstract class Crossover implements Consumer<Population> {   
    protected static Random RANDOM = new Random();
    
    Population childs;
    double probality;

    public Crossover(double probality) {
        this.probality = probality;
    }

    public double getProbality() {
        return probality;
    }

    public void setProbality(double probality) {
        this.probality = probality;
    }
    
    @Override
    public void accept(Population population) {
        childs = new Population();
        for(int i=0;i<population.size();i+=2)
            if(RANDOM.nextDouble()<probality)
                crossover(population.get(RANDOM.nextInt(population.size())), 
                        population.get(RANDOM.nextInt(population.size())));
        
        population.addAll(childs);
    }
    
    protected abstract void crossover(Individual parent1, Individual parent2);
}
