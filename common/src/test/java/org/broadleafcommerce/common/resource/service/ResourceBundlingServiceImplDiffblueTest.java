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
package org.broadleafcommerce.common.resource.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.cache.StatisticsService;
import org.broadleafcommerce.common.file.service.BroadleafFileService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@RunWith(MockitoJUnitRunner.class)
public class ResourceBundlingServiceImplDiffblueTest {
  @Mock
  private ApplicationContext applicationContext;

  @Mock
  private BroadleafFileService broadleafFileService;

  @Mock
  private Environment environment;

  @Mock
  private Map<String, List<String>> map;

  @InjectMocks
  private ResourceBundlingServiceImpl resourceBundlingServiceImpl;

  @Mock
  private StatisticsService statisticsService;

  /**
   * Test {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}.
   * <ul>
   *   <li>When {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.checkForRegisteredBundleFile(String)"})
  public void testCheckForRegisteredBundleFile_when102() {
    // Arrange, Act and Assert
    assertFalse(resourceBundlingServiceImpl.checkForRegisteredBundleFile("1.0.2"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}.
   * <ul>
   *   <li>When {@code .css}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.checkForRegisteredBundleFile(String)"})
  public void testCheckForRegisteredBundleFile_whenCss() {
    // Arrange, Act and Assert
    assertFalse(resourceBundlingServiceImpl.checkForRegisteredBundleFile(".css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}.
   * <ul>
   *   <li>When {@code /css/.css}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.checkForRegisteredBundleFile(String)"})
  public void testCheckForRegisteredBundleFile_whenCssCss() {
    // Arrange, Act and Assert
    assertFalse(resourceBundlingServiceImpl.checkForRegisteredBundleFile("/css/.css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}.
   * <ul>
   *   <li>When {@code .js}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.checkForRegisteredBundleFile(String)"})
  public void testCheckForRegisteredBundleFile_whenJs() {
    // Arrange, Act and Assert
    assertFalse(resourceBundlingServiceImpl.checkForRegisteredBundleFile(".js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}.
   * <ul>
   *   <li>When {@code /js/.js}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.checkForRegisteredBundleFile(String)"})
  public void testCheckForRegisteredBundleFile_whenJsJs() {
    // Arrange, Act and Assert
    assertFalse(resourceBundlingServiceImpl.checkForRegisteredBundleFile("/js/.js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#addVersion(String, String)}.
   * <ul>
   *   <li>When {@code Request Path}.</li>
   *   <li>Then return {@code Request Path1.0.2.null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundlingServiceImpl#addVersion(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ResourceBundlingServiceImpl.addVersion(String, String)"})
  public void testAddVersion_whenRequestPath_thenReturnRequestPath102Null() {
    // Arrange, Act and Assert
    assertEquals("Request Path1.0.2.null", resourceBundlingServiceImpl.addVersion("Request Path", "1.0.2"));
  }
}
