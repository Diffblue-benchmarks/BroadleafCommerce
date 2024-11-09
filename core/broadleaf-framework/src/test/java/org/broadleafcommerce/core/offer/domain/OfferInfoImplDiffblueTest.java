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
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class OfferInfoImplDiffblueTest {
  /**
   * Test {@link OfferInfoImpl#equals(Object)}, and
   * {@link OfferInfoImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferInfoImpl#equals(Object)}
   *   <li>{@link OfferInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    OfferInfoImpl offerInfoImpl2 = new OfferInfoImpl();
    offerInfoImpl2.setFieldValues(new HashMap<>());
    offerInfoImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(offerInfoImpl, offerInfoImpl2);
    int expectedHashCodeResult = offerInfoImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerInfoImpl2.hashCode());
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}, and
   * {@link OfferInfoImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferInfoImpl#equals(Object)}
   *   <li>{@link OfferInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(null);

    OfferInfoImpl offerInfoImpl2 = new OfferInfoImpl();
    offerInfoImpl2.setFieldValues(new HashMap<>());
    offerInfoImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(offerInfoImpl, offerInfoImpl2);
    int expectedHashCodeResult = offerInfoImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerInfoImpl2.hashCode());
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}, and
   * {@link OfferInfoImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferInfoImpl#equals(Object)}
   *   <li>{@link OfferInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    OfferInfoImpl offerInfoImpl2 = new OfferInfoImpl();
    offerInfoImpl2.setFieldValues(new HashMap<>());
    offerInfoImpl2.setId(null);

    // Act and Assert
    assertEquals(offerInfoImpl, offerInfoImpl2);
    int expectedHashCodeResult = offerInfoImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerInfoImpl2.hashCode());
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}, and
   * {@link OfferInfoImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferInfoImpl#equals(Object)}
   *   <li>{@link OfferInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    HashMap<String, String> fieldValues = new HashMap<>();
    fieldValues.computeIfPresent("foo", mock(BiFunction.class));

    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(fieldValues);
    offerInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    OfferInfoImpl offerInfoImpl2 = new OfferInfoImpl();
    offerInfoImpl2.setFieldValues(new HashMap<>());
    offerInfoImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(offerInfoImpl, offerInfoImpl2);
    int expectedHashCodeResult = offerInfoImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerInfoImpl2.hashCode());
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}, and
   * {@link OfferInfoImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferInfoImpl#equals(Object)}
   *   <li>{@link OfferInfoImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(offerInfoImpl, offerInfoImpl);
    int expectedHashCodeResult = offerInfoImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerInfoImpl.hashCode());
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferInfoImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(2L);

    OfferInfoImpl offerInfoImpl2 = new OfferInfoImpl();
    offerInfoImpl2.setFieldValues(new HashMap<>());
    offerInfoImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(offerInfoImpl, offerInfoImpl2);
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferInfoImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<String, String> fieldValues = new HashMap<>();
    fieldValues.put("", "");

    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(fieldValues);
    offerInfoImpl.setId(null);

    OfferInfoImpl offerInfoImpl2 = new OfferInfoImpl();
    offerInfoImpl2.setFieldValues(new HashMap<>());
    offerInfoImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(offerInfoImpl, offerInfoImpl2);
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferInfoImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(offerInfoImpl, null);
  }

  /**
   * Test {@link OfferInfoImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferInfoImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(offerInfoImpl, "Different type to OfferInfoImpl");
  }

  /**
   * Test
   * {@link OfferInfoImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link OfferInfoImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferInfo> actualCreateOrRetrieveCopyInstanceResult = offerInfoImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link OfferInfoImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link OfferInfoImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferInfoImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnOfferInfoImpl() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<OfferInfo> actualCreateOrRetrieveCopyInstanceResult = offerInfoImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.offer.domain.OfferInfoImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    OfferInfo clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof OfferInfoImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(offerInfoImpl, clone);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OfferInfoImpl}
   *   <li>{@link OfferInfoImpl#setFieldValues(Map)}
   *   <li>{@link OfferInfoImpl#setId(Long)}
   *   <li>{@link OfferInfoImpl#getFieldValues()}
   *   <li>{@link OfferInfoImpl#getId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OfferInfoImpl actualOfferInfoImpl = new OfferInfoImpl();
    HashMap<String, String> fieldValues = new HashMap<>();
    actualOfferInfoImpl.setFieldValues(fieldValues);
    actualOfferInfoImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    Map<String, String> actualFieldValues = actualOfferInfoImpl.getFieldValues();
    Long actualId = actualOfferInfoImpl.getId();

    // Assert that nothing has changed
    assertTrue(actualFieldValues.isEmpty());
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(fieldValues, actualFieldValues);
  }
}
