package task.com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.com.example.demo.Response.BaseResponse;
import task.com.example.demo.DTO.SectionDto;
import task.com.example.demo.Model.Section;
import task.com.example.demo.Serviceinterface.SectionInterface;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RequestMapping("/section")
@RestController
public class SectionController {
    @Autowired
    private SectionInterface sectionInterface;

    @RolesAllowed(value="ADMIN")
    @PostMapping(value = "/save")
    public BaseResponse saveSection(@RequestBody SectionDto sectionDto){
        BaseResponse<Section>  sectionBaseResponse =null;
        sectionBaseResponse=BaseResponse.<Section>builder().Data(sectionInterface.savesection(sectionDto)).build() ;
        return sectionBaseResponse;
    }
    @RolesAllowed(value="USER")
        @GetMapping("/findall")
        public BaseResponse findAllsection() {
            BaseResponse<List<Section>>  sectionBaseResponse=null;
            sectionBaseResponse = BaseResponse.<List<Section>>builder().Data(sectionInterface.getAllsection()).build();
            return sectionBaseResponse;
        }
    @RolesAllowed(value="ADMIN")
        @PutMapping("/update")
        public BaseResponse updateById(@RequestBody SectionDto sectionDto){
            BaseResponse<Optional<Section>>  sectionBaseResponse=null;
            sectionBaseResponse = BaseResponse.<Optional<Section>>builder().Data(sectionInterface.UpdateSectionById(sectionDto)).build();
            return sectionBaseResponse;
        }
    @RolesAllowed(value="ADMIN")
        @PutMapping("/isdeleted")
        public BaseResponse Deleted(@RequestBody  SectionDto sectionDto) {
            BaseResponse<Optional<Section>>  sectionBaseResponse=null;
            sectionBaseResponse=BaseResponse.<Optional<Section>>builder().Data(sectionInterface.IsDeletedSection(sectionDto)).build();
            return sectionBaseResponse;
        }

    }
