package util.lab.configs.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import util.lab.domain.model.Usuario;
import util.lab.infrastructure.repositories.UsuarioRespository;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter{

	private TokenService tokenService;
	
	private UsuarioRespository usuarioRepository;
	
	public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioRespository usuarioRepository) {
		this.tokenService = tokenService;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		
		boolean valido = tokenService.tokenValido(token);
		if(valido) {
			autenticarUsuario(token);
		}
		
		filterChain.doFilter(request, response);
		
	}

	private void autenticarUsuario(String token) {
		Long id = tokenService.getIdUsuario(token);
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		UsernamePasswordAuthenticationToken authentication = 
				new UsernamePasswordAuthenticationToken(usuario.get(), null, usuario.get().getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(null == token || token.isEmpty() || !token.startsWith("Bearer ") ) {
			return null;
		}
		return token.substring(7, token.length());
	}

}
