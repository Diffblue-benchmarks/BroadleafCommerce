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
public class ConditionalDirectCopyTransformersManagerImplDiffblueTest {
  @InjectMocks
  private ConditionalDirectCopyTransformersManagerImpl conditionalDirectCopyTransformersManagerImpl;

  @Mock private Map<String, ConditionalDirectCopyTransformMemberDto> map;

  /**
   * Test {@link ConditionalDirectCopyTransformersManagerImpl#isEntityEnabled(String)}.
   *
   * <ul>
   *   <li>Given {@link Map} {@link Map#containsKey(Object)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConditionalDirectCopyTransformersManagerImpl#isEntityEnabled(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ConditionalDirectCopyTransformersManagerImpl.isEntityEnabled(String)"
  })
  public void testIsEntityEnabled_givenMapContainsKeyReturnTrue_thenReturnTrue() {
    // Arrange
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);

    // Act
    Boolean actualIsEntityEnabledResult =
        conditionalDirectCopyTransformersManagerImpl.isEntityEnabled("Entity Name");

    // Assert
    verify(map).containsKey(isA(Object.class));
    assertTrue(actualIsEntityEnabledResult);
  }

  /**
   * Test {@link ConditionalDirectCopyTransformersManagerImpl#isEntityEnabled(String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConditionalDirectCopyTransformersManagerImpl#isEntityEnabled(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ConditionalDirectCopyTransformersManagerImpl.isEntityEnabled(String)"
  })
  public void testIsEntityEnabled_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ConditionalDirectCopyTransformersManagerImpl().isEntityEnabled("Entity Name"));
  }

  /**
   * Test {@link ConditionalDirectCopyTransformersManagerImpl#getTransformMember(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConditionalDirectCopyTransformersManagerImpl#getTransformMember(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ConditionalDirectCopyTransformMemberDto ConditionalDirectCopyTransformersManagerImpl.getTransformMember(String)"
  })
  public void testGetTransformMember_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new ConditionalDirectCopyTransformersManagerImpl().getTransformMember("Entity Name"));
  }

  /**
   * Test {@link ConditionalDirectCopyTransformersManagerImpl#isPropertyEnabled(String)}.
   *
   * <p>Method under test: {@link
   * ConditionalDirectCopyTransformersManagerImpl#isPropertyEnabled(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ConditionalDirectCopyTransformersManagerImpl.isPropertyEnabled(String)"
  })
  public void testIsPropertyEnabled() throws BeansException {
    // Arrange
    ConditionalDirectCopyTransformersManagerImpl conditionalDirectCopyTransformersManagerImpl =
        new ConditionalDirectCopyTransformersManagerImpl();
    conditionalDirectCopyTransformersManagerImpl.setBeanFactory(new DefaultListableBeanFactory());

    // Act and Assert
    assertFalse(conditionalDirectCopyTransformersManagerImpl.isPropertyEnabled("Property Name"));
  }

  /**
   * Test {@link ConditionalDirectCopyTransformersManagerImpl#isPropertyEnabled(String)}.
   *
   * <ul>
   *   <li>Given {@link ConditionalDirectCopyTransformersManagerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * ConditionalDirectCopyTransformersManagerImpl#isPropertyEnabled(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ConditionalDirectCopyTransformersManagerImpl.isPropertyEnabled(String)"
  })
  public void testIsPropertyEnabled_givenConditionalDirectCopyTransformersManagerImpl() {
    // Arrange, Act and Assert
    assertFalse(
        new ConditionalDirectCopyTransformersManagerImpl().isPropertyEnabled("Property Name"));
  }
}
