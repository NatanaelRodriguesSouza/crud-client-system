package crud_client_system.Demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud_client_system.Demo.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repository;
	
	public String test() {
		return "rodou";
	}
}
