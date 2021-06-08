package shop.goodcasting.api.user.producer.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProducer is a Querydsl query type for Producer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProducer extends EntityPathBase<Producer> {

    private static final long serialVersionUID = 1957603119L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProducer producer = new QProducer("producer");

    public final shop.goodcasting.api.common.domain.QBaseEntity _super = new shop.goodcasting.api.common.domain.QBaseEntity(this);

    public final StringPath agency = createString("agency");

    public final StringPath email = createString("email");

    //inherited
    public final DateTimePath<java.sql.Timestamp> modDate = _super.modDate;

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final StringPath position = createString("position");

    public final NumberPath<Long> producerId = createNumber("producerId", Long.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> regDate = _super.regDate;

    public final shop.goodcasting.api.user.login.domain.QUserVO user;

    public QProducer(String variable) {
        this(Producer.class, forVariable(variable), INITS);
    }

    public QProducer(Path<? extends Producer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProducer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProducer(PathMetadata metadata, PathInits inits) {
        this(Producer.class, metadata, inits);
    }

    public QProducer(Class<? extends Producer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new shop.goodcasting.api.user.login.domain.QUserVO(forProperty("user")) : null;
    }

}

