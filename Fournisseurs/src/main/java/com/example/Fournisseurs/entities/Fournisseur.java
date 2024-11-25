package com.example.Fournisseurs.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fournisseur {
    private Long id;
    private String nom;
    private String contact;
}

