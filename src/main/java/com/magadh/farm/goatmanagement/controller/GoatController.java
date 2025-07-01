package com.magadh.farm.goatmanagement.controller;

import com.magadh.farm.common.dto.ErrorResponse;
import com.magadh.farm.common.dto.SuccessResponse;
import com.magadh.farm.goatmanagement.domain.Goat;
import com.magadh.farm.goatmanagement.service.GoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goats")
public class GoatController {

    private GoatService goatService;

    @Autowired
    public GoatController(GoatService goatService) {
        this.goatService = goatService;
    }

    /**
     * Register new goat
     * @return
     */
    @PostMapping
    public String registerGoat() {
        return "Registered New Goat";
    }


    /**
     * Get deails of all goats
     * @return
     */
    @GetMapping
    public String getAllGoats() {
        return "All goats";
    }

    /**
     * Get goat details of given goat id
     * @param goatId id of the goat
     * @return Goat object
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getGoatById(@PathVariable("id") Long goatId) {
        try {
            Goat goat = goatService.getGoatDetailsById(12L);
            SuccessResponse<Goat> response = new SuccessResponse<>("Goat details retrieved successfully", goat);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse("User Not Found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update goat details of given goat id
     * @return
     */
    @PostMapping("/{id}")
    public String updateGoat() {
        return "updated";
    }

    /**
     * Goat details by goat tag id
     * @param tagId
     * @return
     */
    @GetMapping("/by-tag/{tagId}")
    public String getGoatByTag(@PathVariable("tagId") Long tagId) {
        return "Goat by tag id";
    }

    /**
     * Get deails of all goats in a specific farm
     * @return
     */
    @GetMapping("/farm/{farmId}")
    public String getAllGoatsByFarm(@PathVariable("farmId") Long farmId) {
        return "All goats of specific farm";
    }
}
