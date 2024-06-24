package website.kalman.guitar_types.secure;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import website.kalman.guitar_types.entity.User;
import website.kalman.guitar_types.repository.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

// Don't use NoArgsConstructor here, otherwise userRepository will be nulll
@AllArgsConstructor
@Service
public class MyUserService implements UserDetailsService{

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameEmail) throws UsernameNotFoundException {


         User   user = userRepository.findByUsername(usernameEmail)
                    .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username"));

        Set<GrantedAuthority> authoritieSet = user.getRolesSet().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                usernameEmail,
                user.getPassword(),
                authoritieSet
        );
    }
}
