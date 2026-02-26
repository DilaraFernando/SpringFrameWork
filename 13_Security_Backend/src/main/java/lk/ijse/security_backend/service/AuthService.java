package lk.ijse.security_backend.service;

import lk.ijse.security_backend.dto.AuthDTO;
import lk.ijse.security_backend.dto.AuthResponseDTO;
import lk.ijse.security_backend.dto.RegisterDTO;
import lk.ijse.security_backend.entity.Role;
import lk.ijse.security_backend.entity.User;
import lk.ijse.security_backend.repository.UserRepository;
import lk.ijse.security_backend.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private  final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResponseDTO authResponseDTO(AuthDTO authDTO){
      User user= userRepository.findByUsername(authDTO.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException(authDTO.getUsername()));
           if (!passwordEncoder.matches(authDTO.getPassword(),user.getPassword())){
               throw new BadCredentialsException(authDTO.getUsername());
           }

           String token=jwtUtil.generateToken(authDTO.getUsername());
           return  new AuthResponseDTO(token);
    }
    public String register(RegisterDTO registerDTO){
        if (userRepository.findByUsername(registerDTO.getUsername()).isPresent()){
            throw new RuntimeException("Username is already in use");
        }
        User user=User.builder()
                .username(registerDTO.getUsername())
                .password(passwordEncoder.encode(registerDTO.getPassword()))
                .role(Role.valueOf(registerDTO.getRole()))
                .build();
        userRepository.save(user);
        return "user register successfully..";
    }
}
