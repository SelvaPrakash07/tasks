package task.com.example.demo.Serviceinterface;



import task.com.example.demo.Response.BaseResponse;
import task.com.example.demo.DTO.UserDto;
import task.com.example.demo.DTO.UserSignupRequestVO;

public interface ServiceRole {

    UserSignupRequestVO logOfUser(UserSignupRequestVO userSignupRequestVO);

    UserDto Saveuser(UserDto userDto);
}



