package org.broadleafcommerce.cms.page.message.jms;

import javax.jms.Message;
import org.junit.Ignore;
import org.junit.Test;

public class JMSArchivedPageSubscriberDiffblueTest {
  /**
   * Test {@link JMSArchivedPageSubscriber#onMessage(Message)}.
   * <p>
   * Method under test: {@link JMSArchivedPageSubscriber#onMessage(Message)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOnMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.cms.page.message.jms.JMSArchivedPageSubscriber.onMessage(JMSArchivedPageSubscriber.java:47)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new JMSArchivedPageSubscriber()).onMessage(null);
  }

  /**
   * Test new {@link JMSArchivedPageSubscriber} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link JMSArchivedPageSubscriber}
   */
  @Test
  public void testNewJMSArchivedPageSubscriber() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     JMSArchivedPageSubscriber.pageService

    // Arrange and Act
    new JMSArchivedPageSubscriber();
  }
}
