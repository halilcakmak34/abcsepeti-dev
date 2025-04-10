package com.cakmak.abc.billing.service;

import com.cakmak.abc.billing.web.CreateAddressRequest;
import com.cakmak.abc.billing.web.GetAddressResponse;
import com.cakmak.abc.billing.web.UpdateAddressRequest;

import java.util.List;

/**
 * @author: Halil Cakmak, Date : 2019-09-27
 */
public interface AddressService {

  void createAddress(CreateAddressRequest createAddressRequest);

  List<GetAddressResponse> getAddress();

  void updateAddress(UpdateAddressRequest updateAddressRequest);

  GetAddressResponse getAddressById(String addressId);

  void deleteAddressById(String addressId);
}
