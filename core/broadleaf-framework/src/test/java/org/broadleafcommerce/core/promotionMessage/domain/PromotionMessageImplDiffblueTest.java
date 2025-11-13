package org.broadleafcommerce.core.promotionMessage.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.core.catalog.domain.CategoryMediaXrefImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PromotionMessageImplDiffblueTest {
  @Autowired private PromotionMessageImpl promotionMessageImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PromotionMessageImpl#setEndDate(Date)}
   *   <li>{@link PromotionMessageImpl#setId(Long)}
   *   <li>{@link PromotionMessageImpl#setLocale(Locale)}
   *   <li>{@link PromotionMessageImpl#setMedia(Media)}
   *   <li>{@link PromotionMessageImpl#setMessage(String)}
   *   <li>{@link PromotionMessageImpl#setMessagePlacement(String)}
   *   <li>{@link PromotionMessageImpl#setName(String)}
   *   <li>{@link PromotionMessageImpl#setPriority(Integer)}
   *   <li>{@link PromotionMessageImpl#setStartDate(Date)}
   *   <li>{@link PromotionMessageImpl#getEndDate()}
   *   <li>{@link PromotionMessageImpl#getId()}
   *   <li>{@link PromotionMessageImpl#getLocale()}
   *   <li>{@link PromotionMessageImpl#getMedia()}
   *   <li>{@link PromotionMessageImpl#getMessage()}
   *   <li>{@link PromotionMessageImpl#getMessagePlacement()}
   *   <li>{@link PromotionMessageImpl#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Date PromotionMessageImpl.getEndDate()",
    "Long PromotionMessageImpl.getId()",
    "Locale PromotionMessageImpl.getLocale()",
    "Media PromotionMessageImpl.getMedia()",
    "String PromotionMessageImpl.getMessage()",
    "String PromotionMessageImpl.getMessagePlacement()",
    "String PromotionMessageImpl.getName()",
    "void PromotionMessageImpl.setEndDate(Date)",
    "void PromotionMessageImpl.setId(Long)",
    "void PromotionMessageImpl.setLocale(Locale)",
    "void PromotionMessageImpl.setMedia(Media)",
    "void PromotionMessageImpl.setMessage(String)",
    "void PromotionMessageImpl.setMessagePlacement(String)",
    "void PromotionMessageImpl.setName(String)",
    "void PromotionMessageImpl.setPriority(Integer)",
    "void PromotionMessageImpl.setStartDate(Date)"
  })
  public void testGettersAndSetters() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    Date endDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    promotionMessageImpl.setEndDate(endDate);
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    LocaleImpl locale = new LocaleImpl();
    promotionMessageImpl.setLocale(locale);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessageImpl.setMedia(media);
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Date actualEndDate = promotionMessageImpl.getEndDate();
    Long actualId = promotionMessageImpl.getId();
    Locale actualLocale = promotionMessageImpl.getLocale();
    Media actualMedia = promotionMessageImpl.getMedia();
    String actualMessage = promotionMessageImpl.getMessage();
    String actualMessagePlacement = promotionMessageImpl.getMessagePlacement();

    // Assert
    assertEquals("Message Location", actualMessagePlacement);
    assertEquals("Name", promotionMessageImpl.getName());
    assertEquals("Promotion Message", actualMessage);
    assertEquals(PromotionMessageImpl.serialVersionUID, actualId.longValue());
    assertSame(locale, actualLocale);
    assertSame(media, actualMedia);
    assertSame(endDate, actualEndDate);
  }

  /**
   * Test {@link PromotionMessageImpl#equals(Object)}, and {@link PromotionMessageImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PromotionMessageImpl#equals(Object)}
   *   <li>{@link PromotionMessageImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PromotionMessageImpl.equals(Object)",
    "int PromotionMessageImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl.setLocale(new LocaleImpl());
    promotionMessageImpl.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    PromotionMessageImpl promotionMessageImpl2 = new PromotionMessageImpl();
    promotionMessageImpl2.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl2.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl2.setLocale(new LocaleImpl());
    promotionMessageImpl2.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl2.setMessage("Promotion Message");
    promotionMessageImpl2.setMessagePlacement("Message Location");
    promotionMessageImpl2.setName("Name");
    promotionMessageImpl2.setPriority(1);
    promotionMessageImpl2.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertEquals(promotionMessageImpl, promotionMessageImpl2);
    assertEquals(promotionMessageImpl.hashCode(), promotionMessageImpl2.hashCode());
  }

  /**
   * Test {@link PromotionMessageImpl#equals(Object)}, and {@link PromotionMessageImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PromotionMessageImpl#equals(Object)}
   *   <li>{@link PromotionMessageImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PromotionMessageImpl.equals(Object)",
    "int PromotionMessageImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl.setLocale(new LocaleImpl());
    promotionMessageImpl.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertEquals(promotionMessageImpl, promotionMessageImpl);
    int expectedHashCodeResult = promotionMessageImpl.hashCode();
    assertEquals(expectedHashCodeResult, promotionMessageImpl.hashCode());
  }

  /**
   * Test {@link PromotionMessageImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PromotionMessageImpl.equals(Object)",
    "int PromotionMessageImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(2L);
    promotionMessageImpl.setLocale(new LocaleImpl());
    promotionMessageImpl.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    PromotionMessageImpl promotionMessageImpl2 = new PromotionMessageImpl();
    promotionMessageImpl2.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl2.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl2.setLocale(new LocaleImpl());
    promotionMessageImpl2.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl2.setMessage("Promotion Message");
    promotionMessageImpl2.setMessagePlacement("Message Location");
    promotionMessageImpl2.setName("Name");
    promotionMessageImpl2.setPriority(1);
    promotionMessageImpl2.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertNotEquals(promotionMessageImpl, promotionMessageImpl2);
  }

  /**
   * Test {@link PromotionMessageImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PromotionMessageImpl.equals(Object)",
    "int PromotionMessageImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl.setLocale(new LocaleImpl());
    promotionMessageImpl.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertNotEquals(promotionMessageImpl, null);
  }

  /**
   * Test {@link PromotionMessageImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PromotionMessageImpl.equals(Object)",
    "int PromotionMessageImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl.setLocale(new LocaleImpl());
    promotionMessageImpl.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertNotEquals(promotionMessageImpl, "Different type to PromotionMessageImpl");
  }

  /**
   * Test new {@link PromotionMessageImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PromotionMessageImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionMessageImpl.<init>()"})
  public void testNewPromotionMessageImpl() {
    // Arrange and Act
    PromotionMessageImpl actualPromotionMessageImpl = new PromotionMessageImpl();

    // Assert
    assertEquals('N', actualPromotionMessageImpl.getArchived().charValue());
    assertNull(actualPromotionMessageImpl.priority);
    assertNull(actualPromotionMessageImpl.getId());
    assertNull(actualPromotionMessageImpl.getMainEntityName());
    assertNull(actualPromotionMessageImpl.getMessage());
    assertNull(actualPromotionMessageImpl.getMessagePlacement());
    assertNull(actualPromotionMessageImpl.getName());
    assertNull(actualPromotionMessageImpl.getEndDate());
    assertNull(actualPromotionMessageImpl.getStartDate());
    assertNull(actualPromotionMessageImpl.startDate);
    assertNull(actualPromotionMessageImpl.getLocale());
    assertNull(actualPromotionMessageImpl.getMedia());
    assertEquals(2147483646, actualPromotionMessageImpl.getPriority());
  }
}
