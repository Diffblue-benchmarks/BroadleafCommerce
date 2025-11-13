package org.broadleafcommerce.profile.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.broadleafcommerce.profile.core.service.ChallengeQuestionService;
import org.broadleafcommerce.profile.core.service.ChallengeQuestionServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomChallengeQuestionEditorDiffblueTest {
  @Mock private ChallengeQuestionService challengeQuestionService;

  @InjectMocks private CustomChallengeQuestionEditor customChallengeQuestionEditor;

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
   * <ul>
   *   <li>Then {@link CustomChallengeQuestionEditor} Value is {@link ChallengeQuestionImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomChallengeQuestionEditor#setAsText(String)}
   */
  @Test
  @DisplayName(
      "Test setAsText(String); then CustomChallengeQuestionEditor Value is ChallengeQuestionImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomChallengeQuestionEditor.setAsText(String)"})
  void testSetAsText_thenCustomChallengeQuestionEditorValueIsChallengeQuestionImpl()
      throws IllegalArgumentException {
    // Arrange
    ChallengeQuestionImpl challengeQuestionImpl = new ChallengeQuestionImpl();
    when(challengeQuestionService.readChallengeQuestionById(anyLong()))
        .thenReturn(challengeQuestionImpl);

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
    when(challengeQuestionService.readChallengeQuestionById(anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> customChallengeQuestionEditor.setAsText("42"));
    verify(challengeQuestionService).readChallengeQuestionById(42L);
  }
}
