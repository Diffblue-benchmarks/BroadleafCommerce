package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml",
    "/bl-profile-applicationContext-persistence.xml", "/bl-profile-applicationContext.xml",
    "/blc-config/admin/framework/bl-profile-applicationContext.xml",
    "/blc-config/site/framework/bl-profile-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ChallengeQuestionImplDiffblueTest {
  @Autowired
  private ChallengeQuestionImpl challengeQuestionImpl;

  /**
   * Test {@link ChallengeQuestionImpl#getQuestion()}.
   * <p>
   * Method under test: {@link ChallengeQuestionImpl#getQuestion()}
   */
  @Test
  public void testGetQuestion() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ChallengeQuestionImpl()).getQuestion());
  }

  /**
   * Test {@link ChallengeQuestionImpl#getQuestion()}.
   * <p>
   * Method under test: {@link ChallengeQuestionImpl#getQuestion()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetQuestion2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3308 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl challengeQuestionImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ChallengeQuestionImpl()).getQuestion();
  }

  /**
   * Test {@link ChallengeQuestionImpl#equals(Object)}, and
   * {@link ChallengeQuestionImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ChallengeQuestionImpl#equals(Object)}
   *   <li>{@link ChallengeQuestionImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ChallengeQuestionImpl challengeQuestionImpl = new ChallengeQuestionImpl();
    challengeQuestionImpl.setId(1L);
    challengeQuestionImpl.setQuestion("Question");

    ChallengeQuestionImpl challengeQuestionImpl2 = new ChallengeQuestionImpl();
    challengeQuestionImpl2.setId(1L);
    challengeQuestionImpl2.setQuestion("Question");

    // Act and Assert
    assertEquals(challengeQuestionImpl, challengeQuestionImpl2);
    int expectedHashCodeResult = challengeQuestionImpl.hashCode();
    assertEquals(expectedHashCodeResult, challengeQuestionImpl2.hashCode());
  }

  /**
   * Test {@link ChallengeQuestionImpl#equals(Object)}, and
   * {@link ChallengeQuestionImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ChallengeQuestionImpl#equals(Object)}
   *   <li>{@link ChallengeQuestionImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ChallengeQuestionImpl challengeQuestionImpl = new ChallengeQuestionImpl();
    challengeQuestionImpl.setId(null);
    challengeQuestionImpl.setQuestion("Question");

    ChallengeQuestionImpl challengeQuestionImpl2 = new ChallengeQuestionImpl();
    challengeQuestionImpl2.setId(1L);
    challengeQuestionImpl2.setQuestion("Question");

    // Act and Assert
    assertEquals(challengeQuestionImpl, challengeQuestionImpl2);
    int expectedHashCodeResult = challengeQuestionImpl.hashCode();
    assertEquals(expectedHashCodeResult, challengeQuestionImpl2.hashCode());
  }

  /**
   * Test {@link ChallengeQuestionImpl#equals(Object)}, and
   * {@link ChallengeQuestionImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ChallengeQuestionImpl#equals(Object)}
   *   <li>{@link ChallengeQuestionImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ChallengeQuestionImpl challengeQuestionImpl = new ChallengeQuestionImpl();
    challengeQuestionImpl.setId(1L);
    challengeQuestionImpl.setQuestion("Question");

    ChallengeQuestionImpl challengeQuestionImpl2 = new ChallengeQuestionImpl();
    challengeQuestionImpl2.setId(null);
    challengeQuestionImpl2.setQuestion("Question");

    // Act and Assert
    assertEquals(challengeQuestionImpl, challengeQuestionImpl2);
    int expectedHashCodeResult = challengeQuestionImpl.hashCode();
    assertEquals(expectedHashCodeResult, challengeQuestionImpl2.hashCode());
  }

  /**
   * Test {@link ChallengeQuestionImpl#equals(Object)}, and
   * {@link ChallengeQuestionImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ChallengeQuestionImpl#equals(Object)}
   *   <li>{@link ChallengeQuestionImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ChallengeQuestionImpl challengeQuestionImpl = new ChallengeQuestionImpl();
    challengeQuestionImpl.setId(null);
    challengeQuestionImpl.setQuestion(null);

    ChallengeQuestionImpl challengeQuestionImpl2 = new ChallengeQuestionImpl();
    challengeQuestionImpl2.setId(1L);
    challengeQuestionImpl2.setQuestion(null);

    // Act and Assert
    assertEquals(challengeQuestionImpl, challengeQuestionImpl2);
    int expectedHashCodeResult = challengeQuestionImpl.hashCode();
    assertEquals(expectedHashCodeResult, challengeQuestionImpl2.hashCode());
  }

  /**
   * Test {@link ChallengeQuestionImpl#equals(Object)}, and
   * {@link ChallengeQuestionImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ChallengeQuestionImpl#equals(Object)}
   *   <li>{@link ChallengeQuestionImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ChallengeQuestionImpl challengeQuestionImpl = new ChallengeQuestionImpl();
    challengeQuestionImpl.setId(1L);
    challengeQuestionImpl.setQuestion("Question");

    // Act and Assert
    assertEquals(challengeQuestionImpl, challengeQuestionImpl);
    int expectedHashCodeResult = challengeQuestionImpl.hashCode();
    assertEquals(expectedHashCodeResult, challengeQuestionImpl.hashCode());
  }

  /**
   * Test {@link ChallengeQuestionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChallengeQuestionImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ChallengeQuestionImpl challengeQuestionImpl = new ChallengeQuestionImpl();
    challengeQuestionImpl.setId(2L);
    challengeQuestionImpl.setQuestion("Question");

    ChallengeQuestionImpl challengeQuestionImpl2 = new ChallengeQuestionImpl();
    challengeQuestionImpl2.setId(1L);
    challengeQuestionImpl2.setQuestion("Question");

    // Act and Assert
    assertNotEquals(challengeQuestionImpl, challengeQuestionImpl2);
  }

  /**
   * Test {@link ChallengeQuestionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChallengeQuestionImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ChallengeQuestionImpl challengeQuestionImpl = new ChallengeQuestionImpl();
    challengeQuestionImpl.setId(null);
    challengeQuestionImpl.setQuestion(null);

    ChallengeQuestionImpl challengeQuestionImpl2 = new ChallengeQuestionImpl();
    challengeQuestionImpl2.setId(1L);
    challengeQuestionImpl2.setQuestion("Question");

    // Act and Assert
    assertNotEquals(challengeQuestionImpl, challengeQuestionImpl2);
  }

  /**
   * Test {@link ChallengeQuestionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChallengeQuestionImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ChallengeQuestionImpl challengeQuestionImpl = new ChallengeQuestionImpl();
    challengeQuestionImpl.setId(null);
    challengeQuestionImpl.setQuestion("42");

    ChallengeQuestionImpl challengeQuestionImpl2 = new ChallengeQuestionImpl();
    challengeQuestionImpl2.setId(1L);
    challengeQuestionImpl2.setQuestion("Question");

    // Act and Assert
    assertNotEquals(challengeQuestionImpl, challengeQuestionImpl2);
  }

  /**
   * Test {@link ChallengeQuestionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChallengeQuestionImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ChallengeQuestionImpl challengeQuestionImpl = new ChallengeQuestionImpl();
    challengeQuestionImpl.setId(1L);
    challengeQuestionImpl.setQuestion("Question");

    // Act and Assert
    assertNotEquals(challengeQuestionImpl, null);
  }

  /**
   * Test {@link ChallengeQuestionImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChallengeQuestionImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ChallengeQuestionImpl challengeQuestionImpl = new ChallengeQuestionImpl();
    challengeQuestionImpl.setId(1L);
    challengeQuestionImpl.setQuestion("Question");

    // Act and Assert
    assertNotEquals(challengeQuestionImpl, "Different type to ChallengeQuestionImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ChallengeQuestionImpl}
   *   <li>{@link ChallengeQuestionImpl#setId(Long)}
   *   <li>{@link ChallengeQuestionImpl#setQuestion(String)}
   *   <li>{@link ChallengeQuestionImpl#getId()}
   *   <li>{@link ChallengeQuestionImpl#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ChallengeQuestionImpl actualChallengeQuestionImpl = new ChallengeQuestionImpl();
    actualChallengeQuestionImpl.setId(1L);
    actualChallengeQuestionImpl.setQuestion("Question");
    Long actualId = actualChallengeQuestionImpl.getId();

    // Assert that nothing has changed
    assertEquals("Question", actualChallengeQuestionImpl.toString());
    assertEquals(1L, actualId.longValue());
  }
}
