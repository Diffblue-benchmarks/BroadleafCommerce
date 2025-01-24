package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.offer.domain.CandidateItemOfferImpl;
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
public class DynamicPriceDiscreteOrderItemImplDiffblueTest {
  @Autowired
  private DynamicPriceDiscreteOrderItemImpl dynamicPriceDiscreteOrderItemImpl;

  /**
   * Test {@link DynamicPriceDiscreteOrderItemImpl#setSku(Sku)}.
   * <p>
   * Method under test: {@link DynamicPriceDiscreteOrderItemImpl#setSku(Sku)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetSku() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.DynamicPriceDiscreteOrderItemImpl dynamicPriceDiscreteOrderItemImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DynamicPriceDiscreteOrderItemImpl dynamicPriceDiscreteOrderItemImpl2 = new DynamicPriceDiscreteOrderItemImpl();

    // Act
    dynamicPriceDiscreteOrderItemImpl2.setSku(new SkuImpl());
  }

  /**
   * Test {@link DynamicPriceDiscreteOrderItemImpl#setSku(Sku)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then {@link DynamicPriceDiscreteOrderItemImpl} (default constructor) Name
   * is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicPriceDiscreteOrderItemImpl#setSku(Sku)}
   */
  @Test
  public void testSetSku_givenName_thenDynamicPriceDiscreteOrderItemImplNameIsName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicPriceDiscreteOrderItemImpl dynamicPriceDiscreteOrderItemImpl = new DynamicPriceDiscreteOrderItemImpl();
    Sku sku = mock(Sku.class);
    when(sku.getName()).thenReturn("Name");

    // Act
    dynamicPriceDiscreteOrderItemImpl.setSku(sku);

    // Assert
    verify(sku).getName();
    assertEquals("Name", dynamicPriceDiscreteOrderItemImpl.getName());
    assertEquals("Name", dynamicPriceDiscreteOrderItemImpl.getMainEntityName());
    assertFalse(dynamicPriceDiscreteOrderItemImpl.isSkuActive());
    assertSame(sku, dynamicPriceDiscreteOrderItemImpl.getSku());
    assertSame(sku, dynamicPriceDiscreteOrderItemImpl.deproxiedSku);
  }

  /**
   * Test {@link DynamicPriceDiscreteOrderItemImpl#updateSaleAndRetailPrices()}.
   * <p>
   * Method under test:
   * {@link DynamicPriceDiscreteOrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  public void testUpdateSaleAndRetailPrices() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicPriceDiscreteOrderItemImpl dynamicPriceDiscreteOrderItemImpl = new DynamicPriceDiscreteOrderItemImpl();
    dynamicPriceDiscreteOrderItemImpl.addCandidateItemOffer(mock(CandidateItemOfferImpl.class));

    // Act and Assert
    assertFalse(dynamicPriceDiscreteOrderItemImpl.updateSaleAndRetailPrices());
  }

  /**
   * Test {@link DynamicPriceDiscreteOrderItemImpl#updateSaleAndRetailPrices()}.
   * <p>
   * Method under test:
   * {@link DynamicPriceDiscreteOrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateSaleAndRetailPrices2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass77 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.DynamicPriceDiscreteOrderItemImpl dynamicPriceDiscreteOrderItemImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DynamicPriceDiscreteOrderItemImpl()).updateSaleAndRetailPrices();
  }

  /**
   * Test {@link DynamicPriceDiscreteOrderItemImpl#updateSaleAndRetailPrices()}.
   * <ul>
   *   <li>Given {@link DynamicPriceDiscreteOrderItemImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicPriceDiscreteOrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  public void testUpdateSaleAndRetailPrices_givenDynamicPriceDiscreteOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new DynamicPriceDiscreteOrderItemImpl()).updateSaleAndRetailPrices());
  }

  /**
   * Test new {@link DynamicPriceDiscreteOrderItemImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link DynamicPriceDiscreteOrderItemImpl}
   */
  @Test
  public void testNewDynamicPriceDiscreteOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    DynamicPriceDiscreteOrderItemImpl actualDynamicPriceDiscreteOrderItemImpl = new DynamicPriceDiscreteOrderItemImpl();

    // Assert
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.discountsAllowed);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.hasValidationError);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.itemTaxable);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.retailPriceOverride);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.salePriceOverride);
    Auditable auditable = actualDynamicPriceDiscreteOrderItemImpl.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getId());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.orderItemType);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.baseRetailPrice);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.baseSalePrice);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.price);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.retailPrice);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.salePrice);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.totalTax);
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getCartMessages());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getBaseRetailPrice());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getBaseSalePrice());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getAdjustmentValue());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getAverageAdjustmentValue());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getAveragePrice());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getPrice());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getRetailPrice());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getSalePrice());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getCategory());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.category);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.deproxiedCategory);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getProduct());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.deproxiedProduct);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.product);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getSku());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.deproxiedSku);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.sku);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getSkuBundleItem());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getBundleOrderItem());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getGiftWrapOrderItem());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.giftWrapOrderItem);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getOrder());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getParentOrderItem());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getPersonalMessage());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getOrderItemType());
    assertEquals(0, actualDynamicPriceDiscreteOrderItemImpl.getQuantity());
    assertFalse(actualDynamicPriceDiscreteOrderItemImpl.getHasValidationError());
    assertFalse(actualDynamicPriceDiscreteOrderItemImpl.getIsDiscounted());
    assertFalse(actualDynamicPriceDiscreteOrderItemImpl.getIsOnSale());
    assertFalse(actualDynamicPriceDiscreteOrderItemImpl.isChildOrderItem());
    assertTrue(actualDynamicPriceDiscreteOrderItemImpl.getDiscreteOrderItemFeePrices().isEmpty());
    assertTrue(actualDynamicPriceDiscreteOrderItemImpl.getCandidateItemOffers().isEmpty());
    assertTrue(actualDynamicPriceDiscreteOrderItemImpl.getChildOrderItems().isEmpty());
    assertTrue(actualDynamicPriceDiscreteOrderItemImpl.getOrderItemAdjustments().isEmpty());
    assertTrue(actualDynamicPriceDiscreteOrderItemImpl.getOrderItemPriceDetails().isEmpty());
    assertTrue(actualDynamicPriceDiscreteOrderItemImpl.getOrderItemQualifiers().isEmpty());
    assertTrue(actualDynamicPriceDiscreteOrderItemImpl.getProratedOrderItemAdjustments().isEmpty());
    assertTrue(actualDynamicPriceDiscreteOrderItemImpl.getAdditionalAttributes().isEmpty());
    assertTrue(actualDynamicPriceDiscreteOrderItemImpl.getOrderItemAttributes().isEmpty());
  }

  /**
   * Test new {@link DynamicPriceDiscreteOrderItemImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link DynamicPriceDiscreteOrderItemImpl}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewDynamicPriceDiscreteOrderItemImpl2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.domain.DynamicPriceDiscreteOrderItemImpl dynamicPriceDiscreteOrderItemImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new DynamicPriceDiscreteOrderItemImpl();
  }
}
