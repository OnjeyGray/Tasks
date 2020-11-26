package com.epam.newsportal.service;

import com.epam.newsportal.model.AbstractEntity;
import com.epam.newsportal.repository.AbstractRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<Entity extends AbstractEntity, Id, Repository extends AbstractRepository<Entity, Id>> {

    @Inject
    protected Repository repository;

    public List<Entity> findAll() {
        return repository.findAll();
    }

    public Optional<Entity> find(Id id) {
        return repository.find(id);
    }

    public Entity save(Entity entity) {
        return repository.save(entity);
    }

    public void delete(Id id) {
        repository.delete(id);
    }
}
