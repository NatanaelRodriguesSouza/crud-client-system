package crud_client_system.Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import crud_client_system.Demo.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
