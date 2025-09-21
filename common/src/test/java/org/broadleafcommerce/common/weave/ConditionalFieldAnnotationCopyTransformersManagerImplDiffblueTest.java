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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class ConditionalFieldAnnotationCopyTransformersManagerImplDiffblueTest {
  @InjectMocks
  private ConditionalFieldAnnotationCopyTransformersManagerImpl
      conditionalFieldAnnotationCopyTransformersManagerImpl;

  @Mock private Map<String, ConditionalFieldAnnotationCopyTransformMemberDTO> map;

  /**
   * Test {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#isEntityEnabled(String)}.
   *
   * <ul>
   *   <li>Given {@link Map} {@link Map#containsKey(Object)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConditionalFieldAnnotationCopyTransformersManagerImpl#isEntityEnabled(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ConditionalFieldAnnotationCopyTransformersManagerImpl.isEntityEnabled(String)"
  })
  public void testIsEntityEnabled_givenMapContainsKeyReturnFalse_thenReturnFalse() {
    // Arrange
    when(map.containsKey(Mockito.<Object>any())).thenReturn(false);

    // Act
    Boolean actualIsEntityEnabledResult =
        conditionalFieldAnnotationCopyTransformersManagerImpl.isEntityEnabled("Entity Name");

    // Assert
    verify(map).containsKey(isA(Object.class));
    assertFalse(actualIsEntityEnabledResult);
  }

  /**
   * Test {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#isEntityEnabled(String)}.
   *
   * <ul>
   *   <li>Given {@link Map} {@link Map#containsKey(Object)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConditionalFieldAnnotationCopyTransformersManagerImpl#isEntityEnabled(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ConditionalFieldAnnotationCopyTransformersManagerImpl.isEntityEnabled(String)"
  })
  public void testIsEntityEnabled_givenMapContainsKeyReturnTrue_thenReturnTrue() {
    // Arrange
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);

    // Act
    Boolean actualIsEntityEnabledResult =
        conditionalFieldAnnotationCopyTransformersManagerImpl.isEntityEnabled("Entity Name");

    // Assert
    verify(map).containsKey(isA(Object.class));
    assertTrue(actualIsEntityEnabledResult);
  }

  /**
   * Test {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#getTransformMember(String)}.
   *
   * <p>Method under test: {@link
   * ConditionalFieldAnnotationCopyTransformersManagerImpl#getTransformMember(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ConditionalFieldAnnotationCopyTransformMemberDTO ConditionalFieldAnnotationCopyTransformersManagerImpl.getTransformMember(String)"
  })
  public void testGetTransformMember() {
    // Arrange
    ConditionalFieldAnnotationCopyTransformMemberDTO
        conditionalFieldAnnotationCopyTransformMemberDTO =
            new ConditionalFieldAnnotationCopyTransformMemberDTO();
    conditionalFieldAnnotationCopyTransformMemberDTO.setConditionalProperty("Property Name");
    conditionalFieldAnnotationCopyTransformMemberDTO.setTemplateNames(
        new String[] {"Template Names"});
    when(map.get(Mockito.<Object>any()))
        .thenReturn(conditionalFieldAnnotationCopyTransformMemberDTO);

    // Act
    ConditionalFieldAnnotationCopyTransformMemberDTO actualTransformMember =
        conditionalFieldAnnotationCopyTransformersManagerImpl.getTransformMember("Entity Name");

    // Assert
    verify(map).get(isA(Object.class));
    assertSame(conditionalFieldAnnotationCopyTransformMemberDTO, actualTransformMember);
  }

  /**
   * Test {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#isPropertyEnabled(String)}.
   *
   * <p>Method under test: {@link
   * ConditionalFieldAnnotationCopyTransformersManagerImpl#isPropertyEnabled(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ConditionalFieldAnnotationCopyTransformersManagerImpl.isPropertyEnabled(String)"
  })
  public void testIsPropertyEnabled() throws BeansException {
    // Arrange
    ConditionalFieldAnnotationCopyTransformersManagerImpl
        conditionalFieldAnnotationCopyTransformersManagerImpl =
            new ConditionalFieldAnnotationCopyTransformersManagerImpl();
    conditionalFieldAnnotationCopyTransformersManagerImpl.setBeanFactory(
        new DefaultListableBeanFactory());

    // Act and Assert
    assertFalse(
        conditionalFieldAnnotationCopyTransformersManagerImpl.isPropertyEnabled("Property Name"));
  }

  /**
   * Test {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#isPropertyEnabled(String)}.
   *
   * <ul>
   *   <li>Given {@link ConditionalFieldAnnotationCopyTransformersManagerImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConditionalFieldAnnotationCopyTransformersManagerImpl#isPropertyEnabled(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ConditionalFieldAnnotationCopyTransformersManagerImpl.isPropertyEnabled(String)"
  })
  public void testIsPropertyEnabled_givenConditionalFieldAnnotationCopyTransformersManagerImpl() {
    // Arrange, Act and Assert
    assertFalse(
        conditionalFieldAnnotationCopyTransformersManagerImpl.isPropertyEnabled("Property Name"));
  }
}
