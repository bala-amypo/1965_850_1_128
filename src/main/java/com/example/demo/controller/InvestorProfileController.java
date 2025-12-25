@RestController
@RequestMapping("/api/investors")
@Tag(name = "Investors")
public class InvestorProfileController {

    private final InvestorProfileService service;

    public InvestorProfileController(InvestorProfileService service) {
        this.service = service;
    }

    @PostMapping
    public InvestorProfile create(@RequestBody InvestorProfile investor) {
        return service.createInvestor(investor);
    }

    @GetMapping("/{id}")
    public InvestorProfile get(@PathVariable Long id) {
        return service.getInvestorById(id);
    }

    @GetMapping
    public List<InvestorProfile> list() {
        return service.getAllInvestors();
    }

    @PutMapping("/{id}/status")
    public InvestorProfile updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        return service.updateInvestorStatus(id, active);
    }

    @GetMapping("/lookup/{investorId}")
    public InvestorProfile lookup(@PathVariable String investorId) {
        return service.findByInvestorId(investorId);
    }
}
