/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.initialise;

import model.Individual;
import model.Population;
import static model.initialise.RandomInitialise.RANDOM;

/**
 *
 * @author auswise
 */
public class TSPRandomInitialise extends RandomInitialise {

    public TSPRandomInitialise(int n, int m) {
        super(n, m, m);
    }

    @Override
    public Population get() {
        Population population = new Population();
        
        Individual individual;
        for(int i=0;i<n;i++){
            individual = new Individual(m,v);
            
            for(int j=0;j<m;j++)
                individual.set(j, j);
            
            for(int j=0;j<m;j++)
                individual.insert(RANDOM.nextInt(m), RANDOM.nextInt(m));
                
            population.add(individual);
        }
        
        return population;
    }
    
    
}
