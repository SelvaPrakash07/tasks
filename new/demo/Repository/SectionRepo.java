package task.com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.com.example.demo.Model.Section;

@Repository
public interface SectionRepo extends JpaRepository<Section,Integer> {
}
