package task.com.example.demo.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import task.com.example.demo.DTO.StaffDto;
import task.com.example.demo.Model.Section;
import task.com.example.demo.Model.Staff;
import task.com.example.demo.Repository.StaffRepo;
import task.com.example.demo.Serviceinterface.StaffInterface;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StaffService implements StaffInterface {

    @Autowired
    private StaffRepo staffRepo;

    @Override
    public Staff savestaff(StaffDto staffDto) {
        ModelMapper modelMapper = new ModelMapper();
        Staff staff = modelMapper.map(staffDto, Staff.class);
        staffRepo.save(staff);
        return null;
    }

    @Override
    public List<Staff> getAllstaff() {
        List<Staff> staffList=staffRepo.findAll();
        return staffList;

    }

    @Override
    public Optional<Staff> UpdatestaffById(StaffDto staffDto) {
        Optional<Staff> staff = staffRepo.findById(staffDto.getId());
        if (staff.isPresent())
        {staff.get().setStaffName(staffDto.getStaffName());
        }
        else
        {throw new RuntimeException("");
        }
        staffRepo.save(staff.get());
        return staff;
    }

    @Override
    public Optional<Staff> IsDeletedstaff(StaffDto staffDto) {
        Optional<Staff> staff = staffRepo.findById(staffDto.getId());
        if (staff.isPresent())
        {staff.get().setIsDeleted(1);
        }
        else
        {throw new RuntimeException(HttpStatus.NOT_FOUND.name());
        }
        staffRepo.save(staff.get());
        return staff;
    }
}
