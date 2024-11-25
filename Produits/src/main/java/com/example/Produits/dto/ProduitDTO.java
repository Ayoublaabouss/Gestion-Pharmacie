package com.example.Produits.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitDTO {
    private String nom;
    private String dosage;
    private double prix;
}
