package shop.ryuseulgi.goodCasting.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@ToString
@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {
    private Integer page;
    private Integer size;
    private String type;
    private String sort;

    private String rKeyword;
    private Integer hFrom;
    private Integer hto;
    private Integer aFrom;
    private Integer ato;
    private String gKeyword;
    private Integer wFrom;
    private Integer wto;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fto;

    private String conKeyword;
    private String castKeyword;
    private Integer gFrom;
    private Integer gto;
    private String tKeyword;
    private String pKeyword;

    public PageRequestDTO() {
        this.page = 1;
        this.size = 10;
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page - 1, size, sort);
    }
}