package com.pizzaria.framework.adapter.out;

import com.pizzaria.domain.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositoryAdapter extends JpaRepository<Address, Long> {
}
