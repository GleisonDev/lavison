package com.gvc.lavison.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long>{

	Page<Section> findAllByActiveTrue(Pageable page);

}
