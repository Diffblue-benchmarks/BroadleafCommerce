package org.broadleafcommerce.common.copy;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CreateResponseDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CreateResponse#CreateResponse(Object, boolean)}
   *   <li>{@link CreateResponse#getClone()}
   *   <li>{@link CreateResponse#isAlreadyPopulated()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CreateResponse.<init>(Object, boolean)",
    "Object CreateResponse.getClone()",
    "boolean CreateResponse.isAlreadyPopulated()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    CreateResponse<Object> actualCreateResponse = new CreateResponse<>(object, true);
    Object actualClone = actualCreateResponse.getClone();

    // Assert
    assertTrue(actualCreateResponse.isAlreadyPopulated());
    assertSame(object, actualClone);
  }
}
