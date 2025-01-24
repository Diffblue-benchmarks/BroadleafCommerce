package org.broadleafcommerce.cms.structure.message.jms;

import javax.jms.Message;
import org.junit.Ignore;
import org.junit.Test;

public class JMSArchivedStructuredContentSubscriberDiffblueTest {
  /**
   * Test {@link JMSArchivedStructuredContentSubscriber#onMessage(Message)}.
   * <p>
   * Method under test:
   * {@link JMSArchivedStructuredContentSubscriber#onMessage(Message)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOnMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.cms.structure.message.jms.JMSArchivedStructuredContentSubscriber.onMessage(JMSArchivedStructuredContentSubscriber.java:49)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new JMSArchivedStructuredContentSubscriber()).onMessage(null);
  }

  /**
   * Test new {@link JMSArchivedStructuredContentSubscriber} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link JMSArchivedStructuredContentSubscriber}
   */
  @Test
  public void testNewJMSArchivedStructuredContentSubscriber() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     JMSArchivedStructuredContentSubscriber.structuredContentService

    // Arrange and Act
    new JMSArchivedStructuredContentSubscriber();
  }
}
