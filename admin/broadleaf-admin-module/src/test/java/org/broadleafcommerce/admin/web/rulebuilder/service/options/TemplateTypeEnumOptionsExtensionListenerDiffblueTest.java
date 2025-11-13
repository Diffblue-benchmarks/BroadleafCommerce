package org.broadleafcommerce.admin.web.rulebuilder.service.options;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.broadleafcommerce.common.BroadleafEnumerationType;
import org.broadleafcommerce.common.template.TemplateType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TemplateTypeEnumOptionsExtensionListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TemplateTypeEnumOptionsExtensionListenerDiffblueTest {
  @Autowired
  private TemplateTypeEnumOptionsExtensionListener templateTypeEnumOptionsExtensionListener;

  /**
   * Test {@link TemplateTypeEnumOptionsExtensionListener#getValuesToGenerate()}.
   *
   * <p>Method under test: {@link TemplateTypeEnumOptionsExtensionListener#getValuesToGenerate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TemplateTypeEnumOptionsExtensionListener.getValuesToGenerate()"})
  public void testGetValuesToGenerate() {
    // Arrange and Act
    Map<String, Class<? extends BroadleafEnumerationType>> actualValuesToGenerate =
        templateTypeEnumOptionsExtensionListener.getValuesToGenerate();

    // Assert
    assertEquals(1, actualValuesToGenerate.size());
    Class<TemplateType> expectedGetResult = TemplateType.class;
    assertEquals(expectedGetResult, actualValuesToGenerate.get("blcOptions_TemplateType"));
  }
}
