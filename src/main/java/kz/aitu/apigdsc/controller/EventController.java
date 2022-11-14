package kz.aitu.apigdsc.controller;

import kz.aitu.apigdsc.model.EventRequest;
import kz.aitu.apigdsc.model.EventResponse;
import kz.aitu.apigdsc.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/event")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("/all")
    public List<EventResponse> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public EventResponse getEvent(@PathVariable String eventId) {
        return eventService.getEventById(eventId);
    }

    @PostMapping
    public EventResponse addEvent(@RequestBody EventRequest event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/{id}")
    public EventResponse updateEvent(@RequestBody EventRequest event) {
        return eventService.updateEvent(event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable String eventId) {
        eventService.deleteEventById(eventId);
    }

}
