package model;

import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author auswise
 */
public class Individual implements Comparable<Individual> {
    public final List<Integer> chromosome;
    public double fitness=-1;
    
    int v,m;
    
    public Individual(int m, int v){
        this.v=v;
        this.m=m;
        
        chromosome = new LinkedList<Integer>();
        for(int i=0;i<m;i++)
            chromosome.add(-1);
        
    }
    
    public int set(int i,int gene){
        
        if(gene>=v)
            throw new RuntimeException();
        
        return chromosome.set(i, gene);
    }
    
    public int get(int i){
        return chromosome.get(i);
    }
    
    public int length(){
        return chromosome.size();
    }

    @Override
    public int compareTo(Individual o) {
        if(fitness==o.fitness)
            return 0;
        
        return fitness<o.fitness ? -1 : 1;
    }
    
    public int getVariety(){
        return v;
    }
    
    public boolean contains(int gene){
        return chromosome.contains(gene);
    }
    
    public int indexOf(int gene){
        return chromosome.indexOf(gene);
    }
    
    public void insert(int from,int to){
        if(from>=m || to>=m)
            throw new RuntimeException();
        
        chromosome.add(to, chromosome.remove(from));
    }
    
    public void move(int start,int stop, int to){
        if(start>=m || stop>=m || to>=m)
            throw new RuntimeException();
        
        List<Integer> interval = chromosome.subList(start, stop);
        chromosome.removeAll(interval);
        if(to<start)
            chromosome.addAll(to,interval);
        else if(to>stop)
            chromosome.addAll(to-interval.size(), interval);
        else
            throw new RuntimeException();
    }

    @Override
    public String toString() {
        return chromosome.toString();
    }
    
    
}
