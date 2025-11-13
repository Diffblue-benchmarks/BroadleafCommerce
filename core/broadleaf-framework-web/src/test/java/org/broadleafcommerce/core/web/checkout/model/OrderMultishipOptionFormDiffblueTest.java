package org.broadleafcommerce.core.web.checkout.model;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.service.call.OrderMultishipOptionDTO;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderMultishipOptionFormDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderMultishipOptionForm}
   *   <li>{@link OrderMultishipOptionForm#setOptions(List)}
   *   <li>{@link OrderMultishipOptionForm#getOptions()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderMultishipOptionForm.<init>()",
    "List OrderMultishipOptionForm.getOptions()",
    "void OrderMultishipOptionForm.setOptions(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderMultishipOptionForm actualOrderMultishipOptionForm = new OrderMultishipOptionForm();
    ArrayList<OrderMultishipOptionDTO> options = new ArrayList<>();
    actualOrderMultishipOptionForm.setOptions(options);
    List<OrderMultishipOptionDTO> actualOptions = actualOrderMultishipOptionForm.getOptions();

    // Assert
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
