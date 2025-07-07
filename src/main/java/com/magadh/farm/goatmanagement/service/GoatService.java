package com.magadh.farm.goatmanagement.service;

import com.magadh.farm.common.annotation.LogExecutionTime;
import com.magadh.farm.common.exceptions.ResourceNotFoundException;
import com.magadh.farm.goatmanagement.domain.Goat;
import com.magadh.farm.goatmanagement.domain.GoatStatus;
import com.magadh.farm.goatmanagement.dto.CreateGoatRequest;
import com.magadh.farm.goatmanagement.dto.GoatResponse;
import com.magadh.farm.goatmanagement.repositories.GoatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoatService {

    private final Logger LOGGER = LoggerFactory.getLogger(GoatService.class);

    private final GoatRepository goatRepository;

    @Autowired
    public GoatService(GoatRepository goatRepository) {
        this.goatRepository = goatRepository;
    }

    @LogExecutionTime
    public GoatResponse getGoatDetailsById(Long goatId) {

        LOGGER.info("Getting goat with id {}", goatId);

        Goat goat = goatRepository.findById(goatId).orElseThrow(() -> new ResourceNotFoundException("Goat not found"));
        return new GoatResponse(goat.getId(), goat.getBreed(), goat.getColor(), goat.getWeight(), goat.getHornType());
    }

    public void createGoat(CreateGoatRequest goatRequest) {
        Goat goat = new Goat();
        goat.setBreed(goatRequest.breed());
        goat.setColor(goatRequest.color());
        goat.setGender(goatRequest.gender());
        goat.setWeight(goatRequest.weight());
        goat.setDateOfBirth(goatRequest.dateOfBirth());
        goatRepository.save(goat);

    }
}
