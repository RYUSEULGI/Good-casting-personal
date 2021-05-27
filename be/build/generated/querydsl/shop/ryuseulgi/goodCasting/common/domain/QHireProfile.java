package shop.ryuseulgi.goodCasting.common.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHireProfile is a Querydsl query type for HireProfile
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHireProfile extends EntityPathBase<HireProfile> {

    private static final long serialVersionUID = 589216249L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHireProfile hireProfile = new QHireProfile("hireProfile");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final shop.ryuseulgi.goodCasting.article.hire.domain.QHire hire;

    public final NumberPath<Long> hireProfileId = createNumber("hireProfileId", Long.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> modDate = _super.modDate;

    public final shop.ryuseulgi.goodCasting.article.profile.domain.QProfile profile;

    //inherited
    public final DateTimePath<java.sql.Timestamp> regDate = _super.regDate;

    public QHireProfile(String variable) {
        this(HireProfile.class, forVariable(variable), INITS);
    }

    public QHireProfile(Path<? extends HireProfile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHireProfile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHireProfile(PathMetadata metadata, PathInits inits) {
        this(HireProfile.class, metadata, inits);
    }

    public QHireProfile(Class<? extends HireProfile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hire = inits.isInitialized("hire") ? new shop.ryuseulgi.goodCasting.article.hire.domain.QHire(forProperty("hire"), inits.get("hire")) : null;
        this.profile = inits.isInitialized("profile") ? new shop.ryuseulgi.goodCasting.article.profile.domain.QProfile(forProperty("profile"), inits.get("profile")) : null;
    }

}

