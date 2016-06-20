/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author auswise
 */
public class Map extends ArrayList<Pair<Double,Double>>{
    public static final String NAME = "NAME";
    public static final String COMMENT = "COMMENT";
    public static final String TYPE ="TYPE";
    public static final String DIMENSION = "DIMENSION";
    public static final String EDGE_WEIGHT_TYPE ="EDGE_WEIGHT_TYPE";
    public static final String NODE_COORD_SECTION = "NODE_COORD_SECTION";
    public static final String TSP = "TSP";
    public static final String EUC_2D = "EUC_2D"; 
    
    String name, comment;
    
    public Map(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
