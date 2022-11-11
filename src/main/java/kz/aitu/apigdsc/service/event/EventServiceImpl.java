package kz.aitu.apigdsc.service.event;

import kz.aitu.apigdsc.model.EventRequest;
import kz.aitu.apigdsc.model.EventResponse;
import kz.aitu.apigdsc.repository.EventEntity;
import kz.aitu.apigdsc.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }


    @Override
    public EventResponse createEvent(EventRequest eventRequest) {
        eventRequest.setEventId(UUID.randomUUID().toString());
        EventEntity employeeEntity = modelMapper.map(eventRequest, EventEntity.class);
        eventRepository.save(employeeEntity);

        return modelMapper.map(employeeEntity, EventResponse.class);
    }

    @Override
    public EventResponse updateEvent(EventRequest eventRequest) {
        EventEntity eventEntity = modelMapper.map(eventRequest, EventEntity.class);
        EventEntity eventDbEntity = eventRepository.getEventEntityByEventId(eventRequest.getEventId());
        eventEntity.setId(eventDbEntity.getId());
        eventRepository.save(eventEntity);

        return modelMapper.map(eventEntity, EventResponse.class);
    }

    @Override
    public EventResponse getEventById(String eventId) {
        return modelMapper.map(eventRepository.getEventEntityByEventId(eventId), EventResponse.class);
    }

    @Override
    public List<EventResponse> getAllEvents() {
        List<EventEntity> events = new ArrayList<>();
        eventRepository.findAll().forEach(events::add);
        return events.stream().map(event -> modelMapper.map(event, EventResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteEventById(String eventId) {
        EventEntity deletedEntity = eventRepository.getEventEntityByEventId(eventId);
        eventRepository.deleteEventEntityById(deletedEntity.getId());
    }
}
