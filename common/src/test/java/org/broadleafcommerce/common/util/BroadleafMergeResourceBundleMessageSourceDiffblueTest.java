/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafMergeResourceBundleMessageSourceDiffblueTest {
  @InjectMocks
  private BroadleafMergeResourceBundleMessageSource broadleafMergeResourceBundleMessageSource;

  @Mock
  private BroadleafMergeResourceExtensionManager broadleafMergeResourceExtensionManager;

  /**
   * Test new {@link BroadleafMergeResourceBundleMessageSource} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BroadleafMergeResourceBundleMessageSource}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafMergeResourceBundleMessageSource.<init>()"})
  public void testNewBroadleafMergeResourceBundleMessageSource() {
    // Arrange and Act
    BroadleafMergeResourceBundleMessageSource actualBroadleafMergeResourceBundleMessageSource = new BroadleafMergeResourceBundleMessageSource();

    // Assert
    assertNull(actualBroadleafMergeResourceBundleMessageSource.extensionManager);
    assertNull(actualBroadleafMergeResourceBundleMessageSource.getParentMessageSource());
    assertTrue(actualBroadleafMergeResourceBundleMessageSource.getBasenameSet().isEmpty());
  }

  /**
   * Test {@link BroadleafMergeResourceBundleMessageSource#setBasenames(String[])}.
   * <p>
   * Method under test: {@link BroadleafMergeResourceBundleMessageSource#setBasenames(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafMergeResourceBundleMessageSource.setBasenames(String[])"})
  public void testSetBasenames() {
    // Arrange
    String[] basenames = new String[]{"Basenames"};

    // Act
    broadleafMergeResourceBundleMessageSource.setBasenames(basenames);

    // Assert
    Set<String> basenameSet = broadleafMergeResourceBundleMessageSource.getBasenameSet();
    assertEquals(1, basenameSet.size());
    assertTrue(basenameSet.contains("Basenames"));
    assertArrayEquals(new String[]{"Basenames"}, basenames);
  }

  /**
   * Test {@link BroadleafMergeResourceBundleMessageSource#setBasenames(String[])}.
   * <p>
   * Method under test: {@link BroadleafMergeResourceBundleMessageSource#setBasenames(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafMergeResourceBundleMessageSource.setBasenames(String[])"})
  public void testSetBasenames2() {
    // Arrange
    String[] basenames = new String[]{"Basenames", "UTF-8"};

    // Act
    broadleafMergeResourceBundleMessageSource.setBasenames(basenames);

    // Assert
    Set<String> basenameSet = broadleafMergeResourceBundleMessageSource.getBasenameSet();
    assertEquals(2, basenameSet.size());
    assertTrue(basenameSet.contains("Basenames"));
    assertTrue(basenameSet.contains("UTF-8"));
    assertArrayEquals(new String[]{"UTF-8", "Basenames"}, basenames);
  }

  /**
   * Test {@link BroadleafMergeResourceBundleMessageSource#resolveCode(String, Locale)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafMergeResourceBundleMessageSource#resolveCode(String, Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MessageFormat BroadleafMergeResourceBundleMessageSource.resolveCode(String, Locale)"})
  public void testResolveCode_thenReturnNull() {
    // Arrange
    when(broadleafMergeResourceExtensionManager.getProxy())
        .thenReturn(new AbstractBroadleafMergeResourceExtensionHandler());

    // Act
    MessageFormat actualResolveCodeResult = broadleafMergeResourceBundleMessageSource.resolveCode("Code",
        Locale.getDefault());

    // Assert
    verify(broadleafMergeResourceExtensionManager).getProxy();
    assertNull(actualResolveCodeResult);
  }

  /**
   * Test {@link BroadleafMergeResourceBundleMessageSource#resolveCodeWithoutArguments(String, Locale)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafMergeResourceBundleMessageSource#resolveCodeWithoutArguments(String, Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafMergeResourceBundleMessageSource.resolveCodeWithoutArguments(String, Locale)"})
  public void testResolveCodeWithoutArguments_thenReturnNull() {
    // Arrange
    when(broadleafMergeResourceExtensionManager.getProxy())
        .thenReturn(new AbstractBroadleafMergeResourceExtensionHandler());

    // Act
    String actualResolveCodeWithoutArgumentsResult = broadleafMergeResourceBundleMessageSource
        .resolveCodeWithoutArguments("Code", Locale.getDefault());

    // Assert
    verify(broadleafMergeResourceExtensionManager).getProxy();
    assertNull(actualResolveCodeWithoutArgumentsResult);
  }
}
