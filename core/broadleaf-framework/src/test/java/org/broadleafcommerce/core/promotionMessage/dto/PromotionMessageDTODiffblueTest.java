/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.promotionMessage.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.core.catalog.domain.CategoryMediaXrefImpl;
import org.broadleafcommerce.core.promotionMessage.domain.PromotionMessage;
import org.broadleafcommerce.core.promotionMessage.domain.PromotionMessageImpl;
import org.broadleafcommerce.profile.core.dto.CustomerRuleHolder;
import org.junit.Test;

public class PromotionMessageDTODiffblueTest {
  /**
   * Test {@link PromotionMessageDTO#PromotionMessageDTO(PromotionMessage)}.
   * <p>
   * Method under test:
   * {@link PromotionMessageDTO#PromotionMessageDTO(PromotionMessage)}
   */
  @Test
  public void testNewPromotionMessageDTO() {
    // Arrange
    PromotionMessageImpl promotionMessage = new PromotionMessageImpl();
    promotionMessage.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessage.setId(PromotionMessageImpl.serialVersionUID);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessage.setMedia(media);
    promotionMessage.setMessage("Promotion Message");
    promotionMessage.setMessagePlacement("Message Location");
    promotionMessage.setName("Name");
    promotionMessage.setPriority(1);
    promotionMessage
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessage.setLocale(new LocaleImpl());

    // Act
    PromotionMessageDTO actualPromotionMessageDTO = new PromotionMessageDTO(promotionMessage);

    // Assert
    assertEquals("Message Location", actualPromotionMessageDTO.getMessagePlacement());
    assertEquals("Promotion Message", actualPromotionMessageDTO.getMessage());
    assertEquals(1, actualPromotionMessageDTO.getPriority().intValue());
    assertSame(media, actualPromotionMessageDTO.getMedia());
  }

  /**
   * Test {@link PromotionMessageDTO#PromotionMessageDTO(PromotionMessage)}.
   * <ul>
   *   <li>Given {@link java.sql.Date}.</li>
   *   <li>When {@link PromotionMessageImpl} (default constructor) EndDate is
   * {@link java.sql.Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageDTO#PromotionMessageDTO(PromotionMessage)}
   */
  @Test
  public void testNewPromotionMessageDTO_givenDate_whenPromotionMessageImplEndDateIsDate() {
    // Arrange
    PromotionMessageImpl promotionMessage = new PromotionMessageImpl();
    promotionMessage.setEndDate(mock(java.sql.Date.class));
    promotionMessage.setId(PromotionMessageImpl.serialVersionUID);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessage.setMedia(media);
    promotionMessage.setMessage("Promotion Message");
    promotionMessage.setMessagePlacement("Message Location");
    promotionMessage.setName("Name");
    promotionMessage.setPriority(1);
    promotionMessage
        .setStartDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessage.setLocale(new LocaleImpl());

    // Act
    PromotionMessageDTO actualPromotionMessageDTO = new PromotionMessageDTO(promotionMessage);

    // Assert
    assertEquals("Message Location", actualPromotionMessageDTO.getMessagePlacement());
    assertEquals("Promotion Message", actualPromotionMessageDTO.getMessage());
    assertEquals(1, actualPromotionMessageDTO.getPriority().intValue());
    assertSame(media, actualPromotionMessageDTO.getMedia());
  }

  /**
   * Test {@link PromotionMessageDTO#PromotionMessageDTO(PromotionMessage)}.
   * <ul>
   *   <li>When {@link PromotionMessageImpl} (default constructor).</li>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageDTO#PromotionMessageDTO(PromotionMessage)}
   */
  @Test
  public void testNewPromotionMessageDTO_whenPromotionMessageImpl_thenReturnMessageIsNull() {
    // Arrange and Act
    PromotionMessageDTO actualPromotionMessageDTO = new PromotionMessageDTO(new PromotionMessageImpl());

    // Assert
    assertNull(actualPromotionMessageDTO.getMessage());
    assertNull(actualPromotionMessageDTO.getMessagePlacement());
    assertNull(actualPromotionMessageDTO.getEndDate());
    assertNull(actualPromotionMessageDTO.getMedia());
    assertEquals(2147483646, actualPromotionMessageDTO.getPriority().intValue());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PromotionMessageDTO#setCustomerRuleHolder(CustomerRuleHolder)}
   *   <li>{@link PromotionMessageDTO#setEndDate(Date)}
   *   <li>{@link PromotionMessageDTO#setLocaleCode(String)}
   *   <li>{@link PromotionMessageDTO#setMedia(Media)}
   *   <li>{@link PromotionMessageDTO#setMessage(String)}
   *   <li>{@link PromotionMessageDTO#setMessagePlacement(String)}
   *   <li>{@link PromotionMessageDTO#setPriority(Integer)}
   *   <li>{@link PromotionMessageDTO#getCustomerRuleHolder()}
   *   <li>{@link PromotionMessageDTO#getEndDate()}
   *   <li>{@link PromotionMessageDTO#getLocaleCode()}
   *   <li>{@link PromotionMessageDTO#getMedia()}
   *   <li>{@link PromotionMessageDTO#getMessage()}
   *   <li>{@link PromotionMessageDTO#getMessagePlacement()}
   *   <li>{@link PromotionMessageDTO#getPriority()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PromotionMessageDTO promotionMessageDTO = new PromotionMessageDTO(new PromotionMessageImpl());
    CustomerRuleHolder customerRuleHolder = new CustomerRuleHolder("Customer Rule");

    // Act
    promotionMessageDTO.setCustomerRuleHolder(customerRuleHolder);
    Date endDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    promotionMessageDTO.setEndDate(endDate);
    promotionMessageDTO.setLocaleCode("en");
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessageDTO.setMedia(media);
    promotionMessageDTO.setMessage("Not all who wander are lost");
    promotionMessageDTO.setMessagePlacement("Message Placement");
    promotionMessageDTO.setPriority(1);
    CustomerRuleHolder actualCustomerRuleHolder = promotionMessageDTO.getCustomerRuleHolder();
    Date actualEndDate = promotionMessageDTO.getEndDate();
    String actualLocaleCode = promotionMessageDTO.getLocaleCode();
    Media actualMedia = promotionMessageDTO.getMedia();
    String actualMessage = promotionMessageDTO.getMessage();
    String actualMessagePlacement = promotionMessageDTO.getMessagePlacement();
    Integer actualPriority = promotionMessageDTO.getPriority();

    // Assert that nothing has changed
    assertEquals("Customer Rule", actualCustomerRuleHolder.getCustomerRule());
    assertEquals("Message Placement", actualMessagePlacement);
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals("en", actualLocaleCode);
    assertEquals(1, actualPriority.intValue());
    assertSame(media, actualMedia);
    assertSame(customerRuleHolder, actualCustomerRuleHolder);
    assertSame(endDate, actualEndDate);
  }
}
