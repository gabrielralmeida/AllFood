package com.gabrira.AllFood.Speficication;

import java.util.Locale;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.gabrira.AllFood.Model.Usuario;

public class UsuarioSpecification {

	public static Specification<Usuario> porNome(String nome) {
		return (root, query, cb) -> {
			if (!StringUtils.hasText(nome)) {
				return cb.disjunction();
			}
			String pattern = "%" + nome.trim().toLowerCase(Locale.ROOT) + "%";
			var nomeCol = cb.lower(cb.coalesce(root.get("nome"), cb.literal("")));
			return cb.like(nomeCol, pattern);
		};
	}
}
