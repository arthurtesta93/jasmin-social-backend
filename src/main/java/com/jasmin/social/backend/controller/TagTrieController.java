package com.jasmin.social.backend.controller;

import com.jasmin.social.backend.service.TagTrieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagTrieController {
    @Autowired
    private TagTrieService tagTrieService;

    // REST endpoints to interact with the TRIE structure
        @PostMapping("/tag")
        public void insertTag(String tag) {
            tagTrieService.insert(tag);
        }

}
