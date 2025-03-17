package br.com.dio.barber_shop_iu.service;

import br.com.dio.barber_shop_iu.entity.ScheduleEntity;

public interface IScheduleService {

    ScheduleEntity save(final ScheduleEntity entity);

    void delete(final long id);


}
