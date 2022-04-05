package com.heyorange.heyorange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heyorange.heyorange.entity.HabilidadeItem;

@Repository
public interface HabilidadeItemRepository extends JpaRepository<HabilidadeItem,Long>{

}
