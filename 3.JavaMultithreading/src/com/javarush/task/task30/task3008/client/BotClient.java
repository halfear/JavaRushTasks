package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BotClient extends Client {
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public static void main(String[] args) {
        Client client = new BotClient();
        client.run();
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. " +
                    "Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);

            String[] strings = message.split(": ");
            if (strings.length != 2) return;

            String senderName = strings[0].trim();
            String messageText = strings[1].trim();
            Calendar calendar = new GregorianCalendar();
            DateFormat format = null;

            if (messageText.equals("дата"))
                format = new SimpleDateFormat("d.MM.YYYY");
            if (messageText.equals("день"))
                format = new SimpleDateFormat("d");
            if (messageText.equals("месяц"))
                format = new SimpleDateFormat("MMMM");
            if (messageText.equals("год"))
                format = new SimpleDateFormat("YYYY");
            if (messageText.equals("время"))
                format = new SimpleDateFormat("H:mm:ss");
            if (messageText.equals("час"))
                format = new SimpleDateFormat("H");
            if (messageText.equals("минуты"))
                format = new SimpleDateFormat("m");
            if (messageText.equals("секунды"))
                format = new SimpleDateFormat("s");

            if (format != null)
                sendTextMessage("Информация для " + senderName + ": " +
                        format.format(calendar.getTime()));
        }
    }
}
