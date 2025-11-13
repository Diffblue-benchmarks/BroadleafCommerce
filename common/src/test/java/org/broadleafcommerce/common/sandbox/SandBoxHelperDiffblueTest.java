package org.broadleafcommerce.common.sandbox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.sandbox.SandBoxHelper.OriginalIdResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SandBoxHelperDiffblueTest {
  /**
   * Test OriginalIdResponse getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OriginalIdResponse}
   *   <li>{@link OriginalIdResponse#setOriginalId(Long)}
   *   <li>{@link OriginalIdResponse#setRecordFound(boolean)}
   *   <li>{@link OriginalIdResponse#getOriginalId()}
   *   <li>{@link OriginalIdResponse#isRecordFound()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OriginalIdResponse.<init>()",
    "Long OriginalIdResponse.getOriginalId()",
    "boolean OriginalIdResponse.isRecordFound()",
    "void OriginalIdResponse.setOriginalId(Long)",
    "void OriginalIdResponse.setRecordFound(boolean)"
  })
  public void testOriginalIdResponseGettersAndSetters() {
    // Arrange and Act
    OriginalIdResponse actualOriginalIdResponse = new OriginalIdResponse();
    actualOriginalIdResponse.setOriginalId(1L);
    actualOriginalIdResponse.setRecordFound(true);
    Long actualOriginalId = actualOriginalIdResponse.getOriginalId();
    boolean actualIsRecordFoundResult = actualOriginalIdResponse.isRecordFound();

    // Assert
    assertEquals(1L, actualOriginalId.longValue());
    assertTrue(actualIsRecordFoundResult);
  }
}
