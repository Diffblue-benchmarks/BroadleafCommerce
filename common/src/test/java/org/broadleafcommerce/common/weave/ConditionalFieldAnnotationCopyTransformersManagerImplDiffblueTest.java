package org.broadleafcommerce.common.weave;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
   * Test {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#isEntityEnabled(String)}.
   *
   * <ul>
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
  public void testIsEntityEnabled_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ConditionalFieldAnnotationCopyTransformersManagerImpl().isEntityEnabled("Entity Name"));
  }

  /**
   * Test {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#getTransformMember(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
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
  public void testGetTransformMember_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new ConditionalFieldAnnotationCopyTransformersManagerImpl()
            .getTransformMember("Entity Name"));
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
   *   <li>Given {@link ConditionalFieldAnnotationCopyTransformersManagerImpl} (default
   *       constructor).
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
        new ConditionalFieldAnnotationCopyTransformersManagerImpl()
            .isPropertyEnabled("Property Name"));
  }
}
