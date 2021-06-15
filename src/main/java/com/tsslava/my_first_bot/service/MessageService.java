package com.tsslava.my_first_bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessageService {

    @Autowired
    Tracker tracker;

    public SendMessage unUpdateReceived (Update update) throws Exception {
        SendMessage sendMessage = new SendMessage();
        if (update != null) {
            Message message = update.getMessage();
            sendMessage.setChatId(message.getChatId());
            if (message!= null && message.hasText()) {
                String magText = message.getText();
                if (magText.equals("/start")) {
                    return sendMessage.setText("Добрый день!\nВведите номер почтового отправления:");
                }
                if (message.hasText()) {
                    return sendMessage.setText(tracker.trackInfo(message.getText()));
                }
            }

        }
        return sendMessage.setText("I don't understand");
    }
}
