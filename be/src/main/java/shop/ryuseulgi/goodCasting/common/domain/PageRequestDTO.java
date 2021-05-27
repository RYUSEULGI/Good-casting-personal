package shop.ryuseulgi.goodCasting.common.domain;

import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@ToString
@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {
    private Integer page;
    private Integer size;
    private String type;
    private String rkeyword;
    private Integer hfrom;
    private Integer hto;
    private Integer afrom;
    private Integer ato;
    private String gkeyword;
    private Integer wfrom;
    private Integer wto;

    public PageRequestDTO() {
        this.page = 1;
        this.size = 10;
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page - 1, size, sort);
    }
}
