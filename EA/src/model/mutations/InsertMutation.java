/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.mutations;

import model.Individual;

/**
 *
 * @author auswise
 */
public class InsertMutation extends Mutation {

    public InsertMutation(double pm) {
        super(pm);
    }

    @Override
    protected void mutate(Individual individual) {
        int from=RANDOM.nextInt(individual.getVariety());
        int to=RANDOM.nextInt(individual.getVariety());
        
        individual.insert(from, to);
    }
    
    
}
