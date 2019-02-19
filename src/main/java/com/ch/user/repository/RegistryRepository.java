package com.ch.user.repository;

import com.ch.user.domain.Registry;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Chen on 2019-02-06-23:52
 */
public interface RegistryRepository extends CrudRepository<Registry,Integer> {
    Registry findByUserName(String userName);
}
