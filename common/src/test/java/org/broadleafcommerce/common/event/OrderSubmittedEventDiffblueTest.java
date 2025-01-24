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
package org.broadleafcommerce.common.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Map;
import java.util.TimeZone;
import org.broadleafcommerce.common.classloader.release.ThreadLocalManager;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.event.BroadleafApplicationEvent.ContextVars;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OrderSubmittedEvent.class, Object.class, Long.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderSubmittedEventDiffblueTest {
  @Autowired
  private OrderSubmittedEvent orderSubmittedEvent;

  /**
   * Test {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}.
   * <p>
   * Method under test:
   * {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewOrderSubmittedEvent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - java.lang.Object
    //   when running class:
    //   package org.broadleafcommerce.common.event;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.common.event.OrderSubmittedEvent.class,java.lang.Object.class,java.lang.Long.class,java.lang.String.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.common.event.OrderSubmittedEvent orderSubmittedEvent;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new OrderSubmittedEvent(BLCFieldUtils.NULL_FIELD, 1L, "42");

  }

  /**
   * Test {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}.
   * <ul>
   *   <li>Given {@link CatalogImpl} (default constructor).</li>
   *   <li>Then return Context {@link ContextVars#CATALOG_ID} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}
   */
  @Test
  public void testNewOrderSubmittedEvent_givenCatalogImpl_thenReturnContextCatalog_idIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestContext broadleafRequestContext = BroadleafRequestContext.getBroadleafRequestContext(true);
    CatalogImpl currentCatalog = new CatalogImpl();
    broadleafRequestContext.setCurrentCatalog(currentCatalog);

    // Act
    OrderSubmittedEvent actualOrderSubmittedEvent = new OrderSubmittedEvent(broadleafRequestContext, 1L, "42");

    // Assert
    Object source = actualOrderSubmittedEvent.getSource();
    assertTrue(source instanceof BroadleafRequestContext);
    Map<String, Object> context = actualOrderSubmittedEvent.getContext();
    assertEquals(1, context.size());
    assertNull(context.get(BroadleafApplicationEvent.ContextVars.CATALOG_ID));
    assertSame(currentCatalog, ((BroadleafRequestContext) source).getCurrentCatalog());
  }

  /**
   * Test {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}.
   * <ul>
   *   <li>Then return Context {@link ContextVars#CURRENCY_CODE} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}
   */
  @Test
  public void testNewOrderSubmittedEvent_thenReturnContextCurrency_codeIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestContext broadleafRequestContext = BroadleafRequestContext.getBroadleafRequestContext(true);
    BroadleafCurrencyImpl broadleafCurrency = new BroadleafCurrencyImpl();
    broadleafRequestContext.setBroadleafCurrency(broadleafCurrency);

    // Act
    OrderSubmittedEvent actualOrderSubmittedEvent = new OrderSubmittedEvent(broadleafRequestContext, 1L, "42");

    // Assert
    Object source = actualOrderSubmittedEvent.getSource();
    assertTrue(source instanceof BroadleafRequestContext);
    Map<String, Object> context = actualOrderSubmittedEvent.getContext();
    assertEquals(1, context.size());
    assertNull(context.get(BroadleafApplicationEvent.ContextVars.CURRENCY_CODE));
    assertSame(broadleafCurrency, ((BroadleafRequestContext) source).getBroadleafCurrency());
  }

  /**
   * Test {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}.
   * <ul>
   *   <li>Then return Context {@link ContextVars#PROFILE_ID} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}
   */
  @Test
  public void testNewOrderSubmittedEvent_thenReturnContextProfile_idIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestContext broadleafRequestContext = BroadleafRequestContext.getBroadleafRequestContext(true);
    SiteImpl currentProfile = new SiteImpl();
    broadleafRequestContext.setCurrentProfile(currentProfile);

    // Act
    OrderSubmittedEvent actualOrderSubmittedEvent = new OrderSubmittedEvent(broadleafRequestContext, 1L, "42");

    // Assert
    Object source = actualOrderSubmittedEvent.getSource();
    assertTrue(source instanceof BroadleafRequestContext);
    Map<String, Object> context = actualOrderSubmittedEvent.getContext();
    assertEquals(1, context.size());
    assertNull(context.get(BroadleafApplicationEvent.ContextVars.PROFILE_ID));
    assertSame(currentProfile, ((BroadleafRequestContext) source).getCurrentProfile());
  }

  /**
   * Test {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}.
   * <ul>
   *   <li>Then return Context {@link ContextVars#SITE_ID} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}
   */
  @Test
  public void testNewOrderSubmittedEvent_thenReturnContextSite_idIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestContext broadleafRequestContext = BroadleafRequestContext.getBroadleafRequestContext(true);
    SiteImpl site = new SiteImpl();
    broadleafRequestContext.setNonPersistentSite(site);

    // Act
    OrderSubmittedEvent actualOrderSubmittedEvent = new OrderSubmittedEvent(broadleafRequestContext, 1L, "42");

    // Assert
    Object source = actualOrderSubmittedEvent.getSource();
    assertTrue(source instanceof BroadleafRequestContext);
    Map<String, Object> context = actualOrderSubmittedEvent.getContext();
    assertEquals(1, context.size());
    assertNull(context.get(BroadleafApplicationEvent.ContextVars.SITE_ID));
    assertSame(site, ((BroadleafRequestContext) source).getNonPersistentSite());
    assertSame(site, ((BroadleafRequestContext) source).getSite());
  }

  /**
   * Test {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}.
   * <ul>
   *   <li>Then return Source is {@link ThreadLocalManager}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}
   */
  @Test
  public void testNewOrderSubmittedEvent_thenReturnSourceIsThreadLocalManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ThreadLocalManager threadLocalManager = mock(ThreadLocalManager.class);

    // Act
    OrderSubmittedEvent actualOrderSubmittedEvent = new OrderSubmittedEvent(threadLocalManager, 1L, "42");

    // Assert
    assertNull(actualOrderSubmittedEvent.getTimeZoneId());
    assertTrue(actualOrderSubmittedEvent.getContext().isEmpty());
    assertSame(threadLocalManager, actualOrderSubmittedEvent.getSource());
  }

  /**
   * Test {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}.
   * <ul>
   *   <li>Then return Source TimeZone is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}
   */
  @Test
  public void testNewOrderSubmittedEvent_thenReturnSourceTimeZoneIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    OrderSubmittedEvent actualOrderSubmittedEvent = new OrderSubmittedEvent(
        BroadleafRequestContext.getBroadleafRequestContext(true), 1L, "42");

    // Assert
    Object source = actualOrderSubmittedEvent.getSource();
    assertTrue(source instanceof BroadleafRequestContext);
    assertNull(((BroadleafRequestContext) source).getTimeZone());
    assertNull(((BroadleafRequestContext) source).getBroadleafCurrency());
    assertNull(((BroadleafRequestContext) source).getCurrentCatalog());
    assertNull(((BroadleafRequestContext) source).getCurrentProfile());
    assertNull(((BroadleafRequestContext) source).getNonPersistentSite());
    assertNull(((BroadleafRequestContext) source).getSite());
    assertTrue(actualOrderSubmittedEvent.getContext().isEmpty());
  }

  /**
   * Test {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}.
   * <ul>
   *   <li>Then return TimeZoneId is {@code America/Los_Angeles}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}
   */
  @Test
  public void testNewOrderSubmittedEvent_thenReturnTimeZoneIdIsAmericaLosAngeles() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestContext broadleafRequestContext = BroadleafRequestContext.getBroadleafRequestContext(true);
    TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
    broadleafRequestContext.setTimeZone(timeZone);

    // Act
    OrderSubmittedEvent actualOrderSubmittedEvent = new OrderSubmittedEvent(broadleafRequestContext, 1L, "42");

    // Assert
    Object source = actualOrderSubmittedEvent.getSource();
    assertTrue(source instanceof BroadleafRequestContext);
    assertEquals("America/Los_Angeles", actualOrderSubmittedEvent.getTimeZoneId());
    Map<String, Object> context = actualOrderSubmittedEvent.getContext();
    assertEquals(1, context.size());
    assertEquals("America/Los_Angeles", context.get(BroadleafApplicationEvent.ContextVars.TIMEZONE_ID));
    assertSame(timeZone, ((BroadleafRequestContext) source).getTimeZone());
  }

  /**
   * Test {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then return Source is {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderSubmittedEvent#OrderSubmittedEvent(Object, Long, String)}
   */
  @Test
  public void testNewOrderSubmittedEvent_whenNull_field_thenReturnSourceIsNull_field() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    OrderSubmittedEvent actualOrderSubmittedEvent = new OrderSubmittedEvent(object, 1L, "42");

    // Assert
    assertNull(actualOrderSubmittedEvent.getTimeZoneId());
    assertTrue(actualOrderSubmittedEvent.getContext().isEmpty());
    assertSame(object, actualOrderSubmittedEvent.getSource());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderSubmittedEvent#getOrderId()}
   *   <li>{@link OrderSubmittedEvent#getOrderNumber()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OrderSubmittedEvent orderSubmittedEvent = new OrderSubmittedEvent(BLCFieldUtils.NULL_FIELD, 1L, "42");

    // Act
    Long actualOrderId = orderSubmittedEvent.getOrderId();

    // Assert
    assertEquals("42", orderSubmittedEvent.getOrderNumber());
    assertEquals(1L, actualOrderId.longValue());
  }
}
