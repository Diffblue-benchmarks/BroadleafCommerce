package org.broadleafcommerce.common.config.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ModuleConfigurationTypeDiffblueTest {
  /**
   * Test {@link ModuleConfigurationType#getInstance(String)}.
   *
   * <p>Method under test: {@link ModuleConfigurationType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ModuleConfigurationType ModuleConfigurationType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    ModuleConfigurationType actualInstance = ModuleConfigurationType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return FriendlyType is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModuleConfigurationType#ModuleConfigurationType()}
   *   <li>{@link ModuleConfigurationType#getFriendlyType()}
   *   <li>{@link ModuleConfigurationType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ModuleConfigurationType.<init>()",
    "void ModuleConfigurationType.<init>(String, String)",
    "String ModuleConfigurationType.getFriendlyType()",
    "String ModuleConfigurationType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    ModuleConfigurationType actualModuleConfigurationType = new ModuleConfigurationType();
    String actualFriendlyType = actualModuleConfigurationType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualModuleConfigurationType.getType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return {@code Friendly Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModuleConfigurationType#ModuleConfigurationType(String, String)}
   *   <li>{@link ModuleConfigurationType#getFriendlyType()}
   *   <li>{@link ModuleConfigurationType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ModuleConfigurationType.<init>()",
    "void ModuleConfigurationType.<init>(String, String)",
    "String ModuleConfigurationType.getFriendlyType()",
    "String ModuleConfigurationType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    ModuleConfigurationType actualModuleConfigurationType =
        new ModuleConfigurationType("Type", "Friendly Type");
    String actualFriendlyType = actualModuleConfigurationType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualModuleConfigurationType.getType());
  }

  /**
   * Test {@link ModuleConfigurationType#equals(Object)}, and {@link
   * ModuleConfigurationType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModuleConfigurationType#equals(Object)}
   *   <li>{@link ModuleConfigurationType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ModuleConfigurationType.equals(Object)",
    "int ModuleConfigurationType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ModuleConfigurationType moduleConfigurationType = ModuleConfigurationType.ADDRESS_VERIFICATION;
    ModuleConfigurationType moduleConfigurationType2 = ModuleConfigurationType.ADDRESS_VERIFICATION;

    // Act and Assert
    assertEquals(moduleConfigurationType, moduleConfigurationType2);
    assertEquals(moduleConfigurationType.hashCode(), moduleConfigurationType2.hashCode());
  }

  /**
   * Test {@link ModuleConfigurationType#equals(Object)}, and {@link
   * ModuleConfigurationType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModuleConfigurationType#equals(Object)}
   *   <li>{@link ModuleConfigurationType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ModuleConfigurationType.equals(Object)",
    "int ModuleConfigurationType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ModuleConfigurationType moduleConfigurationType = ModuleConfigurationType.CDN_PROVIDER;
    ModuleConfigurationType moduleConfigurationType2 =
        new ModuleConfigurationType("CDN_PROVIDER", "CDN_PROVIDER");

    // Act and Assert
    assertEquals(moduleConfigurationType, moduleConfigurationType2);
    assertEquals(moduleConfigurationType.hashCode(), moduleConfigurationType2.hashCode());
  }

  /**
   * Test {@link ModuleConfigurationType#equals(Object)}, and {@link
   * ModuleConfigurationType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModuleConfigurationType#equals(Object)}
   *   <li>{@link ModuleConfigurationType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ModuleConfigurationType.equals(Object)",
    "int ModuleConfigurationType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ModuleConfigurationType moduleConfigurationType = new ModuleConfigurationType();
    ModuleConfigurationType moduleConfigurationType2 = new ModuleConfigurationType();

    // Act and Assert
    assertEquals(moduleConfigurationType, moduleConfigurationType2);
    assertEquals(moduleConfigurationType.hashCode(), moduleConfigurationType2.hashCode());
  }

  /**
   * Test {@link ModuleConfigurationType#equals(Object)}, and {@link
   * ModuleConfigurationType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ModuleConfigurationType#equals(Object)}
   *   <li>{@link ModuleConfigurationType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ModuleConfigurationType.equals(Object)",
    "int ModuleConfigurationType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ModuleConfigurationType moduleConfigurationType = ModuleConfigurationType.ADDRESS_VERIFICATION;

    // Act and Assert
    assertEquals(moduleConfigurationType, moduleConfigurationType);
    int expectedHashCodeResult = moduleConfigurationType.hashCode();
    assertEquals(expectedHashCodeResult, moduleConfigurationType.hashCode());
  }

  /**
   * Test {@link ModuleConfigurationType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ModuleConfigurationType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ModuleConfigurationType.equals(Object)",
    "int ModuleConfigurationType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ModuleConfigurationType.CDN_PROVIDER, ModuleConfigurationType.ADDRESS_VERIFICATION);
  }

  /**
   * Test {@link ModuleConfigurationType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ModuleConfigurationType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ModuleConfigurationType.equals(Object)",
    "int ModuleConfigurationType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ModuleConfigurationType(), ModuleConfigurationType.ADDRESS_VERIFICATION);
  }

  /**
   * Test {@link ModuleConfigurationType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ModuleConfigurationType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ModuleConfigurationType.equals(Object)",
    "int ModuleConfigurationType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModuleConfigurationType.ADDRESS_VERIFICATION, null);
  }

  /**
   * Test {@link ModuleConfigurationType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ModuleConfigurationType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ModuleConfigurationType.equals(Object)",
    "int ModuleConfigurationType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ModuleConfigurationType.ADDRESS_VERIFICATION, "Different type to ModuleConfigurationType");
  }
}
