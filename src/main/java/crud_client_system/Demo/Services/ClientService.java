package crud_client_system.Demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import crud_client_system.Demo.DTO.ClientDTO;
import crud_client_system.Demo.entities.Client;
import crud_client_system.Demo.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repository;
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable pageable){
		Page<Client> list = repository.findAll(pageable);
		return  list.map(x -> new ClientDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> result = repository.findById(id);
		Client client = result.get();
		ClientDTO dto = new ClientDTO(client);
		return dto;
	}
}
