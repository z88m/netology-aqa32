package ru.netology.testUtils;

import lombok.Value;
import lombok.val;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCode(String dbUrl, String dbUser, String dbPass, String user) throws SQLException {
        val selectCode = "SELECT code FROM app.auth_codes\n" +
                "WHERE user_id = (SELECT id FROM app.users WHERE login='" + user + "')  ORDER BY created DESC LIMIT 1;";

        try (val conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            val statement = conn.createStatement();
            try (val resultSet = statement.executeQuery(selectCode)) {
                String code = "";
                while (resultSet.next()) {
                    code = resultSet.getString(1);
                }
                return new VerificationCode(code);
            }
        }
    }
}