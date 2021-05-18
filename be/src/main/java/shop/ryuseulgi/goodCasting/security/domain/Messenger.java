package shop.ryuseulgi.goodCasting.security.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Messenger {
    private String message;
    private int status;
    private String code;
}