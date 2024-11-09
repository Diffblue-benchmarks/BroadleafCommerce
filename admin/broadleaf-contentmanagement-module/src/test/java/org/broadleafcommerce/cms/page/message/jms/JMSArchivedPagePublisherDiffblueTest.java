/*-
 * #%L
 * BroadleafCommerce CMS Module
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
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
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class JMSArchivedPagePublisherDiffblueTest {
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
