package com.leolian.exceltodb.service;

import com.leolian.exceltodb.entity.ContactStatus;
import com.leolian.exceltodb.entity.UserMessage;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @description:
 * @date 2025/6/10 14:07
 */
public abstract class AbstractExcelToDatabaseService {

    public String split = "、";

    // 定义日期格式
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public String sourceFileDir = "H:/File/Msg/";
    
    /**
     * @param contacts
     * @return
     */
    public List<UserMessage> parseContactResult(String contacts) {
        String[] strArray = contacts.split(split);

        List<UserMessage> numberList = Lists.newArrayList();
        for (String str : strArray) {
            str = str.trim();
            if (str.length() < 11) {
                continue;
            }
            String number = str.substring(0, 11);
            String desc = str.substring(12, str.length() - 1);

            ContactStatus status = ContactStatus.find(desc);
            if (null == status) {
                System.out.println("手机号号码状态未识别: " + number + ", " + desc);
                continue;
            }
            UserMessage userMessage = new UserMessage();
            userMessage.setContact(Long.parseLong(number));
            userMessage.setContactStatus(status.getStatus());

            numberList.add(userMessage);
        }
        return numberList;
    }

    public Date parseDate(String format) {
        if (StringUtils.isBlank(format)) {
            return null;
        }
        try {
            return simpleDateFormat.parse(format);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
