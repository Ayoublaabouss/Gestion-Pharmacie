
package com.example.Fournisseurs.service;

import com.example.Fournisseurs.dto.FournisseursDTO;
import com.example.Fournisseurs.entities.Fournisseur;
import com.example.Fournisseurs.mappers.FournisseursMapper;
import com.example.Fournisseurs.repository.FournisseursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FournisseursServiceImpl implements FournisseursService {

    private final FournisseursRepository fournisseursRepository;
    private final FournisseursMapper fournisseursMapper;

    @Override
    public FournisseursDTO createFournisseur(FournisseursDTO fournisseursDTO) {
        Fournisseur fournisseur = fournisseursMapper.toEntity(fournisseursDTO);
        Fournisseur saveFournisseur = fournisseursRepository.save(fournisseur);
        return fournisseursMapper.toDTO(saveFournisseur);
    }

    @Override
    public FournisseursDTO updateFournisseur(Long id, FournisseursDTO fournisseursDTO) {
        Optional<Fournisseur> optionalFournisseur = fournisseursRepository.findById(id);
        if (optionalFournisseur.isPresent()) {
            Fournisseur fournisseur = optionalFournisseur.get();
            fournisseur.setNom(fournisseursDTO.getNom());
            fournisseur.setContact(fournisseursDTO.getContact());
            // Ajouter d'autres champs si nécessaire.

            Fournisseur updatedFournisseur = fournisseursRepository.save(fournisseur);
            return fournisseursMapper.toDTO(updatedFournisseur);
        } else {
            throw new RuntimeException("Ce fournisseur n'existe pas");
        }
    }

    @Override
    public FournisseursDTO getFournisseur(Long id) {
        Fournisseur fournisseur = fournisseursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ce fournisseur n'existe pas"));
        return fournisseursMapper.toDTO(fournisseur);
    }

    @Override
    public List<FournisseursDTO> getAllFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseursRepository.findAll();
        return fournisseurs.stream()
                .map(fournisseursMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteFournisseur(Long id) {
        Fournisseur fournisseur = fournisseursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ce fournisseur avec l'ID " + id + " n'existe pas"));
        fournisseursRepository.delete(fournisseur);
    }
}
