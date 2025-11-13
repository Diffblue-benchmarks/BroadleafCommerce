package org.broadleafcommerce.common.web.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;

public class BroadleafContextUtilDiffblueTest {
  /**
   * Test {@link BroadleafContextUtil#getContextName(HttpServletRequest)}.
   *
   * <p>Method under test: {@link BroadleafContextUtil#getContextName(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BroadleafContextUtil.getContextName(HttpServletRequest)"})
  public void testGetContextName() {
    // Arrange
    BroadleafContextUtil broadleafContextUtil = new BroadleafContextUtil();

    // Act and Assert
    assertEquals("localhost", broadleafContextUtil.getContextName(new MockHttpServletRequest()));
  }

  /**
   * Test {@link BroadleafContextUtil#readSecurityContextFromSession(HttpSession)}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafContextUtil#readSecurityContextFromSession(HttpSession)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecurityContext BroadleafContextUtil.readSecurityContextFromSession(HttpSession)"
  })
  public void testReadSecurityContextFromSession_givenNull_field() {
    // Arrange
    BroadleafContextUtil broadleafContextUtil = new BroadleafContextUtil();

    MockHttpSession httpSession = new MockHttpSession();
    httpSession.setAttribute("SPRING_SECURITY_CONTEXT", BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertNull(broadleafContextUtil.readSecurityContextFromSession(httpSession));
  }

  /**
   * Test {@link BroadleafContextUtil#readSecurityContextFromSession(HttpSession)}.
   *
   * <ul>
   *   <li>Then return {@link SecurityContextImpl}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafContextUtil#readSecurityContextFromSession(HttpSession)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecurityContext BroadleafContextUtil.readSecurityContextFromSession(HttpSession)"
  })
  public void testReadSecurityContextFromSession_thenReturnSecurityContextImpl() {
    // Arrange
    BroadleafContextUtil broadleafContextUtil = new BroadleafContextUtil();

    MockHttpSession httpSession = new MockHttpSession();
    SecurityContextImpl securityContextImpl = new SecurityContextImpl();
    httpSession.setAttribute("SPRING_SECURITY_CONTEXT", securityContextImpl);

    // Act
    SecurityContext actualReadSecurityContextFromSessionResult =
        broadleafContextUtil.readSecurityContextFromSession(httpSession);

    // Assert
    assertTrue(actualReadSecurityContextFromSessionResult instanceof SecurityContextImpl);
    assertNull(actualReadSecurityContextFromSessionResult.getAuthentication());
    assertSame(securityContextImpl, actualReadSecurityContextFromSessionResult);
  }

  /**
   * Test {@link BroadleafContextUtil#readSecurityContextFromSession(HttpSession)}.
   *
   * <ul>
   *   <li>When {@link MockHttpSession#MockHttpSession()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafContextUtil#readSecurityContextFromSession(HttpSession)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecurityContext BroadleafContextUtil.readSecurityContextFromSession(HttpSession)"
  })
  public void testReadSecurityContextFromSession_whenMockHttpSession_thenReturnNull() {
    // Arrange
    BroadleafContextUtil broadleafContextUtil = new BroadleafContextUtil();

    // Act and Assert
    assertNull(broadleafContextUtil.readSecurityContextFromSession(new MockHttpSession()));
  }

  /**
   * Test {@link BroadleafContextUtil#readSecurityContextFromSession(HttpSession)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafContextUtil#readSecurityContextFromSession(HttpSession)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecurityContext BroadleafContextUtil.readSecurityContextFromSession(HttpSession)"
  })
  public void testReadSecurityContextFromSession_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new BroadleafContextUtil().readSecurityContextFromSession(null));
  }
}
