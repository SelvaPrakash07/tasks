package task.com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.com.example.demo.Model.Section;
import task.com.example.demo.Model.Staff;

@Repository
public interface StaffRepo extends JpaRepository<Staff,Integer> {
}
