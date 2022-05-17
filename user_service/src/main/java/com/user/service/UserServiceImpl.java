package com.user.service;

import java.util.List;



import org.springframework.stereotype.Service;

import com.user.entity.User;

@Service
public class UserServiceImpl implements UserService{

	List<User> list=List.of(
			new User(133L,"Amit","Goel"),
			new User(136L,"Sumit","Goel")
			);
			
	
	@Override
	public User getUser(Long userId) {
		// TODO Auto-generated method stub
		return this.list.stream().filter(user->user.getUserId()
				.equals(userId)).findAny().orElse(null);
	}

}
