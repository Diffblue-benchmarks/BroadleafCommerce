package org.broadleafcommerce.common.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.module.BroadleafModuleRegistration.BroadleafModuleEnum;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafModuleRegistrationDiffblueTest {
  /**
   * Test BroadleafModuleEnum {@link BroadleafModuleEnum#equalsModuleName(String)}.
   *
   * <ul>
   *   <li>When {@code ACCOUNT}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafModuleEnum#equalsModuleName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafModuleEnum.equalsModuleName(String)"})
  public void testBroadleafModuleEnumEqualsModuleName_whenAccount_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BroadleafModuleEnum.ACCOUNT.equalsModuleName("ACCOUNT"));
  }

  /**
   * Test BroadleafModuleEnum {@link BroadleafModuleEnum#equalsModuleName(String)}.
   *
   * <ul>
   *   <li>When {@code Account}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafModuleEnum#equalsModuleName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafModuleEnum.equalsModuleName(String)"})
  public void testBroadleafModuleEnumEqualsModuleName_whenAccount_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BroadleafModuleEnum.ACCOUNT.equalsModuleName("Account"));
  }

  /**
   * Test BroadleafModuleEnum {@link BroadleafModuleEnum#equalsModuleName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafModuleEnum#equalsModuleName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafModuleEnum.equalsModuleName(String)"})
  public void testBroadleafModuleEnumEqualsModuleName_whenName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BroadleafModuleEnum.ACCOUNT.equalsModuleName("Name"));
  }

  /**
   * Test BroadleafModuleEnum {@link BroadleafModuleEnum#equalsModuleName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafModuleEnum#equalsModuleName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafModuleEnum.equalsModuleName(String)"})
  public void testBroadleafModuleEnumEqualsModuleName_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BroadleafModuleEnum.ACCOUNT.equalsModuleName(null));
  }

  /**
   * Test BroadleafModuleEnum getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafModuleEnum#getName()}
   *   <li>{@link BroadleafModuleEnum#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafModuleEnum.getName()",
    "String BroadleafModuleEnum.toString()"
  })
  public void testBroadleafModuleEnumGettersAndSetters() {
    // Arrange
    BroadleafModuleEnum valueOfResult = BroadleafModuleEnum.valueOf("ACCOUNT");

    // Act
    String actualName = valueOfResult.getName();

    // Assert
    assertEquals("Account", actualName);
    assertEquals("Account", valueOfResult.toString());
  }
}
