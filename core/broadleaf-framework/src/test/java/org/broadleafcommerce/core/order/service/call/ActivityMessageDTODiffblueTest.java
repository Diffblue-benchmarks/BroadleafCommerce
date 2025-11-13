package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ActivityMessageDTODiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActivityMessageDTO#ActivityMessageDTO(String, Integer, String)}
   *   <li>{@link ActivityMessageDTO#setErrorCode(String)}
   *   <li>{@link ActivityMessageDTO#setMessage(String)}
   *   <li>{@link ActivityMessageDTO#setPriority(Integer)}
   *   <li>{@link ActivityMessageDTO#setType(String)}
   *   <li>{@link ActivityMessageDTO#getErrorCode()}
   *   <li>{@link ActivityMessageDTO#getMessage()}
   *   <li>{@link ActivityMessageDTO#getPriority()}
   *   <li>{@link ActivityMessageDTO#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ActivityMessageDTO.<init>(String, Integer, String)",
    "String ActivityMessageDTO.getErrorCode()",
    "String ActivityMessageDTO.getMessage()",
    "Integer ActivityMessageDTO.getPriority()",
    "String ActivityMessageDTO.getType()",
    "void ActivityMessageDTO.setErrorCode(String)",
    "void ActivityMessageDTO.setMessage(String)",
    "void ActivityMessageDTO.setPriority(Integer)",
    "void ActivityMessageDTO.setType(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ActivityMessageDTO actualActivityMessageDTO =
        new ActivityMessageDTO("Type", 1, "Not all who wander are lost");
    actualActivityMessageDTO.setErrorCode("An error occurred");
    actualActivityMessageDTO.setMessage("Not all who wander are lost");
    actualActivityMessageDTO.setPriority(1);
    actualActivityMessageDTO.setType("Type");
    String actualErrorCode = actualActivityMessageDTO.getErrorCode();
    String actualMessage = actualActivityMessageDTO.getMessage();
    Integer actualPriority = actualActivityMessageDTO.getPriority();

    // Assert
    assertEquals("An error occurred", actualErrorCode);
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals("Type", actualActivityMessageDTO.getType());
    assertEquals(1, actualPriority.intValue());
  }
}
