package org.broadleafcommerce.common.module;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.module.BroadleafModuleRegistration.BroadleafModuleEnum;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ModulePresentUtilDiffblueTest {
  /**
   * Test {@link ModulePresentUtil#isPresent(BroadleafModuleEnum)} with {@code BroadleafModuleEnum}.
   *
   * <p>Method under test: {@link ModulePresentUtil#isPresent(BroadleafModuleEnum)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModulePresentUtil.isPresent(BroadleafModuleEnum)"})
  public void testIsPresentWithBroadleafModuleEnum() {
    // Arrange, Act and Assert
    assertFalse(ModulePresentUtil.isPresent(BroadleafModuleEnum.ACCOUNT));
  }

  /**
   * Test {@link ModulePresentUtil#isPresent(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code CommonTest}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ModulePresentUtil#isPresent(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModulePresentUtil.isPresent(String)"})
  public void testIsPresentWithString_whenCommonTest_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ModulePresentUtil.isPresent("CommonTest"));
  }

  /**
   * Test {@link ModulePresentUtil#isPresent(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Module In Question}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ModulePresentUtil#isPresent(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModulePresentUtil.isPresent(String)"})
  public void testIsPresentWithString_whenModuleInQuestion_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ModulePresentUtil.isPresent("Module In Question"));
  }

  /**
   * Test {@link ModulePresentUtil#allPresent(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ModulePresentUtil#allPresent(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModulePresentUtil.allPresent(List)"})
  public void testAllPresent_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    ArrayList<String> modulesInQuestion = new ArrayList<>();
    modulesInQuestion.add("42");
    modulesInQuestion.add("foo");

    // Act and Assert
    assertFalse(ModulePresentUtil.allPresent(modulesInQuestion));
  }

  /**
   * Test {@link ModulePresentUtil#allPresent(List)}.
   *
   * <ul>
   *   <li>Given {@code CommonTest}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code CommonTest}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ModulePresentUtil#allPresent(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModulePresentUtil.allPresent(List)"})
  public void testAllPresent_givenCommonTest_whenArrayListAddCommonTest_thenReturnTrue() {
    // Arrange
    ArrayList<String> modulesInQuestion = new ArrayList<>();
    modulesInQuestion.add("CommonTest");

    // Act and Assert
    assertTrue(ModulePresentUtil.allPresent(modulesInQuestion));
  }

  /**
   * Test {@link ModulePresentUtil#allPresent(List)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link ArrayList#ArrayList()} add empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ModulePresentUtil#allPresent(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModulePresentUtil.allPresent(List)"})
  public void testAllPresent_givenEmptyString_whenArrayListAddEmptyString_thenReturnFalse() {
    // Arrange
    ArrayList<String> modulesInQuestion = new ArrayList<>();
    modulesInQuestion.add("");

    // Act and Assert
    assertFalse(ModulePresentUtil.allPresent(modulesInQuestion));
  }

  /**
   * Test {@link ModulePresentUtil#allPresent(List)}.
   *
   * <ul>
   *   <li>Given {@code Modules In Question}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Modules In Question}.
   * </ul>
   *
   * <p>Method under test: {@link ModulePresentUtil#allPresent(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModulePresentUtil.allPresent(List)"})
  public void testAllPresent_givenModulesInQuestion_whenArrayListAddModulesInQuestion() {
    // Arrange
    ArrayList<String> modulesInQuestion = new ArrayList<>();
    modulesInQuestion.add("Modules In Question");

    // Act and Assert
    assertFalse(ModulePresentUtil.allPresent(modulesInQuestion));
  }

  /**
   * Test {@link ModulePresentUtil#allPresent(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ModulePresentUtil#allPresent(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModulePresentUtil.allPresent(List)"})
  public void testAllPresent_givenNull_whenArrayListAddNull_thenReturnFalse() {
    // Arrange
    ArrayList<String> modulesInQuestion = new ArrayList<>();
    modulesInQuestion.add(null);

    // Act and Assert
    assertFalse(ModulePresentUtil.allPresent(modulesInQuestion));
  }

  /**
   * Test {@link ModulePresentUtil#allPresent(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ModulePresentUtil#allPresent(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ModulePresentUtil.allPresent(List)"})
  public void testAllPresent_whenArrayList_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ModulePresentUtil.allPresent(new ArrayList<>()));
  }
}
