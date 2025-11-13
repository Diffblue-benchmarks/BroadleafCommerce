package org.broadleafcommerce.profile.core.service.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.validation.BindException;

public class BaseResponseDiffblueTest {
  /**
   * Test {@link BaseResponse#BaseResponse(Object, String)}.
   *
   * <ul>
   *   <li>When {@code Target}.
   *   <li>Then Errors return {@link BindException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResponse#BaseResponse(Object, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResponse.<init>(Object, String)"})
  public void testNewBaseResponse_whenTarget_thenErrorsReturnBindException() {
    // Arrange and Act
    BaseResponse actualBaseResponse = new BaseResponse("Target", "Object Name");

    // Assert
    assertTrue(actualBaseResponse.getErrors() instanceof BindException);
    assertFalse(actualBaseResponse.hasErrors());
  }

  /**
   * Test {@link BaseResponse#hasErrors()}.
   *
   * <p>Method under test: {@link BaseResponse#hasErrors()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseResponse.hasErrors()"})
  public void testHasErrors() {
    // Arrange, Act and Assert
    assertFalse(new BaseResponse("Target", "Object Name").hasErrors());
  }

  /**
   * Test {@link BaseResponse#getErrors()}.
   *
   * <p>Method under test: {@link BaseResponse#getErrors()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.springframework.validation.Errors BaseResponse.getErrors()"})
  public void testGetErrors() {
    // Arrange, Act and Assert
    assertTrue(new BaseResponse("Target", "Object Name").getErrors() instanceof BindException);
  }
}
