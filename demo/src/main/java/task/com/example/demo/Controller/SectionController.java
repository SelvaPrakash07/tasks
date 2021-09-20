package task.com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.com.example.demo.BaseResponse.BaseResponse;
import task.com.example.demo.DTO.MediumDto;
import task.com.example.demo.DTO.SectionDto;
import task.com.example.demo.Model.Medium;
import task.com.example.demo.Model.Section;
import task.com.example.demo.Serviceinterface.MediumInterface;
import task.com.example.demo.Serviceinterface.SectionInterface;
import task.com.example.demo.Serviceinterface.Service;

import java.util.List;
import java.util.Optional;

@RequestMapping("/section")
@RestController
public class SectionController {
    @Autowired
    private SectionInterface sectionInterface;

    @PostMapping(value = "/save")
    public BaseResponse saveSection(@RequestBody SectionDto sectionDto){
        BaseResponse<Section>  sectionBaseResponse =null;
        sectionBaseResponse=BaseResponse.<Section>builder().Data(sectionInterface.savesection(sectionDto)).build() ;
        return sectionBaseResponse;
    }

        @GetMapping("/findall")
        public BaseResponse findAllsection() {
            BaseResponse<List<Section>>  sectionBaseResponse=null;
            sectionBaseResponse = BaseResponse.<List<Section>>builder().Data(sectionInterface.getAllsection()).build();
            return sectionBaseResponse;
        }

        @PutMapping("/update")
        public BaseResponse updateById(@RequestBody SectionDto sectionDto){
            BaseResponse<Optional<Section>>  sectionBaseResponse=null;
            sectionBaseResponse = BaseResponse.<Optional<Section>>builder().Data(sectionInterface.UpdateSectionById(sectionDto)).build();
            return sectionBaseResponse;
        }

        @PutMapping("/isdeleted")
        public BaseResponse Deleted(@RequestBody  SectionDto sectionDto) {
            BaseResponse<Optional<Section>>  sectionBaseResponse=null;
            sectionBaseResponse=BaseResponse.<Optional<Section>>builder().Data(sectionInterface.IsDeletedSection(sectionDto)).build();
            return sectionBaseResponse;
        }

    }
