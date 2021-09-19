package task.com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.com.example.demo.BaseResponse.BaseResponse;
import task.com.example.demo.DTO.MediumDto;
import task.com.example.demo.DTO.SectionDto;
import task.com.example.demo.Service.ServiceImpl;

@RequestMapping("/section")
    @RestController
    public class SectionController {
        @Autowired
        private ServiceImpl serviceimpl;

        @PostMapping(value = "/save")
        public BaseResponse saveSection(@RequestBody SectionDto sectionDto) {
            return serviceimpl.saveSection(sectionDto);
        }
        @GetMapping("/findall")
        public BaseResponse findAllsection() {
            return serviceimpl.getAllSection();
        }
        @GetMapping("/getbyid")
        public BaseResponse getById(@PathVariable int id) {
            return serviceimpl.getSectionById(id);
        }
        @PutMapping("/Update")
        public BaseResponse update(@RequestBody SectionDto sectionDto) {
            return serviceimpl.updatesection(sectionDto);
        }

        @PutMapping("/IsActive")
        public BaseResponse Active(@RequestBody SectionDto sectionDto) {
            return serviceimpl.IsActivesection(sectionDto);
        }
        @PutMapping("/IsDeleted")
        public BaseResponse Deleted(@RequestBody SectionDto sectionDto) {
            return serviceimpl.IsDeletedSection(sectionDto);
        }

    }
