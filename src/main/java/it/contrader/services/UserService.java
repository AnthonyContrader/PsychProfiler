package it.contrader.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterUser;
import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

@Service
public class UserService extends AbstractService<User, UserDTO> {

	@Autowired
	private ConverterUser converter;
	@Autowired
	private UserRepository repository;

	public UserDTO findByUsernameAndPassword(String username, String password) {
		return converter.toDTO(repository.findByUsernameAndPassword(username, password));
	}


}
