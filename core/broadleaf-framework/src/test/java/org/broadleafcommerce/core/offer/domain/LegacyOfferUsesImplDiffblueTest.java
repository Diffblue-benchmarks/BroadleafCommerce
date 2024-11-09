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
package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.sql.Date;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.DeferredOperation;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.offer.weave.LegacyOfferUses;
import org.junit.Test;

public class LegacyOfferUsesImplDiffblueTest {
  /**
   * Test {@link LegacyOfferUsesImpl#getMaxUses()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) StartDate is
   * {@link Date}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOfferUsesImpl#getMaxUses()}
   */
  @Test
  public void testGetMaxUses_givenOfferImplStartDateIsDate_thenReturnZero() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setStartDate(mock(Date.class));

    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl.setOffer(offer);
    legacyOfferUsesImpl.setUses(1);

    // Act and Assert
    assertEquals(0, legacyOfferUsesImpl.getMaxUses());
  }

  /**
   * Test {@link LegacyOfferUsesImpl#getMaxUses()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOfferUsesImpl#getMaxUses()}
   */
  @Test
  public void testGetMaxUses_thenReturnZero() {
    // Arrange
    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl.setOffer(new OfferImpl());
    legacyOfferUsesImpl.setUses(1);

    // Act and Assert
    assertEquals(0, legacyOfferUsesImpl.getMaxUses());
  }

  /**
   * Test {@link LegacyOfferUsesImpl#setMaxUses(int)}.
   * <ul>
   *   <li>Then {@link LegacyOfferUsesImpl} (default constructor) Offer
   * {@link OfferImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOfferUsesImpl#setMaxUses(int)}
   */
  @Test
  public void testSetMaxUses_thenLegacyOfferUsesImplOfferOfferImpl() {
    // Arrange
    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl.setOffer(new OfferImpl());
    legacyOfferUsesImpl.setUses(1);

    // Act
    legacyOfferUsesImpl.setMaxUses(3);

    // Assert
    Offer offer = legacyOfferUsesImpl.getOffer();
    assertTrue(offer instanceof OfferImpl);
    assertEquals(3, ((OfferImpl) offer).maxUsesPerOrder.intValue());
    assertEquals(3, legacyOfferUsesImpl.getMaxUses());
    assertEquals(3, offer.getMaxUsesPerOrder());
    assertFalse(offer.isUnlimitedUsePerOrder());
    assertTrue(offer.isLimitedUsePerOrder());
  }

  /**
   * Test {@link LegacyOfferUsesImpl#equals(Object)}, and
   * {@link LegacyOfferUsesImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LegacyOfferUsesImpl#equals(Object)}
   *   <li>{@link LegacyOfferUsesImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl.setOffer(new OfferImpl());
    legacyOfferUsesImpl.setUses(1);

    LegacyOfferUsesImpl legacyOfferUsesImpl2 = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl2.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl2.setOffer(new OfferImpl());
    legacyOfferUsesImpl2.setUses(1);

    // Act and Assert
    assertEquals(legacyOfferUsesImpl, legacyOfferUsesImpl2);
    int expectedHashCodeResult = legacyOfferUsesImpl.hashCode();
    assertEquals(expectedHashCodeResult, legacyOfferUsesImpl2.hashCode());
  }

  /**
   * Test {@link LegacyOfferUsesImpl#equals(Object)}, and
   * {@link LegacyOfferUsesImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LegacyOfferUsesImpl#equals(Object)}
   *   <li>{@link LegacyOfferUsesImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl.setOffer(new OfferImpl());
    legacyOfferUsesImpl.setUses(1);

    // Act and Assert
    assertEquals(legacyOfferUsesImpl, legacyOfferUsesImpl);
    int expectedHashCodeResult = legacyOfferUsesImpl.hashCode();
    assertEquals(expectedHashCodeResult, legacyOfferUsesImpl.hashCode());
  }

  /**
   * Test {@link LegacyOfferUsesImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOfferUsesImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setId(OfferImpl.serialVersionUID);

    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl.setOffer(offer);
    legacyOfferUsesImpl.setUses(1);

    LegacyOfferUsesImpl legacyOfferUsesImpl2 = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl2.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl2.setOffer(new OfferImpl());
    legacyOfferUsesImpl2.setUses(1);

    // Act and Assert
    assertNotEquals(legacyOfferUsesImpl, legacyOfferUsesImpl2);
  }

  /**
   * Test {@link LegacyOfferUsesImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOfferUsesImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl.setOffer(mock(OfferImpl.class));
    legacyOfferUsesImpl.setUses(1);

    LegacyOfferUsesImpl legacyOfferUsesImpl2 = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl2.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl2.setOffer(new OfferImpl());
    legacyOfferUsesImpl2.setUses(1);

    // Act and Assert
    assertNotEquals(legacyOfferUsesImpl, legacyOfferUsesImpl2);
  }

  /**
   * Test {@link LegacyOfferUsesImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOfferUsesImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl.setOffer(new OfferImpl());
    legacyOfferUsesImpl.setUses(0);

    LegacyOfferUsesImpl legacyOfferUsesImpl2 = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl2.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl2.setOffer(new OfferImpl());
    legacyOfferUsesImpl2.setUses(1);

    // Act and Assert
    assertNotEquals(legacyOfferUsesImpl, legacyOfferUsesImpl2);
  }

  /**
   * Test {@link LegacyOfferUsesImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOfferUsesImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl.setOffer(new OfferImpl());
    legacyOfferUsesImpl.setUses(1);

    // Act and Assert
    assertNotEquals(legacyOfferUsesImpl, null);
  }

  /**
   * Test {@link LegacyOfferUsesImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LegacyOfferUsesImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    legacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    legacyOfferUsesImpl.setOffer(new OfferImpl());
    legacyOfferUsesImpl.setUses(1);

    // Act and Assert
    assertNotEquals(legacyOfferUsesImpl, "Different type to LegacyOfferUsesImpl");
  }

  /**
   * Test
   * {@link LegacyOfferUsesImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link LegacyOfferUsesImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    CreateResponse<LegacyOfferUses> actualCreateOrRetrieveCopyInstanceResult = legacyOfferUsesImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    LegacyOfferUses clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof LegacyOfferUsesImpl);
    assertNull(((LegacyOfferUsesImpl) clone).getOffer());
    assertEquals(0, clone.getUses());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertFalse(((LegacyOfferUsesImpl) clone).getApplyDiscountToMarkedItems());
    assertFalse(clone.isApplyDiscountToMarkedItems());
  }

  /**
   * Test
   * {@link LegacyOfferUsesImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@link DeferredOperation}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyOfferUsesImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_givenDeferredOperation() throws CloneNotSupportedException {
    // Arrange
    LegacyOfferUsesImpl legacyOfferUsesImpl = new LegacyOfferUsesImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());
    context.addDeferredOperation(mock(DeferredOperation.class));

    // Act
    CreateResponse<LegacyOfferUses> actualCreateOrRetrieveCopyInstanceResult = legacyOfferUsesImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    LegacyOfferUses clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof LegacyOfferUsesImpl);
    assertNull(((LegacyOfferUsesImpl) clone).getOffer());
    assertEquals(0, clone.getUses());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertFalse(((LegacyOfferUsesImpl) clone).getApplyDiscountToMarkedItems());
    assertFalse(clone.isApplyDiscountToMarkedItems());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LegacyOfferUsesImpl}
   *   <li>{@link LegacyOfferUsesImpl#setApplyDiscountToMarkedItems(boolean)}
   *   <li>{@link LegacyOfferUsesImpl#setOffer(Offer)}
   *   <li>{@link LegacyOfferUsesImpl#setUses(int)}
   *   <li>{@link LegacyOfferUsesImpl#getApplyDiscountToMarkedItems()}
   *   <li>{@link LegacyOfferUsesImpl#getOffer()}
   *   <li>{@link LegacyOfferUsesImpl#getUses()}
   *   <li>{@link LegacyOfferUsesImpl#isApplyDiscountToMarkedItems()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    LegacyOfferUsesImpl actualLegacyOfferUsesImpl = new LegacyOfferUsesImpl();
    actualLegacyOfferUsesImpl.setApplyDiscountToMarkedItems(true);
    OfferImpl offer = new OfferImpl();
    actualLegacyOfferUsesImpl.setOffer(offer);
    actualLegacyOfferUsesImpl.setUses(1);
    boolean actualApplyDiscountToMarkedItems = actualLegacyOfferUsesImpl.getApplyDiscountToMarkedItems();
    Offer actualOffer = actualLegacyOfferUsesImpl.getOffer();
    int actualUses = actualLegacyOfferUsesImpl.getUses();

    // Assert that nothing has changed
    assertEquals(1, actualUses);
    assertTrue(actualApplyDiscountToMarkedItems);
    assertTrue(actualLegacyOfferUsesImpl.isApplyDiscountToMarkedItems());
    assertSame(offer, actualOffer);
  }
}
