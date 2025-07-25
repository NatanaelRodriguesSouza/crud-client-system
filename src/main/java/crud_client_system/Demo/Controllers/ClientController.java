package crud_client_system.Demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crud_client_system.Demo.Services.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
	@Autowired
	private ClientService service;
	
	@GetMapping
	public String test() {
		String st = service.test();
		return st;
	}
}
