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
package org.broadleafcommerce.common.jmx;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.jmx.export.metadata.InvalidMetadataException;
import org.springframework.util.StringValueResolver;

public class AnnotationJmxAttributeSourceDiffblueTest {
  /**
   * Test {@link AnnotationJmxAttributeSource#getManagedResource(Class)}.
   * <p>
   * Method under test:
   * {@link AnnotationJmxAttributeSource#getManagedResource(Class)}
   */
  @Test
  public void testGetManagedResource() throws InvalidMetadataException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    beanFactory.addEmbeddedValueResolver(mock(StringValueResolver.class));

    AnnotationJmxAttributeSource annotationJmxAttributeSource = new AnnotationJmxAttributeSource("App Name");
    annotationJmxAttributeSource.setBeanFactory(beanFactory);
    Class<Object> beanClass = Object.class;

    // Act and Assert
    assertNull(annotationJmxAttributeSource.getManagedResource((Class) beanClass));
  }

  /**
   * Test {@link AnnotationJmxAttributeSource#getManagedResource(Class)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AnnotationJmxAttributeSource#getManagedResource(Class)}
   */
  @Test
  public void testGetManagedResource_thenReturnNull() throws InvalidMetadataException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationJmxAttributeSource annotationJmxAttributeSource = new AnnotationJmxAttributeSource("App Name");
    Class<Object> beanClass = Object.class;

    // Act and Assert
    assertNull(annotationJmxAttributeSource.getManagedResource((Class) beanClass));
  }
}
