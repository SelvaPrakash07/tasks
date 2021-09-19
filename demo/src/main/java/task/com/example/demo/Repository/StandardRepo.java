package task.com.example.demo.Repository;

import com.sun.xml.bind.api.impl.NameConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.com.example.demo.Model.Standard;




@Repository
public interface StandardRepo extends JpaRepository<Standard,Integer> {


    Page<Standard> searchAllnameByLike(String s, Pageable paging);
}
