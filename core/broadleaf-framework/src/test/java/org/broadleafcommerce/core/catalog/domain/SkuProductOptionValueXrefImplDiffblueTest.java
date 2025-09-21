/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class SkuProductOptionValueXrefImplDiffblueTest {
  @Autowired private SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuProductOptionValueXrefImpl#SkuProductOptionValueXrefImpl()}
   *   <li>{@link SkuProductOptionValueXrefImpl#setId(Long)}
   *   <li>{@link SkuProductOptionValueXrefImpl#setProductOptionValue(ProductOptionValue)}
   *   <li>{@link SkuProductOptionValueXrefImpl#setSku(Sku)}
   *   <li>{@link SkuProductOptionValueXrefImpl#getId()}
   *   <li>{@link SkuProductOptionValueXrefImpl#getProductOptionValue()}
   *   <li>{@link SkuProductOptionValueXrefImpl#getSku()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuProductOptionValueXrefImpl.<init>()",
    "void SkuProductOptionValueXrefImpl.<init>(Sku, ProductOptionValue)",
    "Long SkuProductOptionValueXrefImpl.getId()",
    "ProductOptionValue SkuProductOptionValueXrefImpl.getProductOptionValue()",
    "Sku SkuProductOptionValueXrefImpl.getSku()",
    "void SkuProductOptionValueXrefImpl.setId(Long)",
    "void SkuProductOptionValueXrefImpl.setProductOptionValue(ProductOptionValue)",
    "void SkuProductOptionValueXrefImpl.setSku(Sku)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SkuProductOptionValueXrefImpl actualSkuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
    actualSkuProductOptionValueXrefImpl.setId(1L);
    ProductOptionValueImpl productOptionValue = new ProductOptionValueImpl();
    actualSkuProductOptionValueXrefImpl.setProductOptionValue(productOptionValue);
    SkuImpl sku = new SkuImpl();
    actualSkuProductOptionValueXrefImpl.setSku(sku);
    Long actualId = actualSkuProductOptionValueXrefImpl.getId();
    ProductOptionValue actualProductOptionValue =
        actualSkuProductOptionValueXrefImpl.getProductOptionValue();
    Sku actualSku = actualSkuProductOptionValueXrefImpl.getSku();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertSame(productOptionValue, actualProductOptionValue);
    assertSame(sku, actualSku);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuProductOptionValueXrefImpl#SkuProductOptionValueXrefImpl(Sku,
   *       ProductOptionValue)}
   *   <li>{@link SkuProductOptionValueXrefImpl#setId(Long)}
   *   <li>{@link SkuProductOptionValueXrefImpl#setProductOptionValue(ProductOptionValue)}
   *   <li>{@link SkuProductOptionValueXrefImpl#setSku(Sku)}
   *   <li>{@link SkuProductOptionValueXrefImpl#getId()}
   *   <li>{@link SkuProductOptionValueXrefImpl#getProductOptionValue()}
   *   <li>{@link SkuProductOptionValueXrefImpl#getSku()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuProductOptionValueXrefImpl.<init>()",
    "void SkuProductOptionValueXrefImpl.<init>(Sku, ProductOptionValue)",
    "Long SkuProductOptionValueXrefImpl.getId()",
    "ProductOptionValue SkuProductOptionValueXrefImpl.getProductOptionValue()",
    "Sku SkuProductOptionValueXrefImpl.getSku()",
    "void SkuProductOptionValueXrefImpl.setId(Long)",
    "void SkuProductOptionValueXrefImpl.setProductOptionValue(ProductOptionValue)",
    "void SkuProductOptionValueXrefImpl.setSku(Sku)"
  })
  public void testGettersAndSetters_whenSkuImpl() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act
    SkuProductOptionValueXrefImpl actualSkuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl(sku, new ProductOptionValueImpl());
    actualSkuProductOptionValueXrefImpl.setId(1L);
    ProductOptionValueImpl productOptionValue = new ProductOptionValueImpl();
    actualSkuProductOptionValueXrefImpl.setProductOptionValue(productOptionValue);
    SkuImpl sku2 = new SkuImpl();
    actualSkuProductOptionValueXrefImpl.setSku(sku2);
    Long actualId = actualSkuProductOptionValueXrefImpl.getId();
    ProductOptionValue actualProductOptionValue =
        actualSkuProductOptionValueXrefImpl.getProductOptionValue();
    Sku actualSku = actualSkuProductOptionValueXrefImpl.getSku();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertSame(productOptionValue, actualProductOptionValue);
    assertSame(sku2, actualSku);
  }

  /**
   * Test {@link
   * SkuProductOptionValueXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SkuProductOptionValueXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuProductOptionValueXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(new SkuProductOptionValueXrefImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SkuProductOptionValueXref> actualCreateOrRetrieveCopyInstanceResult =
        skuProductOptionValueXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link
   * SkuProductOptionValueXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SkuProductOptionValueXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuProductOptionValueXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse =
        new CreateResponse<>(skuProductOptionValueXrefImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SkuProductOptionValueXref> actualCreateOrRetrieveCopyInstanceResult =
        skuProductOptionValueXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link
   * SkuProductOptionValueXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SkuProductOptionValueXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuProductOptionValueXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl2 =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl2.setId(1L);
    skuProductOptionValueXrefImpl2.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl2.setSku(new SkuImpl());
    CreateResponse<Object> createResponse =
        new CreateResponse<>(skuProductOptionValueXrefImpl2, false);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("MANUAL_DUPLICATION", "Copy Hints");

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SkuProductOptionValueXref> actualCreateOrRetrieveCopyInstanceResult =
        skuProductOptionValueXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link
   * SkuProductOptionValueXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SkuProductOptionValueXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuProductOptionValueXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance4() throws CloneNotSupportedException {
    // Arrange
    ProductOptionValueImpl productOptionValue = mock(ProductOptionValueImpl.class);
    when(productOptionValue.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new ProductOptionValueImpl(), true));

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setProductOptionValue(productOptionValue);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new SkuProductOptionValueXrefImpl());

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "Copy Hints");

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    skuProductOptionValueXrefImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    verify(productOptionValue).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test {@link
   * SkuProductOptionValueXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then throw {@link CloneNotSupportedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuProductOptionValueXrefImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuProductOptionValueXrefImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenThrowCloneNotSupportedException()
      throws CloneNotSupportedException {
    // Arrange
    ProductOptionValueImpl productOptionValue = mock(ProductOptionValueImpl.class);
    when(productOptionValue.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException());

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setProductOptionValue(productOptionValue);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new SkuProductOptionValueXrefImpl());

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "Copy Hints");

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(
        CloneNotSupportedException.class,
        () -> skuProductOptionValueXrefImpl.createOrRetrieveCopyInstance(context));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    verify(productOptionValue).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}, and {@link
   * SkuProductOptionValueXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuProductOptionValueXrefImpl#equals(Object)}
   *   <li>{@link SkuProductOptionValueXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuProductOptionValueXrefImpl.equals(Object)",
    "int SkuProductOptionValueXrefImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(1L);
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl.setSku(new SkuImpl());

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl2 =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl2.setId(1L);
    skuProductOptionValueXrefImpl2.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertEquals(skuProductOptionValueXrefImpl, skuProductOptionValueXrefImpl2);
    assertEquals(
        skuProductOptionValueXrefImpl.hashCode(), skuProductOptionValueXrefImpl2.hashCode());
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}, and {@link
   * SkuProductOptionValueXrefImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuProductOptionValueXrefImpl#equals(Object)}
   *   <li>{@link SkuProductOptionValueXrefImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuProductOptionValueXrefImpl.equals(Object)",
    "int SkuProductOptionValueXrefImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuProductOptionValueXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuProductOptionValueXrefImpl.equals(Object)",
    "int SkuProductOptionValueXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(2L);
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl.setSku(new SkuImpl());

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl2 =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl2.setId(1L);
    skuProductOptionValueXrefImpl2.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuProductOptionValueXrefImpl, skuProductOptionValueXrefImpl2);
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuProductOptionValueXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuProductOptionValueXrefImpl.equals(Object)",
    "int SkuProductOptionValueXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(1L);
    skuProductOptionValueXrefImpl.setProductOptionValue(null);
    skuProductOptionValueXrefImpl.setSku(new SkuImpl());

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl2 =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl2.setId(1L);
    skuProductOptionValueXrefImpl2.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuProductOptionValueXrefImpl, skuProductOptionValueXrefImpl2);
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuProductOptionValueXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuProductOptionValueXrefImpl.equals(Object)",
    "int SkuProductOptionValueXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(1L);
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl.setSku(null);

    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl2 =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl2.setId(1L);
    skuProductOptionValueXrefImpl2.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuProductOptionValueXrefImpl, skuProductOptionValueXrefImpl2);
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuProductOptionValueXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuProductOptionValueXrefImpl.equals(Object)",
    "int SkuProductOptionValueXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(1L);
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuProductOptionValueXrefImpl, null);
  }

  /**
   * Test {@link SkuProductOptionValueXrefImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuProductOptionValueXrefImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SkuProductOptionValueXrefImpl.equals(Object)",
    "int SkuProductOptionValueXrefImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SkuProductOptionValueXrefImpl skuProductOptionValueXrefImpl =
        new SkuProductOptionValueXrefImpl();
    skuProductOptionValueXrefImpl.setId(1L);
    skuProductOptionValueXrefImpl.setProductOptionValue(new ProductOptionValueImpl());
    skuProductOptionValueXrefImpl.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(
        skuProductOptionValueXrefImpl, "Different type to SkuProductOptionValueXrefImpl");
  }
}
