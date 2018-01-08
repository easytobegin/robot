package com.minisheep.service;

/**
 * Created by minisheep on 18/1/8.
 */
public interface LogService {
    public void saveChatLog(String openId, String createTime, String reqMsg, String respMsg, int chatCategory);
}
