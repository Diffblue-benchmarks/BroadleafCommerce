package org.broadleafcommerce.cms.structure.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StructuredContentItemCriteriaImplDiffblueTest {
  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}, and {@link
   * StructuredContentItemCriteriaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentItemCriteriaImpl#equals(Object)}
   *   <li>{@link StructuredContentItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
    assertEquals(
        structuredContentItemCriteriaImpl.hashCode(),
        structuredContentItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}, and {@link
   * StructuredContentItemCriteriaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentItemCriteriaImpl#equals(Object)}
   *   <li>{@link StructuredContentItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(null);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
    assertNotEquals(
        structuredContentItemCriteriaImpl.hashCode(),
        structuredContentItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}, and {@link
   * StructuredContentItemCriteriaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentItemCriteriaImpl#equals(Object)}
   *   <li>{@link StructuredContentItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(null);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
    assertNotEquals(
        structuredContentItemCriteriaImpl.hashCode(),
        structuredContentItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}, and {@link
   * StructuredContentItemCriteriaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentItemCriteriaImpl#equals(Object)}
   *   <li>{@link StructuredContentItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(null);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(null);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(null);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
    assertNotEquals(
        structuredContentItemCriteriaImpl.hashCode(),
        structuredContentItemCriteriaImpl2.hashCode());
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}, and {@link
   * StructuredContentItemCriteriaImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StructuredContentItemCriteriaImpl#equals(Object)}
   *   <li>{@link StructuredContentItemCriteriaImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl);
    int expectedHashCodeResult = structuredContentItemCriteriaImpl.hashCode();
    assertEquals(expectedHashCodeResult, structuredContentItemCriteriaImpl.hashCode());
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(2L);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(null);
    structuredContentItemCriteriaImpl.setMatchRule("42");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(null);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(0);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(null);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(null);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl2 =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl2.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl2.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl2.setQuantity(1);
    structuredContentItemCriteriaImpl2.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(structuredContentItemCriteriaImpl, structuredContentItemCriteriaImpl2);
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(structuredContentItemCriteriaImpl, null);
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StructuredContentItemCriteriaImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentItemCriteriaImpl.equals(Object)",
    "int StructuredContentItemCriteriaImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    structuredContentItemCriteriaImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    structuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    structuredContentItemCriteriaImpl.setQuantity(1);
    structuredContentItemCriteriaImpl.setStructuredContent(new StructuredContentImpl());

    // Act and Assert
    assertNotEquals(
        structuredContentItemCriteriaImpl, "Different type to StructuredContentItemCriteriaImpl");
  }

  /**
   * Test {@link StructuredContentItemCriteriaImpl#cloneEntity()}.
   *
   * <p>Method under test: {@link StructuredContentItemCriteriaImpl#cloneEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StructuredContentItemCriteria StructuredContentItemCriteriaImpl.cloneEntity()"
  })
  public void testCloneEntity() {
    // Arrange
    StructuredContentItemCriteriaImpl structuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();

    // Act
    StructuredContentItemCriteria actualCloneEntityResult =
        structuredContentItemCriteriaImpl.cloneEntity();

    // Assert
    assertTrue(actualCloneEntityResult instanceof StructuredContentItemCriteriaImpl);
    assertEquals(structuredContentItemCriteriaImpl, actualCloneEntityResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StructuredContentItemCriteriaImpl}
   *   <li>{@link StructuredContentItemCriteriaImpl#setId(Long)}
   *   <li>{@link StructuredContentItemCriteriaImpl#setMatchRule(String)}
   *   <li>{@link StructuredContentItemCriteriaImpl#setQuantity(Integer)}
   *   <li>{@link StructuredContentItemCriteriaImpl#setStructuredContent(StructuredContent)}
   *   <li>{@link StructuredContentItemCriteriaImpl#getId()}
   *   <li>{@link StructuredContentItemCriteriaImpl#getMatchRule()}
   *   <li>{@link StructuredContentItemCriteriaImpl#getQuantity()}
   *   <li>{@link StructuredContentItemCriteriaImpl#getStructuredContent()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentItemCriteriaImpl.<init>()",
    "Long StructuredContentItemCriteriaImpl.getId()",
    "String StructuredContentItemCriteriaImpl.getMatchRule()",
    "Integer StructuredContentItemCriteriaImpl.getQuantity()",
    "StructuredContent StructuredContentItemCriteriaImpl.getStructuredContent()",
    "void StructuredContentItemCriteriaImpl.setId(Long)",
    "void StructuredContentItemCriteriaImpl.setMatchRule(String)",
    "void StructuredContentItemCriteriaImpl.setQuantity(Integer)",
    "void StructuredContentItemCriteriaImpl.setStructuredContent(StructuredContent)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentItemCriteriaImpl actualStructuredContentItemCriteriaImpl =
        new StructuredContentItemCriteriaImpl();
    actualStructuredContentItemCriteriaImpl.setId(
        StructuredContentItemCriteriaImpl.serialVersionUID);
    actualStructuredContentItemCriteriaImpl.setMatchRule("Match Rule");
    actualStructuredContentItemCriteriaImpl.setQuantity(1);
    StructuredContentImpl structuredContent = new StructuredContentImpl();
    actualStructuredContentItemCriteriaImpl.setStructuredContent(structuredContent);
    Long actualId = actualStructuredContentItemCriteriaImpl.getId();
    String actualMatchRule = actualStructuredContentItemCriteriaImpl.getMatchRule();
    Integer actualQuantity = actualStructuredContentItemCriteriaImpl.getQuantity();
    StructuredContent actualStructuredContent =
        actualStructuredContentItemCriteriaImpl.getStructuredContent();

    // Assert
    assertEquals("Match Rule", actualMatchRule);
    assertEquals(1, actualQuantity.intValue());
    assertEquals(StructuredContentItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(structuredContent, actualStructuredContent);
  }
}
