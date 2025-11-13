package org.broadleafcommerce.common.copy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.regex.Pattern;
import org.broadleafcommerce.common.persistence.EntityDuplicatorImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MultiTenantCopierDiffblueTest {
  /**
   * Test {@link MultiTenantCopier#getOrder()}.
   *
   * <p>Method under test: {@link MultiTenantCopier#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int MultiTenantCopier.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(0, new EntityDuplicatorImpl().getOrder());
  }

  /**
   * Test {@link MultiTenantCopier#excludeFromCopyRegexPattern(Object)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor) addPattern compile {@code
   *       .*\.txt}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#excludeFromCopyRegexPattern(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean MultiTenantCopier.excludeFromCopyRegexPattern(Object)"})
  public void testExcludeFromCopyRegexPattern_givenEntityDuplicatorImplAddPatternCompileTxt() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    entityDuplicatorImpl.addPattern(Pattern.compile(".*\\.txt"));

    // Act and Assert
    assertFalse(entityDuplicatorImpl.excludeFromCopyRegexPattern(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link MultiTenantCopier#excludeFromCopyRegexPattern(Object)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#excludeFromCopyRegexPattern(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean MultiTenantCopier.excludeFromCopyRegexPattern(Object)"})
  public void testExcludeFromCopyRegexPattern_givenEntityDuplicatorImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EntityDuplicatorImpl().excludeFromCopyRegexPattern(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link MultiTenantCopier#addPattern(Pattern)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#addPattern(Pattern)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiTenantCopier.addPattern(Pattern)"})
  public void testAddPattern_givenEntityDuplicatorImpl() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    Pattern pattern = Pattern.compile(".*\\.txt");

    // Act
    entityDuplicatorImpl.addPattern(pattern);

    // Assert
    List<Pattern> patternList = entityDuplicatorImpl.classExcludeRegexPatternList;
    assertEquals(1, patternList.size());
    assertSame(pattern, patternList.get(0));
  }

  /**
   * Test {@link MultiTenantCopier#addPattern(Pattern)}.
   *
   * <ul>
   *   <li>Then {@link EntityDuplicatorImpl} (default constructor) {@link
   *       MultiTenantCopier#classExcludeRegexPatternList} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#addPattern(Pattern)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiTenantCopier.addPattern(Pattern)"})
  public void testAddPattern_thenEntityDuplicatorImplClassExcludeRegexPatternListSizeIsOne() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    Pattern pattern = Pattern.compile(".*\\.txt");
    entityDuplicatorImpl.addPattern(pattern);

    // Act
    entityDuplicatorImpl.addPattern(Pattern.compile(".*\\.txt"));

    // Assert that nothing has changed
    List<Pattern> patternList = entityDuplicatorImpl.classExcludeRegexPatternList;
    assertEquals(1, patternList.size());
    assertSame(pattern, patternList.get(0));
  }

  /**
   * Test {@link MultiTenantCopier#addPattern(Pattern)}.
   *
   * <ul>
   *   <li>Then {@link EntityDuplicatorImpl} (default constructor) {@link
   *       MultiTenantCopier#classExcludeRegexPatternList} size is two.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#addPattern(Pattern)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiTenantCopier.addPattern(Pattern)"})
  public void testAddPattern_thenEntityDuplicatorImplClassExcludeRegexPatternListSizeIsTwo() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    Pattern pattern = Pattern.compile("foo");
    entityDuplicatorImpl.addPattern(pattern);
    entityDuplicatorImpl.addPattern(Pattern.compile(".*\\.txt"));

    // Act
    entityDuplicatorImpl.addPattern(Pattern.compile(".*\\.txt"));

    // Assert that nothing has changed
    List<Pattern> patternList = entityDuplicatorImpl.classExcludeRegexPatternList;
    assertEquals(2, patternList.size());
    assertSame(pattern, patternList.get(0));
  }

  /**
   * Test {@link MultiTenantCopier#needToAdd(Pattern)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor) addPattern compile {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#needToAdd(Pattern)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultiTenantCopier.needToAdd(Pattern)"})
  public void testNeedToAdd_givenEntityDuplicatorImplAddPatternCompileFoo_thenReturnFalse() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    entityDuplicatorImpl.addPattern(Pattern.compile("foo"));
    entityDuplicatorImpl.addPattern(Pattern.compile(".*\\.txt"));

    // Act and Assert
    assertFalse(entityDuplicatorImpl.needToAdd(Pattern.compile(".*\\.txt")));
  }

  /**
   * Test {@link MultiTenantCopier#needToAdd(Pattern)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor) addPattern compile {@code
   *       .*\.txt}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#needToAdd(Pattern)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultiTenantCopier.needToAdd(Pattern)"})
  public void testNeedToAdd_givenEntityDuplicatorImplAddPatternCompileTxt_thenReturnFalse() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    entityDuplicatorImpl.addPattern(Pattern.compile(".*\\.txt"));

    // Act and Assert
    assertFalse(entityDuplicatorImpl.needToAdd(Pattern.compile(".*\\.txt")));
  }

  /**
   * Test {@link MultiTenantCopier#needToAdd(Pattern)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor).
   *   <li>When compile {@code .*\.txt}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#needToAdd(Pattern)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultiTenantCopier.needToAdd(Pattern)"})
  public void testNeedToAdd_givenEntityDuplicatorImpl_whenCompileTxt_thenReturnTrue() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();

    // Act and Assert
    assertTrue(entityDuplicatorImpl.needToAdd(Pattern.compile(".*\\.txt")));
  }
}
