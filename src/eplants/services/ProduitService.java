/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eplants.services;

import eplants.config.ConnexionSingleton;
import eplants.entities.Produit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author User
 */
public class ProduitService {
    
     private static ProduitService instance;
    private Statement st;
    private ResultSet rs;
    
    private ProduitService() {
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ProduitService getInstance(){
        if(instance==null) 
            instance=new ProduitService();
        return instance;
    }
    
    public List<Produit> DisplayAll(){
        String req="select * from produit";
        List<Produit> list=new ArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Produit p=new Produit();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setImg(rs.getString(3));
                p.setPrix(rs.getDouble(5));
                p.setStock(rs.getInt(6));
                p.setDescription(rs.getString(4));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    
    }
    public Produit FindProduit(int id){
        String req="select * from produit where id = '"+id+"'";
Produit p=new Produit();        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setImg(rs.getString(3));
                p.setPrix(rs.getDouble(5));
                p.setStock(rs.getInt(6));
                p.setDescription(rs.getString(4));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    
    }
    
     

}
