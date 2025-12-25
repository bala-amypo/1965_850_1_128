@RestController
@RequestMapping("/api/snapshots")
@Tag(name = "Snapshots")
public class AllocationSnapshotController {

    private final AllocationSnapshotServiceImpl service;

    public AllocationSnapshotController(AllocationSnapshotServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/compute/{investorId}")
    public AllocationSnapshotRecord compute(@PathVariable Long investorId) {
        return service.computeSnapshot(investorId);
    }
}
