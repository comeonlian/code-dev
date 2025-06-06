package com.leolian.exceltodb.dao;

import com.leolian.exceltodb.entity.UserMessage;
import com.leolian.exceltodb.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Administrator
 * @description:
 * @date 2025/6/5 20:35
 */
public class UserMessageDao {

    private final static String INSERT_SQL = "insert into user_message_aiqicha(" +
            "company_name, person_name, position, profession, contact, contact_status, qq_number, email, address, register_capital, register_date, remark) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?)";

    public void insertBatch(List<UserMessage> userMessageList) throws SQLException {
        Connection conn = DataSourceUtils.getConnection();
        conn.setAutoCommit(false);
        PreparedStatement ps = conn.prepareStatement(INSERT_SQL);
        for (int i = 0; i < userMessageList.size(); i++) {
            UserMessage userMessage = userMessageList.get(i);

            ps.setString(1, userMessage.getCompanyName());
            ps.setString(2, userMessage.getPersonName());
            ps.setString(3, userMessage.getPosition());
            ps.setString(4, userMessage.getProfession());
            ps.setLong(5, userMessage.getContact());
            ps.setInt(6, userMessage.getContactStatus());
            ps.setString(7, userMessage.getQqNumber());
            ps.setString(8, userMessage.getEmail());
            ps.setString(9, userMessage.getAddress());
            ps.setString(10, userMessage.getRegisterCapital());
            ps.setDate(11, new java.sql.Date(userMessage.getRegisterDate().getTime()));
            ps.setString(12, userMessage.getRemark());
            ps.addBatch();
            if (i % 500 == 0) {
                ps.executeBatch();
                ps.clearBatch();
            }
        }
        ps.executeBatch();
        conn.commit();
    }

}
