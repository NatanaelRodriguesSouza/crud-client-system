package crud_client_system.Demo.DTO;

import java.util.Date;

import crud_client_system.Demo.entities.Client;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ClientDTO {

	private long id;
	private String name;
	private String cpf;
	private Double income;
	private Date birthDate;
	private Integer children;
	public ClientDTO() {}
	public ClientDTO(long id, String name, String cpf, Double income, Date birthDate, Integer children) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}
	public ClientDTO(Client entity) {
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
		income = entity.getIncome();
		birthDate = entity.getBirthDate();
		children = entity.getChildren();
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCpf() {
		return cpf;
	}
	public Double getIncome() {
		return income;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public Integer getChildren() {
		return children;
	}
	
}
