package my.company.groomer.repos;

import my.company.groomer.domains.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
