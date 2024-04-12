package com.ohnal.chap.common;

import lombok.*;

@Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Page {

    private int pageNo = 1;
    private int amount = 12;
    
    public int getFirstPage() {
        return (pageNo - 1) * amount;
    }

}
