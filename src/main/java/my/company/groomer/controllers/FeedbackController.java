package my.company.groomer.controllers;

import my.company.groomer.domains.Event;
import my.company.groomer.domains.Feedback;
import my.company.groomer.services.EventService;
import my.company.groomer.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/createFeedback")
    public ResponseEntity<?> createFeedback(@RequestBody Feedback feedback) {
        Feedback createdFeedback = feedbackService.create(feedback);
        return ResponseEntity.ok(createdFeedback);
    }

    @GetMapping("/getFeedbacks")
    public ResponseEntity<?> getFeedbacks() {
        List<Feedback> events = feedbackService.get();
        return ResponseEntity.ok(events);
    }

    @DeleteMapping("/deleteFeedback")
    public ResponseEntity<?> deleteFeedback(@RequestParam Long id) {
        feedbackService.delete(id);
        return ResponseEntity.ok("{}");
    }
}
