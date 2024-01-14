package com.cloud.ws.Security;

import com.cloud.ws.Model.Utilisateur;
import com.cloud.ws.Repository.UtilisateurRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService  implements UserDetailsService {
    private final UtilisateurRepository utilisateurRepository;

    public CustomUserDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(username);
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(utilisateur.getEmail())
                        .password(utilisateur.getPassword())
                        .roles(roles.toArray(new String[0]))
                        .build();
        return userDetails;
    }
}
