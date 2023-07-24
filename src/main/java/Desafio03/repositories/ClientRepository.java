package Desafio03.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Desafio03.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
