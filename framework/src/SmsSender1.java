import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.HashMap;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
public class SmsSender1 extends JFrame{
 
    /* Find your sid and token at twilio.com/user/account */
    public static final String ACCOUNT_SID = "ACcd5118bd20fd850167ba320ddb55a0a3";
    public static final String AUTH_TOKEN = "d2e9de675333dd5cf2c1937f719c89c4";
 
   public void SmsSender1() throws TwilioRestException {
 
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID,AUTH_TOKEN);
 
        Account account = client.getAccount();
 
        MessageFactory messageFactory = account.getMessageFactory();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("To","+919670139778")); // Replace with a valid phone number for your account.
        params.add(new BasicNameValuePair("From","+13205230830")); // Replace with a valid phone number for your account.
        params.add(new BasicNameValuePair("Body","pukgutiuolyuugki"));
        Message sms = messageFactory.create(params);
       System.out.println(sms);	
       JOptionPane.showMessageDialog(this, "successfully send to****");	
    }
}