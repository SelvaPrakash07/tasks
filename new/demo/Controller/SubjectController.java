package task.com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.com.example.demo.Response.BaseResponse;
import task.com.example.demo.DTO.StaffDto;
import task.com.example.demo.DTO.SubjectDto;
import task.com.example.demo.Model.Subject;
import task.com.example.demo.Serviceinterface.SubjectInterface;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;


@RequestMapping("/subject")
@RestController
public class SubjectController {
    @Autowired
    private SubjectInterface subjectInterface;

    @RolesAllowed(value="ADMIN")
    @PostMapping(value = "/save")
    public BaseResponse saveSubject(@RequestBody SubjectDto subjectDto, StaffDto staffDto) {
        BaseResponse<Subject>  subjectBaseResponse =null;
        subjectBaseResponse=BaseResponse.<Subject>builder().Data(subjectInterface.savesubject(subjectDto,staffDto)).build() ;
            return subjectBaseResponse;
        }

    @RolesAllowed(value="USER")
    @GetMapping("/findall")
    public BaseResponse findAllstaff() {
        BaseResponse<List<Subject>>  subjectBaseResponse =null;
        subjectBaseResponse = BaseResponse.<List<Subject>>builder().Data(subjectInterface.getAllsubject()).build();
        return subjectBaseResponse;
    }

    @RolesAllowed(value="ADMIN")
    @PutMapping("/update")
    public BaseResponse update(@RequestBody SubjectDto subjectDto) {
        BaseResponse<Optional<Subject>>  subjectBaseResponse=null;
        subjectBaseResponse = BaseResponse.<Optional<Subject>>builder().Data(subjectInterface.UpdatesubjectById(subjectDto)).build();
        return subjectBaseResponse;
    }
    @RolesAllowed(value="ADMIN")
    @PutMapping("/isdeleted")
    public BaseResponse Deleted(@RequestBody SubjectDto subjectDto) {
        BaseResponse<Optional<Subject>>  subjectBaseResponse=null;
        subjectBaseResponse =BaseResponse.<Optional<Subject>>builder().Data(subjectInterface.IsDeletedsubject(subjectDto)).build();
        return subjectBaseResponse;
    }
}