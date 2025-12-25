@RestController
@RequestMapping("/api/holdings")
@Tag(name = "Holdings")
public class HoldingRecordController {

    private final HoldingRecordService service;

    public HoldingRecordController(HoldingRecordService service) {
        this.service = service;
    }

    @PostMapping
    public HoldingRecord create(@RequestBody HoldingRecord holding) {
        return service.recordHolding(holding);
    }

    @GetMapping("/investor/{investorId}")
    public List<HoldingRecord> byInvestor(@PathVariable Long investorId) {
        return service.getHoldingsByInvestor(investorId);
    }

    @GetMapping("/{id}")
    public HoldingRecord get(@PathVariable Long id) {
        return service.getHoldingById(id);
    }

    @GetMapping
    public List<HoldingRecord> list() {
        return service.getAllHoldings();
    }
}
