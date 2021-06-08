package shop.goodcasting.api.article.hire.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHire is a Querydsl query type for Hire
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHire extends EntityPathBase<Hire> {

    private static final long serialVersionUID = 98743632L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHire hire = new QHire("hire");

    public final shop.goodcasting.api.common.domain.QBaseEntity _super = new shop.goodcasting.api.common.domain.QBaseEntity(this);

    public final StringPath cast = createString("cast");

    public final StringPath contents = createString("contents");

    public final DateTimePath<java.time.LocalDateTime> deadline = createDateTime("deadline", java.time.LocalDateTime.class);

    public final DatePath<java.time.LocalDate> filming = createDate("filming", java.time.LocalDate.class);

    public final NumberPath<Integer> guarantee = createNumber("guarantee", Integer.class);

    public final NumberPath<Long> hireId = createNumber("hireId", Long.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> modDate = _super.modDate;

    public final StringPath personnel = createString("personnel");

    public final shop.goodcasting.api.user.producer.domain.QProducer producer;

    public final StringPath project = createString("project");

    //inherited
    public final DateTimePath<java.sql.Timestamp> regDate = _super.regDate;

    public final StringPath title = createString("title");

    public QHire(String variable) {
        this(Hire.class, forVariable(variable), INITS);
    }

    public QHire(Path<? extends Hire> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHire(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHire(PathMetadata metadata, PathInits inits) {
        this(Hire.class, metadata, inits);
    }

    public QHire(Class<? extends Hire> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.producer = inits.isInitialized("producer") ? new shop.goodcasting.api.user.producer.domain.QProducer(forProperty("producer"), inits.get("producer")) : null;
    }

}

