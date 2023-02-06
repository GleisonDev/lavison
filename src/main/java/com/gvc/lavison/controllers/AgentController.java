package com.gvc.lavison.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gvc.lavison.agent.Agent;
import com.gvc.lavison.agent.AgentRepository;
import com.gvc.lavison.agent.CreateAgentData;
import com.gvc.lavison.agent.ListAgentData;
import com.gvc.lavison.agent.UpdateAgentData;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/agent")
public class AgentController {

	@Autowired
	private AgentRepository repository;

	@PostMapping
	@Transactional
	public void registerAgent(@RequestBody @Valid CreateAgentData data) {

		repository.save(new Agent(data));
	}
	
	@GetMapping
	public Page<ListAgentData> listAgent(@PageableDefault(size = 10, sort = {"name"}) Pageable page){
		
		return repository.findAllByActiveTrue(page).map(ListAgentData::new);
	}

	@PutMapping
	@Transactional
	public void updateAgent(@RequestBody @Valid UpdateAgentData data) {
		Agent agent = repository.getReferenceById(data.id());
		
		agent.update(data);
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void deleteAgent(@PathVariable Long id) {
		Agent agent = repository.getReferenceById(id);
		agent.delete();
		
	}
}
