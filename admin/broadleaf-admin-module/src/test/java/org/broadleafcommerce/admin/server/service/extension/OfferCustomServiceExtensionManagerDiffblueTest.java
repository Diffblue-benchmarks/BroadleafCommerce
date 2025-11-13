package org.broadleafcommerce.admin.server.service.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferCustomServiceExtensionManager.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferCustomServiceExtensionManagerDiffblueTest {
  @Autowired private OfferCustomServiceExtensionManager offerCustomServiceExtensionManager;

  /**
   * Test {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   *
   * <p>Method under test: {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferCustomServiceExtensionManager.clearHiddenQualifiers(Entity)"
  })
  public void testClearHiddenQualifiers() {
    // Arrange
    OfferCustomServiceExtensionManager offerCustomServiceExtensionManager =
        new OfferCustomServiceExtensionManager();
    offerCustomServiceExtensionManager.registerHandler(
        new AbstractOfferCustomServiceExtensionHandler());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerCustomServiceExtensionManager.clearHiddenQualifiers(new Entity()));
  }

  /**
   * Test {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   *
   * <p>Method under test: {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferCustomServiceExtensionManager.clearHiddenQualifiers(Entity)"
  })
  public void testClearHiddenQualifiers2() {
    // Arrange
    OfferCustomServiceExtensionManager offerCustomServiceExtensionManager =
        new OfferCustomServiceExtensionManager();
    offerCustomServiceExtensionManager.registerHandler(new OfferCustomServiceExtensionManager());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerCustomServiceExtensionManager.clearHiddenQualifiers(new Entity()));
  }

  /**
   * Test {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   *
   * <p>Method under test: {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferCustomServiceExtensionManager.clearHiddenQualifiers(Entity)"
  })
  public void testClearHiddenQualifiers3() {
    // Arrange
    AbstractOfferCustomServiceExtensionHandler abstractOfferCustomServiceExtensionHandler =
        mock(AbstractOfferCustomServiceExtensionHandler.class);
    when(abstractOfferCustomServiceExtensionHandler.clearHiddenQualifiers(Mockito.<Entity>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferCustomServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferCustomServiceExtensionManager offerCustomServiceExtensionManager =
        new OfferCustomServiceExtensionManager();
    offerCustomServiceExtensionManager.registerHandler(abstractOfferCustomServiceExtensionHandler);

    // Act
    ExtensionResultStatusType actualClearHiddenQualifiersResult =
        offerCustomServiceExtensionManager.clearHiddenQualifiers(new Entity());

    // Assert
    verify(abstractOfferCustomServiceExtensionHandler).clearHiddenQualifiers(isA(Entity.class));
    verify(abstractOfferCustomServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualClearHiddenQualifiersResult);
  }

  /**
   * Test {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   *
   * <p>Method under test: {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferCustomServiceExtensionManager.clearHiddenQualifiers(Entity)"
  })
  public void testClearHiddenQualifiers4() {
    // Arrange
    AbstractOfferCustomServiceExtensionHandler abstractOfferCustomServiceExtensionHandler =
        mock(AbstractOfferCustomServiceExtensionHandler.class);
    when(abstractOfferCustomServiceExtensionHandler.clearHiddenQualifiers(Mockito.<Entity>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractOfferCustomServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferCustomServiceExtensionManager offerCustomServiceExtensionManager =
        new OfferCustomServiceExtensionManager();
    offerCustomServiceExtensionManager.registerHandler(abstractOfferCustomServiceExtensionHandler);

    // Act
    ExtensionResultStatusType actualClearHiddenQualifiersResult =
        offerCustomServiceExtensionManager.clearHiddenQualifiers(new Entity());

    // Assert
    verify(abstractOfferCustomServiceExtensionHandler).clearHiddenQualifiers(isA(Entity.class));
    verify(abstractOfferCustomServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualClearHiddenQualifiersResult);
  }

  /**
   * Test {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   *
   * <p>Method under test: {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferCustomServiceExtensionManager.clearHiddenQualifiers(Entity)"
  })
  public void testClearHiddenQualifiers5() {
    // Arrange
    AbstractOfferCustomServiceExtensionHandler abstractOfferCustomServiceExtensionHandler =
        mock(AbstractOfferCustomServiceExtensionHandler.class);
    when(abstractOfferCustomServiceExtensionHandler.isEnabled()).thenReturn(false);

    OfferCustomServiceExtensionManager offerCustomServiceExtensionManager =
        new OfferCustomServiceExtensionManager();
    offerCustomServiceExtensionManager.registerHandler(abstractOfferCustomServiceExtensionHandler);

    // Act
    ExtensionResultStatusType actualClearHiddenQualifiersResult =
        offerCustomServiceExtensionManager.clearHiddenQualifiers(new Entity());

    // Assert
    verify(abstractOfferCustomServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualClearHiddenQualifiersResult);
  }

  /**
   * Test {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   *
   * <ul>
   *   <li>Given {@link OfferCustomServiceExtensionManager}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferCustomServiceExtensionManager.clearHiddenQualifiers(Entity)"
  })
  public void testClearHiddenQualifiers_givenOfferCustomServiceExtensionManager() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerCustomServiceExtensionManager.clearHiddenQualifiers(new Entity()));
  }

  /**
   * Test {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   *
   * <ul>
   *   <li>Given {@link OfferCustomServiceExtensionManager}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferCustomServiceExtensionManager.clearHiddenQualifiers(Entity)"
  })
  public void testClearHiddenQualifiers_givenOfferCustomServiceExtensionManager_whenNull() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        offerCustomServiceExtensionManager.clearHiddenQualifiers(null));
  }

  /**
   * Test {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link AbstractOfferCustomServiceExtensionHandler#getPriority()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferCustomServiceExtensionManager.clearHiddenQualifiers(Entity)"
  })
  public void testClearHiddenQualifiers_thenCallsGetPriority() {
    // Arrange
    AbstractOfferCustomServiceExtensionHandler abstractOfferCustomServiceExtensionHandler =
        mock(AbstractOfferCustomServiceExtensionHandler.class);
    when(abstractOfferCustomServiceExtensionHandler.getPriority()).thenReturn(1);
    when(abstractOfferCustomServiceExtensionHandler.clearHiddenQualifiers(Mockito.<Entity>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferCustomServiceExtensionHandler.isEnabled()).thenReturn(true);

    ArrayList<OfferCustomServiceExtensionHandler> handlers = new ArrayList<>();
    handlers.add(new AbstractOfferCustomServiceExtensionHandler());

    OfferCustomServiceExtensionManager offerCustomServiceExtensionManager =
        new OfferCustomServiceExtensionManager();
    offerCustomServiceExtensionManager.setHandlers(handlers);
    offerCustomServiceExtensionManager.registerHandler(abstractOfferCustomServiceExtensionHandler);

    // Act
    ExtensionResultStatusType actualClearHiddenQualifiersResult =
        offerCustomServiceExtensionManager.clearHiddenQualifiers(new Entity());

    // Assert
    verify(abstractOfferCustomServiceExtensionHandler).clearHiddenQualifiers(isA(Entity.class));
    verify(abstractOfferCustomServiceExtensionHandler).getPriority();
    verify(abstractOfferCustomServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualClearHiddenQualifiersResult);
  }

  /**
   * Test {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link AbstractOfferCustomServiceExtensionHandler#getPriority()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferCustomServiceExtensionManager#clearHiddenQualifiers(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType OfferCustomServiceExtensionManager.clearHiddenQualifiers(Entity)"
  })
  public void testClearHiddenQualifiers_thenCallsGetPriority2() {
    // Arrange
    AbstractOfferCustomServiceExtensionHandler abstractOfferCustomServiceExtensionHandler =
        mock(AbstractOfferCustomServiceExtensionHandler.class);
    when(abstractOfferCustomServiceExtensionHandler.getPriority()).thenReturn(1);
    when(abstractOfferCustomServiceExtensionHandler.clearHiddenQualifiers(Mockito.<Entity>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferCustomServiceExtensionHandler.isEnabled()).thenReturn(true);

    ArrayList<OfferCustomServiceExtensionHandler> handlers = new ArrayList<>();
    handlers.add(new AbstractOfferCustomServiceExtensionHandler());
    handlers.add(new AbstractOfferCustomServiceExtensionHandler());

    OfferCustomServiceExtensionManager offerCustomServiceExtensionManager =
        new OfferCustomServiceExtensionManager();
    offerCustomServiceExtensionManager.setHandlers(handlers);
    offerCustomServiceExtensionManager.registerHandler(abstractOfferCustomServiceExtensionHandler);

    // Act
    ExtensionResultStatusType actualClearHiddenQualifiersResult =
        offerCustomServiceExtensionManager.clearHiddenQualifiers(new Entity());

    // Assert
    verify(abstractOfferCustomServiceExtensionHandler).clearHiddenQualifiers(isA(Entity.class));
    verify(abstractOfferCustomServiceExtensionHandler).getPriority();
    verify(abstractOfferCustomServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualClearHiddenQualifiersResult);
  }

  /**
   * Test {@link OfferCustomServiceExtensionManager#isEnabled()}.
   *
   * <p>Method under test: {@link OfferCustomServiceExtensionManager#isEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferCustomServiceExtensionManager.isEnabled()"})
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue(new OfferCustomServiceExtensionManager().isEnabled());
  }
}
