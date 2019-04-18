/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eplants.controleur;

import eplants.entities.Commande;
import eplants.entities.Panier;
import eplants.services.CommandeService;
import eplants.services.LivraisonService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AdminCommandeController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TableView<Commande> admincommande;
    @FXML
    private TableColumn<Commande, String> commande;
    @FXML
    private TableColumn<Commande, String> user;
    @FXML
    private TableColumn<Commande, String> produits;
     @FXML
    private TableColumn<Commande, String> prix;
      @FXML
    private TableColumn<Commande, String> date;
        @FXML
    private Button stat;
      @FXML
    private Button retour;
      private   ObservableList<Commande> commandes= FXCollections.observableArrayList();
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          CommandeService cs =  CommandeService.getInstance();
        commandes = cs.DisplayAll();
        
       
       
      admincommande.setItems(commandes);
          commande.setCellValueFactory(cell -> new SimpleStringProperty (""+cell.
                getValue().getId()));
          user.setCellValueFactory(cell -> new SimpleStringProperty (""+cell.
                getValue().getUser_id()));
           produits.setCellValueFactory(cell -> new SimpleStringProperty (""+cell.
                getValue().getProduits()));
 
 prix.setCellValueFactory(cell -> new SimpleStringProperty (""+cell.
                getValue().getPrix_total()));
 date.setCellValueFactory(cell -> new SimpleStringProperty (""+cell.
                getValue().getDate()));   
    
     stat.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/eplants/view/Stat.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(PanierController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    } 
    
   
          
    
}
