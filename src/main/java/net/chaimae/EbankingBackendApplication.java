package net.chaimae;

import net.chaimae.entities.Customer;
import net.chaimae.repositories.AccountOperationRepository;
import net.chaimae.repositories.BankAccountRepository;
import net.chaimae.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class EbankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankingBackendApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository,
        BankAccountRepository bankAccountRepository,
        AccountOperationRepository accountOperationRepository){
        return args -> {
            Stream.of("Chaimae", "Yassine", "Adnane").forEach(name -> {
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name + "@gmail.com");
                customerRepository.save(customer);
            });
        };
    }

}
