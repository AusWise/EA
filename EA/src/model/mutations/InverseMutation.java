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
public class InverseMutation extends Mutation {

    public InverseMutation(double pm) {
        super(pm);
    }
    
    
    @Override
    protected void mutate(Individual individual) {
        int start, stop;
        
        start=RANDOM.nextInt(individual.getVariety());
        
        do{
            stop=RANDOM.nextInt(individual.getVariety());
        }while(start==stop);
        
        if(start>stop){
            int temp=start;
            start=stop;
            stop=temp;
        }
        
        while(start<stop){
            int temp = individual.get(stop);
            individual.set(stop, individual.get(start));
            individual.set(start, temp);
            
            start++;
            stop--;
        }
            
        
    }
}
