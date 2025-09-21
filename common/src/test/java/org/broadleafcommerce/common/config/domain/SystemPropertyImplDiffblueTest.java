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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType;
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

@ContextConfiguration(locations = {"/bl-common-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class SystemPropertyImplDiffblueTest {
  @Autowired private SystemPropertyImpl systemPropertyImpl;

  /**
   * Test {@link SystemPropertyImpl#getPropertyType()}.
   *
   * <ul>
   *   <li>Given {@link SystemPropertyImpl}.
   *   <li>Then return {@link SystemPropertyFieldType#STRING_TYPE}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyImpl#getPropertyType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemPropertyFieldType SystemPropertyImpl.getPropertyType()"})
  public void testGetPropertyType_givenSystemPropertyImpl_thenReturnString_type() {
    // Arrange, Act and Assert
    assertSame(SystemPropertyFieldType.STRING_TYPE, systemPropertyImpl.getPropertyType());
  }

  /**
   * Test {@link SystemPropertyImpl#getPropertyType()}.
   *
   * <ul>
   *   <li>Then return {@link SystemPropertyFieldType#BOOLEAN_TYPE}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyImpl#getPropertyType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemPropertyFieldType SystemPropertyImpl.getPropertyType()"})
  public void testGetPropertyType_thenReturnBoolean_type() {
    // Arrange
    systemPropertyImpl.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);

    // Act and Assert
    assertSame(SystemPropertyFieldType.BOOLEAN_TYPE, systemPropertyImpl.getPropertyType());
  }

  /**
   * Test {@link SystemPropertyImpl#setPropertyType(SystemPropertyFieldType)}.
   *
   * <ul>
   *   <li>Then {@link SystemPropertyImpl} {@link SystemPropertyImpl#propertyType} is {@code
   *       BOOLEAN_TYPE}.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyImpl#setPropertyType(SystemPropertyFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SystemPropertyImpl.setPropertyType(SystemPropertyFieldType)"})
  public void testSetPropertyType_thenSystemPropertyImplPropertyTypeIsBooleanType() {
    // Arrange and Act
    systemPropertyImpl.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);

    // Assert
    assertEquals("BOOLEAN_TYPE", systemPropertyImpl.propertyType);
    assertSame(SystemPropertyFieldType.BOOLEAN_TYPE, systemPropertyImpl.getPropertyType());
  }

  /**
   * Test {@link SystemPropertyImpl#getMainEntityName()}.
   *
   * <p>Method under test: {@link SystemPropertyImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SystemPropertyImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull(systemPropertyImpl.getMainEntityName());
  }

  /**
   * Test {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SystemPropertyImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new NullSystemProperty(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SystemProperty> actualCreateOrRetrieveCopyInstanceResult =
        systemPropertyImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SystemPropertyImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(systemPropertyImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SystemProperty> actualCreateOrRetrieveCopyInstanceResult =
        systemPropertyImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SystemPropertyImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new NullSystemProperty(), false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SystemProperty> actualCreateOrRetrieveCopyInstanceResult =
        systemPropertyImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * SystemPropertyImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse SystemPropertyImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance4() throws CloneNotSupportedException {
    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);

    SystemPropertyImpl systemPropertyImpl2 = new SystemPropertyImpl();
    systemPropertyImpl2.setFriendlyGroup("Friendly Group");
    systemPropertyImpl2.setFriendlyName("Friendly Name");
    systemPropertyImpl2.setFriendlyTab("Friendly Tab");
    systemPropertyImpl2.setId(1L);
    systemPropertyImpl2.setName("Name");
    systemPropertyImpl2.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl2.setPropertyType(SystemPropertyFieldType.BOOLEAN_TYPE);
    systemPropertyImpl2.setValue("42");
    CreateResponse<Object> createResponse = new CreateResponse<>(systemPropertyImpl2, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SystemProperty> actualCreateOrRetrieveCopyInstanceResult =
        systemPropertyImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link SystemPropertyImpl#equals(Object)}, and {@link SystemPropertyImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemPropertyImpl#equals(Object)}
   *   <li>{@link SystemPropertyImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertyImpl.equals(Object)",
    "int SystemPropertyImpl.hashCode()"
  })
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
    assertEquals(systemPropertyImpl.hashCode(), systemPropertyImpl2.hashCode());
  }

  /**
   * Test {@link SystemPropertyImpl#equals(Object)}, and {@link SystemPropertyImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemPropertyImpl#equals(Object)}
   *   <li>{@link SystemPropertyImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertyImpl.equals(Object)",
    "int SystemPropertyImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertyImpl.equals(Object)",
    "int SystemPropertyImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertyImpl.equals(Object)",
    "int SystemPropertyImpl.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemPropertyImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SystemPropertyImpl.equals(Object)",
    "int SystemPropertyImpl.hashCode()"
  })
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
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SystemPropertyImpl.<init>()",
    "String SystemPropertyImpl.getFriendlyGroup()",
    "String SystemPropertyImpl.getFriendlyName()",
    "String SystemPropertyImpl.getFriendlyTab()",
    "Long SystemPropertyImpl.getId()",
    "String SystemPropertyImpl.getName()",
    "Boolean SystemPropertyImpl.getOverrideGeneratedPropertyName()",
    "String SystemPropertyImpl.getValue()",
    "void SystemPropertyImpl.setFriendlyGroup(String)",
    "void SystemPropertyImpl.setFriendlyName(String)",
    "void SystemPropertyImpl.setFriendlyTab(String)",
    "void SystemPropertyImpl.setId(Long)",
    "void SystemPropertyImpl.setName(String)",
    "void SystemPropertyImpl.setOverrideGeneratedPropertyName(Boolean)",
    "void SystemPropertyImpl.setValue(String)"
  })
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
    Boolean actualOverrideGeneratedPropertyName =
        actualSystemPropertyImpl.getOverrideGeneratedPropertyName();

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
