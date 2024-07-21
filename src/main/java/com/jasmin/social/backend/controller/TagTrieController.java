package com.jasmin.social.backend.controller;

import com.jasmin.social.backend.dto.TagSearchWithContextDTO;
import com.jasmin.social.backend.service.TagTrieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TagTrieController {
    @Autowired
    private TagTrieService tagTrieService;

    @PostMapping("/tag")
    public ResponseEntity<String> insertTag(@RequestBody String tag) {
        try {
            return tagTrieService.insert(tag);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/tag")
    public boolean searchTag(@RequestBody String tag) {
        return tagTrieService.search(tag);
    }

    @GetMapping("/tag/{tag}/context")
    public ResponseEntity<TagSearchWithContextDTO> searchTagWithContext(@PathVariable String tag) {
        try {
            return tagTrieService.searchWithContext(tag);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/tag")
    public void deleteTag(@RequestBody String tag) {
        tagTrieService.delete(tag);
    }

}


