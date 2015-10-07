package com.example.persistence.jpa.dao;

import javax.transaction.Transactional;

import com.example.persistence.jpa.entity.ActorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ActorDao extends CrudRepository<ActorEntity, Integer> {

    // http://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    public Iterable<ActorEntity> findByLastNameContaining(String lastName);
}
