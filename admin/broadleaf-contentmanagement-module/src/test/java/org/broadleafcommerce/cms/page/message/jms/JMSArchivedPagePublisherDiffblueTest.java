package org.broadleafcommerce.cms.page.message.jms;

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
import javax.jms.Destination;
import org.broadleafcommerce.cms.page.domain.Page;
import org.broadleafcommerce.cms.page.domain.PageImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class JMSArchivedPagePublisherDiffblueTest {
  /**
   * Test {@link JMSArchivedPagePublisher#processPageArchive(Page, String)}.
   *
   * <ul>
   *   <li>Given {@link JmsTemplate} {@link JmsTemplate#send(Destination, MessageCreator)} does
   *       nothing.
   *   <li>Then calls {@link JmsTemplate#send(Destination, MessageCreator)}.
   * </ul>
   *
   * <p>Method under test: {@link JMSArchivedPagePublisher#processPageArchive(Page, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JMSArchivedPagePublisher.processPageArchive(Page, String)"})
  public void testProcessPageArchive_givenJmsTemplateSendDoesNothing_thenCallsSend()
      throws JmsException {
    // Arrange
    JmsTemplate archivePageTemplate = mock(JmsTemplate.class);
    doNothing()
        .when(archivePageTemplate)
        .send(Mockito.<Destination>any(), Mockito.<MessageCreator>any());

    JMSArchivedPagePublisher jmsArchivedPagePublisher = new JMSArchivedPagePublisher();
    jmsArchivedPagePublisher.setArchivePageTemplate(archivePageTemplate);

    // Act
    jmsArchivedPagePublisher.processPageArchive(new PageImpl(), "Base Page Key");

    // Assert
    verify(archivePageTemplate).send((Destination) isNull(), isA(MessageCreator.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link JMSArchivedPagePublisher}
   *   <li>{@link JMSArchivedPagePublisher#setArchivePageDestination(Destination)}
   *   <li>{@link JMSArchivedPagePublisher#setArchivePageTemplate(JmsTemplate)}
   *   <li>{@link JMSArchivedPagePublisher#getArchivePageDestination()}
   *   <li>{@link JMSArchivedPagePublisher#getArchivePageTemplate()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JMSArchivedPagePublisher.<init>()",
    "Destination JMSArchivedPagePublisher.getArchivePageDestination()",
    "JmsTemplate JMSArchivedPagePublisher.getArchivePageTemplate()",
    "void JMSArchivedPagePublisher.setArchivePageDestination(Destination)",
    "void JMSArchivedPagePublisher.setArchivePageTemplate(JmsTemplate)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    JMSArchivedPagePublisher actualJmsArchivedPagePublisher = new JMSArchivedPagePublisher();
    actualJmsArchivedPagePublisher.setArchivePageDestination(null);
    JmsTemplate archivePageTemplate = new JmsTemplate();
    actualJmsArchivedPagePublisher.setArchivePageTemplate(archivePageTemplate);
    Destination actualArchivePageDestination =
        actualJmsArchivedPagePublisher.getArchivePageDestination();

    // Assert
    assertNull(actualArchivePageDestination);
    assertSame(archivePageTemplate, actualJmsArchivedPagePublisher.getArchivePageTemplate());
  }
}
