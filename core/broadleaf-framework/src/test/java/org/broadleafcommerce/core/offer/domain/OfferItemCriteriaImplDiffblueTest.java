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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class OfferItemCriteriaImplDiffblueTest {
  /**
   * Test {@link OfferItemCriteriaImpl#equals(Object)}, and
   * {@link OfferItemCriteriaImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferItemCriteriaImpl#equals(Object)}
   *   <li>{@link OfferItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferItemCriteriaImpl offerItemCriteriaImpl = new OfferItemCriteriaImpl();
    offerItemCriteriaImpl.setId(OfferItemCriteriaImpl.serialVersionUID);
    offerItemCriteriaImpl.setMatchRule("Match Rule");
    offerItemCriteriaImpl.setQuantity(1);

    OfferItemCriteriaImpl offerItemCriteriaImpl2 = new OfferItemCriteriaImpl();
    offerItemCriteriaImpl2.setId(OfferItemCriteriaImpl.serialVersionUID);
    offerItemCriteriaImpl2.setMatchRule("Match Rule");
    offerItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertEquals(offerItemCriteriaImpl, offerItemCriteriaImpl2);
    int expectedHashCodeResult = offerItemCriteriaImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link OfferItemCriteriaImpl#equals(Object)}, and
   * {@link OfferItemCriteriaImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferItemCriteriaImpl#equals(Object)}
   *   <li>{@link OfferItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferItemCriteriaImpl offerItemCriteriaImpl = new OfferItemCriteriaImpl();
    offerItemCriteriaImpl.setId(OfferItemCriteriaImpl.serialVersionUID);
    offerItemCriteriaImpl.setMatchRule("Match Rule");
    offerItemCriteriaImpl.setQuantity(1);

    // Act and Assert
    assertEquals(offerItemCriteriaImpl, offerItemCriteriaImpl);
    int expectedHashCodeResult = offerItemCriteriaImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerItemCriteriaImpl.hashCode());
  }

  /**
   * Test {@link OfferItemCriteriaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferItemCriteriaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferItemCriteriaImpl offerItemCriteriaImpl = new OfferItemCriteriaImpl();
    offerItemCriteriaImpl.setId(2L);
    offerItemCriteriaImpl.setMatchRule("Match Rule");
    offerItemCriteriaImpl.setQuantity(1);

    OfferItemCriteriaImpl offerItemCriteriaImpl2 = new OfferItemCriteriaImpl();
    offerItemCriteriaImpl2.setId(OfferItemCriteriaImpl.serialVersionUID);
    offerItemCriteriaImpl2.setMatchRule("Match Rule");
    offerItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerItemCriteriaImpl, offerItemCriteriaImpl2);
  }

  /**
   * Test {@link OfferItemCriteriaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferItemCriteriaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferItemCriteriaImpl offerItemCriteriaImpl = new OfferItemCriteriaImpl();
    offerItemCriteriaImpl.setId(OfferItemCriteriaImpl.serialVersionUID);
    offerItemCriteriaImpl.setMatchRule("Match Rule");
    offerItemCriteriaImpl.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerItemCriteriaImpl, null);
  }

  /**
   * Test {@link OfferItemCriteriaImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferItemCriteriaImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferItemCriteriaImpl offerItemCriteriaImpl = new OfferItemCriteriaImpl();
    offerItemCriteriaImpl.setId(OfferItemCriteriaImpl.serialVersionUID);
    offerItemCriteriaImpl.setMatchRule("Match Rule");
    offerItemCriteriaImpl.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerItemCriteriaImpl, "Different type to OfferItemCriteriaImpl");
  }

  /**
   * Test
   * {@link OfferItemCriteriaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link OfferItemCriteriaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferItemCriteriaImpl offerItemCriteriaImpl = new OfferItemCriteriaImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferItemCriteria> actualCreateOrRetrieveCopyInstanceResult = offerItemCriteriaImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link OfferItemCriteriaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link OfferItemCriteriaImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferItemCriteriaImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnOfferItemCriteriaImpl()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferItemCriteriaImpl offerItemCriteriaImpl = new OfferItemCriteriaImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<OfferItemCriteria> actualCreateOrRetrieveCopyInstanceResult = offerItemCriteriaImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.core.offer.domain.OfferItemCriteriaImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    OfferItemCriteria clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof OfferItemCriteriaImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(offerItemCriteriaImpl, clone);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OfferItemCriteriaImpl}
   *   <li>{@link OfferItemCriteriaImpl#setId(Long)}
   *   <li>{@link OfferItemCriteriaImpl#setMatchRule(String)}
   *   <li>{@link OfferItemCriteriaImpl#setQuantity(Integer)}
   *   <li>{@link OfferItemCriteriaImpl#getId()}
   *   <li>{@link OfferItemCriteriaImpl#getMatchRule()}
   *   <li>{@link OfferItemCriteriaImpl#getQuantity()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferItemCriteriaImpl actualOfferItemCriteriaImpl = new OfferItemCriteriaImpl();
    actualOfferItemCriteriaImpl.setId(OfferItemCriteriaImpl.serialVersionUID);
    actualOfferItemCriteriaImpl.setMatchRule("Match Rule");
    actualOfferItemCriteriaImpl.setQuantity(1);
    Long actualId = actualOfferItemCriteriaImpl.getId();
    String actualMatchRule = actualOfferItemCriteriaImpl.getMatchRule();

    // Assert that nothing has changed
    assertEquals("Match Rule", actualMatchRule);
    assertEquals(1, actualOfferItemCriteriaImpl.getQuantity().intValue());
    assertEquals(OfferItemCriteriaImpl.serialVersionUID, actualId.longValue());
  }
}
