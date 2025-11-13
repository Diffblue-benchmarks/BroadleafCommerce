package org.broadleafcommerce.openadmin.web.rulebuilder.enums;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.Resource;

@RunWith(MockitoJUnitRunner.class)
public class RuleBuilderEnumOptionsResourceHandlerDiffblueTest {
  @Mock private RuleBuilderEnumOptionsExtensionManager ruleBuilderEnumOptionsExtensionManager;

  @InjectMocks private RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler;

  /**
   * Test {@link RuleBuilderEnumOptionsResourceHandler#canHandle(String)}.
   *
   * <ul>
   *   <li>When {@code admin/components/ruleBuilder-options.js}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RuleBuilderEnumOptionsResourceHandler#canHandle(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleBuilderEnumOptionsResourceHandler.canHandle(String)"})
  public void testCanHandle_whenAdminComponentsRuleBuilderOptionsJs_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new RuleBuilderEnumOptionsResourceHandler()
            .canHandle("admin/components/ruleBuilder-options.js"));
  }

  /**
   * Test {@link RuleBuilderEnumOptionsResourceHandler#canHandle(String)}.
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RuleBuilderEnumOptionsResourceHandler#canHandle(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleBuilderEnumOptionsResourceHandler.canHandle(String)"})
  public void testCanHandle_whenPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new RuleBuilderEnumOptionsResourceHandler().canHandle("Path"));
  }

  /**
   * Test {@link RuleBuilderEnumOptionsResourceHandler#getFileContents(String, List)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleBuilderEnumOptionsResourceHandler#getFileContents(String,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource RuleBuilderEnumOptionsResourceHandler.getFileContents(String, List)"
  })
  public void testGetFileContents_givenGeneratedResource_whenArrayListAddGeneratedResource()
      throws IOException {
    // Arrange
    when(ruleBuilderEnumOptionsExtensionManager.getOptionValues()).thenReturn("42");

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act
    Resource actualFileContents =
        ruleBuilderEnumOptionsResourceHandler.getFileContents("Path", locations);

    // Assert
    verify(ruleBuilderEnumOptionsExtensionManager).getOptionValues();
    assertTrue(actualFileContents instanceof GeneratedResource);
    assertEquals("Path", actualFileContents.getDescription());
    assertEquals("Path", actualFileContents.getFilename());
    byte[] byteArray = new byte[2];
    assertEquals(2, actualFileContents.getInputStream().read(byteArray));
    assertFalse(actualFileContents.isFile());
    assertFalse(actualFileContents.isOpen());
    assertArrayEquals(new byte[] {'4', '2'}, ((GeneratedResource) actualFileContents).getBytes());
    assertArrayEquals(new byte[] {'4', '2'}, byteArray);
  }

  /**
   * Test {@link RuleBuilderEnumOptionsResourceHandler#getFileContents(String, List)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleBuilderEnumOptionsResourceHandler#getFileContents(String,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource RuleBuilderEnumOptionsResourceHandler.getFileContents(String, List)"
  })
  public void testGetFileContents_givenGeneratedResource_whenArrayListAddGeneratedResource2()
      throws IOException {
    // Arrange
    when(ruleBuilderEnumOptionsExtensionManager.getOptionValues()).thenReturn("42");

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act
    Resource actualFileContents =
        ruleBuilderEnumOptionsResourceHandler.getFileContents("Path", locations);

    // Assert
    verify(ruleBuilderEnumOptionsExtensionManager).getOptionValues();
    assertTrue(actualFileContents instanceof GeneratedResource);
    assertEquals("Path", actualFileContents.getDescription());
    assertEquals("Path", actualFileContents.getFilename());
    byte[] byteArray = new byte[2];
    assertEquals(2, actualFileContents.getInputStream().read(byteArray));
    assertFalse(actualFileContents.isFile());
    assertFalse(actualFileContents.isOpen());
    assertArrayEquals(new byte[] {'4', '2'}, ((GeneratedResource) actualFileContents).getBytes());
    assertArrayEquals(new byte[] {'4', '2'}, byteArray);
  }

  /**
   * Test {@link RuleBuilderEnumOptionsResourceHandler#getFileContents(String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RuleBuilderEnumOptionsResourceHandler#getFileContents(String,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource RuleBuilderEnumOptionsResourceHandler.getFileContents(String, List)"
  })
  public void testGetFileContents_whenArrayList() throws IOException {
    // Arrange
    when(ruleBuilderEnumOptionsExtensionManager.getOptionValues()).thenReturn("42");

    // Act
    Resource actualFileContents =
        ruleBuilderEnumOptionsResourceHandler.getFileContents("Path", new ArrayList<>());

    // Assert
    verify(ruleBuilderEnumOptionsExtensionManager).getOptionValues();
    assertTrue(actualFileContents instanceof GeneratedResource);
    assertEquals("Path", actualFileContents.getDescription());
    assertEquals("Path", actualFileContents.getFilename());
    byte[] byteArray = new byte[2];
    assertEquals(2, actualFileContents.getInputStream().read(byteArray));
    assertFalse(actualFileContents.isFile());
    assertFalse(actualFileContents.isOpen());
    assertArrayEquals(new byte[] {'4', '2'}, ((GeneratedResource) actualFileContents).getBytes());
    assertArrayEquals(new byte[] {'4', '2'}, byteArray);
  }

  /**
   * Test {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource,
   * String, List)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleBuilderEnumOptionsResourceHandler.isCachedResourceExpired(GeneratedResource, String, List)"
  })
  public void testIsCachedResourceExpired_givenGeneratedResource() {
    // Arrange
    RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler =
        new RuleBuilderEnumOptionsResourceHandler();
    GeneratedResource cachedResource = new GeneratedResource();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertFalse(
        ruleBuilderEnumOptionsResourceHandler.isCachedResourceExpired(
            cachedResource, "Path", locations));
  }

  /**
   * Test {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource,
   * String, List)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleBuilderEnumOptionsResourceHandler.isCachedResourceExpired(GeneratedResource, String, List)"
  })
  public void testIsCachedResourceExpired_givenGeneratedResource2() {
    // Arrange
    RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler =
        new RuleBuilderEnumOptionsResourceHandler();
    GeneratedResource cachedResource = new GeneratedResource();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertFalse(
        ruleBuilderEnumOptionsResourceHandler.isCachedResourceExpired(
            cachedResource, "Path", locations));
  }

  /**
   * Test {@link RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource,
   * String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleBuilderEnumOptionsResourceHandler#isCachedResourceExpired(GeneratedResource, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleBuilderEnumOptionsResourceHandler.isCachedResourceExpired(GeneratedResource, String, List)"
  })
  public void testIsCachedResourceExpired_whenArrayList() {
    // Arrange
    RuleBuilderEnumOptionsResourceHandler ruleBuilderEnumOptionsResourceHandler =
        new RuleBuilderEnumOptionsResourceHandler();
    GeneratedResource cachedResource = new GeneratedResource();

    // Act and Assert
    assertFalse(
        ruleBuilderEnumOptionsResourceHandler.isCachedResourceExpired(
            cachedResource, "Path", new ArrayList<>()));
  }
}
