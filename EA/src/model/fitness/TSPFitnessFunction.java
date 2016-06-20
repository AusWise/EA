/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.fitness;

import model.graphs.Graph;
import model.Individual;
import java.util.function.Function;

/**
 *
 * @author auswise
 */
public class TSPFitnessFunction implements Function<Individual,Double> {

    Graph g;

    public TSPFitnessFunction(Graph g) {
        this.g = g;
    }
    
    @Override
    public Double apply(Individual individual) {
        double sum=0;
        for(int i=0;i<individual.length()-1;i++)
            sum+=g.getWeight(individual.get(i), individual.get(i+1));
        
        sum+=g.getWeight(individual.get(individual.length()-1), individual.get(0));
        
        return sum;
    }

    public Graph getGraph() {
        return g;
    }

    public void setGraph(Graph g) {
        this.g = g;
    }
}
