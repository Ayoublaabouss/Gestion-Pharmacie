package com.example.Commandes.mappers;

import com.example.Commandes.dto.CommandeDTO;
import com.example.Commandes.Entities.Commande;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CommandeMapper {

    public CommandeDTO toDTO(Commande commande) {
        CommandeDTO commandeDTO = new CommandeDTO();
        BeanUtils.copyProperties(commande, commandeDTO);

        // Assurer que les IDs des relations (Produit et Fournisseur) sont mappés correctement
        if (commande.getProduit() != null) {
            commandeDTO.setProduitId(commande.getProduit().getId());
        }
        if (commande.getFournisseur() != null) {
            commandeDTO.setFournisseurId(commande.getFournisseur().getId());
        }

        return commandeDTO;
    }

    public Commande toEntity(CommandeDTO commandeDTO) {
        Commande commande = new Commande();
        BeanUtils.copyProperties(commandeDTO, commande);

        // Les relations (Produit et Fournisseur) devront être liées dans le service
        // Ces objets ne sont pas initialisés ici pour éviter de charger des relations inutiles

        return commande;
    }
}
