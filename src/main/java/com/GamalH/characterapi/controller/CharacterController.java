package com.GamalH.characterapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GamalH.characterapi.entity.Character;
import com.GamalH.characterapi.service.CharacterService;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @GetMapping
    public List<Character> getAllCharacters() {
        return service.getAllCharacters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Long id) {
        return service.getCharacterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Character> addCharacter(@RequestBody Character character) {
        if (character.getName() == null || character.getName().isBlank()
                || character.getDescription() == null || character.getDescription().isBlank()
                || character.getUniverse() == null || character.getUniverse().isBlank()
                || character.getSpecies() == null || character.getSpecies().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        Character createdCharacter = service.addCharacter(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCharacter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Long id, @RequestBody Character character) {
        if (character.getName() == null || character.getName().isBlank()
                || character.getDescription() == null || character.getDescription().isBlank()
                || character.getUniverse() == null || character.getUniverse().isBlank()
                || character.getSpecies() == null || character.getSpecies().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        return service.updateCharacter(id, character)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) {
        boolean deleted = service.deleteCharacter(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{category}")
    public List<Character> getCharactersByCategory(@PathVariable("category") String universe) {
        return service.getCharactersByUniverse(universe);
    }

    @GetMapping("/search")
    public List<Character> searchCharactersByName(@RequestParam String name) {
        return service.searchCharactersByName(name);
    }
}