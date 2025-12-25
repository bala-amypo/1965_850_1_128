@RestController
@RequestMapping("/api/allocation-rules")
@Tag(name = "Allocation Rules")
public class AllocationRuleController {

    private final AllocationRuleService service;

    public AllocationRuleController(AllocationRuleService service) {
        this.service = service;
    }

    @PostMapping
    public AssetClassAllocationRule create(@RequestBody AssetClassAllocationRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public AssetClassAllocationRule update(@PathVariable Long id,
                                           @RequestBody AssetClassAllocationRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/investor/{investorId}")
    public List<AssetClassAllocationRule> byInvestor(@PathVariable Long investorId) {
        return service.getRulesByInvestor(investorId);
    }

    @GetMapping("/{id}")
    public AssetClassAllocationRule get(@PathVariable Long id) {
        return service.getRuleById(id);
    }

    @GetMapping
    public List<AssetClassAllocationRule> list() {
        return service.getRulesByInvestor(null);
    }
}
