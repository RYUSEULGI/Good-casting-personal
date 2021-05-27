package shop.ryuseulgi.goodCasting.user.producer.domain;

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

    private static final long serialVersionUID = 1291125198L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProducer producer = new QProducer("producer");

    public final StringPath agency = createString("agency");

    public final StringPath email = createString("email");

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final StringPath position = createString("position");

    public final NumberPath<Long> producerId = createNumber("producerId", Long.class);

    public final shop.ryuseulgi.goodCasting.user.login.domain.QUserVO userVO;

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
        this.userVO = inits.isInitialized("userVO") ? new shop.ryuseulgi.goodCasting.user.login.domain.QUserVO(forProperty("userVO")) : null;
    }

}

