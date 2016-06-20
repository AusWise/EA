package model.graphs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author auswise
 */
public class Graph {
    double [][] g;
    int V,E;
    
    public Graph(int V){
        this.V=V;
        g=new double [V][V];
        
        for(int i=0;i<V;i++)
            g[i]=new double[V];
        
        E=0;
    }
    
    public int V(){
        return V;
    }
    
    public int E(){
        return E;
    }
    
    public void addEdge(int v, int w, double weight){
        E++;
        g[v][w]=g[w][v]=weight;
    }
    
    public double getWeight(int v, int w){
        return g[v][w];
    }
}
