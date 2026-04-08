package com.GamalH.characterapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GamalH.characterapi.entity.Character;

public interface CharacterRepository extends JpaRepository<Character, Long> {

    List<Character> findByUniverseIgnoreCase(String universe);

    List<Character> findByNameContainingIgnoreCase(String name);
}