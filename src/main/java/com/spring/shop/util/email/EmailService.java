package com.spring.shop.util.email;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);
}