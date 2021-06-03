package shop.ryuseulgi.goodCasting.article.hire.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Builder
@AllArgsConstructor
@Data
public class Pay {

    private Integer start;
    private Integer end;
}
