package shop.goodcasting.api.career.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCareer is a Querydsl query type for Career
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCareer extends EntityPathBase<Career> {

    private static final long serialVersionUID = 385069292L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCareer career = new QCareer("career");

    public final shop.goodcasting.api.common.domain.QBaseEntity _super = new shop.goodcasting.api.common.domain.QBaseEntity(this);

    public final NumberPath<Long> careerId = createNumber("careerId", Long.class);

    public final StringPath contents = createString("contents");

    public final StringPath genre = createString("genre");

    //inherited
    public final DateTimePath<java.sql.Timestamp> modDate = _super.modDate;

    public final shop.goodcasting.api.article.profile.domain.QProfile profile;

    //inherited
    public final DateTimePath<java.sql.Timestamp> regDate = _super.regDate;

    public final StringPath title = createString("title");

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QCareer(String variable) {
        this(Career.class, forVariable(variable), INITS);
    }

    public QCareer(Path<? extends Career> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCareer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCareer(PathMetadata metadata, PathInits inits) {
        this(Career.class, metadata, inits);
    }

    public QCareer(Class<? extends Career> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.profile = inits.isInitialized("profile") ? new shop.goodcasting.api.article.profile.domain.QProfile(forProperty("profile"), inits.get("profile")) : null;
    }

}

