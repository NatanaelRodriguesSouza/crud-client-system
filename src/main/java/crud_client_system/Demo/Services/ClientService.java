package crud_client_system.Demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import crud_client_system.Demo.DTO.ClientDTO;
import crud_client_system.Demo.Services.exceptions.ResourceNotFoundException;
import crud_client_system.Demo.entities.Client;
import crud_client_system.Demo.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;

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
		Client client = result.orElseThrow(()-> new ResourceNotFoundException("Cliente não encontrado"));
		ClientDTO dto = new ClientDTO(client);
		return dto;
	}
	@Transactional(readOnly = true)
	public ClientDTO insert(ClientDTO dto) {
		Client client = new Client();
		copyDtoToEntity(dto, client);
		return new ClientDTO(client);
	}
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
		Client client = repository.getReferenceById(id);
		copyDtoToEntity(dto, client);
		client = repository.save(client);
		return new ClientDTO(client);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Cliente não encontrado");
		}
	}
	private void copyDtoToEntity(ClientDTO dto, Client client) {
		client.setBirthDate(dto.getBirthDate());
		client.setChildren(dto.getChildren());
		client.setCpf(dto.getCpf());
		client.setIncome(dto.getIncome());
		client.setName(dto.getName());
		client = repository.save(client);
	}
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if(!repository.existsById(id)) {
			throw new ResourceNotFoundException("Cliente não encontrado");
		}
		repository.deleteById(id);
	}
}
