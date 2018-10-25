package com.wipu.javaapi.api;

import com.wipu.javaapi.availability.AvailabilityOutbound;
import com.wipu.javaapi.availability.AvailabilityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hotels")
public class HotelsController {

    private final AvailabilityService availabilityService;

    public HotelsController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @GetMapping
    public String getHotels() throws Exception {
        return "Hello";
    }

    @GetMapping(value = "{hotelAddress}/availability")
    public AvailabilityOutbound getAvailability(@PathVariable("hotelAddress") String hotelAddress) throws NotFoundException {
        return availabilityService.getAvailability(hotelAddress)
                .orElseThrow(NotFoundException::new);
    }

}
