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
package org.broadleafcommerce.common.web.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.crossapp.service.CrossAppAuthService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BRCVariableExpressionDiffblueTest {
  @InjectMocks
  private BRCVariableExpression bRCVariableExpression;

  @Mock
  private CrossAppAuthService crossAppAuthService;

  /**
   * Test {@link BRCVariableExpression#getName()}.
   * <p>
   * Method under test: {@link BRCVariableExpression#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BRCVariableExpression.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("brc", (new BRCVariableExpression()).getName());
  }

  /**
   * Test {@link BRCVariableExpression#getSandbox()}.
   * <p>
   * Method under test: {@link BRCVariableExpression#getSandbox()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.common.sandbox.domain.SandBox BRCVariableExpression.getSandbox()"})
  public void testGetSandbox() {
    // Arrange, Act and Assert
    assertNull(bRCVariableExpression.getSandbox());
  }

  /**
   * Test {@link BRCVariableExpression#getCurrentProfile()}.
   * <p>
   * Method under test: {@link BRCVariableExpression#getCurrentProfile()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.common.site.domain.Site BRCVariableExpression.getCurrentProfile()"})
  public void testGetCurrentProfile() {
    // Arrange, Act and Assert
    assertNull(bRCVariableExpression.getCurrentProfile());
  }

  /**
   * Test {@link BRCVariableExpression#getCurrentCatalog()}.
   * <p>
   * Method under test: {@link BRCVariableExpression#getCurrentCatalog()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.common.site.domain.Catalog BRCVariableExpression.getCurrentCatalog()"})
  public void testGetCurrentCatalog() {
    // Arrange, Act and Assert
    assertNull(bRCVariableExpression.getCurrentCatalog());
  }

  /**
   * Test {@link BRCVariableExpression#get(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BRCVariableExpression#get(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Object BRCVariableExpression.get(String)"})
  public void testGet_whenNull() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> bRCVariableExpression.get(null));
  }

  /**
   * Test {@link BRCVariableExpression#get(String)}.
   * <ul>
   *   <li>When {@code Property Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BRCVariableExpression#get(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Object BRCVariableExpression.get(String)"})
  public void testGet_whenPropertyName() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> bRCVariableExpression.get("Property Name"));
  }

  /**
   * Test {@link BRCVariableExpression#get(String)}.
   * <ul>
   *   <li>When {@code ThreadLocalManager.notify.orphans}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BRCVariableExpression#get(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Object BRCVariableExpression.get(String)"})
  public void testGet_whenThreadLocalManagerNotifyOrphans() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> bRCVariableExpression.get("ThreadLocalManager.notify.orphans"));
  }

  /**
   * Test {@link BRCVariableExpression#isCsrMode()}.
   * <ul>
   *   <li>Given {@link BRCVariableExpression} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BRCVariableExpression#isCsrMode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BRCVariableExpression.isCsrMode()"})
  public void testIsCsrMode_givenBRCVariableExpression_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BRCVariableExpression()).isCsrMode());
  }

  /**
   * Test {@link BRCVariableExpression#isCsrMode()}.
   * <ul>
   *   <li>Given Bean Name{blCrossAppAuthService} {@link CrossAppAuthService#hasCsrPermission()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BRCVariableExpression#isCsrMode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BRCVariableExpression.isCsrMode()"})
  public void testIsCsrMode_givenBeanNameBlCrossAppAuthServiceHasCsrPermissionReturnFalse() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(false);

    // Act
    boolean actualIsCsrModeResult = bRCVariableExpression.isCsrMode();

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    assertFalse(actualIsCsrModeResult);
  }

  /**
   * Test {@link BRCVariableExpression#isCsrMode()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BRCVariableExpression#isCsrMode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BRCVariableExpression.isCsrMode()"})
  public void testIsCsrMode_thenReturnTrue() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenReturn(true);

    // Act
    boolean actualIsCsrModeResult = bRCVariableExpression.isCsrMode();

    // Assert
    verify(crossAppAuthService).hasCsrPermission();
    assertTrue(actualIsCsrModeResult);
  }

  /**
   * Test {@link BRCVariableExpression#isCsrMode()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BRCVariableExpression#isCsrMode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BRCVariableExpression.isCsrMode()"})
  public void testIsCsrMode_thenThrowRuntimeException() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> bRCVariableExpression.isCsrMode());
    verify(crossAppAuthService).hasCsrPermission();
  }

  /**
   * Test {@link BRCVariableExpression#isQuoteMode()}.
   * <ul>
   *   <li>Given {@link BRCVariableExpression} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BRCVariableExpression#isQuoteMode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BRCVariableExpression.isQuoteMode()"})
  public void testIsQuoteMode_givenBRCVariableExpression_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BRCVariableExpression()).isQuoteMode());
  }

  /**
   * Test {@link BRCVariableExpression#isQuoteMode()}.
   * <ul>
   *   <li>Given Bean Name{blCrossAppAuthService} {@link CrossAppAuthService#hasQuotePermission()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BRCVariableExpression#isQuoteMode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BRCVariableExpression.isQuoteMode()"})
  public void testIsQuoteMode_givenBeanNameBlCrossAppAuthServiceHasQuotePermissionReturnFalse() {
    // Arrange
    when(crossAppAuthService.hasQuotePermission()).thenReturn(false);

    // Act
    boolean actualIsQuoteModeResult = bRCVariableExpression.isQuoteMode();

    // Assert
    verify(crossAppAuthService).hasQuotePermission();
    assertFalse(actualIsQuoteModeResult);
  }

  /**
   * Test {@link BRCVariableExpression#isQuoteMode()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BRCVariableExpression#isQuoteMode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BRCVariableExpression.isQuoteMode()"})
  public void testIsQuoteMode_thenReturnTrue() {
    // Arrange
    when(crossAppAuthService.hasQuotePermission()).thenReturn(true);

    // Act
    boolean actualIsQuoteModeResult = bRCVariableExpression.isQuoteMode();

    // Assert
    verify(crossAppAuthService).hasQuotePermission();
    assertTrue(actualIsQuoteModeResult);
  }

  /**
   * Test {@link BRCVariableExpression#isQuoteMode()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BRCVariableExpression#isQuoteMode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BRCVariableExpression.isQuoteMode()"})
  public void testIsQuoteMode_thenThrowRuntimeException() {
    // Arrange
    when(crossAppAuthService.hasQuotePermission()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> bRCVariableExpression.isQuoteMode());
    verify(crossAppAuthService).hasQuotePermission();
  }

  /**
   * Test {@link BRCVariableExpression#isSandboxMode()}.
   * <p>
   * Method under test: {@link BRCVariableExpression#isSandboxMode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BRCVariableExpression.isSandboxMode()"})
  public void testIsSandboxMode() {
    // Arrange, Act and Assert
    assertFalse(bRCVariableExpression.isSandboxMode());
  }

  /**
   * Test {@link BRCVariableExpression#getAdditionalProperty(String)}.
   * <p>
   * Method under test: {@link BRCVariableExpression#getAdditionalProperty(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Object BRCVariableExpression.getAdditionalProperty(String)"})
  public void testGetAdditionalProperty() {
    // Arrange, Act and Assert
    assertNull(bRCVariableExpression.getAdditionalProperty("Property Name"));
  }
}
