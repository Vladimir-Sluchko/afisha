package by.itacademy.user.controller;

//@Controller
//@RequestMapping("/users")
public class AdminController {
    /*private final IServiceUsers service;

    public UserController(IServiceUsers service) {
        this.service = service;
    }
    @PostMapping("/registration")
    public ResponseEntity<UserCreatDto> create (@RequestBody UserCreatDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<PageDto> getPage (@RequestParam(name = "page",defaultValue = "1") int page,
                                            @RequestParam(name = "size", defaultValue = "20") int size){
        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserReadDto> get (@PathVariable UUID uuid){
        return ResponseEntity.ok(service.get(uuid));
    }
    @PutMapping("{uuid}/dt_update/{dt_update}")
    public ResponseEntity<UserCreatDto> update (@RequestBody UserCreatDto dto,
                                                @PathVariable UUID uuid,
                                                @PathVariable(name = "dt_update") Long dtUpdate){
        return ResponseEntity.ok(service.update(dto,uuid,dtUpdate));
    }*/

}
