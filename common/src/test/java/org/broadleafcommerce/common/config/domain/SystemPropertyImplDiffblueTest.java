package org.broadleafcommerce.common.config.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SystemPropertyImplDiffblueTest {
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
