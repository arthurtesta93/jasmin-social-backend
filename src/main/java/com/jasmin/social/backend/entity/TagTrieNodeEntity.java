package com.jasmin.social.backend.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class TagTrieNodeEntity {

    private char character;
    private boolean isEndOfTag;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private TagTrieNodeEntity parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<TagTrieNodeEntity> children;

    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    // Constructors, getters, setters

    public void setCharacter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public void setEndOfTag(boolean endOfTag) {
        isEndOfTag = endOfTag;
    }

    public boolean isEndOfTag() {
        return isEndOfTag;
    }

    public void setParent(TagTrieNodeEntity parent) {
        this.parent = parent;
    }

    public TagTrieNodeEntity getParent() {
        return parent;
    }

    public void setChildren(List<TagTrieNodeEntity> children) {
        this.children = children;
    }

    public List<TagTrieNodeEntity> getChildren() {
        return children;
    }

}
