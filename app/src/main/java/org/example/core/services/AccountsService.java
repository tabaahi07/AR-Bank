package org.example.core.services;
import org.example.commons.Enums.TransactionStatus;
import org.example.commons.Enums.TransactionType;
import org.example.core.dao.IAccountsDAO;
import org.example.core.data.Accounts;
import org.example.core.dto.TransactionReceipt;
import org.example.core.dto.TransactionReceipt.TransactionReceiptBuilder;

import com.google.common.base.Enums;

import java.time.* ;

import lombok.Builder;

import java.util.* ;

@Builder
public class AccountsService {
    private IAccountsDAO accountDAO ;

    public String createAccount(String customerId){
        String newAccountNumber = UUID.randomUUID().toString();
        Accounts newAccount = Accounts.builder().customerId(customerId).accountNumber(newAccountNumber).balance(0).issuedDate(LocalDate.now()).build() ;
        return accountDAO.createAccount(newAccountNumber , newAccount , customerId) ;
    }

    public Optional<List<Accounts>> geAccounts(String customerId){
        Optional<List<Accounts>> accountList = accountDAO.getAccounts(customerId) ;
        if(accountList.isEmpty()) return null ;
        return accountList ;
    }

    public TransactionReceipt setAccountBalance(String accountNumber , Integer amount , TransactionType transactionType){
        Optional<Accounts> accountDetail ;
        if(transactionType == TransactionType.DEPOSIT) accountDetail = accountDAO.setAccountBalance(accountNumber , amount) ;

        accountDetail = accountDAO.setAccountBalance(accountNumber , (-1*amount)) ;

        String transactionId = UUID.randomUUID().toString();

        TransactionStatus status = (accountDetail.isEmpty()) ? TransactionStatus.REJECTED : TransactionStatus.APPROVED ;

        return TransactionReceipt.builder().accountDetail(accountDetail).status(status).transactionDateAndTime(LocalDateTime.now()).transactionId(transactionId).build() ;
      
    }

    public Integer getBalance(String accountNumber){
        Optional<Accounts> userAccount = accountDAO.getBalance(accountNumber) ;
        if(userAccount.isEmpty()) return 0 ;
        return userAccount.get().getBalance() ;
    }
}
