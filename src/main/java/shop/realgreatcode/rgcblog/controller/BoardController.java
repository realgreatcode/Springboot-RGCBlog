package shop.realgreatcode.rgcblog.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import shop.realgreatcode.rgcblog.core.auth.MyUserDetails;
import shop.realgreatcode.rgcblog.dto.board.BoardRequest;
import shop.realgreatcode.rgcblog.service.BoardService;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    // RestAPI 주소 설계 규칙에서 자원에는 복수를 붙인다. boards 정석!
    @GetMapping({"/", "/board"})
    public String main(){
        return "board/main";
    }

    @GetMapping("/s/board/saveForm")
    public String saveForm(){
        return "board";
    }

    @PostMapping("/s/board/save")
    public String save(
            @Valid BoardRequest.SaveInDTO saveInDTO,
            Errors errors,
            @AuthenticationPrincipal MyUserDetails myUserDetails
    ) {
        boardService.글쓰기(saveInDTO, myUserDetails.getUser().getId());

        return "redirect:/";
    }

}
