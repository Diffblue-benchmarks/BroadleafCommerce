package org.broadleafcommerce.admin.web.rulebuilder.service.options;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.broadleafcommerce.common.BroadleafEnumerationType;
import org.broadleafcommerce.common.web.device.WebRequestDeviceType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {WebRequestDeviceTypeEnumOptionsExtensionListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class WebRequestDeviceTypeEnumOptionsExtensionListenerDiffblueTest {
  @Autowired
  private WebRequestDeviceTypeEnumOptionsExtensionListener
      webRequestDeviceTypeEnumOptionsExtensionListener;

  /**
   * Test {@link WebRequestDeviceTypeEnumOptionsExtensionListener#getValuesToGenerate()}.
   *
   * <p>Method under test: {@link
   * WebRequestDeviceTypeEnumOptionsExtensionListener#getValuesToGenerate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map WebRequestDeviceTypeEnumOptionsExtensionListener.getValuesToGenerate()"})
  public void testGetValuesToGenerate() {
    // Arrange and Act
    Map<String, Class<? extends BroadleafEnumerationType>> actualValuesToGenerate =
        webRequestDeviceTypeEnumOptionsExtensionListener.getValuesToGenerate();

    // Assert
    assertEquals(1, actualValuesToGenerate.size());
    Class<WebRequestDeviceType> expectedGetResult = WebRequestDeviceType.class;
    assertEquals(expectedGetResult, actualValuesToGenerate.get("blcOptions_WebRequestDeviceType"));
  }
}
