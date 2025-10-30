/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-common-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SystemPropertyImplDiffblueTest {
  @Autowired
  private SystemPropertyImpl systemPropertyImpl;

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SystemPropertyFieldType SystemPropertyImpl.getPropertyType()"})
  public void testGetPropertyType_givenSystemPropertyImpl_thenReturnString_type() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SystemPropertyFieldType SystemPropertyImpl.getPropertyType()"})
  public void testGetPropertyType_thenReturnBoolean_type() {
    // Arrange
    SystemPropertyImpl systemPropertyImpl2 = new SystemPropertyImpl();
    systemPropertyImpl2.setFriendlyGroup("Friendly Group");
    systemPropertyImpl2.setFriendlyName("Friendly Name");
    systemPropertyImpl2.setFriendlyTab("Friendly Tab");
    systemPropertyImpl2.setId(1L);
    systemPropertyImpl2.setName("Name");
    systemPropertyImpl2.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl2.setValue("42");
    systemPropertyImpl2.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);

    // Act
    SystemPropertyFieldType actualPropertyType = systemPropertyImpl2.getPropertyType();

    // Assert
    assertSame(actualPropertyType.BOOLEAN_TYPE, actualPropertyType);
  }

  /**
   * Test {@link SystemPropertyImpl#setPropertyType(SystemPropertyFieldType)}.
   * <ul>
   *   <li>Then {@link SystemPropertyImpl} (default constructor) {@link SystemPropertyImpl#propertyType} is {@code BOOLEAN_TYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyImpl#setPropertyType(SystemPropertyFieldType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SystemPropertyImpl.setPropertyType(SystemPropertyFieldType)"})
  public void testSetPropertyType_thenSystemPropertyImplPropertyTypeIsBooleanType() {
    // Arrange
    SystemPropertyImpl systemPropertyImpl2 = new SystemPropertyImpl();
    SystemPropertyFieldType propertyType = SystemPropertyFieldType.BOOLEAN_TYPE;

    // Act
    systemPropertyImpl2.setPropertyType(propertyType);

    // Assert
    assertEquals("BOOLEAN_TYPE", systemPropertyImpl2.propertyType);
    SystemPropertyFieldType expectedPropertyType = propertyType.BOOLEAN_TYPE;
    assertSame(expectedPropertyType, systemPropertyImpl2.getPropertyType());
  }

  /**
   * Test {@link SystemPropertyImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link SystemPropertyImpl#getMainEntityName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SystemPropertyImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull((new SystemPropertyImpl()).getMainEntityName());
  }

  /**
   * Test {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse SystemPropertyImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    SystemPropertyImpl systemPropertyImpl2 = new SystemPropertyImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(BLCFieldUtils.NULL_FIELD, true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SystemProperty> actualCreateOrRetrieveCopyInstanceResult = systemPropertyImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then calls {@link CreateResponse#getClone()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse SystemPropertyImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenCallsGetClone() throws CloneNotSupportedException {
    // Arrange
    SystemPropertyImpl systemPropertyImpl2 = new SystemPropertyImpl();
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new NullSystemProperty());
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    systemPropertyImpl2.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link SystemPropertyImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse SystemPropertyImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnSystemPropertyImpl() throws CloneNotSupportedException {
    // Arrange
    SystemPropertyImpl systemPropertyImpl2 = new SystemPropertyImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<SystemProperty> actualCreateOrRetrieveCopyInstanceResult = systemPropertyImpl2
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.common.config.domain.SystemPropertyImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    SystemProperty clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof SystemPropertyImpl);
    assertEquals("STRING", ((SystemPropertyImpl) clone).propertyType);
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
   * Test {@link SystemPropertyImpl#equals(Object)}, and {@link SystemPropertyImpl#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SystemPropertyImpl.equals(Object)", "int SystemPropertyImpl.hashCode()"})
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
   * Test {@link SystemPropertyImpl#equals(Object)}, and {@link SystemPropertyImpl#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SystemPropertyImpl.equals(Object)", "int SystemPropertyImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SystemPropertyImpl.equals(Object)", "int SystemPropertyImpl.hashCode()"})
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
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SystemPropertyImpl.equals(Object)", "int SystemPropertyImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SystemPropertyImpl.equals(Object)", "int SystemPropertyImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SystemPropertyImpl.<init>()", "String SystemPropertyImpl.getFriendlyGroup()",
      "String SystemPropertyImpl.getFriendlyName()", "String SystemPropertyImpl.getFriendlyTab()",
      "Long SystemPropertyImpl.getId()", "String SystemPropertyImpl.getName()",
      "Boolean SystemPropertyImpl.getOverrideGeneratedPropertyName()", "String SystemPropertyImpl.getValue()",
      "void SystemPropertyImpl.setFriendlyGroup(String)", "void SystemPropertyImpl.setFriendlyName(String)",
      "void SystemPropertyImpl.setFriendlyTab(String)", "void SystemPropertyImpl.setId(Long)",
      "void SystemPropertyImpl.setName(String)", "void SystemPropertyImpl.setOverrideGeneratedPropertyName(Boolean)",
      "void SystemPropertyImpl.setValue(String)"})
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

    // Assert
    assertEquals("42", actualSystemPropertyImpl.getValue());
    assertEquals("Friendly Group", actualFriendlyGroup);
    assertEquals("Friendly Name", actualFriendlyName);
    assertEquals("Friendly Tab", actualFriendlyTab);
    assertEquals("Name", actualName);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualOverrideGeneratedPropertyName);
  }
}
