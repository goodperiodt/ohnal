package com.ohnal.chap.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@EqualsAndHashCode
public class Search extends Page{
    
    private String type, keyword;
    
    public Search() {
        this.type = "";
        this.keyword = "";
    }
    
}
