/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eplants.controleur;

import eplants.entities.Livraison;
import eplants.entities.Panier;
import eplants.services.LivraisonService;
import eplants.services.PanierService;
import eplants.services.ProduitService;
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
public class LivraisonController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Livraison> livraisontable ;
    @FXML
    private TableColumn<Livraison, String> id_commande;
    @FXML
    private TableColumn<Livraison, String> adresse;
    @FXML
    private Button livre;
     private   ObservableList<Livraison> Livraisons= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          LivraisonService ls =  LivraisonService.getInstance();
      ProduitService pr =  ProduitService.getInstance();
      Livraisons= ls.DisplayAll(4);
      livraisontable.setItems(Livraisons);
        id_commande.setCellValueFactory(cell ->new SimpleStringProperty (""+cell.
                getValue().getCommande_id()));
        adresse.setCellValueFactory(cell ->new SimpleStringProperty (""+cell.
                getValue().getAddresse()));
         livre.setOnAction(event -> {

          int x=livraisontable.getSelectionModel().getSelectedItem().getCommande_id();
               
                
                     ls.modifierlivraison(x);
                     
        });
    }    
    
}
