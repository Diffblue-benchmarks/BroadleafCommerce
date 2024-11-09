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
import org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.mockito.Mockito;

public class SystemPropertyImplDiffblueTest {
  /**
   * Test {@link SystemPropertyImpl#getPropertyType()}.
   * <ul>
   *   <li>Given {@link SystemPropertyFieldType}
   * {@link SystemPropertyFieldType#getType()} return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyImpl#getPropertyType()}
   */
  @Test
  public void testGetPropertyType_givenSystemPropertyFieldTypeGetTypeReturnFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyFieldType propertyType = mock(SystemPropertyFieldType.class);
    when(propertyType.getType()).thenReturn("foo");

    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setFriendlyGroup("Friendly Group");
    systemPropertyImpl.setFriendlyName("Friendly Name");
    systemPropertyImpl.setFriendlyTab("Friendly Tab");
    systemPropertyImpl.setId(1L);
    systemPropertyImpl.setName("Name");
    systemPropertyImpl.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl.setValue("42");
    systemPropertyImpl.setPropertyType(propertyType);

    // Act
    SystemPropertyFieldType actualPropertyType = systemPropertyImpl.getPropertyType();

    // Assert
    verify(propertyType).getType();
    assertSame(actualPropertyType.STRING_TYPE, actualPropertyType);
  }

  /**
   * Test {@link SystemPropertyImpl#getPropertyType()}.
   * <ul>
   *   <li>Given {@link SystemPropertyImpl} (default constructor).</li>
   *   <li>Then return {@link SystemPropertyFieldType#STRING_TYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyImpl#getPropertyType()}
   */
  @Test
  public void testGetPropertyType_givenSystemPropertyImpl_thenReturnString_type() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SystemPropertyFieldType actualPropertyType = (new SystemPropertyImpl()).getPropertyType();

    // Assert
    assertSame(actualPropertyType.STRING_TYPE, actualPropertyType);
  }

  /**
   * Test {@link SystemPropertyImpl#getPropertyType()}.
   * <ul>
   *   <li>Then return {@link SystemPropertyFieldType#BOOLEAN_TYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyImpl#getPropertyType()}
   */
  @Test
  public void testGetPropertyType_thenReturnBoolean_type() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setFriendlyGroup("Friendly Group");
    systemPropertyImpl.setFriendlyName("Friendly Name");
    systemPropertyImpl.setFriendlyTab("Friendly Tab");
    systemPropertyImpl.setId(1L);
    systemPropertyImpl.setName("Name");
    systemPropertyImpl.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl.setValue("42");
    systemPropertyImpl.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);

    // Act
    SystemPropertyFieldType actualPropertyType = systemPropertyImpl.getPropertyType();

    // Assert
    assertSame(actualPropertyType.BOOLEAN_TYPE, actualPropertyType);
  }

  /**
   * Test {@link SystemPropertyImpl#setPropertyType(SystemPropertyFieldType)}.
   * <ul>
   *   <li>Then {@link SystemPropertyImpl} (default constructor)
   * {@link SystemPropertyImpl#propertyType} is {@code BOOLEAN_TYPE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyImpl#setPropertyType(SystemPropertyFieldType)}
   */
  @Test
  public void testSetPropertyType_thenSystemPropertyImplPropertyTypeIsBooleanType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    SystemPropertyFieldType propertyType = SystemPropertyFieldType.BOOLEAN_TYPE;

    // Act
    systemPropertyImpl.setPropertyType(propertyType);

    // Assert
    assertEquals("BOOLEAN_TYPE", systemPropertyImpl.propertyType);
    SystemPropertyFieldType expectedPropertyType = propertyType.BOOLEAN_TYPE;
    assertSame(expectedPropertyType, systemPropertyImpl.getPropertyType());
  }

  /**
   * Test {@link SystemPropertyImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link SystemPropertyImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenSystemPropertyImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SystemPropertyImpl()).getMainEntityName());
  }

  /**
   * Test {@link SystemPropertyImpl#getMainEntityName()}.
   * <ul>
   *   <li>Then calls {@link SystemPropertyFieldType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyFieldType propertyType = mock(SystemPropertyFieldType.class);
    when(propertyType.getType()).thenReturn("Type");

    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setPropertyType(propertyType);

    // Act
    String actualMainEntityName = systemPropertyImpl.getMainEntityName();

    // Assert
    verify(propertyType).getType();
    assertNull(actualMainEntityName);
  }

  /**
   * Test
   * {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(BLCFieldUtils.NULL_FIELD, true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SystemProperty> actualCreateOrRetrieveCopyInstanceResult = systemPropertyImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new NullSystemProperty());
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    systemPropertyImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test
   * {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@link SystemPropertyFieldType}
   * {@link SystemPropertyFieldType#getType()} return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_givenSystemPropertyFieldTypeGetTypeReturnFoo()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyFieldType propertyType = mock(SystemPropertyFieldType.class);
    when(propertyType.getType()).thenReturn("foo");

    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setPropertyType(propertyType);

    SystemPropertyImpl systemPropertyImpl2 = new SystemPropertyImpl();
    systemPropertyImpl2.setFriendlyGroup("Friendly Group");
    systemPropertyImpl2.setFriendlyName("Friendly Name");
    systemPropertyImpl2.setFriendlyTab("Friendly Tab");
    systemPropertyImpl2.setId(1L);
    systemPropertyImpl2.setName("Name");
    systemPropertyImpl2.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl2.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);
    systemPropertyImpl2.setValue("42");
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(systemPropertyImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    systemPropertyImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(propertyType).getType();
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test
   * {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@link SystemPropertyFieldType}
   * {@link SystemPropertyFieldType#getType()} return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_givenSystemPropertyFieldTypeGetTypeReturnType()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyFieldType propertyType = mock(SystemPropertyFieldType.class);
    when(propertyType.getType()).thenReturn("Type");

    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setPropertyType(propertyType);

    SystemPropertyImpl systemPropertyImpl2 = new SystemPropertyImpl();
    systemPropertyImpl2.setFriendlyGroup("Friendly Group");
    systemPropertyImpl2.setFriendlyName("Friendly Name");
    systemPropertyImpl2.setFriendlyTab("Friendly Tab");
    systemPropertyImpl2.setId(1L);
    systemPropertyImpl2.setName("Name");
    systemPropertyImpl2.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl2.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);
    systemPropertyImpl2.setValue("42");
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(systemPropertyImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    systemPropertyImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(propertyType).getType();
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test
   * {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link SystemPropertyImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnSystemPropertyImpl() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<SystemProperty> actualCreateOrRetrieveCopyInstanceResult = systemPropertyImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.common.config.domain.SystemPropertyImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    SystemProperty clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof SystemPropertyImpl);
    SystemPropertyFieldType propertyType = clone.getPropertyType();
    assertEquals("STRING", propertyType.getType());
    assertEquals("STRING", ((SystemPropertyImpl) clone).propertyType);
    assertEquals("String value", propertyType.getFriendlyType());
    assertNull(clone.getId());
    assertNull(clone.getFriendlyGroup());
    assertNull(clone.getFriendlyName());
    assertNull(clone.getFriendlyTab());
    assertNull(clone.getName());
    assertNull(clone.getValue());
    assertNull(((SystemPropertyImpl) clone).getMainEntityName());
    assertFalse(clone.getOverrideGeneratedPropertyName());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
  }

  /**
   * Test {@link SystemPropertyImpl#equals(Object)}, and
   * {@link SystemPropertyImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SystemPropertyImpl#equals(Object)}
   *   <li>{@link SystemPropertyImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setFriendlyGroup("Friendly Group");
    systemPropertyImpl.setFriendlyName("Friendly Name");
    systemPropertyImpl.setFriendlyTab("Friendly Tab");
    systemPropertyImpl.setId(1L);
    systemPropertyImpl.setName("Name");
    systemPropertyImpl.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);
    systemPropertyImpl.setValue("42");

    SystemPropertyImpl systemPropertyImpl2 = new SystemPropertyImpl();
    systemPropertyImpl2.setFriendlyGroup("Friendly Group");
    systemPropertyImpl2.setFriendlyName("Friendly Name");
    systemPropertyImpl2.setFriendlyTab("Friendly Tab");
    systemPropertyImpl2.setId(1L);
    systemPropertyImpl2.setName("Name");
    systemPropertyImpl2.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl2.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);
    systemPropertyImpl2.setValue("42");

    // Act and Assert
    assertEquals(systemPropertyImpl, systemPropertyImpl2);
    int expectedHashCodeResult = systemPropertyImpl.hashCode();
    assertEquals(expectedHashCodeResult, systemPropertyImpl2.hashCode());
  }

  /**
   * Test {@link SystemPropertyImpl#equals(Object)}, and
   * {@link SystemPropertyImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SystemPropertyImpl#equals(Object)}
   *   <li>{@link SystemPropertyImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setFriendlyGroup("Friendly Group");
    systemPropertyImpl.setFriendlyName("Friendly Name");
    systemPropertyImpl.setFriendlyTab("Friendly Tab");
    systemPropertyImpl.setId(1L);
    systemPropertyImpl.setName("Name");
    systemPropertyImpl.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);
    systemPropertyImpl.setValue("42");

    // Act and Assert
    assertEquals(systemPropertyImpl, systemPropertyImpl);
    int expectedHashCodeResult = systemPropertyImpl.hashCode();
    assertEquals(expectedHashCodeResult, systemPropertyImpl.hashCode());
  }

  /**
   * Test {@link SystemPropertyImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setFriendlyGroup(null);
    systemPropertyImpl.setFriendlyName("Friendly Name");
    systemPropertyImpl.setFriendlyTab("Friendly Tab");
    systemPropertyImpl.setId(1L);
    systemPropertyImpl.setName("Name");
    systemPropertyImpl.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);
    systemPropertyImpl.setValue("42");

    SystemPropertyImpl systemPropertyImpl2 = new SystemPropertyImpl();
    systemPropertyImpl2.setFriendlyGroup("Friendly Group");
    systemPropertyImpl2.setFriendlyName("Friendly Name");
    systemPropertyImpl2.setFriendlyTab("Friendly Tab");
    systemPropertyImpl2.setId(1L);
    systemPropertyImpl2.setName("Name");
    systemPropertyImpl2.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl2.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);
    systemPropertyImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(systemPropertyImpl, systemPropertyImpl2);
  }

  /**
   * Test {@link SystemPropertyImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SystemPropertyFieldType propertyType = mock(SystemPropertyFieldType.class);
    when(propertyType.getType()).thenReturn("Type");

    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setFriendlyGroup("Friendly Group");
    systemPropertyImpl.setFriendlyName("Friendly Name");
    systemPropertyImpl.setFriendlyTab("Friendly Tab");
    systemPropertyImpl.setId(1L);
    systemPropertyImpl.setName("Name");
    systemPropertyImpl.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl.setPropertyType(propertyType);
    systemPropertyImpl.setValue("42");

    SystemPropertyImpl systemPropertyImpl2 = new SystemPropertyImpl();
    systemPropertyImpl2.setFriendlyGroup("Friendly Group");
    systemPropertyImpl2.setFriendlyName("Friendly Name");
    systemPropertyImpl2.setFriendlyTab("Friendly Tab");
    systemPropertyImpl2.setId(1L);
    systemPropertyImpl2.setName("Name");
    systemPropertyImpl2.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl2.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);
    systemPropertyImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(systemPropertyImpl, systemPropertyImpl2);
  }

  /**
   * Test {@link SystemPropertyImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setFriendlyGroup("Friendly Group");
    systemPropertyImpl.setFriendlyName("Friendly Name");
    systemPropertyImpl.setFriendlyTab("Friendly Tab");
    systemPropertyImpl.setId(1L);
    systemPropertyImpl.setName("Name");
    systemPropertyImpl.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);
    systemPropertyImpl.setValue("42");

    // Act and Assert
    assertNotEquals(systemPropertyImpl, null);
  }

  /**
   * Test {@link SystemPropertyImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setFriendlyGroup("Friendly Group");
    systemPropertyImpl.setFriendlyName("Friendly Name");
    systemPropertyImpl.setFriendlyTab("Friendly Tab");
    systemPropertyImpl.setId(1L);
    systemPropertyImpl.setName("Name");
    systemPropertyImpl.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);
    systemPropertyImpl.setValue("42");

    // Act and Assert
    assertNotEquals(systemPropertyImpl, "Different type to SystemPropertyImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SystemPropertyImpl}
   *   <li>{@link SystemPropertyImpl#setFriendlyGroup(String)}
   *   <li>{@link SystemPropertyImpl#setFriendlyName(String)}
   *   <li>{@link SystemPropertyImpl#setFriendlyTab(String)}
   *   <li>{@link SystemPropertyImpl#setId(Long)}
   *   <li>{@link SystemPropertyImpl#setName(String)}
   *   <li>{@link SystemPropertyImpl#setOverrideGeneratedPropertyName(Boolean)}
   *   <li>{@link SystemPropertyImpl#setValue(String)}
   *   <li>{@link SystemPropertyImpl#getFriendlyGroup()}
   *   <li>{@link SystemPropertyImpl#getFriendlyName()}
   *   <li>{@link SystemPropertyImpl#getFriendlyTab()}
   *   <li>{@link SystemPropertyImpl#getId()}
   *   <li>{@link SystemPropertyImpl#getName()}
   *   <li>{@link SystemPropertyImpl#getOverrideGeneratedPropertyName()}
   *   <li>{@link SystemPropertyImpl#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SystemPropertyImpl actualSystemPropertyImpl = new SystemPropertyImpl();
    actualSystemPropertyImpl.setFriendlyGroup("Friendly Group");
    actualSystemPropertyImpl.setFriendlyName("Friendly Name");
    actualSystemPropertyImpl.setFriendlyTab("Friendly Tab");
    actualSystemPropertyImpl.setId(1L);
    actualSystemPropertyImpl.setName("Name");
    actualSystemPropertyImpl.setOverrideGeneratedPropertyName(true);
    actualSystemPropertyImpl.setValue("42");
    String actualFriendlyGroup = actualSystemPropertyImpl.getFriendlyGroup();
    String actualFriendlyName = actualSystemPropertyImpl.getFriendlyName();
    String actualFriendlyTab = actualSystemPropertyImpl.getFriendlyTab();
    Long actualId = actualSystemPropertyImpl.getId();
    String actualName = actualSystemPropertyImpl.getName();
    Boolean actualOverrideGeneratedPropertyName = actualSystemPropertyImpl.getOverrideGeneratedPropertyName();

    // Assert that nothing has changed
    assertEquals("42", actualSystemPropertyImpl.getValue());
    assertEquals("Friendly Group", actualFriendlyGroup);
    assertEquals("Friendly Name", actualFriendlyName);
    assertEquals("Friendly Tab", actualFriendlyTab);
    assertEquals("Name", actualName);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualOverrideGeneratedPropertyName);
  }
}
