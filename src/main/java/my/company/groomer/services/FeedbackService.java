package my.company.groomer.services;

import my.company.groomer.domains.Event;
import my.company.groomer.domains.Feedback;
import my.company.groomer.repos.EventRepository;
import my.company.groomer.repos.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback create(Feedback feedback) {
        Feedback createdEvent = feedbackRepository.save(feedback);
        return createdEvent;
    }

    public List<Feedback> get() {
        List<Feedback> events = feedbackRepository.findAll();
        return events;
    }

    public void delete(Long id) {
        feedbackRepository.deleteById(id);
    }


}
