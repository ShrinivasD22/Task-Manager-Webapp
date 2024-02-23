package com.example.todo.service.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.entity.User;
import com.example.todo.payload.UserDto;
import com.example.todo.repository.UserRepo;
import com.example.todo.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
private UserRepo userRepo; 
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User userEntity = this.dtoToUser(userDto); 
		this.userRepo.save(userEntity); 
		User savedUser = this.userRepo.save(userEntity);
		return this.userToDto(savedUser);
	}  
	
	
	private User dtoToUser(UserDto userDto) {
		User user= this.modelMapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		return user;
	}  
	
	
	
	public UserDto userToDto(User user) {
	    UserDto userDto = this.modelMapper.map(user, UserDto.class);
//	    userDto.setId(user.getId());
//	    userDto.setName(user.getName());
//	    userDto.setEmail(user.getEmail());
//	    userDto.setAbout(user.getAbout());
//	    userDto.setPassword(user.getPassword());
	    return userDto;
	}
	

}
