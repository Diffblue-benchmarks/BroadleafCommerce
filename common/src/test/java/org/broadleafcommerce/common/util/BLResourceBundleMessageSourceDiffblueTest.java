package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BLResourceBundleMessageSourceDiffblueTest {
  /**
   * Test {@link BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[],
   * ResourceBundleExtensionPoint)}.
   *
   * <p>Method under test: {@link
   * BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[],
   * ResourceBundleExtensionPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BLResourceBundleMessageSource.<init>(String[], ResourceBundleExtensionPoint)"
  })
  public void testNewBLResourceBundleMessageSource() {
    // Arrange
    ResourceBundleExtensionPoint resourceBundleExtensionPoint = new ResourceBundleExtensionPoint();
    resourceBundleExtensionPoint.setBasenameExtensions(
        new String[] {"Resource Bundle Extension Point"});

    // Act
    BLResourceBundleMessageSource actualBlResourceBundleMessageSource =
        new BLResourceBundleMessageSource(null, resourceBundleExtensionPoint);

    // Assert
    assertNull(actualBlResourceBundleMessageSource.getParentMessageSource());
    Set<String> basenameSet = actualBlResourceBundleMessageSource.getBasenameSet();
    assertEquals(1, basenameSet.size());
    assertTrue(basenameSet.contains("Resource Bundle Extension Point"));
  }

  /**
   * Test {@link BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[],
   * ResourceBundleExtensionPoint)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[],
   * ResourceBundleExtensionPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BLResourceBundleMessageSource.<init>(String[], ResourceBundleExtensionPoint)"
  })
  public void testNewBLResourceBundleMessageSource_givenNull() {
    // Arrange
    String[] basenames = new String[] {"Basenames"};

    ResourceBundleExtensionPoint resourceBundleExtensionPoint = new ResourceBundleExtensionPoint();
    resourceBundleExtensionPoint.setBasenameExtensions(null);

    // Act
    BLResourceBundleMessageSource actualBlResourceBundleMessageSource =
        new BLResourceBundleMessageSource(basenames, resourceBundleExtensionPoint);

    // Assert
    assertNull(actualBlResourceBundleMessageSource.getParentMessageSource());
    Set<String> basenameSet = actualBlResourceBundleMessageSource.getBasenameSet();
    assertEquals(1, basenameSet.size());
    assertTrue(basenameSet.contains("Basenames"));
  }

  /**
   * Test {@link BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[],
   * ResourceBundleExtensionPoint)}.
   *
   * <ul>
   *   <li>Then return BasenameSet size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[],
   * ResourceBundleExtensionPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BLResourceBundleMessageSource.<init>(String[], ResourceBundleExtensionPoint)"
  })
  public void testNewBLResourceBundleMessageSource_thenReturnBasenameSetSizeIsTwo() {
    // Arrange
    String[] basenames = new String[] {"Basenames"};

    ResourceBundleExtensionPoint resourceBundleExtensionPoint = new ResourceBundleExtensionPoint();
    resourceBundleExtensionPoint.setBasenameExtensions(new String[] {"Basename Extensions"});

    // Act
    BLResourceBundleMessageSource actualBlResourceBundleMessageSource =
        new BLResourceBundleMessageSource(basenames, resourceBundleExtensionPoint);

    // Assert
    assertNull(actualBlResourceBundleMessageSource.getParentMessageSource());
    Set<String> basenameSet = actualBlResourceBundleMessageSource.getBasenameSet();
    assertEquals(2, basenameSet.size());
    assertTrue(basenameSet.contains("Basename Extensions"));
    assertTrue(basenameSet.contains("Basenames"));
  }

  /**
   * Test {@link BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[],
   * ResourceBundleExtensionPoint)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return BasenameSet Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * BLResourceBundleMessageSource#BLResourceBundleMessageSource(String[],
   * ResourceBundleExtensionPoint)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BLResourceBundleMessageSource.<init>(String[], ResourceBundleExtensionPoint)"
  })
  public void testNewBLResourceBundleMessageSource_whenNull_thenReturnBasenameSetEmpty() {
    // Arrange
    String[] basenames = new String[] {"Basenames"};

    // Act
    BLResourceBundleMessageSource actualBlResourceBundleMessageSource =
        new BLResourceBundleMessageSource(basenames, null);

    // Assert
    assertNull(actualBlResourceBundleMessageSource.getParentMessageSource());
    assertTrue(actualBlResourceBundleMessageSource.getBasenameSet().isEmpty());
  }
}
