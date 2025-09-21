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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.Executor;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafApplicationEventMulticaster.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafApplicationEventMulticasterDiffblueTest {
  @Autowired private BroadleafApplicationEventMulticaster broadleafApplicationEventMulticaster;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafApplicationEventMulticaster#setApplicationContext(ApplicationContext)}
   *   <li>{@link BroadleafApplicationEventMulticaster#setTaskExecutor(Executor)}
   *   <li>{@link BroadleafApplicationEventMulticaster#getTaskExecutor()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Executor BroadleafApplicationEventMulticaster.getTaskExecutor()",
    "void BroadleafApplicationEventMulticaster.setApplicationContext(ApplicationContext)",
    "void BroadleafApplicationEventMulticaster.setTaskExecutor(Executor)"
  })
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    BroadleafApplicationEventMulticaster broadleafApplicationEventMulticaster =
        new BroadleafApplicationEventMulticaster();

    // Act
    broadleafApplicationEventMulticaster.setApplicationContext(mock(ApplicationContext.class));
    Executor taskExecutor = mock(Executor.class);
    broadleafApplicationEventMulticaster.setTaskExecutor(taskExecutor);

    // Assert
    assertSame(taskExecutor, broadleafApplicationEventMulticaster.getTaskExecutor());
  }

  /**
   * Test new {@link BroadleafApplicationEventMulticaster} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * BroadleafApplicationEventMulticaster}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafApplicationEventMulticaster.<init>()"})
  public void testNewBroadleafApplicationEventMulticaster() {
    // Arrange and Act
    BroadleafApplicationEventMulticaster actualBroadleafApplicationEventMulticaster =
        new BroadleafApplicationEventMulticaster();

    // Assert
    assertNull(actualBroadleafApplicationEventMulticaster.getTaskExecutor());
    assertNull(actualBroadleafApplicationEventMulticaster.ctx);
  }
}
