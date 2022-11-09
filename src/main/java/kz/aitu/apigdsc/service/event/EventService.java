package kz.aitu.apigdsc.service.event;

import kz.aitu.apigdsc.model.EventRequest;
import kz.aitu.apigdsc.model.EventResponse;

import java.util.List;

public interface EventService {
    EventResponse createEvent(EventRequest eventRequest);

    EventResponse updateEvent(EventRequest eventRequest);

    EventResponse getEventById(String eventId);

    List<EventResponse> getAllEvents();

    void deleteEventById(String eventId);
    
}
