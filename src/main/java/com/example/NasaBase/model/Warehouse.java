package com.example.NasaBase.model;

import java.util.List;

public interface Warehouse<T> {
    boolean add(T o);

    boolean remove(T o);

    List<T> getAll();
}
