/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.stopconditions;

import java.util.LinkedList;
import model.GeneticAlgorithm;
import java.util.List;

/**
 *
 * @author auswise
 */
public class CompundStopCondition implements StopCondition {

    List<StopCondition> conditions;

    public CompundStopCondition(List<StopCondition> conditions) {
        this.conditions = conditions;
    }
    
    public CompundStopCondition(){
        conditions = new LinkedList<StopCondition>();
    }
    
    @Override
    public boolean test(GeneticAlgorithm t) {
        for(int i=0;i<conditions.size();i++)
            if(conditions.get(i).test(t))
                return true;
        
        return false;
    }
}
