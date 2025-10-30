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
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.Map;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class StatisticsServiceImplDiffblueTest {
  /**
   * Test {@link StatisticsServiceImpl#addCacheStat(String, boolean)}.
   * <p>
   * Method under test: {@link StatisticsServiceImpl#addCacheStat(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatisticsServiceImpl.addCacheStat(String, boolean)"})
  public void testAddCacheStat() {
    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.addCacheStat("Key", true);

    // Act
    statisticsServiceImpl.addCacheStat("Key", true);

    // Assert
    Map<String, CacheStat> stringCacheStatMap = statisticsServiceImpl.cacheStats;
    assertEquals(1, stringCacheStatMap.size());
    CacheStat getResult = stringCacheStatMap.get("Key");
    assertEquals(2L, getResult.getCacheHitCount().longValue());
    assertEquals(2L, getResult.getRequestCount().longValue());
    BigDecimal expectedHitRate = new BigDecimal("100.00");
    assertEquals(expectedHitRate, getResult.getHitRate());
  }

  /**
   * Test {@link StatisticsServiceImpl#getCacheStat(String)}.
   * <ul>
   *   <li>Then second element Description is {@code LOG_RESOLUTION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#getCacheStat(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CacheStat StatisticsServiceImpl.getCacheStat(String)"})
  public void testGetCacheStat_thenSecondElementDescriptionIsLogResolution() {
    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();

    // Act
    statisticsServiceImpl.getCacheStat("Key");

    // Assert
    MBeanAttributeInfo[] attributes = statisticsServiceImpl.getMBeanInfo().getAttributes();
    MBeanAttributeInfo mBeanAttributeInfo = attributes[1];
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo.getDescription());
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo.getName());
    assertEquals("java.lang.Double", mBeanAttributeInfo.getType());
    Map<String, CacheStat> stringCacheStatMap = statisticsServiceImpl.cacheStats;
    assertEquals(1, stringCacheStatMap.size());
    assertEquals(2, attributes.length);
    assertFalse(mBeanAttributeInfo.isIs());
    assertFalse((attributes[0]).isWritable());
    assertTrue(stringCacheStatMap.containsKey("Key"));
    assertTrue(mBeanAttributeInfo.isReadable());
    assertTrue(mBeanAttributeInfo.isWritable());
  }

  /**
   * Test {@link StatisticsServiceImpl#getCacheStat(String)}.
   * <ul>
   *   <li>Then third element Description is {@code LOG_RESOLUTION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#getCacheStat(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CacheStat StatisticsServiceImpl.getCacheStat(String)"})
  public void testGetCacheStat_thenThirdElementDescriptionIsLogResolution() {
    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.addCacheStat("ThreadLocalManager.notify.orphans", true);

    // Act
    statisticsServiceImpl.getCacheStat("Key");

    // Assert
    MBeanAttributeInfo[] attributes = statisticsServiceImpl.getMBeanInfo().getAttributes();
    MBeanAttributeInfo mBeanAttributeInfo = attributes[2];
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo.getDescription());
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo.getName());
    MBeanAttributeInfo mBeanAttributeInfo2 = attributes[1];
    assertEquals("ThreadLocalManager.notify.orphans", mBeanAttributeInfo2.getDescription());
    assertEquals("ThreadLocalManager.notify.orphans", mBeanAttributeInfo2.getName());
    assertEquals("java.lang.Double", mBeanAttributeInfo.getType());
    Map<String, CacheStat> stringCacheStatMap = statisticsServiceImpl.cacheStats;
    assertEquals(2, stringCacheStatMap.size());
    assertEquals(3, attributes.length);
    assertFalse(mBeanAttributeInfo.isIs());
    assertFalse(mBeanAttributeInfo2.isWritable());
    assertTrue(stringCacheStatMap.containsKey("Key"));
    assertTrue(stringCacheStatMap.containsKey("ThreadLocalManager.notify.orphans"));
    assertTrue(mBeanAttributeInfo.isReadable());
    assertTrue(mBeanAttributeInfo.isWritable());
  }

  /**
   * Test {@link StatisticsServiceImpl#activateLogging()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#activateLogging()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatisticsServiceImpl.activateLogging()"})
  public void testActivateLogging_thenThrowRuntimeException() {
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
   * Test {@link StatisticsServiceImpl#disableLogging()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#disableLogging()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatisticsServiceImpl.disableLogging()"})
  public void testDisableLogging_thenThrowRuntimeException() {
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
   * Test {@link StatisticsServiceImpl#getAttribute(String)}.
   * <ul>
   *   <li>Then return doubleValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#getAttribute(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StatisticsServiceImpl.getAttribute(String)"})
  public void testGetAttribute_thenReturnDoubleValueIsZero()
      throws AttributeNotFoundException, MBeanException, ReflectionException {
    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.addCacheStat("Attribute", false);
    statisticsServiceImpl.addCacheStat("LOG_RESOLUTION", true);

    // Act and Assert
    assertEquals(0.0d, ((Double) statisticsServiceImpl.getAttribute("Attribute")).doubleValue(), 0.0);
    Map<String, CacheStat> stringCacheStatMap = statisticsServiceImpl.cacheStats;
    assertEquals(2, stringCacheStatMap.size());
    MBeanAttributeInfo[] attributes = statisticsServiceImpl.getMBeanInfo().getAttributes();
    assertEquals(3, attributes.length);
    assertFalse((attributes[1]).isWritable());
    assertTrue(stringCacheStatMap.containsKey("LOG_RESOLUTION"));
  }

  /**
   * Test {@link StatisticsServiceImpl#getAttribute(String)}.
   * <ul>
   *   <li>Then second element Description is {@code LOG_RESOLUTION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#getAttribute(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StatisticsServiceImpl.getAttribute(String)"})
  public void testGetAttribute_thenSecondElementDescriptionIsLogResolution()
      throws AttributeNotFoundException, MBeanException, ReflectionException {
    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();

    // Act
    statisticsServiceImpl.getAttribute("Attribute");

    // Assert
    MBeanAttributeInfo[] attributes = statisticsServiceImpl.getMBeanInfo().getAttributes();
    MBeanAttributeInfo mBeanAttributeInfo = attributes[1];
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo.getDescription());
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo.getName());
    assertEquals("java.lang.Double", mBeanAttributeInfo.getType());
    assertEquals(1, statisticsServiceImpl.cacheStats.size());
    assertEquals(2, attributes.length);
    assertFalse(mBeanAttributeInfo.isIs());
    assertFalse((attributes[0]).isWritable());
    assertTrue(mBeanAttributeInfo.isReadable());
    assertTrue(mBeanAttributeInfo.isWritable());
  }

  /**
   * Test {@link StatisticsServiceImpl#getAttribute(String)}.
   * <ul>
   *   <li>Then third element Description is {@code LOG_RESOLUTION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#getAttribute(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StatisticsServiceImpl.getAttribute(String)"})
  public void testGetAttribute_thenThirdElementDescriptionIsLogResolution()
      throws AttributeNotFoundException, MBeanException, ReflectionException {
    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.addCacheStat("LOG_RESOLUTION", true);

    // Act
    statisticsServiceImpl.getAttribute("Attribute");

    // Assert
    MBeanAttributeInfo[] attributes = statisticsServiceImpl.getMBeanInfo().getAttributes();
    MBeanAttributeInfo mBeanAttributeInfo = attributes[2];
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo.getDescription());
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo.getName());
    assertEquals("java.lang.Double", mBeanAttributeInfo.getType());
    Map<String, CacheStat> stringCacheStatMap = statisticsServiceImpl.cacheStats;
    assertEquals(2, stringCacheStatMap.size());
    assertEquals(3, attributes.length);
    assertFalse(mBeanAttributeInfo.isIs());
    assertFalse((attributes[1]).isWritable());
    assertTrue(stringCacheStatMap.containsKey("LOG_RESOLUTION"));
    assertTrue(mBeanAttributeInfo.isReadable());
    assertTrue(mBeanAttributeInfo.isWritable());
  }

  /**
   * Test {@link StatisticsServiceImpl#getAttribute(String)}.
   * <ul>
   *   <li>When {@code LOG_RESOLUTION}.</li>
   *   <li>Then array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#getAttribute(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StatisticsServiceImpl.getAttribute(String)"})
  public void testGetAttribute_whenLogResolution_thenArrayLengthIsOne()
      throws AttributeNotFoundException, MBeanException, ReflectionException {
    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();

    // Act
    Object actualAttribute = statisticsServiceImpl.getAttribute("LOG_RESOLUTION");

    // Assert
    assertEquals(1, statisticsServiceImpl.getMBeanInfo().getAttributes().length);
    assertEquals(30000L, ((Long) actualAttribute).longValue());
    assertTrue(statisticsServiceImpl.cacheStats.isEmpty());
  }

  /**
   * Test {@link StatisticsServiceImpl#setAttribute(Attribute)}.
   * <ul>
   *   <li>Then {@link StatisticsServiceImpl} (default constructor) LogResolution longValue is {@code 30000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#setAttribute(Attribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatisticsServiceImpl.setAttribute(Attribute)"})
  public void testSetAttribute_thenStatisticsServiceImplLogResolutionLongValueIs30000()
      throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();

    // Act
    statisticsServiceImpl.setAttribute(new Attribute("foo", BLCFieldUtils.NULL_FIELD));

    // Assert that nothing has changed
    assertEquals(30000L, statisticsServiceImpl.getLogResolution().longValue());
  }

  /**
   * Test {@link StatisticsServiceImpl#setAttribute(Attribute)}.
   * <ul>
   *   <li>Then {@link StatisticsServiceImpl} (default constructor) LogResolution longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#setAttribute(Attribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StatisticsServiceImpl.setAttribute(Attribute)"})
  public void testSetAttribute_thenStatisticsServiceImplLogResolutionLongValueIsOne()
      throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();

    // Act
    statisticsServiceImpl.setAttribute(new Attribute("LOG_RESOLUTION", 1L));

    // Assert
    assertEquals(1L, statisticsServiceImpl.getLogResolution().longValue());
  }

  /**
   * Test {@link StatisticsServiceImpl#getAttributes(String[])}.
   * <ul>
   *   <li>Given {@link StatisticsServiceImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#getAttributes(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AttributeList StatisticsServiceImpl.getAttributes(String[])"})
  public void testGetAttributes_givenStatisticsServiceImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new StatisticsServiceImpl()).getAttributes(new String[]{"Attributes"}).isEmpty());
  }

  /**
   * Test {@link StatisticsServiceImpl#getAttributes(String[])}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#getAttributes(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AttributeList StatisticsServiceImpl.getAttributes(String[])"})
  public void testGetAttributes_thenReturnSizeIsOne() {
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
   * Test {@link StatisticsServiceImpl#setAttributes(AttributeList)}.
   * <p>
   * Method under test: {@link StatisticsServiceImpl#setAttributes(AttributeList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AttributeList StatisticsServiceImpl.setAttributes(AttributeList)"})
  public void testSetAttributes() {
    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    AttributeList attributes = new AttributeList();

    // Act and Assert
    assertSame(attributes, statisticsServiceImpl.setAttributes(attributes));
  }

  /**
   * Test {@link StatisticsServiceImpl#invoke(String, Object[], String[])}.
   * <ul>
   *   <li>Given {@link StatisticsServiceImpl} (default constructor) Adapter is {@link Log4j2StatisticsServiceLogAdapter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#invoke(String, Object[], String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StatisticsServiceImpl.invoke(String, Object[], String[])"})
  public void testInvoke_givenStatisticsServiceImplAdapterIsLog4j2StatisticsServiceLogAdapter()
      throws MBeanException, ReflectionException {
    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(new Log4j2StatisticsServiceLogAdapter());

    // Act and Assert
    assertNull(
        statisticsServiceImpl.invoke("activate", new Object[]{BLCFieldUtils.NULL_FIELD}, new String[]{"Signature"}));
  }

  /**
   * Test {@link StatisticsServiceImpl#invoke(String, Object[], String[])}.
   * <ul>
   *   <li>Given {@link StatisticsServiceImpl} (default constructor) Adapter is {@link Log4j2StatisticsServiceLogAdapter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#invoke(String, Object[], String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StatisticsServiceImpl.invoke(String, Object[], String[])"})
  public void testInvoke_givenStatisticsServiceImplAdapterIsLog4j2StatisticsServiceLogAdapter2()
      throws MBeanException, ReflectionException {
    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(new Log4j2StatisticsServiceLogAdapter());

    // Act and Assert
    assertNull(
        statisticsServiceImpl.invoke("disable", new Object[]{BLCFieldUtils.NULL_FIELD}, new String[]{"Signature"}));
  }

  /**
   * Test {@link StatisticsServiceImpl#invoke(String, Object[], String[])}.
   * <ul>
   *   <li>Given {@link StatisticsServiceImpl} (default constructor) Adapter is {@code null}.</li>
   *   <li>When {@code activate}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#invoke(String, Object[], String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StatisticsServiceImpl.invoke(String, Object[], String[])"})
  public void testInvoke_givenStatisticsServiceImplAdapterIsNull_whenActivate_thenReturnNull()
      throws MBeanException, ReflectionException {
    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(null);

    // Act and Assert
    assertNull(
        statisticsServiceImpl.invoke("activate", new Object[]{BLCFieldUtils.NULL_FIELD}, new String[]{"Signature"}));
  }

  /**
   * Test {@link StatisticsServiceImpl#invoke(String, Object[], String[])}.
   * <ul>
   *   <li>Given {@link StatisticsServiceImpl} (default constructor) Adapter is {@code null}.</li>
   *   <li>When {@code disable}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#invoke(String, Object[], String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StatisticsServiceImpl.invoke(String, Object[], String[])"})
  public void testInvoke_givenStatisticsServiceImplAdapterIsNull_whenDisable_thenReturnNull()
      throws MBeanException, ReflectionException {
    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(null);

    // Act and Assert
    assertNull(
        statisticsServiceImpl.invoke("disable", new Object[]{BLCFieldUtils.NULL_FIELD}, new String[]{"Signature"}));
  }

  /**
   * Test {@link StatisticsServiceImpl#invoke(String, Object[], String[])}.
   * <ul>
   *   <li>Given {@link StatisticsServiceImpl} (default constructor).</li>
   *   <li>When {@code Action Name}.</li>
   *   <li>Then throw {@link MBeanException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#invoke(String, Object[], String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StatisticsServiceImpl.invoke(String, Object[], String[])"})
  public void testInvoke_givenStatisticsServiceImpl_whenActionName_thenThrowMBeanException()
      throws MBeanException, ReflectionException {
    // Arrange, Act and Assert
    assertThrows(MBeanException.class, () -> (new StatisticsServiceImpl()).invoke("Action Name",
        new Object[]{BLCFieldUtils.NULL_FIELD}, new String[]{"Signature"}));
  }

  /**
   * Test {@link StatisticsServiceImpl#invoke(String, Object[], String[])}.
   * <ul>
   *   <li>Then calls {@link Log4j2StatisticsServiceLogAdapter#activateLogging(Class)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#invoke(String, Object[], String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StatisticsServiceImpl.invoke(String, Object[], String[])"})
  public void testInvoke_thenCallsActivateLogging() throws MBeanException, ReflectionException {
    // Arrange
    Log4j2StatisticsServiceLogAdapter adapter = mock(Log4j2StatisticsServiceLogAdapter.class);
    doThrow(new RuntimeException("foo")).when(adapter).activateLogging(Mockito.<Class<Object>>any());

    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.setAdapter(adapter);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> statisticsServiceImpl.invoke("activate",
        new Object[]{BLCFieldUtils.NULL_FIELD}, new String[]{"Signature"}));
    verify(adapter).activateLogging(isA(Class.class));
  }

  /**
   * Test {@link StatisticsServiceImpl#invoke(String, Object[], String[])}.
   * <ul>
   *   <li>Then calls {@link Log4j2StatisticsServiceLogAdapter#disableLogging(Class)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#invoke(String, Object[], String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object StatisticsServiceImpl.invoke(String, Object[], String[])"})
  public void testInvoke_thenCallsDisableLogging() throws MBeanException, ReflectionException {
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
   * Test {@link StatisticsServiceImpl#getObjectName()}.
   * <ul>
   *   <li>Given {@link StatisticsServiceImpl} (default constructor).</li>
   *   <li>Then return KeyPropertyList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#getObjectName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ObjectName StatisticsServiceImpl.getObjectName()"})
  public void testGetObjectName_givenStatisticsServiceImpl_thenReturnKeyPropertyListSizeIsOne()
      throws MalformedObjectNameException {
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
   * Test {@link StatisticsServiceImpl#getMBeanInfo()}.
   * <ul>
   *   <li>Then return Description is {@code Runtime Statistics}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#getMBeanInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MBeanInfo StatisticsServiceImpl.getMBeanInfo()"})
  public void testGetMBeanInfo_thenReturnDescriptionIsRuntimeStatistics() {
    // Arrange and Act
    MBeanInfo actualMBeanInfo = (new StatisticsServiceImpl()).getMBeanInfo();

    // Assert
    assertEquals("Runtime Statistics", actualMBeanInfo.getDescription());
    assertEquals("org.broadleafcommerce:name=StatisticsService.broadleaf", actualMBeanInfo.getClassName());
    assertEquals(0, actualMBeanInfo.getConstructors().length);
    assertEquals(0, actualMBeanInfo.getNotifications().length);
    assertEquals(1, actualMBeanInfo.getAttributes().length);
    assertEquals(2, actualMBeanInfo.getOperations().length);
  }

  /**
   * Test {@link StatisticsServiceImpl#getMBeanInfo()}.
   * <ul>
   *   <li>Then return second element Description is {@code LOG_RESOLUTION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatisticsServiceImpl#getMBeanInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MBeanInfo StatisticsServiceImpl.getMBeanInfo()"})
  public void testGetMBeanInfo_thenReturnSecondElementDescriptionIsLogResolution() {
    // Arrange
    StatisticsServiceImpl statisticsServiceImpl = new StatisticsServiceImpl();
    statisticsServiceImpl.addCacheStat("LOG_RESOLUTION", true);

    // Act and Assert
    MBeanAttributeInfo[] attributes = statisticsServiceImpl.getMBeanInfo().getAttributes();
    MBeanAttributeInfo mBeanAttributeInfo = attributes[1];
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo.getDescription());
    assertEquals("LOG_RESOLUTION", mBeanAttributeInfo.getName());
    assertEquals("java.lang.Double", mBeanAttributeInfo.getType());
    assertEquals(2, attributes.length);
    assertFalse(mBeanAttributeInfo.isIs());
    assertFalse((attributes[0]).isWritable());
    assertTrue(mBeanAttributeInfo.isReadable());
    assertTrue(mBeanAttributeInfo.isWritable());
  }

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StatisticsServiceLogAdapter StatisticsServiceImpl.getAdapter()",
      "String StatisticsServiceImpl.getAppName()", "Long StatisticsServiceImpl.getLogResolution()",
      "void StatisticsServiceImpl.setAdapter(StatisticsServiceLogAdapter)",
      "void StatisticsServiceImpl.setAppName(String)", "void StatisticsServiceImpl.setLogResolution(Long)"})
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

    // Assert
    assertTrue(actualAdapter instanceof Log4j2StatisticsServiceLogAdapter);
    assertEquals("App Name", actualAppName);
    assertEquals(1L, statisticsServiceImpl.getLogResolution().longValue());
    assertSame(adapter, actualAdapter);
  }
}
