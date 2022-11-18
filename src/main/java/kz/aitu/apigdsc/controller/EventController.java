package kz.aitu.apigdsc.controller;

import kz.aitu.apigdsc.model.EventRequest;
import kz.aitu.apigdsc.model.EventResponse;
import kz.aitu.apigdsc.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("/all")
    public List<EventResponse> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{eventId}")
    public EventResponse getEvent(@PathVariable String eventId) {
        return eventService.getEventById(eventId);
    }

    @PostMapping
    public EventResponse addEvent(@RequestBody EventRequest event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/{eventId}")
    public EventResponse updateEvent(@PathVariable String eventId, @RequestBody EventRequest event) {
        event.setEventId(eventId);
        return eventService.updateEvent(event);
    }

    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable String eventId) {
        eventService.deleteEventById(eventId);
    }

}
