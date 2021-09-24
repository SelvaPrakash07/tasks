package task.com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.com.example.demo.Response.BaseResponse;
import task.com.example.demo.DTO.MediumDto;
import task.com.example.demo.Model.Medium;
import task.com.example.demo.Serviceinterface.MediumInterface;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RequestMapping("/medium")
@RestController
public class MediumController {
@Autowired
    private MediumInterface mediumInterface;

    @RolesAllowed(value="ADMIN")
    @PostMapping(value = "/save")
    public BaseResponse saveMedium(@RequestBody MediumDto mediumDto) {
        BaseResponse<Medium>  mediumBaseResponse =null;
        mediumBaseResponse=BaseResponse.<Medium>builder().Data(mediumInterface.savemedium(mediumDto)).build() ;
        return mediumBaseResponse;
    }
    @RolesAllowed(value="USER")
    @GetMapping("/findall")
    public BaseResponse mediumlist(){
        BaseResponse<List<Medium>>  mediumBaseResponse=null;
        mediumBaseResponse = BaseResponse.<List<Medium>>builder().Data(mediumInterface.getAllMedium()).build();
        return mediumBaseResponse;
    }

    @RolesAllowed(value="ADMIN")
    @PutMapping("/update")
    public BaseResponse updateById(@RequestBody MediumDto mediumDto){
        BaseResponse<Optional<Medium>> mediumBaseResponse=null;
        mediumBaseResponse = BaseResponse.<Optional<Medium>>builder().Data(mediumInterface.UpdateMediumById(mediumDto)).build();
        return mediumBaseResponse;
    }
    @RolesAllowed(value="ADMIN")
    @PutMapping("/isdeleted")
    public BaseResponse Deleted(@RequestBody MediumDto mediumDto) {
        BaseResponse<Optional<Medium>>  mediumBaseResponse=null;
        mediumBaseResponse=BaseResponse.<Optional<Medium>>builder().Data(mediumInterface.IsDeletedmedium(mediumDto)).build();
        return mediumBaseResponse;
    }

}

