package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Locale;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractBroadleafMergeResourceExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractBroadleafMergeResourceExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractBroadleafMergeResourceExtensionHandler
      abstractBroadleafMergeResourceExtensionHandler;

  /**
   * Test {@link AbstractBroadleafMergeResourceExtensionHandler#resolveMessageSource(String, Locale,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * AbstractBroadleafMergeResourceExtensionHandler#resolveMessageSource(String, Locale,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractBroadleafMergeResourceExtensionHandler.resolveMessageSource(String, Locale, ExtensionResultHolder)"
  })
  public void testResolveMessageSource() {
    // Arrange
    Locale locale = Locale.getDefault();

    ExtensionResultHolder<String> result = new ExtensionResultHolder<>();
    result.setResult("Result");
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractBroadleafMergeResourceExtensionHandler.resolveMessageSource(
            "Code", locale, result));
  }

  /**
   * Test new {@link AbstractBroadleafMergeResourceExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractBroadleafMergeResourceExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractBroadleafMergeResourceExtensionHandler.<init>()"})
  public void testNewAbstractBroadleafMergeResourceExtensionHandler() {
    // Arrange and Act
    AbstractBroadleafMergeResourceExtensionHandler
        actualAbstractBroadleafMergeResourceExtensionHandler =
            new AbstractBroadleafMergeResourceExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractBroadleafMergeResourceExtensionHandler.getPriority());
    assertTrue(actualAbstractBroadleafMergeResourceExtensionHandler.isEnabled());
  }
}
