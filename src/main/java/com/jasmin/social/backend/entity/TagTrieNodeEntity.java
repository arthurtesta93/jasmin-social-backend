package com.jasmin.social.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tag_trie_node")
public class TagTrieNodeEntity {

    @Column(name = "tag_id")
    @Id
    private Long tagId;

    @Column(name = "tag_word")
    @NonNull
    private String tagWord;

    @Column(name = "is_end_of_tag")
    private boolean isEndOfTag;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private TagTrieNodeEntity parent;

    @OneToMany(mappedBy = "parent")
    private List<TagTrieNodeEntity> children;

}
