package com.spring.mvc.chap05.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;



@Getter @Setter @ToString
@EqualsAndHashCode @NoArgsConstructor
@AllArgsConstructor @Builder
public class KakaoUserResponseDTO {

    private long id;

    @JsonProperty("connected_at")
    private LocalDateTime connectedAt;

    private Properties properties;

    @JsonProperty("kakao_account")
    private KakaoAccount account;

    @Setter @Getter @ToString
    public static class Properties{

        /*
        내부(중첩) 클래스는 static 으로 선언 하는 것을 권장함 
        외부 클래스가 GC의 수거 대상으로 선정되기 전에,
        내부 클래스가 항상 외부 클래스를 참조하고 있기 때문에
        GC가 외부 클래스를 수거 대상으로 인식하지 못한다 
        -> 메모리에 상주 -> 메모리의 누수를 초래.
        */
        
        private String nickname;

        @JsonProperty("profile_image")
        private String profileImage;
        
        @JsonProperty("thumbnail_image")
        private String thumbnailImage;



    }

    @Setter @Getter @ToString
    public static class KakaoAccount{

        private String email;

    }















}
