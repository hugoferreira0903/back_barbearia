package br.com.dio.barber_shop_iu.repository;

import br.com.dio.barber_shop_iu.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientRepository extends JpaRepository<ClientEntity, Long> {

    boolean existsByEmail(final String email);

    Optional<ClientEntity> findByEmail(final String phone);

    boolean existsByPhone(final String email);

    Optional<ClientEntity> findByPhone(final String phone);

}
