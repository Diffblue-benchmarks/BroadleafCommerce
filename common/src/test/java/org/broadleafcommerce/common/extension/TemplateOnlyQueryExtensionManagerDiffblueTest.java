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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TemplateOnlyQueryExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class TemplateOnlyQueryExtensionManagerDiffblueTest {
  @Autowired
  private TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager;

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#refineQuery(Class, Object, TypedQuery)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#refineQuery(Class, Object, TypedQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.refineQuery(Class, Object, TypedQuery)"})
  public void testRefineQuery_whenNull_thenReturnNotHandled() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.refineQuery(type, BLCFieldUtils.NULL_FIELD, null));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#refineQuery(Class, Object, TypedQuery)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#refineQuery(Class, Object, TypedQuery)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.refineQuery(Class, Object, TypedQuery)"})
  public void testRefineQuery_whenNull_thenReturnNotHandled2() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.refineQuery(type, BLCFieldUtils.NULL_FIELD, null));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#setup(Class)}.
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#setup(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType TemplateOnlyQueryExtensionManager.setup(Class)"})
  public void testSetup() {
    // Arrange
    Class<TemplateOnlyQueryExtensionHandler> type = TemplateOnlyQueryExtensionHandler.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.setup(type));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#setup(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#setup(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType TemplateOnlyQueryExtensionManager.setup(Class)"})
  public void testSetup_whenJavaLangObject() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.setup(type));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#isEnabled()}.
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#isEnabled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TemplateOnlyQueryExtensionManager.isEnabled()"})
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new TemplateOnlyQueryExtensionManager()).isEnabled());
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}.
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType TemplateOnlyQueryExtensionManager.breakdown(Class)"})
  public void testBreakdown() {
    // Arrange
    Class<TemplateOnlyQueryExtensionHandler> type = TemplateOnlyQueryExtensionHandler.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.breakdown(type));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#breakdown(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType TemplateOnlyQueryExtensionManager.breakdown(Class)"})
  public void testBreakdown_whenJavaLangObject() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.breakdown(type));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}.
   * <ul>
   *   <li>Then calls {@link ExtensionResultHolder#setResult(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType TemplateOnlyQueryExtensionManager.isValidState(ExtensionResultHolder)"})
  public void testIsValidState_thenCallsSetResult() {
    // Arrange
    ExtensionResultHolder<Boolean> response = mock(ExtensionResultHolder.class);
    doNothing().when(response).setResult(Mockito.<Boolean>any());
    doNothing().when(response).setThrowable(Mockito.<Throwable>any());
    response.setResult(true);
    response.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualIsValidStateResult = templateOnlyQueryExtensionManager.isValidState(response);

    // Assert
    verify(response).setResult(eq(true));
    verify(response).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualIsValidStateResult);
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder} (default constructor) Result is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#isValidState(ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType TemplateOnlyQueryExtensionManager.isValidState(ExtensionResultHolder)"})
  public void testIsValidState_whenExtensionResultHolderResultIsTrue() {
    // Arrange
    ExtensionResultHolder<Boolean> response = new ExtensionResultHolder<>();
    response.setResult(true);
    response.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, templateOnlyQueryExtensionManager.isValidState(response));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link DynamicDaoHelperImpl#LOCK_OBJECT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.buildStatus(Object, ExtensionResultHolder)"})
  public void testBuildStatus_whenLock_object() {
    // Arrange
    ExtensionResultHolder<ItemStatus> response = new ExtensionResultHolder<>();
    response.setResult(ItemStatus.DELETED);
    response.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.buildStatus(DynamicDaoHelperImpl.LOCK_OBJECT, response));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#buildStatus(Object, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType TemplateOnlyQueryExtensionManager.buildStatus(Object, ExtensionResultHolder)"})
  public void testBuildStatus_whenNull_field() {
    // Arrange
    ExtensionResultHolder<ItemStatus> response = new ExtensionResultHolder<>();
    response.setResult(ItemStatus.DELETED);
    response.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.buildStatus(BLCFieldUtils.NULL_FIELD, response));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}.
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType TemplateOnlyQueryExtensionManager.filterResults(Class, Object, List)"})
  public void testFilterResults() {
    // Arrange
    Class<TemplateOnlyQueryExtensionHandler> type = TemplateOnlyQueryExtensionHandler.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.filterResults(type, BLCFieldUtils.NULL_FIELD, new ArrayList<>()));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType TemplateOnlyQueryExtensionManager.filterResults(Class, Object, List)"})
  public void testFilterResults_givenNull_field_whenArrayListAddNull_field() {
    // Arrange
    Class<Object> type = Object.class;

    ArrayList<Object> results = new ArrayList<>();
    results.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.filterResults(type, BLCFieldUtils.NULL_FIELD, results));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}.
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType TemplateOnlyQueryExtensionManager.filterResults(Class, Object, List)"})
  public void testFilterResults_givenNull_field_whenArrayListAddNull_field2() {
    // Arrange
    Class<Object> type = Object.class;

    ArrayList<Object> results = new ArrayList<>();
    results.add(BLCFieldUtils.NULL_FIELD);
    results.add(BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.filterResults(type, BLCFieldUtils.NULL_FIELD, results));
  }

  /**
   * Test {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TemplateOnlyQueryExtensionManager#filterResults(Class, Object, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType TemplateOnlyQueryExtensionManager.filterResults(Class, Object, List)"})
  public void testFilterResults_whenArrayList() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        templateOnlyQueryExtensionManager.filterResults(type, BLCFieldUtils.NULL_FIELD, new ArrayList<>()));
  }
}
