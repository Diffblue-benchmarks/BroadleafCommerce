package org.broadleafcommerce.admin.web.rulebuilder.service.options;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.broadleafcommerce.common.BroadleafEnumerationType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FulfillmentTypeEnumOptionsExtensionListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FulfillmentTypeEnumOptionsExtensionListenerDiffblueTest {
  @Autowired
  private FulfillmentTypeEnumOptionsExtensionListener fulfillmentTypeEnumOptionsExtensionListener;

  /**
   * Test {@link FulfillmentTypeEnumOptionsExtensionListener#getValuesToGenerate()}.
   *
   * <p>Method under test: {@link FulfillmentTypeEnumOptionsExtensionListener#getValuesToGenerate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map FulfillmentTypeEnumOptionsExtensionListener.getValuesToGenerate()"})
  public void testGetValuesToGenerate() {
    // Arrange and Act
    Map<String, Class<? extends BroadleafEnumerationType>> actualValuesToGenerate =
        fulfillmentTypeEnumOptionsExtensionListener.getValuesToGenerate();

    // Assert
    assertEquals(1, actualValuesToGenerate.size());
    Class<FulfillmentType> expectedGetResult = FulfillmentType.class;
    assertEquals(expectedGetResult, actualValuesToGenerate.get("blcOptions_FulfillmentType"));
  }
}
