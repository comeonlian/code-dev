package com.leolian.exceltodb.service;

import com.leolian.exceltodb.dao.ExcelDao;
import com.leolian.exceltodb.dao.UserMessageDao;
import com.leolian.exceltodb.entity.ContactStatus;
import com.leolian.exceltodb.entity.UserMessage;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @description:
 * @date 2025/6/5 20:54
 */
public class AiqichaExcelToDatabaseService {

    // 定义日期格式
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public String split = "、";

    public String sourceFile = "H:/File/Msg/20250606145143.xlsx";


    public static void main(String[] args) {
        UserMessageDao userMessageDao = new UserMessageDao();
        ExcelDao excelDao = new ExcelDao();

        AiqichaExcelToDatabaseService service = new AiqichaExcelToDatabaseService();
        try {
            XSSFSheet rSheet = excelDao.getXSSFSheet(service.sourceFile);
            XSSFRow row = null;
            List<UserMessage> messageList = Lists.newArrayList();
            for (int i = 1; i < rSheet.getPhysicalNumberOfRows(); i++) {
                row = rSheet.getRow(i);

                // 公司名称 企业法人 推荐号码 号码检测结果 注册资本 成立日期 公司地址 所属行业 邮箱 QQ
                String companyName = row.getCell(0).getStringCellValue().trim();
                String personName = row.getCell(1).getStringCellValue().trim();

                String registerCapital = row.getCell(4).getStringCellValue().trim();
                Date registerDate = service.parseDate(row.getCell(5).getStringCellValue().trim());
                String address = row.getCell(6).getStringCellValue().trim();

                String profession = row.getCell(7).getStringCellValue().trim();
                String email = row.getCell(8).getStringCellValue().trim();
                String qq = row.getCell(9).getStringCellValue().trim();

                String contactResult = row.getCell(3).getStringCellValue().trim();
                List<UserMessage> contacts = service.parseContactResult(contactResult);
                if (contacts.size() == 0) {
                    continue;
                }
                for (int j = 0; j < contacts.size(); j++) {
                    UserMessage contact = contacts.get(j);

                    contact.setCompanyName(companyName);
                    contact.setAddress(address);
                    contact.setEmail(email);
                    contact.setQqNumber(qq);
                    contact.setRegisterCapital(registerCapital);
                    contact.setRegisterDate(registerDate);

                    contact.setProfession(profession);
                    if (j > 0) {
                        contact.setPersonName(personName + j);
                    } else {
                        contact.setPersonName(personName);
                    }

                    messageList.add(contact);
                }
                if (messageList.size() > 5000) {
                    userMessageDao.insertBatch(messageList);
                    messageList = Lists.newArrayList();
                }
            }
            if (messageList.size() > 0) {
                userMessageDao.insertBatch(messageList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 15121016195(正常待机)、13818920677(正常待机)、18601609435(正常待机)、18036397700(沉默号码)、18330656699(关机)
     *
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
