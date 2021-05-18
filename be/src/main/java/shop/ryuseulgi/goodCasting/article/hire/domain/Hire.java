package shop.ryuseulgi.goodCasting.article.hire.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.ryuseulgi.goodCasting.common.domain.BaseEntity;
import shop.ryuseulgi.goodCasting.common.domain.HireProfile;
import shop.ryuseulgi.goodCasting.user.producer.domain.Producer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Entity
@Table(name = "hires")
@NoArgsConstructor
@AllArgsConstructor
public class Hire extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hire_id") private Long hireId;

    @Column private String title;
    @Column private String contents;
    @Column private String cast;    //배역
    @Column private String filming; //촬영기간
    @Column private String guarantee; //출연료
    @Column private String personnel; //모집인원
    @Column private String deadline; //공고마감일

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @OneToMany(mappedBy = "hire")
    private List<HireProfile> hireProfiles = new ArrayList<>();

    public void changeHireId(Long hireId) {
        this.hireId = hireId;
    }

    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeContents(String contents) {
        this.contents = contents;
    }

    public void changeCast(String cast) {
        this.cast = cast;
    }

    public void changeFilming(String filming) {
        this.filming = filming;
    }

    public void changeGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public void changePersonnel(String personnel) {
        this.personnel = personnel;
    }

    public void changeDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void changeProducer(Producer producer) {
        this.producer = producer;
    }

    public void changeProfiles(List<HireProfile> hireProfiles) {
        this.hireProfiles = hireProfiles;
    }
}
