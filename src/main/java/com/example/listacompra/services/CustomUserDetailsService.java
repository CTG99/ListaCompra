package com.example.listacompra.services;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.listacompra.dto.UsuarioDTO;
import com.example.listacompra.repositories.UserRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UsuarioDTO customer = userRepository.findbyUsername(username);
        if (customer == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User.withUsername(customer.getUsername()).password(customer.getPassword()).authorities("USER").build();
        return user;
    }

}