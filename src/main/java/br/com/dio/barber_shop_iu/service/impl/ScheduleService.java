package br.com.dio.barber_shop_iu.service.impl;


import br.com.dio.barber_shop_iu.entity.ScheduleEntity;
import br.com.dio.barber_shop_iu.repository.IScheduleRepository;
import br.com.dio.barber_shop_iu.service.IScheduleService;
import br.com.dio.barber_shop_iu.service.query.IScheduleQueryService;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService implements IScheduleService {


    private final IScheduleRepository repository;
    private final IScheduleQueryService queryService;

    public ScheduleService(IScheduleRepository repository, IScheduleQueryService queryService) {
        this.repository = repository;
        this.queryService = queryService;
    }


    @Override
    public ScheduleEntity save(final ScheduleEntity entity) {
        queryService.verifyIfScheduleExists(entity.getStartAt(), entity.getEndAt());

        return repository.save(entity);
    }

    @Override
    public void delete(final long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }
}
