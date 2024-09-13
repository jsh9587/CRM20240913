package company.demo_last_last202409121553.user.service;

import company.demo_last_last202409121553.user.entity.StatusEntity;
import company.demo_last_last202409121553.user.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<StatusEntity> findAll() {
        return statusRepository.findAll();
    }
}
