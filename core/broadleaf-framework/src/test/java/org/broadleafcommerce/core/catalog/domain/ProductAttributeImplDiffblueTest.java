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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
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
import org.broadleafcommerce.core.catalog.service.type.ProductBundlePricingModelType;
import org.junit.Test;
import org.mockito.Mockito;

public class ProductAttributeImplDiffblueTest {
  /**
   * Test {@link ProductAttributeImpl#getValue()}.
   * <ul>
   *   <li>Given {@link ProductAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductAttributeImpl#getValue()}
   */
  @Test
  public void testGetValue_givenProductAttributeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductAttributeImpl()).getValue());
  }

  /**
   * Test {@link ProductAttributeImpl#getValue()}.
   * <ul>
   *   <li>Given {@link ProductAttributeImpl} (default constructor) Product is
   * {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductAttributeImpl#getValue()}
   */
  @Test
  public void testGetValue_givenProductAttributeImplProductIsProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setProduct(mock(ProductBundleImpl.class));

    // Act and Assert
    assertNull(productAttributeImpl.getValue());
  }

  /**
   * Test {@link ProductAttributeImpl#getName()}.
   * <ul>
   *   <li>Given {@link ProductAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductAttributeImpl#getName()}
   */
  @Test
  public void testGetName_givenProductAttributeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductAttributeImpl()).getName());
  }

  /**
   * Test {@link ProductAttributeImpl#getName()}.
   * <ul>
   *   <li>Given {@link ProductAttributeImpl} (default constructor) Product is
   * {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductAttributeImpl#getName()}
   */
  @Test
  public void testGetName_givenProductAttributeImplProductIsProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setProduct(mock(ProductBundleImpl.class));

    // Act and Assert
    assertNull(productAttributeImpl.getName());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and
   * {@link ProductAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(1L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl2);
    int expectedHashCodeResult = productAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, productAttributeImpl2.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and
   * {@link ProductAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl2);
    int expectedHashCodeResult = productAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, productAttributeImpl2.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and
   * {@link ProductAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(1L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(mock(Product.class));
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl2);
    int notExpectedHashCodeResult = productAttributeImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, productAttributeImpl2.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and
   * {@link ProductAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(1L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(null);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl2);
    int expectedHashCodeResult = productAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, productAttributeImpl2.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}, and
   * {@link ProductAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductAttributeImpl#equals(Object)}
   *   <li>{@link ProductAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(1L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(productAttributeImpl, productAttributeImpl);
    int expectedHashCodeResult = productAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, productAttributeImpl.hashCode());
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(2L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("42");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName(null);
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();
    product.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(product);
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(null);
    productAttributeImpl.setValue("42");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("Name");

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(null);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue(null);

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, productAttributeImpl2);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(1L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, null);
  }

  /**
   * Test {@link ProductAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setId(1L);
    productAttributeImpl.setName("Name");
    productAttributeImpl.setProduct(new ProductBundleImpl());
    productAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(productAttributeImpl, "Different type to ProductAttributeImpl");
  }

  /**
   * Test
   * {@link ProductAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link ProductAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductAttribute> actualCreateOrRetrieveCopyInstanceResult = productAttributeImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link ProductAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link ProductAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new ProductBundleImpl(), true));

    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setProduct(product);

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(productAttributeImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    productAttributeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(product).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test
   * {@link ProductAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link ProductAttributeImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnProductAttributeImpl() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<ProductAttribute> actualCreateOrRetrieveCopyInstanceResult = productAttributeImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.core.catalog.domain.ProductAttributeImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    ProductAttribute clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof ProductAttributeImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(productAttributeImpl, clone);
  }

  /**
   * Test
   * {@link ProductAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then throw {@link CloneNotSupportedException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenThrowCloneNotSupportedException() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException("foo"));

    ProductAttributeImpl productAttributeImpl = new ProductAttributeImpl();
    productAttributeImpl.setProduct(product);

    ProductAttributeImpl productAttributeImpl2 = new ProductAttributeImpl();
    productAttributeImpl2.setId(1L);
    productAttributeImpl2.setName("Name");
    productAttributeImpl2.setProduct(new ProductBundleImpl());
    productAttributeImpl2.setValue("42");
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(productAttributeImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(CloneNotSupportedException.class, () -> productAttributeImpl.createOrRetrieveCopyInstance(context));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(product).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ProductAttributeImpl}
   *   <li>{@link ProductAttributeImpl#setId(Long)}
   *   <li>{@link ProductAttributeImpl#setName(String)}
   *   <li>{@link ProductAttributeImpl#setProduct(Product)}
   *   <li>{@link ProductAttributeImpl#setValue(String)}
   *   <li>{@link ProductAttributeImpl#getId()}
   *   <li>{@link ProductAttributeImpl#getProduct()}
   *   <li>{@link ProductAttributeImpl#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ProductAttributeImpl actualProductAttributeImpl = new ProductAttributeImpl();
    actualProductAttributeImpl.setId(1L);
    actualProductAttributeImpl.setName("Name");
    ProductBundleImpl product = new ProductBundleImpl();
    actualProductAttributeImpl.setProduct(product);
    actualProductAttributeImpl.setValue("42");
    Long actualId = actualProductAttributeImpl.getId();
    Product actualProduct = actualProductAttributeImpl.getProduct();

    // Assert that nothing has changed
    assertEquals("42", actualProductAttributeImpl.toString());
    assertEquals(1L, actualId.longValue());
    assertSame(product, actualProduct);
  }
}
