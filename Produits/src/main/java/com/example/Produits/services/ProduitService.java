package com.example.Produits.services;
import com.example.Produits.entities.Produit;

import java.util.List;

  public interface ProduitService {
    <Produits> List<Produits> getAllProduits();
    <Produits> Produits getProduitById(Long id);

    void addProduit(Produit produit);

    void updateProduit(Long id, Produit produit);

    <Produits> void addProduit(Produits produit);
    <Produits> void updateProduit(Long id, Produits produit);
    void deleteProduit(Long id);

    <ProduitDTO> ProduitDTO getProduitsById(Long id);
  }
