import java.lang.reflect.Method;
import java.util.Observable;
import javax.swing.JFrame;
import model.GeneticAlgorithm;
import model.crossovers.PartiallyMatchedCrossover;
import model.fitness.TSPFitnessFunction;
import model.graphs.Graph;
import model.initialise.TSPRandomInitialise;
import model.mutations.ExchangeMutation;
import model.selections.RouletteWheelSelection;
import model.selections.Selection;
import model.stopconditions.CompundStopCondition;
import view.MainFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author auswise
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        GeneticAlgorithm algorithm = new GeneticAlgorithm(null,null,null,null,null,null);
        
        MainFrame frame = new MainFrame(algorithm);
        
        algorithm.addObserver(frame);
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
            }
        });
        
//        Method [] methods = GeneticAlgorithm.class.getMethods();
//        for(Method method : methods)
//            System.out.println(method.getName());
        
//        RouletteWheelSelection selection = new RouletteWheelSelection(1);
//        System.out.println(Selection.class.isAssignableFrom(RouletteWheelSelection.class));
    }
}
