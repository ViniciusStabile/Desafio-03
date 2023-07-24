package Desafio03.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import Desafio03.DTO.ClientDTO;
import Desafio03.entities.Client;
import Desafio03.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	
	@Transactional(readOnly = true)
	public ClientDTO findById(@PathVariable Long id) {
		Client client = repository.findById(id).get();
		return new ClientDTO(client);
	}
	
	
}
