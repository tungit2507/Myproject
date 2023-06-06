package com.asm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asm.dto.userLogin;
import com.asm.model.users;
@Repository
public interface usersRepository extends JpaRepository<users, String>{
	@Query("select o FROM users o Where o.fullname LIKE %?1%")
	public List<users> 	selectLikeFullName(String fullname);
	public users findByUsernameAndPassword(String username, Object password);
	List<users> findByIsactive(Boolean isactive);
}
