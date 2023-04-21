package shop.realgreatcode.rgcblog.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.realgreatcode.rgcblog.core.auth.MyUserDetails;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BoardController {

    // RestAPI 주소 설계 규칙에서 자원에는 복수를 붙인다. boards 정석!
    @GetMapping({"/", "/board"})
    public String main(){
        return "board/main";
    }

}
