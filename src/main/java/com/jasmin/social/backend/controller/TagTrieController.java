package com.jasmin.social.backend.controller;

import com.jasmin.social.backend.service.TagTrieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagTrieController {
    @Autowired
    private TagTrieService tagTrieService;

    // REST endpoints to interact with the TRIE structure
        @PostMapping("/tag")
        public void insertTag(@RequestBody String tag) {
            tagTrieService.insert(tag);
        }

        // Search for a single tag in the TRIE structure

        @GetMapping("/tag")
        public boolean searchTag(@RequestBody String tag) {
            return tagTrieService.search(tag);
        }


}


