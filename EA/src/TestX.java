
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.function.Function;
import javafx.util.Pair;
import model.GeneticAlgorithm;
import model.Individual;
import model.crossovers.Crossover;
import model.crossovers.CycleCrossover;
import model.crossovers.OrderedCrossover;
import model.crossovers.PartiallyMatchedCrossover;
import model.fitness.LinearScaleFitnessFunction;
import model.fitness.MinFitnessFunction;
import model.fitness.TSPFitnessFunction;
import model.graphs.Graph;
import model.initialise.Initialise;
import model.initialise.TSPRandomInitialise;
import model.mutations.ExchangeMutation;
import model.mutations.InsertMutation;
import model.mutations.InverseMutation;
import model.mutations.Mutation;
import model.selections.RouletteWheelSelection;
import model.selections.Selection;
import model.selections.TournamentSelection;
import model.stopconditions.FitnessTreshold;
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
public class TestX {
    
    static enum Sel{ROULETTE,TOURNAMENT}
    static enum Cross{PMX,OX,CX}
    static enum Mut{EXCHANGE,INSERT,INVERSE}
    
    public static void main(String [] args) throws FileNotFoundException{
        int n=50;
        int m=48;
        Sel s =Sel.TOURNAMENT;
        int k=3;
        Cross c = Cross.OX;
        double pk=0.7;
        Mut mut;
        double pm;
        double max = 180000;
        File file = new File("/home/auswise/Documents/att48.tsp");
        int t=500;
        
        //test(n,m,s,k,c,pk,max,file, t);
        
        mut = Mut.INVERSE;
        pm = 0.08;
        
        //test(n,m,s,k,mut,pm,max,file,t);
        
        c = Cross.OX;
        pk=0.55;
        
        //test(n,m,c,pk,mut,pm,max,file,t);
        
        s = Sel.TOURNAMENT;
        k=3;
        
        //test(m,s,k,c,pk,mut,pm,max,file,t);
        
        n=50;
        
        //test(n,m,s,k,c,pk,mut,pm,max,file);
        //test(2,m,s,k,c,pk,mut,pm,max,file,t);
        
        t=900;
        
        //test(m,s,k,c,pk,mut,pm,max,file,t);
        
        n=50;
        
        //test(n,m,c,pk,mut,pm,max,file,t);
        
        s=Sel.TOURNAMENT;
        k=3;
        
        //test(n,m,s,k,mut,pm,max,file,t);
        
        c = Cross.OX;
        pk=0.8;
        
        //test(n,m,s,k,c,pk,max,file, t);
        
        pm = 0.09;
        
        file = new File("/home/auswise/Documents/tsp225.tsp");
        t=8000;
        m=225;
        max=40000;
        
        //test(n,m,s,k,c,pk,mut,pm,max,file,t);
        
        file = new File("/home/auswise/Documents/lin105.tsp");
        t=4000;
        m=105;
        max=100000;
        
        test(n,m,s,k,c,pk,mut,pm,max,file,t);
        
    }
    
    private static void test(int n, int m,Sel s, int k, Cross c, double pk, 
            Mut mut, double pm,  double max, File file) throws FileNotFoundException{
        for(int t=500;t<=1000;t+=100){
            System.out.println(t + ":");
            test(n,m,s,k,c,pk,mut,pm,max,file,t);
        }
    }
    
    private static void test(int m,Sel s, int k, Cross c, double pk, 
            Mut mut, double pm,  double max, File file, int t) throws FileNotFoundException{
        int n=1;
        System.out.println(n + ":");
        test(n,m,s,k,c,pk,mut,pm,max,file,t);
        for(n=50;n<=1000;n+=50){
            System.out.println(n + ":");
            test(n,m,s,k,c,pk,mut,pm,max,file,t);
        }
            
    }
    
    private static void test(int n, int m, Cross c, double pk, 
            Mut mut, double pm,  double max, File file, int t) throws FileNotFoundException{
        System.out.println("Roulette Wheel: ");
        test(n,m,Sel.ROULETTE,0,c,pk,mut,pm,max,file,t);
        System.out.println("Tournament: ");
        for(int k=1;k<=20;k++){
            System.out.println(k + ":");
            test(n,m,Sel.TOURNAMENT,k,c,pk,mut,pm,max,file,t);
        }
        
    }
    
