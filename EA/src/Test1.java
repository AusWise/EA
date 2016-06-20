
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.function.Function;
import javafx.util.Pair;
import model.GeneticAlgorithm;
import model.Individual;
import model.Population;
import model.crossovers.Crossover;
import model.crossovers.PartiallyMatchedCrossover;
import model.fitness.LinearScaleFitnessFunction;
import model.fitness.TSPFitnessFunction;
import model.graphs.Graph;
import model.initialise.Initialise;
import model.initialise.TSPRandomInitialise;
import model.mutations.ExchangeMutation;
import model.mutations.Mutation;
import model.selections.IdentitySelection;
import model.selections.Selection;
import model.stopconditions.GenerationStopCondition;
import model.stopconditions.StopCondition;
import view.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author auswise
 */
public class Test1 {
    public static void main(String [] args) throws FileNotFoundException{
        for(int i=1;i<=10000;i++)
            init(i);
    }
    
    private static void init(int n) throws FileNotFoundException{
        File file = new File("/home/auswise/Documents/att48.tsp");
        Initialise initialise = new TSPRandomInitialise(n,48);
        Selection selection = new IdentitySelection(n);
        Crossover crossover = new PartiallyMatchedCrossover(0);
        Mutation mutation = new ExchangeMutation(0);
        StopCondition stopCondition = new GenerationStopCondition(2);
        Function<Individual,Double> fitnessFunction = new LinearScaleFitnessFunction(new TSPFitnessFunction(createGraph(createMap(file))),-1,210000);
        
        GeneticAlgorithm algorithm = new GeneticAlgorithm(initialise, selection, crossover,mutation, stopCondition, fitnessFunction);
        algorithm.findBest();
    }
    
     private static Map createMap(File file) throws FileNotFoundException{
        Scanner sc = new Scanner(file);
        
        Map map = new Map();
        
        String line = null;
        StringTokenizer tokenizer = null;
        int n=0;
        double x,y;
        String token = "";
        while(map.size()==0){
            line=sc.nextLine();
               tokenizer = new StringTokenizer(line);
            token = tokenizer.nextToken();
            if(token.equals(Map.NAME)){
                tokenizer.nextToken();
                map.setName(tokenizer.nextToken());
            }
            else if(token.equals(Map.COMMENT)){
                tokenizer.nextToken();
                map.setComment(tokenizer.nextToken());
            }    
            else if(token.equals(Map.TYPE)){
                tokenizer.nextToken();
                if(!tokenizer.nextToken().equals(Map.TSP))
                    throw new RuntimeException();
            }
            else if(token.equals(Map.DIMENSION)){
                tokenizer.nextToken();
                n=Integer.parseInt(tokenizer.nextToken());
            }
            else if(token.equals(Map.EDGE_WEIGHT_TYPE)){
                tokenizer.nextToken();
                if(!tokenizer.nextToken().equals(Map.EUC_2D))
                    throw new RuntimeException();
            }
            else if(token.equals(Map.NODE_COORD_SECTION))
                for(int i=0;i<n;i++){
                    sc.nextInt();
                    x=sc.nextDouble();
                    y=sc.nextDouble();
                    map.add(new Pair<Double,Double>(x,y));
                }
        }
        
        return map;
    }
    
    private static Graph createGraph(Map map){
        Graph graph = new Graph(map.size());
        double x1,x2,y1,y2;
        for(int i=0;i<map.size();i++)
            for(int j=0;j<map.size();j++){
                x1 = map.get(i).getKey();
                x2 = map.get(j).getKey();
                y1 = map.get(i).getValue();
                y2 = map.get(j).getValue();
                graph.addEdge(i, j, Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2)));
            }
        
        return graph;
    }
}
