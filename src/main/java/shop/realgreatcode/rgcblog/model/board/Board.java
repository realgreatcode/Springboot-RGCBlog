package shop.realgreatcode.rgcblog.model.board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import shop.realgreatcode.rgcblog.model.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "board_tb")
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    private String title;

    @Lob // 4GB
    private String content;

    @Lob // 4GB
    private String thumbnail; // content에 등록된 사진중 하나를 선정해서 자동으로 만들기
    @JsonIgnore
    private LocalDateTime createdAt;
    @JsonIgnore
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}