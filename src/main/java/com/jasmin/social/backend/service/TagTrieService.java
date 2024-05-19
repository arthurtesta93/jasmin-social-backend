package com.jasmin.social.backend.service;

import com.jasmin.social.backend.entity.TagTrieNodeEntity;
import com.jasmin.social.backend.repository.TagTrieRepository;
import org.springframework.stereotype.Service;

@Service
public class TagTrieService {
    private TagTrieNodeEntity root;

    // Methods for inserting, searching, and deleting tags in the TRIE structure
    private TagTrieRepository trieNodeRepository;

    public void insert(String tag) {
        // Implementation to insert tag into the TRIE structure
    }

    public boolean search(String tag) {
        // Implementation to search for a tag in the TRIE structure
        return false;
    }

}
