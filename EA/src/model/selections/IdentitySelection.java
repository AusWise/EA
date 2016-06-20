/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.selections;

import model.Population;

/**
 *
 * @author auswise
 */
public class IdentitySelection extends Selection {

    public IdentitySelection(int size) {
        super(size);
    }

    @Override
    public Population apply(Population t) {
        return t;
    }
    
}
