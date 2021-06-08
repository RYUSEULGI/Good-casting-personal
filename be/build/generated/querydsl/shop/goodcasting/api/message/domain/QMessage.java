package shop.goodcasting.api.message.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMessage is a Querydsl query type for Message
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMessage extends EntityPathBase<Message> {

    private static final long serialVersionUID = 676716504L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMessage message = new QMessage("message");

    public final shop.goodcasting.api.common.domain.QBaseEntity _super = new shop.goodcasting.api.common.domain.QBaseEntity(this);

    public final EnumPath<MessageActionType> messageActionType = createEnum("messageActionType", MessageActionType.class);

    public final NumberPath<Long> messageId = createNumber("messageId", Long.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> modDate = _super.modDate;

    public final BooleanPath readMessage = createBoolean("readMessage");

    public final shop.goodcasting.api.user.login.domain.QUserVO receiver;

    //inherited
    public final DateTimePath<java.sql.Timestamp> regDate = _super.regDate;

    public final shop.goodcasting.api.user.login.domain.QUserVO sender;

    public QMessage(String variable) {
        this(Message.class, forVariable(variable), INITS);
    }

    public QMessage(Path<? extends Message> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMessage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMessage(PathMetadata metadata, PathInits inits) {
        this(Message.class, metadata, inits);
    }

    public QMessage(Class<? extends Message> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.receiver = inits.isInitialized("receiver") ? new shop.goodcasting.api.user.login.domain.QUserVO(forProperty("receiver")) : null;
        this.sender = inits.isInitialized("sender") ? new shop.goodcasting.api.user.login.domain.QUserVO(forProperty("sender")) : null;
    }

}

