package task.com.example.demo.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import task.com.example.demo.Constants.MasterConstants;
import task.com.example.demo.DTO.MediumDto;
import task.com.example.demo.Model.Medium;
import task.com.example.demo.Repository.MediumRepo;
import task.com.example.demo.Serviceinterface.MediumInterface;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MediumService implements MediumInterface {

    @Autowired
    private MediumRepo mediumRepo;
    @Override
    public Medium savemedium(MediumDto mediumDto) {
        ModelMapper modelMapper = new ModelMapper();
        Medium medium = modelMapper.map(mediumDto, Medium.class);
        mediumRepo.save(medium);
        return medium;
    }

    @Override
    public List<Medium> getAllMedium() {
        List<Medium> medium=mediumRepo.findAll();
        return medium;
    }

    @Override
    public Optional<Medium> IsDeletedmedium(MediumDto mediumDto) {
        Optional<Medium> medium = mediumRepo.findById(mediumDto.getId());
        if (medium.isPresent())
        {
            medium.get().setIsDeleted(1);
        }
        else
        {throw new RuntimeException(MasterConstants.ERROR_MESSAGE);
        }
        mediumRepo.save(medium.get());
        return medium;
    }

    @Override
    public Optional<Medium> UpdateMediumById(MediumDto mediumDto) {
        Optional<Medium> medium = mediumRepo.findById(mediumDto.getId());
        if (medium.isPresent())
        {medium.get().setMedium(mediumDto.getMedium());
            medium.get().setCreatedAt(medium.get().createdAt);
        }
        else
        {throw new RuntimeException(MasterConstants.ERROR_MESSAGE);
        }
        mediumRepo.save(medium.get());
        return medium;
    }
}




