@RestController
@RequestMapping("/api/scheduler")
public class EventController {

    @Autowired
    private SchedulerService schedulerService;

    @PostMapping("/add")
    public ResponseEntity<String> addEvent(@RequestBody Event event) {
        boolean added = schedulerService.addEvent(event);
        return added ? ResponseEntity.ok("Event added successfully") :
                       ResponseEntity.status(HttpStatus.CONFLICT).body("Event overlaps with an existing event");
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        return schedulerService.getEvents();
    }
}
