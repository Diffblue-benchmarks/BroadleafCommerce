package org.broadleafcommerce.cms.structure.message.jms;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import javax.jms.Destination;
import org.broadleafcommerce.cms.structure.domain.StructuredContent;
import org.broadleafcommerce.cms.structure.domain.StructuredContentImpl;
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

@ContextConfiguration(classes = {JMSArchivedStructuredContentPublisher.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class JMSArchivedStructuredContentPublisherDiffblueTest {
  @Autowired
  private JMSArchivedStructuredContentPublisher jMSArchivedStructuredContentPublisher;

  /**
   * Test
   * {@link JMSArchivedStructuredContentPublisher#processStructuredContentArchive(StructuredContent, String, String)}.
   * <ul>
   *   <li>Then calls {@link JmsTemplate#send(Destination, MessageCreator)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JMSArchivedStructuredContentPublisher#processStructuredContentArchive(StructuredContent, String, String)}
   */
  @Test
  public void testProcessStructuredContentArchive_thenCallsSend() throws JmsException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JmsTemplate archiveStructuredContentTemplate = mock(JmsTemplate.class);
    doNothing().when(archiveStructuredContentTemplate).send(Mockito.<Destination>any(), Mockito.<MessageCreator>any());

    JMSArchivedStructuredContentPublisher jmsArchivedStructuredContentPublisher = new JMSArchivedStructuredContentPublisher();
    jmsArchivedStructuredContentPublisher.setArchiveStructuredContentTemplate(archiveStructuredContentTemplate);

    // Act
    jmsArchivedStructuredContentPublisher.processStructuredContentArchive(new StructuredContentImpl(), "Base Name Key",
        "Base Type Key");

    // Assert
    verify(archiveStructuredContentTemplate).send((Destination) isNull(), isA(MessageCreator.class));
  }

  /**
   * Test
   * {@link JMSArchivedStructuredContentPublisher#processStructuredContentArchive(StructuredContent, String, String)}.
   * <ul>
   *   <li>When {@link StructuredContentImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JMSArchivedStructuredContentPublisher#processStructuredContentArchive(StructuredContent, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testProcessStructuredContentArchive_whenStructuredContentImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.cms.structure.message.jms.JMSArchivedStructuredContentPublisher.processStructuredContentArchive(JMSArchivedStructuredContentPublisher.java:51)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    jMSArchivedStructuredContentPublisher.processStructuredContentArchive(new StructuredContentImpl(), "Base Name Key",
        "Base Type Key");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link JMSArchivedStructuredContentPublisher}
   *   <li>
   * {@link JMSArchivedStructuredContentPublisher#setArchiveStructuredContentDestination(Destination)}
   *   <li>
   * {@link JMSArchivedStructuredContentPublisher#setArchiveStructuredContentTemplate(JmsTemplate)}
   *   <li>
   * {@link JMSArchivedStructuredContentPublisher#getArchiveStructuredContentDestination()}
   *   <li>
   * {@link JMSArchivedStructuredContentPublisher#getArchiveStructuredContentTemplate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    JMSArchivedStructuredContentPublisher actualJmsArchivedStructuredContentPublisher = new JMSArchivedStructuredContentPublisher();
    actualJmsArchivedStructuredContentPublisher.setArchiveStructuredContentDestination(null);
    JmsTemplate archiveStructuredContentTemplate = new JmsTemplate();
    actualJmsArchivedStructuredContentPublisher.setArchiveStructuredContentTemplate(archiveStructuredContentTemplate);
    actualJmsArchivedStructuredContentPublisher.getArchiveStructuredContentDestination();

    // Assert that nothing has changed
    assertSame(archiveStructuredContentTemplate,
        actualJmsArchivedStructuredContentPublisher.getArchiveStructuredContentTemplate());
  }
}
