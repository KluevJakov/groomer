package my.company.groomer.repos;

import my.company.groomer.domains.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(nativeQuery = true, value = "select * from events where client_id = ?1")
    List<Event> findEventByClientId(Long id);
}
