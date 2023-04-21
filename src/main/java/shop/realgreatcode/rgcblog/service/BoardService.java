package shop.realgreatcode.rgcblog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.realgreatcode.rgcblog.dto.board.BoardRequest;
import shop.realgreatcode.rgcblog.model.board.BoardRepository;
import shop.realgreatcode.rgcblog.model.user.User;
import shop.realgreatcode.rgcblog.model.user.UserRepository;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public void 글쓰기(BoardRequest.SaveInDTO saveInDTO, Long userId){
        try {
            // 1. 유저 존재 확인
            User userPS = userRepository.findById(userId).orElseThrow(
                    ()-> new RuntimeException("유저를 찾을 수 없습니다")
            );

            // 2. 게시글 쓰기
            boardRepository.save(saveInDTO.toEntity(userPS));
        }catch (Exception e){
            throw new RuntimeException("글쓰기 실패 : "+e.getMessage());
        }
    }

}
