/*-
 * #%L
 * BroadleafCommerce CMS Module
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
package org.broadleafcommerce.cms.structure.message.jms;

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
import org.broadleafcommerce.cms.structure.domain.StructuredContent;
import org.broadleafcommerce.cms.structure.domain.StructuredContentImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class JMSArchivedStructuredContentPublisherDiffblueTest {
  /**
   * Test {@link
   * JMSArchivedStructuredContentPublisher#processStructuredContentArchive(StructuredContent,
   * String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link JmsTemplate#send(Destination, MessageCreator)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JMSArchivedStructuredContentPublisher#processStructuredContentArchive(StructuredContent,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JMSArchivedStructuredContentPublisher.processStructuredContentArchive(StructuredContent, String, String)"
  })
  public void testProcessStructuredContentArchive_thenCallsSend() throws JmsException {
    // Arrange
    JmsTemplate archiveStructuredContentTemplate = mock(JmsTemplate.class);
    doNothing()
        .when(archiveStructuredContentTemplate)
        .send(Mockito.<Destination>any(), Mockito.<MessageCreator>any());

    JMSArchivedStructuredContentPublisher jmsArchivedStructuredContentPublisher =
        new JMSArchivedStructuredContentPublisher();
    jmsArchivedStructuredContentPublisher.setArchiveStructuredContentTemplate(
        archiveStructuredContentTemplate);

    // Act
    jmsArchivedStructuredContentPublisher.processStructuredContentArchive(
        new StructuredContentImpl(), "Base Name Key", "Base Type Key");

    // Assert
    verify(archiveStructuredContentTemplate)
        .send((Destination) isNull(), isA(MessageCreator.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link JMSArchivedStructuredContentPublisher}
   *   <li>{@link
   *       JMSArchivedStructuredContentPublisher#setArchiveStructuredContentDestination(Destination)}
   *   <li>{@link
   *       JMSArchivedStructuredContentPublisher#setArchiveStructuredContentTemplate(JmsTemplate)}
   *   <li>{@link JMSArchivedStructuredContentPublisher#getArchiveStructuredContentDestination()}
   *   <li>{@link JMSArchivedStructuredContentPublisher#getArchiveStructuredContentTemplate()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JMSArchivedStructuredContentPublisher.<init>()",
    "Destination JMSArchivedStructuredContentPublisher.getArchiveStructuredContentDestination()",
    "JmsTemplate JMSArchivedStructuredContentPublisher.getArchiveStructuredContentTemplate()",
    "void JMSArchivedStructuredContentPublisher.setArchiveStructuredContentDestination(Destination)",
    "void JMSArchivedStructuredContentPublisher.setArchiveStructuredContentTemplate(JmsTemplate)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    JMSArchivedStructuredContentPublisher actualJmsArchivedStructuredContentPublisher =
        new JMSArchivedStructuredContentPublisher();
    actualJmsArchivedStructuredContentPublisher.setArchiveStructuredContentDestination(null);
    JmsTemplate archiveStructuredContentTemplate = new JmsTemplate();
    actualJmsArchivedStructuredContentPublisher.setArchiveStructuredContentTemplate(
        archiveStructuredContentTemplate);
    Destination actualArchiveStructuredContentDestination =
        actualJmsArchivedStructuredContentPublisher.getArchiveStructuredContentDestination();

    // Assert
    assertNull(actualArchiveStructuredContentDestination);
    assertSame(
        archiveStructuredContentTemplate,
        actualJmsArchivedStructuredContentPublisher.getArchiveStructuredContentTemplate());
  }
}
