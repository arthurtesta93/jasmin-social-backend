package com.jasmin.social.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TagSearchWithContextDTO {

    private String[] tags;
    private int contextLevel;

}
