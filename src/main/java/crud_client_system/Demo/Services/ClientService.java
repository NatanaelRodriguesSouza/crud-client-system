package crud_client_system.Demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud_client_system.Demo.DTO.ClientDTO;
import crud_client_system.Demo.entities.Client;
import crud_client_system.Demo.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repository;
	public ClientDTO findById(Long id) {
		Optional<Client> result = repository.findById(id);
		Client client = result.get();
		ClientDTO dto = new ClientDTO(client);
		return dto;
	}
}
