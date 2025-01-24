package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.offer.service.type.CustomerMaxUsesStrategyType;
import org.broadleafcommerce.core.offer.service.type.OfferAdjustmentType;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.offer.service.type.OfferItemRestrictionRuleType;
import org.broadleafcommerce.core.offer.service.type.OfferPriceDataIdentifierType;
import org.broadleafcommerce.core.offer.service.type.OfferType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferPriceDataImplDiffblueTest {
  @Autowired
  private OfferPriceDataImpl offerPriceDataImpl;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    Date activeEndDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    offerPriceDataImpl.setActiveEndDate(activeEndDate);
    Date activeStartDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
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

    // Assert that nothing has changed
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
   * Test {@link OfferPriceDataImpl#getIdentifierType()}.
   * <p>
   * Method under test: {@link OfferPriceDataImpl#getIdentifierType()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetIdentifierType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3367 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.domain.OfferPriceDataImpl offerPriceDataImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OfferPriceDataImpl()).getIdentifierType();
  }

  /**
   * Test {@link OfferPriceDataImpl#getIdentifierType()}.
   * <ul>
   *   <li>Given {@link OfferDiscountType} {@link OfferDiscountType#getType()}
   * return {@code Type}.</li>
   *   <li>Then calls {@link OfferDiscountType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#getIdentifierType()}
   */
  @Test
  public void testGetIdentifierType_givenOfferDiscountTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferDiscountType discountType = mock(OfferDiscountType.class);
    when(discountType.getType()).thenReturn("Type");

    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(discountType);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);

    // Act
    OfferPriceDataIdentifierType actualIdentifierType = offerPriceDataImpl.getIdentifierType();

    // Assert
    verify(discountType).getType();
    assertSame(actualIdentifierType.PRODUCT_EXTERNAL_ID, actualIdentifierType);
  }

  /**
   * Test {@link OfferPriceDataImpl#getIdentifierType()}.
   * <ul>
   *   <li>Given {@link OfferPriceDataImpl} (default constructor) DiscountType is
   * {@link OfferDiscountType#AMOUNT_OFF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#getIdentifierType()}
   */
  @Test
  public void testGetIdentifierType_givenOfferPriceDataImplDiscountTypeIsAmount_off() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);

    // Act
    OfferPriceDataIdentifierType actualIdentifierType = offerPriceDataImpl.getIdentifierType();

    // Assert
    assertSame(actualIdentifierType.PRODUCT_EXTERNAL_ID, actualIdentifierType);
  }

  /**
   * Test {@link OfferPriceDataImpl#getIdentifierType()}.
   * <ul>
   *   <li>Given {@link OfferPriceDataImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#getIdentifierType()}
   */
  @Test
  public void testGetIdentifierType_givenOfferPriceDataImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OfferPriceDataImpl()).getIdentifierType());
  }

  /**
   * Test
   * {@link OfferPriceDataImpl#setIdentifierType(OfferPriceDataIdentifierType)}.
   * <p>
   * Method under test:
   * {@link OfferPriceDataImpl#setIdentifierType(OfferPriceDataIdentifierType)}
   */
  @Test
  public void testSetIdentifierType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    OfferPriceDataIdentifierType identifierType = mock(OfferPriceDataIdentifierType.class);
    when(identifierType.getType()).thenReturn("Type");

    // Act
    offerPriceDataImpl.setIdentifierType(identifierType);

    // Assert
    verify(identifierType).getType();
    OfferPriceDataIdentifierType identifierType2 = offerPriceDataImpl.getIdentifierType();
    assertEquals("Friendly Type", identifierType2.getFriendlyType());
    assertEquals("Type", identifierType2.getType());
    assertEquals("Type", offerPriceDataImpl.identifierType);
    assertEquals(1, identifierType2.getOrder());
  }

  /**
   * Test
   * {@link OfferPriceDataImpl#setIdentifierType(OfferPriceDataIdentifierType)}.
   * <p>
   * Method under test:
   * {@link OfferPriceDataImpl#setIdentifierType(OfferPriceDataIdentifierType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetIdentifierType2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3428 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.domain.OfferPriceDataImpl offerPriceDataImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OfferPriceDataImpl()).setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
  }

  /**
   * Test
   * {@link OfferPriceDataImpl#setIdentifierType(OfferPriceDataIdentifierType)}.
   * <ul>
   *   <li>Then {@link OfferPriceDataImpl} (default constructor)
   * {@link OfferPriceDataImpl#identifierType} is
   * {@code PRODUCT_EXTERNAL_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferPriceDataImpl#setIdentifierType(OfferPriceDataIdentifierType)}
   */
  @Test
  public void testSetIdentifierType_thenOfferPriceDataImplIdentifierTypeIsProductExternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    OfferPriceDataIdentifierType identifierType = OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID;

    // Act
    offerPriceDataImpl.setIdentifierType(identifierType);

    // Assert
    assertEquals("PRODUCT_EXTERNAL_ID", offerPriceDataImpl.identifierType);
    OfferPriceDataIdentifierType expectedIdentifierType = identifierType.PRODUCT_EXTERNAL_ID;
    assertSame(expectedIdentifierType, offerPriceDataImpl.getIdentifierType());
  }

  /**
   * Test {@link OfferPriceDataImpl#getDiscountType()}.
   * <p>
   * Method under test: {@link OfferPriceDataImpl#getDiscountType()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDiscountType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3355 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.domain.OfferPriceDataImpl offerPriceDataImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OfferPriceDataImpl()).getDiscountType();
  }

  /**
   * Test {@link OfferPriceDataImpl#getDiscountType()}.
   * <ul>
   *   <li>Given {@link OfferPriceDataImpl} (default constructor) IdentifierType is
   * {@link OfferPriceDataIdentifierType#PRODUCT_EXTERNAL_ID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#getDiscountType()}
   */
  @Test
  public void testGetDiscountType_givenOfferPriceDataImplIdentifierTypeIsProduct_external_id() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);

    // Act
    OfferDiscountType actualDiscountType = offerPriceDataImpl.getDiscountType();

    // Assert
    assertSame(actualDiscountType.AMOUNT_OFF, actualDiscountType);
  }

  /**
   * Test {@link OfferPriceDataImpl#getDiscountType()}.
   * <ul>
   *   <li>Given {@link OfferPriceDataImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#getDiscountType()}
   */
  @Test
  public void testGetDiscountType_givenOfferPriceDataImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OfferPriceDataImpl()).getDiscountType());
  }

  /**
   * Test {@link OfferPriceDataImpl#getDiscountType()}.
   * <ul>
   *   <li>Then calls {@link OfferPriceDataIdentifierType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#getDiscountType()}
   */
  @Test
  public void testGetDiscountType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferPriceDataIdentifierType identifierType = mock(OfferPriceDataIdentifierType.class);
    when(identifierType.getType()).thenReturn("Type");

    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(identifierType);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);

    // Act
    OfferDiscountType actualDiscountType = offerPriceDataImpl.getDiscountType();

    // Assert
    verify(identifierType).getType();
    assertSame(actualDiscountType.AMOUNT_OFF, actualDiscountType);
  }

  /**
   * Test {@link OfferPriceDataImpl#setDiscountType(OfferDiscountType)}.
   * <p>
   * Method under test:
   * {@link OfferPriceDataImpl#setDiscountType(OfferDiscountType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetDiscountType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3411 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.domain.OfferPriceDataImpl offerPriceDataImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OfferPriceDataImpl()).setDiscountType(OfferDiscountType.AMOUNT_OFF);
  }

  /**
   * Test {@link OfferPriceDataImpl#setDiscountType(OfferDiscountType)}.
   * <ul>
   *   <li>Then {@link OfferPriceDataImpl} (default constructor) DiscountType
   * FriendlyType is {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferPriceDataImpl#setDiscountType(OfferDiscountType)}
   */
  @Test
  public void testSetDiscountType_thenOfferPriceDataImplDiscountTypeFriendlyTypeIsFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    OfferDiscountType discountType = mock(OfferDiscountType.class);
    when(discountType.getType()).thenReturn("Type");

    // Act
    offerPriceDataImpl.setDiscountType(discountType);

    // Assert
    verify(discountType).getType();
    OfferDiscountType discountType2 = offerPriceDataImpl.getDiscountType();
    assertEquals("Friendly Type", discountType2.getFriendlyType());
    assertEquals("Type", discountType2.getType());
    assertEquals("Type", offerPriceDataImpl.discountType);
  }

  /**
   * Test {@link OfferPriceDataImpl#setDiscountType(OfferDiscountType)}.
   * <ul>
   *   <li>When {@link OfferDiscountType#AMOUNT_OFF}.</li>
   *   <li>Then {@link OfferPriceDataImpl} (default constructor)
   * {@link OfferPriceDataImpl#discountType} is {@code AMOUNT_OFF}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferPriceDataImpl#setDiscountType(OfferDiscountType)}
   */
  @Test
  public void testSetDiscountType_whenAmount_off_thenOfferPriceDataImplDiscountTypeIsAmountOff() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    OfferDiscountType discountType = OfferDiscountType.AMOUNT_OFF;

    // Act
    offerPriceDataImpl.setDiscountType(discountType);

    // Assert
    assertEquals("AMOUNT_OFF", offerPriceDataImpl.discountType);
    OfferDiscountType expectedDiscountType = discountType.AMOUNT_OFF;
    assertSame(expectedDiscountType, offerPriceDataImpl.getDiscountType());
  }

  /**
   * Test {@link OfferPriceDataImpl#getArchived()}.
   * <p>
   * Method under test: {@link OfferPriceDataImpl#getArchived()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetArchived() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3343 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.domain.OfferPriceDataImpl offerPriceDataImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OfferPriceDataImpl()).getArchived();
  }

  /**
   * Test {@link OfferPriceDataImpl#getArchived()}.
   * <ul>
   *   <li>Given {@link OfferPriceDataImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#getArchived()}
   */
  @Test
  public void testGetArchived_givenOfferPriceDataImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('N', (new OfferPriceDataImpl()).getArchived().charValue());
  }

  /**
   * Test {@link OfferPriceDataImpl#getArchived()}.
   * <ul>
   *   <li>Given {@link OfferPriceDataImpl} (default constructor) Offer is
   * {@link OfferImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#getArchived()}
   */
  @Test
  public void testGetArchived_givenOfferPriceDataImplOfferIsOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setOffer(mock(OfferImpl.class));

    // Act and Assert
    assertEquals('N', offerPriceDataImpl.getArchived().charValue());
  }

  /**
   * Test {@link OfferPriceDataImpl#setArchived(Character)}.
   * <p>
   * Method under test: {@link OfferPriceDataImpl#setArchived(Character)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetArchived() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3391 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.domain.OfferPriceDataImpl offerPriceDataImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OfferPriceDataImpl()).setArchived('A');
  }

  /**
   * Test {@link OfferPriceDataImpl#setArchived(Character)}.
   * <ul>
   *   <li>Given {@link OfferPriceDataImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived_givenOfferPriceDataImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();

    // Act
    offerPriceDataImpl.setArchived('A');

    // Assert
    assertEquals('A', offerPriceDataImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', offerPriceDataImpl.getArchived().charValue());
  }

  /**
   * Test {@link OfferPriceDataImpl#setArchived(Character)}.
   * <ul>
   *   <li>Given {@link OfferPriceDataImpl} (default constructor) Offer is
   * {@link OfferImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived_givenOfferPriceDataImplOfferIsOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setOffer(mock(OfferImpl.class));

    // Act
    offerPriceDataImpl.setArchived('A');

    // Assert
    assertEquals('A', offerPriceDataImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', offerPriceDataImpl.getArchived().charValue());
  }

  /**
   * Test {@link OfferPriceDataImpl#isActive()}.
   * <p>
   * Method under test: {@link OfferPriceDataImpl#isActive()}
   */
  @Test
  public void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offer.setId(OfferImpl.serialVersionUID);
    offer.setMarketingMessage("Marketing Message");
    offer.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offer.setMaxUsesPerOrder(3);
    offer.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offer.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offer.setName("Name");
    offer.setOfferCodes(new ArrayList<>());
    offer.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferMatchRulesXref(new HashMap<>());
    offer.setOfferPriceData(new ArrayList<>());
    offer.setOrderMinSubTotal(new Money());
    offer.setPriority(1);
    offer.setQualifyingItemCriteriaXref(new HashSet<>());
    offer.setQualifyingItemSubTotal(new Money());
    offer.setRequiresRelatedTargetAndQualifiers(true);
    offer.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));
    offer.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setQuantity(1);
    offerPriceDataImpl.setActiveStartDate(null);
    offerPriceDataImpl.setActiveEndDate(null);
    offerPriceDataImpl.setArchived(null);
    offerPriceDataImpl.setOffer(offer);

    // Act and Assert
    assertFalse(offerPriceDataImpl.isActive());
  }

  /**
   * Test {@link OfferPriceDataImpl#isActive()}.
   * <p>
   * Method under test: {@link OfferPriceDataImpl#isActive()}
   */
  @Test
  public void testIsActive2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Offer offer = mock(Offer.class);
    when(offer.getEndDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(offer.getStartDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setOffer(offer);

    // Act
    boolean actualIsActiveResult = offerPriceDataImpl.isActive();

    // Assert
    verify(offer).getEndDate();
    verify(offer).getStartDate();
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test {@link OfferPriceDataImpl#isActive()}.
   * <p>
   * Method under test: {@link OfferPriceDataImpl#isActive()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsActive3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3379 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.domain.OfferPriceDataImpl offerPriceDataImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OfferPriceDataImpl()).isActive();
  }

  /**
   * Test {@link OfferPriceDataImpl#isActive()}.
   * <ul>
   *   <li>Given {@link Offer} {@link Offer#getEndDate()} return
   * {@link Date#Date()}.</li>
   *   <li>Then calls {@link Offer#getEndDate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#isActive()}
   */
  @Test
  public void testIsActive_givenOfferGetEndDateReturnDate_thenCallsGetEndDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    Offer offer = mock(Offer.class);
    when(offer.getEndDate()).thenReturn(new Date());
    when(offer.getStartDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setOffer(offer);

    // Act
    boolean actualIsActiveResult = offerPriceDataImpl.isActive();

    // Assert
    verify(offer).getEndDate();
    verify(offer).getStartDate();
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test {@link OfferPriceDataImpl#isActive()}.
   * <ul>
   *   <li>Given {@link Offer} {@link Offer#getStartDate()} return
   * {@link Date#Date()}.</li>
   *   <li>Then calls {@link Offer#getEndDate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#isActive()}
   */
  @Test
  public void testIsActive_givenOfferGetStartDateReturnDate_thenCallsGetEndDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Offer offer = mock(Offer.class);
    when(offer.getEndDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(offer.getStartDate()).thenReturn(new Date());

    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setOffer(offer);

    // Act
    boolean actualIsActiveResult = offerPriceDataImpl.isActive();

    // Assert
    verify(offer).getEndDate();
    verify(offer).getStartDate();
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test {@link OfferPriceDataImpl#isActive()}.
   * <ul>
   *   <li>Given {@link OfferPriceDataImpl} (default constructor) Offer is
   * {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#isActive()}
   */
  @Test
  public void testIsActive_givenOfferPriceDataImplOfferIsOfferImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setOffer(new OfferImpl());

    // Act and Assert
    assertFalse(offerPriceDataImpl.isActive());
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}, and
   * {@link OfferPriceDataImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferPriceDataImpl#equals(Object)}
   *   <li>{@link OfferPriceDataImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertEquals(offerPriceDataImpl, offerPriceDataImpl2);
    int expectedHashCodeResult = offerPriceDataImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerPriceDataImpl2.hashCode());
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}, and
   * {@link OfferPriceDataImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferPriceDataImpl#equals(Object)}
   *   <li>{@link OfferPriceDataImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(null);
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("4.5"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.FIX_PRICE);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OfferDiscountType discountType = mock(OfferDiscountType.class);
    when(discountType.getType()).thenReturn("Type");

    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(discountType);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OfferDiscountType discountType = mock(OfferDiscountType.class);
    when(discountType.getType()).thenReturn("Type");

    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(discountType);
    offerPriceDataImpl.setId(2L);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    OfferDiscountType discountType = mock(OfferDiscountType.class);
    when(discountType.getType()).thenReturn("Type");

    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(discountType);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    OfferDiscountType discountType = mock(OfferDiscountType.class);
    when(discountType.getType()).thenReturn("Type");

    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(discountType);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("Type");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    OfferDiscountType discountType = mock(OfferDiscountType.class);
    when(discountType.getType()).thenReturn("Type");

    OfferImpl offer = new OfferImpl();
    offer.setId(OfferImpl.serialVersionUID);

    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(discountType);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(offer);
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then throw exception.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsDifferent_thenThrowException() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.domain.OfferPriceDataImpl.equals(OfferPriceDataImpl.java:297)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(null);
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertThrows(NullPointerException.class, () -> offerPriceDataImpl.equals(offerPriceDataImpl2));
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then throw exception.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsDifferent_thenThrowException2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.domain.OfferPriceDataImpl.equals(OfferPriceDataImpl.java:303)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(null);
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertThrows(NullPointerException.class, () -> offerPriceDataImpl.equals(offerPriceDataImpl2));
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then throw exception.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsDifferent_thenThrowException3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.domain.OfferPriceDataImpl.equals(OfferPriceDataImpl.java:302)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(new OfferDiscountType());
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertThrows(NullPointerException.class, () -> offerPriceDataImpl.equals(offerPriceDataImpl2));
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then throw exception.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsDifferent_thenThrowException4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.domain.OfferPriceDataImpl.equals(OfferPriceDataImpl.java:295)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    OfferDiscountType discountType = mock(OfferDiscountType.class);
    when(discountType.getType()).thenReturn("Type");

    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(discountType);
    offerPriceDataImpl.setId(null);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertThrows(NullPointerException.class, () -> offerPriceDataImpl.equals(offerPriceDataImpl2));
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then throw exception.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsDifferent_thenThrowException5() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.domain.OfferPriceDataImpl.equals(OfferPriceDataImpl.java:300)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    OfferDiscountType discountType = mock(OfferDiscountType.class);
    when(discountType.getType()).thenReturn("Type");

    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(discountType);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(new OfferPriceDataIdentifierType());
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertThrows(NullPointerException.class, () -> offerPriceDataImpl.equals(offerPriceDataImpl2));
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then throw exception.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsDifferent_thenThrowException6() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.domain.OfferPriceDataImpl.equals(OfferPriceDataImpl.java:301)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    OfferDiscountType discountType = mock(OfferDiscountType.class);
    when(discountType.getType()).thenReturn("Type");

    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(discountType);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue(null);
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertThrows(NullPointerException.class, () -> offerPriceDataImpl.equals(offerPriceDataImpl2));
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then throw exception.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsDifferent_thenThrowException7() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    OfferDiscountType discountType = mock(OfferDiscountType.class);
    when(discountType.getType()).thenReturn("Type");

    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(discountType);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(null);
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertThrows(NullPointerException.class, () -> offerPriceDataImpl.equals(offerPriceDataImpl2));
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl
        .setActiveEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * Test
   * {@link OfferPriceDataImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link OfferPriceDataImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3273 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.domain.OfferPriceDataImpl offerPriceDataImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    offerPriceDataImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
        toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test new {@link OfferPriceDataImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link OfferPriceDataImpl}
   */
  @Test
  public void testNewOfferPriceDataImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    OfferPriceDataImpl actualOfferPriceDataImpl = new OfferPriceDataImpl();

    // Assert
    assertEquals('N', actualOfferPriceDataImpl.archiveStatus.getArchived().charValue());
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

  /**
   * Test new {@link OfferPriceDataImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link OfferPriceDataImpl}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewOfferPriceDataImpl2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3272 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.domain.OfferPriceDataImpl offerPriceDataImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new OfferPriceDataImpl();
  }
}
