/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConditionalDirectCopyTransformersManagerImplDiffblueTest {
  @InjectMocks
  private ConditionalDirectCopyTransformersManagerImpl conditionalDirectCopyTransformersManagerImpl;

  @Mock
  private Map<String, ConditionalDirectCopyTransformMemberDto> map;

  /**
   * Test {@link ConditionalDirectCopyTransformersManagerImpl#isEntityEnabled(String)}.
   * <ul>
   *   <li>Given {@link Map} {@link Map#containsKey(Object)} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConditionalDirectCopyTransformersManagerImpl#isEntityEnabled(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean ConditionalDirectCopyTransformersManagerImpl.isEntityEnabled(String)"})
  public void testIsEntityEnabled_givenMapContainsKeyReturnFalse_thenReturnFalse() {
    // Arrange
    when(map.containsKey(Mockito.<Object>any())).thenReturn(false);

    // Act
    Boolean actualIsEntityEnabledResult = conditionalDirectCopyTransformersManagerImpl.isEntityEnabled("Entity Name");

    // Assert
    verify(map).containsKey(isA(Object.class));
    assertFalse(actualIsEntityEnabledResult);
  }

  /**
   * Test {@link ConditionalDirectCopyTransformersManagerImpl#isEntityEnabled(String)}.
   * <ul>
   *   <li>Given {@link Map} {@link Map#containsKey(Object)} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConditionalDirectCopyTransformersManagerImpl#isEntityEnabled(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean ConditionalDirectCopyTransformersManagerImpl.isEntityEnabled(String)"})
  public void testIsEntityEnabled_givenMapContainsKeyReturnTrue_thenReturnTrue() {
    // Arrange
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);

    // Act
    Boolean actualIsEntityEnabledResult = conditionalDirectCopyTransformersManagerImpl.isEntityEnabled("Entity Name");

    // Assert
    verify(map).containsKey(isA(Object.class));
    assertTrue(actualIsEntityEnabledResult);
  }

  /**
   * Test {@link ConditionalDirectCopyTransformersManagerImpl#getTransformMember(String)}.
   * <ul>
   *   <li>Then return {@link ConditionalDirectCopyTransformMemberDto} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ConditionalDirectCopyTransformersManagerImpl#getTransformMember(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ConditionalDirectCopyTransformMemberDto ConditionalDirectCopyTransformersManagerImpl.getTransformMember(String)"})
  public void testGetTransformMember_thenReturnConditionalDirectCopyTransformMemberDto() {
    // Arrange
    ConditionalDirectCopyTransformMemberDto conditionalDirectCopyTransformMemberDto = new ConditionalDirectCopyTransformMemberDto();
    conditionalDirectCopyTransformMemberDto.setConditionalProperty("Conditional Property");
    conditionalDirectCopyTransformMemberDto.setConditionalValue(true);
    conditionalDirectCopyTransformMemberDto.setRenameMethodOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setSkipOverlaps(true);
    conditionalDirectCopyTransformMemberDto.setTemplateTokens(new String[]{"ABC123"});
    when(map.get(Mockito.<Object>any())).thenReturn(conditionalDirectCopyTransformMemberDto);

    // Act
    ConditionalDirectCopyTransformMemberDto actualTransformMember = conditionalDirectCopyTransformersManagerImpl
        .getTransformMember("Entity Name");

    // Assert
    verify(map).get(isA(Object.class));
    assertSame(conditionalDirectCopyTransformMemberDto, actualTransformMember);
  }

  /**
   * Test {@link ConditionalDirectCopyTransformersManagerImpl#isPropertyEnabled(String)}.
   * <p>
   * Method under test: {@link ConditionalDirectCopyTransformersManagerImpl#isPropertyEnabled(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean ConditionalDirectCopyTransformersManagerImpl.isPropertyEnabled(String)"})
  public void testIsPropertyEnabled() {
    // Arrange, Act and Assert
    assertFalse(conditionalDirectCopyTransformersManagerImpl.isPropertyEnabled("Property Name"));
  }
}
