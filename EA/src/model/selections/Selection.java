package model.selections;


import model.Population;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author auswise
 */
public abstract class Selection implements UnaryOperator<Population> {

    int size;

    public Selection(int size){
        this.size=size;
    }
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
