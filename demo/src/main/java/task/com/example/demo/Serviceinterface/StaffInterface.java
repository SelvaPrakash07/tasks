package task.com.example.demo.Serviceinterface;

import task.com.example.demo.DTO.StaffDto;
import task.com.example.demo.Model.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffInterface {
    Staff savestaff(StaffDto staffDto);

    List<Staff> getAllstaff();

    Optional<Staff> UpdatestaffById(StaffDto staffDto);

    Optional<Staff> IsDeletedstaff(StaffDto staffDto);
}
