package com.jasmin.social.backend.repository;

import com.jasmin.social.backend.entity.TagTrieNodeEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagTrieRepository extends JpaRepository<TagTrieNodeEntity, Long> {
    TagTrieNodeEntity findByTagWordAndParent(@NonNull String tagWord, TagTrieNodeEntity parent);

}
