package com.example.Commandes.Services.impl;

import com.example.Commandes.Entities.Commande;
import com.example.Commandes.Entities.Fournisseur;
import com.example.Commandes.Services.CommandesService;
import com.example.Commandes.dto.CommandeDTO;
import com.example.Commandes.Entities.Produit;
import com.example.Commandes.repository.CommandesRepository;
import com.example.Fournisseurs.repository.FournisseursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommandeServiceImpl implements CommandesService {

    private final CommandesRepository commandeRepository;
    private final ProduitRepository produitRepository;
    private final FournisseursRepository fournisseurRepository;

    @Override
    public CommandeDTO createCommande(CommandeDTO commandeDTO) {
        // Vérifier si le produit et le fournisseur existent
        Produit produit = produitRepository.findById(commandeDTO.getProduitId())
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        Fournisseur fournisseur = fournisseurRepository.findById(commandeDTO.getFournisseurId())
                .orElseThrow(() -> new RuntimeException("Fournisseur non trouvé"));

        // Mapper le DTO vers l'entité Commande
        Commande commande = new Commande();
        BeanUtils.copyProperties(commandeDTO, commande);
        commande.setProduit(produit);
        commande.setFournisseur(fournisseur);

        // Sauvegarder la commande
        Commande savedCommande = commandeRepository.save(commande);

        // Mapper l'entité Commande vers le DTO
        CommandeDTO result = new CommandeDTO();
        BeanUtils.copyProperties(savedCommande, result);
        return result;
    }

    @Override
    public CommandeDTO updateCommande(Long id, CommandeDTO commandeDTO) {
        // Vérifier si la commande existe
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande non trouvée"));

        // Vérifier si le produit et le fournisseur existent
        Produit produit = produitRepository.findById(commandeDTO.getProduitId())
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        Fournisseur fournisseur = fournisseurRepository.findById(commandeDTO.getFournisseurId())
                .orElseThrow(() -> new RuntimeException("Fournisseur non trouvé"));

        // Mettre à jour la commande
        commande.setProduit(produit);
        commande.setFournisseur(fournisseur);
        commande.setQuantite(commandeDTO.getQuantite());

        // Sauvegarder la commande mise à jour
        Commande updatedCommande = commandeRepository.save(commande);

        // Mapper l'entité Commande vers le DTO
        CommandeDTO result = new CommandeDTO();
        BeanUtils.copyProperties(updatedCommande, result);
        return result;
    }

    @Override
    public CommandeDTO getCommande(Long id) {
        // Vérifier si la commande existe
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande non trouvée"));

        // Mapper l'entité Commande vers le DTO
        CommandeDTO result = new CommandeDTO();
        BeanUtils.copyProperties(commande, result);
        return result;
    }

    @Override
    public List<CommandeDTO> getAllCommandes() {
        // Récupérer toutes les commandes
        return commandeRepository.findAll().stream()
                .map(commande -> {
                    CommandeDTO dto = new CommandeDTO();
                    BeanUtils.copyProperties(commande, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCommande(Long id) {
        // Vérifier si la commande existe
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande non trouvée"));

        // Supprimer la commande
        commandeRepository.delete(commande);
    }
}
