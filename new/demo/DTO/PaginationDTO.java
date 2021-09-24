package task.com.example.demo.DTO;


import jdk.dynalink.linker.LinkerServices;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class PaginationDTO {
    public List<StandDto> obj1;
    public List<SectionDto> obj2;

}
