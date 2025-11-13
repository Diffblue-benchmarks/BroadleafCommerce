package org.broadleafcommerce.cms.page.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PageItemCriteriaImplDiffblueTest {
  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}, and {@link PageItemCriteriaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageItemCriteriaImpl#equals(Object)}
   *   <li>{@link PageItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageItemCriteriaImpl.equals(Object)",
    "int PageItemCriteriaImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(1);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl2.setMatchRule("Match Rule");
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
    assertEquals(pageItemCriteriaImpl.hashCode(), pageItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}, and {@link PageItemCriteriaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageItemCriteriaImpl#equals(Object)}
   *   <li>{@link PageItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageItemCriteriaImpl.equals(Object)",
    "int PageItemCriteriaImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(null);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(1);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl2.setMatchRule("Match Rule");
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
    assertNotEquals(pageItemCriteriaImpl.hashCode(), pageItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}, and {@link PageItemCriteriaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageItemCriteriaImpl#equals(Object)}
   *   <li>{@link PageItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageItemCriteriaImpl.equals(Object)",
    "int PageItemCriteriaImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(1);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(null);
    pageItemCriteriaImpl2.setMatchRule("Match Rule");
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
    assertNotEquals(pageItemCriteriaImpl.hashCode(), pageItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}, and {@link PageItemCriteriaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageItemCriteriaImpl#equals(Object)}
   *   <li>{@link PageItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageItemCriteriaImpl.equals(Object)",
    "int PageItemCriteriaImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(null);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(null);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl2.setMatchRule("Match Rule");
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(null);

    // Act and Assert
    assertEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
    assertNotEquals(pageItemCriteriaImpl.hashCode(), pageItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}, and {@link PageItemCriteriaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageItemCriteriaImpl#equals(Object)}
   *   <li>{@link PageItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageItemCriteriaImpl.equals(Object)",
    "int PageItemCriteriaImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(1);

    // Act and Assert
    assertEquals(pageItemCriteriaImpl, pageItemCriteriaImpl);
    int expectedHashCodeResult = pageItemCriteriaImpl.hashCode();
    assertEquals(expectedHashCodeResult, pageItemCriteriaImpl.hashCode());
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageItemCriteriaImpl.equals(Object)",
    "int PageItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(2L);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(1);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl2.setMatchRule("Match Rule");
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageItemCriteriaImpl.equals(Object)",
    "int PageItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(null);
    pageItemCriteriaImpl.setMatchRule("42");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(1);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl2.setMatchRule("Match Rule");
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageItemCriteriaImpl.equals(Object)",
    "int PageItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(null);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(0);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl2.setMatchRule("Match Rule");
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageItemCriteriaImpl.equals(Object)",
    "int PageItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(null);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(null);

    PageItemCriteriaImpl pageItemCriteriaImpl2 = new PageItemCriteriaImpl();
    pageItemCriteriaImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl2.setMatchRule("Match Rule");
    pageItemCriteriaImpl2.setPage(new PageImpl());
    pageItemCriteriaImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(pageItemCriteriaImpl, pageItemCriteriaImpl2);
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageItemCriteriaImpl.equals(Object)",
    "int PageItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(1);

    // Act and Assert
    assertNotEquals(pageItemCriteriaImpl, null);
  }

  /**
   * Test {@link PageItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageItemCriteriaImpl.equals(Object)",
    "int PageItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();
    pageItemCriteriaImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageItemCriteriaImpl.setMatchRule("Match Rule");
    pageItemCriteriaImpl.setPage(new PageImpl());
    pageItemCriteriaImpl.setQuantity(1);

    // Act and Assert
    assertNotEquals(pageItemCriteriaImpl, "Different type to PageItemCriteriaImpl");
  }

  /**
   * Test {@link PageItemCriteriaImpl#cloneEntity()}.
   *
   * <p>Method under test: {@link PageItemCriteriaImpl#cloneEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageItemCriteria PageItemCriteriaImpl.cloneEntity()"})
  public void testCloneEntity() {
    // Arrange
    PageItemCriteriaImpl pageItemCriteriaImpl = new PageItemCriteriaImpl();

    // Act
    PageItemCriteria actualCloneEntityResult = pageItemCriteriaImpl.cloneEntity();

    // Assert
    assertTrue(actualCloneEntityResult instanceof PageItemCriteriaImpl);
    assertEquals(pageItemCriteriaImpl, actualCloneEntityResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PageItemCriteriaImpl}
   *   <li>{@link PageItemCriteriaImpl#setId(Long)}
   *   <li>{@link PageItemCriteriaImpl#setMatchRule(String)}
   *   <li>{@link PageItemCriteriaImpl#setPage(Page)}
   *   <li>{@link PageItemCriteriaImpl#setQuantity(Integer)}
   *   <li>{@link PageItemCriteriaImpl#getId()}
   *   <li>{@link PageItemCriteriaImpl#getMatchRule()}
   *   <li>{@link PageItemCriteriaImpl#getPage()}
   *   <li>{@link PageItemCriteriaImpl#getQuantity()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageItemCriteriaImpl.<init>()",
    "Long PageItemCriteriaImpl.getId()",
    "String PageItemCriteriaImpl.getMatchRule()",
    "Page PageItemCriteriaImpl.getPage()",
    "Integer PageItemCriteriaImpl.getQuantity()",
    "void PageItemCriteriaImpl.setId(Long)",
    "void PageItemCriteriaImpl.setMatchRule(String)",
    "void PageItemCriteriaImpl.setPage(Page)",
    "void PageItemCriteriaImpl.setQuantity(Integer)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PageItemCriteriaImpl actualPageItemCriteriaImpl = new PageItemCriteriaImpl();
    actualPageItemCriteriaImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    actualPageItemCriteriaImpl.setMatchRule("Match Rule");
    PageImpl page = new PageImpl();
    actualPageItemCriteriaImpl.setPage(page);
    actualPageItemCriteriaImpl.setQuantity(1);
    Long actualId = actualPageItemCriteriaImpl.getId();
    String actualMatchRule = actualPageItemCriteriaImpl.getMatchRule();
    Page actualPage = actualPageItemCriteriaImpl.getPage();

    // Assert
    assertEquals("Match Rule", actualMatchRule);
    assertEquals(1, actualPageItemCriteriaImpl.getQuantity().intValue());
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(page, actualPage);
  }
}
