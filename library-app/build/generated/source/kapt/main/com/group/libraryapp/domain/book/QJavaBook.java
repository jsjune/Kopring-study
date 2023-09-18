package com.group.libraryapp.domain.book;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QJavaBook is a Querydsl query type for JavaBook
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QJavaBook extends EntityPathBase<JavaBook> {

    private static final long serialVersionUID = -1497777838L;

    public static final QJavaBook javaBook = new QJavaBook("javaBook");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QJavaBook(String variable) {
        super(JavaBook.class, forVariable(variable));
    }

    public QJavaBook(Path<? extends JavaBook> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJavaBook(PathMetadata metadata) {
        super(JavaBook.class, metadata);
    }

}

