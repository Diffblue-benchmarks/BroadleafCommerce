package org.broadleafcommerce.admin.web.rulebuilder.service.options;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.broadleafcommerce.common.BroadleafEnumerationType;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {InventoryTypeEnumOptionsExtensionListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class InventoryTypeEnumOptionsExtensionListenerDiffblueTest {
  @Autowired
  private InventoryTypeEnumOptionsExtensionListener inventoryTypeEnumOptionsExtensionListener;

  /**
   * Test {@link InventoryTypeEnumOptionsExtensionListener#getValuesToGenerate()}.
   *
   * <p>Method under test: {@link InventoryTypeEnumOptionsExtensionListener#getValuesToGenerate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InventoryTypeEnumOptionsExtensionListener.getValuesToGenerate()"})
  public void testGetValuesToGenerate() {
    // Arrange and Act
    Map<String, Class<? extends BroadleafEnumerationType>> actualValuesToGenerate =
        inventoryTypeEnumOptionsExtensionListener.getValuesToGenerate();

    // Assert
    assertEquals(1, actualValuesToGenerate.size());
    Class<InventoryType> expectedGetResult = InventoryType.class;
    assertEquals(expectedGetResult, actualValuesToGenerate.get("blcOptions_InventoryType"));
  }
}
