/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eplants.entities;

/**
 *
 * @author User
 */
public class Produit {
    private int id;
    private String  nom;
    private String img;
    private String description;
    private double prix;
    private int stock;

    public Produit() {
    }

    public Produit(int id, String nom, String img, String description, double prix, int stock) {
        this.id = id;
        this.nom = nom;
        this.img = img;
        this.description = description;
        this.prix = prix;
        this.stock = stock;
    }

    public Produit(String nom, String img, String description, double prix, int stock) {
        this.nom = nom;
        this.img = img;
        this.description = description;
        this.prix = prix;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
   
    
}
