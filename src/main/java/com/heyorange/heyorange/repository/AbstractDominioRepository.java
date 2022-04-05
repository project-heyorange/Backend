package com.heyorange.heyorange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heyorange.heyorange.entity.AbstractDominio;

@Repository
public interface AbstractDominioRepository extends JpaRepository <AbstractDominio,Long> {
	
}
