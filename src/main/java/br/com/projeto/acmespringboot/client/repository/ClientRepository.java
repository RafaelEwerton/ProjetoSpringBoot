package br.com.projeto.acmespringboot.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.acmespringboot.client.domain.Client;

/**
 * 
 * @author Rafael Ewerton
 *
 */

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	

}
