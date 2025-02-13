package tn.esprit.interfaces;

import java.util.List;

public interface IService <T>{ //interface générique
    void add(T t);
    void update(T t);
    void delete(T t);
    List<T> getAll();
}
