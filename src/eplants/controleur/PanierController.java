/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eplants.controleur;

import eplants.entities.Panier;
import eplants.services.PanierService;
import eplants.services.ProduitService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author User
 */
public class PanierController implements Initializable {
     /**
     * Initializes the controller class.
     */
     @FXML
    private TableView<Panier> paniertable;
    @FXML
    private TableColumn<Panier, String> imgColonne;
    @FXML
    private TableColumn<Panier, String> nomColonne;
    @FXML
    private TableColumn<Panier, String> qteColonne;
    @FXML
    private TableColumn<Panier, String> puColonne;
    @FXML
    private TableColumn<Panier, String> ptColonne;
    
     private   ObservableList<Panier> paniers= FXCollections.observableArrayList();
    
     @Override
    public void initialize(URL url, ResourceBundle rb){
        
        
         
      PanierService ps =  PanierService.getInstance();
      ProduitService pr =  ProduitService.getInstance();
      paniers = ps.DisplayAll(3);
      paniertable.setItems(paniers);
        imgColonne.setCellValueFactory(cell ->new SimpleStringProperty (pr.FindProduit( cell.
                getValue().getProduit_id()).getImg()));
        nomColonne.setCellValueFactory(cell -> new SimpleStringProperty (pr.FindProduit( cell.
                getValue().getProduit_id()).getNom()));
        qteColonne.setCellValueFactory(cell -> new SimpleStringProperty (""+cell.
                getValue().getQuantite()));
        puColonne.setCellValueFactory(cell -> new SimpleStringProperty (""+pr.FindProduit( cell.
                getValue().getProduit_id()).getPrix()));
        ptColonne.setCellValueFactory(cell -> new SimpleStringProperty (""+pr.FindProduit( cell.
                getValue().getProduit_id()).getPrix()*cell.
                getValue().getQuantite()));
    }
    
}
