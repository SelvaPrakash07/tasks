package task.com.example.demo.Serviceinterface;

import task.com.example.demo.DTO.MediumDto;
import task.com.example.demo.Model.Medium;

import java.util.List;
import java.util.Optional;

public interface MediumInterface {

    Medium savemedium(MediumDto mediumDto);

    List<Medium> getAllMedium();

    Optional<Medium> IsDeletedmedium(MediumDto mediumDto);

    Optional<Medium> UpdateMediumById(MediumDto mediumDto);
}
