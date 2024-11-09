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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.order.fulfillment.domain.BandedPriceFulfillmentOptionImpl;
import org.broadleafcommerce.core.order.fulfillment.domain.FixedPriceFulfillmentOptionImpl;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.junit.Test;
import org.mockito.Mockito;

public class FulfillmentOptionImplDiffblueTest {
  /**
   * Test {@link FulfillmentOptionImpl#getName()}.
   * <ul>
   *   <li>Given {@link FulfillmentOptionImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentOptionImpl#getName()}
   */
  @Test
  public void testGetName_givenFulfillmentOptionImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentOptionImpl()).getName());
  }

  /**
   * Test {@link FulfillmentOptionImpl#getName()}.
   * <ul>
   *   <li>Given {@link FulfillmentType} {@link FulfillmentType#getType()} return
   * {@code name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentOptionImpl#getName()}
   */
  @Test
  public void testGetName_givenFulfillmentTypeGetTypeReturnName_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentType fulfillmentType = mock(FulfillmentType.class);
    when(fulfillmentType.getType()).thenReturn("name");

    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl = new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl.setCurrency(new BroadleafCurrencyImpl());
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fixedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl.setName("Name");
    fixedPriceFulfillmentOptionImpl.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl.setTaxable(true);
    fixedPriceFulfillmentOptionImpl.setUseFlatRates(true);
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(fulfillmentType);

    // Act
    String actualName = fixedPriceFulfillmentOptionImpl.getName();

    // Assert
    verify(fulfillmentType).getType();
    assertEquals("Name", actualName);
  }

  /**
   * Test {@link FulfillmentOptionImpl#getName()}.
   * <ul>
   *   <li>Given {@link FulfillmentType} {@link FulfillmentType#getType()} return
   * {@code Type}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentOptionImpl#getName()}
   */
  @Test
  public void testGetName_givenFulfillmentTypeGetTypeReturnType_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentType fulfillmentType = mock(FulfillmentType.class);
    when(fulfillmentType.getType()).thenReturn("Type");

    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    fulfillmentOptionImpl.setFulfillmentType(fulfillmentType);

    // Act
    String actualName = fulfillmentOptionImpl.getName();

    // Assert
    verify(fulfillmentType).getType();
    assertNull(actualName);
  }

  /**
   * Test {@link FulfillmentOptionImpl#getLongDescription()}.
   * <ul>
   *   <li>Given {@link FulfillmentOptionImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentOptionImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription_givenFulfillmentOptionImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentOptionImpl()).getLongDescription());
  }

  /**
   * Test {@link FulfillmentOptionImpl#getLongDescription()}.
   * <ul>
   *   <li>Given {@link FulfillmentType} {@link FulfillmentType#getType()} return
   * {@code Type}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentOptionImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription_givenFulfillmentTypeGetTypeReturnType_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentType fulfillmentType = mock(FulfillmentType.class);
    when(fulfillmentType.getType()).thenReturn("Type");

    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    fulfillmentOptionImpl.setFulfillmentType(fulfillmentType);

    // Act
    String actualLongDescription = fulfillmentOptionImpl.getLongDescription();

    // Assert
    verify(fulfillmentType).getType();
    assertNull(actualLongDescription);
  }

  /**
   * Test {@link FulfillmentOptionImpl#getLongDescription()}.
   * <ul>
   *   <li>Then return {@code Long Description}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentOptionImpl#getLongDescription()}
   */
  @Test
  public void testGetLongDescription_thenReturnLongDescription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentType fulfillmentType = mock(FulfillmentType.class);
    when(fulfillmentType.getType()).thenReturn("longDescription");

    FixedPriceFulfillmentOptionImpl fixedPriceFulfillmentOptionImpl = new FixedPriceFulfillmentOptionImpl();
    fixedPriceFulfillmentOptionImpl.setCurrency(new BroadleafCurrencyImpl());
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fixedPriceFulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fixedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    fixedPriceFulfillmentOptionImpl.setName("Name");
    fixedPriceFulfillmentOptionImpl.setPrice(new Money());
    fixedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    fixedPriceFulfillmentOptionImpl.setTaxable(true);
    fixedPriceFulfillmentOptionImpl.setUseFlatRates(true);
    fixedPriceFulfillmentOptionImpl.setFulfillmentType(fulfillmentType);

    // Act
    String actualLongDescription = fixedPriceFulfillmentOptionImpl.getLongDescription();

    // Assert
    verify(fulfillmentType).getType();
    assertEquals("Long Description", actualLongDescription);
  }

  /**
   * Test {@link FulfillmentOptionImpl#getFulfillmentType()}.
   * <ul>
   *   <li>Given {@link FulfillmentOptionImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentOptionImpl#getFulfillmentType()}
   */
  @Test
  public void testGetFulfillmentType_givenFulfillmentOptionImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentOptionImpl()).getFulfillmentType());
  }

  /**
   * Test {@link FulfillmentOptionImpl#setFulfillmentType(FulfillmentType)}.
   * <ul>
   *   <li>Then {@link FulfillmentOptionImpl} (default constructor)
   * {@link FulfillmentOptionImpl#fulfillmentType} is {@code DIGITAL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentOptionImpl#setFulfillmentType(FulfillmentType)}
   */
  @Test
  public void testSetFulfillmentType_thenFulfillmentOptionImplFulfillmentTypeIsDigital() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    FulfillmentType fulfillmentType = FulfillmentType.DIGITAL;

    // Act
    fulfillmentOptionImpl.setFulfillmentType(fulfillmentType);

    // Assert
    assertEquals("DIGITAL", fulfillmentOptionImpl.fulfillmentType);
    FulfillmentType expectedFulfillmentType = fulfillmentType.DIGITAL;
    assertSame(expectedFulfillmentType, fulfillmentOptionImpl.getFulfillmentType());
  }

  /**
   * Test {@link FulfillmentOptionImpl#setFulfillmentType(FulfillmentType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FulfillmentOptionImpl} (default constructor)
   * {@link FulfillmentOptionImpl#fulfillmentType} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentOptionImpl#setFulfillmentType(FulfillmentType)}
   */
  @Test
  public void testSetFulfillmentType_whenNull_thenFulfillmentOptionImplFulfillmentTypeIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();

    // Act
    fulfillmentOptionImpl.setFulfillmentType(null);

    // Assert
    assertNull(fulfillmentOptionImpl.fulfillmentType);
    assertNull(fulfillmentOptionImpl.getFulfillmentType());
  }

  /**
   * Test {@link FulfillmentOptionImpl#equals(Object)}, and
   * {@link FulfillmentOptionImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentOptionImpl#equals(Object)}
   *   <li>{@link FulfillmentOptionImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    fulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentOptionImpl.setLongDescription("Long Description");
    fulfillmentOptionImpl.setName("Name");
    fulfillmentOptionImpl.setTaxCode("Tax Code");
    fulfillmentOptionImpl.setTaxable(true);
    fulfillmentOptionImpl.setUseFlatRates(true);

    FulfillmentOptionImpl fulfillmentOptionImpl2 = new FulfillmentOptionImpl();
    fulfillmentOptionImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentOptionImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentOptionImpl2.setLongDescription("Long Description");
    fulfillmentOptionImpl2.setName("Name");
    fulfillmentOptionImpl2.setTaxCode("Tax Code");
    fulfillmentOptionImpl2.setTaxable(true);
    fulfillmentOptionImpl2.setUseFlatRates(true);

    // Act and Assert
    assertEquals(fulfillmentOptionImpl, fulfillmentOptionImpl2);
    int expectedHashCodeResult = fulfillmentOptionImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentOptionImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentOptionImpl#equals(Object)}, and
   * {@link FulfillmentOptionImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentOptionImpl#equals(Object)}
   *   <li>{@link FulfillmentOptionImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    fulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentOptionImpl.setLongDescription("Long Description");
    fulfillmentOptionImpl.setName("Name");
    fulfillmentOptionImpl.setTaxCode("Tax Code");
    fulfillmentOptionImpl.setTaxable(true);
    fulfillmentOptionImpl.setUseFlatRates(true);

    // Act and Assert
    assertEquals(fulfillmentOptionImpl, fulfillmentOptionImpl);
    int expectedHashCodeResult = fulfillmentOptionImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentOptionImpl.hashCode());
  }

  /**
   * Test {@link FulfillmentOptionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentOptionImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BandedPriceFulfillmentOptionImpl bandedPriceFulfillmentOptionImpl = new BandedPriceFulfillmentOptionImpl();
    bandedPriceFulfillmentOptionImpl.setBands(new ArrayList<>());
    bandedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    bandedPriceFulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bandedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    bandedPriceFulfillmentOptionImpl.setName("Name");
    bandedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    bandedPriceFulfillmentOptionImpl.setTaxable(true);
    bandedPriceFulfillmentOptionImpl.setUseFlatRates(true);
    bandedPriceFulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    bandedPriceFulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bandedPriceFulfillmentOptionImpl.setLongDescription("Long Description");
    bandedPriceFulfillmentOptionImpl.setName("Name");
    bandedPriceFulfillmentOptionImpl.setTaxCode("Tax Code");
    bandedPriceFulfillmentOptionImpl.setTaxable(true);
    bandedPriceFulfillmentOptionImpl.setUseFlatRates(true);

    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    fulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentOptionImpl.setLongDescription("Long Description");
    fulfillmentOptionImpl.setName("Name");
    fulfillmentOptionImpl.setTaxCode("Tax Code");
    fulfillmentOptionImpl.setTaxable(true);
    fulfillmentOptionImpl.setUseFlatRates(true);

    // Act and Assert
    assertNotEquals(bandedPriceFulfillmentOptionImpl, fulfillmentOptionImpl);
  }

  /**
   * Test {@link FulfillmentOptionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentOptionImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FulfillmentType fulfillmentType = mock(FulfillmentType.class);
    when(fulfillmentType.getType()).thenReturn("Type");

    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    fulfillmentOptionImpl.setFulfillmentType(fulfillmentType);
    fulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentOptionImpl.setLongDescription("Long Description");
    fulfillmentOptionImpl.setName("Name");
    fulfillmentOptionImpl.setTaxCode("Tax Code");
    fulfillmentOptionImpl.setTaxable(true);
    fulfillmentOptionImpl.setUseFlatRates(true);

    FulfillmentOptionImpl fulfillmentOptionImpl2 = new FulfillmentOptionImpl();
    fulfillmentOptionImpl2.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentOptionImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentOptionImpl2.setLongDescription("Long Description");
    fulfillmentOptionImpl2.setName("Name");
    fulfillmentOptionImpl2.setTaxCode("Tax Code");
    fulfillmentOptionImpl2.setTaxable(true);
    fulfillmentOptionImpl2.setUseFlatRates(true);

    // Act and Assert
    assertNotEquals(fulfillmentOptionImpl, fulfillmentOptionImpl2);
  }

  /**
   * Test {@link FulfillmentOptionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentOptionImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    fulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentOptionImpl.setLongDescription("Long Description");
    fulfillmentOptionImpl.setName("Name");
    fulfillmentOptionImpl.setTaxCode("Tax Code");
    fulfillmentOptionImpl.setTaxable(true);
    fulfillmentOptionImpl.setUseFlatRates(true);

    // Act and Assert
    assertNotEquals(fulfillmentOptionImpl, null);
  }

  /**
   * Test {@link FulfillmentOptionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentOptionImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    fulfillmentOptionImpl.setFulfillmentType(FulfillmentType.DIGITAL);
    fulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentOptionImpl.setLongDescription("Long Description");
    fulfillmentOptionImpl.setName("Name");
    fulfillmentOptionImpl.setTaxCode("Tax Code");
    fulfillmentOptionImpl.setTaxable(true);
    fulfillmentOptionImpl.setUseFlatRates(true);

    // Act and Assert
    assertNotEquals(fulfillmentOptionImpl, "Different type to FulfillmentOptionImpl");
  }

  /**
   * Test
   * {@link FulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link FulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FulfillmentOption> actualCreateOrRetrieveCopyInstanceResult = fulfillmentOptionImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link FulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then calls {@link CreateResponse#getClone()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCallsGetClone() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    BandedPriceFulfillmentOptionImpl bandedPriceFulfillmentOptionImpl = mock(BandedPriceFulfillmentOptionImpl.class);
    doNothing().when(bandedPriceFulfillmentOptionImpl).setFulfillmentType(Mockito.<FulfillmentType>any());
    doNothing().when(bandedPriceFulfillmentOptionImpl).setLongDescription(Mockito.<String>any());
    doNothing().when(bandedPriceFulfillmentOptionImpl).setName(Mockito.<String>any());
    doNothing().when(bandedPriceFulfillmentOptionImpl).setTaxCode(Mockito.<String>any());
    doNothing().when(bandedPriceFulfillmentOptionImpl).setTaxable(Mockito.<Boolean>any());
    doNothing().when(bandedPriceFulfillmentOptionImpl).setUseFlatRates(Mockito.<Boolean>any());
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(bandedPriceFulfillmentOptionImpl);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    fulfillmentOptionImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(bandedPriceFulfillmentOptionImpl).setFulfillmentType(isNull());
    verify(bandedPriceFulfillmentOptionImpl).setLongDescription(isNull());
    verify(bandedPriceFulfillmentOptionImpl).setName(isNull());
    verify(bandedPriceFulfillmentOptionImpl).setTaxCode(isNull());
    verify(bandedPriceFulfillmentOptionImpl).setTaxable(eq(false));
    verify(bandedPriceFulfillmentOptionImpl).setUseFlatRates(eq(true));
  }

  /**
   * Test
   * {@link FulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link FulfillmentOptionImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentOptionImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnFulfillmentOptionImpl()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<FulfillmentOption> actualCreateOrRetrieveCopyInstanceResult = fulfillmentOptionImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    FulfillmentOption clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof FulfillmentOptionImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(fulfillmentOptionImpl, clone);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FulfillmentOptionImpl}
   *   <li>{@link FulfillmentOptionImpl#setId(Long)}
   *   <li>{@link FulfillmentOptionImpl#setLongDescription(String)}
   *   <li>{@link FulfillmentOptionImpl#setName(String)}
   *   <li>{@link FulfillmentOptionImpl#setTaxCode(String)}
   *   <li>{@link FulfillmentOptionImpl#setTaxable(Boolean)}
   *   <li>{@link FulfillmentOptionImpl#setUseFlatRates(Boolean)}
   *   <li>{@link FulfillmentOptionImpl#getId()}
   *   <li>{@link FulfillmentOptionImpl#getTaxCode()}
   *   <li>{@link FulfillmentOptionImpl#getTaxable()}
   *   <li>{@link FulfillmentOptionImpl#getUseFlatRates()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FulfillmentOptionImpl actualFulfillmentOptionImpl = new FulfillmentOptionImpl();
    actualFulfillmentOptionImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    actualFulfillmentOptionImpl.setLongDescription("Long Description");
    actualFulfillmentOptionImpl.setName("Name");
    actualFulfillmentOptionImpl.setTaxCode("Tax Code");
    actualFulfillmentOptionImpl.setTaxable(true);
    actualFulfillmentOptionImpl.setUseFlatRates(true);
    Long actualId = actualFulfillmentOptionImpl.getId();
    String actualTaxCode = actualFulfillmentOptionImpl.getTaxCode();
    Boolean actualTaxable = actualFulfillmentOptionImpl.getTaxable();

    // Assert that nothing has changed
    assertEquals("Tax Code", actualTaxCode);
    assertTrue(actualTaxable);
    assertTrue(actualFulfillmentOptionImpl.getUseFlatRates());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
  }
}
