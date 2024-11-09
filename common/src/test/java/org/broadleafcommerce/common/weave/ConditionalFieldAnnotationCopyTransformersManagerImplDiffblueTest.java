/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.StringValueResolver;

public class ConditionalFieldAnnotationCopyTransformersManagerImplDiffblueTest {
  /**
   * Test
   * {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#isEntityEnabled(String)}.
   * <p>
   * Method under test:
   * {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#isEntityEnabled(String)}
   */
  @Test
  public void testIsEntityEnabled() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    beanFactory.addEmbeddedValueResolver(mock(StringValueResolver.class));

    ConditionalFieldAnnotationCopyTransformersManagerImpl conditionalFieldAnnotationCopyTransformersManagerImpl = new ConditionalFieldAnnotationCopyTransformersManagerImpl();
    conditionalFieldAnnotationCopyTransformersManagerImpl.setBeanFactory(beanFactory);

    // Act and Assert
    assertFalse(conditionalFieldAnnotationCopyTransformersManagerImpl.isEntityEnabled("Entity Name"));
  }

  /**
   * Test
   * {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#isEntityEnabled(String)}.
   * <ul>
   *   <li>Given {@link ConditionalFieldAnnotationCopyTransformersManagerImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#isEntityEnabled(String)}
   */
  @Test
  public void testIsEntityEnabled_givenConditionalFieldAnnotationCopyTransformersManagerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ConditionalFieldAnnotationCopyTransformersManagerImpl()).isEntityEnabled("Entity Name"));
  }

  /**
   * Test
   * {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#getTransformMember(String)}.
   * <p>
   * Method under test:
   * {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#getTransformMember(String)}
   */
  @Test
  public void testGetTransformMember() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ConditionalFieldAnnotationCopyTransformersManagerImpl()).getTransformMember("Entity Name"));
  }

  /**
   * Test
   * {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#getTransformMember(String)}.
   * <p>
   * Method under test:
   * {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#getTransformMember(String)}
   */
  @Test
  public void testGetTransformMember2() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    beanFactory.addEmbeddedValueResolver(mock(StringValueResolver.class));

    ConditionalFieldAnnotationCopyTransformersManagerImpl conditionalFieldAnnotationCopyTransformersManagerImpl = new ConditionalFieldAnnotationCopyTransformersManagerImpl();
    conditionalFieldAnnotationCopyTransformersManagerImpl.setBeanFactory(beanFactory);

    // Act and Assert
    assertNull(conditionalFieldAnnotationCopyTransformersManagerImpl.getTransformMember("Entity Name"));
  }

  /**
   * Test
   * {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#isPropertyEnabled(String)}.
   * <p>
   * Method under test:
   * {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#isPropertyEnabled(String)}
   */
  @Test
  public void testIsPropertyEnabled() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConditionalFieldAnnotationCopyTransformersManagerImpl conditionalFieldAnnotationCopyTransformersManagerImpl = new ConditionalFieldAnnotationCopyTransformersManagerImpl();
    conditionalFieldAnnotationCopyTransformersManagerImpl.setBeanFactory(new DefaultListableBeanFactory());

    // Act and Assert
    assertFalse(conditionalFieldAnnotationCopyTransformersManagerImpl.isPropertyEnabled("Property Name"));
  }

  /**
   * Test
   * {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#isPropertyEnabled(String)}.
   * <ul>
   *   <li>Given {@link ConditionalFieldAnnotationCopyTransformersManagerImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#isPropertyEnabled(String)}
   */
  @Test
  public void testIsPropertyEnabled_givenConditionalFieldAnnotationCopyTransformersManagerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ConditionalFieldAnnotationCopyTransformersManagerImpl()).isPropertyEnabled("Property Name"));
  }

  /**
   * Test
   * {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#isPropertyEnabled(String)}.
   * <ul>
   *   <li>Then calls {@link StringValueResolver#resolveStringValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConditionalFieldAnnotationCopyTransformersManagerImpl#isPropertyEnabled(String)}
   */
  @Test
  public void testIsPropertyEnabled_thenCallsResolveStringValue() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringValueResolver valueResolver = mock(StringValueResolver.class);
    when(valueResolver.resolveStringValue(Mockito.<String>any())).thenReturn("42");

    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    beanFactory.addEmbeddedValueResolver(valueResolver);

    ConditionalFieldAnnotationCopyTransformersManagerImpl conditionalFieldAnnotationCopyTransformersManagerImpl = new ConditionalFieldAnnotationCopyTransformersManagerImpl();
    conditionalFieldAnnotationCopyTransformersManagerImpl.setBeanFactory(beanFactory);

    // Act
    Boolean actualIsPropertyEnabledResult = conditionalFieldAnnotationCopyTransformersManagerImpl
        .isPropertyEnabled("Property Name");

    // Assert
    verify(valueResolver).resolveStringValue(eq("${Property Name:false}"));
    assertFalse(actualIsPropertyEnabledResult);
  }
}
