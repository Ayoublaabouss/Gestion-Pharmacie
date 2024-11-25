package com.example.Produits.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    private Long id;
    private String nom;
    private String dosage;
    private double prix;
}
