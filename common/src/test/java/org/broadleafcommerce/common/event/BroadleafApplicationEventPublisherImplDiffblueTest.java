package org.broadleafcommerce.common.event;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Mock private ApplicationContext applicationContext;

  @InjectMocks
  private BroadleafApplicationEventPublisherImpl broadleafApplicationEventPublisherImpl;

  /**
   * Test {@link BroadleafApplicationEventPublisherImpl#publishEvent(ApplicationEvent)}.
   *
   * <p>Method under test: {@link
   * BroadleafApplicationEventPublisherImpl#publishEvent(ApplicationEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafApplicationEventPublisherImpl.publishEvent(ApplicationEvent)"})
  public void testPublishEvent() {
    // Arrange
    doNothing().when(applicationContext).publishEvent(Mockito.<ApplicationEvent>any());

    // Act
    broadleafApplicationEventPublisherImpl.publishEvent(new ReindexEvent(BLCFieldUtils.NULL_FIELD));

    // Assert
    verify(applicationContext).publishEvent(isA(ApplicationEvent.class));
  }

  /**
   * Test {@link
   * BroadleafApplicationEventPublisherImpl#publishEventUnsynchronized(ApplicationEvent)}.
   *
   * <p>Method under test: {@link
   * BroadleafApplicationEventPublisherImpl#publishEventUnsynchronized(ApplicationEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafApplicationEventPublisherImpl.publishEventUnsynchronized(ApplicationEvent)"
  })
  public void testPublishEventUnsynchronized() {
    // Arrange
    doNothing().when(applicationContext).publishEvent(Mockito.<ApplicationEvent>any());

    // Act
    broadleafApplicationEventPublisherImpl.publishEventUnsynchronized(
        new ReindexEvent(BLCFieldUtils.NULL_FIELD));

    // Assert
    verify(applicationContext).publishEvent(isA(ApplicationEvent.class));
  }
}
