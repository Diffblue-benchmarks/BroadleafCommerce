package org.broadleafcommerce.common.config;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class BroadleafBeanNameGeneratorDiffblueTest {
  /**
   * Test {@link BroadleafBeanNameGenerator#generateBeanName(BeanDefinition,
   * BeanDefinitionRegistry)}.
   *
   * <ul>
   *   <li>Given {@link BroadleafBeanNameGenerator#BROADLEAF_BEAN_PREFIX}.
   *   <li>Then return {@link BroadleafBeanNameGenerator#BROADLEAF_BEAN_PREFIX}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafBeanNameGenerator#generateBeanName(BeanDefinition,
   * BeanDefinitionRegistry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String BroadleafBeanNameGenerator.generateBeanName(BeanDefinition, BeanDefinitionRegistry)"
  })
  public void testGenerateBeanName_givenBroadleaf_bean_prefix_thenReturnBroadleaf_bean_prefix() {
    // Arrange
    BroadleafBeanNameGenerator broadleafBeanNameGenerator = new BroadleafBeanNameGenerator();
    Class<Object> beanClass = Object.class;

    AnnotatedGenericBeanDefinition definition = new AnnotatedGenericBeanDefinition(beanClass);
    definition.setBeanClassName(BroadleafBeanNameGenerator.BROADLEAF_BEAN_PREFIX);

    // Act and Assert
    assertEquals(
        BroadleafBeanNameGenerator.BROADLEAF_BEAN_PREFIX,
        broadleafBeanNameGenerator.generateBeanName(definition, new DefaultListableBeanFactory()));
  }

  /**
   * Test {@link BroadleafBeanNameGenerator#generateBeanName(BeanDefinition,
   * BeanDefinitionRegistry)}.
   *
   * <ul>
   *   <li>Then return {@code blObject}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafBeanNameGenerator#generateBeanName(BeanDefinition,
   * BeanDefinitionRegistry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String BroadleafBeanNameGenerator.generateBeanName(BeanDefinition, BeanDefinitionRegistry)"
  })
  public void testGenerateBeanName_thenReturnBlObject() {
    // Arrange
    BroadleafBeanNameGenerator broadleafBeanNameGenerator = new BroadleafBeanNameGenerator();
    Class<Object> beanClass = Object.class;
    AnnotatedGenericBeanDefinition definition = new AnnotatedGenericBeanDefinition(beanClass);

    // Act and Assert
    assertEquals(
        "blObject",
        broadleafBeanNameGenerator.generateBeanName(definition, new DefaultListableBeanFactory()));
  }
}
