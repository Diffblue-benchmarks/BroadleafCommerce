package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {BroadleafRequestCustomerResolverImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafRequestCustomerResolverImplDiffblueTest {
  @Autowired private BroadleafRequestCustomerResolverImpl broadleafRequestCustomerResolverImpl;

  /**
   * Test {@link BroadleafRequestCustomerResolverImpl#getCustomer(HttpServletRequest)} with {@code
   * HttpServletRequest}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafRequestCustomerResolverImpl#getCustomer(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Object BroadleafRequestCustomerResolverImpl.getCustomer(HttpServletRequest)"
  })
  public void testGetCustomerWithHttpServletRequest_whenMockHttpServletRequest_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(broadleafRequestCustomerResolverImpl.getCustomer(new MockHttpServletRequest()));
  }

  /**
   * Test {@link BroadleafRequestCustomerResolverImpl#getCustomer(WebRequest)} with {@code
   * WebRequest}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestCustomerResolverImpl#getCustomer(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Object BroadleafRequestCustomerResolverImpl.getCustomer(WebRequest)"
  })
  public void testGetCustomerWithWebRequest_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        broadleafRequestCustomerResolverImpl.getCustomer(
            new ServletWebRequest(new MockHttpServletRequest())));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafRequestCustomerResolverImpl#setApplicationContext(ApplicationContext)}
   *   <li>{@link BroadleafRequestCustomerResolverImpl#setCustomerRequestAttributeName(String)}
   *   <li>{@link BroadleafRequestCustomerResolverImpl#getCustomerRequestAttributeName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafRequestCustomerResolverImpl.getCustomerRequestAttributeName()",
    "void BroadleafRequestCustomerResolverImpl.setApplicationContext(ApplicationContext)",
    "void BroadleafRequestCustomerResolverImpl.setCustomerRequestAttributeName(String)"
  })
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    BroadleafRequestCustomerResolverImpl broadleafRequestCustomerResolverImpl =
        new BroadleafRequestCustomerResolverImpl();

    // Act
    broadleafRequestCustomerResolverImpl.setApplicationContext(mock(ApplicationContext.class));
    broadleafRequestCustomerResolverImpl.setCustomerRequestAttributeName(
        "Customer Request Attribute Name");

    // Assert
    assertEquals(
        "Customer Request Attribute Name",
        broadleafRequestCustomerResolverImpl.getCustomerRequestAttributeName());
  }
}
