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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Field;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelper;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;

public class BLCFieldUtilsDiffblueTest {
  /**
   * Test {@link BLCFieldUtils#BLCFieldUtils(boolean, boolean, EntityConfiguration, DynamicDaoHelper)}.
   * <p>
   * Method under test: {@link BLCFieldUtils#BLCFieldUtils(boolean, boolean, EntityConfiguration, DynamicDaoHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BLCFieldUtils.<init>(boolean, boolean, EntityConfiguration, DynamicDaoHelper)"})
  public void testNewBLCFieldUtils() {
    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();

    // Act and Assert
    assertNull((new BLCFieldUtils(true, true, entityConfiguration, new DynamicDaoHelperImpl())).entityConfiguration
        .getEntityContexts());
  }

  /**
   * Test {@link BLCFieldUtils#getSingleField(Class, String)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCFieldUtils#getSingleField(Class, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field BLCFieldUtils.getSingleField(Class, String)"})
  public void testGetSingleField_whenBLCFieldUtils_thenReturnNull() throws IllegalStateException {
    // Arrange
    Class<BLCFieldUtils> clazz = BLCFieldUtils.class;

    // Act and Assert
    assertNull(BLCFieldUtils.getSingleField(clazz, "Field Name"));
  }

  /**
   * Test {@link BLCFieldUtils#getSingleField(Class, String)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCFieldUtils#getSingleField(Class, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field BLCFieldUtils.getSingleField(Class, String)"})
  public void testGetSingleField_whenBLCFieldUtils_thenReturnNull2() throws IllegalStateException {
    // Arrange
    Class<BLCFieldUtils> clazz = BLCFieldUtils.class;

    // Act and Assert
    assertNull(BLCFieldUtils.getSingleField(clazz, "org.broadleafcommerce.common.util.BLCFieldUtils"));
  }

  /**
   * Test {@link BLCFieldUtils#getSingleField(Class, String)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCFieldUtils#getSingleField(Class, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field BLCFieldUtils.getSingleField(Class, String)"})
  public void testGetSingleField_whenJavaLangObject_thenReturnNull() throws IllegalStateException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(BLCFieldUtils.getSingleField(clazz, "Field Name"));
  }

  /**
   * Test {@link BLCFieldUtils#getSingleField(Class, String)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCFieldUtils#getSingleField(Class, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field BLCFieldUtils.getSingleField(Class, String)"})
  public void testGetSingleField_whenJavaLangObject_thenReturnNull2() throws IllegalStateException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(BLCFieldUtils.getSingleField(clazz, "org.broadleafcommerce.common.util.BLCFieldUtils"));
  }

  /**
   * Test {@link BLCFieldUtils#getField(Class, String)}.
   * <p>
   * Method under test: {@link BLCFieldUtils#getField(Class, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field BLCFieldUtils.getField(Class, String)"})
  public void testGetField() throws IllegalStateException {
    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    BLCFieldUtils blcFieldUtils = new BLCFieldUtils(true, true, entityConfiguration, new DynamicDaoHelperImpl());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(blcFieldUtils.getField(clazz, "Field Name"));
  }

  /**
   * Test {@link BLCFieldUtils#getField(Class, String)}.
   * <p>
   * Method under test: {@link BLCFieldUtils#getField(Class, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field BLCFieldUtils.getField(Class, String)"})
  public void testGetField2() throws IllegalStateException {
    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    BLCFieldUtils blcFieldUtils = new BLCFieldUtils(false, true, entityConfiguration, new DynamicDaoHelperImpl());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(blcFieldUtils.getField(clazz, "Field Name"));
  }

  /**
   * Test {@link BLCFieldUtils#getField(Class, String)}.
   * <p>
   * Method under test: {@link BLCFieldUtils#getField(Class, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field BLCFieldUtils.getField(Class, String)"})
  public void testGetField3() throws IllegalStateException {
    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    BLCFieldUtils blcFieldUtils = new BLCFieldUtils(true, false, entityConfiguration, new DynamicDaoHelperImpl());
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(blcFieldUtils.getField(clazz, "Field Name"));
  }

  /**
   * Test {@link BLCFieldUtils#getField(Class, String)}.
   * <p>
   * Method under test: {@link BLCFieldUtils#getField(Class, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field BLCFieldUtils.getField(Class, String)"})
  public void testGetField4() throws IllegalStateException, BeansException {
    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    entityConfiguration.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    DynamicDaoHelper helper = mock(DynamicDaoHelper.class);
    when(helper.getUpDownInheritance(Mockito.<Class<Object>>any(), anyBoolean(), anyBoolean())).thenReturn(null);
    BLCFieldUtils blcFieldUtils = new BLCFieldUtils(true, true, entityConfiguration, helper);
    Class<Object> clazz = Object.class;

    // Act
    Field actualField = blcFieldUtils.getField(clazz, "Field Name");

    // Assert
    verify(helper).getUpDownInheritance(isA(Class.class), eq(true), eq(true));
    assertNull(actualField);
  }

  /**
   * Test {@link BLCFieldUtils#getField(Class, String)}.
   * <ul>
   *   <li>Given {@link DynamicDaoHelper} {@link DynamicDaoHelper#getUpDownInheritance(Class, boolean, boolean)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCFieldUtils#getField(Class, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field BLCFieldUtils.getField(Class, String)"})
  public void testGetField_givenDynamicDaoHelperGetUpDownInheritanceReturnNull() throws IllegalStateException {
    // Arrange
    DynamicDaoHelper helper = mock(DynamicDaoHelper.class);
    when(helper.getUpDownInheritance(Mockito.<Class<Object>>any(), anyBoolean(), anyBoolean())).thenReturn(null);
    BLCFieldUtils blcFieldUtils = new BLCFieldUtils(true, true, new EntityConfiguration(), helper);
    Class<Object> clazz = Object.class;

    // Act
    Field actualField = blcFieldUtils.getField(clazz, "Field Name");

    // Assert
    verify(helper).getUpDownInheritance(isA(Class.class), eq(true), eq(true));
    assertNull(actualField);
  }

  /**
   * Test {@link BLCFieldUtils#getField(Class, String)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then calls {@link DynamicDaoHelper#getUpDownInheritance(Class, boolean, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCFieldUtils#getField(Class, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field BLCFieldUtils.getField(Class, String)"})
  public void testGetField_givenJavaLangObject_thenCallsGetUpDownInheritance() throws IllegalStateException {
    // Arrange
    DynamicDaoHelper helper = mock(DynamicDaoHelper.class);
    Class<Object> forNameResult = Object.class;
    when(helper.getUpDownInheritance(Mockito.<Class<Object>>any(), anyBoolean(), anyBoolean()))
        .thenReturn(new Class[]{forNameResult});
    BLCFieldUtils blcFieldUtils = new BLCFieldUtils(true, true, new EntityConfiguration(), helper);
    Class<Object> clazz = Object.class;

    // Act
    Field actualField = blcFieldUtils.getField(clazz, "Field Name");

    // Assert
    verify(helper).getUpDownInheritance(isA(Class.class), eq(true), eq(true));
    assertNull(actualField);
  }

  /**
   * Test {@link BLCFieldUtils#getField(Class, String)}.
   * <ul>
   *   <li>When {@code BLCFieldUtils}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCFieldUtils#getField(Class, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field BLCFieldUtils.getField(Class, String)"})
  public void testGetField_whenOrgBroadleafcommerceCommonUtilBLCFieldUtils() throws IllegalStateException {
    // Arrange
    DynamicDaoHelper helper = mock(DynamicDaoHelper.class);
    when(helper.getUpDownInheritance(Mockito.<Class<Object>>any(), anyBoolean(), anyBoolean())).thenReturn(null);
    BLCFieldUtils blcFieldUtils = new BLCFieldUtils(true, true, new EntityConfiguration(), helper);
    Class<BLCFieldUtils> clazz = BLCFieldUtils.class;

    // Act
    Field actualField = blcFieldUtils.getField(clazz, "Field Name");

    // Assert
    verify(helper).getUpDownInheritance(isA(Class.class), eq(true), eq(true));
    assertNull(actualField);
  }

  /**
   * Test {@link BLCFieldUtils#getClassForField(DynamicDaoHelper, String, Field, Class[])}.
   * <ul>
   *   <li>When {@code ABC123}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCFieldUtils#getClassForField(DynamicDaoHelper, String, Field, Class[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class BLCFieldUtils.getClassForField(DynamicDaoHelper, String, Field, Class[])"})
  public void testGetClassForField_whenAbc123_thenReturnNull() {
    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    BLCFieldUtils blcFieldUtils = new BLCFieldUtils(true, true, entityConfiguration, new DynamicDaoHelperImpl());
    DynamicDaoHelperImpl helper = new DynamicDaoHelperImpl();
    Class<Object> forNameResult = Object.class;

    // Act and Assert
    assertNull(blcFieldUtils.getClassForField(helper, "ABC123", null, new Class[]{forNameResult}));
  }
}
