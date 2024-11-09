/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.weave;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ConditionalDirectCopyTransformMemberDtoDiffblueTest {
  /**
   * Test {@link ConditionalDirectCopyTransformMemberDto#equals(Object)}, and
   * {@link ConditionalDirectCopyTransformMemberDto#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#equals(Object)}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConditionalDirectCopyTransformMemberDto conditionalDirectCopyTransformMemberDto = new ConditionalDirectCopyTransformMemberDto();
    conditionalDirectCopyTransformMemberDto.setConditionalProperty("Conditional Property");
    conditionalDirectCopyTransformMemberDto.setConditionalValue(true);
    conditionalDirectCopyTransformMemberDto.setRenameMethodOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setSkipOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setTemplateTokens(new String[]{"ABC123"});

    ConditionalDirectCopyTransformMemberDto conditionalDirectCopyTransformMemberDto2 = new ConditionalDirectCopyTransformMemberDto();
    conditionalDirectCopyTransformMemberDto2.setConditionalProperty("Conditional Property");
    conditionalDirectCopyTransformMemberDto2.setConditionalValue(true);
    conditionalDirectCopyTransformMemberDto2.setRenameMethodOverlaps(true);
    conditionalDirectCopyTransformMemberDto2.setSkipOverlaps(true);
    conditionalDirectCopyTransformMemberDto2.setTemplateTokens(new String[]{"ABC123"});

    // Act and Assert
    assertEquals(conditionalDirectCopyTransformMemberDto, conditionalDirectCopyTransformMemberDto2);
    int expectedHashCodeResult = conditionalDirectCopyTransformMemberDto.hashCode();
    assertEquals(expectedHashCodeResult, conditionalDirectCopyTransformMemberDto2.hashCode());
  }

  /**
   * Test {@link ConditionalDirectCopyTransformMemberDto#equals(Object)}, and
   * {@link ConditionalDirectCopyTransformMemberDto#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#equals(Object)}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConditionalDirectCopyTransformMemberDto conditionalDirectCopyTransformMemberDto = new ConditionalDirectCopyTransformMemberDto();
    conditionalDirectCopyTransformMemberDto.setConditionalProperty("Conditional Property");
    conditionalDirectCopyTransformMemberDto.setConditionalValue(true);
    conditionalDirectCopyTransformMemberDto.setRenameMethodOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setSkipOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setTemplateTokens(new String[]{"ABC123"});

    // Act and Assert
    assertEquals(conditionalDirectCopyTransformMemberDto, conditionalDirectCopyTransformMemberDto);
    int expectedHashCodeResult = conditionalDirectCopyTransformMemberDto.hashCode();
    assertEquals(expectedHashCodeResult, conditionalDirectCopyTransformMemberDto.hashCode());
  }

  /**
   * Test {@link ConditionalDirectCopyTransformMemberDto#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConditionalDirectCopyTransformMemberDto#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConditionalDirectCopyTransformMemberDto conditionalDirectCopyTransformMemberDto = new ConditionalDirectCopyTransformMemberDto();
    conditionalDirectCopyTransformMemberDto.setConditionalProperty(null);
    conditionalDirectCopyTransformMemberDto.setConditionalValue(true);
    conditionalDirectCopyTransformMemberDto.setRenameMethodOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setSkipOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setTemplateTokens(new String[]{"ABC123"});

    ConditionalDirectCopyTransformMemberDto conditionalDirectCopyTransformMemberDto2 = new ConditionalDirectCopyTransformMemberDto();
    conditionalDirectCopyTransformMemberDto2.setConditionalProperty("Conditional Property");
    conditionalDirectCopyTransformMemberDto2.setConditionalValue(true);
    conditionalDirectCopyTransformMemberDto2.setRenameMethodOverlaps(true);
    conditionalDirectCopyTransformMemberDto2.setSkipOverlaps(true);
    conditionalDirectCopyTransformMemberDto2.setTemplateTokens(new String[]{"ABC123"});

    // Act and Assert
    assertNotEquals(conditionalDirectCopyTransformMemberDto, conditionalDirectCopyTransformMemberDto2);
  }

  /**
   * Test {@link ConditionalDirectCopyTransformMemberDto#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConditionalDirectCopyTransformMemberDto#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ConditionalDirectCopyTransformMemberDto conditionalDirectCopyTransformMemberDto = new ConditionalDirectCopyTransformMemberDto();
    conditionalDirectCopyTransformMemberDto.setConditionalProperty("Conditional Property");
    conditionalDirectCopyTransformMemberDto.setConditionalValue(true);
    conditionalDirectCopyTransformMemberDto.setRenameMethodOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setSkipOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setTemplateTokens(new String[]{"ABC123"});

    // Act and Assert
    assertNotEquals(conditionalDirectCopyTransformMemberDto, null);
  }

  /**
   * Test {@link ConditionalDirectCopyTransformMemberDto#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConditionalDirectCopyTransformMemberDto#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ConditionalDirectCopyTransformMemberDto conditionalDirectCopyTransformMemberDto = new ConditionalDirectCopyTransformMemberDto();
    conditionalDirectCopyTransformMemberDto.setConditionalProperty("Conditional Property");
    conditionalDirectCopyTransformMemberDto.setConditionalValue(true);
    conditionalDirectCopyTransformMemberDto.setRenameMethodOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setSkipOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setTemplateTokens(new String[]{"ABC123"});

    // Act and Assert
    assertNotEquals(conditionalDirectCopyTransformMemberDto,
        "Different type to ConditionalDirectCopyTransformMemberDto");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ConditionalDirectCopyTransformMemberDto}
   *   <li>
   * {@link ConditionalDirectCopyTransformMemberDto#setConditionalProperty(String)}
   *   <li>
   * {@link ConditionalDirectCopyTransformMemberDto#setConditionalValue(Boolean)}
   *   <li>
   * {@link ConditionalDirectCopyTransformMemberDto#setRenameMethodOverlaps(boolean)}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#setSkipOverlaps(boolean)}
   *   <li>
   * {@link ConditionalDirectCopyTransformMemberDto#setTemplateTokens(String[])}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#getConditionalProperty()}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#getConditionalValue()}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#getTemplateTokens()}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#isRenameMethodOverlaps()}
   *   <li>{@link ConditionalDirectCopyTransformMemberDto#isSkipOverlaps()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ConditionalDirectCopyTransformMemberDto actualConditionalDirectCopyTransformMemberDto = new ConditionalDirectCopyTransformMemberDto();
    actualConditionalDirectCopyTransformMemberDto.setConditionalProperty("Conditional Property");
    actualConditionalDirectCopyTransformMemberDto.setConditionalValue(true);
    actualConditionalDirectCopyTransformMemberDto.setRenameMethodOverlaps(true);
    actualConditionalDirectCopyTransformMemberDto.setSkipOverlaps(true);
    String[] templateTokens = new String[]{"ABC123"};
    actualConditionalDirectCopyTransformMemberDto.setTemplateTokens(templateTokens);
    String actualConditionalProperty = actualConditionalDirectCopyTransformMemberDto.getConditionalProperty();
    Boolean actualConditionalValue = actualConditionalDirectCopyTransformMemberDto.getConditionalValue();
    String[] actualTemplateTokens = actualConditionalDirectCopyTransformMemberDto.getTemplateTokens();
    boolean actualIsRenameMethodOverlapsResult = actualConditionalDirectCopyTransformMemberDto.isRenameMethodOverlaps();

    // Assert that nothing has changed
    assertEquals("Conditional Property", actualConditionalProperty);
    assertTrue(actualConditionalValue);
    assertTrue(actualIsRenameMethodOverlapsResult);
    assertTrue(actualConditionalDirectCopyTransformMemberDto.isSkipOverlaps());
    assertSame(templateTokens, actualTemplateTokens);
    assertArrayEquals(new String[]{"ABC123"}, actualTemplateTokens);
  }
}
