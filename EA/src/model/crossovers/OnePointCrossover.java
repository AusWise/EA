package model.crossovers;


import model.Population;
import model.Individual;
import model.crossovers.Crossover;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author auswise
 */
public class OnePointCrossover extends Crossover {

    public OnePointCrossover(double probality) {
        super(probality);
    }
    
    @Override
    protected void crossover(Individual parent1, Individual parent2){
        int crossoverPoint = RANDOM.nextInt(parent1.length());
        
        Individual child1=new Individual(parent1.length(),parent1.getVariety());
        Individual child2=new Individual(parent2.length(),parent1.getVariety());
        
        for(int i=0;i<crossoverPoint;i++){
            child1.set(i, parent1.get(i));
            child2.set(i, parent2.get(i));
        }  
        
        for(int i=crossoverPoint;i<parent1.length();i++){
            child1.set(i, parent2.get(i));
            child2.set(i, parent1.get(i));
        }  
        
        childs.add(child1);
        childs.add(child2);
    }
}
