
import java.util.function.Function;
import model.GeneticAlgorithm;
import model.Individual;
import model.crossovers.Crossover;
import model.initialise.Initialise;
import model.initialise.TSPRandomInitialise;
import model.mutations.Mutation;
import model.selections.Selection;
import model.stopconditions.StopCondition;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author auswise
 */

public class TestQ {
    
    static enum sel{ROULETTE,TOURNAMENT}
    static enum cross{PMX,OX,CX}
    static enum mut{EXCHANGE,INSERT,INVERSE}
    
    public static void main(String [] args){
        
    }
    
    private static GeneticAlgorithm run(int n, int m, enum s, int k, enum c,double pk){
        Initialise initialise; 
        Selection selection;
        Crossover crossover; 
        Mutation mutation; 
        StopCondition stopcondition; 
        Function<Individual, Double> fitnessfunction;
        
        initialise = new TSPRandomInitialise(n,m);
        
        selection = null;
        switch(s){
            case sel.ROULETTE:
                selection = new RouletteWheelSelection(n);
                break;
            case sel.TOURNAMENT:
                selection = new TournamentSelection(n,k);
                break;
        }
        
        crossover = null;
        switch(c){
            case cross.PMX:
                crossover = new PartiallyMatchedCrossover(pk);
                break;
            case cross.OX:
                crossover = new OrderedCrossover(pk);
                break;
            case cross.CX:
                crossover = new CycleCrossover(pk);
                break;
        }
        
        mutation = null;
        
    }
    
    private static GeneticAlgorithm run(Initialise initialise, Selection selection,
            Crossover crossover, Mutation mutation, StopCondition stopcondition, 
            Function<Individual, Double> fitnessfunction){
        return new GeneticAlgorithm(initialise, selection, crossover, mutation,
                stopcondition,fitnessfunction);
    }
}