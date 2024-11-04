package org.example.core.services;
import org.example.commons.Enums.TransactionStatus;
import org.example.commons.Enums.TransactionType;
import org.example.core.data.Accounts;
import org.example.core.db.inmem.AccountsDAO;
import org.example.core.dto.TransactionReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.* ;
import lombok.Builder;
import java.util.* ;

@Builder
@Service
public class AccountsService {
    @Autowired
    private AccountsDAO accountDAO ;
    @Autowired
    private AuthService authService ;

    public String createAccount(String customerId , String accessToken){
        if(!authService.validateAccessToken(customerId, accessToken)) return null ;
        String newAccountNumber = UUID.randomUUID().toString();
        Accounts newAccount = Accounts.builder().
            customerId(customerId).
            accountNumber(newAccountNumber).
            balance(0).
            issuedDate(LocalDate.now()).
            build() ;

        return accountDAO.createAccount(newAccountNumber , newAccount , customerId) ;
    }

    public Optional<List<Accounts>> listAccounts(String customerId , String accessToken){
        if(!authService.validateAccessToken(customerId, accessToken)) return null ;
        Optional<List<Accounts>> accountList = accountDAO.listAccounts(customerId) ;
        if(accountList.isEmpty()) return null ;
        return accountList ;
    }

    public Optional<TransactionReceipt> setAccountBalance(String customerId , String accessToken , String accountNumber , Integer amount , TransactionType transactionType){
        if(!authService.validateAccessToken(customerId, accessToken)) return null ;
        Optional<Accounts> accountDetail ;
        if(transactionType == TransactionType.DEPOSIT) accountDetail = accountDAO.setAccountBalance(accountNumber , amount) ;

        else accountDetail = accountDAO.setAccountBalance(accountNumber , (-1*amount)) ;
        if(accountDetail == null) return null ;
        String transactionId = UUID.randomUUID().toString();

        TransactionStatus status = (accountDetail.isEmpty()) ? TransactionStatus.REJECTED : TransactionStatus.APPROVED ;

        return Optional.of(TransactionReceipt.builder().
            accountDetail(accountDetail).
            status(status).
            transactionDateAndTime(LocalDateTime.now()).
            transactionId(transactionId).
            build()) ;
    }

    public Integer getBalance(String customerId , String accessToken , String accountNumber){
        if(!authService.validateAccessToken(customerId, accessToken)) return null ;
        Optional<Accounts> userAccount = accountDAO.getBalance(accountNumber) ;
        if(userAccount.isEmpty()) return 0 ;
        return userAccount.get().getBalance() ;
    }
}
