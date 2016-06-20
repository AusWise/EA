package model.selections;


import model.selections.Selection;
import model.Population;
import model.Individual;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author auswise
 */
public class RouletteWheelSelection extends Selection {

    protected static Random RANDOM = new Random();

    double p [];

    public RouletteWheelSelection(int size) {
        super(size);
    }
    
    @Override
    public Population apply(Population population) {
        double Q = 0;
        for(int i=0;i<population.size();i++)
            Q+=population.get(i).fitness;
        
        p = new double [population.size()];
        
        for(int i=0;i<p.length;i++)
            p[i]=population.get(i).fitness/Q;
        
        Population result = new Population();
        
        for(int i=0;i<size;i++)
            result.add(rand(population));
        
        return result;
    }
    
    private Individual rand(Population population){
        
        double pr = RANDOM.nextDouble();
        
        double pi=0;
        int i;
        for(i=0;i<p.length && pi<pr;i++)
            pi+=p[i];
        
        return population.get(i-1);
    }
}
