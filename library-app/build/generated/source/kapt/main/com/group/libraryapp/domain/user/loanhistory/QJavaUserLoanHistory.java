package com.group.libraryapp.domain.user.loanhistory;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QJavaUserLoanHistory is a Querydsl query type for JavaUserLoanHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QJavaUserLoanHistory extends EntityPathBase<JavaUserLoanHistory> {

    private static final long serialVersionUID = -1602001208L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QJavaUserLoanHistory javaUserLoanHistory = new QJavaUserLoanHistory("javaUserLoanHistory");

    public final StringPath bookName = createString("bookName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isReturn = createBoolean("isReturn");

    public final com.group.libraryapp.domain.user.QJavaUser user;

    public QJavaUserLoanHistory(String variable) {
        this(JavaUserLoanHistory.class, forVariable(variable), INITS);
    }

    public QJavaUserLoanHistory(Path<? extends JavaUserLoanHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QJavaUserLoanHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QJavaUserLoanHistory(PathMetadata metadata, PathInits inits) {
        this(JavaUserLoanHistory.class, metadata, inits);
    }

    public QJavaUserLoanHistory(Class<? extends JavaUserLoanHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.group.libraryapp.domain.user.QJavaUser(forProperty("user")) : null;
    }

}

