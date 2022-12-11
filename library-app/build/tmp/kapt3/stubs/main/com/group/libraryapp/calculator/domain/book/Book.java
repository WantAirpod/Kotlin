package com.group.libraryapp.calculator.domain.book;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/group/libraryapp/calculator/domain/book/Book;", "", "name", "", "id", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "()Ljava/lang/String;", "library-app"})
@javax.persistence.Entity
public final class Book {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = null;
    
    /**
     * val : null 불가능 이며 id는 한 번 생기면 불변이다.
     * Long : type 이며
     * ? : null이 가능하다.
     * = null : 초기화
     */
    @org.jetbrains.annotations.Nullable
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    private final java.lang.Long id = null;
    
    public Book(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.Long id) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    /**
     * val : null 불가능 이며 id는 한 번 생기면 불변이다.
     * Long : type 이며
     * ? : null이 가능하다.
     * = null : 초기화
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getId() {
        return null;
    }
}