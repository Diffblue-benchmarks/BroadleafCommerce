package org.broadleafcommerce.core.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.service.call.ActivityMessageDTO;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DefaultProcessContextImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DefaultProcessContextImpl}
   *   <li>{@link DefaultProcessContextImpl#setActivityMessages(List)}
   *   <li>{@link DefaultProcessContextImpl#setSeedData(Object)}
   *   <li>{@link DefaultProcessContextImpl#stopProcess()}
   *   <li>{@link DefaultProcessContextImpl#getActivityMessages()}
   *   <li>{@link DefaultProcessContextImpl#getSeedData()}
   *   <li>{@link DefaultProcessContextImpl#isStopped()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultProcessContextImpl.<init>()",
    "List DefaultProcessContextImpl.getActivityMessages()",
    "Object DefaultProcessContextImpl.getSeedData()",
    "boolean DefaultProcessContextImpl.isStopped()",
    "void DefaultProcessContextImpl.setActivityMessages(List)",
    "void DefaultProcessContextImpl.setSeedData(Object)",
    "boolean DefaultProcessContextImpl.stopProcess()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DefaultProcessContextImpl<Object> actualDefaultProcessContextImpl =
        new DefaultProcessContextImpl<>();
    ArrayList<ActivityMessageDTO> activityMessages = new ArrayList<>();
    actualDefaultProcessContextImpl.setActivityMessages(activityMessages);
    actualDefaultProcessContextImpl.setSeedData("Seed Object");
    boolean actualStopProcessResult = actualDefaultProcessContextImpl.stopProcess();
    List<ActivityMessageDTO> actualActivityMessages =
        actualDefaultProcessContextImpl.getActivityMessages();
    Object actualSeedData = actualDefaultProcessContextImpl.getSeedData();
    boolean actualIsStoppedResult = actualDefaultProcessContextImpl.isStopped();

    // Assert
    assertEquals("Seed Object", actualSeedData);
    assertTrue(actualActivityMessages.isEmpty());
    assertTrue(actualIsStoppedResult);
    assertTrue(actualStopProcessResult);
    assertSame(activityMessages, actualActivityMessages);
  }
}
