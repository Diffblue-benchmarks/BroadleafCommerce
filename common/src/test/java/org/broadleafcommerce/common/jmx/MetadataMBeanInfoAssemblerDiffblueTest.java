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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.management.JMException;
import javax.management.modelmbean.ModelMBeanNotificationInfo;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.jmx.export.metadata.InvalidMetadataException;
import org.springframework.jmx.export.metadata.ManagedNotification;

public class MetadataMBeanInfoAssemblerDiffblueTest {
  /**
   * Test {@link MetadataMBeanInfoAssembler#getNotificationInfo(Object, String)}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MetadataMBeanInfoAssembler#getNotificationInfo(Object, String)}
   */
  @Test
  public void testGetNotificationInfo_thenReturnArrayLengthIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MetadataMBeanInfoAssembler metadataMBeanInfoAssembler = new MetadataMBeanInfoAssembler();
    metadataMBeanInfoAssembler.setAttributeSource(new AnnotationJmxAttributeSource("App Name"));

    // Act and Assert
    assertEquals(0, metadataMBeanInfoAssembler.getNotificationInfo(new AspectJProxyFactory(), "Bean Key").length);
  }

  /**
   * Test {@link MetadataMBeanInfoAssembler#getNotificationInfo(Object, String)}.
   * <ul>
   *   <li>Then return first element Name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MetadataMBeanInfoAssembler#getNotificationInfo(Object, String)}
   */
  @Test
  public void testGetNotificationInfo_thenReturnFirstElementNameIsName() throws InvalidMetadataException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ManagedNotification managedNotification = new ManagedNotification();
    managedNotification.setDescription("The characteristics of someone or something");
    managedNotification.setName("Name");
    managedNotification.setNotificationType("Notification Type");
    managedNotification.setNotificationTypes("Notification Types");
    AnnotationJmxAttributeSource attributeSource = mock(AnnotationJmxAttributeSource.class);
    when(attributeSource.getManagedNotifications(Mockito.<Class<Object>>any()))
        .thenReturn(new ManagedNotification[]{managedNotification});

    MetadataMBeanInfoAssembler metadataMBeanInfoAssembler = new MetadataMBeanInfoAssembler();
    metadataMBeanInfoAssembler.setAttributeSource(attributeSource);

    // Act
    ModelMBeanNotificationInfo[] actualNotificationInfo = metadataMBeanInfoAssembler
        .getNotificationInfo(new AspectJProxyFactory(), "Bean Key");

    // Assert
    verify(attributeSource).getManagedNotifications(isA(Class.class));
    ModelMBeanNotificationInfo modelMBeanNotificationInfo = actualNotificationInfo[0];
    assertEquals("Name", modelMBeanNotificationInfo.getName());
    assertEquals("The characteristics of someone or something", modelMBeanNotificationInfo.getDescription());
    assertEquals(1, actualNotificationInfo.length);
    assertArrayEquals(new String[]{"Notification Types"}, modelMBeanNotificationInfo.getNotifTypes());
  }

  /**
   * Test {@link MetadataMBeanInfoAssembler#getAttributeInfo(Object, String)}.
   * <p>
   * Method under test:
   * {@link MetadataMBeanInfoAssembler#getAttributeInfo(Object, String)}
   */
  @Test
  public void testGetAttributeInfo() throws JMException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MetadataMBeanInfoAssembler metadataMBeanInfoAssembler = new MetadataMBeanInfoAssembler();
    metadataMBeanInfoAssembler.setAttributeSource(mock(AnnotationJmxAttributeSource.class));

    // Act and Assert
    assertEquals(0, metadataMBeanInfoAssembler.getAttributeInfo(BLCFieldUtils.NULL_FIELD, "Bean Key").length);
  }

  /**
   * Test {@link MetadataMBeanInfoAssembler#getAttributeInfo(Object, String)}.
   * <ul>
   *   <li>Given {@link MetadataMBeanInfoAssembler} (default constructor).</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MetadataMBeanInfoAssembler#getAttributeInfo(Object, String)}
   */
  @Test
  public void testGetAttributeInfo_givenMetadataMBeanInfoAssembler_thenReturnArrayLengthIsZero() throws JMException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new MetadataMBeanInfoAssembler()).getAttributeInfo(BLCFieldUtils.NULL_FIELD, "Bean Key").length);
  }

  /**
   * Test {@link MetadataMBeanInfoAssembler#getOperationInfo(Object, String)}.
   * <p>
   * Method under test:
   * {@link MetadataMBeanInfoAssembler#getOperationInfo(Object, String)}
   */
  @Test
  public void testGetOperationInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MetadataMBeanInfoAssembler metadataMBeanInfoAssembler = new MetadataMBeanInfoAssembler();
    metadataMBeanInfoAssembler.setAttributeSource(mock(AnnotationJmxAttributeSource.class));

    // Act and Assert
    assertEquals(0, metadataMBeanInfoAssembler.getOperationInfo(BLCFieldUtils.NULL_FIELD, "Bean Key").length);
  }

  /**
   * Test {@link MetadataMBeanInfoAssembler#getOperationInfo(Object, String)}.
   * <ul>
   *   <li>Given {@link MetadataMBeanInfoAssembler} (default constructor).</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MetadataMBeanInfoAssembler#getOperationInfo(Object, String)}
   */
  @Test
  public void testGetOperationInfo_givenMetadataMBeanInfoAssembler_thenReturnArrayLengthIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new MetadataMBeanInfoAssembler()).getOperationInfo(BLCFieldUtils.NULL_FIELD, "Bean Key").length);
  }
}
