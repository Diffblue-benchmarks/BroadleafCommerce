package org.broadleafcommerce.core.util.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl.CartPurgeParams;
import org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl.CustomerPurgeParams;
import org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl.PurgeErrorCache;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ResourcePurgeServiceImplDiffblueTest {
  @Autowired
  private ResourcePurgeServiceImpl resourcePurgeServiceImpl;

  /**
   * Test CartPurgeParams getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ResourcePurgeServiceImpl.CartPurgeParams#CartPurgeParams(ResourcePurgeServiceImpl, Map)}
   *   <li>{@link ResourcePurgeServiceImpl.CartPurgeParams#getBatchSize()}
   *   <li>
   * {@link ResourcePurgeServiceImpl.CartPurgeParams#getDateCreatedMinThreshold()}
   *   <li>{@link ResourcePurgeServiceImpl.CartPurgeParams#getFailedRetryTime()}
   *   <li>{@link ResourcePurgeServiceImpl.CartPurgeParams#getIsPreview()}
   *   <li>{@link ResourcePurgeServiceImpl.CartPurgeParams#getNameArray()}
   *   <li>{@link ResourcePurgeServiceImpl.CartPurgeParams#getStatusArray()}
   * </ul>
   */
  @Test
  public void testCartPurgeParamsGettersAndSetters() {
    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    // Act
    ResourcePurgeServiceImpl.CartPurgeParams actualCartPurgeParams = resourcePurgeServiceImpl.new CartPurgeParams(
        new HashMap<>());
    Long actualBatchSize = actualCartPurgeParams.getBatchSize();
    Date actualDateCreatedMinThreshold = actualCartPurgeParams.getDateCreatedMinThreshold();
    Long actualFailedRetryTime = actualCartPurgeParams.getFailedRetryTime();
    Boolean actualIsPreview = actualCartPurgeParams.getIsPreview();
    String[] actualNameArray = actualCartPurgeParams.getNameArray();

    // Assert
    assertNull(actualNameArray);
    assertNull(actualCartPurgeParams.getStatusArray());
    assertNull(actualIsPreview);
    assertNull(actualBatchSize);
    assertNull(actualFailedRetryTime);
    assertNull(actualDateCreatedMinThreshold);
  }

  /**
   * Test CartPurgeParams {@link CartPurgeParams#invoke()}.
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl.CartPurgeParams#invoke()}
   */
  @Test
  public void testCartPurgeParamsInvoke() {
    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();
    ResourcePurgeServiceImpl.CartPurgeParams cartPurgeParams = resourcePurgeServiceImpl.new CartPurgeParams(
        new HashMap<>());

    // Act
    ResourcePurgeServiceImpl.CartPurgeParams actualInvokeResult = cartPurgeParams.invoke();

    // Assert
    assertNull(cartPurgeParams.getIsPreview());
    assertEquals(1736867873990L, cartPurgeParams.getFailedRetryTime().longValue());
    assertEquals(50L, cartPurgeParams.getBatchSize().longValue());
    assertSame(cartPurgeParams, actualInvokeResult);
  }

  /**
   * Test CartPurgeParams {@link CartPurgeParams#invoke()}.
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl.CartPurgeParams#invoke()}
   */
  @Test
  public void testCartPurgeParamsInvoke2() {
    // Arrange
    HashMap<Object, Object> config = new HashMap<>();
    config.put("IS_PREVIEW", "42");
    ResourcePurgeServiceImpl.CartPurgeParams cartPurgeParams = (new ResourcePurgeServiceImpl()).new CartPurgeParams(
        config);

    // Act
    ResourcePurgeServiceImpl.CartPurgeParams actualInvokeResult = cartPurgeParams.invoke();

    // Assert
    assertEquals(1736867873990L, cartPurgeParams.getFailedRetryTime().longValue());
    assertEquals(50L, cartPurgeParams.getBatchSize().longValue());
    assertFalse(cartPurgeParams.getIsPreview());
    assertSame(cartPurgeParams, actualInvokeResult);
  }

  /**
   * Test CartPurgeParams {@link CartPurgeParams#invoke()}.
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl.CartPurgeParams#invoke()}
   */
  @Test
  public void testCartPurgeParamsInvoke3() {
    // Arrange
    HashMap<Object, Object> config = new HashMap<>();
    config.put("BATCH_SIZE", "42");
    ResourcePurgeServiceImpl.CartPurgeParams cartPurgeParams = (new ResourcePurgeServiceImpl()).new CartPurgeParams(
        config);

    // Act
    ResourcePurgeServiceImpl.CartPurgeParams actualInvokeResult = cartPurgeParams.invoke();

    // Assert
    assertNull(cartPurgeParams.getIsPreview());
    assertEquals(1736867873990L, cartPurgeParams.getFailedRetryTime().longValue());
    assertEquals(42L, cartPurgeParams.getBatchSize().longValue());
    assertSame(cartPurgeParams, actualInvokeResult);
  }

  /**
   * Test CartPurgeParams {@link CartPurgeParams#invoke()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl.CartPurgeParams#invoke()}
   */
  @Test
  public void testCartPurgeParamsInvoke_givenHashMap42Is42() {
    // Arrange
    HashMap<Object, Object> config = new HashMap<>();
    config.put("42", "42");
    ResourcePurgeServiceImpl.CartPurgeParams cartPurgeParams = (new ResourcePurgeServiceImpl()).new CartPurgeParams(
        config);

    // Act
    ResourcePurgeServiceImpl.CartPurgeParams actualInvokeResult = cartPurgeParams.invoke();

    // Assert
    assertNull(cartPurgeParams.getIsPreview());
    assertEquals(1736867873990L, cartPurgeParams.getFailedRetryTime().longValue());
    assertEquals(50L, cartPurgeParams.getBatchSize().longValue());
    assertSame(cartPurgeParams, actualInvokeResult);
  }

  /**
   * Test CartPurgeParams {@link CartPurgeParams#invoke()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code 42} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl.CartPurgeParams#invoke()}
   */
  @Test
  public void testCartPurgeParamsInvoke_givenHashMapComputeIfPresent42AndBiFunction() {
    // Arrange
    HashMap<Object, Object> config = new HashMap<>();
    config.computeIfPresent("42", mock(BiFunction.class));
    config.put("42", "42");
    ResourcePurgeServiceImpl.CartPurgeParams cartPurgeParams = (new ResourcePurgeServiceImpl()).new CartPurgeParams(
        config);

    // Act
    ResourcePurgeServiceImpl.CartPurgeParams actualInvokeResult = cartPurgeParams.invoke();

    // Assert
    assertNull(cartPurgeParams.getIsPreview());
    assertEquals(1736867873990L, cartPurgeParams.getFailedRetryTime().longValue());
    assertEquals(50L, cartPurgeParams.getBatchSize().longValue());
    assertSame(cartPurgeParams, actualInvokeResult);
  }

  /**
   * Test CartPurgeParams {@link CartPurgeParams#invoke()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code RETRY_FAILED_SECONDS} is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl.CartPurgeParams#invoke()}
   */
  @Test
  public void testCartPurgeParamsInvoke_givenHashMapRetryFailedSecondsIs42() {
    // Arrange
    HashMap<Object, Object> config = new HashMap<>();
    config.put("RETRY_FAILED_SECONDS", "42");
    ResourcePurgeServiceImpl.CartPurgeParams cartPurgeParams = (new ResourcePurgeServiceImpl()).new CartPurgeParams(
        config);

    // Act
    ResourcePurgeServiceImpl.CartPurgeParams actualInvokeResult = cartPurgeParams.invoke();

    // Assert
    assertNull(cartPurgeParams.getIsPreview());
    assertEquals(50L, cartPurgeParams.getBatchSize().longValue());
    assertSame(cartPurgeParams, actualInvokeResult);
  }

  /**
   * Test CartPurgeParams {@link CartPurgeParams#invoke()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code SECONDS_OLD} is {@code 42}.</li>
   *   <li>Then return IsPreview is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl.CartPurgeParams#invoke()}
   */
  @Test
  public void testCartPurgeParamsInvoke_givenHashMapSecondsOldIs42_thenReturnIsPreviewIsNull() {
    // Arrange
    HashMap<Object, Object> config = new HashMap<>();
    config.put("SECONDS_OLD", "42");

    // Act
    ResourcePurgeServiceImpl.CartPurgeParams actualInvokeResult = ((new ResourcePurgeServiceImpl()).new CartPurgeParams(
        config)).invoke();

    // Assert
    assertNull(actualInvokeResult.getNameArray());
    assertNull(actualInvokeResult.getStatusArray());
    assertNull(actualInvokeResult.getIsPreview());
    assertEquals(1736867873990L, actualInvokeResult.getFailedRetryTime().longValue());
    assertEquals(50L, actualInvokeResult.getBatchSize().longValue());
  }

  /**
   * Test CartPurgeParams {@link CartPurgeParams#invoke()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code STATUS} is {@code 42}.</li>
   *   <li>Then return first element is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl.CartPurgeParams#invoke()}
   */
  @Test
  public void testCartPurgeParamsInvoke_givenHashMapStatusIs42_thenReturnFirstElementIsNull() {
    // Arrange
    HashMap<Object, Object> config = new HashMap<>();
    config.put("STATUS", "42");

    // Act
    ResourcePurgeServiceImpl.CartPurgeParams actualInvokeResult = ((new ResourcePurgeServiceImpl()).new CartPurgeParams(
        config)).invoke();

    // Assert
    assertNull(actualInvokeResult.getNameArray());
    assertNull(actualInvokeResult.getDateCreatedMinThreshold());
    OrderStatus[] statusArray = actualInvokeResult.getStatusArray();
    assertNull(statusArray[0]);
    assertEquals(1, statusArray.length);
  }

  /**
   * Test CartPurgeParams {@link CartPurgeParams#invoke()}.
   * <ul>
   *   <li>Then return NameArray is array of {@link String} with {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl.CartPurgeParams#invoke()}
   */
  @Test
  public void testCartPurgeParamsInvoke_thenReturnNameArrayIsArrayOfStringWith42() {
    // Arrange
    HashMap<Object, Object> config = new HashMap<>();
    config.put("NAME", "42");

    // Act
    ResourcePurgeServiceImpl.CartPurgeParams actualInvokeResult = ((new ResourcePurgeServiceImpl()).new CartPurgeParams(
        config)).invoke();

    // Assert
    assertNull(actualInvokeResult.getStatusArray());
    assertNull(actualInvokeResult.getDateCreatedMinThreshold());
    assertArrayEquals(new String[]{"42"}, actualInvokeResult.getNameArray());
  }

  /**
   * Test CustomerPurgeParams getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ResourcePurgeServiceImpl.CustomerPurgeParams#CustomerPurgeParams(ResourcePurgeServiceImpl, Map)}
   *   <li>{@link ResourcePurgeServiceImpl.CustomerPurgeParams#getBatchSize()}
   *   <li>
   * {@link ResourcePurgeServiceImpl.CustomerPurgeParams#getDateCreatedMinThreshold()}
   *   <li>{@link ResourcePurgeServiceImpl.CustomerPurgeParams#getFailedRetryTime()}
   *   <li>{@link ResourcePurgeServiceImpl.CustomerPurgeParams#getIsDeactivated()}
   *   <li>{@link ResourcePurgeServiceImpl.CustomerPurgeParams#getIsPreview()}
   *   <li>{@link ResourcePurgeServiceImpl.CustomerPurgeParams#getIsRegistered()}
   * </ul>
   */
  @Test
  public void testCustomerPurgeParamsGettersAndSetters() {
    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    // Act
    ResourcePurgeServiceImpl.CustomerPurgeParams actualCustomerPurgeParams = resourcePurgeServiceImpl.new CustomerPurgeParams(
        new HashMap<>());
    Long actualBatchSize = actualCustomerPurgeParams.getBatchSize();
    Date actualDateCreatedMinThreshold = actualCustomerPurgeParams.getDateCreatedMinThreshold();
    Long actualFailedRetryTime = actualCustomerPurgeParams.getFailedRetryTime();
    Boolean actualIsDeactivated = actualCustomerPurgeParams.getIsDeactivated();
    Boolean actualIsPreview = actualCustomerPurgeParams.getIsPreview();

    // Assert
    assertNull(actualIsDeactivated);
    assertNull(actualIsPreview);
    assertNull(actualCustomerPurgeParams.getIsRegistered());
    assertNull(actualBatchSize);
    assertNull(actualFailedRetryTime);
    assertNull(actualDateCreatedMinThreshold);
  }

  /**
   * Test CustomerPurgeParams {@link CustomerPurgeParams#invoke()}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl.CustomerPurgeParams#invoke()}
   */
  @Test
  public void testCustomerPurgeParamsInvoke() {
    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();
    ResourcePurgeServiceImpl.CustomerPurgeParams customerPurgeParams = resourcePurgeServiceImpl.new CustomerPurgeParams(
        new HashMap<>());

    // Act
    customerPurgeParams.invoke();

    // Assert
    assertNull(customerPurgeParams.getIsDeactivated());
    assertNull(customerPurgeParams.getIsPreview());
    assertNull(customerPurgeParams.getIsRegistered());
    assertEquals(1736867873990L, customerPurgeParams.getFailedRetryTime().longValue());
    assertEquals(50L, customerPurgeParams.getBatchSize().longValue());
  }

  /**
   * Test CustomerPurgeParams {@link CustomerPurgeParams#invoke()}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl.CustomerPurgeParams#invoke()}
   */
  @Test
  public void testCustomerPurgeParamsInvoke2() {
    // Arrange
    HashMap<Object, Object> config = new HashMap<>();
    config.put("IS_REGISTERED", "42");
    ResourcePurgeServiceImpl.CustomerPurgeParams customerPurgeParams = (new ResourcePurgeServiceImpl()).new CustomerPurgeParams(
        config);

    // Act
    customerPurgeParams.invoke();

    // Assert
    assertNull(customerPurgeParams.getIsDeactivated());
    assertNull(customerPurgeParams.getIsPreview());
    assertEquals(1736867873990L, customerPurgeParams.getFailedRetryTime().longValue());
    assertEquals(50L, customerPurgeParams.getBatchSize().longValue());
    assertFalse(customerPurgeParams.getIsRegistered());
  }

  /**
   * Test CustomerPurgeParams {@link CustomerPurgeParams#invoke()}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl.CustomerPurgeParams#invoke()}
   */
  @Test
  public void testCustomerPurgeParamsInvoke3() {
    // Arrange
    HashMap<Object, Object> config = new HashMap<>();
    config.put("IS_DEACTIVATED", "42");
    ResourcePurgeServiceImpl.CustomerPurgeParams customerPurgeParams = (new ResourcePurgeServiceImpl()).new CustomerPurgeParams(
        config);

    // Act
    customerPurgeParams.invoke();

    // Assert
    assertNull(customerPurgeParams.getIsPreview());
    assertNull(customerPurgeParams.getIsRegistered());
    assertEquals(1736867873990L, customerPurgeParams.getFailedRetryTime().longValue());
    assertEquals(50L, customerPurgeParams.getBatchSize().longValue());
    assertFalse(customerPurgeParams.getIsDeactivated());
  }

  /**
   * Test CustomerPurgeParams {@link CustomerPurgeParams#invoke()}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl.CustomerPurgeParams#invoke()}
   */
  @Test
  public void testCustomerPurgeParamsInvoke4() {
    // Arrange
    HashMap<Object, Object> config = new HashMap<>();
    config.put("IS_PREVIEW", "42");
    ResourcePurgeServiceImpl.CustomerPurgeParams customerPurgeParams = (new ResourcePurgeServiceImpl()).new CustomerPurgeParams(
        config);

    // Act
    customerPurgeParams.invoke();

    // Assert
    assertNull(customerPurgeParams.getIsDeactivated());
    assertNull(customerPurgeParams.getIsRegistered());
    assertEquals(1736867873990L, customerPurgeParams.getFailedRetryTime().longValue());
    assertEquals(50L, customerPurgeParams.getBatchSize().longValue());
    assertFalse(customerPurgeParams.getIsPreview());
  }

  /**
   * Test CustomerPurgeParams {@link CustomerPurgeParams#invoke()}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl.CustomerPurgeParams#invoke()}
   */
  @Test
  public void testCustomerPurgeParamsInvoke5() {
    // Arrange
    HashMap<Object, Object> config = new HashMap<>();
    config.put("BATCH_SIZE", "42");
    ResourcePurgeServiceImpl.CustomerPurgeParams customerPurgeParams = (new ResourcePurgeServiceImpl()).new CustomerPurgeParams(
        config);

    // Act
    customerPurgeParams.invoke();

    // Assert
    assertNull(customerPurgeParams.getIsDeactivated());
    assertNull(customerPurgeParams.getIsPreview());
    assertNull(customerPurgeParams.getIsRegistered());
    assertEquals(1736867873990L, customerPurgeParams.getFailedRetryTime().longValue());
    assertEquals(42L, customerPurgeParams.getBatchSize().longValue());
  }

  /**
   * Test CustomerPurgeParams {@link CustomerPurgeParams#invoke()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl.CustomerPurgeParams#invoke()}
   */
  @Test
  public void testCustomerPurgeParamsInvoke_givenHashMap42Is42() {
    // Arrange
    HashMap<Object, Object> config = new HashMap<>();
    config.put("42", "42");
    ResourcePurgeServiceImpl.CustomerPurgeParams customerPurgeParams = (new ResourcePurgeServiceImpl()).new CustomerPurgeParams(
        config);

    // Act
    customerPurgeParams.invoke();

    // Assert
    assertNull(customerPurgeParams.getIsDeactivated());
    assertNull(customerPurgeParams.getIsPreview());
    assertNull(customerPurgeParams.getIsRegistered());
    assertEquals(1736867873990L, customerPurgeParams.getFailedRetryTime().longValue());
    assertEquals(50L, customerPurgeParams.getBatchSize().longValue());
  }

  /**
   * Test CustomerPurgeParams {@link CustomerPurgeParams#invoke()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code 42} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl.CustomerPurgeParams#invoke()}
   */
  @Test
  public void testCustomerPurgeParamsInvoke_givenHashMapComputeIfPresent42AndBiFunction() {
    // Arrange
    HashMap<Object, Object> config = new HashMap<>();
    config.computeIfPresent("42", mock(BiFunction.class));
    config.put("42", "42");
    ResourcePurgeServiceImpl.CustomerPurgeParams customerPurgeParams = (new ResourcePurgeServiceImpl()).new CustomerPurgeParams(
        config);

    // Act
    customerPurgeParams.invoke();

    // Assert
    assertNull(customerPurgeParams.getIsDeactivated());
    assertNull(customerPurgeParams.getIsPreview());
    assertNull(customerPurgeParams.getIsRegistered());
    assertEquals(1736867873990L, customerPurgeParams.getFailedRetryTime().longValue());
    assertEquals(50L, customerPurgeParams.getBatchSize().longValue());
  }

  /**
   * Test CustomerPurgeParams {@link CustomerPurgeParams#invoke()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code RETRY_FAILED_SECONDS} is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl.CustomerPurgeParams#invoke()}
   */
  @Test
  public void testCustomerPurgeParamsInvoke_givenHashMapRetryFailedSecondsIs42() {
    // Arrange
    HashMap<Object, Object> config = new HashMap<>();
    config.put("RETRY_FAILED_SECONDS", "42");
    ResourcePurgeServiceImpl.CustomerPurgeParams customerPurgeParams = (new ResourcePurgeServiceImpl()).new CustomerPurgeParams(
        config);

    // Act
    customerPurgeParams.invoke();

    // Assert
    assertNull(customerPurgeParams.getIsDeactivated());
    assertNull(customerPurgeParams.getIsPreview());
    assertNull(customerPurgeParams.getIsRegistered());
    assertEquals(50L, customerPurgeParams.getBatchSize().longValue());
  }

  /**
   * Test CustomerPurgeParams {@link CustomerPurgeParams#invoke()}.
   * <ul>
   *   <li>Then return IsDeactivated is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl.CustomerPurgeParams#invoke()}
   */
  @Test
  public void testCustomerPurgeParamsInvoke_thenReturnIsDeactivatedIsNull() {
    // Arrange
    HashMap<Object, Object> config = new HashMap<>();
    config.put("SECONDS_OLD", "42");

    // Act
    ResourcePurgeServiceImpl.CustomerPurgeParams actualInvokeResult = ((new ResourcePurgeServiceImpl()).new CustomerPurgeParams(
        config)).invoke();

    // Assert
    assertNull(actualInvokeResult.getIsDeactivated());
    assertNull(actualInvokeResult.getIsPreview());
    assertNull(actualInvokeResult.getIsRegistered());
    assertEquals(1736867873990L, actualInvokeResult.getFailedRetryTime().longValue());
    assertEquals(50L, actualInvokeResult.getBatchSize().longValue());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPurgeCarts() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass173 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl resourcePurgeServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl2 = new ResourcePurgeServiceImpl();

    // Act
    resourcePurgeServiceImpl2.purgeCarts(new HashMap<>());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCarts(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#purgeCarts(Map)}
   */
  @Test
  public void testPurgeCarts_whenHashMap_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourcePurgeServiceImpl.purgeCarts(new HashMap<>()));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCarts(Map)}.
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#notifyCarts(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNotifyCarts() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass165 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl resourcePurgeServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl2 = new ResourcePurgeServiceImpl();

    // Act
    resourcePurgeServiceImpl2.notifyCarts(new HashMap<>());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCarts(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#notifyCarts(Map)}
   */
  @Test
  public void testNotifyCarts_whenHashMap_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourcePurgeServiceImpl.notifyCarts(new HashMap<>()));
  }

  /**
   * Test PurgeErrorCache {@link PurgeErrorCache#add(Long)}.
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl.PurgeErrorCache#add(Long)}
   */
  @Test
  public void testPurgeErrorCacheAdd() {
    // Arrange
    ResourcePurgeServiceImpl.PurgeErrorCache purgeErrorCache = (new ResourcePurgeServiceImpl()).new PurgeErrorCache();
    purgeErrorCache.add(1L);

    // Act and Assert
    assertNull(purgeErrorCache.add(1L));
    assertEquals(1, purgeErrorCache.size());
  }

  /**
   * Test PurgeErrorCache {@link PurgeErrorCache#add(Long)}.
   * <ul>
   *   <li>Given {@link PurgeErrorCache#PurgeErrorCache(ResourcePurgeServiceImpl)}
   * with this$0 is {@link ResourcePurgeServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl.PurgeErrorCache#add(Long)}
   */
  @Test
  public void testPurgeErrorCacheAdd_givenPurgeErrorCacheWithThis$0IsResourcePurgeServiceImpl() {
    // Arrange
    ResourcePurgeServiceImpl.PurgeErrorCache purgeErrorCache = (new ResourcePurgeServiceImpl()).new PurgeErrorCache();

    // Act and Assert
    assertNull(purgeErrorCache.add(1L));
    assertEquals(1, purgeErrorCache.size());
  }

  /**
   * Test PurgeErrorCache {@link PurgeErrorCache#getEntriesSince(long)}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl.PurgeErrorCache#getEntriesSince(long)}
   */
  @Test
  public void testPurgeErrorCacheGetEntriesSince() {
    // Arrange
    ResourcePurgeServiceImpl.PurgeErrorCache purgeErrorCache = (new ResourcePurgeServiceImpl()).new PurgeErrorCache();

    // Act
    Set<Long> actualEntriesSince = purgeErrorCache.getEntriesSince(1L);

    // Assert
    assertEquals(0, purgeErrorCache.size());
    assertTrue(actualEntriesSince.isEmpty());
  }

  /**
   * Test PurgeErrorCache {@link PurgeErrorCache#getEntriesSince(long)}.
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl.PurgeErrorCache#getEntriesSince(long)}
   */
  @Test
  public void testPurgeErrorCacheGetEntriesSince_whenMax_value() {
    // Arrange
    ResourcePurgeServiceImpl.PurgeErrorCache purgeErrorCache = (new ResourcePurgeServiceImpl()).new PurgeErrorCache();
    purgeErrorCache.add(1L);

    // Act
    Set<Long> actualEntriesSince = purgeErrorCache.getEntriesSince(Long.MAX_VALUE);

    // Assert
    assertEquals(0, purgeErrorCache.size());
    assertTrue(actualEntriesSince.isEmpty());
  }

  /**
   * Test PurgeErrorCache
   * {@link PurgeErrorCache#PurgeErrorCache(ResourcePurgeServiceImpl)}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl.PurgeErrorCache#PurgeErrorCache(ResourcePurgeServiceImpl)}
   */
  @Test
  public void testPurgeErrorCacheNewPurgeErrorCache() {
    // Arrange, Act and Assert
    assertEquals(0, ((new ResourcePurgeServiceImpl()).new PurgeErrorCache()).size());
  }

  /**
   * Test PurgeErrorCache {@link PurgeErrorCache#size()}.
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl.PurgeErrorCache#size()}
   */
  @Test
  public void testPurgeErrorCacheSize() {
    // Arrange, Act and Assert
    assertEquals(0, ((new ResourcePurgeServiceImpl()).new PurgeErrorCache()).size());
  }

  /**
   * Test
   * {@link ResourcePurgeServiceImpl#purgeOrderHistory(Class, String, Map, Map)}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl#purgeOrderHistory(Class, String, Map, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPurgeOrderHistory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass189 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl resourcePurgeServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl2 = new ResourcePurgeServiceImpl();
    Class<Object> rootType = Object.class;
    HashMap<String, List<DeleteStatementGeneratorImpl.PathElement>> depends = new HashMap<>();

    // Act
    resourcePurgeServiceImpl2.purgeOrderHistory(rootType, "42", depends, new HashMap<>());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPurgeCustomers() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass181 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl resourcePurgeServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl2 = new ResourcePurgeServiceImpl();

    // Act
    resourcePurgeServiceImpl2.purgeCustomers(new HashMap<>());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#purgeCustomers(Map)}
   */
  @Test
  public void testPurgeCustomers_whenHashMap_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resourcePurgeServiceImpl.purgeCustomers(new HashMap<>()));
  }

  /**
   * Test
   * {@link ResourcePurgeServiceImpl#getCartsInErrorToIgnore(CartPurgeParams)}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl#getCartsInErrorToIgnore(ResourcePurgeServiceImpl.CartPurgeParams)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCartsInErrorToIgnore() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass43 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl resourcePurgeServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl2 = new ResourcePurgeServiceImpl();
    ResourcePurgeServiceImpl resourcePurgeServiceImpl3 = new ResourcePurgeServiceImpl();

    // Act
    resourcePurgeServiceImpl2.getCartsInErrorToIgnore(resourcePurgeServiceImpl3.new CartPurgeParams(new HashMap<>()));
  }

  /**
   * Test
   * {@link ResourcePurgeServiceImpl#getCartsInErrorToIgnore(CartPurgeParams)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl#getCartsInErrorToIgnore(ResourcePurgeServiceImpl.CartPurgeParams)}
   */
  @Test
  public void testGetCartsInErrorToIgnore_givenOne_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();
    ResourcePurgeServiceImpl.CartPurgeParams purgeParams = mock(ResourcePurgeServiceImpl.CartPurgeParams.class);
    when(purgeParams.getFailedRetryTime()).thenReturn(1L);

    // Act
    Set<Long> actualCartsInErrorToIgnore = resourcePurgeServiceImpl.getCartsInErrorToIgnore(purgeParams);

    // Assert
    verify(purgeParams).getFailedRetryTime();
    assertTrue(actualCartsInErrorToIgnore.isEmpty());
  }

  /**
   * Test
   * {@link ResourcePurgeServiceImpl#getCartsToPurge(CartPurgeParams, int, int, List)}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl#getCartsToPurge(ResourcePurgeServiceImpl.CartPurgeParams, int, int, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCartsToPurge() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass54 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl resourcePurgeServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl2 = new ResourcePurgeServiceImpl();
    ResourcePurgeServiceImpl resourcePurgeServiceImpl3 = new ResourcePurgeServiceImpl();
    ResourcePurgeServiceImpl.CartPurgeParams purgeParams = resourcePurgeServiceImpl3.new CartPurgeParams(
        new HashMap<>());

    // Act
    resourcePurgeServiceImpl2.getCartsToPurge(purgeParams, 1, 3, new ArrayList<>());
  }

  /**
   * Test
   * {@link ResourcePurgeServiceImpl#getCartsToPurgeLength(CartPurgeParams, List)}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl#getCartsToPurgeLength(ResourcePurgeServiceImpl.CartPurgeParams, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCartsToPurgeLength() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass76 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl resourcePurgeServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl2 = new ResourcePurgeServiceImpl();
    ResourcePurgeServiceImpl resourcePurgeServiceImpl3 = new ResourcePurgeServiceImpl();
    ResourcePurgeServiceImpl.CartPurgeParams purgeParams = resourcePurgeServiceImpl3.new CartPurgeParams(
        new HashMap<>());

    // Act
    resourcePurgeServiceImpl2.getCartsToPurgeLength(purgeParams, new ArrayList<>());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#notifyCart(Order)}.
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#notifyCart(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNotifyCart() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass152 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl resourcePurgeServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl2 = new ResourcePurgeServiceImpl();

    // Act
    resourcePurgeServiceImpl2.notifyCart(new NullOrderImpl());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}.
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetEmailForCart() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass139 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl resourcePurgeServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl2 = new ResourcePurgeServiceImpl();

    // Act
    resourcePurgeServiceImpl2.getEmailForCart(new NullOrderImpl());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}.
   * <ul>
   *   <li>Given {@code 42 Main St}.</li>
   *   <li>Then return {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}
   */
  @Test
  public void testGetEmailForCart_given42MainSt_thenReturn42MainSt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();
    NullOrderImpl cart = mock(NullOrderImpl.class);
    when(cart.getEmailAddress()).thenReturn("42 Main St");

    // Act
    String actualEmailForCart = resourcePurgeServiceImpl.getEmailForCart(cart);

    // Assert
    verify(cart, atLeast(1)).getEmailAddress();
    assertEquals("42 Main St", actualEmailForCart);
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}.
   * <ul>
   *   <li>Given {@code Cart}.</li>
   *   <li>When {@link OrderImpl} (default constructor) EmailAddress is
   * {@code Cart}.</li>
   *   <li>Then return {@code Cart}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}
   */
  @Test
  public void testGetEmailForCart_givenCart_whenOrderImplEmailAddressIsCart_thenReturnCart() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalShipping(new Money());
    cart.setTotalTax(new Money());
    cart.setEmailAddress("Cart");
    cart.setCustomer(null);

    // Act and Assert
    assertEquals("Cart", resourcePurgeServiceImpl.getEmailForCart(cart));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor) Auditable is
   * {@link Auditable} (default constructor).</li>
   *   <li>Then return {@code Cart}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}
   */
  @Test
  public void testGetEmailForCart_givenCustomerImplAuditableIsAuditable_thenReturnCart() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setEmailAddress("Cart");

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalShipping(new Money());
    cart.setTotalTax(new Money());
    cart.setEmailAddress(null);
    cart.setCustomer(customer);

    // Act and Assert
    assertEquals("Cart", resourcePurgeServiceImpl.getEmailForCart(cart));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}
   */
  @Test
  public void testGetEmailForCart_givenCustomerImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalShipping(new Money());
    cart.setTotalTax(new Money());
    cart.setEmailAddress(null);
    cart.setCustomer(new CustomerImpl());

    // Act and Assert
    assertNull(resourcePurgeServiceImpl.getEmailForCart(cart));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#getEmailForCart(Order)}
   */
  @Test
  public void testGetEmailForCart_whenNullOrderImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();

    // Act and Assert
    assertNull(resourcePurgeServiceImpl.getEmailForCart(new NullOrderImpl()));
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#deleteCart(Order)}.
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#deleteCart(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteCart() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl resourcePurgeServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl2 = new ResourcePurgeServiceImpl();

    // Act
    resourcePurgeServiceImpl2.deleteCart(new NullOrderImpl());
  }

  /**
   * Test
   * {@link ResourcePurgeServiceImpl#getCustomersInErrorToIgnore(CustomerPurgeParams)}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl#getCustomersInErrorToIgnore(ResourcePurgeServiceImpl.CustomerPurgeParams)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCustomersInErrorToIgnore() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass91 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl resourcePurgeServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl2 = new ResourcePurgeServiceImpl();
    ResourcePurgeServiceImpl resourcePurgeServiceImpl3 = new ResourcePurgeServiceImpl();

    // Act
    resourcePurgeServiceImpl2
        .getCustomersInErrorToIgnore(resourcePurgeServiceImpl3.new CustomerPurgeParams(new HashMap<>()));
  }

  /**
   * Test
   * {@link ResourcePurgeServiceImpl#getCustomersInErrorToIgnore(CustomerPurgeParams)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl#getCustomersInErrorToIgnore(ResourcePurgeServiceImpl.CustomerPurgeParams)}
   */
  @Test
  public void testGetCustomersInErrorToIgnore_givenOne_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl = new ResourcePurgeServiceImpl();
    ResourcePurgeServiceImpl.CustomerPurgeParams purgeParams = mock(ResourcePurgeServiceImpl.CustomerPurgeParams.class);
    when(purgeParams.getFailedRetryTime()).thenReturn(1L);

    // Act
    Set<Long> actualCustomersInErrorToIgnore = resourcePurgeServiceImpl.getCustomersInErrorToIgnore(purgeParams);

    // Assert
    verify(purgeParams).getFailedRetryTime();
    assertTrue(actualCustomersInErrorToIgnore.isEmpty());
  }

  /**
   * Test
   * {@link ResourcePurgeServiceImpl#getCustomersToPurge(CustomerPurgeParams, int, int, List)}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl#getCustomersToPurge(ResourcePurgeServiceImpl.CustomerPurgeParams, int, int, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCustomersToPurge() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass102 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl resourcePurgeServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl2 = new ResourcePurgeServiceImpl();
    ResourcePurgeServiceImpl resourcePurgeServiceImpl3 = new ResourcePurgeServiceImpl();
    ResourcePurgeServiceImpl.CustomerPurgeParams purgeParams = resourcePurgeServiceImpl3.new CustomerPurgeParams(
        new HashMap<>());

    // Act
    resourcePurgeServiceImpl2.getCustomersToPurge(purgeParams, 1, 3, new ArrayList<>());
  }

  /**
   * Test
   * {@link ResourcePurgeServiceImpl#getCustomersToPurgeLength(CustomerPurgeParams, List)}.
   * <p>
   * Method under test:
   * {@link ResourcePurgeServiceImpl#getCustomersToPurgeLength(ResourcePurgeServiceImpl.CustomerPurgeParams, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCustomersToPurgeLength() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass124 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl resourcePurgeServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl2 = new ResourcePurgeServiceImpl();
    ResourcePurgeServiceImpl resourcePurgeServiceImpl3 = new ResourcePurgeServiceImpl();
    ResourcePurgeServiceImpl.CustomerPurgeParams purgeParams = resourcePurgeServiceImpl3.new CustomerPurgeParams(
        new HashMap<>());

    // Act
    resourcePurgeServiceImpl2.getCustomersToPurgeLength(purgeParams, new ArrayList<>());
  }

  /**
   * Test {@link ResourcePurgeServiceImpl#deleteCustomer(Customer)}.
   * <p>
   * Method under test: {@link ResourcePurgeServiceImpl#deleteCustomer(Customer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteCustomer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.service.ResourcePurgeServiceImpl resourcePurgeServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ResourcePurgeServiceImpl resourcePurgeServiceImpl2 = new ResourcePurgeServiceImpl();

    // Act
    resourcePurgeServiceImpl2.deleteCustomer(new CustomerImpl());
  }
}
