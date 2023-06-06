package com.asm.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.constant.sessionAttribute;
import com.asm.dto.userLogin;
import com.asm.model.users;
import com.asm.repository.usersRepository;
import com.asm.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	usersRepository usersRepository;
	@Autowired 
	HttpSession httpSession;
	
	@Override
	public Boolean Login(userLogin userLogin) {
		users users =  usersRepository.findByUsernameAndPassword(userLogin.getUsername(), userLogin.getPassword());
		if(users == null) {
			return false;
		}else {
			httpSession.setAttribute(sessionAttribute.CURRENT_USER, users);
			return true;
		}
	}

	@Override
	public List<users> selectAll() {
		List<users> list = usersRepository.findByIsactive(true);
		return list;
	}

	@Override
	public users Create(users users) {
		usersRepository.save(users);
		return users;
	}

	@Override
	public users Update(users users) {
		usersRepository.save(users);
		return users;
	}

	@Override
	public users Remove(users users) {
		users.setIsactive(false);
		usersRepository.save(users);
		return users;
	}

	@Override
	public users selectById(String username) {
		Optional<users> request = usersRepository.findById(username);
		users users =  request.orElse(null);
		return users;
	}

	@Override
	public List<users> selectLikeFullName(String fullname) {
		// TODO Auto-generated method stub
		return null;
	}

}
