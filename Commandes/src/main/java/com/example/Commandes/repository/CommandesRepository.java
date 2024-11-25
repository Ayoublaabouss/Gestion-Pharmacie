package com.example.Commandes.repository;

import com.example.Commandes.Entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandesRepository extends JpaRepository<Commande, Long> {
}
