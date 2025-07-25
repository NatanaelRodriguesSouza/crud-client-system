package crud_client_system.Demo.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crud_client_system.Demo.DTO.ClientDTO;
import crud_client_system.Demo.Services.ClientService;
import crud_client_system.Demo.entities.Client;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
	@Autowired
	private ClientService service;
	@GetMapping
	public ResponseEntity<Page<ClientDTO>> findAll(Pageable pegeable){
		Page<ClientDTO> dto = service.findAll(pegeable);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable long id){
		ClientDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
}
