/*-
 * #%L
 * BroadleafCommerce Profile Web
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
package org.broadleafcommerce.profile.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.broadleafcommerce.profile.core.service.ChallengeQuestionService;
import org.broadleafcommerce.profile.core.service.ChallengeQuestionServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CustomChallengeQuestionEditorDiffblueTest {
  /**
   * Test {@link
   * CustomChallengeQuestionEditor#CustomChallengeQuestionEditor(ChallengeQuestionService)}.
   *
   * <p>Method under test: {@link
   * CustomChallengeQuestionEditor#CustomChallengeQuestionEditor(ChallengeQuestionService)}
   */
  @Test
  @DisplayName("Test new CustomChallengeQuestionEditor(ChallengeQuestionService)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomChallengeQuestionEditor.<init>(ChallengeQuestionService)"})
  void testNewCustomChallengeQuestionEditor() {
    // Arrange and Act
    CustomChallengeQuestionEditor actualCustomChallengeQuestionEditor =
        new CustomChallengeQuestionEditor(new ChallengeQuestionServiceImpl());

    // Assert
    assertNull(actualCustomChallengeQuestionEditor.getValue());
    Object actualSource = actualCustomChallengeQuestionEditor.getSource();
    assertSame(actualCustomChallengeQuestionEditor, actualSource);
  }

  /**
   * Test {@link CustomChallengeQuestionEditor#getAsText()}.
   *
   * <ul>
   *   <li>Given {@link ChallengeQuestionImpl} (default constructor) Id is one.
   *   <li>Then return {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link CustomChallengeQuestionEditor#getAsText()}
   */
  @Test
  @DisplayName(
      "Test getAsText(); given ChallengeQuestionImpl (default constructor) Id is one; then return '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CustomChallengeQuestionEditor.getAsText()"})
  void testGetAsText_givenChallengeQuestionImplIdIsOne_thenReturn1() {
    // Arrange
    ChallengeQuestionImpl challengeQuestionImpl = new ChallengeQuestionImpl();
    challengeQuestionImpl.setId(1L);
    challengeQuestionImpl.setQuestion("Question");

    CustomChallengeQuestionEditor customChallengeQuestionEditor =
        new CustomChallengeQuestionEditor(new ChallengeQuestionServiceImpl());
    customChallengeQuestionEditor.setValue(challengeQuestionImpl);
    customChallengeQuestionEditor.addPropertyChangeListener(mock(PropertyChangeListener.class));

    // Act and Assert
    assertEquals("1", customChallengeQuestionEditor.getAsText());
  }

  /**
   * Test {@link CustomChallengeQuestionEditor#getAsText()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomChallengeQuestionEditor#getAsText()}
   */
  @Test
  @DisplayName("Test getAsText(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String CustomChallengeQuestionEditor.getAsText()"})
  void testGetAsText_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new CustomChallengeQuestionEditor(new ChallengeQuestionServiceImpl()).getAsText());
  }

  /**
   * Test {@link CustomChallengeQuestionEditor#setAsText(String)}.
   *
   * <p>Method under test: {@link CustomChallengeQuestionEditor#setAsText(String)}
   */
  @Test
  @DisplayName("Test setAsText(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomChallengeQuestionEditor.setAsText(String)"})
  void testSetAsText() throws IllegalArgumentException {
    // Arrange
    ChallengeQuestionServiceImpl challengeQuestionService =
        mock(ChallengeQuestionServiceImpl.class);
    ChallengeQuestionImpl challengeQuestionImpl = new ChallengeQuestionImpl();
    when(challengeQuestionService.readChallengeQuestionById(anyLong()))
        .thenReturn(challengeQuestionImpl);
    CustomChallengeQuestionEditor customChallengeQuestionEditor =
        new CustomChallengeQuestionEditor(challengeQuestionService);

    // Act
    customChallengeQuestionEditor.setAsText("42");

    // Assert
    verify(challengeQuestionService).readChallengeQuestionById(42L);
    assertSame(challengeQuestionImpl, customChallengeQuestionEditor.getValue());
  }

  /**
   * Test {@link CustomChallengeQuestionEditor#setAsText(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomChallengeQuestionEditor#setAsText(String)}
   */
  @Test
  @DisplayName("Test setAsText(String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomChallengeQuestionEditor.setAsText(String)"})
  void testSetAsText_thenThrowIllegalArgumentException() throws IllegalArgumentException {
    // Arrange
    ChallengeQuestionServiceImpl challengeQuestionService =
        mock(ChallengeQuestionServiceImpl.class);
    when(challengeQuestionService.readChallengeQuestionById(anyLong()))
        .thenReturn(new ChallengeQuestionImpl());

    PropertyChangeListener propertyChangeListener = mock(PropertyChangeListener.class);
    doThrow(new IllegalArgumentException())
        .when(propertyChangeListener)
        .propertyChange(Mockito.<PropertyChangeEvent>any());

    CustomChallengeQuestionEditor customChallengeQuestionEditor =
        new CustomChallengeQuestionEditor(challengeQuestionService);
    customChallengeQuestionEditor.addPropertyChangeListener(propertyChangeListener);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> customChallengeQuestionEditor.setAsText("42"));
    verify(propertyChangeListener).propertyChange(isA(PropertyChangeEvent.class));
    verify(challengeQuestionService).readChallengeQuestionById(42L);
  }
}
