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
package org.broadleafcommerce.common.sitemap.wrapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SiteMapURLWrapperDiffblueTest {
  /**
   * Test {@link SiteMapURLWrapper#addImage(SiteMapImageWrapper)}.
   * <p>
   * Method under test: {@link SiteMapURLWrapper#addImage(SiteMapImageWrapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteMapURLWrapper.addImage(SiteMapImageWrapper)"})
  public void testAddImage() {
    // Arrange
    SiteMapURLWrapper siteMapURLWrapper = new SiteMapURLWrapper();

    SiteMapImageWrapper siteMapImage = new SiteMapImageWrapper();
    siteMapImage.setLoc("Loc");

    // Act
    siteMapURLWrapper.addImage(siteMapImage);

    // Assert
    List<SiteMapImageWrapper> siteMapImageWrappers = siteMapURLWrapper.getSiteMapImageWrappers();
    assertEquals(1, siteMapImageWrappers.size());
    assertSame(siteMapImage, siteMapImageWrappers.get(0));
  }

  /**
   * Test {@link SiteMapURLWrapper#setPriorityType(SiteMapPriorityType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SiteMapURLWrapper} (default constructor) Priority is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapURLWrapper#setPriorityType(SiteMapPriorityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteMapURLWrapper.setPriorityType(SiteMapPriorityType)"})
  public void testSetPriorityType_whenNull_thenSiteMapURLWrapperPriorityIsNull() {
    // Arrange
    SiteMapURLWrapper siteMapURLWrapper = new SiteMapURLWrapper();

    // Act
    siteMapURLWrapper.setPriorityType(null);

    // Assert that nothing has changed
    assertNull(siteMapURLWrapper.getPriority());
  }

  /**
   * Test {@link SiteMapURLWrapper#setPriorityType(SiteMapPriorityType)}.
   * <ul>
   *   <li>When {@link SiteMapPriorityType#ONE}.</li>
   *   <li>Then {@link SiteMapURLWrapper} (default constructor) Priority is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapURLWrapper#setPriorityType(SiteMapPriorityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteMapURLWrapper.setPriorityType(SiteMapPriorityType)"})
  public void testSetPriorityType_whenOne_thenSiteMapURLWrapperPriorityIs10() {
    // Arrange
    SiteMapURLWrapper siteMapURLWrapper = new SiteMapURLWrapper();

    // Act
    siteMapURLWrapper.setPriorityType(SiteMapPriorityType.ONE);

    // Assert
    assertEquals("1.0", siteMapURLWrapper.getPriority());
  }

  /**
   * Test {@link SiteMapURLWrapper#setChangeFreqType(SiteMapChangeFreqType)}.
   * <ul>
   *   <li>When {@link SiteMapChangeFreqType#ALWAYS}.</li>
   *   <li>Then {@link SiteMapURLWrapper} (default constructor) Changefreq is {@code always}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapURLWrapper#setChangeFreqType(SiteMapChangeFreqType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteMapURLWrapper.setChangeFreqType(SiteMapChangeFreqType)"})
  public void testSetChangeFreqType_whenAlways_thenSiteMapURLWrapperChangefreqIsAlways() {
    // Arrange
    SiteMapURLWrapper siteMapURLWrapper = new SiteMapURLWrapper();

    // Act
    siteMapURLWrapper.setChangeFreqType(SiteMapChangeFreqType.ALWAYS);

    // Assert
    assertEquals("always", siteMapURLWrapper.getChangefreq());
  }

  /**
   * Test {@link SiteMapURLWrapper#setChangeFreqType(SiteMapChangeFreqType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SiteMapURLWrapper} (default constructor) Changefreq is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapURLWrapper#setChangeFreqType(SiteMapChangeFreqType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteMapURLWrapper.setChangeFreqType(SiteMapChangeFreqType)"})
  public void testSetChangeFreqType_whenNull_thenSiteMapURLWrapperChangefreqIsNull() {
    // Arrange
    SiteMapURLWrapper siteMapURLWrapper = new SiteMapURLWrapper();

    // Act
    siteMapURLWrapper.setChangeFreqType(null);

    // Assert that nothing has changed
    assertNull(siteMapURLWrapper.getChangefreq());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SiteMapURLWrapper}
   *   <li>{@link SiteMapURLWrapper#setChangefreq(String)}
   *   <li>{@link SiteMapURLWrapper#setLastmod(String)}
   *   <li>{@link SiteMapURLWrapper#setLoc(String)}
   *   <li>{@link SiteMapURLWrapper#setPriority(String)}
   *   <li>{@link SiteMapURLWrapper#setSiteMapImageWrappers(List)}
   *   <li>{@link SiteMapURLWrapper#getChangefreq()}
   *   <li>{@link SiteMapURLWrapper#getLastmod()}
   *   <li>{@link SiteMapURLWrapper#getLoc()}
   *   <li>{@link SiteMapURLWrapper#getPriority()}
   *   <li>{@link SiteMapURLWrapper#getSiteMapImageWrappers()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteMapURLWrapper.<init>()", "String SiteMapURLWrapper.getChangefreq()",
      "String SiteMapURLWrapper.getLastmod()", "String SiteMapURLWrapper.getLoc()",
      "String SiteMapURLWrapper.getPriority()", "List SiteMapURLWrapper.getSiteMapImageWrappers()",
      "void SiteMapURLWrapper.setChangefreq(String)", "void SiteMapURLWrapper.setLastmod(String)",
      "void SiteMapURLWrapper.setLoc(String)", "void SiteMapURLWrapper.setPriority(String)",
      "void SiteMapURLWrapper.setSiteMapImageWrappers(List)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    SiteMapURLWrapper actualSiteMapURLWrapper = new SiteMapURLWrapper();
    actualSiteMapURLWrapper.setChangefreq("https://example.org/example");
    actualSiteMapURLWrapper.setLastmod("https://example.org/example");
    actualSiteMapURLWrapper.setLoc("https://example.org/example");
    actualSiteMapURLWrapper.setPriority("https://example.org/example");
    ArrayList<SiteMapImageWrapper> siteMapImageWrappers = new ArrayList<>();
    actualSiteMapURLWrapper.setSiteMapImageWrappers(siteMapImageWrappers);
    String actualChangefreq = actualSiteMapURLWrapper.getChangefreq();
    String actualLastmod = actualSiteMapURLWrapper.getLastmod();
    String actualLoc = actualSiteMapURLWrapper.getLoc();
    String actualPriority = actualSiteMapURLWrapper.getPriority();
    List<SiteMapImageWrapper> actualSiteMapImageWrappers = actualSiteMapURLWrapper.getSiteMapImageWrappers();

    // Assert
    assertEquals("https://example.org/example", actualChangefreq);
    assertEquals("https://example.org/example", actualLastmod);
    assertEquals("https://example.org/example", actualLoc);
    assertEquals("https://example.org/example", actualPriority);
    assertTrue(actualSiteMapImageWrappers.isEmpty());
    assertSame(siteMapImageWrappers, actualSiteMapImageWrappers);
  }
}
