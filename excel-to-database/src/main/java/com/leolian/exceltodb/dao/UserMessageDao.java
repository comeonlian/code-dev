package com.leolian.exceltodb.dao;

import com.leolian.exceltodb.entity.UserMessage;
import com.leolian.exceltodb.util.DataSourceUtils;
import org.apache.commons.compress.utils.Sets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * @author Administrator
 * @description:
 * @date 2025/6/5 20:35
 */
public class UserMessageDao {

    private final static String INSERT_SQL = "insert into user_message_aiqicha(" +
            "company_name, person_name, position, profession, contact, contact_status, qq_number, email, address, register_capital, register_date, query_condition, remark, create_date) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,curdate())";

    private final static String QUERY_DISTINCT_COMPANY_NAME = "SELECT DISTINCT company_name " +
            "FROM user_message_aiqicha;";
    
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
            ps.setString(12, userMessage.getQueryCondition());
            ps.setString(13, userMessage.getRemark());
            ps.addBatch();
            if (i % 500 == 0) {
                ps.executeBatch();
                ps.clearBatch();
            }
        }
        ps.executeBatch();
        conn.commit();
    }

    public Set<String> queryDistinctCompanyNameList() throws SQLException {
        Connection conn = DataSourceUtils.getConnection();
        Set<String> companyNameSet = Sets.newHashSet();
        PreparedStatement statement = conn.prepareStatement(QUERY_DISTINCT_COMPANY_NAME);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String companyName = resultSet.getString("company_name");
            companyNameSet.add(companyName);
        }
        resultSet.close();
        statement.close();
        return companyNameSet;
    }

}
