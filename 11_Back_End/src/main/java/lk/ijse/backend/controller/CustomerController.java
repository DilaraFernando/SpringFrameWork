package lk.ijse.backend.controller;

import lk.ijse.backend.dto.CustomerDto;
import lk.ijse.backend.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl customerService;

    //    public CustomerController(CustomerServiceImpl customerServiceImpl) {
//        this.customerServiceImpl = customerServiceImpl;
//    }
    @PostMapping
    public void saveCustomer(@RequestBody CustomerDto customerDto) {
        customerService.saveCustomer(customerDto);
        System.out.println("save customer");
    }
}