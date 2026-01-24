package org.broadleafcommerce.core.web.linkeddata.generator;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultLinkedDataGeneratorExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultLinkedDataGeneratorExtensionHandlerDiffblueTest {
  @Autowired
  private DefaultLinkedDataGeneratorExtensionHandler defaultLinkedDataGeneratorExtensionHandler;

  @MockBean(name = "blLinkedDataGeneratorExtensionManager")
  private LinkedDataGeneratorExtensionManager linkedDataGeneratorExtensionManager;

  /**
   * Test {@link DefaultLinkedDataGeneratorExtensionHandler#init()}.
   *
   * <p>Method under test: {@link DefaultLinkedDataGeneratorExtensionHandler#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLinkedDataGeneratorExtensionHandler.init()"})
  public void testInit() {
    // Arrange
    when(linkedDataGeneratorExtensionManager.registerHandler(
            Mockito.<LinkedDataGeneratorExtensionHandler>any()))
        .thenReturn(true);

    // Act
    defaultLinkedDataGeneratorExtensionHandler.init();

    // Assert
    verify(linkedDataGeneratorExtensionManager)
        .registerHandler(isA(LinkedDataGeneratorExtensionHandler.class));
  }

  /**
   * Test {@link DefaultLinkedDataGeneratorExtensionHandler#getPriority()}.
   *
   * <p>Method under test: {@link DefaultLinkedDataGeneratorExtensionHandler#getPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultLinkedDataGeneratorExtensionHandler.getPriority()"})
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, new DefaultLinkedDataGeneratorExtensionHandler().getPriority());
  }
}
