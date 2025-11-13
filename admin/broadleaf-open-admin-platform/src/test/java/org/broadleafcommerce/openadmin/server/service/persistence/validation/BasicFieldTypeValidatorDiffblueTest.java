package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BasicFieldTypeValidatorDiffblueTest {
  /**
   * Test {@link BasicFieldTypeValidator#getOrder()}.
   *
   * <p>Method under test: {@link BasicFieldTypeValidator#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BasicFieldTypeValidator.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(2147482647, new BasicFieldTypeValidator().getOrder());
  }
}
