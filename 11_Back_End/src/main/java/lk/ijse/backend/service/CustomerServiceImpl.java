package lk.ijse.backend.service;


import lk.ijse.backend.dto.CustomerDto;
import lk.ijse.backend.entity.Customer;
import lk.ijse.backend.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    
    @Override
    public void saveCustomer(CustomerDto customerDTO){
       customerRepository.save(new Customer(customerDTO.getcId(),
                                            customerDTO.getcName(),
                                            customerDTO.getcTel()));
    }


}