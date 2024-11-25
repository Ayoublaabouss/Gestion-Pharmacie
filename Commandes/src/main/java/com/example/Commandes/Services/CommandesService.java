package com.example.Commandes.Services;

import com.example.Commandes.dto.CommandeDTO;
import java.util.List;

public interface CommandesService {
    CommandeDTO createCommande(CommandeDTO commandeDTO);
    CommandeDTO updateCommande(Long id, CommandeDTO commandeDTO);
    CommandeDTO getCommande(Long id);
    List<CommandeDTO> getAllCommandes();
    void deleteCommande(Long id);
}

