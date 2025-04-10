package com.cakmak.abc.payment.repository;

import com.cakmak.abc.payment.repository.dao.UserPaymentCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Halil Cakmak, Date : 14-Dec-2020
 */
@Repository
public interface UserPaymentCustomerRepository extends JpaRepository<UserPaymentCustomer, String> {

    UserPaymentCustomer findByUserId(String userId);
}
