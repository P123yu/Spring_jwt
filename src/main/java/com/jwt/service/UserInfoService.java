package com.jwt.service;



import com.jwt.model.UserModel;
import com.jwt.repository.UserRepository;
import lombok.AllArgsConstructor;
        import org.springframework.security.core.GrantedAuthority;
        import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.core.userdetails.UsernameNotFoundException;
        import org.springframework.stereotype.Service;

        import java.util.Set;
        import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserInfoService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        UserModel user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElse(null);
            //    .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new User(
                usernameOrEmail,
                user.getPassword(),
                authorities
        );
    }
}
