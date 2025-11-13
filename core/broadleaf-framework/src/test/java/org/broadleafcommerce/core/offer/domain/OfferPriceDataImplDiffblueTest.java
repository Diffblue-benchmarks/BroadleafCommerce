package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.offer.service.type.OfferPriceDataIdentifierType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferPriceDataImplDiffblueTest {
  @Autowired private OfferPriceDataImpl offerPriceDataImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferPriceDataImpl#setActiveEndDate(Date)}
   *   <li>{@link OfferPriceDataImpl#setActiveStartDate(Date)}
   *   <li>{@link OfferPriceDataImpl#setAmount(BigDecimal)}
   *   <li>{@link OfferPriceDataImpl#setId(Long)}
   *   <li>{@link OfferPriceDataImpl#setIdentifierValue(String)}
   *   <li>{@link OfferPriceDataImpl#setOffer(Offer)}
   *   <li>{@link OfferPriceDataImpl#setQuantity(Integer)}
   *   <li>{@link OfferPriceDataImpl#getActiveEndDate()}
   *   <li>{@link OfferPriceDataImpl#getActiveStartDate()}
   *   <li>{@link OfferPriceDataImpl#getAmount()}
   *   <li>{@link OfferPriceDataImpl#getId()}
   *   <li>{@link OfferPriceDataImpl#getIdentifierValue()}
   *   <li>{@link OfferPriceDataImpl#getOffer()}
   *   <li>{@link OfferPriceDataImpl#getQuantity()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Date OfferPriceDataImpl.getActiveEndDate()",
    "Date OfferPriceDataImpl.getActiveStartDate()",
    "BigDecimal OfferPriceDataImpl.getAmount()",
    "Long OfferPriceDataImpl.getId()",
    "String OfferPriceDataImpl.getIdentifierValue()",
    "Offer OfferPriceDataImpl.getOffer()",
    "Integer OfferPriceDataImpl.getQuantity()",
    "void OfferPriceDataImpl.setActiveEndDate(Date)",
    "void OfferPriceDataImpl.setActiveStartDate(Date)",
    "void OfferPriceDataImpl.setAmount(BigDecimal)",
    "void OfferPriceDataImpl.setId(Long)",
    "void OfferPriceDataImpl.setIdentifierValue(String)",
    "void OfferPriceDataImpl.setOffer(Offer)",
    "void OfferPriceDataImpl.setQuantity(Integer)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    Date activeEndDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    offerPriceDataImpl.setActiveEndDate(activeEndDate);
    Date activeStartDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    offerPriceDataImpl.setActiveStartDate(activeStartDate);
    BigDecimal amount = new BigDecimal("2.3");
    offerPriceDataImpl.setAmount(amount);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierValue("42");
    OfferImpl offer = new OfferImpl();
    offerPriceDataImpl.setOffer(offer);
    offerPriceDataImpl.setQuantity(1);
    Date actualActiveEndDate = offerPriceDataImpl.getActiveEndDate();
    Date actualActiveStartDate = offerPriceDataImpl.getActiveStartDate();
    BigDecimal actualAmount = offerPriceDataImpl.getAmount();
    Long actualId = offerPriceDataImpl.getId();
    String actualIdentifierValue = offerPriceDataImpl.getIdentifierValue();
    Offer actualOffer = offerPriceDataImpl.getOffer();

    // Assert
    assertEquals("42", actualIdentifierValue);
    assertEquals(1, offerPriceDataImpl.getQuantity().intValue());
    assertEquals(new BigDecimal("2.3"), actualAmount);
    assertEquals(OfferPriceDataImpl.serialVersionUID, actualId.longValue());
    assertSame(amount, actualAmount);
    assertSame(offer, actualOffer);
    assertSame(activeEndDate, actualActiveEndDate);
    assertSame(activeStartDate, actualActiveStartDate);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}, and {@link OfferPriceDataImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferPriceDataImpl#equals(Object)}
   *   <li>{@link OfferPriceDataImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertEquals(offerPriceDataImpl, offerPriceDataImpl2);
    assertEquals(offerPriceDataImpl.hashCode(), offerPriceDataImpl2.hashCode());
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}, and {@link OfferPriceDataImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferPriceDataImpl#equals(Object)}
   *   <li>{@link OfferPriceDataImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(null);
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(null);
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertEquals(offerPriceDataImpl, offerPriceDataImpl2);
    assertEquals(offerPriceDataImpl.hashCode(), offerPriceDataImpl2.hashCode());
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}, and {@link OfferPriceDataImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferPriceDataImpl#equals(Object)}
   *   <li>{@link OfferPriceDataImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    // Act and Assert
    assertEquals(offerPriceDataImpl, offerPriceDataImpl);
    int expectedHashCodeResult = offerPriceDataImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerPriceDataImpl.hashCode());
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(new Date());
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(null);
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(new Date());
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(BigDecimal.valueOf(OfferPriceDataImpl.serialVersionUID));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.FIX_PRICE);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(2L);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("Identifier Value");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setId(OfferImpl.serialVersionUID);

    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(offer);
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(0);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(new OfferDiscountType());
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(new OfferPriceDataIdentifierType());
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, null);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, "Different type to OfferPriceDataImpl");
  }

  /**
   * Test new {@link OfferPriceDataImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OfferPriceDataImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferPriceDataImpl.<init>()"})
  public void testNewOfferPriceDataImpl() {
    // Arrange and Act
    OfferPriceDataImpl actualOfferPriceDataImpl = new OfferPriceDataImpl();

    // Assert
    assertEquals('N', actualOfferPriceDataImpl.getArchived().charValue());
    assertNull(actualOfferPriceDataImpl.getQuantity());
    assertNull(actualOfferPriceDataImpl.getId());
    assertNull(actualOfferPriceDataImpl.getIdentifierValue());
    assertNull(actualOfferPriceDataImpl.discountType);
    assertNull(actualOfferPriceDataImpl.identifierType);
    assertNull(actualOfferPriceDataImpl.getAmount());
    assertNull(actualOfferPriceDataImpl.getActiveEndDate());
    assertNull(actualOfferPriceDataImpl.getActiveStartDate());
    assertNull(actualOfferPriceDataImpl.getOffer());
    assertNull(actualOfferPriceDataImpl.getDiscountType());
    assertNull(actualOfferPriceDataImpl.getIdentifierType());
  }
}
