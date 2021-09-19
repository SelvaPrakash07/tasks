package task.com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.com.example.demo.BaseResponse.BaseResponse;
import task.com.example.demo.DTO.MediumDto;
import task.com.example.demo.Service.ServiceImpl;
@RequestMapping("/medium")
@RestController
public class MediumController {
@Autowired
    private ServiceImpl serviceimpl;

    @PostMapping(value = "/save")
    public BaseResponse saveMedium(@RequestBody MediumDto mediumDto) {
        return serviceimpl.savemedium(mediumDto);
    }
    @GetMapping("/findall")
    public BaseResponse findAllmedium() {
        return serviceimpl.getAllMedium();
    }
    @GetMapping("/getbyId")
    public BaseResponse getById(@PathVariable int id) {
        return serviceimpl.getMediumById(id);
    }
    @PutMapping("/Update")
    public BaseResponse update(@RequestBody MediumDto mediumDto) {
        return serviceimpl.updatemedium(mediumDto);
    }

    @PutMapping("/IsActive")
    public BaseResponse Active(@RequestBody MediumDto mediumDto) {
        return serviceimpl.IsActivemedium(mediumDto);
    }
    @PutMapping("/IsDeleted")
    public BaseResponse Deleted(@RequestBody MediumDto mediumDto) {
        return serviceimpl.IsDeletedmedium(mediumDto);
    }

}

