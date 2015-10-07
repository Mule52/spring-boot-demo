package com.example.persistence.jpa.dao;

import com.example.persistence.jpa.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CustomerDao extends CrudRepository<CustomerEntity, Short> {
}