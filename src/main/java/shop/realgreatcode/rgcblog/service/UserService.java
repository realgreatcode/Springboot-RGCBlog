package shop.realgreatcode.rgcblog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import shop.realgreatcode.rgcblog.dto.user.UserRequest;
import shop.realgreatcode.rgcblog.model.user.UserRepository;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder; // SecurityConfig Bean 등록함

    // insert, update, delete -> try catch 처리
    @Transactional
    public void 회원가입(UserRequest.JoinInDTO joinInDTO){
        try {
            // 1. 패스워드 암호화
            joinInDTO.setPassword(passwordEncoder.encode(joinInDTO.getPassword()));
            // 2. DB 저장
            userRepository.save(joinInDTO.toEntity());
        }catch (Exception e){
            throw new RuntimeException("회원가입 오류 : "+e.getMessage());
        }
    } // 더티채킹, DB세션종료
}
