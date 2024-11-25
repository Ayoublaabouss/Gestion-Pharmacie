package com.example.Produits.services;

import com.example.Produits.entities.Produit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // Annoter avec @Service pour que Spring gère cette classe comme un bean de service
public class ProduitServiceImpl implements ProduitService {

    // Liste temporaire pour simuler une base de données
    private List<Produit> produits = new ArrayList<>();

    @Override
    public List<Produit> getAllProduits() {
        return produits;
    }

    @Override
    public Produit getProduitById(Long id) {
        return produits.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addProduit(Produit produit) {
        produits.add(produit); // Ajout d'un produit à la liste
    }

    @Override
    public void updateProduit(Long id, Produit produit) {
        Produit existingProduit = getProduitById(id); // Recherche du produit par son ID
        if (existingProduit != null) {
            // Mise à jour des informations du produit
            existingProduit.setNom(produit.getNom());
            existingProduit.setDosage(produit.getDosage());
            existingProduit.setPrix(produit.getPrix());
        }
    }

    @Override
    public <Produits> void addProduit(Produits produit) {

    }

    @Override
    public <Produits> void updateProduit(Long id, Produits produit) {

    }

    @Override
    public void deleteProduit(Long id) {
        produits.removeIf(p -> p.getId().equals(id)); // Suppression du produit par ID
    }

    @Override
    public <ProduitDTO> ProduitDTO getProduitsById(Long id) {
        return null;
    }
}
