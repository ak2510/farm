package com.magadh.farm.goatmanagement.service;

import com.magadh.farm.goatmanagement.domain.Goat;
import com.magadh.farm.goatmanagement.domain.GoatStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GoatService {

    private final Logger LOGGER = LoggerFactory.getLogger(GoatService.class);

    public Goat getGoatDetailsById(Long goatId) {

        LOGGER.info("Getting goat with id{}", goatId);
        Goat goat = new Goat();
        goat.setId(7867L);
        goat.setBreed("Black Bengal");
        goat.setStatus(GoatStatus.ACTIVE);
        return goat;

    }
}
