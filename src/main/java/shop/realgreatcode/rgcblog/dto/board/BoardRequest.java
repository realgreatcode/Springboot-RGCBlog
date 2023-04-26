package shop.realgreatcode.rgcblog.dto.board;

import lombok.Getter;
import lombok.Setter;
import shop.realgreatcode.rgcblog.model.board.Board;
import shop.realgreatcode.rgcblog.model.user.User;

public class BoardRequest {

    @Getter @Setter
    public static class SaveInDTO {
        private String title;
        private String content;

        public Board toEntity(User user, String thumbnail){
            return Board.builder()
                    .user(user)
                    .title(title)
                    .content(content)
                    .thumbnail(thumbnail)
                    .build();
        }
    }
}
