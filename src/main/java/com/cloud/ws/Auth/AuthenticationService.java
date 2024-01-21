package com.cloud.ws.Auth;


import com.cloud.ws.Model.Role;
import com.cloud.ws.Model.Utilisateur;
import com.cloud.ws.Repository.UtilisateurRepository;
import com.cloud.ws.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        Utilisateur u = new Utilisateur();
        u.setNomUtilisateur(request.getNomUtilisateur());
        u.setPrenomUtilisateur(request.getPrenomUtilisateur());
        u.setAdresse(request.getAdresse());
        u.setDateNaissance(request.getDateNaissance());
        u.setEmail(request.getEmail());
        u.setPassword(passwordEncoder.encode(request.getPassword()));
        u.setTel(request.getTel());
        u.setSexe(request.getSexe());
        u.setIsAdmin(request.getIsAdmin());
        u.setRole(Role.USER);

        utilisateurRepository.save(u);
        var jwtToken = jwtService.generateToken(u);



        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        Utilisateur u = utilisateurRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(u);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();}
}
