package task.com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.com.example.demo.BaseResponse.BaseResponse;
import task.com.example.demo.DTO.SectionDto;
import task.com.example.demo.DTO.StaffDto;
import task.com.example.demo.Model.Section;
import task.com.example.demo.Model.Staff;
import task.com.example.demo.Serviceinterface.SectionInterface;
import task.com.example.demo.Serviceinterface.Service;
import task.com.example.demo.Serviceinterface.StaffInterface;

import java.util.List;
import java.util.Optional;


@RequestMapping("/staff")
    @RestController
    public class StaffController {
    @Autowired
    private StaffInterface staffInterface;

    @PostMapping(value = "/save")
    public BaseResponse saveStaff(@RequestBody StaffDto staffDto){
        BaseResponse<Staff>  staffBaseResponse =null;
        staffBaseResponse=BaseResponse.<Staff>builder().Data(staffInterface.savestaff(staffDto)).build() ;
        return staffBaseResponse;
    }

    @GetMapping("/findall")
    public BaseResponse findAllstaff() {
        BaseResponse<List<Staff>>  staffBaseResponse=null;
        staffBaseResponse = BaseResponse.<List<Staff>>builder().Data(staffInterface.getAllstaff()).build();
        return staffBaseResponse;
    }

    @PutMapping("/update")
    public BaseResponse updateById(@RequestBody StaffDto staffDto){
        BaseResponse<Optional<Staff>>  staffBaseResponse=null;
        staffBaseResponse = BaseResponse.<Optional<Staff>>builder().Data(staffInterface.UpdatestaffById(staffDto)).build();
        return staffBaseResponse;
    }

    @PutMapping("/isdeleted")
    public BaseResponse Deleted(@RequestBody  StaffDto staffDto) {
        BaseResponse<Optional<Staff>>  staffBaseResponse=null;
        staffBaseResponse=BaseResponse.<Optional<Staff>>builder().Data(staffInterface.IsDeletedstaff(staffDto)).build();
        return staffBaseResponse;
    }




    }


