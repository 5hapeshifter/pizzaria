package com.pizzaria.framework.adapter.out;

import com.pizzaria.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositoryAdapter extends JpaRepository<Customer, Long> {

}
