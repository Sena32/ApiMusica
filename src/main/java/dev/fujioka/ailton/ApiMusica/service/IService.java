package dev.fujioka.ailton.ApiMusica.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {

    public List<T> findAll();
	public Optional<T> findById(Long id);
	public T save(T entity);
    public T delete(T entity);
	public void deleteById(Long id);
}
