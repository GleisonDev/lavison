package com.gvc.lavison.agent;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "agents")
@Entity(name = "Agent")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agent {

	public Agent(CreateAgentData data) {
		this.name = data.name();
		this.login = data.login();
		this.password = data.password();
		this.phone = data.phone();
		this.email = data.email();
		this.acess = data.acess();
		this.active = true;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String login;
	private String password;
	private String phone;
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Acess acess;
	private Boolean active;

	public void update(@Valid UpdateAgentData data) {
		if (data.password() != null) {
			this.password = data.password();
		}
		if (data.phone() != null) {
			this.phone = data.phone();
		}
		if (data.acess() != null) {
			this.acess = data.acess();
		}
		
	}

	public void delete() {
		this.active = false;
		
	}
}
