package com.jasmin.social.backend.repository;

import com.jasmin.social.backend.entity.TagTrieNodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagTrieRepository extends JpaRepository<TagTrieNodeEntity, Long> {
    TagTrieNodeEntity findByCharacterAndParentId(char c, Long id);

}
