package task.com.example.demo.Controller;



import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import task.com.example.demo.Response.BaseResponse;
import task.com.example.demo.DTO.UserDto;
import task.com.example.demo.DTO.UserSignupRequestVO;
import task.com.example.demo.Serviceinterface.ServiceRole;


@RestController
public class UserController {

    @Autowired
    private ServiceRole service;

    @PostMapping(value="/save")
    public BaseResponse<UserDto> Save(@RequestBody UserDto userDto){
        BaseResponse base=null;
        base = BaseResponse.<UserDto>builder().Data(service.Saveuser(userDto)).build();
        return base;
    }

    @GetMapping(value = "/user/login", consumes = {"application/json"})
    @ApiOperation(value = "user login ")
    public BaseResponse.BaseResponseBuilder<UserSignupRequestVO> UserLogin(@RequestBody UserSignupRequestVO userSignupRequestVO) {
        BaseResponse.BaseResponseBuilder<UserSignupRequestVO> baseResponse=null;
        baseResponse = BaseResponse.<UserSignupRequestVO>builder().Data(service.logOfUser(userSignupRequestVO));
        return baseResponse;
    }
}
