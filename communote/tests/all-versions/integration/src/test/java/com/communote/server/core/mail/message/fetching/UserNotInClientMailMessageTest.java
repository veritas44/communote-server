package com.communote.server.core.mail.message.fetching;

import com.communote.server.core.mail.MailSender;
import com.communote.server.core.mail.messages.fetching.UserNotInClientMailMessage;
import com.communote.server.model.user.User;
import com.communote.server.test.mail.MailMessageCommunoteIntegrationTest;


/**
 * @author Communote GmbH - <a href="http://www.communote.com/">http://www.communote.com/</a>
 */
public class UserNotInClientMailMessageTest extends MailMessageCommunoteIntegrationTest {
    /**
     * {@inheritDoc}
     */
    @Override
    public void sendMail(MailSender mailSender, User... recipients) {
        for (User recipient : recipients) {
            mailSender.send(new UserNotInClientMailMessage(recipient.getEmail(), recipient
                    .getLanguageLocale()));
        }
    }
}
