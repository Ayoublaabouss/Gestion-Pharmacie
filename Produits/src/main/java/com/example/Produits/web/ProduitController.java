package com.example.Produits.web;

import com.example.Produits.dto.ProduitDTO;
import com.example.Produits.services.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
@RequiredArgsConstructor // Utilisation de l'injection de dépendances automatique par le constructeur
public class ProduitController {

    private final ProduitService produitService;

    // Endpoint pour obtenir tous les produits
    @GetMapping
    public List<ProduitDTO> getAllProduits() {
        return produitService.getAllProduits();
    }

    // Endpoint pour obtenir un produit par son ID
    @GetMapping("/{id}")
    public ProduitDTO getProduitById(@PathVariable Long id) {
        return produitService.getProduitsById(id); // Appel au service pour récupérer le produit
    }

    // Endpoint pour ajouter un nouveau produit
    @PostMapping("/add")
    public void addProduit(@RequestBody ProduitDTO produitDTO) {
        produitService.addProduit(produitDTO);
    }

    // Endpoint pour mettre à jour un produit existant
    @PutMapping("/{id}")
    public void updateProduit(@PathVariable Long id, @RequestBody ProduitDTO produitDTO) {
        produitService.updateProduit(id, produitDTO);
    }

    // Endpoint pour supprimer un produit
    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
    }
}
