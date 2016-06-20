
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import javafx.util.Pair;
import model.Individual;
import model.Population;
import model.crossovers.Crossover;
import model.crossovers.PartiallyMatchedCrossover;
import model.fitness.TSPFitnessFunction;
import model.graphs.Graph;
import model.initialise.Initialise;
import model.initialise.TSPRandomInitialise;
import model.mutations.ExchangeMutation;
import model.mutations.Mutation;
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
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Graph graph=createGraph(createMap(new File("/home/auswise/Documents/lin105.tsp")));
        
        TSPFitnessFunction fitnessFunction = new TSPFitnessFunction(graph);
        
        System.out.println(fitnessFunction.apply(best(new File("/home/auswise/Documents/lin105.opt.tour"))));
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
    
    private static Individual best(File file) throws FileNotFoundException{
        Scanner sc = new Scanner(file);
        
        Individual best = new Individual(105,105);
        
        for(int i=0;i<5;i++)
            sc.nextLine();
        
        int i=0;
        while(sc.hasNextInt()){
            best.set(i, sc.nextInt()-1);
            i++;
        }
        
        return best;
    }
    
}
