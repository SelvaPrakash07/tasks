package task.com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.com.example.demo.BaseResponse.BaseResponse;
import task.com.example.demo.DTO.SectionDto;
import task.com.example.demo.DTO.StaffDto;
import task.com.example.demo.DTO.StandardDto;
import task.com.example.demo.DTO.SubjectNdStaffDto;
import task.com.example.demo.Service.ServiceImpl;


    @RequestMapping("/staff")
    @RestController
    public class StaffController {
        @Autowired
        private ServiceImpl serviceimpl;

        @PostMapping(value = "/save")
        public BaseResponse saveStaff(@RequestBody StaffDto staffDto) {
            return serviceimpl.savestaff(staffDto);
        }
        @GetMapping("/findall")
        public BaseResponse findAllstaff() {
            return serviceimpl.getAllStaff();
        }

        @GetMapping("/getbyid")
        public BaseResponse getById(@PathVariable int id) {
            return serviceimpl.getStaffById(id);
        }
        @PutMapping("/Update")
        public BaseResponse update(@RequestBody StaffDto staffDto) {
            return serviceimpl.updatestaff(staffDto);
        }

        @PutMapping("/IsActive")
        public BaseResponse Active(@RequestBody StaffDto staffDto) {
            return serviceimpl.IsActiveStaff(staffDto);
        }
        @PutMapping("/IsDeleted")
        public BaseResponse Deleted(@RequestBody StaffDto staffDto) {
            return serviceimpl.IsDeletedStaff(staffDto);
        }


    }


