package co.iud.iudigital.service;

public interface IEmailService {

	boolean sendEmail(String mensaje, String email, String asunto);
}