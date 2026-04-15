package principal;
import Servicio.SistemaNotificaciones.*;
public class PruebaEmail {

    public static void main(String[] args) {

        EmailService emailService = new EmailService();

        emailService.enviarCorreo(
                "alvarosantiagopachon@gmail.com", // destino
                "Prueba de sistema",
                "Si recibiste esto, el envío de correo funciona correctamente desde Java."
        );
    }
}