    private static void test(int n, int m, Sel s, int k, Mut mut, 
            double pm,  double max, File file, int t) throws FileNotFoundException{
        System.out.println("PMX: ");
        test(n,m,s,k,Cross.PMX,mut,pm,max,file,t);
        System.out.println("OX: ");
        test(n,m,s,k,Cross.OX,mut,pm,max,file,t);
        System.out.println("CX: ");
        test(n,m,s,k,Cross.CX,mut,pm,max,file,t);
    }
    
    private static void test(int n, int m, Sel s, int k, Cross c, Mut mut, 
            double pm,  double max, File file, int t) throws FileNotFoundException{
        for(double pk=0.5;pk<=1;pk+=0.05){
            System.out.println(pk+":");
            test(n,m,s,k,c,pk,mut,pm,max,file,t);
        }
    }
    
    private static void test(int n, int m,Sel s, int k, Cross c, double pk, 
            Mut mut, double max, File file, int t) throws FileNotFoundException{
        for(double pm=0;pm<=0.1;pm+=0.01){
            System.out.println(pm + ":");
            test(n,m,s,k,c,pk,mut,pm,max,file,t);
        }
            
    }
    
    private static void test(int n, int m,Sel s, int k, Cross c, double pk, 
             double max, File file, int t) throws FileNotFoundException{
        System.out.println("Exchange " +":");
        test(n,m,s,k,c,pk,Mut.EXCHANGE,max,file, t);
        System.out.println("Insert " +":");
        test(n,m,s,k,c,pk,Mut.INSERT,max,file, t);
        System.out.println("Inverse " +":");
        test(n,m,s,k,c,pk,Mut.INVERSE,max,file, t);
    }
    
    private static void test(int n, int m,Sel s, int k, Cross c, double pk, 
            Mut mut, double pm,  double max, File file, int t) throws FileNotFoundException{
        GeneticAlgorithm algorithm = null;
        for(int i=0;i<10;i++){
            algorithm = run(n, m, s, k, c, pk, mut, pm, max, file, t);
            algorithm.findBest();
            System.out.println();
        }   
    }
    
    private static GeneticAlgorithm run(int n, int m,Sel s, int k, Cross c, double pk, 
            Mut mut, double pm, double max, File file, int t) throws FileNotFoundException{
        Graph g = createGraph(createMap(file));
        Initialise initialise;
        Selection selection;
        Crossover crossover;
        Mutation mutation;
        StopCondition stopcondition;
        Function<Individual, Double> fitnessfunction;
        
        initialise = new TSPRandomInitialise(n,m); 
        selection = selectSelection(n,s,k);
        crossover = selectCrossOver(c,pk);
        mutation = selectMutation(mut,pm);
        stopcondition = new GenerationStopCondition(t);
        fitnessfunction = new MinFitnessFunction(max,new TSPFitnessFunction(g));
        
        return run(initialise, selection, crossover, mutation, stopcondition,fitnessfunction);
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
   
    
    
    private static Mutation selectMutation(Mut mut, double pm){
        Mutation mutation;
        switch(mut){
            case EXCHANGE:
                mutation = new ExchangeMutation(pm);
                break;
            case INSERT:
                mutation = new InsertMutation(pm);
                break;
            case INVERSE:
                mutation = new InverseMutation(pm);
                break;
            default:
                mutation = null;
        }
        
        return mutation;
    }
    
    private static Crossover selectCrossOver(Cross c, double pk){
        Crossover crossover;
        switch(c){
            case PMX:
                crossover = new PartiallyMatchedCrossover(pk);
                break;
            case OX:
                crossover = new OrderedCrossover(pk);
                break;
            case CX:
                crossover = new CycleCrossover(pk);
                break;
            default:
                crossover = null;
        }
        
        return crossover;
    }
    
    private static Selection selectSelection(int n, Sel s, int k){
        Selection selection;
        switch(s){
            case ROULETTE:
                selection = new RouletteWheelSelection(n);
                break;
            case TOURNAMENT:
                selection = new TournamentSelection(n,k);
                break;
            default:
                selection = null;
        }
        
        return selection;
    }
    
    private static GeneticAlgorithm run(Initialise initialise, Selection selection,
            Crossover crossover, Mutation mutation, StopCondition stopcondition, 
            Function<Individual, Double> fitnessfunction){
        return new GeneticAlgorithm(initialise, selection, crossover, mutation,
                stopcondition,fitnessfunction);
    }
}
