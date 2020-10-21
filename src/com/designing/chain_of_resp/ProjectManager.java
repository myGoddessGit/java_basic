package com.designing.chain_of_resp;

/**
 * 具体处理者角色
 */
public class ProjectManager extends Handler{
    @Override
    public String handleFreeRequest(String user, double free) {
        String str = "";
        if (free < 500){
            if ("small".equals(user)){
                str = "success: small同意" + user + "的费用, money为" + free + "元";
            } else {
                str = "fail: small不同意" + user + "的费用, money为" + free + "元";
            }
        } else {
            if (getSuccessor() != null){
                return getSuccessor().handleFreeRequest(user, free);
            }
        }
        return str;
    }
}
