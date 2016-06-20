/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.crossovers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import static model.crossovers.OnePointCrossover.RANDOM;
import model.Individual;
import model.Population;

/**
 *
 * @author auswise
 */
public class CycleCrossover extends Crossover{
    Individual child1;
    Individual child2;

    public CycleCrossover(double probality) {
        super(probality);
    }
    
    @Override
    protected void crossover(Individual parent1, Individual parent2){
        child1 = new Individual(parent1.length(),parent1.getVariety());
        child2 = new Individual(parent1.length(),parent1.getVariety());
        
        
        Set<Integer> visitedIndices = new HashSet<Integer>();
        List<Integer> indices = new LinkedList<Integer>();
        
        int cycle=0;
        int idx=0;
        
        Individual p1,p2;
        
        while(visitedIndices.size()<child1.length()){
            
            do{
                indices.add(idx);
                visitedIndices.add(idx);
                idx=parent2.indexOf(parent1.get(idx));
            }while(idx!=indices.get(0));
                
            if(cycle % 2 ==0){
                p1 = parent1;
                p2 = parent2;
            }
            else{
                p1 = parent2;
                p2 = parent1;
            }
            
            for(int i=0;i<indices.size();i++){
                child1.set(indices.get(i), p1.get(indices.get(i)));
                child2.set(indices.get(i), p2.get(indices.get(i)));
            }
            
            
            
            while(visitedIndices.contains(idx))
                idx++;
            
            cycle++;
            
            indices.clear();
        }
        
        
        childs.add(child1);
        childs.add(child2);
    }
}
