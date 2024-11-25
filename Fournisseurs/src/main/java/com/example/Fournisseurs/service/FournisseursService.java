package com.example.Fournisseurs.service;

import com.example.Fournisseurs.dto.FournisseursDTO;

import java.util.List;

public interface FournisseursService {
    FournisseursDTO createFournisseur(FournisseursDTO fournisseurDTO); // Correction du nom
    FournisseursDTO updateFournisseur(Long id, FournisseursDTO fournisseurDTO); // Correction du nom
    FournisseursDTO getFournisseur(Long id); // Correction du nom
    List<FournisseursDTO> getAllFournisseurs(); // Correction du nom
        void deleteFournisseur(Long id); // Correction du nom
}
