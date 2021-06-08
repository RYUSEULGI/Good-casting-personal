package shop.goodcasting.api.user.actor.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QActor is a Querydsl query type for Actor
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QActor extends EntityPathBase<Actor> {

    private static final long serialVersionUID = 692272819L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QActor actor = new QActor("actor");

    public final shop.goodcasting.api.common.domain.QBaseEntity _super = new shop.goodcasting.api.common.domain.QBaseEntity(this);

    public final NumberPath<Long> actorId = createNumber("actorId", Long.class);

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath agency = createString("agency");

    public final StringPath birthday = createString("birthday");

    public final StringPath email = createString("email");

    public final StringPath gender = createString("gender");

    public final NumberPath<Integer> height = createNumber("height", Integer.class);

    public final BooleanPath major = createBoolean("major");

    //inherited
    public final DateTimePath<java.sql.Timestamp> modDate = _super.modDate;

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    //inherited
    public final DateTimePath<java.sql.Timestamp> regDate = _super.regDate;

    public final shop.goodcasting.api.user.login.domain.QUserVO user;

    public final NumberPath<Integer> weight = createNumber("weight", Integer.class);

    public QActor(String variable) {
        this(Actor.class, forVariable(variable), INITS);
    }

    public QActor(Path<? extends Actor> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QActor(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QActor(PathMetadata metadata, PathInits inits) {
        this(Actor.class, metadata, inits);
    }

    public QActor(Class<? extends Actor> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new shop.goodcasting.api.user.login.domain.QUserVO(forProperty("user")) : null;
    }

}

