package com.gabrira.AllFood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gabrira.AllFood.Model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {
	Usuario findByEmail(String email);
	Usuario findByUserlogin(String userlogin);
}
