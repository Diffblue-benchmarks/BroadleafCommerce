package org.broadleafcommerce.common.event;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.Executor;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafApplicationEventMulticaster.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafApplicationEventMulticasterDiffblueTest {
  @Autowired private BroadleafApplicationEventMulticaster broadleafApplicationEventMulticaster;

  /**
   * Test {@link BroadleafApplicationEventMulticaster#multicastEvent(ApplicationEvent)} with {@code
   * event}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafApplicationEventMulticaster#multicastEvent(ApplicationEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafApplicationEventMulticaster.multicastEvent(ApplicationEvent)"})
  public void testMulticastEventWithEvent_thenDoesNotThrow() {
    // Arrange
    BroadleafApplicationEventMulticaster broadleafApplicationEventMulticaster =
        new BroadleafApplicationEventMulticaster();

    // Act and Assert
    broadleafApplicationEventMulticaster.multicastEvent(new ReindexEvent(BLCFieldUtils.NULL_FIELD));
  }

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
