package task.com.example.demo.Serviceinterface;

import task.com.example.demo.BaseResponse.BaseResponse;
import task.com.example.demo.BaseResponse.PageResponse;
import task.com.example.demo.DTO.*;
import task.com.example.demo.Model.Standard;

public interface Service {

    BaseResponse savemedium(MediumDto mediumDto);

    BaseResponse getAllMedium();

    BaseResponse getMediumById(int id);

    BaseResponse updatemedium(MediumDto mediumDto);

    BaseResponse IsActivemedium(MediumDto mediumDto);

    BaseResponse IsDeletedmedium(MediumDto mediumDto);

    BaseResponse saveSection(SectionDto sectionDto);

    BaseResponse getAllSection();

    BaseResponse getSectionById(int id);

    BaseResponse updatesection(SectionDto sectionDto);

    BaseResponse IsActivesection(SectionDto sectionDto);

    BaseResponse IsDeletedSection(SectionDto sectionDto);

    BaseResponse savestaff(StaffDto staffDto);

    BaseResponse getAllStaff();

    BaseResponse getStaffById(int id);

    BaseResponse updatestaff(StaffDto staffDto);

    BaseResponse IsActiveStaff(StaffDto staffDto);

    BaseResponse IsDeletedStaff(StaffDto staffDto);

    BaseResponse savestandard(StandardDto standardDto);

    BaseResponse getAllstandard();

    BaseResponse getStandardById(int id);

    BaseResponse updatestandard(StandardDto standardDto);

    BaseResponse IsActivestandard(StandardDto standardDto);

    BaseResponse IsDeletedstandard(StandardDto standardDto);

    BaseResponse savesubject(SubjectDto subjectDto);

    BaseResponse getAllsubject();

    BaseResponse getsubjectById(int id);

    BaseResponse updatesubject(SubjectDto subjectDto);

    BaseResponse IsActivesubject(SubjectDto subjectDto);

    BaseResponse IsDeletedsubject(SubjectDto subjectDto);

    BaseResponse saveEverything(StandardDto standardDto);


    PageResponse<Standard> getByname(Integer pageNo, Integer pageSize, String sortBy, String name);

}
