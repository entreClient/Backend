package com.upc.trabajo_final.Trabajo.Final.security.security;

import com.upc.trabajo_final.Trabajo.Final.security.model.Gestor;
import com.upc.trabajo_final.Trabajo.Final.security.repository.GestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private GestorRepository gestorRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Gestor gestor = gestorRepository.findOneByUsername(email)
                .orElseThrow(()->new UsernameNotFoundException(("El ususario con "+ email+"no existe")));

        return new UserDetailsImpl(gestor);
    }
}