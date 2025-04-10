package com.cakmak.abc.billing.repository;

import com.cakmak.abc.billing.repository.dao.AddressDao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author: Halil Cakmak,
 * Date : 2019-09-20
 */
public interface AddressRepository extends CrudRepository<AddressDao, String> {

    Optional<List<AddressDao>> findByUserId(String userId);

    Optional<AddressDao> findByAddressId(String addressId);

    Boolean existsByUserId(String userId);
    
}
