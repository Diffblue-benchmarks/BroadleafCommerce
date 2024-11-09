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

public class ConditionalDirectCopyTransformersManagerImplDiffblueTest {
  /**
   * Test
   * {@link ConditionalDirectCopyTransformersManagerImpl#isEntityEnabled(String)}.
   * <p>
   * Method under test:
   * {@link ConditionalDirectCopyTransformersManagerImpl#isEntityEnabled(String)}
   */
  @Test
  public void testIsEntityEnabled() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    beanFactory.addEmbeddedValueResolver(mock(StringValueResolver.class));

    ConditionalDirectCopyTransformersManagerImpl conditionalDirectCopyTransformersManagerImpl = new ConditionalDirectCopyTransformersManagerImpl();
    conditionalDirectCopyTransformersManagerImpl.setBeanFactory(beanFactory);

    // Act and Assert
    assertFalse(conditionalDirectCopyTransformersManagerImpl.isEntityEnabled("Entity Name"));
  }

  /**
   * Test
   * {@link ConditionalDirectCopyTransformersManagerImpl#isEntityEnabled(String)}.
   * <ul>
   *   <li>Given {@link ConditionalDirectCopyTransformersManagerImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConditionalDirectCopyTransformersManagerImpl#isEntityEnabled(String)}
   */
  @Test
  public void testIsEntityEnabled_givenConditionalDirectCopyTransformersManagerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ConditionalDirectCopyTransformersManagerImpl()).isEntityEnabled("Entity Name"));
  }

  /**
   * Test
   * {@link ConditionalDirectCopyTransformersManagerImpl#getTransformMember(String)}.
   * <p>
   * Method under test:
   * {@link ConditionalDirectCopyTransformersManagerImpl#getTransformMember(String)}
   */
  @Test
  public void testGetTransformMember() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    beanFactory.addEmbeddedValueResolver(mock(StringValueResolver.class));

    ConditionalDirectCopyTransformersManagerImpl conditionalDirectCopyTransformersManagerImpl = new ConditionalDirectCopyTransformersManagerImpl();
    conditionalDirectCopyTransformersManagerImpl.setBeanFactory(beanFactory);

    // Act and Assert
    assertNull(conditionalDirectCopyTransformersManagerImpl.getTransformMember("Entity Name"));
  }

  /**
   * Test
   * {@link ConditionalDirectCopyTransformersManagerImpl#getTransformMember(String)}.
   * <ul>
   *   <li>Given {@link ConditionalDirectCopyTransformersManagerImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConditionalDirectCopyTransformersManagerImpl#getTransformMember(String)}
   */
  @Test
  public void testGetTransformMember_givenConditionalDirectCopyTransformersManagerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ConditionalDirectCopyTransformersManagerImpl()).getTransformMember("Entity Name"));
  }

  /**
   * Test
   * {@link ConditionalDirectCopyTransformersManagerImpl#isPropertyEnabled(String)}.
   * <p>
   * Method under test:
   * {@link ConditionalDirectCopyTransformersManagerImpl#isPropertyEnabled(String)}
   */
  @Test
  public void testIsPropertyEnabled() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ConditionalDirectCopyTransformersManagerImpl conditionalDirectCopyTransformersManagerImpl = new ConditionalDirectCopyTransformersManagerImpl();
    conditionalDirectCopyTransformersManagerImpl.setBeanFactory(new DefaultListableBeanFactory());

    // Act and Assert
    assertFalse(conditionalDirectCopyTransformersManagerImpl.isPropertyEnabled("Property Name"));
  }

  /**
   * Test
   * {@link ConditionalDirectCopyTransformersManagerImpl#isPropertyEnabled(String)}.
   * <ul>
   *   <li>Given {@link ConditionalDirectCopyTransformersManagerImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConditionalDirectCopyTransformersManagerImpl#isPropertyEnabled(String)}
   */
  @Test
  public void testIsPropertyEnabled_givenConditionalDirectCopyTransformersManagerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ConditionalDirectCopyTransformersManagerImpl()).isPropertyEnabled("Property Name"));
  }

  /**
   * Test
   * {@link ConditionalDirectCopyTransformersManagerImpl#isPropertyEnabled(String)}.
   * <ul>
   *   <li>Then calls {@link StringValueResolver#resolveStringValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConditionalDirectCopyTransformersManagerImpl#isPropertyEnabled(String)}
   */
  @Test
  public void testIsPropertyEnabled_thenCallsResolveStringValue() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringValueResolver valueResolver = mock(StringValueResolver.class);
    when(valueResolver.resolveStringValue(Mockito.<String>any())).thenReturn("42");

    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    beanFactory.addEmbeddedValueResolver(valueResolver);

    ConditionalDirectCopyTransformersManagerImpl conditionalDirectCopyTransformersManagerImpl = new ConditionalDirectCopyTransformersManagerImpl();
    conditionalDirectCopyTransformersManagerImpl.setBeanFactory(beanFactory);

    // Act
    Boolean actualIsPropertyEnabledResult = conditionalDirectCopyTransformersManagerImpl
        .isPropertyEnabled("Property Name");

    // Assert
    verify(valueResolver).resolveStringValue(eq("${Property Name:false}"));
    assertFalse(actualIsPropertyEnabledResult);
  }
}
