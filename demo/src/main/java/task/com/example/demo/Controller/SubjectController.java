package task.com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.com.example.demo.BaseResponse.BaseResponse;
import task.com.example.demo.DTO.StandardDto;
import task.com.example.demo.DTO.SubjectDto;
import task.com.example.demo.Service.ServiceImpl;


@RequestMapping("/subject")
@RestController
public class SubjectController {
    @Autowired
    private ServiceImpl serviceimpl;

    @PostMapping(value = "/save")
    public BaseResponse saveStaff(@RequestBody SubjectDto subjectDto) {
        return serviceimpl.savesubject(subjectDto);
    }

    @GetMapping("/findall")
    public BaseResponse findAllstaff() {
        return serviceimpl.getAllsubject();
    }

    @GetMapping("/getbyid")
    public BaseResponse getById(@PathVariable int id) {
        return serviceimpl.getsubjectById(id);
    }

    @PutMapping("/Update")
    public BaseResponse update(@RequestBody SubjectDto subjectDto) {
        return serviceimpl.updatesubject(subjectDto);
    }

    @PutMapping("/IsActive")
    public BaseResponse Active(@RequestBody SubjectDto subjectDto) {
        return serviceimpl.IsActivesubject(subjectDto);
    }

    @PutMapping("/IsDeleted")
    public BaseResponse Deleted(@RequestBody SubjectDto subjectDto) {
        return serviceimpl.IsDeletedsubject(subjectDto);

    }
}