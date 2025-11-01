/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
package org.broadleafcommerce.common.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.Hashtable;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.mockito.Mockito;

public class StatisticsServiceImplDiffblueTest {
  /**
   * Method under test: {@link StatisticsServiceImpl#activateLogging()}
   */
  @Test
  public void testActivateLogging() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Log4j2StatisticsServiceLogAdapter adapter = mock(Log4j2StatisticsServiceLogAdapter.class);
    doNothing().when(adapter).activateLogging(Mockito.<Class<Object>>any());

    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(adapter);

    // Act
    statisticsServiceImpl.activateLogging();

    // Assert
    verify(adapter).activateLogging(isA(Class.class));
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#activateLogging()}
   */
  @Test
  public void testActivateLogging2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Log4j2StatisticsServiceLogAdapter adapter = mock(Log4j2StatisticsServiceLogAdapter.class);
    doThrow(new RuntimeException("foo")).when(adapter).activateLogging(Mockito.<Class<Object>>any());

    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(adapter);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> statisticsServiceImpl.activateLogging());
    verify(adapter).activateLogging(isA(Class.class));
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#disableLogging()}
   */
  @Test
  public void testDisableLogging() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Log4j2StatisticsServiceLogAdapter adapter = mock(Log4j2StatisticsServiceLogAdapter.class);
    doNothing().when(adapter).disableLogging(Mockito.<Class<Object>>any());

    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(adapter);

    // Act
    statisticsServiceImpl.disableLogging();

    // Assert
    verify(adapter).disableLogging(isA(Class.class));
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#disableLogging()}
   */
  @Test
  public void testDisableLogging2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Log4j2StatisticsServiceLogAdapter adapter = mock(Log4j2StatisticsServiceLogAdapter.class);
    doThrow(new RuntimeException("foo")).when(adapter).disableLogging(Mockito.<Class<Object>>any());

    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(adapter);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> statisticsServiceImpl.disableLogging());
    verify(adapter).disableLogging(isA(Class.class));
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#getAttribute(String)}
   */
  @Test
  public void testGetAttribute() throws AttributeNotFoundException, MBeanException, ReflectionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();

    // Act
    statisticsServiceImpl.getAttribute("LOG_RESOLUTION");

    // Assert
    MBeanAttributeInfo[] attributes = statisticsServiceImpl.getMBeanInfo().getAttributes();
    MBeanAttributeInfo mBeanAttributeInfo = attributes[0];
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo.getDescription());
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo.getName());
    assertEquals(1, attributes.length);
    assertTrue(statisticsServiceImpl.cacheStats.isEmpty());
    assertTrue(mBeanAttributeInfo.isWritable());
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#setAttribute(Attribute)}
   */
  @Test
  public void testSetAttribute()
      throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();

    // Act
    statisticsServiceImpl.setAttribute(new Attribute("foo", BLCFieldUtils.NULL_FIELD));

    // Assert that nothing has changed
    assertEquals(30000L, statisticsServiceImpl.getLogResolution().longValue());
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#setAttribute(Attribute)}
   */
  @Test
  public void testSetAttribute2()
      throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();

    // Act
    statisticsServiceImpl.setAttribute(new Attribute("LOG_RESOLUTION", 1L));

    // Assert
    assertEquals(1L, statisticsServiceImpl.getLogResolution().longValue());
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#getAttributes(String[])}
   */
  @Test
  public void testGetAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new StatisticsServiceImpl()).getAttributes(new String[]{"Attributes"}).isEmpty());
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#getAttributes(String[])}
   */
  @Test
  public void testGetAttributes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.addCacheStat("Key", true);

    // Act
    AttributeList actualAttributes = statisticsServiceImpl.getAttributes(new String[]{"Attributes"});

    // Assert
    assertEquals(1, actualAttributes.size());
    Object getResult = actualAttributes.get(0);
    assertEquals("Key", ((Attribute) getResult).getName());
    assertEquals(100.0d, ((Double) ((Attribute) getResult).getValue()).doubleValue(), 0.0);
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#getAttributes(String[])}
   */
  @Test
  public void testGetAttributes3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(mock(Log4j2StatisticsServiceLogAdapter.class));
    statisticsServiceImpl.addCacheStat("Key", true);

    // Act
    AttributeList actualAttributes = statisticsServiceImpl.getAttributes(new String[]{"Attributes"});

    // Assert
    assertEquals(1, actualAttributes.size());
    Object getResult = actualAttributes.get(0);
    assertEquals("Key", ((Attribute) getResult).getName());
    assertEquals(100.0d, ((Double) ((Attribute) getResult).getValue()).doubleValue(), 0.0);
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#setAttributes(AttributeList)}
   */
  @Test
  public void testSetAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    AttributeList attributes = new AttributeList();

    // Act
    AttributeList actualSetAttributesResult = statisticsServiceImpl.setAttributes(attributes);

    // Assert
    assertTrue(actualSetAttributesResult.isEmpty());
    assertSame(attributes, actualSetAttributesResult);
  }

  /**
   * Method under test:
   * {@link StatisticsServiceImpl#invoke(String, Object[], String[])}
   */
  @Test
  public void testInvoke() throws MBeanException, ReflectionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(MBeanException.class, () -> (new StatisticsServiceImpl()).invoke("Action Name",
        new Object[]{BLCFieldUtils.NULL_FIELD}, new String[]{"Signature"}));
  }

  /**
   * Method under test:
   * {@link StatisticsServiceImpl#invoke(String, Object[], String[])}
   */
  @Test
  public void testInvoke2() throws MBeanException, ReflectionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(null);

    // Act and Assert
    assertNull(
        statisticsServiceImpl.invoke("activate", new Object[]{BLCFieldUtils.NULL_FIELD}, new String[]{"Signature"}));
  }

  /**
   * Method under test:
   * {@link StatisticsServiceImpl#invoke(String, Object[], String[])}
   */
  @Test
  public void testInvoke3() throws MBeanException, ReflectionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(null);

    // Act and Assert
    assertNull(
        statisticsServiceImpl.invoke("disable", new Object[]{BLCFieldUtils.NULL_FIELD}, new String[]{"Signature"}));
  }

  /**
   * Method under test:
   * {@link StatisticsServiceImpl#invoke(String, Object[], String[])}
   */
  @Test
  public void testInvoke4() throws MBeanException, ReflectionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(new Log4j2StatisticsServiceLogAdapter());

    // Act and Assert
    assertNull(
        statisticsServiceImpl.invoke("activate", new Object[]{BLCFieldUtils.NULL_FIELD}, new String[]{"Signature"}));
  }

  /**
   * Method under test:
   * {@link StatisticsServiceImpl#invoke(String, Object[], String[])}
   */
  @Test
  public void testInvoke5() throws MBeanException, ReflectionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(new Log4j2StatisticsServiceLogAdapter());

    // Act and Assert
    assertNull(
        statisticsServiceImpl.invoke("disable", new Object[]{BLCFieldUtils.NULL_FIELD}, new String[]{"Signature"}));
  }

  /**
   * Method under test:
   * {@link StatisticsServiceImpl#invoke(String, Object[], String[])}
   */
  @Test
  public void testInvoke6() throws MBeanException, ReflectionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Log4j2StatisticsServiceLogAdapter adapter = mock(Log4j2StatisticsServiceLogAdapter.class);
    doNothing().when(adapter).activateLogging(Mockito.<Class<Object>>any());

    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(adapter);

    // Act
    Object actualInvokeResult = statisticsServiceImpl.invoke("activate", new Object[]{BLCFieldUtils.NULL_FIELD},
        new String[]{"Signature"});

    // Assert
    verify(adapter).activateLogging(isA(Class.class));
    assertNull(actualInvokeResult);
  }

  /**
   * Method under test:
   * {@link StatisticsServiceImpl#invoke(String, Object[], String[])}
   */
  @Test
  public void testInvoke7() throws MBeanException, ReflectionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Log4j2StatisticsServiceLogAdapter adapter = mock(Log4j2StatisticsServiceLogAdapter.class);
    doThrow(new RuntimeException("foo")).when(adapter).disableLogging(Mockito.<Class<Object>>any());

    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(adapter);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> statisticsServiceImpl.invoke("disable",
        new Object[]{BLCFieldUtils.NULL_FIELD}, new String[]{"Signature"}));
    verify(adapter).disableLogging(isA(Class.class));
  }

  /**
   * Method under test:
   * {@link StatisticsServiceImpl#invoke(String, Object[], String[])}
   */
  @Test
  public void testInvoke8() throws MBeanException, ReflectionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NoOpStatisticsServiceLogAdapter adapter = mock(NoOpStatisticsServiceLogAdapter.class);
    doThrow(new RuntimeException("foo")).when(adapter).activateLogging(Mockito.<Class<Object>>any());

    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(adapter);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> statisticsServiceImpl.invoke("activate",
        new Object[]{BLCFieldUtils.NULL_FIELD}, new String[]{"Signature"}));
    verify(adapter).activateLogging(isA(Class.class));
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#getObjectName()}
   */
  @Test
  public void testGetObjectName() throws MalformedObjectNameException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ObjectName actualObjectName = (new StatisticsServiceImpl()).getObjectName();

    // Assert
    Hashtable<String, String> keyPropertyList = actualObjectName.getKeyPropertyList();
    assertEquals(1, keyPropertyList.size());
    assertEquals("StatisticsService.broadleaf", keyPropertyList.get("name"));
    assertEquals("name=StatisticsService.broadleaf", actualObjectName.getCanonicalKeyPropertyListString());
    assertEquals("name=StatisticsService.broadleaf", actualObjectName.getKeyPropertyListString());
    assertEquals("org.broadleafcommerce", actualObjectName.getDomain());
    assertEquals("org.broadleafcommerce:name=StatisticsService.broadleaf", actualObjectName.getCanonicalName());
    assertFalse(actualObjectName.isDomainPattern());
    assertFalse(actualObjectName.isPattern());
    assertFalse(actualObjectName.isPropertyListPattern());
    assertFalse(actualObjectName.isPropertyPattern());
    assertFalse(actualObjectName.isPropertyValuePattern());
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#getObjectName()}
   */
  @Test
  public void testGetObjectName2() throws MalformedObjectNameException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(mock(Log4j2StatisticsServiceLogAdapter.class));

    // Act
    ObjectName actualObjectName = statisticsServiceImpl.getObjectName();

    // Assert
    Hashtable<String, String> keyPropertyList = actualObjectName.getKeyPropertyList();
    assertEquals(1, keyPropertyList.size());
    assertEquals("StatisticsService.broadleaf", keyPropertyList.get("name"));
    assertEquals("name=StatisticsService.broadleaf", actualObjectName.getCanonicalKeyPropertyListString());
    assertEquals("name=StatisticsService.broadleaf", actualObjectName.getKeyPropertyListString());
    assertEquals("org.broadleafcommerce", actualObjectName.getDomain());
    assertEquals("org.broadleafcommerce:name=StatisticsService.broadleaf", actualObjectName.getCanonicalName());
    assertFalse(actualObjectName.isDomainPattern());
    assertFalse(actualObjectName.isPattern());
    assertFalse(actualObjectName.isPropertyListPattern());
    assertFalse(actualObjectName.isPropertyPattern());
    assertFalse(actualObjectName.isPropertyValuePattern());
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#getMBeanInfo()}
   */
  @Test
  public void testGetMBeanInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    MBeanInfo actualMBeanInfo = (new StatisticsServiceImpl()).getMBeanInfo();

    // Assert
    MBeanOperationInfo[] operations = actualMBeanInfo.getOperations();
    MBeanOperationInfo mBeanOperationInfo = operations[0];
    assertEquals("Activate statistic logging", mBeanOperationInfo.getDescription());
    MBeanOperationInfo mBeanOperationInfo2 = operations[1];
    assertEquals("Disable statistic logging", mBeanOperationInfo2.getDescription());
    MBeanAttributeInfo[] attributes = actualMBeanInfo.getAttributes();
    MBeanAttributeInfo mBeanAttributeInfo = attributes[0];
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo.getDescription());
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo.getName());
    assertEquals("Runtime Statistics", actualMBeanInfo.getDescription());
    assertEquals("activate", mBeanOperationInfo.getName());
    assertEquals("disable", mBeanOperationInfo2.getName());
    assertEquals("java.lang.Double", mBeanAttributeInfo.getType());
    assertEquals("org.broadleafcommerce:name=StatisticsService.broadleaf", actualMBeanInfo.getClassName());
    assertEquals("void", mBeanOperationInfo.getReturnType());
    assertEquals("void", mBeanOperationInfo2.getReturnType());
    assertEquals(0, actualMBeanInfo.getConstructors().length);
    assertEquals(0, actualMBeanInfo.getNotifications().length);
    MBeanParameterInfo[] signature = mBeanOperationInfo.getSignature();
    assertEquals(0, signature.length);
    assertEquals(1, mBeanOperationInfo.getImpact());
    assertEquals(1, mBeanOperationInfo2.getImpact());
    assertEquals(1, attributes.length);
    assertEquals(2, operations.length);
    assertFalse(mBeanAttributeInfo.isIs());
    assertTrue(mBeanAttributeInfo.isReadable());
    assertTrue(mBeanAttributeInfo.isWritable());
    assertSame(signature, mBeanOperationInfo2.getSignature());
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#getMBeanInfo()}
   */
  @Test
  public void testGetMBeanInfo2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.addCacheStat("LOG_RESOLUTION", true);

    // Act
    MBeanInfo actualMBeanInfo = statisticsServiceImpl.getMBeanInfo();

    // Assert
    MBeanOperationInfo[] operations = actualMBeanInfo.getOperations();
    MBeanOperationInfo mBeanOperationInfo = operations[0];
    assertEquals("Activate statistic logging", mBeanOperationInfo.getDescription());
    MBeanOperationInfo mBeanOperationInfo2 = operations[1];
    assertEquals("Disable statistic logging", mBeanOperationInfo2.getDescription());
    MBeanAttributeInfo[] attributes = actualMBeanInfo.getAttributes();
    MBeanAttributeInfo mBeanAttributeInfo = attributes[0];
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo.getDescription());
    MBeanAttributeInfo mBeanAttributeInfo2 = attributes[1];
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo2.getDescription());
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo.getName());
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo2.getName());
    assertEquals("Runtime Statistics", actualMBeanInfo.getDescription());
    assertEquals("activate", mBeanOperationInfo.getName());
    assertEquals("disable", mBeanOperationInfo2.getName());
    assertEquals("java.lang.Double", mBeanAttributeInfo.getType());
    assertEquals("java.lang.Double", mBeanAttributeInfo2.getType());
    assertEquals("org.broadleafcommerce:name=StatisticsService.broadleaf", actualMBeanInfo.getClassName());
    assertEquals("void", mBeanOperationInfo.getReturnType());
    assertEquals("void", mBeanOperationInfo2.getReturnType());
    assertEquals(0, actualMBeanInfo.getConstructors().length);
    assertEquals(0, actualMBeanInfo.getNotifications().length);
    MBeanParameterInfo[] signature = mBeanOperationInfo.getSignature();
    assertEquals(0, signature.length);
    assertEquals(1, mBeanOperationInfo.getImpact());
    assertEquals(1, mBeanOperationInfo2.getImpact());
    assertEquals(2, attributes.length);
    assertEquals(2, operations.length);
    assertFalse(mBeanAttributeInfo.isIs());
    assertFalse(mBeanAttributeInfo2.isIs());
    assertFalse(mBeanAttributeInfo.isWritable());
    assertTrue(mBeanAttributeInfo.isReadable());
    assertTrue(mBeanAttributeInfo2.isReadable());
    assertTrue(mBeanAttributeInfo2.isWritable());
    assertSame(signature, mBeanOperationInfo2.getSignature());
  }

  /**
   * Method under test: {@link StatisticsServiceImpl#getMBeanInfo()}
   */
  @Test
  public void testGetMBeanInfo3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(mock(Log4j2StatisticsServiceLogAdapter.class));
    statisticsServiceImpl.addCacheStat("LOG_RESOLUTION", true);

    // Act
    MBeanInfo actualMBeanInfo = statisticsServiceImpl.getMBeanInfo();

    // Assert
    MBeanOperationInfo[] operations = actualMBeanInfo.getOperations();
    MBeanOperationInfo mBeanOperationInfo = operations[0];
    assertEquals("Activate statistic logging", mBeanOperationInfo.getDescription());
    MBeanOperationInfo mBeanOperationInfo2 = operations[1];
    assertEquals("Disable statistic logging", mBeanOperationInfo2.getDescription());
    MBeanAttributeInfo[] attributes = actualMBeanInfo.getAttributes();
    MBeanAttributeInfo mBeanAttributeInfo = attributes[0];
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo.getDescription());
    MBeanAttributeInfo mBeanAttributeInfo2 = attributes[1];
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo2.getDescription());
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo.getName());
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo2.getName());
    assertEquals("Runtime Statistics", actualMBeanInfo.getDescription());
    assertEquals("activate", mBeanOperationInfo.getName());
    assertEquals("disable", mBeanOperationInfo2.getName());
    assertEquals("java.lang.Double", mBeanAttributeInfo.getType());
    assertEquals("java.lang.Double", mBeanAttributeInfo2.getType());
    assertEquals("org.broadleafcommerce:name=StatisticsService.broadleaf", actualMBeanInfo.getClassName());
    assertEquals("void", mBeanOperationInfo.getReturnType());
    assertEquals("void", mBeanOperationInfo2.getReturnType());
    assertEquals(0, actualMBeanInfo.getConstructors().length);
    assertEquals(0, actualMBeanInfo.getNotifications().length);
    MBeanParameterInfo[] signature = mBeanOperationInfo.getSignature();
    assertEquals(0, signature.length);
    assertEquals(1, mBeanOperationInfo.getImpact());
    assertEquals(1, mBeanOperationInfo2.getImpact());
    assertEquals(2, attributes.length);
    assertEquals(2, operations.length);
    assertFalse(mBeanAttributeInfo.isIs());
    assertFalse(mBeanAttributeInfo2.isIs());
    assertFalse(mBeanAttributeInfo.isWritable());
    assertTrue(mBeanAttributeInfo.isReadable());
    assertTrue(mBeanAttributeInfo2.isReadable());
    assertTrue(mBeanAttributeInfo2.isWritable());
    assertSame(signature, mBeanOperationInfo2.getSignature());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsServiceImpl#setAdapter(StatisticsServiceLogAdapter)}
   *   <li>{@link StatisticsServiceImpl#setAppName(String)}
   *   <li>{@link StatisticsServiceImpl#setLogResolution(Long)}
   *   <li>{@link StatisticsServiceImpl#getAdapter()}
   *   <li>{@link StatisticsServiceImpl#getAppName()}
   *   <li>{@link StatisticsServiceImpl#getLogResolution()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    Log4j2StatisticsServiceLogAdapter adapter = new Log4j2StatisticsServiceLogAdapter();

    // Act
    statisticsServiceImpl.setAdapter(adapter);
    statisticsServiceImpl.setAppName("App Name");
    statisticsServiceImpl.setLogResolution(1L);
    StatisticsServiceLogAdapter actualAdapter = statisticsServiceImpl.getAdapter();
    String actualAppName = statisticsServiceImpl.getAppName();

    // Assert that nothing has changed
    assertTrue(actualAdapter instanceof Log4j2StatisticsServiceLogAdapter);
    assertEquals("App Name", actualAppName);
    assertEquals(1L, statisticsServiceImpl.getLogResolution().longValue());
    assertSame(adapter, actualAdapter);
  }
}
