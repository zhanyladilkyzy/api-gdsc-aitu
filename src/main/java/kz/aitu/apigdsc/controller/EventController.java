package kz.aitu.apigdsc.controller;

import kz.aitu.apigdsc.model.EventModel;
import kz.aitu.apigdsc.model.EventRequest;
import kz.aitu.apigdsc.model.EventResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/event")
public class EventController {

    @GetMapping("/all")
    public List<EventResponse> getAllEvents() {

    }

    @GetMapping("/{id}")
    public EventResponse getEvent(@PathVariable Integer eventId) {

    }

    @PostMapping
    public EventResponse addEvent(@RequestBody EventRequest event) {

    }

    @PutMapping("/{id}")
    public EventResponse updateEvent(@RequestBody EventRequest event) {

    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Integer eventId) {

    }

}
