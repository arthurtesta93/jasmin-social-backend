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
            root.setTagWord(""); // Or any appropriate root tag word
            trieNodeRepository.save(root); // Save the root node
        }

        TagTrieNodeEntity current = root;
        for (int i = 0; i < tag.length(); i++) {
            String tagPart = tag.substring(0, i + 1); // Get the current part of the tag
            TagTrieNodeEntity node = trieNodeRepository.findByTagWordAndParent(tagPart, current);

            if (node == null) {
                node = new TagTrieNodeEntity();
                node.setTagWord(tagPart);
                node.setParent(current);
                trieNodeRepository.save(node); // Save the new node before proceeding
            }

            current = node;
        }

        current.setEndOfTag(true);
        trieNodeRepository.save(current); // Save the final node to ensure `endOfTag` is updated
    }

    public boolean search(String tag) {
        return false;
    }


}
