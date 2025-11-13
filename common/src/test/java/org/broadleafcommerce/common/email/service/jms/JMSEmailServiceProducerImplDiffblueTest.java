package org.broadleafcommerce.common.email.service.jms;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import javax.jms.Destination;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class JMSEmailServiceProducerImplDiffblueTest {
  /**
   * Test {@link JMSEmailServiceProducerImpl#send(Map)}.
   *
   * <ul>
   *   <li>Given {@link JmsTemplate} {@link JmsTemplate#send(Destination, MessageCreator)} does
   *       nothing.
   *   <li>Then calls {@link JmsTemplate#send(Destination, MessageCreator)}.
   * </ul>
   *
   * <p>Method under test: {@link JMSEmailServiceProducerImpl#send(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JMSEmailServiceProducerImpl.send(Map)"})
  public void testSend_givenJmsTemplateSendDoesNothing_thenCallsSend() throws JmsException {
    // Arrange
    JmsTemplate emailServiceTemplate = mock(JmsTemplate.class);
    doNothing()
        .when(emailServiceTemplate)
        .send(Mockito.<Destination>any(), Mockito.<MessageCreator>any());

    JMSEmailServiceProducerImpl jmsEmailServiceProducerImpl = new JMSEmailServiceProducerImpl();
    jmsEmailServiceProducerImpl.setEmailServiceTemplate(emailServiceTemplate);

    // Act
    jmsEmailServiceProducerImpl.send(new HashMap<>());

    // Assert
    verify(emailServiceTemplate).send((Destination) isNull(), isA(MessageCreator.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link JMSEmailServiceProducerImpl}
   *   <li>{@link JMSEmailServiceProducerImpl#setEmailServiceDestination(Destination)}
   *   <li>{@link JMSEmailServiceProducerImpl#setEmailServiceTemplate(JmsTemplate)}
   *   <li>{@link JMSEmailServiceProducerImpl#getEmailServiceDestination()}
   *   <li>{@link JMSEmailServiceProducerImpl#getEmailServiceTemplate()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JMSEmailServiceProducerImpl.<init>()",
    "Destination JMSEmailServiceProducerImpl.getEmailServiceDestination()",
    "JmsTemplate JMSEmailServiceProducerImpl.getEmailServiceTemplate()",
    "void JMSEmailServiceProducerImpl.setEmailServiceDestination(Destination)",
    "void JMSEmailServiceProducerImpl.setEmailServiceTemplate(JmsTemplate)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    JMSEmailServiceProducerImpl actualJmsEmailServiceProducerImpl =
        new JMSEmailServiceProducerImpl();
    actualJmsEmailServiceProducerImpl.setEmailServiceDestination(null);
    JmsTemplate emailServiceTemplate = new JmsTemplate();
    actualJmsEmailServiceProducerImpl.setEmailServiceTemplate(emailServiceTemplate);
    Destination actualEmailServiceDestination =
        actualJmsEmailServiceProducerImpl.getEmailServiceDestination();

    // Assert
    assertNull(actualEmailServiceDestination);
    assertSame(emailServiceTemplate, actualJmsEmailServiceProducerImpl.getEmailServiceTemplate());
  }
}
