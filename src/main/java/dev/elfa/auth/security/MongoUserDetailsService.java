package dev.elfa.auth.security;

import dev.elfa.auth.dto.MongoUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MongoUserDetailsService implements UserDetailsService {

	private final MongoUserRepository userRepository;
	private final Argon2PasswordEncoder passwordEncoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MongoUser user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User: " + username + " not found!"));

		// GrantedAuthority is used for giving roles to the user
		return new User(user.username(), user.password(), Collections.emptyList());
	}

	public void register(MongoUserDTO newUser) {
		MongoUser user = MongoUser.builder()
				.id(UUID.randomUUID().toString())
				.username(newUser.username())
				.password(passwordEncoder.encode(newUser.password()))
				.build();

		userRepository.save(user);
	}
}
