/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eplants.controleur;

import eplants.services.CommandeService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author User
 */
public class StatController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML 
    private BarChart <?,?> stat;
    @FXML
    private CategoryAxis x;
     @FXML
    private NumberAxis y;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         CommandeService cs =  CommandeService.getInstance();
        XYChart.Series set1 = new XYChart.Series<>();
        
        set1.getData().add(new XYChart.Data("JANVIER", cs.Calculerstat(1)));
         set1.getData().add(new XYChart.Data("FEVRIER", cs.Calculerstat(2)));
          set1.getData().add(new XYChart.Data("MARS", cs.Calculerstat(3)));
           set1.getData().add(new XYChart.Data("AVRIL", cs.Calculerstat(4)));
        
        stat.getData().addAll(set1);
        // TODO
    }    
    
}
