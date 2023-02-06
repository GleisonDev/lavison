package com.gvc.lavison.agent;

public record ListAgentData(Long id, String name, String login, String email, String phone) {

	public ListAgentData(Agent agent) {
		this(agent.getId(), agent.getName(), agent.getLogin(), agent.getEmail(), agent.getPhone());
	}
}
