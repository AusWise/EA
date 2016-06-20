package model;

import model.crossovers.Crossover;
import model.initialise.Initialise;
import java.util.Collections;
import java.util.Observable;
import java.util.function.Function;
import model.graphs.Graph;
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
public class GeneticAlgorithm extends Observable {
    
    Initialise initialise;
    Selection selection;
    Crossover crossover;
    Mutation mutation;
    StopCondition stopCondition;
    Function<Individual,Double> fitnessFunction;
    Population population;

    int t;
    
    Individual best;
    
    double bestFitness,averageFitness,worstFitness;

    public GeneticAlgorithm(Initialise initialise, Selection selection, 
            Crossover crossover, Mutation mutation, StopCondition stopCondition, 
            Function<Individual,Double> fitnessFunction) {
        this.initialise = initialise;
        this.selection = selection;
        this.crossover = crossover;
        this.mutation = mutation;
        this.stopCondition = stopCondition;
        this.fitnessFunction = fitnessFunction;
        
        t=0;
    }
    
    public Individual findBest(){
        
        population = initialise.get();
        evaluate();
        t=1;
        while(!stopCondition.test(this)){
            //best=population.max();
       
            System.out.printf("%d %.2f %.2f %.2f \n",t ,bestFitness , averageFitness, worstFitness);
            
            this.setChanged();
            
            this.notifyObservers();
       
            population=selection.apply(population);
            crossover.accept(population);
            mutation.accept(population);
            evaluate();

            t++; 
        }

        return best;
    }
    
    private void evaluate(){
        double fitness;
        averageFitness=0;
        worstFitness=bestFitness=population.get(0).fitness= fitnessFunction.apply(population.get(0));
        for(int i=0;i<population.size();i++){
            fitness=population.get(i).fitness= fitnessFunction.apply(population.get(i));
            
            if(bestFitness<fitness){
                bestFitness=fitness;
                best=population.get(i);
            }
            
            if(worstFitness>fitness)
                worstFitness=fitness;
            
            averageFitness+=fitness;
        }
        
        averageFitness/=population.size();
    }

    public Individual getBest() {
        return best;
    }
    
    public int getGeneration(){
        return t;
    }
    
    public Population getPopulation(){
        return population;
    }

    public Initialise getInitialise() {
        return initialise;
    }

    public void setInitialise(Initialise initialise) {
        this.initialise = initialise;
    }

    public Selection getSelection() {
        return selection;
    }

    public void setSelection(Selection selection) {
        this.selection = selection;
    }

    public Crossover getCrossover() {
        return crossover;
    }

    public void setCrossover(Crossover crossover) {
        this.crossover = crossover;
    }

    public Mutation getMutation() {
        return mutation;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    public StopCondition getStopCondition() {
        return stopCondition;
    }

    public void setStopCondition(StopCondition stopCondition) {
        this.stopCondition = stopCondition;
    }

    public Function<Individual, Double> getFitnessFunction() {
        return fitnessFunction;
    }

    public void setFitnessFunction(Function<Individual, Double> fitnessFunction) {
        this.fitnessFunction = fitnessFunction;
    }
    
    public double getSize(){
        return selection.getSize();
    }
    
    public void setSize(int size){
        selection.setSize(size);
    }
    
    public double getProbalityCrossover(){
        return mutation.getProbality();
    }
    
    public void setProbalityCrossover(double probalityCrossover){
        crossover.setProbality(probalityCrossover);
    }
    
    public double getProbalityMuattion(){
        return mutation.getProbality();
    }
    
    public void setProbalityMutation(double probalityMuatation){
        mutation.setProbality(probalityMuatation);
    }

    public double getBestFitness() {
        return bestFitness;
    }

    public double getAverageFitness() {
        return averageFitness;
    }

    public double getWorstFitness() {
        return worstFitness;
    }
}
