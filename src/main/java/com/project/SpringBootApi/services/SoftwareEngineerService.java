package com.project.SpringBootApi.services;

import com.project.SpringBootApi.entities.SoftwareEngineer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;
    private final AiService aiService;
    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository, AiService aiService) {
        this.softwareEngineerRepository = softwareEngineerRepository;
        this.aiService = aiService;
    }


    public List<SoftwareEngineer> getSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        String prompt = """
                Based on the programming tech stack %s that %s has given
                Provide a full learning path and recommendations for this person.
                """.formatted(
                softwareEngineer.getTechStack(),
                softwareEngineer.getName()
        );
        String chatRes = aiService.chat(prompt);
        softwareEngineer.setLearningPathRecommendation(chatRes);
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
