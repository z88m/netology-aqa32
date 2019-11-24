package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.pages.DashboardPage;
import ru.netology.pages.LoginPage;
import ru.netology.testUtils.DataHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    private String testSite = "http://localhost:9999";
    private String testUser = "vasya";
    private String testUserPass = "qwerty123";
    private String dbUrl = "jdbc:mysql://localhost:3306/app";
    private String dbUser = "app";
    private String dbPass = "pass";

    @Test
    @DisplayName("Логин с валидными данными")
    void loginWithValideData() throws SQLException {
        open(testSite);
        val loginPage = new LoginPage();
        val authInfo = new DataHelper.AuthInfo(testUser, testUserPass);
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCode(dbUrl, dbUser, dbPass, testUser);
        DashboardPage dashboardPage = verificationPage.validVerify(verificationCode);
    }

    @DisplayName("Удаляем данные тестовых пользователей")
    void deleteTestUsers() throws SQLException {

        val deleteVasyaCards = "DELETE FROM app.cards\n" +
                "WHERE user_id=(SELECT id FROM app.users WHERE login='" + testUser + "');";
        val deleteVasya = "DELETE FROM app.users WHERE login='" + testUser + "';";
        val deletePetya = "DELETE FROM app.users WHERE login='petya';";
        val deleteVasyaCodes = "DELETE FROM app.auth_codes\n" +
                "WHERE user_id = (SELECT id FROM app.users WHERE login='" + testUser + "');";
        Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        Statement statement = conn.createStatement();
        statement.executeUpdate(deleteVasyaCards);
        statement.executeUpdate(deleteVasyaCodes);
        statement.executeUpdate(deleteVasya);
        statement.executeUpdate(deletePetya);
        conn.close();

    }
}