package com.nutritionapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nutritionapp.model.Usuario;
import com.nutritionapp.repo.IUsuarioRepo;
import com.nutritionapp.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService,UserDetailsService{

	@Autowired
	private IUsuarioRepo repo;
	 
	@Override
	public Usuario registrar(Usuario obj) {
		return repo.save(obj);
	}

	@Override
	public Usuario modificar(Usuario obj) {
		return repo.save(obj);
	}

	@Override
	public List<Usuario> listar() {
		return repo.findAll();
	}

	@Override
	public Usuario leerPorId(Integer id) {
		 Optional<Usuario> op = repo.findById(id);
		 return op.isPresent() ? op.get() : new Usuario();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = repo.findOneByUsername(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException(String.format("usuario no existe", username));
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		
		usuario.getRoles().forEach(rol -> {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		});
		
		UserDetails ud = new User(usuario.getUsername(), usuario.getPassword(), roles);
		return ud;
	}

}
