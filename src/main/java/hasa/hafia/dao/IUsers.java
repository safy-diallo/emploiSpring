package hasa.hafia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hasa.hafia.entites.Candidat;
import hasa.hafia.entites.Users;

@Repository
public interface IUsers extends JpaRepository<Users, Integer>{
	/*@Query("SELECT u from Users u where u.email=:email AND u.password=:password")
	public Users getUserByEmailAndPassword(@Param("email")String email,@Param("password")String password);*/
	
	/*@Query("select u from Users c where u.email =:email")
    public Users getUserByEmail(@Param("email") String e);*/
}
