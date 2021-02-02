package com.estiasi.service;

import com.estiasi.repositories.ReadOnlyRepository;

public abstract class ReadOnlyBaseService<TE, T> {

    private final ReadOnlyRepository<TE, T> repository;

    ReadOnlyBaseService(ReadOnlyRepository<TE, T> repository) {
        this.repository = repository;
    }

    public boolean contains(T id) {
        return repository.contains(id);
    }

    public TE get(T id) throws Exception {
        return repository.get(id);
    }

    public Iterable<TE> getAll() {
        return repository.getAll();
    }

}
