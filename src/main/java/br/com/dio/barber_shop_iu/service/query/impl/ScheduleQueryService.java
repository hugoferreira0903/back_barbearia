package br.com.dio.barber_shop_iu.service.query.impl;

import br.com.dio.barber_shop_iu.entity.ScheduleEntity;
import br.com.dio.barber_shop_iu.exception.NotFoundException;
import br.com.dio.barber_shop_iu.exception.ScheduleInUseException;
import br.com.dio.barber_shop_iu.repository.IScheduleRepository;
import br.com.dio.barber_shop_iu.service.query.IScheduleQueryService;
import org.springframework.stereotype.Repository;


import java.time.OffsetDateTime;
import java.util.List;

@Repository
public class ScheduleQueryService implements IScheduleQueryService {

    private final IScheduleRepository repository;

    public ScheduleQueryService(IScheduleRepository repository) {
        this.repository = repository;
    }


    @Override
    public ScheduleEntity findById(final long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Agendamento não encontrado")
        );
    }

    @Override
    public List<ScheduleEntity> findInMonth(final OffsetDateTime startAt, final OffsetDateTime endAt) {
        return repository.findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtAscEndAtAsc(startAt, endAt);
    }

    @Override
    public void verifyIfScheduleExists(final OffsetDateTime startAt, final OffsetDateTime endAt) {
        if (repository.existsByStartAtAndEndAt(startAt, endAt)){
            var message = "Já existe um cliente agendado no horário solicitado";
            throw new ScheduleInUseException(message);
        }
    }
}
