/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.mutations;

import model.Individual;
import model.Population;

/**
 *
 * @author auswise
 */
public class ExchangeMutation extends Mutation {

    public ExchangeMutation(double pm) {
        super(pm);
    }

    @Override
    protected void mutate(Individual individual) {
        int exchangePoint2,exchangePoint1;
        
        exchangePoint1=RANDOM.nextInt(individual.getVariety());
        exchangePoint2=RANDOM.nextInt(individual.getVariety());
        
        do{
            exchangePoint2=RANDOM.nextInt(individual.getVariety());
        }while(exchangePoint1==exchangePoint2);
        
        int temp=individual.get(exchangePoint1);
        individual.set(exchangePoint1,individual.get(exchangePoint2));
        individual.set(exchangePoint2, temp);
    }
}
