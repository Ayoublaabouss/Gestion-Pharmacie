package com.example.Fournisseurs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class FournisseursDTO {
        private Long id;
        private String nom;
        private String contact; // Correctement terminé par un point-virgule
}

