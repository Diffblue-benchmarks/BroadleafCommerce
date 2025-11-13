package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SiteReindexCommandDiffblueTest {
  /**
   * Test {@link SiteReindexCommand#SiteReindexCommand(Long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return SiteId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SiteReindexCommand#SiteReindexCommand(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SiteReindexCommand.<init>(Long)"})
  public void testNewSiteReindexCommand_whenOne_thenReturnSiteIdLongValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1L, new SiteReindexCommand(1L).getSiteId().longValue());
  }

  /**
   * Test {@link SiteReindexCommand#getSiteId()}.
   *
   * <p>Method under test: {@link SiteReindexCommand#getSiteId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long SiteReindexCommand.getSiteId()"})
  public void testGetSiteId() {
    // Arrange, Act and Assert
    assertEquals(1L, new SiteReindexCommand(1L).getSiteId().longValue());
  }

  /**
   * Test {@link SiteReindexCommand#equals(Object)}, and {@link SiteReindexCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteReindexCommand#equals(Object)}
   *   <li>{@link SiteReindexCommand#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteReindexCommand.equals(Object)",
    "int SiteReindexCommand.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SiteReindexCommand siteReindexCommand = new SiteReindexCommand(1L);
    SiteReindexCommand siteReindexCommand2 = new SiteReindexCommand(1L);

    // Act and Assert
    assertEquals(siteReindexCommand, siteReindexCommand2);
    assertEquals(siteReindexCommand.hashCode(), siteReindexCommand2.hashCode());
  }

  /**
   * Test {@link SiteReindexCommand#equals(Object)}, and {@link SiteReindexCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SiteReindexCommand#equals(Object)}
   *   <li>{@link SiteReindexCommand#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteReindexCommand.equals(Object)",
    "int SiteReindexCommand.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SiteReindexCommand siteReindexCommand = new SiteReindexCommand(1L);

    // Act and Assert
    assertEquals(siteReindexCommand, siteReindexCommand);
    int expectedHashCodeResult = siteReindexCommand.hashCode();
    assertEquals(expectedHashCodeResult, siteReindexCommand.hashCode());
  }

  /**
   * Test {@link SiteReindexCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteReindexCommand#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteReindexCommand.equals(Object)",
    "int SiteReindexCommand.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SiteReindexCommand siteReindexCommand = new SiteReindexCommand(2L);

    // Act and Assert
    assertNotEquals(siteReindexCommand, new SiteReindexCommand(1L));
  }

  /**
   * Test {@link SiteReindexCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteReindexCommand#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteReindexCommand.equals(Object)",
    "int SiteReindexCommand.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SiteReindexCommand(1L), null);
  }

  /**
   * Test {@link SiteReindexCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SiteReindexCommand#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SiteReindexCommand.equals(Object)",
    "int SiteReindexCommand.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SiteReindexCommand(1L), "Different type to SiteReindexCommand");
  }
}
