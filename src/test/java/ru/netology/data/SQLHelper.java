package ru.netology.data;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import ru.netology.SQLentities.CreditRequestEntity;
import ru.netology.SQLentities.OrderEntity;
import ru.netology.SQLentities.PaymentEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
    private static final String url = System.getProperty("url");
    private static final String user = System.getProperty("user");
    private static final String password = System.getProperty("password");
    private static Connection conn;

    private static Connection getConnection() {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void cleanDb() {
        val runner = new QueryRunner();
        val creditRequest = "DELETE FROM credit_request_entity";
        val order = "DELETE FROM order_entity";
        val payment = "DELETE FROM payment_entity";

        try (val conn = getConnection()) {
            runner.update(conn, creditRequest);
            runner.update(conn, order);
            runner.update(conn, payment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getStatusForPaymentWithDebitCard() {
        val extractStatus = "SELECT * FROM payment_entity";
        val runner = new QueryRunner();
        try (val conn = getConnection()) {
            val debitCardStatus = runner.query(conn, extractStatus, new BeanHandler<>(PaymentEntity.class));
            return debitCardStatus.getStatus();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getStatusForPaymentWithCreditCard() {
        val extractStatus = "SELECT * FROM credit_request_entity";
        val runner = new QueryRunner();
        try (val conn = getConnection()) {
            val creditCardStatus = runner.query(conn, extractStatus, new BeanHandler<>(CreditRequestEntity.class));
            return creditCardStatus.getStatus();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPaymentId() {
        val extractTransactionId = "SELECT * FROM payment_entity";
        val runner = new QueryRunner();
        try (val conn = getConnection()) {
            val transactionId = runner.query(conn, extractTransactionId, new BeanHandler<>(PaymentEntity.class));
            return transactionId.getTransaction_id();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getCreditId() {
        val extractBankId = "SELECT * FROM credit_request_entity";
        val runner = new QueryRunner();
        try (val conn = getConnection()) {
            val bankId = runner.query(conn, extractBankId, new BeanHandler<>(CreditRequestEntity.class));
            return bankId.getBank_id();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getOrderPaymentId() {
        val extractPaymentId = "SELECT * FROM order_entity";
        val runner = new QueryRunner();
        try (val conn = getConnection()) {
            val paymentId = runner.query(conn, extractPaymentId, new BeanHandler<>(OrderEntity.class));
            return paymentId.getPayment_id();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getOrderCreditId() {
        val extractCreditId = "SELECT * FROM order_entity";
        val runner = new QueryRunner();
        try (val conn = getConnection()) {
            val paymentId = runner.query(conn, extractCreditId, new BeanHandler<>(OrderEntity.class));
            return paymentId.getPayment_id();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}