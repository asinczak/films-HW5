package pl.akademiastring.films.service;

public interface EmailService {

    void sendMessage(String to, String subject, String text);
}
