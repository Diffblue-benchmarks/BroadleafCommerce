package org.broadleafcommerce.common.weave;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConditionalDirectCopyTransformMemberDtoDiffblueTest {
  /**
   * Test {@link ConditionalDirectCopyTransformMemberDto#equals(Object)}, and {@link
   * ConditionalDirectCopyTransformMemberDto#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#equals(Object)}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConditionalDirectCopyTransformMemberDto.equals(Object)",
    "int ConditionalDirectCopyTransformMemberDto.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConditionalDirectCopyTransformMemberDto conditionalDirectCopyTransformMemberDto =
        new ConditionalDirectCopyTransformMemberDto();
    conditionalDirectCopyTransformMemberDto.setConditionalProperty("Conditional Property");
    conditionalDirectCopyTransformMemberDto.setConditionalValue(true);
    conditionalDirectCopyTransformMemberDto.setRenameMethodOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setSkipOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setTemplateTokens(new String[] {"ABC123"});

    ConditionalDirectCopyTransformMemberDto conditionalDirectCopyTransformMemberDto2 =
        new ConditionalDirectCopyTransformMemberDto();
    conditionalDirectCopyTransformMemberDto2.setConditionalProperty("Conditional Property");
    conditionalDirectCopyTransformMemberDto2.setConditionalValue(true);
    conditionalDirectCopyTransformMemberDto2.setRenameMethodOverlaps(true);
    conditionalDirectCopyTransformMemberDto2.setSkipOverlaps(true);
    conditionalDirectCopyTransformMemberDto2.setTemplateTokens(new String[] {"ABC123"});

    // Act and Assert
    assertEquals(conditionalDirectCopyTransformMemberDto, conditionalDirectCopyTransformMemberDto2);
    assertEquals(
        conditionalDirectCopyTransformMemberDto.hashCode(),
        conditionalDirectCopyTransformMemberDto2.hashCode());
  }

  /**
   * Test {@link ConditionalDirectCopyTransformMemberDto#equals(Object)}, and {@link
   * ConditionalDirectCopyTransformMemberDto#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#equals(Object)}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConditionalDirectCopyTransformMemberDto.equals(Object)",
    "int ConditionalDirectCopyTransformMemberDto.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConditionalDirectCopyTransformMemberDto conditionalDirectCopyTransformMemberDto =
        new ConditionalDirectCopyTransformMemberDto();
    conditionalDirectCopyTransformMemberDto.setConditionalProperty("Conditional Property");
    conditionalDirectCopyTransformMemberDto.setConditionalValue(true);
    conditionalDirectCopyTransformMemberDto.setRenameMethodOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setSkipOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setTemplateTokens(new String[] {"ABC123"});

    // Act and Assert
    assertEquals(conditionalDirectCopyTransformMemberDto, conditionalDirectCopyTransformMemberDto);
    int expectedHashCodeResult = conditionalDirectCopyTransformMemberDto.hashCode();
    assertEquals(expectedHashCodeResult, conditionalDirectCopyTransformMemberDto.hashCode());
  }

  /**
   * Test {@link ConditionalDirectCopyTransformMemberDto#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConditionalDirectCopyTransformMemberDto#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConditionalDirectCopyTransformMemberDto.equals(Object)",
    "int ConditionalDirectCopyTransformMemberDto.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConditionalDirectCopyTransformMemberDto conditionalDirectCopyTransformMemberDto =
        new ConditionalDirectCopyTransformMemberDto();
    conditionalDirectCopyTransformMemberDto.setConditionalProperty(null);
    conditionalDirectCopyTransformMemberDto.setConditionalValue(true);
    conditionalDirectCopyTransformMemberDto.setRenameMethodOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setSkipOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setTemplateTokens(new String[] {"ABC123"});

    ConditionalDirectCopyTransformMemberDto conditionalDirectCopyTransformMemberDto2 =
        new ConditionalDirectCopyTransformMemberDto();
    conditionalDirectCopyTransformMemberDto2.setConditionalProperty("Conditional Property");
    conditionalDirectCopyTransformMemberDto2.setConditionalValue(true);
    conditionalDirectCopyTransformMemberDto2.setRenameMethodOverlaps(true);
    conditionalDirectCopyTransformMemberDto2.setSkipOverlaps(true);
    conditionalDirectCopyTransformMemberDto2.setTemplateTokens(new String[] {"ABC123"});

    // Act and Assert
    assertNotEquals(
        conditionalDirectCopyTransformMemberDto, conditionalDirectCopyTransformMemberDto2);
  }

  /**
   * Test {@link ConditionalDirectCopyTransformMemberDto#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConditionalDirectCopyTransformMemberDto#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConditionalDirectCopyTransformMemberDto.equals(Object)",
    "int ConditionalDirectCopyTransformMemberDto.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ConditionalDirectCopyTransformMemberDto conditionalDirectCopyTransformMemberDto =
        new ConditionalDirectCopyTransformMemberDto();
    conditionalDirectCopyTransformMemberDto.setConditionalProperty("Conditional Property");
    conditionalDirectCopyTransformMemberDto.setConditionalValue(true);
    conditionalDirectCopyTransformMemberDto.setRenameMethodOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setSkipOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setTemplateTokens(new String[] {"ABC123"});

    // Act and Assert
    assertNotEquals(conditionalDirectCopyTransformMemberDto, null);
  }

  /**
   * Test {@link ConditionalDirectCopyTransformMemberDto#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConditionalDirectCopyTransformMemberDto#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConditionalDirectCopyTransformMemberDto.equals(Object)",
    "int ConditionalDirectCopyTransformMemberDto.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ConditionalDirectCopyTransformMemberDto conditionalDirectCopyTransformMemberDto =
        new ConditionalDirectCopyTransformMemberDto();
    conditionalDirectCopyTransformMemberDto.setConditionalProperty("Conditional Property");
    conditionalDirectCopyTransformMemberDto.setConditionalValue(true);
    conditionalDirectCopyTransformMemberDto.setRenameMethodOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setSkipOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setTemplateTokens(new String[] {"ABC123"});

    // Act and Assert
    assertNotEquals(
        conditionalDirectCopyTransformMemberDto,
        "Different type to ConditionalDirectCopyTransformMemberDto");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ConditionalDirectCopyTransformMemberDto}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#setConditionalProperty(String)}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#setConditionalValue(Boolean)}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#setRenameMethodOverlaps(boolean)}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#setSkipOverlaps(boolean)}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#setTemplateTokens(String[])}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#getConditionalProperty()}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#getConditionalValue()}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#getTemplateTokens()}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#isRenameMethodOverlaps()}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#isSkipOverlaps()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConditionalDirectCopyTransformMemberDto.<init>()",
    "String ConditionalDirectCopyTransformMemberDto.getConditionalProperty()",
    "Boolean ConditionalDirectCopyTransformMemberDto.getConditionalValue()",
    "String[] ConditionalDirectCopyTransformMemberDto.getTemplateTokens()",
    "boolean ConditionalDirectCopyTransformMemberDto.isRenameMethodOverlaps()",
    "boolean ConditionalDirectCopyTransformMemberDto.isSkipOverlaps()",
    "void ConditionalDirectCopyTransformMemberDto.setConditionalProperty(String)",
    "void ConditionalDirectCopyTransformMemberDto.setConditionalValue(Boolean)",
    "void ConditionalDirectCopyTransformMemberDto.setRenameMethodOverlaps(boolean)",
    "void ConditionalDirectCopyTransformMemberDto.setSkipOverlaps(boolean)",
    "void ConditionalDirectCopyTransformMemberDto.setTemplateTokens(String[])"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ConditionalDirectCopyTransformMemberDto actualConditionalDirectCopyTransformMemberDto =
        new ConditionalDirectCopyTransformMemberDto();
    actualConditionalDirectCopyTransformMemberDto.setConditionalProperty("Conditional Property");
    actualConditionalDirectCopyTransformMemberDto.setConditionalValue(true);
    actualConditionalDirectCopyTransformMemberDto.setRenameMethodOverlaps(true);
    actualConditionalDirectCopyTransformMemberDto.setSkipOverlaps(true);
    String[] templateTokens = new String[] {"ABC123"};
    actualConditionalDirectCopyTransformMemberDto.setTemplateTokens(templateTokens);
    String actualConditionalProperty =
        actualConditionalDirectCopyTransformMemberDto.getConditionalProperty();
    Boolean actualConditionalValue =
        actualConditionalDirectCopyTransformMemberDto.getConditionalValue();
    String[] actualTemplateTokens =
        actualConditionalDirectCopyTransformMemberDto.getTemplateTokens();
    boolean actualIsRenameMethodOverlapsResult =
        actualConditionalDirectCopyTransformMemberDto.isRenameMethodOverlaps();

    // Assert
    assertEquals("Conditional Property", actualConditionalProperty);
    assertTrue(actualConditionalValue);
    assertTrue(actualIsRenameMethodOverlapsResult);
    assertTrue(actualConditionalDirectCopyTransformMemberDto.isSkipOverlaps());
    assertSame(templateTokens, actualTemplateTokens);
    assertArrayEquals(new String[] {"ABC123"}, actualTemplateTokens);
  }
}
