/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.crossovers;

import static model.crossovers.OnePointCrossover.RANDOM;
import model.Individual;
import model.Population;
import java.util.Random;

/**
 *
 * @author auswise
 */
public class OrderedCrossover extends Crossover{
  
    int crossoverPoint1, crossoverPoint2,j;

    public OrderedCrossover(double probality) {
        super(probality);
    }
    
    @Override
    protected void crossover(Individual parent1,Individual parent2){
        
        crossoverPoint1=RANDOM.nextInt(parent1.getVariety());
        
        do{
            crossoverPoint2=RANDOM.nextInt(parent1.getVariety());
        }while(crossoverPoint1==crossoverPoint2);
        
        if(crossoverPoint1>crossoverPoint2){
            int temp=crossoverPoint1;
            crossoverPoint1=crossoverPoint2;
            crossoverPoint2=temp;
        }
        
        Individual child1=new Individual(parent1.length(),parent2.getVariety());
        Individual child2=new Individual(parent1.length(),parent2.getVariety());
        
        for(int i=crossoverPoint1;i<=crossoverPoint2;i++){
            child1.set(i, parent1.get(i));
            child2.set(i, parent2.get(i));
        }
        
        insertRest(child1,parent2);
        insertRest(child2,parent1);
            
        childs.add(child1);
        childs.add(child2);
    }
    
    private void insertRest(Individual child, Individual parent){
        j=0;
        insertRest(child,parent,0,crossoverPoint1);
        insertRest(child,parent,crossoverPoint2 +1,child.length());
    }
    
    private void insertRest(Individual child, Individual parent, int start, int stop){
        for(int i=start;i<stop;i++){
            while(child.contains(parent.get(j))) 
                ++j;
            
            child.set(i, parent.get(j));    
        }
    }
    
}
