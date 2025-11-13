package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yahoo.platform.yui.compressor.JarClassLoader;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.ConcurrencyThrottleInterceptor;
import org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources;
import org.springframework.boot.autoconfigure.web.servlet.error.DefaultErrorViewResolver;
import org.springframework.context.ApplicationContext;

@RunWith(MockitoJUnitRunner.class)
public class SortedListFactoryBeanDiffblueTest {
  @Mock private List<Object> list;

  @InjectMocks private SortedListFactoryBean sortedListFactoryBean;

  /**
   * Test {@link SortedListFactoryBean#createInstance()}.
   *
   * <ul>
   *   <li>Given {@link SortedListFactoryBean} (default constructor).
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SortedListFactoryBean#createInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SortedListFactoryBean.createInstance()"})
  public void testCreateInstance_givenSortedListFactoryBean_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new SortedListFactoryBean().createInstance());
  }

  /**
   * Test {@link SortedListFactoryBean#createInstance()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SortedListFactoryBean#createInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SortedListFactoryBean.createInstance()"})
  public void testCreateInstance_thenReturnEmpty() {
    // Arrange
    SortedListFactoryBean sortedListFactoryBean = new SortedListFactoryBean();
    sortedListFactoryBean.setSourceList(new ArrayList<>());

    // Act and Assert
    assertTrue(sortedListFactoryBean.createInstance().isEmpty());
  }

  /**
   * Test {@link SortedListFactoryBean#createInstance()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link SortedListFactoryBean#createInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SortedListFactoryBean.createInstance()"})
  public void testCreateInstance_thenReturnSizeIsTwo() {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getClassLoader()).thenReturn(new JarClassLoader());
    DefaultErrorViewResolver defaultErrorViewResolver =
        new DefaultErrorViewResolver(applicationContext, new Resources());

    DefaultBeanFactoryPointcutAdvisor defaultBeanFactoryPointcutAdvisor =
        new DefaultBeanFactoryPointcutAdvisor();
    defaultBeanFactoryPointcutAdvisor.setAdvice(new ConcurrencyThrottleInterceptor());
    defaultBeanFactoryPointcutAdvisor.setAdviceBeanName("Advice Bean Name");
    defaultBeanFactoryPointcutAdvisor.setBeanFactory(new DefaultListableBeanFactory());
    defaultBeanFactoryPointcutAdvisor.setOrder(1);
    defaultBeanFactoryPointcutAdvisor.setPointcut(new AspectJExpressionPointcut());
    when(list.size()).thenReturn(3);
    when(list.toArray())
        .thenReturn(new Object[] {defaultErrorViewResolver, defaultBeanFactoryPointcutAdvisor});

    // Act
    List actualCreateInstanceResult = sortedListFactoryBean.createInstance();

    // Assert
    verify(list).size();
    verify(list).toArray();
    verify(applicationContext).getClassLoader();
    assertEquals(2, actualCreateInstanceResult.size());
    Object getResult = actualCreateInstanceResult.get(1);
    assertTrue(getResult instanceof DefaultErrorViewResolver);
    assertEquals(Integer.MAX_VALUE, ((DefaultErrorViewResolver) getResult).getOrder());
    assertSame(defaultBeanFactoryPointcutAdvisor, actualCreateInstanceResult.get(0));
    assertSame(defaultErrorViewResolver, getResult);
  }

  /**
   * Test new {@link SortedListFactoryBean} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SortedListFactoryBean}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SortedListFactoryBean.<init>()"})
  public void testNewSortedListFactoryBean() {
    // Arrange and Act
    SortedListFactoryBean actualSortedListFactoryBean = new SortedListFactoryBean();

    // Assert
    assertTrue(actualSortedListFactoryBean.isSingleton());
    Class<List> expectedObjectType = List.class;
    assertEquals(expectedObjectType, actualSortedListFactoryBean.getObjectType());
  }
}
