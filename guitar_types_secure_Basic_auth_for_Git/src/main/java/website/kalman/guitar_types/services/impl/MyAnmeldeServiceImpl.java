package website.kalman.guitar_types.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import website.kalman.guitar_types.dto.AnmeldungDto;
import website.kalman.guitar_types.entity.User;
import website.kalman.guitar_types.exception.HttpStatusDetailsException;
import website.kalman.guitar_types.repository.RoleRepository;
import website.kalman.guitar_types.repository.UserRepository;
import website.kalman.guitar_types.services.MyAnmeldeService;
import website.kalman.guitar_types.entity.Role;

import java.net.Authenticator;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class MyAnmeldeServiceImpl implements MyAnmeldeService {

    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    @Override
    public String einloggen(AnmeldungDto anmeldungDto) {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        anmeldungDto.getUsername(),
                        anmeldungDto.getPassword()
                );

        Authentication authentication =
                authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "User " + anmeldungDto.getUsername() + " wurde eingeloggt";
    }

    @Override
    public String anmelden(AnmeldungDto anmeldungDto) {

        String encodedPassword = passwordEncoder.encode(anmeldungDto.getPassword());

        Role role = roleRepository.findById(1l).orElseThrow(() ->
                new HttpStatusDetailsException("Role 1 does not exist", HttpStatus.BAD_REQUEST)
        );

        if(userRepository.existsByUsername(anmeldungDto.getUsername())) {
            throw new HttpStatusDetailsException("Username "+anmeldungDto.getUsername() +" existiert schon", HttpStatus.BAD_REQUEST);
        }

        User newUser = new User();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        newUser.setRolesSet(roleSet);
        newUser.setName(anmeldungDto.getName());
        newUser.setUsername(anmeldungDto.getUsername());
        newUser.setPassword(encodedPassword);
        newUser.setEmailAccount(anmeldungDto.getEmailAccount());

        userRepository.save(newUser);

        return "Anmeldung ist OK fuer " + anmeldungDto.getName();
    }
}
