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
package org.broadleafcommerce.common.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TemplateCacheExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class TemplateCacheExtensionManagerDiffblueTest {
  @Autowired
  private TemplateCacheExtensionManager templateCacheExtensionManager;

  /**
   * Test {@link TemplateCacheExtensionManager#isEnabled()}.
   * <p>
   * Method under test: {@link TemplateCacheExtensionManager#isEnabled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TemplateCacheExtensionManager.isEnabled()"})
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new TemplateCacheExtensionManager()).isEnabled());
  }

  /**
   * Test {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link DynamicDaoHelperImpl#LOCK_OBJECT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType TemplateCacheExtensionManager.getTemplateCacheKey(Object, String, ExtensionResultHolder)"})
  public void testGetTemplateCacheKey_whenLock_object() {
    // Arrange
    ExtensionResultHolder<Object> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(BLCFieldUtils.NULL_FIELD);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateCacheExtensionManager.getTemplateCacheKey(DynamicDaoHelperImpl.LOCK_OBJECT, "Template", resultHolder));
  }

  /**
   * Test {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateCacheExtensionManager#getTemplateCacheKey(Object, String, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType TemplateCacheExtensionManager.getTemplateCacheKey(Object, String, ExtensionResultHolder)"})
  public void testGetTemplateCacheKey_whenNull_field() {
    // Arrange
    ExtensionResultHolder<Object> resultHolder = new ExtensionResultHolder<>();
    resultHolder.setResult(BLCFieldUtils.NULL_FIELD);
    resultHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateCacheExtensionManager.getTemplateCacheKey(BLCFieldUtils.NULL_FIELD, "Template", resultHolder));
  }

  /**
   * Test {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link DynamicDaoHelperImpl#LOCK_OBJECT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType TemplateCacheExtensionManager.getTemplateName(Object, ExtensionResultHolder)"})
  public void testGetTemplateName_whenLock_object() {
    // Arrange
    ExtensionResultHolder<Object> result = new ExtensionResultHolder<>();
    result.setResult(BLCFieldUtils.NULL_FIELD);
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateCacheExtensionManager.getTemplateName(DynamicDaoHelperImpl.LOCK_OBJECT, result));
  }

  /**
   * Test {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateCacheExtensionManager#getTemplateName(Object, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType TemplateCacheExtensionManager.getTemplateName(Object, ExtensionResultHolder)"})
  public void testGetTemplateName_whenNull_field() {
    // Arrange
    ExtensionResultHolder<Object> result = new ExtensionResultHolder<>();
    result.setResult(BLCFieldUtils.NULL_FIELD);
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateCacheExtensionManager.getTemplateName(BLCFieldUtils.NULL_FIELD, result));
  }
}
