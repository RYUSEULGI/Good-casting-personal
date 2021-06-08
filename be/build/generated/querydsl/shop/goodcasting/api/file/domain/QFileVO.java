package shop.goodcasting.api.file.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFileVO is a Querydsl query type for FileVO
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFileVO extends EntityPathBase<FileVO> {

    private static final long serialVersionUID = 1594202401L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFileVO fileVO = new QFileVO("fileVO");

    public final shop.goodcasting.api.common.domain.QBaseEntity _super = new shop.goodcasting.api.common.domain.QBaseEntity(this);

    public final NumberPath<Long> fileId = createNumber("fileId", Long.class);

    public final StringPath fileName = createString("fileName");

    public final BooleanPath first = createBoolean("first");

    public final shop.goodcasting.api.article.hire.domain.QHire hire;

    //inherited
    public final DateTimePath<java.sql.Timestamp> modDate = _super.modDate;

    public final BooleanPath photoType = createBoolean("photoType");

    public final shop.goodcasting.api.article.profile.domain.QProfile profile;

    //inherited
    public final DateTimePath<java.sql.Timestamp> regDate = _super.regDate;

    public final StringPath uuid = createString("uuid");

    public QFileVO(String variable) {
        this(FileVO.class, forVariable(variable), INITS);
    }

    public QFileVO(Path<? extends FileVO> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFileVO(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFileVO(PathMetadata metadata, PathInits inits) {
        this(FileVO.class, metadata, inits);
    }

    public QFileVO(Class<? extends FileVO> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hire = inits.isInitialized("hire") ? new shop.goodcasting.api.article.hire.domain.QHire(forProperty("hire"), inits.get("hire")) : null;
        this.profile = inits.isInitialized("profile") ? new shop.goodcasting.api.article.profile.domain.QProfile(forProperty("profile"), inits.get("profile")) : null;
    }

}

