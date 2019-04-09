/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eplants.controleur;

import eplants.entities.Panier;
import eplants.entities.Produit;
import eplants.services.PanierService;
import eplants.services.ProduitService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ProduitController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ScrollPane scrollprod;
    @FXML
    private Button panier;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ProduitService ps =  ProduitService.getInstance();
        PanierService pas =  PanierService.getInstance();
        GridPane Prodgrid = new GridPane();
        Prodgrid.setVgap(35);
        Prodgrid.setHgap(35);
          // TODO
        panier.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/eplants/view/Panier.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ProduitController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        List<Produit> Produits = ps.DisplayAll();
        int row = 0;
        int column =0;
        int i =0;
        for(Produit p : Produits){
            
        Pane produit = new Pane();
        
         File file = new File("C:/Users/User/Documents/NetBeansProjects/Eplants/src/images/"+p.getImg());
              ImageView imag = new ImageView();
              imag.setFitHeight(80);
              imag.setFitWidth(150);
          Image image = new Image(file.toURI().toString());
        imag.setImage(image);
        
        Text ProdName = new Text(p.getNom());
        Button panbutton = new Button("Ajouter au panier");
        Text Quantitel = new Text("Quantite");
        TextField quant = new TextField("1");
        quant.setMaxWidth(40);
        produit.getChildren().addAll(imag,ProdName,panbutton,Quantitel,quant);
         imag.setLayoutX(35);
             imag.setLayoutY(20);
             ProdName.setLayoutX(35);
             ProdName.setLayoutY(110);
             panbutton.setLayoutY(160);
             panbutton.setLayoutX(35);
              Quantitel.setLayoutY(145);
             Quantitel.setLayoutX(35);
             quant.setLayoutY(130);
             quant.setLayoutX(80);
             
             panbutton.setOnAction((event) -> {
                 Panier pan = new Panier(3, p.getId(), quant.getText().equalsIgnoreCase("")?1:Integer.valueOf(quant.getText()), "");
                 if(!pas.checkproduit(pan))
                 pas.ajouterPanier(pan);
                 else
                     pas.updatepanier(pan);
                     
             });
             
              if(i%3==0 && i!=0){
             row +=1;
          GridPane.setConstraints(produit, 0,row);
         Prodgrid.getChildren().add(produit);
         }
         
         else{
             
         GridPane.setConstraints(produit,column ,row);
         Prodgrid.getChildren().add(produit);
         column +=1;
         }
         i++;

        }
        
        scrollprod.setContent(Prodgrid);
                             // Always show vertical scroll bar
        scrollprod.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        
        // Horizontal scroll bar is only displayed when needed
        scrollprod.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        
       
    }    
    
}
