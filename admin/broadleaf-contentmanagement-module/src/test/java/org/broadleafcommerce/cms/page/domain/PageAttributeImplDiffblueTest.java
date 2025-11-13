package org.broadleafcommerce.cms.page.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PageAttributeImplDiffblueTest {
  /**
   * Test {@link PageAttributeImpl#equals(Object)}, and {@link PageAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageAttributeImpl#equals(Object)}
   *   <li>{@link PageAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageAttributeImpl.equals(Object)",
    "int PageAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(pageAttributeImpl, pageAttributeImpl2);
    assertNotEquals(pageAttributeImpl.hashCode(), pageAttributeImpl2.hashCode());
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}, and {@link PageAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageAttributeImpl#equals(Object)}
   *   <li>{@link PageAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageAttributeImpl.equals(Object)",
    "int PageAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(null);
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(null);
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(pageAttributeImpl, pageAttributeImpl2);
    assertEquals(pageAttributeImpl.hashCode(), pageAttributeImpl2.hashCode());
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}, and {@link PageAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageAttributeImpl#equals(Object)}
   *   <li>{@link PageAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageAttributeImpl.equals(Object)",
    "int PageAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(null);
    pageAttributeImpl.setValue(null);

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(null);
    pageAttributeImpl2.setValue(null);

    // Act and Assert
    assertEquals(pageAttributeImpl, pageAttributeImpl2);
    assertEquals(pageAttributeImpl.hashCode(), pageAttributeImpl2.hashCode());
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}, and {@link PageAttributeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageAttributeImpl#equals(Object)}
   *   <li>{@link PageAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageAttributeImpl.equals(Object)",
    "int PageAttributeImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(pageAttributeImpl, pageAttributeImpl);
    int expectedHashCodeResult = pageAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, pageAttributeImpl.hashCode());
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageAttributeImpl.equals(Object)",
    "int PageAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(2L);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageAttributeImpl.equals(Object)",
    "int PageAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageAttributeImpl.equals(Object)",
    "int PageAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(null);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageAttributeImpl.equals(Object)",
    "int PageAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName(null);
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageAttributeImpl.equals(Object)",
    "int PageAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("java.lang.String");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageAttributeImpl.equals(Object)",
    "int PageAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(null);
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageAttributeImpl.equals(Object)",
    "int PageAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName(null);
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName(null);
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageAttributeImpl.equals(Object)",
    "int PageAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(null);
    pageAttributeImpl.setValue("Name");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(null);
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageAttributeImpl.equals(Object)",
    "int PageAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(null);
    pageAttributeImpl.setValue(null);

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(null);
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageAttributeImpl.equals(Object)",
    "int PageAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, null);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PageAttributeImpl.equals(Object)",
    "int PageAttributeImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, "Different type to PageAttributeImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PageAttributeImpl}
   *   <li>{@link PageAttributeImpl#setId(Long)}
   *   <li>{@link PageAttributeImpl#setName(String)}
   *   <li>{@link PageAttributeImpl#setPage(Page)}
   *   <li>{@link PageAttributeImpl#setValue(String)}
   *   <li>{@link PageAttributeImpl#getId()}
   *   <li>{@link PageAttributeImpl#getName()}
   *   <li>{@link PageAttributeImpl#getPage()}
   *   <li>{@link PageAttributeImpl#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageAttributeImpl.<init>()",
    "Long PageAttributeImpl.getId()",
    "String PageAttributeImpl.getName()",
    "Page PageAttributeImpl.getPage()",
    "void PageAttributeImpl.setId(Long)",
    "void PageAttributeImpl.setName(String)",
    "void PageAttributeImpl.setPage(Page)",
    "void PageAttributeImpl.setValue(String)",
    "String PageAttributeImpl.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PageAttributeImpl actualPageAttributeImpl = new PageAttributeImpl();
    actualPageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    actualPageAttributeImpl.setName("Name");
    PageImpl page = new PageImpl();
    actualPageAttributeImpl.setPage(page);
    actualPageAttributeImpl.setValue("42");
    Long actualId = actualPageAttributeImpl.getId();
    String actualName = actualPageAttributeImpl.getName();
    Page actualPage = actualPageAttributeImpl.getPage();
    String actualToStringResult = actualPageAttributeImpl.toString();

    // Assert
    assertEquals("42", actualPageAttributeImpl.getValue());
    assertEquals("42", actualToStringResult);
    assertEquals("Name", actualName);
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(page, actualPage);
  }
}
