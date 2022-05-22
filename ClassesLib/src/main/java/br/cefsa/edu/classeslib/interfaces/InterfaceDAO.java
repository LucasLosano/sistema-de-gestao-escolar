package br.cefsa.edu.classeslib.interfaces;

import java.io.Serializable;
import java.util.List;

public interface InterfaceDAO<T> extends Serializable{

    public List<T> GetAll();

    public T GetById(int id);

    public void Delete(int id);

    public void Update(T entity);
    
    public void Insert(T entity);
}
