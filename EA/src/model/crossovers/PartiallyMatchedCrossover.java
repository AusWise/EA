/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.crossovers;

import static model.crossovers.OrderedCrossover.RANDOM;
import model.Individual;
import model.Population;
import java.util.List;
import java.util.Random;

/**
 *
 * @author auswise
 */
public class PartiallyMatchedCrossover extends Crossover{
    int crossoverPoint1, crossoverPoint2;
    Individual child1, child2;
    Individual parent1,parent2; //blad

    public PartiallyMatchedCrossover(double probality) {
        super(probality);
    }
   
    @Override
    protected void crossover(Individual parent1,Individual parent2){
        
        this.parent1=parent1;
        this.parent2=parent2;
        
        crossoverPoint1=RANDOM.nextInt(parent1.getVariety());
        
        do{
            crossoverPoint2=RANDOM.nextInt(parent1.getVariety());
        }while(crossoverPoint1==crossoverPoint2);
        
        if(crossoverPoint1>crossoverPoint2){
            int temp=crossoverPoint1;
            crossoverPoint1=crossoverPoint2;
            crossoverPoint2=temp;
        }

        makeChilds();
        repair(child1);
        repair(child2);
        childs.add(child1);
        childs.add(child2);
    }
    
    private void makeChilds(){
        child1=new Individual(parent1.length(),parent2.getVariety());
        child2=new Individual(parent1.length(),parent2.getVariety());
        
        for(int i=0;i<crossoverPoint1;i++){
            child1.set(i, parent2.get(i));
            child2.set(i, parent1.get(i));
        }
        
        for(int i=crossoverPoint1;i<=crossoverPoint2;i++){
            child1.set(i, parent1.get(i));
            child2.set(i, parent2.get(i));
        }
        
        for(int i=crossoverPoint2+1;i<parent1.length();i++){
            child1.set(i, parent2.get(i));
            child2.set(i, parent1.get(i));
        }
    }
    
    private void repair(Individual child){
        Individual another = child==child1 ? child2 : child1;   
        
        for(int i=0;i<crossoverPoint1;i++){ //blad 
            int duplicate = indexOfInSegment(child.get(i), child);
            while(duplicate!=-1){
                child.set(i, another.get(duplicate));
                duplicate = indexOfInSegment(child.get(i), child);
            }
        }
        
        for(int i=crossoverPoint2+1;i<child.length();i++){ //blad 
            int duplicate = indexOfInSegment(child.get(i), child);
            while(duplicate!=-1){
                child.set(i, another.get(duplicate));
                duplicate = indexOfInSegment(child.get(i), child);
            }
        }
    }
        
    private int indexOfInSegment(int gene, Individual individual){
        for(int i=crossoverPoint1;i<=crossoverPoint2;i++)
            if(individual.get(i)==gene)
                return i;
        
        return -1;
    }
}
