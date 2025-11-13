package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferCodeImplDiffblueTest {
  @Autowired private OfferCodeImpl offerCodeImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferCodeImpl#setEmailAddress(String)}
   *   <li>{@link OfferCodeImpl#setEndDate(Date)}
   *   <li>{@link OfferCodeImpl#setId(Long)}
   *   <li>{@link OfferCodeImpl#setOfferCode(String)}
   *   <li>{@link OfferCodeImpl#setOrders(List)}
   *   <li>{@link OfferCodeImpl#setStartDate(Date)}
   *   <li>{@link OfferCodeImpl#setUses(int)}
   *   <li>{@link OfferCodeImpl#getEmailAddress()}
   *   <li>{@link OfferCodeImpl#getEndDate()}
   *   <li>{@link OfferCodeImpl#getId()}
   *   <li>{@link OfferCodeImpl#getOfferCode()}
   *   <li>{@link OfferCodeImpl#getOrders()}
   *   <li>{@link OfferCodeImpl#getStartDate()}
   *   <li>{@link OfferCodeImpl#getUses()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String OfferCodeImpl.getEmailAddress()",
    "Date OfferCodeImpl.getEndDate()",
    "Long OfferCodeImpl.getId()",
    "String OfferCodeImpl.getOfferCode()",
    "List OfferCodeImpl.getOrders()",
    "Date OfferCodeImpl.getStartDate()",
    "int OfferCodeImpl.getUses()",
    "void OfferCodeImpl.setEmailAddress(String)",
    "void OfferCodeImpl.setEndDate(Date)",
    "void OfferCodeImpl.setId(Long)",
    "void OfferCodeImpl.setOfferCode(String)",
    "void OfferCodeImpl.setOrders(List)",
    "void OfferCodeImpl.setStartDate(Date)",
    "void OfferCodeImpl.setUses(int)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();

    // Act
    offerCodeImpl.setEmailAddress("42 Main St");
    Date endDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    offerCodeImpl.setEndDate(endDate);
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setOfferCode("Offer Code");
    ArrayList<Order> orders = new ArrayList<>();
    offerCodeImpl.setOrders(orders);
    Date startDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    offerCodeImpl.setStartDate(startDate);
    offerCodeImpl.setUses(1);
    String actualEmailAddress = offerCodeImpl.getEmailAddress();
    Date actualEndDate = offerCodeImpl.getEndDate();
    Long actualId = offerCodeImpl.getId();
    String actualOfferCode = offerCodeImpl.getOfferCode();
    List<Order> actualOrders = offerCodeImpl.getOrders();
    Date actualStartDate = offerCodeImpl.getStartDate();

    // Assert
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("Offer Code", actualOfferCode);
    assertEquals(1, offerCodeImpl.getUses());
    assertTrue(actualOrders.isEmpty());
    assertEquals(OfferCodeImpl.serialVersionUID, actualId.longValue());
    assertSame(orders, actualOrders);
    assertSame(endDate, actualEndDate);
    assertSame(startDate, actualStartDate);
  }

  /**
   * Test {@link OfferCodeImpl#equals(Object)}, and {@link OfferCodeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferCodeImpl#equals(Object)}
   *   <li>{@link OfferCodeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.equals(Object)", "int OfferCodeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);

    OfferCodeImpl offerCodeImpl2 = new OfferCodeImpl();
    offerCodeImpl2.setEmailAddress("42 Main St");
    offerCodeImpl2.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl2.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl2.setMaxUses(3);
    offerCodeImpl2.setOfferCode("Offer Code");
    offerCodeImpl2.setOrders(new ArrayList<>());
    offerCodeImpl2.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl2.setUses(1);

    // Act and Assert
    assertEquals(offerCodeImpl, offerCodeImpl2);
    assertEquals(offerCodeImpl.hashCode(), offerCodeImpl2.hashCode());
  }

  /**
   * Test {@link OfferCodeImpl#equals(Object)}, and {@link OfferCodeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferCodeImpl#equals(Object)}
   *   <li>{@link OfferCodeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.equals(Object)", "int OfferCodeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);

    // Act and Assert
    assertEquals(offerCodeImpl, offerCodeImpl);
    int expectedHashCodeResult = offerCodeImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerCodeImpl.hashCode());
  }

  /**
   * Test {@link OfferCodeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.equals(Object)", "int OfferCodeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("17 High St");
    offerCodeImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);

    OfferCodeImpl offerCodeImpl2 = new OfferCodeImpl();
    offerCodeImpl2.setEmailAddress("42 Main St");
    offerCodeImpl2.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl2.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl2.setMaxUses(3);
    offerCodeImpl2.setOfferCode("Offer Code");
    offerCodeImpl2.setOrders(new ArrayList<>());
    offerCodeImpl2.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl2.setUses(1);

    // Act and Assert
    assertNotEquals(offerCodeImpl, offerCodeImpl2);
  }

  /**
   * Test {@link OfferCodeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.equals(Object)", "int OfferCodeImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);

    // Act and Assert
    assertNotEquals(offerCodeImpl, null);
  }

  /**
   * Test {@link OfferCodeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferCodeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCodeImpl.equals(Object)", "int OfferCodeImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);

    // Act and Assert
    assertNotEquals(offerCodeImpl, "Different type to OfferCodeImpl");
  }

  /**
   * Test new {@link OfferCodeImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OfferCodeImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferCodeImpl.<init>()"})
  public void testNewOfferCodeImpl() {
    // Arrange and Act
    OfferCodeImpl actualOfferCodeImpl = new OfferCodeImpl();

    // Assert
    assertEquals('N', actualOfferCodeImpl.getArchived().charValue());
    assertNull(actualOfferCodeImpl.maxUses);
    assertNull(actualOfferCodeImpl.getId());
    assertNull(actualOfferCodeImpl.getEmailAddress());
    assertNull(actualOfferCodeImpl.getOfferCode());
    assertNull(actualOfferCodeImpl.getEndDate());
    assertNull(actualOfferCodeImpl.getStartDate());
    assertNull(actualOfferCodeImpl.getOffer());
    assertNull(actualOfferCodeImpl.deproxiedOffer);
    assertNull(actualOfferCodeImpl.offer);
    assertNull(actualOfferCodeImpl.sbClonedOffer);
    assertEquals(0, actualOfferCodeImpl.getMaxUses());
    assertEquals(0, actualOfferCodeImpl.getUses());
    assertFalse(actualOfferCodeImpl.isLimitedUse());
    assertTrue(actualOfferCodeImpl.getOrders().isEmpty());
    assertTrue(actualOfferCodeImpl.isUnlimitedUse());
  }
}
