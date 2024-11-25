package com.example.Fournisseurs.mappers;

import com.example.Fournisseurs.dto.FournisseursDTO;
import com.example.Fournisseurs.entities.Fournisseur;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

public class FournisseursMapper {
    @Component
        public FournisseursDTO toDTO(Fournisseur fournisseur) {
            FournisseursDTO fournisseursDTO = new FournisseursDTO();
            BeanUtils.copyProperties(fournisseur, fournisseursDTO);
            return fournisseursDTO;
        }

        public Fournisseur toEntity(FournisseursDTO fournisseursDTO) {
            Fournisseur fournisseur = new Fournisseur();
            BeanUtils.copyProperties(fournisseursDTO, fournisseur);
            return fournisseur;
        }


}
