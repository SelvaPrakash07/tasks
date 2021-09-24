package task.com.example.demo.Serviceinterface;

import task.com.example.demo.Response.PageResponse;
import task.com.example.demo.DTO.StandardDto;
import task.com.example.demo.Model.Standard;

import java.util.Optional;

public interface StandardInterface {
    Standard savestandard(StandardDto standardDto);

    Optional<Standard> UpdatestandardById(StandardDto standardDto);

    Optional<Standard> IsDeletedstandard(StandardDto standardDto);

    PageResponse<Standard> getByname(Integer pageNo, Integer pageSize, String sortBy, String name);
}
