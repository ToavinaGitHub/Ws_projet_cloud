package com.cloud.ws.Controller;

import com.cloud.ws.Model.Utilisateur;
import com.cloud.ws.Repository.UtilisateurRepository;
import com.cloud.ws.Auth.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@RestController
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private UtilisateurRepository utilisateurRepository;
    private JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UtilisateurRepository utilisateurRepository) {
        this.authenticationManager = authenticationManager;
        this.utilisateurRepository = utilisateurRepository;
        this.jwtUtil = jwtUtil;
    }

   @PostMapping("/auth/login")
    public String login(String email, String password)  {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
            String token = jwtUtil.createToken(utilisateur);
            return token;

        }catch (Exception e){
            return e.getMessage();
        }
    }

}
