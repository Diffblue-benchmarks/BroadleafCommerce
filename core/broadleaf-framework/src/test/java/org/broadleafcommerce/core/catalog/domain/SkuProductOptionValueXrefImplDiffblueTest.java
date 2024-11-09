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
package org.broadleafcommerce.core.catalog.domain;

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
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class SkuProductOptionValueXrefImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuProductOptionValueXrefImpl#SkuProductOptionValueXrefImpl()}
   *   <li>{@link SkuProductOptionValueXrefImpl#setId(Long)}
   *   <li>
   * {@link SkuProductOptionValueXrefImpl#setProductOptionValue(ProductOptionValue)}
   *   <li>{@link SkuProductOptionValueXrefImpl#setSku(Sku)}
   *   <li>{@link SkuProductOptionValueXrefImpl#getId()}
   *   <li>{@link SkuProductOptionValueXrefImpl#getProductOptionValue()}
   *   <li>{@link SkuProductOptionValueXrefImpl#getSku()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SkuProductOptionValueXrefImpl actualSkuProductOptionValueXrefImpl = new SkuProductOptionValueXrefImpl();
    actualSkuProductOptionValueXrefImpl.setId(1L);
    ProductOptionValueImpl productOptionValue = new ProductOptionValueImpl();
    actualSkuProductOptionValueXrefImpl.setProductOptionValue(productOptionValue);
    SkuImpl sku = new SkuImpl();
    actualSkuProductOptionValueXrefImpl.setSku(sku);
    Long actualId = actualSkuProductOptionValueXrefImpl.getId();
    ProductOptionValue actualProductOptionValue = actualSkuProductOptionValueXrefImpl.getProductOptionValue();
    Sku actualSku = actualSkuProductOptionValueXrefImpl.getSku();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertSame(productOptionValue, actualProductOptionValue);
    assertSame(sku, actualSku);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SkuProductOptionValueXrefImpl#SkuProductOptionValueXrefImpl(Sku, ProductOptionValue)}
   *   <li>{@link SkuProductOptionValueXrefImpl#setId(Long)}
   *   <li>
   * {@link SkuProductOptionValueXrefImpl#setProductOptionValue(ProductOptionValue)}
   *   <li>{@link SkuProductOptionValueXrefImpl#setSku(Sku)}
   *   <li>{@link SkuProductOptionValueXrefImpl#getId()}
   *   <li>{@link SkuProductOptionValueXrefImpl#getProductOptionValue()}
   *   <li>{@link SkuProductOptionValueXrefImpl#getSku()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenSkuImpl() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act
    SkuProductOptionValueXrefImpl actualSkuProductOptionValueXrefImpl = new SkuProductOptionValueXrefImpl(sku,
        new ProductOptionValueImpl());
    actualSkuProductOptionValueXrefImpl.setId(1L);
    ProductOptionValueImpl productOptionValue = new ProductOptionValueImpl();
    actualSkuProductOptionValueXrefImpl.setProductOptionValue(productOptionValue);
    SkuImpl sku2 = new SkuImpl();
    actualSkuProductOptionValueXrefImpl.setSku(sku2);
    Long actualId = actualSkuProductOptionValueXrefImpl.getId();
    ProductOptionValue actualProductOptionValue = actualSkuProductOptionValueXrefImpl.getProductOptionValue();
    Sku actualSku = actualSkuProductOptionValueXrefImpl.getSku();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertSame(productOptionValue, actualProductOptionValue);
    assertSame(sku2, actualSku);
  }

  /**
   * Test
   * {@link SkuProductOptionValueXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link SkuProductOptionValueXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl = new SkuProductOptionValueXrefImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SkuProductOptionValueXref> actualCreateOrRetrieveCopyInstanceResult = skuProductOptionValueXrefImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link SkuProductOptionValueXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link SkuProductOptionValueXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValueImpl productOptionValue = mock(ProductOptionValueImpl.class);
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    when(productOptionValue.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(productOptionValueImpl, true));

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl = new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setProductOptionValue(productOptionValue);

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl2 = new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl2.setId(1L);
    skuProductOptionValueXrefImpl2.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl2.setSku(new SkuImpl());
    CreateResponse<Object> createResponse = new CreateResponse<>(skuProductOptionValueXrefImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(new HashMap<>());
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SkuProductOptionValueXref> actualCreateOrRetrieveCopyInstanceResult = skuProductOptionValueXrefImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    verify(productOptionValue).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    SkuProductOptionValueXref clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof SkuProductOptionValueXrefImpl);
    assertSame(productOptionValueImpl, clone.getProductOptionValue());
  }

  /**
   * Test
   * {@link SkuProductOptionValueXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link SkuProductOptionValueXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl = new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setProductOptionValue(mock(ProductOptionValueImpl.class));

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl2 = new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl2.setId(1L);
    skuProductOptionValueXrefImpl2.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl2.setSku(new SkuImpl());
    CreateResponse<Object> createResponse = new CreateResponse<>(skuProductOptionValueXrefImpl2, false);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("MANUAL_DUPLICATION", "MANUAL_DUPLICATION");
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SkuProductOptionValueXref> actualCreateOrRetrieveCopyInstanceResult = skuProductOptionValueXrefImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link SkuProductOptionValueXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then return not AlreadyPopulated.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuProductOptionValueXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenReturnNotAlreadyPopulated() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl = new SkuProductOptionValueXrefImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<SkuProductOptionValueXref> actualCreateOrRetrieveCopyInstanceResult = skuProductOptionValueXrefImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.core.catalog.domain.SkuProductOptionValueXrefImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    SkuProductOptionValueXref clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof SkuProductOptionValueXrefImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(skuProductOptionValueXrefImpl, clone);
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}, and
   * {@link SkuProductOptionValueXrefImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuProductOptionValueXrefImpl#equals(Object)}
   *   <li>{@link SkuProductOptionValueXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl = new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(1L);
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl.setSku(new SkuImpl());

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl2 = new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl2.setId(1L);
    skuProductOptionValueXrefImpl2.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertEquals(skuProductOptionValueXrefImpl, skuProductOptionValueXrefImpl2);
    int expectedHashCodeResult = skuProductOptionValueXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuProductOptionValueXrefImpl2.hashCode());
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}, and
   * {@link SkuProductOptionValueXrefImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuProductOptionValueXrefImpl#equals(Object)}
   *   <li>{@link SkuProductOptionValueXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl = new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(1L);
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl.setSku(new SkuImpl());

    // Act and Assert
    assertEquals(skuProductOptionValueXrefImpl, skuProductOptionValueXrefImpl);
    int expectedHashCodeResult = skuProductOptionValueXrefImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuProductOptionValueXrefImpl.hashCode());
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuProductOptionValueXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl = new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(2L);
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl.setSku(new SkuImpl());

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl2 = new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl2.setId(1L);
    skuProductOptionValueXrefImpl2.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuProductOptionValueXrefImpl, skuProductOptionValueXrefImpl2);
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuProductOptionValueXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl = new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(1L);
    skuProductOptionValueXrefImpl.setProductOptionValue(null);
    skuProductOptionValueXrefImpl.setSku(new SkuImpl());

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl2 = new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl2.setId(1L);
    skuProductOptionValueXrefImpl2.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuProductOptionValueXrefImpl, skuProductOptionValueXrefImpl2);
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuProductOptionValueXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl = new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(1L);
    skuProductOptionValueXrefImpl.setProductOptionValue(mock(ProductOptionValueImpl.class));
    skuProductOptionValueXrefImpl.setSku(new SkuImpl());

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl2 = new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl2.setId(1L);
    skuProductOptionValueXrefImpl2.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuProductOptionValueXrefImpl, skuProductOptionValueXrefImpl2);
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuProductOptionValueXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl = new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(1L);
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl.setSku(null);

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl2 = new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl2.setId(1L);
    skuProductOptionValueXrefImpl2.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuProductOptionValueXrefImpl, skuProductOptionValueXrefImpl2);
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuProductOptionValueXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl = new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(1L);
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuProductOptionValueXrefImpl, null);
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuProductOptionValueXrefImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl = new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(1L);
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuProductOptionValueXrefImpl, "Different type to SkuProductOptionValueXrefImpl");
  }
}
