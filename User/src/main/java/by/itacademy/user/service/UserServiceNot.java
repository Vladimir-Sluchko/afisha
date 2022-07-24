package by.itacademy.user.service;

//@Service
public class UserServiceNot {
   /* private final PasswordEncoder encoder;
    private final UserRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public UserService(PasswordEncoder encoder, UserRepository repository, ModelMapper mapper) {
        this.encoder = encoder;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserCreatDto create(UserCreatDto dto) {
        User entity = mapper.map(dto, User.class);
        entity.setPassword(encoder.encode(dto.getPassword()));
        entity.setUuid(UUID.randomUUID());
        entity.setDtCreate(LocalDateTime.now());
        entity.setDtUpdate(LocalDateTime.now());
        repository.save(entity);
        return dto;
    }

    @Override
    public PageDto<UserReadDto> getAll(int page, int size) {
        List<User> listEntity = repository.findAll();
        List<UserReadDto> listDto = listEntity.stream()
                .map(element -> mapper.map(element, UserReadDto.class))
                .collect(Collectors.toList());;
        Pageable pageRequest = PageRequest.of(--page,size);
        Page<User> entities = repository.findAll(pageRequest);
        Page<UserReadDto> pageDtoR = new PageImpl<>(listDto, pageRequest, entities.getTotalElements());
        PageDto<UserReadDto> pageDto = mapper.map(pageDtoR,PageDto.class);
        return pageDto;
    }

    @Override
    public UserReadDto get(UUID uuid) {
        if (uuid == null) {
            throw new IllegalArgumentException("This field cannot be null");
        }
        User entity = repository.findById(uuid).
                orElseThrow(()-> {
                    throw new IllegalArgumentException("Нет такого User");
                });
        return mapper.map(entity,UserReadDto.class);
    }

    @Override
    public UserCreatDto update(UserCreatDto dto, UUID uuid, Long dtUpdate) {
        LocalDateTime dateUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(dtUpdate), ZoneId.systemDefault());
        User entity = repository.findById(uuid).orElseThrow(()-> {
            throw new IllegalArgumentException("Нет такого User");
        });
        if (entity.getDtUpdate().equals(dateUpdate)) {
            entity.setDtUpdate(LocalDateTime.now());
            entity.setMail(dto.getMail());
            entity.setNick(dto.getNick());
            entity.setRole(dto.getRole());
            entity.setStatus(dto.getStatus());
            repository.save(entity);
        } else {
            throw new OptimisticLockException("Entity already updated");
        }
        return dto;
    }

    @Override
    public RegistrationDto registration (RegistrationDto dto) {
        User entity = mapper.map(dto, User.class);
        entity.setUuid(UUID.randomUUID());
        entity.setDtCreate(LocalDateTime.now());
        entity.setDtUpdate(LocalDateTime.now());
        entity.setRole(RoleNoten.USER);
        entity.setStatus(Status.WAITING_ACTIVATION);
        repository.save(entity);
        return dto;
    }

    @Override
    public LoginUserDto login(LoginUserDto dto) {
        User entity = repository.findByMail(dto.getMail());
        if (entity.getPassword().equals(dto.getPassword())){
            ///
        }
        return null;
    }

    public User22 dtoToEntity (UserCreatDto dto){
        User user = new User();
        user.setUuid(UUID.randomUUID());
        user.setDtCreate(LocalDateTime.now());
        user.setDtUpdate(LocalDateTime.now());
        user.setUserName(dto.getNick());
        user.setMail(dto.getMail());
        user.setRoles(dto.getRole());
        user.setRoles(Collections.singleton);
        user.setUserStatus(UserStatus.WAITING_ACTIVATION);
        user.setPassword(encoder.encode(userRegistration.getPassword()));
        user.setCredentialsNonExpired(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
    }
*/
}
