package com.gvc.lavison.agent;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long>{

	Page<Agent> findAllByActiveTrue(Pageable page);

}
