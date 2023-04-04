package org.academiadecodigo.javabank.converters;

import org.academiadecodigo.javabank.command.AccountDto;
import org.academiadecodigo.javabank.persistence.model.account.Account;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountToAccountDto extends AbstractConverter<Account, AccountDto> {

    @Override
    public AccountDto convert(Account account) {

        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setCustomerId(account.getCustomer().getId());
        accountDto.setBalance(account.getBalance());
        accountDto.setType(account.getAccountType());

        return accountDto;
    }
}
