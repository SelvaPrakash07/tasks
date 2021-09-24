package task.com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.com.example.demo.Response.BaseResponse;
import task.com.example.demo.Response.PageResponse;
import task.com.example.demo.DTO.StandardDto;
import task.com.example.demo.Model.Standard;
import task.com.example.demo.Serviceinterface.StandardInterface;

import javax.annotation.security.RolesAllowed;
import java.util.Optional;


@RequestMapping("/standard")
    @RestController
    public class StandardController {
        @Autowired
        private StandardInterface standardInterface;

    @RolesAllowed(value="ADMIN")
        @PostMapping(value = "/save")
        public BaseResponse saveStandard(@RequestBody StandardDto standardDto) {
            BaseResponse<Standard>  standardBaseResponse =null;
            standardBaseResponse=BaseResponse.<Standard>builder().Data(standardInterface.savestandard(standardDto)).build() ;
            return standardBaseResponse;
        }
    @RolesAllowed(value="ADMIN")
        @PutMapping("/update")
        public BaseResponse update(@RequestBody StandardDto standardDto) {
            BaseResponse<Optional<Standard>>  standardBaseResponse=null;
            standardBaseResponse = BaseResponse.<Optional<Standard>>builder().Data(standardInterface.UpdatestandardById(standardDto)).build();
            return standardBaseResponse;
        }

    @RolesAllowed(value="ADMIN")
    @PutMapping("/isdeleted")
    public BaseResponse Deleted(@RequestBody StandardDto standardDto) {
        BaseResponse<Optional<Standard>>  standardBaseResponse=null;
        standardBaseResponse =BaseResponse.<Optional<Standard>>builder().Data(standardInterface.IsDeletedstandard(standardDto)).build();
        return standardBaseResponse;
    }


    @RolesAllowed(value="USER")
    @GetMapping(value = "/name")
        public @ResponseBody
        PageResponse<Standard> getname(@RequestParam(defaultValue = "0") Integer pageNo,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       @RequestParam(defaultValue = "id") String sortBy,
                                       @RequestParam String name)
                throws Exception {
            return standardInterface.getByname(pageNo, pageSize, sortBy,name);
        }
}
