package my.company.groomer.services;

import my.company.groomer.domains.Event;
import my.company.groomer.repos.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event) {
        Date endDate = new Date(event.getStart().getTime());
        endDate.setHours(event.getStart().getHours() + 2);
        event.setEnd(endDate);
        Event createdEvent = eventRepository.save(event);
        return createdEvent;
    }

    public Event updateEvent(Event event) {
        Date endDate = new Date(event.getStart().getTime());
        endDate.setHours(event.getStart().getHours() + 2);
        event.setEnd(endDate);
        Event createdEvent = eventRepository.save(event);
        return createdEvent;
    }

    public List<Event> getEventsById(Long id) {
        List<Event> events = eventRepository.findEventByClientId(id);
        return events;
    }



    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        Event event = eventRepository.findById(id).get();
        return event;
    }

    public void cancelEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
