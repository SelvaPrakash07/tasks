package task.com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.com.example.demo.BaseResponse.ApiResponse;
import task.com.example.demo.BaseResponse.BaseResponse;
import task.com.example.demo.BaseResponse.PageResponse;
import task.com.example.demo.DTO.StaffDto;
import task.com.example.demo.DTO.StandardDto;
import task.com.example.demo.Model.Standard;
import task.com.example.demo.Service.ServiceImpl;


    @RequestMapping("/standard")
    @RestController
    public class StandardController {
        @Autowired
        private ServiceImpl serviceimpl;

        @PostMapping(value = "/save")
        public BaseResponse saveStaff(@RequestBody StandardDto standardDto) {
            return serviceimpl.savestandard(standardDto);
        }

        @GetMapping("/findall")
        public BaseResponse findAllstaff() {
            return serviceimpl.getAllstandard();
        }

        @GetMapping("/getbyid")
        public BaseResponse getById(@PathVariable int id) {
            return serviceimpl.getStandardById(id);
        }

        @PutMapping("/Update")
        public BaseResponse update(@RequestBody StandardDto standardDto) {
            return serviceimpl.updatestandard(standardDto);
        }

        @PutMapping("/IsActive")
        public BaseResponse Active(@RequestBody StandardDto standardDto) {
            return serviceimpl.IsActivestandard(standardDto);
        }

        @PutMapping("/IsDeleted")
        public BaseResponse Deleted(@RequestBody StandardDto standardDto) {
            return serviceimpl.IsDeletedstandard(standardDto);
        }

        @PostMapping(value = "/saveEverything")
        public BaseResponse saveall(@RequestBody StandardDto standardDto) {
            return serviceimpl.saveEverything(standardDto);
        }


        @GetMapping(value = "standard/name")
        public @ResponseBody
        PageResponse<Standard> getname(@RequestParam(defaultValue = "0") Integer pageNo,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       @RequestParam(defaultValue = "id") String sortBy,
                                       @RequestParam String name)
                throws Exception {
            return serviceimpl.getByname(pageNo, pageSize, sortBy,name);
        }


    }
