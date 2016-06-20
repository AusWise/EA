package model.initialise;

import model.Population;
import model.Individual;
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
public class RandomInitialise implements Initialise {
    protected static final Random RANDOM = new Random();
    
    int n,m,v;
    
    public RandomInitialise(int n,int m,int v){
        this.n=n;
        this.m=m;
        this.v=v;
    }
    
    @Override
    public Population get() {
        Population population = new Population();
        
        Individual individual;
        for(int i=0;i<n;i++){
            individual = new Individual(m,v);
            
            for(int j=0;j<m;j++)
                individual.set(j, RANDOM.nextInt(v));
            
            population.add(individual);
        }
        
        return population;
    }
}
