/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.config.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType;
import org.broadleafcommerce.common.copy.DeferredOperation;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;

public class NullSystemPropertyDiffblueTest {
  /**
   * Test
   * {@link NullSystemProperty#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link NullSystemProperty#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    NullSystemProperty nullSystemProperty = new NullSystemProperty();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act and Assert
    assertNull(nullSystemProperty.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog,
        fromSite, toSite, genericEntityService, new MultiTenantCopierExtensionManager())));
  }

  /**
   * Test
   * {@link NullSystemProperty#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@link DeferredOperation}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NullSystemProperty#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_givenDeferredOperation() throws CloneNotSupportedException {
    // Arrange
    NullSystemProperty nullSystemProperty = new NullSystemProperty();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());
    context.addDeferredOperation(mock(DeferredOperation.class));

    // Act and Assert
    assertNull(nullSystemProperty.createOrRetrieveCopyInstance(context));
  }

  /**
   * Test {@link NullSystemProperty#equals(Object)}, and
   * {@link NullSystemProperty#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NullSystemProperty#equals(Object)}
   *   <li>{@link NullSystemProperty#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NullSystemProperty nullSystemProperty = new NullSystemProperty();
    NullSystemProperty nullSystemProperty2 = new NullSystemProperty();

    // Act and Assert
    assertEquals(nullSystemProperty, nullSystemProperty2);
    int expectedHashCodeResult = nullSystemProperty.hashCode();
    assertEquals(expectedHashCodeResult, nullSystemProperty2.hashCode());
  }

  /**
   * Test {@link NullSystemProperty#equals(Object)}, and
   * {@link NullSystemProperty#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NullSystemProperty#equals(Object)}
   *   <li>{@link NullSystemProperty#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NullSystemProperty nullSystemProperty = new NullSystemProperty();

    // Act and Assert
    assertEquals(nullSystemProperty, nullSystemProperty);
    int expectedHashCodeResult = nullSystemProperty.hashCode();
    assertEquals(expectedHashCodeResult, nullSystemProperty.hashCode());
  }

  /**
   * Test {@link NullSystemProperty#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullSystemProperty#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NullSystemProperty(), 3);
  }

  /**
   * Test {@link NullSystemProperty#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullSystemProperty#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NullSystemProperty(), null);
  }

  /**
   * Test {@link NullSystemProperty#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullSystemProperty#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NullSystemProperty(), "Different type to NullSystemProperty");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NullSystemProperty}
   *   <li>{@link NullSystemProperty#setFriendlyGroup(String)}
   *   <li>{@link NullSystemProperty#setFriendlyName(String)}
   *   <li>{@link NullSystemProperty#setFriendlyTab(String)}
   *   <li>{@link NullSystemProperty#setId(Long)}
   *   <li>{@link NullSystemProperty#setName(String)}
   *   <li>{@link NullSystemProperty#setOverrideGeneratedPropertyName(Boolean)}
   *   <li>{@link NullSystemProperty#setPropertyType(SystemPropertyFieldType)}
   *   <li>{@link NullSystemProperty#setValue(String)}
   *   <li>{@link NullSystemProperty#getFriendlyGroup()}
   *   <li>{@link NullSystemProperty#getFriendlyName()}
   *   <li>{@link NullSystemProperty#getFriendlyTab()}
   *   <li>{@link NullSystemProperty#getId()}
   *   <li>{@link NullSystemProperty#getName()}
   *   <li>{@link NullSystemProperty#getOverrideGeneratedPropertyName()}
   *   <li>{@link NullSystemProperty#getPropertyType()}
   *   <li>{@link NullSystemProperty#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    NullSystemProperty actualNullSystemProperty = new NullSystemProperty();
    actualNullSystemProperty.setFriendlyGroup("Friendly Group");
    actualNullSystemProperty.setFriendlyName("Friendly Name");
    actualNullSystemProperty.setFriendlyTab("Friendly Tab");
    actualNullSystemProperty.setId(1L);
    actualNullSystemProperty.setName("Name");
    actualNullSystemProperty.setOverrideGeneratedPropertyName(true);
    actualNullSystemProperty.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);
    actualNullSystemProperty.setValue("42");
    String actualFriendlyGroup = actualNullSystemProperty.getFriendlyGroup();
    String actualFriendlyName = actualNullSystemProperty.getFriendlyName();
    String actualFriendlyTab = actualNullSystemProperty.getFriendlyTab();
    Long actualId = actualNullSystemProperty.getId();
    String actualName = actualNullSystemProperty.getName();
    Boolean actualOverrideGeneratedPropertyName = actualNullSystemProperty.getOverrideGeneratedPropertyName();
    SystemPropertyFieldType actualPropertyType = actualNullSystemProperty.getPropertyType();

    // Assert that nothing has changed
    assertNull(actualOverrideGeneratedPropertyName);
    assertNull(actualId);
    assertNull(actualFriendlyGroup);
    assertNull(actualFriendlyName);
    assertNull(actualFriendlyTab);
    assertNull(actualName);
    assertNull(actualNullSystemProperty.getValue());
    assertNull(actualPropertyType);
  }
}
