package com.example.demo.services.impls;

import com.example.demo.models.Account;
import com.example.demo.models.User;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepository;
    UserRepository userRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository,UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Double increaseBalance(Double balance,Long id) {
        User user =  userRepository.getUserById(id);
        if(user != null) {
            Account account = Account.builder().balance(balance).userId(user).build();
            accountRepository.save(account);
        }
        return balance;
    }
}
