package util.lab.configs.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import util.lab.domain.model.Usuario;
import util.lab.infrastructure.repositories.UsuarioRespository;

@Service
public class AutenticacaoService implements UserDetailsService{

	@Autowired
	private UsuarioRespository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository
				.findByLogin(username);
		if(usuario.isPresent()) {
			return usuario.get();
		}
		throw new UsernameNotFoundException("Dados Inválidos");
	}

}
