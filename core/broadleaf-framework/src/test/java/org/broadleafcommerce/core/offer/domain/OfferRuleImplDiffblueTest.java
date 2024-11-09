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

public class OfferRuleImplDiffblueTest {
  /**
   * Test {@link OfferRuleImpl#equals(Object)}, and
   * {@link OfferRuleImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferRuleImpl#equals(Object)}
   *   <li>{@link OfferRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl.setMatchRule("Match Rule");

    OfferRuleImpl offerRuleImpl2 = new OfferRuleImpl();
    offerRuleImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(offerRuleImpl, offerRuleImpl2);
    int expectedHashCodeResult = offerRuleImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerRuleImpl2.hashCode());
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}, and
   * {@link OfferRuleImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferRuleImpl#equals(Object)}
   *   <li>{@link OfferRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(null);
    offerRuleImpl.setMatchRule("Match Rule");

    OfferRuleImpl offerRuleImpl2 = new OfferRuleImpl();
    offerRuleImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(offerRuleImpl, offerRuleImpl2);
    int notExpectedHashCodeResult = offerRuleImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, offerRuleImpl2.hashCode());
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}, and
   * {@link OfferRuleImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferRuleImpl#equals(Object)}
   *   <li>{@link OfferRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl.setMatchRule("Match Rule");

    OfferRuleImpl offerRuleImpl2 = new OfferRuleImpl();
    offerRuleImpl2.setId(null);
    offerRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(offerRuleImpl, offerRuleImpl2);
    int notExpectedHashCodeResult = offerRuleImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, offerRuleImpl2.hashCode());
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}, and
   * {@link OfferRuleImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferRuleImpl#equals(Object)}
   *   <li>{@link OfferRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(null);
    offerRuleImpl.setMatchRule(null);

    OfferRuleImpl offerRuleImpl2 = new OfferRuleImpl();
    offerRuleImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl2.setMatchRule(null);

    // Act and Assert
    assertEquals(offerRuleImpl, offerRuleImpl2);
    int notExpectedHashCodeResult = offerRuleImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, offerRuleImpl2.hashCode());
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}, and
   * {@link OfferRuleImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferRuleImpl#equals(Object)}
   *   <li>{@link OfferRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(offerRuleImpl, offerRuleImpl);
    int expectedHashCodeResult = offerRuleImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerRuleImpl.hashCode());
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferRuleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(2L);
    offerRuleImpl.setMatchRule("Match Rule");

    OfferRuleImpl offerRuleImpl2 = new OfferRuleImpl();
    offerRuleImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(offerRuleImpl, offerRuleImpl2);
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferRuleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(null);
    offerRuleImpl.setMatchRule(null);

    OfferRuleImpl offerRuleImpl2 = new OfferRuleImpl();
    offerRuleImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(offerRuleImpl, offerRuleImpl2);
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferRuleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(null);
    offerRuleImpl.setMatchRule("42");

    OfferRuleImpl offerRuleImpl2 = new OfferRuleImpl();
    offerRuleImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(offerRuleImpl, offerRuleImpl2);
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferRuleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(offerRuleImpl, null);
  }

  /**
   * Test {@link OfferRuleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferRuleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    offerRuleImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    offerRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(offerRuleImpl, "Different type to OfferRuleImpl");
  }

  /**
   * Test
   * {@link OfferRuleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link OfferRuleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferRule> actualCreateOrRetrieveCopyInstanceResult = offerRuleImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link OfferRuleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link OfferRuleImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferRuleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnOfferRuleImpl() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferRuleImpl offerRuleImpl = new OfferRuleImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<OfferRule> actualCreateOrRetrieveCopyInstanceResult = offerRuleImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.offer.domain.OfferRuleImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    OfferRule clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof OfferRuleImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(offerRuleImpl, clone);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OfferRuleImpl}
   *   <li>{@link OfferRuleImpl#setId(Long)}
   *   <li>{@link OfferRuleImpl#setMatchRule(String)}
   *   <li>{@link OfferRuleImpl#getId()}
   *   <li>{@link OfferRuleImpl#getMatchRule()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferRuleImpl actualOfferRuleImpl = new OfferRuleImpl();
    actualOfferRuleImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    actualOfferRuleImpl.setMatchRule("Match Rule");
    Long actualId = actualOfferRuleImpl.getId();

    // Assert that nothing has changed
    assertEquals("Match Rule", actualOfferRuleImpl.getMatchRule());
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
  }
}
