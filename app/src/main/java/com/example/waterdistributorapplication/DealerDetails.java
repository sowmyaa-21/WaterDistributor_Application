package com.example.waterdistributorapplication;

public class DealerDetails {
    String dealername;
    String dealercompanyname;
    String dealerlocation;
    String dealerphonenumber;
    public DealerDetails(){

    }

    public DealerDetails(String dealername, String dealercompanyname, String dealerlocation, String dealerphonenumber) {
        this.dealername = dealername;
        this.dealercompanyname = dealercompanyname;
        this.dealerlocation = dealerlocation;
        this.dealerphonenumber = dealerphonenumber;
    }

    public String getDealername() {
        return dealername;
    }

    public void setDealername(String dealername) {
        this.dealername = dealername;
    }

    public String getDealercompanyname() {
        return dealercompanyname;
    }

    public void setDealercompanyname(String dealercompanyname) {
        this.dealercompanyname = dealercompanyname;
    }

    public String getDealerlocation() {
        return dealerlocation;
    }

    public void setDealerlocation(String dealerlocation) {
        this.dealerlocation = dealerlocation;
    }

    public String getDealerphonenumber() {
        return dealerphonenumber;
    }

    public void setDealerphonenumber(String dealerphonenumber) {
        this.dealerphonenumber = dealerphonenumber;
    }
}
