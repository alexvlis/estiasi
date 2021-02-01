package com.estiasi.service;

import com.estiasi.repositories.Repository;

public abstract class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {

    private final Repository<TE, T> repository;

    public BaseService(Repository<TE, T> repository) {
        super(repository);
        this.repository = repository;
    }

    public void remove(T id) {
        repository.remove(id);
    }

    public void update(TE entity) {
        repository.update(entity);
    }

    public TE add(TE entity) throws Exception {
        repository.add(entity);
        return entity;
    }

}
