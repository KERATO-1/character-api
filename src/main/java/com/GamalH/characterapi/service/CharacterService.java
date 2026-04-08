package com.GamalH.characterapi.service;

import com.GamalH.characterapi.entity.Character;
import com.GamalH.characterapi.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepository repository;

    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    public List<Character> getAllCharacters() {
        return repository.findAll();
    }

    public Optional<Character> getCharacterById(Long id) {
        return repository.findById(id);
    }

    public Character addCharacter(Character character) {
        character.setCharacterId(null);
        return repository.save(character);
    }

    public Optional<Character> updateCharacter(Long id, Character updatedCharacter) {
        return repository.findById(id).map(character -> {
            character.setName(updatedCharacter.getName());
            character.setDescription(updatedCharacter.getDescription());
            character.setUniverse(updatedCharacter.getUniverse());
            character.setSpecies(updatedCharacter.getSpecies());
            return repository.save(character);
        });
    }

    public boolean deleteCharacter(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    public List<Character> getCharactersByUniverse(String universe) {
        return repository.findByUniverseIgnoreCase(universe);
    }

    public List<Character> searchCharactersByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}