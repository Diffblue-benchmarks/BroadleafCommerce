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

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafApplicationEventPublisherImplDiffblueTest {
  @Mock
  private ApplicationContext applicationContext;

  @InjectMocks
  private BroadleafApplicationEventPublisherImpl broadleafApplicationEventPublisherImpl;

  /**
   * Test {@link BroadleafApplicationEventPublisherImpl#publishEventUnsynchronized(ApplicationEvent)}.
   * <p>
   * Method under test: {@link BroadleafApplicationEventPublisherImpl#publishEventUnsynchronized(ApplicationEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafApplicationEventPublisherImpl.publishEventUnsynchronized(ApplicationEvent)"})
  public void testPublishEventUnsynchronized() {
    // Arrange
    doNothing().when(applicationContext).publishEvent(Mockito.<ApplicationEvent>any());

    // Act
    broadleafApplicationEventPublisherImpl.publishEventUnsynchronized(new ReindexEvent(BLCFieldUtils.NULL_FIELD));

    // Assert
    verify(applicationContext).publishEvent(isA(ApplicationEvent.class));
  }
}
