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

public class CategoryAttributeImplDiffblueTest {
  /**
   * Test {@link CategoryAttributeImpl#getValue()}.
   * <ul>
   *   <li>Given {@link CategoryAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryAttributeImpl#getValue()}
   */
  @Test
  public void testGetValue_givenCategoryAttributeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryAttributeImpl()).getValue());
  }

  /**
   * Test {@link CategoryAttributeImpl#getValue()}.
   * <ul>
   *   <li>Given {@link CategoryAttributeImpl} (default constructor) Category is
   * {@link CategoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryAttributeImpl#getValue()}
   */
  @Test
  public void testGetValue_givenCategoryAttributeImplCategoryIsCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(mock(CategoryImpl.class));

    // Act and Assert
    assertNull(categoryAttributeImpl.getValue());
  }

  /**
   * Test {@link CategoryAttributeImpl#getName()}.
   * <ul>
   *   <li>Given {@link CategoryAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryAttributeImpl#getName()}
   */
  @Test
  public void testGetName_givenCategoryAttributeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CategoryAttributeImpl()).getName());
  }

  /**
   * Test {@link CategoryAttributeImpl#getName()}.
   * <ul>
   *   <li>Given {@link CategoryAttributeImpl} (default constructor) Category is
   * {@link CategoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryAttributeImpl#getName()}
   */
  @Test
  public void testGetName_givenCategoryAttributeImplCategoryIsCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(mock(CategoryImpl.class));

    // Act and Assert
    assertNull(categoryAttributeImpl.getName());
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}, and
   * {@link CategoryAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryAttributeImpl#equals(Object)}
   *   <li>{@link CategoryAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(1L);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(categoryAttributeImpl, categoryAttributeImpl2);
    int expectedHashCodeResult = categoryAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}, and
   * {@link CategoryAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryAttributeImpl#equals(Object)}
   *   <li>{@link CategoryAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(mock(Category.class));
    categoryAttributeImpl.setId(1L);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(categoryAttributeImpl, categoryAttributeImpl2);
    int notExpectedHashCodeResult = categoryAttributeImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, categoryAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}, and
   * {@link CategoryAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryAttributeImpl#equals(Object)}
   *   <li>{@link CategoryAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(categoryAttributeImpl, categoryAttributeImpl2);
    int expectedHashCodeResult = categoryAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}, and
   * {@link CategoryAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryAttributeImpl#equals(Object)}
   *   <li>{@link CategoryAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(1L);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(null);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(categoryAttributeImpl, categoryAttributeImpl2);
    int expectedHashCodeResult = categoryAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}, and
   * {@link CategoryAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryAttributeImpl#equals(Object)}
   *   <li>{@link CategoryAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(null);
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(null);
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(categoryAttributeImpl, categoryAttributeImpl2);
    int expectedHashCodeResult = categoryAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}, and
   * {@link CategoryAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryAttributeImpl#equals(Object)}
   *   <li>{@link CategoryAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName(null);
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName(null);
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(categoryAttributeImpl, categoryAttributeImpl2);
    int expectedHashCodeResult = categoryAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryAttributeImpl2.hashCode());
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}, and
   * {@link CategoryAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CategoryAttributeImpl#equals(Object)}
   *   <li>{@link CategoryAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(1L);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(categoryAttributeImpl, categoryAttributeImpl);
    int expectedHashCodeResult = categoryAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, categoryAttributeImpl.hashCode());
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(2L);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(categoryAttributeImpl, categoryAttributeImpl2);
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(mock(Category.class));
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(categoryAttributeImpl, categoryAttributeImpl2);
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(null);
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(categoryAttributeImpl, categoryAttributeImpl2);
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName("42");
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(categoryAttributeImpl, categoryAttributeImpl2);
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName(null);
    categoryAttributeImpl.setValue("42");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(categoryAttributeImpl, categoryAttributeImpl2);
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("Name");

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(categoryAttributeImpl, categoryAttributeImpl2);
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(null);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue(null);

    CategoryAttributeImpl categoryAttributeImpl2 = new CategoryAttributeImpl();
    categoryAttributeImpl2.setCategory(new CategoryImpl());
    categoryAttributeImpl2.setId(1L);
    categoryAttributeImpl2.setName("Name");
    categoryAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(categoryAttributeImpl, categoryAttributeImpl2);
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(1L);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(categoryAttributeImpl, null);
  }

  /**
   * Test {@link CategoryAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CategoryAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    categoryAttributeImpl.setCategory(new CategoryImpl());
    categoryAttributeImpl.setId(1L);
    categoryAttributeImpl.setName("Name");
    categoryAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(categoryAttributeImpl, "Different type to CategoryAttributeImpl");
  }

  /**
   * Test
   * {@link CategoryAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link CategoryAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CategoryAttribute> actualCreateOrRetrieveCopyInstanceResult = categoryAttributeImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link CategoryAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link CategoryAttributeImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CategoryAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnCategoryAttributeImpl()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CategoryAttributeImpl categoryAttributeImpl = new CategoryAttributeImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<CategoryAttribute> actualCreateOrRetrieveCopyInstanceResult = categoryAttributeImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.core.catalog.domain.CategoryAttributeImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    CategoryAttribute clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof CategoryAttributeImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(categoryAttributeImpl, clone);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CategoryAttributeImpl}
   *   <li>{@link CategoryAttributeImpl#setCategory(Category)}
   *   <li>{@link CategoryAttributeImpl#setId(Long)}
   *   <li>{@link CategoryAttributeImpl#setName(String)}
   *   <li>{@link CategoryAttributeImpl#setValue(String)}
   *   <li>{@link CategoryAttributeImpl#getCategory()}
   *   <li>{@link CategoryAttributeImpl#getId()}
   *   <li>{@link CategoryAttributeImpl#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CategoryAttributeImpl actualCategoryAttributeImpl = new CategoryAttributeImpl();
    CategoryImpl category = new CategoryImpl();
    actualCategoryAttributeImpl.setCategory(category);
    actualCategoryAttributeImpl.setId(1L);
    actualCategoryAttributeImpl.setName("Name");
    actualCategoryAttributeImpl.setValue("42");
    Category actualCategory = actualCategoryAttributeImpl.getCategory();
    Long actualId = actualCategoryAttributeImpl.getId();

    // Assert that nothing has changed
    assertEquals("42", actualCategoryAttributeImpl.toString());
    assertEquals(1L, actualId.longValue());
    assertSame(category, actualCategory);
  }
}
