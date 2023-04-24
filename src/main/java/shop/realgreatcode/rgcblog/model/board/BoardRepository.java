package shop.realgreatcode.rgcblog.model.board;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import shop.realgreatcode.rgcblog.model.board.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @EntityGraph(attributePaths = "user")
    Page<Board> findAll(Pageable pageable);
}