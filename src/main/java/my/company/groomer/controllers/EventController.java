package my.company.groomer.controllers;

import my.company.groomer.domains.Event;
import my.company.groomer.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/event")
    public ResponseEntity<?> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        System.out.println(createdEvent);
        return ResponseEntity.ok(createdEvent);
    }

    @PutMapping("/updateEvent")
    public ResponseEntity<?> updateEvent(@RequestBody Event event) {
        Event createdEvent = eventService.updateEvent(event);
        return ResponseEntity.ok(createdEvent);
    }

    @GetMapping("/getEvents")
    public ResponseEntity<?> getEvents(@RequestParam Long id) {
        List<Event> events = eventService.getEventsById(id);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/getAllEvents")
    public ResponseEntity<?> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/getEvent")
    public ResponseEntity<?> getEvent(@RequestParam Long id) {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/cancelEvent")
    public ResponseEntity<?> cancelEvent(@RequestParam Long id) {
        eventService.cancelEvent(id);
        return ResponseEntity.ok("{}");
    }
}
