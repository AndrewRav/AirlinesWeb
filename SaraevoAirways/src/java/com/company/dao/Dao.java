package com.company.dao;

import java.util.Set;

public interface Dao<Type> {
    int create(Type entity);
    Set<Type> read();
    int update(Type entity);
    int delete(Type entity);
}
