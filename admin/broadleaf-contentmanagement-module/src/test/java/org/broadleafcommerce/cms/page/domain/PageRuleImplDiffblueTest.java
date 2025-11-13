package org.broadleafcommerce.cms.page.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PageRuleImplDiffblueTest {
  @Autowired private PageRuleImpl pageRuleImpl;

  /**
   * Test {@link PageRuleImpl#equals(Object)}, and {@link PageRuleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageRuleImpl#equals(Object)}
   *   <li>{@link PageRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageRuleImpl.equals(Object)", "int PageRuleImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    pageRuleImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl.setMatchRule("Match Rule");

    PageRuleImpl pageRuleImpl2 = new PageRuleImpl();
    pageRuleImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(pageRuleImpl, pageRuleImpl2);
    assertEquals(pageRuleImpl.hashCode(), pageRuleImpl2.hashCode());
  }

  /**
   * Test {@link PageRuleImpl#equals(Object)}, and {@link PageRuleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageRuleImpl#equals(Object)}
   *   <li>{@link PageRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageRuleImpl.equals(Object)", "int PageRuleImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    pageRuleImpl.setId(null);
    pageRuleImpl.setMatchRule("Match Rule");

    PageRuleImpl pageRuleImpl2 = new PageRuleImpl();
    pageRuleImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(pageRuleImpl, pageRuleImpl2);
    assertNotEquals(pageRuleImpl.hashCode(), pageRuleImpl2.hashCode());
  }

  /**
   * Test {@link PageRuleImpl#equals(Object)}, and {@link PageRuleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageRuleImpl#equals(Object)}
   *   <li>{@link PageRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageRuleImpl.equals(Object)", "int PageRuleImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    pageRuleImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl.setMatchRule("Match Rule");

    PageRuleImpl pageRuleImpl2 = new PageRuleImpl();
    pageRuleImpl2.setId(null);
    pageRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(pageRuleImpl, pageRuleImpl2);
    assertNotEquals(pageRuleImpl.hashCode(), pageRuleImpl2.hashCode());
  }

  /**
   * Test {@link PageRuleImpl#equals(Object)}, and {@link PageRuleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageRuleImpl#equals(Object)}
   *   <li>{@link PageRuleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageRuleImpl.equals(Object)", "int PageRuleImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    pageRuleImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertEquals(pageRuleImpl, pageRuleImpl);
    int expectedHashCodeResult = pageRuleImpl.hashCode();
    assertEquals(expectedHashCodeResult, pageRuleImpl.hashCode());
  }

  /**
   * Test {@link PageRuleImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageRuleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageRuleImpl.equals(Object)", "int PageRuleImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    pageRuleImpl.setId(2L);
    pageRuleImpl.setMatchRule("Match Rule");

    PageRuleImpl pageRuleImpl2 = new PageRuleImpl();
    pageRuleImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(pageRuleImpl, pageRuleImpl2);
  }

  /**
   * Test {@link PageRuleImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageRuleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageRuleImpl.equals(Object)", "int PageRuleImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    pageRuleImpl.setId(null);
    pageRuleImpl.setMatchRule("42");

    PageRuleImpl pageRuleImpl2 = new PageRuleImpl();
    pageRuleImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl2.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(pageRuleImpl, pageRuleImpl2);
  }

  /**
   * Test {@link PageRuleImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageRuleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageRuleImpl.equals(Object)", "int PageRuleImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    pageRuleImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(pageRuleImpl, null);
  }

  /**
   * Test {@link PageRuleImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageRuleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PageRuleImpl.equals(Object)", "int PageRuleImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PageRuleImpl pageRuleImpl = new PageRuleImpl();
    pageRuleImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageRuleImpl.setMatchRule("Match Rule");

    // Act and Assert
    assertNotEquals(pageRuleImpl, "Different type to PageRuleImpl");
  }

  /**
   * Test {@link PageRuleImpl#cloneEntity()}.
   *
   * <p>Method under test: {@link PageRuleImpl#cloneEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageRule PageRuleImpl.cloneEntity()"})
  public void testCloneEntity() {
    // Arrange and Act
    PageRule actualCloneEntityResult = pageRuleImpl.cloneEntity();

    // Assert
    assertTrue(actualCloneEntityResult instanceof PageRuleImpl);
    assertEquals(pageRuleImpl, actualCloneEntityResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PageRuleImpl}
   *   <li>{@link PageRuleImpl#setId(Long)}
   *   <li>{@link PageRuleImpl#setMatchRule(String)}
   *   <li>{@link PageRuleImpl#getId()}
   *   <li>{@link PageRuleImpl#getMatchRule()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageRuleImpl.<init>()",
    "Long PageRuleImpl.getId()",
    "String PageRuleImpl.getMatchRule()",
    "void PageRuleImpl.setId(Long)",
    "void PageRuleImpl.setMatchRule(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PageRuleImpl actualPageRuleImpl = new PageRuleImpl();
    actualPageRuleImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    actualPageRuleImpl.setMatchRule("Match Rule");
    Long actualId = actualPageRuleImpl.getId();

    // Assert
    assertEquals("Match Rule", actualPageRuleImpl.getMatchRule());
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
  }
}
