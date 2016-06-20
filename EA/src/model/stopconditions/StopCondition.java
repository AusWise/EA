package model.stopconditions;


import model.GeneticAlgorithm;
import java.util.function.Predicate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author auswise
 */
public interface StopCondition extends Predicate<GeneticAlgorithm> {}
