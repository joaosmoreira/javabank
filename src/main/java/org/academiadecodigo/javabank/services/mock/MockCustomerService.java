package org.academiadecodigo.javabank.services.mock;

import org.academiadecodigo.javabank.persistence.model.AbstractModel;
import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.persistence.model.Recipient;
import org.academiadecodigo.javabank.persistence.model.account.Account;
import org.academiadecodigo.javabank.services.CustomerService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MockCustomerService extends AbstractMockService<Customer> implements CustomerService {

    @Override
    public Customer get(Integer id) {
        return modelMap.get(id);
    }

    @Override
    public double getBalance(Integer customerId) {

        List<Account> accounts = modelMap.get(customerId).getAccounts();

        return accounts.stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }

    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {

        List<Account> accounts = modelMap.get(id).getAccounts();

        return accounts.stream()
                .map(AbstractModel::getId)
                .collect(Collectors.toSet());
    }

    @Override
    public List<Recipient> listRecipients(Integer id) {
        return modelMap.get(id).getRecipients();
    }
    
    @Override
    public List<Customer> findAll () {
        return null;
    }
}
