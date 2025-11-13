package org.broadleafcommerce.common.web.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @InjectMocks private BRCVariableExpression bRCVariableExpression;

  @Mock private CrossAppAuthService crossAppAuthService;

  /**
   * Test {@link BRCVariableExpression#getName()}.
   *
   * <p>Method under test: {@link BRCVariableExpression#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BRCVariableExpression.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("brc", new BRCVariableExpression().getName());
  }

  /**
   * Test {@link BRCVariableExpression#getSandbox()}.
   *
   * <p>Method under test: {@link BRCVariableExpression#getSandbox()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.sandbox.domain.SandBox BRCVariableExpression.getSandbox()"
  })
  public void testGetSandbox() {
    // Arrange, Act and Assert
    assertNull(new BRCVariableExpression().getSandbox());
  }

  /**
   * Test {@link BRCVariableExpression#getSite()}.
   *
   * <p>Method under test: {@link BRCVariableExpression#getSite()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.site.domain.Site BRCVariableExpression.getSite()"
  })
  public void testGetSite() {
    // Arrange, Act and Assert
    assertNull(new BRCVariableExpression().getSite());
  }

  /**
   * Test {@link BRCVariableExpression#getCurrentProfile()}.
   *
   * <p>Method under test: {@link BRCVariableExpression#getCurrentProfile()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.site.domain.Site BRCVariableExpression.getCurrentProfile()"
  })
  public void testGetCurrentProfile() {
    // Arrange, Act and Assert
    assertNull(new BRCVariableExpression().getCurrentProfile());
  }

  /**
   * Test {@link BRCVariableExpression#getCurrentCatalog()}.
   *
   * <p>Method under test: {@link BRCVariableExpression#getCurrentCatalog()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.site.domain.Catalog BRCVariableExpression.getCurrentCatalog()"
  })
  public void testGetCurrentCatalog() {
    // Arrange, Act and Assert
    assertNull(new BRCVariableExpression().getCurrentCatalog());
  }

  /**
   * Test {@link BRCVariableExpression#get(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BRCVariableExpression#get(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object BRCVariableExpression.get(String)"})
  public void testGet_whenNull() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new BRCVariableExpression().get(null));
  }

  /**
   * Test {@link BRCVariableExpression#get(String)}.
   *
   * <ul>
   *   <li>When {@code Property Name}.
   * </ul>
   *
   * <p>Method under test: {@link BRCVariableExpression#get(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object BRCVariableExpression.get(String)"})
  public void testGet_whenPropertyName() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new BRCVariableExpression().get("Property Name"));
  }

  /**
   * Test {@link BRCVariableExpression#isCsrMode()}.
   *
   * <ul>
   *   <li>Given {@link BRCVariableExpression} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BRCVariableExpression#isCsrMode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BRCVariableExpression.isCsrMode()"})
  public void testIsCsrMode_givenBRCVariableExpression_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BRCVariableExpression().isCsrMode());
  }

  /**
   * Test {@link BRCVariableExpression#isCsrMode()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BRCVariableExpression#isCsrMode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BRCVariableExpression#isCsrMode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BRCVariableExpression.isCsrMode()"})
  public void testIsCsrMode_thenThrowRuntimeException() {
    // Arrange
    when(crossAppAuthService.hasCsrPermission()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> bRCVariableExpression.isCsrMode());
    verify(crossAppAuthService).hasCsrPermission();
  }

  /**
   * Test {@link BRCVariableExpression#isQuoteMode()}.
   *
   * <ul>
   *   <li>Given {@link BRCVariableExpression} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BRCVariableExpression#isQuoteMode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BRCVariableExpression.isQuoteMode()"})
  public void testIsQuoteMode_givenBRCVariableExpression_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BRCVariableExpression().isQuoteMode());
  }

  /**
   * Test {@link BRCVariableExpression#isQuoteMode()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BRCVariableExpression#isQuoteMode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BRCVariableExpression#isQuoteMode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BRCVariableExpression.isQuoteMode()"})
  public void testIsQuoteMode_thenThrowRuntimeException() {
    // Arrange
    when(crossAppAuthService.hasQuotePermission()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> bRCVariableExpression.isQuoteMode());
    verify(crossAppAuthService).hasQuotePermission();
  }

  /**
   * Test {@link BRCVariableExpression#isSandboxMode()}.
   *
   * <p>Method under test: {@link BRCVariableExpression#isSandboxMode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BRCVariableExpression.isSandboxMode()"})
  public void testIsSandboxMode() {
    // Arrange, Act and Assert
    assertFalse(new BRCVariableExpression().isSandboxMode());
  }

  /**
   * Test {@link BRCVariableExpression#getAdditionalProperty(String)}.
   *
   * <p>Method under test: {@link BRCVariableExpression#getAdditionalProperty(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object BRCVariableExpression.getAdditionalProperty(String)"})
  public void testGetAdditionalProperty() {
    // Arrange, Act and Assert
    assertNull(new BRCVariableExpression().getAdditionalProperty("Property Name"));
  }
}
