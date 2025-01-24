package org.broadleafcommerce.cms.page.message.jms;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import javax.jms.Destination;
import org.broadleafcommerce.cms.page.domain.Page;
import org.broadleafcommerce.cms.page.domain.PageImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {JMSArchivedPagePublisher.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class JMSArchivedPagePublisherDiffblueTest {
  @Autowired
  private JMSArchivedPagePublisher jMSArchivedPagePublisher;

  /**
   * Test {@link JMSArchivedPagePublisher#processPageArchive(Page, String)}.
   * <ul>
   *   <li>Given {@link JmsTemplate}
   * {@link JmsTemplate#send(Destination, MessageCreator)} does nothing.</li>
   *   <li>Then calls {@link JmsTemplate#send(Destination, MessageCreator)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JMSArchivedPagePublisher#processPageArchive(Page, String)}
   */
  @Test
  public void testProcessPageArchive_givenJmsTemplateSendDoesNothing_thenCallsSend() throws JmsException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JmsTemplate archivePageTemplate = mock(JmsTemplate.class);
    doNothing().when(archivePageTemplate).send(Mockito.<Destination>any(), Mockito.<MessageCreator>any());

    JMSArchivedPagePublisher jmsArchivedPagePublisher = new JMSArchivedPagePublisher();
    jmsArchivedPagePublisher.setArchivePageTemplate(archivePageTemplate);

    // Act
    jmsArchivedPagePublisher.processPageArchive(new PageImpl(), "Base Page Key");

    // Assert
    verify(archivePageTemplate).send((Destination) isNull(), isA(MessageCreator.class));
  }

  /**
   * Test {@link JMSArchivedPagePublisher#processPageArchive(Page, String)}.
   * <ul>
   *   <li>When {@link PageImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JMSArchivedPagePublisher#processPageArchive(Page, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testProcessPageArchive_whenPageImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.cms.page.message.jms.JMSArchivedPagePublisher.processPageArchive(JMSArchivedPagePublisher.java:50)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    jMSArchivedPagePublisher.processPageArchive(new PageImpl(), "Base Page Key");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link JMSArchivedPagePublisher}
   *   <li>{@link JMSArchivedPagePublisher#setArchivePageDestination(Destination)}
   *   <li>{@link JMSArchivedPagePublisher#setArchivePageTemplate(JmsTemplate)}
   *   <li>{@link JMSArchivedPagePublisher#getArchivePageDestination()}
   *   <li>{@link JMSArchivedPagePublisher#getArchivePageTemplate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    JMSArchivedPagePublisher actualJmsArchivedPagePublisher = new JMSArchivedPagePublisher();
    actualJmsArchivedPagePublisher.setArchivePageDestination(null);
    JmsTemplate archivePageTemplate = new JmsTemplate();
    actualJmsArchivedPagePublisher.setArchivePageTemplate(archivePageTemplate);
    actualJmsArchivedPagePublisher.getArchivePageDestination();

    // Assert that nothing has changed
    assertSame(archivePageTemplate, actualJmsArchivedPagePublisher.getArchivePageTemplate());
  }
}
