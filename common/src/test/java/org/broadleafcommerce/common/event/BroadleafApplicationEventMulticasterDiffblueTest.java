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
package org.broadleafcommerce.common.event;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.concurrent.Executor;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class BroadleafApplicationEventMulticasterDiffblueTest {
  /**
   * Test
   * {@link BroadleafApplicationEventMulticaster#multicastEvent(ApplicationEvent)}
   * with {@code event}.
   * <ul>
   *   <li>Then calls
   * {@link ApplicationListener#onApplicationEvent(ApplicationEvent)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafApplicationEventMulticaster#multicastEvent(ApplicationEvent)}
   */
  @Test
  public void testMulticastEventWithEvent_thenCallsOnApplicationEvent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationListener<ApplicationEvent> listener = mock(ApplicationListener.class);
    doNothing().when(listener).onApplicationEvent(Mockito.<ApplicationEvent>any());

    BroadleafApplicationEventMulticaster broadleafApplicationEventMulticaster = new BroadleafApplicationEventMulticaster();
    broadleafApplicationEventMulticaster.addApplicationListener(listener);

    // Act
    broadleafApplicationEventMulticaster.multicastEvent(new ReindexEvent(BLCFieldUtils.NULL_FIELD));

    // Assert
    verify(listener).onApplicationEvent(isA(ApplicationEvent.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link BroadleafApplicationEventMulticaster#setApplicationContext(ApplicationContext)}
   *   <li>{@link BroadleafApplicationEventMulticaster#setTaskExecutor(Executor)}
   *   <li>{@link BroadleafApplicationEventMulticaster#getTaskExecutor()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    BroadleafApplicationEventMulticaster broadleafApplicationEventMulticaster = new BroadleafApplicationEventMulticaster();

    // Act
    broadleafApplicationEventMulticaster.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    Executor taskExecutor = mock(Executor.class);
    broadleafApplicationEventMulticaster.setTaskExecutor(taskExecutor);

    // Assert that nothing has changed
    assertSame(taskExecutor, broadleafApplicationEventMulticaster.getTaskExecutor());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link BroadleafApplicationEventMulticaster#setApplicationContext(ApplicationContext)}
   *   <li>{@link BroadleafApplicationEventMulticaster#setTaskExecutor(Executor)}
   *   <li>{@link BroadleafApplicationEventMulticaster#getTaskExecutor()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() throws BeansException {
    // Arrange
    BroadleafApplicationEventMulticaster broadleafApplicationEventMulticaster = new BroadleafApplicationEventMulticaster();

    // Act
    broadleafApplicationEventMulticaster.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    Executor taskExecutor = mock(Executor.class);
    broadleafApplicationEventMulticaster.setTaskExecutor(taskExecutor);

    // Assert that nothing has changed
    assertSame(taskExecutor, broadleafApplicationEventMulticaster.getTaskExecutor());
  }

  /**
   * Test new {@link BroadleafApplicationEventMulticaster} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafApplicationEventMulticaster}
   */
  @Test
  public void testNewBroadleafApplicationEventMulticaster() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    BroadleafApplicationEventMulticaster actualBroadleafApplicationEventMulticaster = new BroadleafApplicationEventMulticaster();

    // Assert
    assertNull(actualBroadleafApplicationEventMulticaster.getTaskExecutor());
    assertNull(actualBroadleafApplicationEventMulticaster.ctx);
  }

  /**
   * Test new {@link BroadleafApplicationEventMulticaster} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafApplicationEventMulticaster}
   */
  @Test
  public void testNewBroadleafApplicationEventMulticaster2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    BroadleafApplicationEventMulticaster actualBroadleafApplicationEventMulticaster = new BroadleafApplicationEventMulticaster();

    // Assert
    assertNull(actualBroadleafApplicationEventMulticaster.getTaskExecutor());
    assertNull(actualBroadleafApplicationEventMulticaster.ctx);
  }
}
