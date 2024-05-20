package com.jasmin.social.backend.service;

import com.jasmin.social.backend.entity.TagTrieNodeEntity;
import com.jasmin.social.backend.repository.TagTrieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagTrieService {
    private TagTrieNodeEntity root;

    // Methods for inserting, searching, and deleting tags in the TRIE structure
    private TagTrieRepository trieNodeRepository;

    @Autowired
    public TagTrieService(TagTrieRepository trieNodeRepository) {
        this.trieNodeRepository = trieNodeRepository;
    }

    // Insert a tag into the TRIE structure
    @Transactional
    public void insert(String tag) {
        if (root == null) {
            root = new TagTrieNodeEntity();
        }
        TagTrieNodeEntity current = root;
        for (int i = 0; i < tag.length(); i++) {
            char c = tag.charAt(i);
            TagTrieNodeEntity node = trieNodeRepository.findByCharacterAndParentId(c, current.getId());
            if (node == null) {
                node = new TagTrieNodeEntity();
                node.setCharacter(c);
                node.setParent(current);
                trieNodeRepository.save(node);
            }
            current = node;
        }
        current.setEndOfTag(true);
    }

    public boolean search(String tag) {
        return false;
    }


}
