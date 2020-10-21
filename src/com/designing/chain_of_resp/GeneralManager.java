package com.designing.chain_of_resp;

public class GeneralManager extends Handler{
    @Override
    public String handleFreeRequest(String user, double free) {
        String str = "";
        if (free >= 1000){
            if ("small".equals(user)){
                str = "success: lager同意" + user + "的费用, money为" + free + "元";
            } else {
                str = "fail: lager不同意" + user + "的费用, money为" + free + "元";
            }
        } else {
            if (getSuccessor() != null){
                return getSuccessor().handleFreeRequest(user, free);
            }
        }
        return str;
    }
}
