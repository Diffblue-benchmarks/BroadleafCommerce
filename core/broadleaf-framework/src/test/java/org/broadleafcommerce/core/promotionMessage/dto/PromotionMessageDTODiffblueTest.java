package org.broadleafcommerce.core.promotionMessage.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.experimental.categories.Category;

public class PromotionMessageDTODiffblueTest {
  /**
   * Test {@link PromotionMessageDTO#PromotionMessageDTO(PromotionMessage)}.
   *
   * <ul>
   *   <li>Then return MessagePlacement is {@code Message Location}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageDTO#PromotionMessageDTO(PromotionMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionMessageDTO.<init>(PromotionMessage)"})
  public void testNewPromotionMessageDTO_thenReturnMessagePlacementIsMessageLocation() {
    // Arrange
    PromotionMessageImpl promotionMessage = new PromotionMessageImpl();
    promotionMessage.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessage.setId(PromotionMessageImpl.serialVersionUID);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessage.setMedia(media);
    promotionMessage.setMessage("Promotion Message");
    promotionMessage.setMessagePlacement("Message Location");
    promotionMessage.setName("Name");
    promotionMessage.setPriority(1);
    promotionMessage.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   *
   * <ul>
   *   <li>When {@link PromotionMessageImpl} (default constructor).
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageDTO#PromotionMessageDTO(PromotionMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionMessageDTO.<init>(PromotionMessage)"})
  public void testNewPromotionMessageDTO_whenPromotionMessageImpl_thenReturnMessageIsNull() {
    // Arrange and Act
    PromotionMessageDTO actualPromotionMessageDTO =
        new PromotionMessageDTO(new PromotionMessageImpl());

    // Assert
    assertNull(actualPromotionMessageDTO.getMessage());
    assertNull(actualPromotionMessageDTO.getMessagePlacement());
    assertNull(actualPromotionMessageDTO.getEndDate());
    assertNull(actualPromotionMessageDTO.getMedia());
    assertEquals(2147483646, actualPromotionMessageDTO.getPriority().intValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerRuleHolder PromotionMessageDTO.getCustomerRuleHolder()",
    "Date PromotionMessageDTO.getEndDate()",
    "String PromotionMessageDTO.getLocaleCode()",
    "Media PromotionMessageDTO.getMedia()",
    "String PromotionMessageDTO.getMessage()",
    "String PromotionMessageDTO.getMessagePlacement()",
    "Integer PromotionMessageDTO.getPriority()",
    "void PromotionMessageDTO.setCustomerRuleHolder(CustomerRuleHolder)",
    "void PromotionMessageDTO.setEndDate(Date)",
    "void PromotionMessageDTO.setLocaleCode(String)",
    "void PromotionMessageDTO.setMedia(Media)",
    "void PromotionMessageDTO.setMessage(String)",
    "void PromotionMessageDTO.setMessagePlacement(String)",
    "void PromotionMessageDTO.setPriority(Integer)"
  })
  public void testGettersAndSetters() {
    // Arrange
    PromotionMessageDTO promotionMessageDTO = new PromotionMessageDTO(new PromotionMessageImpl());
    CustomerRuleHolder customerRuleHolder = new CustomerRuleHolder();

    // Act
    promotionMessageDTO.setCustomerRuleHolder(customerRuleHolder);
    Date endDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
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

    // Assert
    assertEquals("Message Placement", actualMessagePlacement);
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals("en", actualLocaleCode);
    assertNull(actualCustomerRuleHolder.getCustomerRule());
    assertEquals(1, promotionMessageDTO.getPriority().intValue());
    assertSame(media, actualMedia);
    assertSame(customerRuleHolder, actualCustomerRuleHolder);
    assertSame(endDate, actualEndDate);
  }
}
