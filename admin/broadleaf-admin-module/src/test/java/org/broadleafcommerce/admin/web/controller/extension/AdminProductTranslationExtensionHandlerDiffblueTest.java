package org.broadleafcommerce.admin.web.controller.extension;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.web.controller.AdminTranslationControllerExtensionHandler;
import org.broadleafcommerce.openadmin.web.controller.AdminTranslationControllerExtensionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class AdminProductTranslationExtensionHandlerDiffblueTest {
  @InjectMocks
  private AdminProductTranslationExtensionHandler adminProductTranslationExtensionHandler;

  @Mock
  private AdminTranslationControllerExtensionManager adminTranslationControllerExtensionManager;

  /**
   * Test {@link AdminProductTranslationExtensionHandler#init()}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       AdminTranslationControllerExtensionManager#registerHandler(ExtensionHandler)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminProductTranslationExtensionHandler#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminProductTranslationExtensionHandler.init()"})
  public void testInit_thenCallsRegisterHandler() {
    // Arrange
    when(adminTranslationControllerExtensionManager.registerHandler(
            Mockito.<AdminTranslationControllerExtensionHandler>any()))
        .thenReturn(true);

    // Act
    adminProductTranslationExtensionHandler.init();

    // Assert
    verify(adminTranslationControllerExtensionManager)
        .registerHandler(isA(AdminTranslationControllerExtensionHandler.class));
  }
}
