package com.heyorange.heyorange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heyorange.heyorange.entity.AbstractEntity;

@Repository
public interface AbstractEntityRepository extends JpaRepository <AbstractEntity,Long> {

}
