package com.example.todo.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private Long id;
	private String name;
	
	@NotBlank
	private String email;
	@Size(min=6,max=10,message="Password must be min of 6 chars and max of 10 chars!!!")
	private String password;
	private String confirmpassword;
	
	
}
