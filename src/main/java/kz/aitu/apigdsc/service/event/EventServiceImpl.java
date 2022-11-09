package kz.aitu.apigdsc.service.event;

import kz.aitu.apigdsc.model.EventRequest;
import kz.aitu.apigdsc.model.EventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired


    @Override
    public EventResponse createEvent(EventRequest eventRequest) {
        return null;
    }

    @Override
    public EventResponse updateEvent(EventRequest eventRequest) {
        return null;
    }

    @Override
    public EventResponse getEventById(String eventId) {
        return null;
    }

    @Override
    public List<EventResponse> getAllEvents() {
        return null;
    }

    @Override
    public void deleteEventById(String eventId) {

    }
}
