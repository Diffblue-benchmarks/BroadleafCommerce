package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {JsonResponse.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class JsonResponseDiffblueTest {
  @MockBean private HttpServletResponse httpServletResponse;

  @Autowired private JsonResponse jsonResponse;

  /**
   * Test {@link JsonResponse#JsonResponse(HttpServletResponse)}.
   *
   * <p>Method under test: {@link JsonResponse#JsonResponse(HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JsonResponse.<init>(HttpServletResponse)"})
  public void testNewJsonResponse() {
    // Arrange, Act and Assert
    assertTrue(new JsonResponse(new MockHttpServletResponse()).map.isEmpty());
  }

  /**
   * Test {@link JsonResponse#with(String, Object)}.
   *
   * <p>Method under test: {@link JsonResponse#with(String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonResponse JsonResponse.with(String, Object)"})
  public void testWith() {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    JsonResponse actualWithResult = jsonResponse.with("Key", object);

    // Assert
    Map<String, Object> stringObjectMap = jsonResponse.map;
    assertEquals(1, stringObjectMap.size());
    assertSame(jsonResponse, actualWithResult);
    assertSame(object, stringObjectMap.get("Key"));
  }

  /**
   * Test {@link JsonResponse#done()}.
   *
   * <p>Method under test: {@link JsonResponse#done()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonResponse.done()"})
  public void testDone() throws UnsupportedEncodingException {
    // Arrange
    JsonResponse jsonResponse = new JsonResponse(new MockHttpServletResponse());

    // Act
    String actualDoneResult = jsonResponse.done();

    // Assert
    HttpServletResponse httpServletResponse = jsonResponse.response;
    Collection<String> headerNames = httpServletResponse.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertTrue(httpServletResponse instanceof MockHttpServletResponse);
    assertEquals("application/json", httpServletResponse.getContentType());
    assertEquals("{}", ((MockHttpServletResponse) httpServletResponse).getContentAsString());
    assertNull(actualDoneResult);
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(httpServletResponse.isCommitted());
    assertArrayEquals(
        new byte[] {'{', '}'},
        ((MockHttpServletResponse) httpServletResponse).getContentAsByteArray());
  }
}
