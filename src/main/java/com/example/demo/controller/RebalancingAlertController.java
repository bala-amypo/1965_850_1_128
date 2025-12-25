@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Alerts")
public class RebalancingAlertController {

    private final RebalancingAlertService service;

    public RebalancingAlertController(RebalancingAlertService service) {
        this.service = service;
    }

    @PostMapping
    public RebalancingAlertRecord create(@RequestBody RebalancingAlertRecord alert) {
        return service.createAlert(alert);
    }

    @PutMapping("/{id}/resolve")
    public RebalancingAlertRecord resolve(@PathVariable Long id) {
        return service.resolveAlert(id);
    }

    @GetMapping("/investor/{investorId}")
    public List<RebalancingAlertRecord> byInvestor(@PathVariable Long investorId) {
        return service.getAlertsByInvestor(investorId);
    }

    @GetMapping("/{id}")
    public RebalancingAlertRecord get(@PathVariable Long id) {
        return service.getAlertById(id);
    }

    @GetMapping
    public List<RebalancingAlertRecord> list() {
        return service.getAllAlerts();
    }
}
