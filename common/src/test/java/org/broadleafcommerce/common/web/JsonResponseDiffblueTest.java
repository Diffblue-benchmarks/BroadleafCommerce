/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {JsonResponse.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class JsonResponseDiffblueTest {
  @MockBean
  private HttpServletResponse httpServletResponse;

  @Autowired
  private JsonResponse jsonResponse;

  /**
   * Test {@link JsonResponse#JsonResponse(HttpServletResponse)}.
   * <p>
   * Method under test: {@link JsonResponse#JsonResponse(HttpServletResponse)}
   */
  @Test
  public void testNewJsonResponse() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertTrue((new JsonResponse(new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())))).map.isEmpty());
  }

  /**
   * Test {@link JsonResponse#with(String, Object)}.
   * <p>
   * Method under test: {@link JsonResponse#with(String, Object)}
   */
  @Test
  public void testWith() {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    JsonResponse actualWithResult = jsonResponse.with("Key", object);

    // Assert
    Map<String, Object> stringObjectMap = actualWithResult.map;
    assertEquals(1, stringObjectMap.size());
    Map<String, Object> stringObjectMap2 = jsonResponse.map;
    assertEquals(1, stringObjectMap2.size());
    assertSame(jsonResponse, actualWithResult);
    assertSame(object, stringObjectMap.get("Key"));
    assertSame(object, stringObjectMap2.get("Key"));
  }

  /**
   * Test {@link JsonResponse#done()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonResponse#done()}
   */
  @Test
  public void testDone_thenThrowRuntimeException() throws IOException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new JsonResponse(new StatusExposingServletResponse(
            new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "").toFile()))))
                .done());
  }
}
