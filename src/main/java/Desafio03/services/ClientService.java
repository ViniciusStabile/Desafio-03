package Desafio03.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
	public List<ClientDTO> findAll() {
		List<Client> list = repository.findAll();
		return list.stream().map(x -> new ClientDTO(x)).toList();
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(@PathVariable Long id) {
		Client client = repository.findById(id).get();
		return new ClientDTO(client);
	}

	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		CopyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		Client client = repository.getReferenceById(id);
		CopyDtoToEntity(dto, client);
		client = repository.save(client);
		return new ClientDTO(client);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	
	
	public void CopyDtoToEntity(ClientDTO dto, Client client) {
		client.setCpf(dto.getCpf());
		client.setName(dto.getName());
		client.setIncome(dto.getIncome());
		client.setBirthDate(dto.getBirthDate());
		client.setChildren(dto.getChildren());
	}
}
