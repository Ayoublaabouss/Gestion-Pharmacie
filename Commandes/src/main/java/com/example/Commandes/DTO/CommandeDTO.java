package com.example.Commandes.dto;

import lombok.Data;

@Data
public class CommandeDTO {
    private Long id;
    private Long produitId;
    private Long fournisseurId;
    private Integer quantite;
}
