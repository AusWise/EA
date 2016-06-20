package model;


import model.Individual;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author auswise
 */
public class Population extends LinkedList<Individual> {
    
    public double fitnessAverage(){
        double sum=0;
        Iterator i = iterator();
        while(i.hasNext())
            sum+=((Individual)i.next()).fitness;
        
        return sum/size();
    }
    
    public Individual max(){
        return Collections.max(this);
    }
}
