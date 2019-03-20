package com.tomo.webservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by betterfly
 * Date : 2019.03.20
 */

@Getter
@Setter
@NoArgsConstructor
public class SampleSaveRequestDTO {
    private String title;
    private String content;
    private String author;

    public Sample toEntity(){
        return Sample.builder()
                .title(this.title)
                .content(this.content)
                .author(this.author)
                .build();
    }
}
