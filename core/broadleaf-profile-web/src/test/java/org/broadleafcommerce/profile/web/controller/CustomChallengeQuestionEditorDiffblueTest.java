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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.beans.PropertyChangeListener;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.broadleafcommerce.profile.core.service.ChallengeQuestionService;
import org.broadleafcommerce.profile.core.service.ChallengeQuestionServiceImpl;
import org.junit.jupiter.api.Test;

class CustomChallengeQuestionEditorDiffblueTest {
  /**
   * Method under test: {@link CustomChallengeQuestionEditor#getAsText()}
   */
  @Test
  void testGetAsText() {
    // Arrange, Act and Assert
    assertNull((new CustomChallengeQuestionEditor(new ChallengeQuestionServiceImpl())).getAsText());
  }

  /**
   * Method under test: {@link CustomChallengeQuestionEditor#getAsText()}
   */
  @Test
  void testGetAsText2() {
    // Arrange
    CustomChallengeQuestionEditor customChallengeQuestionEditor = new CustomChallengeQuestionEditor(
        new ChallengeQuestionServiceImpl());
    customChallengeQuestionEditor.addPropertyChangeListener(mock(PropertyChangeListener.class));

    // Act and Assert
    assertNull(customChallengeQuestionEditor.getAsText());
  }

  /**
   * Method under test: {@link CustomChallengeQuestionEditor#getAsText()}
   */
  @Test
  void testGetAsText3() {
    // Arrange
    ChallengeQuestionImpl challengeQuestionImpl = new ChallengeQuestionImpl();
    challengeQuestionImpl.setId(1L);
    challengeQuestionImpl.setQuestion("Question");

    CustomChallengeQuestionEditor customChallengeQuestionEditor = new CustomChallengeQuestionEditor(
        new ChallengeQuestionServiceImpl());
    customChallengeQuestionEditor.setValue(challengeQuestionImpl);
    customChallengeQuestionEditor.addPropertyChangeListener(mock(PropertyChangeListener.class));

    // Act and Assert
    assertEquals("1", customChallengeQuestionEditor.getAsText());
  }

  /**
   * Method under test: {@link CustomChallengeQuestionEditor#setAsText(String)}
   */
  @Test
  void testSetAsText() throws IllegalArgumentException {
    // Arrange
    ChallengeQuestionServiceImpl challengeQuestionService = mock(ChallengeQuestionServiceImpl.class);
    ChallengeQuestionImpl challengeQuestionImpl = new ChallengeQuestionImpl();
    when(challengeQuestionService.readChallengeQuestionById(anyLong())).thenReturn(challengeQuestionImpl);
    CustomChallengeQuestionEditor customChallengeQuestionEditor = new CustomChallengeQuestionEditor(
        challengeQuestionService);

    // Act
    customChallengeQuestionEditor.setAsText("42");

    // Assert
    verify(challengeQuestionService).readChallengeQuestionById(eq(42L));
    assertSame(challengeQuestionImpl, customChallengeQuestionEditor.getValue());
  }

  /**
   * Method under test:
   * {@link CustomChallengeQuestionEditor#CustomChallengeQuestionEditor(ChallengeQuestionService)}
   */
  @Test
  void testNewCustomChallengeQuestionEditor() {
    // Arrange and Act
    CustomChallengeQuestionEditor actualCustomChallengeQuestionEditor = new CustomChallengeQuestionEditor(
        new ChallengeQuestionServiceImpl());

    // Assert
    assertNull(actualCustomChallengeQuestionEditor.getValue());
    assertSame(actualCustomChallengeQuestionEditor, actualCustomChallengeQuestionEditor.getSource());
  }
}
