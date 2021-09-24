package task.com.example.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.com.example.demo.Model.Standard;




@Repository
public interface StandardRepo extends JpaRepository<Standard,Integer> {

    Page<Standard> searchAllByNameLike(String s, Pageable paging);
}
