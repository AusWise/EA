/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.selections;

import model.Individual;
import model.Population;
import java.util.Random;

/**
 *
 * @author auswise
 */
public class TournamentSelection extends Selection {
    
    private final static Random RANDOM = new Random();

    private int tournamentSize;
    
    public TournamentSelection(int size, int tournamentSize) {
        super(size);
        this.tournamentSize=tournamentSize;
    }
    
    @Override
    public Population apply(Population population) {
        Population result = new Population();
        
        for(int i=0;i<size;i++)
            result.add(tournament(population));
            
        return result;
    }
    
    private Individual tournament(Population population){
        
        Population tournament = new Population();
        
        for(int i=0;i<tournamentSize;i++)
           tournament.add(population.get(RANDOM.nextInt(population.size())));
        
        return tournament.max();
    }
}
