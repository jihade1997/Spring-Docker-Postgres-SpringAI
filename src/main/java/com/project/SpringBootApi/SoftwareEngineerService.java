package com.project.SpringBootApi;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }


    public List<SoftwareEngineer> getSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineersById(Integer id) {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("software engineer " + id  + " not found"));
    }

    public void deleteSoftwareEngineer(Integer id) {
        boolean exists = softwareEngineerRepository.existsById(id);
        if (exists){
            softwareEngineerRepository.deleteById(id);
        } else {
            throw new IllegalStateException("software engineer " + id + " not found");
        }
    }

    public void updateSoftwareEngineer(Integer id, SoftwareEngineer softwareEngineer1 ) {
        boolean exists = softwareEngineerRepository.existsById(id);
        if (exists){
            SoftwareEngineer softwareEngineer = getSoftwareEngineersById(id);
            softwareEngineer.setName(softwareEngineer1.getName());
            softwareEngineer.setTechStack(softwareEngineer1.getTechStack());
            softwareEngineerRepository.save(softwareEngineer);
        } else {
            throw new IllegalStateException("software engineer " + id + " not found");
        }
    }
}
