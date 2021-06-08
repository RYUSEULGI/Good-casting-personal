package shop.goodcasting.api.user.login.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserVO is a Querydsl query type for UserVO
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserVO extends EntityPathBase<UserVO> {

    private static final long serialVersionUID = 1708121402L;

    public static final QUserVO userVO = new QUserVO("userVO");

    public final shop.goodcasting.api.common.domain.QBaseEntity _super = new shop.goodcasting.api.common.domain.QBaseEntity(this);

    public final BooleanPath account = createBoolean("account");

    //inherited
    public final DateTimePath<java.sql.Timestamp> modDate = _super.modDate;

    public final StringPath password = createString("password");

    public final BooleanPath position = createBoolean("position");

    //inherited
    public final DateTimePath<java.sql.Timestamp> regDate = _super.regDate;

    public final ListPath<Role, EnumPath<Role>> roles = this.<Role, EnumPath<Role>>createList("roles", Role.class, EnumPath.class, PathInits.DIRECT2);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final StringPath username = createString("username");

    public QUserVO(String variable) {
        super(UserVO.class, forVariable(variable));
    }

    public QUserVO(Path<? extends UserVO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserVO(PathMetadata metadata) {
        super(UserVO.class, metadata);
    }

}

