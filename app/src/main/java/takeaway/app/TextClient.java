package takeaway.app;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TextClient {
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public void sendMessage() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        LocalDateTime dateObject = LocalDateTime.now().plusHours(1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = dateObject.format(dtf);
        String text = "Thank you! Your order was placed and will be delivered before " + formattedTime;
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(System.getenv("FROM_NUMBER")),
                new com.twilio.type.PhoneNumber(System.getenv("TO_NUMBER")),
                text)
                .create();
    }

}
