package com.ohnal.chap.dto.response;

import lombok.*;

@Getter @Setter @ToString
@EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
@Builder
public class WeatherInfoResponseDTO {
    private String area1;
    private String area2;
    private double maxTemperature;
    private double minTemperature;
    private int presentTemperature; // 현재기온
    private String comment;
    private String styleImage;
    private String weatherIcon;
}
