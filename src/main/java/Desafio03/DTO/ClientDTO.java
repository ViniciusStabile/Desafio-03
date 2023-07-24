package Desafio03.DTO;

import java.time.LocalDate;

import Desafio03.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClientDTO {

	
	private Long id;
	@Size(min = 2)
	@NotBlank(message = "Invalid")
	private String name;
	@Size(min = 11, max = 11)
	@NotBlank(message = "Invalid")
	private String cpf;
	private Double income;
	private LocalDate birthDate;
	private Integer children;
	
	
	public ClientDTO(Client client) {
		id = client.getId();
		name = client.getName();
		cpf = client.getCpf();
		income = client.getIncome();
		birthDate = client.getBirthDate();
		children = client.getChildren();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Double getIncome() {
		return income;
	}


	public void setIncome(Double income) {
		this.income = income;
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}


	public Integer getChildren() {
		return children;
	}


	public void setChildren(Integer children) {
		this.children = children;
	}
	
	
	
	
}
