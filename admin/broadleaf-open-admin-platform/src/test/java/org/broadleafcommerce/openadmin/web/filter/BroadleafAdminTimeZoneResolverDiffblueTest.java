package org.broadleafcommerce.openadmin.web.filter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.TimeZone;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafAdminTimeZoneResolverDiffblueTest {
  @Autowired
  private BroadleafAdminTimeZoneResolver broadleafAdminTimeZoneResolver;

  /**
   * Test {@link BroadleafAdminTimeZoneResolver#resolveTimeZone(WebRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafAdminTimeZoneResolver#resolveTimeZone(WebRequest)}
   */
  @Test
  public void testResolveTimeZone() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTimeZoneResolver broadleafAdminTimeZoneResolver = new BroadleafAdminTimeZoneResolver();
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));

    // Act
    broadleafAdminTimeZoneResolver.resolveTimeZone(request);

    // Assert
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(new String[]{"blTimeZone"}, ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link BroadleafAdminTimeZoneResolver#resolveTimeZone(WebRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafAdminTimeZoneResolver#resolveTimeZone(WebRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResolveTimeZone2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.filter;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3060 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.filter.BroadleafAdminTimeZoneResolver broadleafAdminTimeZoneResolver;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BroadleafAdminTimeZoneResolver broadleafAdminTimeZoneResolver2 = new BroadleafAdminTimeZoneResolver();

    // Act
    broadleafAdminTimeZoneResolver2
        .resolveTimeZone(new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Test {@link BroadleafAdminTimeZoneResolver#resolveTimeZone(WebRequest)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return ID is {@code GMT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAdminTimeZoneResolver#resolveTimeZone(WebRequest)}
   */
  @Test
  public void testResolveTimeZone_givenNull_thenReturnIdIsGmt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminTimeZoneResolver broadleafAdminTimeZoneResolver = new BroadleafAdminTimeZoneResolver();
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(null);
    when(request.getHeader(Mockito.<String>any())).thenReturn("Header");
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());

    // Act
    TimeZone actualResolveTimeZoneResult = broadleafAdminTimeZoneResolver.resolveTimeZone(request);

    // Assert
    verify(request, atLeast(1)).getAttribute(Mockito.<String>any(), eq(0));
    verify(request).setAttribute(eq("blTimeZone"), isA(Object.class), eq(1));
    verify(request, atLeast(1)).getHeader(eq("blTimeZoneCode"));
    assertEquals("GMT", actualResolveTimeZoneResult.getID());
    assertEquals("Greenwich Mean Time", actualResolveTimeZoneResult.getDisplayName());
    assertEquals(0, actualResolveTimeZoneResult.getDSTSavings());
  }
}
