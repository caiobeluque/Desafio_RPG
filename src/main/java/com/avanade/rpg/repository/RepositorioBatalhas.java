package com.avanade.rpg.repository;

import com.avanade.rpg.model.Batalhas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioBatalhas extends JpaRepository<Batalhas, Integer > {

}
