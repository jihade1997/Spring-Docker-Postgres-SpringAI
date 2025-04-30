package com.project.SpringBootApi.services;

import com.project.SpringBootApi.entities.SoftwareEngineer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareEngineerRepository extends JpaRepository<SoftwareEngineer, Integer> {


}
