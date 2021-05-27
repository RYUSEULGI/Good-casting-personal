package shop.ryuseulgi.goodCasting.apply.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QApply is a Querydsl query type for Apply
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QApply extends EntityPathBase<Apply> {

    private static final long serialVersionUID = 388986681L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QApply apply = new QApply("apply");

    public final shop.ryuseulgi.goodCasting.common.domain.QBaseEntity _super = new shop.ryuseulgi.goodCasting.common.domain.QBaseEntity(this);

    public final NumberPath<Long> applyId = createNumber("applyId", Long.class);

    public final NumberPath<Long> applyStatus = createNumber("applyStatus", Long.class);

    public final shop.ryuseulgi.goodCasting.article.hire.domain.QHire hire;

    //inherited
    public final DateTimePath<java.sql.Timestamp> modDate = _super.modDate;

    public final shop.ryuseulgi.goodCasting.article.profile.domain.QProfile profile;

    //inherited
    public final DateTimePath<java.sql.Timestamp> regDate = _super.regDate;

    public QApply(String variable) {
        this(Apply.class, forVariable(variable), INITS);
    }

    public QApply(Path<? extends Apply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QApply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QApply(PathMetadata metadata, PathInits inits) {
        this(Apply.class, metadata, inits);
    }

    public QApply(Class<? extends Apply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hire = inits.isInitialized("hire") ? new shop.ryuseulgi.goodCasting.article.hire.domain.QHire(forProperty("hire"), inits.get("hire")) : null;
        this.profile = inits.isInitialized("profile") ? new shop.ryuseulgi.goodCasting.article.profile.domain.QProfile(forProperty("profile"), inits.get("profile")) : null;
    }

}

