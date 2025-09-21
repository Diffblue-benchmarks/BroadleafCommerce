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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
public class SkuAttributeImplDiffblueTest {
  @Autowired private SkuAttributeImpl skuAttributeImpl;

  /**
   * Test {@link SkuAttributeImpl#getValue()}.
   *
   * <p>Method under test: {@link SkuAttributeImpl#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuAttributeImpl.getValue()"})
  public void testGetValue() {
    // Arrange, Act and Assert
    assertNull(skuAttributeImpl.getValue());
  }

  /**
   * Test {@link SkuAttributeImpl#getName()}.
   *
   * <p>Method under test: {@link SkuAttributeImpl#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SkuAttributeImpl.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull(skuAttributeImpl.getName());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and {@link SkuAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(1L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl2);
    assertEquals(skuAttributeImpl.hashCode(), skuAttributeImpl2.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and {@link SkuAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl2);
    assertEquals(skuAttributeImpl.hashCode(), skuAttributeImpl2.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and {@link SkuAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(1L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(null);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl2);
    assertEquals(skuAttributeImpl.hashCode(), skuAttributeImpl2.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and {@link SkuAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName(null);
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName(null);
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl2);
    assertEquals(skuAttributeImpl.hashCode(), skuAttributeImpl2.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and {@link SkuAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(null);
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(null);
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl2);
    assertEquals(skuAttributeImpl.hashCode(), skuAttributeImpl2.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and {@link SkuAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue(null);

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue(null);

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl2);
    assertEquals(skuAttributeImpl.hashCode(), skuAttributeImpl2.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}, and {@link SkuAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SkuAttributeImpl#equals(Object)}
   *   <li>{@link SkuAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(1L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(skuAttributeImpl, skuAttributeImpl);
    int expectedHashCodeResult = skuAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuAttributeImpl.hashCode());
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(2L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName(null);
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(null);
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(mock(SkuImpl.class));
    skuAttributeImpl.setValue("42");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("Name");

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(null);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue(null);

    SkuAttributeImpl skuAttributeImpl2 = new SkuAttributeImpl();
    skuAttributeImpl2.setId(1L);
    skuAttributeImpl2.setName("Name");
    skuAttributeImpl2.setSku(new SkuImpl());
    skuAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, skuAttributeImpl2);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(1L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, null);
  }

  /**
   * Test {@link SkuAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SkuAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuAttributeImpl.equals(Object)", "int SkuAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setId(1L);
    skuAttributeImpl.setName("Name");
    skuAttributeImpl.setSku(new SkuImpl());
    skuAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(skuAttributeImpl, "Different type to SkuAttributeImpl");
  }

  /**
   * Test {@link SkuAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SkuAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuAttributeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new SkuAttributeImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SkuAttribute> actualCreateOrRetrieveCopyInstanceResult =
        skuAttributeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link SkuAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SkuAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuAttributeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(skuAttributeImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SkuAttribute> actualCreateOrRetrieveCopyInstanceResult =
        skuAttributeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link SkuAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SkuAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuAttributeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new SkuImpl(), true));

    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setSku(sku);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new SkuAttributeImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    skuAttributeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(sku).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test {@link SkuAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then throw {@link CloneNotSupportedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SkuAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SkuAttributeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenThrowCloneNotSupportedException()
      throws CloneNotSupportedException {
    // Arrange
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException());

    SkuAttributeImpl skuAttributeImpl = new SkuAttributeImpl();
    skuAttributeImpl.setSku(sku);

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new SkuAttributeImpl());

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(
        CloneNotSupportedException.class,
        () -> skuAttributeImpl.createOrRetrieveCopyInstance(context));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(sku).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SkuAttributeImpl}
   *   <li>{@link SkuAttributeImpl#setId(Long)}
   *   <li>{@link SkuAttributeImpl#setName(String)}
   *   <li>{@link SkuAttributeImpl#setSku(Sku)}
   *   <li>{@link SkuAttributeImpl#setValue(String)}
   *   <li>{@link SkuAttributeImpl#getId()}
   *   <li>{@link SkuAttributeImpl#getSku()}
   *   <li>{@link SkuAttributeImpl#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SkuAttributeImpl.<init>()",
    "Long SkuAttributeImpl.getId()",
    "Sku SkuAttributeImpl.getSku()",
    "void SkuAttributeImpl.setId(Long)",
    "void SkuAttributeImpl.setName(String)",
    "void SkuAttributeImpl.setSku(Sku)",
    "void SkuAttributeImpl.setValue(String)",
    "String SkuAttributeImpl.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SkuAttributeImpl actualSkuAttributeImpl = new SkuAttributeImpl();
    actualSkuAttributeImpl.setId(1L);
    actualSkuAttributeImpl.setName("Name");
    SkuImpl sku = new SkuImpl();
    actualSkuAttributeImpl.setSku(sku);
    actualSkuAttributeImpl.setValue("42");
    Long actualId = actualSkuAttributeImpl.getId();
    Sku actualSku = actualSkuAttributeImpl.getSku();

    // Assert
    assertEquals("42", actualSkuAttributeImpl.toString());
    assertEquals(1L, actualId.longValue());
    assertSame(sku, actualSku);
  }
}
