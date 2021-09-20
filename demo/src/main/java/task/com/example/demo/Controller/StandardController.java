package task.com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.com.example.demo.BaseResponse.BaseResponse;
import task.com.example.demo.BaseResponse.PageResponse;
import task.com.example.demo.DTO.StandardDto;
import task.com.example.demo.Model.Standard;
import task.com.example.demo.Model.Subject;
import task.com.example.demo.Serviceinterface.Service;
import task.com.example.demo.Serviceinterface.StandardInterface;

import java.util.Optional;


@RequestMapping("/standard")
    @RestController
    public class StandardController {
        @Autowired
        private StandardInterface standardInterface;

        @PostMapping(value = "/save")
        public BaseResponse saveStandard(@RequestBody StandardDto standardDto) {
            BaseResponse<Standard>  standardBaseResponse =null;
            standardBaseResponse=BaseResponse.<Standard>builder().Data(standardInterface.savestandard(standardDto)).build() ;
            return standardBaseResponse;
        }

        @PutMapping("/update")
        public BaseResponse update(@RequestBody StandardDto standardDto) {
            BaseResponse<Optional<Standard>>  standardBaseResponse=null;
            standardBaseResponse = BaseResponse.<Optional<Standard>>builder().Data(standardInterface.UpdatestandardById(standardDto)).build();
            return standardBaseResponse;
        }
    @PutMapping("/isdeleted")
    public BaseResponse Deleted(@RequestBody StandardDto standardDto) {
        BaseResponse<Optional<Standard>>  standardBaseResponse=null;
        standardBaseResponse =BaseResponse.<Optional<Standard>>builder().Data(standardInterface.IsDeletedstandard(standardDto)).build();
        return standardBaseResponse;
    }

    @GetMapping(value = "standard/name")
        public @ResponseBody
        PageResponse<Standard> getname(@RequestParam(defaultValue = "0") Integer pageNo,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       @RequestParam(defaultValue = "id") String sortBy,
                                       @RequestParam String name)
                throws Exception {
            return standardInterface.getByname(pageNo, pageSize, sortBy,name);
        }
}
