package com.jasmin.social.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//getter, setter, constructor annotations

@Table(name = "trie_node")
@Getter
@Setter
@Entity
public class TagTrieNodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private char character;
    private boolean isEndOfTag;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private TagTrieNodeEntity parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<TagTrieNodeEntity> children;


}