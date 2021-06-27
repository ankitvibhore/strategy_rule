package com.strategy;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;


public class Account
{
    private Long accNo;
    private String strategyid;

    public Account(Long accNo, String strategyid) {
        this.accNo = accNo;
        this.strategyid = strategyid;
    }

    public Long getAccNo() {
        return accNo;
    }

    public void setAccNo(Long accNo) {
        this.accNo = accNo;
    }

    public String getStrategyid() {
        return strategyid;
    }

    public void setStrategyid(String strategyid) {
        this.strategyid = strategyid;
    }
}
