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
package org.broadleafcommerce.common.web;

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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.TimeZone;
import javax.servlet.http.HttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {BroadleafTimeZoneResolverImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafTimeZoneResolverImplDiffblueTest {
  @Autowired private BroadleafTimeZoneResolverImpl broadleafTimeZoneResolverImpl;

  /**
   * Test {@link BroadleafTimeZoneResolverImpl#resolveTimeZone(WebRequest)}.
   *
   * <p>Method under test: {@link BroadleafTimeZoneResolverImpl#resolveTimeZone(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TimeZone BroadleafTimeZoneResolverImpl.resolveTimeZone(WebRequest)"})
  public void testResolveTimeZone() {
    // Arrange
    ServletWebRequest request =
        new ServletWebRequest(new HttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    broadleafTimeZoneResolverImpl.resolveTimeZone(request);

    // Assert
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(
        new String[] {"blTimeZone"}, ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link BroadleafTimeZoneResolverImpl#resolveTimeZone(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return ID is {@code GMT}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafTimeZoneResolverImpl#resolveTimeZone(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TimeZone BroadleafTimeZoneResolverImpl.resolveTimeZone(WebRequest)"})
  public void testResolveTimeZone_givenNull_thenReturnIdIsGmt() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(null);
    when(request.getHeader(Mockito.<String>any())).thenReturn("Header");
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());

    // Act
    TimeZone actualResolveTimeZoneResult = broadleafTimeZoneResolverImpl.resolveTimeZone(request);

    // Assert
    verify(request, atLeast(1)).getAttribute(Mockito.<String>any(), eq(0));
    verify(request).setAttribute(eq("blTimeZone"), isA(Object.class), eq(1));
    verify(request, atLeast(1)).getHeader("blTimeZoneCode");
    assertEquals("GMT", actualResolveTimeZoneResult.getID());
    assertEquals("Greenwich Mean Time", actualResolveTimeZoneResult.getDisplayName());
    assertEquals(0, actualResolveTimeZoneResult.getDSTSavings());
  }
}
