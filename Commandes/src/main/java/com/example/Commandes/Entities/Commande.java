package com.example.Commandes.Entities;

import com.example.Fournisseurs.entities.Fournisseur;
import com.example.Produits.entities.Produit;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "commandes")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produit_id", nullable = false)
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id", nullable = false)
    private Fournisseur fournisseur;

    private Integer quantite;
}

