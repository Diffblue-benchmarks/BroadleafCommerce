package org.broadleafcommerce.profile.web.core.service.login;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LoginServiceImplDiffblueTest {
  /**
   * Test {@link LoginServiceImpl#getWebRequest()}.
   *
   * <p>Method under test: {@link LoginServiceImpl#getWebRequest()}
   */
  @Test
  @DisplayName("Test getWebRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.WebRequest LoginServiceImpl.getWebRequest()"
  })
  void testGetWebRequest() {
    // Arrange, Act and Assert
    assertNull(new LoginServiceImpl().getWebRequest());
  }
}
