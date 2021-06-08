package shop.goodcasting.api.article.profile.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProfile is a Querydsl query type for Profile
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProfile extends EntityPathBase<Profile> {

    private static final long serialVersionUID = -1572725872L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProfile profile = new QProfile("profile");

    public final shop.goodcasting.api.common.domain.QBaseEntity _super = new shop.goodcasting.api.common.domain.QBaseEntity(this);

    public final shop.goodcasting.api.user.actor.domain.QActor actor;

    public final NumberPath<Double> confidence = createNumber("confidence", Double.class);

    public final StringPath contents = createString("contents");

    public final BooleanPath first = createBoolean("first");

    //inherited
    public final DateTimePath<java.sql.Timestamp> modDate = _super.modDate;

    public final BooleanPath privacy = createBoolean("privacy");

    public final NumberPath<Long> profileId = createNumber("profileId", Long.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> regDate = _super.regDate;

    public final StringPath resemble = createString("resemble");

    public QProfile(String variable) {
        this(Profile.class, forVariable(variable), INITS);
    }

    public QProfile(Path<? extends Profile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProfile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProfile(PathMetadata metadata, PathInits inits) {
        this(Profile.class, metadata, inits);
    }

    public QProfile(Class<? extends Profile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.actor = inits.isInitialized("actor") ? new shop.goodcasting.api.user.actor.domain.QActor(forProperty("actor"), inits.get("actor")) : null;
    }

}

