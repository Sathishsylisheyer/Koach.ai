@Service
public class SchedulerService {

    @Autowired
    private EventRepository eventRepository;

    public boolean addEvent(Event event) {
        List<Event> events = eventRepository.findAll();
        for (Event e : events) {
            if (event.getStartTime() < e.getEndTime() && event.getEndTime() > e.getStartTime()) {
                return false; // Overlap detected
            }
        }
        eventRepository.save(event);
        return true;
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }
}
