package com.example.Fournisseurs.repository;

import com.example.Fournisseurs.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseursRepository extends JpaRepository<Fournisseur,Long> {
}