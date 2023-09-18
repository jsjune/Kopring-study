package com.group.libraryapp.domain.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QJavaUser is a Querydsl query type for JavaUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QJavaUser extends EntityPathBase<JavaUser> {

    private static final long serialVersionUID = 1448449938L;

    public static final QJavaUser javaUser = new QJavaUser("javaUser");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<com.group.libraryapp.domain.user.loanhistory.JavaUserLoanHistory, com.group.libraryapp.domain.user.loanhistory.QJavaUserLoanHistory> userLoanHistories = this.<com.group.libraryapp.domain.user.loanhistory.JavaUserLoanHistory, com.group.libraryapp.domain.user.loanhistory.QJavaUserLoanHistory>createList("userLoanHistories", com.group.libraryapp.domain.user.loanhistory.JavaUserLoanHistory.class, com.group.libraryapp.domain.user.loanhistory.QJavaUserLoanHistory.class, PathInits.DIRECT2);

    public QJavaUser(String variable) {
        super(JavaUser.class, forVariable(variable));
    }

    public QJavaUser(Path<? extends JavaUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJavaUser(PathMetadata metadata) {
        super(JavaUser.class, metadata);
    }

}

