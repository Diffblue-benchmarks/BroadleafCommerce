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
package org.broadleafcommerce.common.sitemap.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-common-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SiteMapUrlEntryImplDiffblueTest {
  @Autowired
  private SiteMapUrlEntryImpl siteMapUrlEntryImpl;

  /**
   * Test {@link SiteMapUrlEntryImpl#getSiteMapChangeFreq()}.
   * <ul>
   *   <li>Given {@link SiteMapUrlEntryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#getSiteMapChangeFreq()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SiteMapChangeFreqType SiteMapUrlEntryImpl.getSiteMapChangeFreq()"})
  public void testGetSiteMapChangeFreq_givenSiteMapUrlEntryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SiteMapUrlEntryImpl()).getSiteMapChangeFreq());
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#getSiteMapChangeFreq()}.
   * <ul>
   *   <li>Then return {@link SiteMapChangeFreqType#ALWAYS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#getSiteMapChangeFreq()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SiteMapChangeFreqType SiteMapUrlEntryImpl.getSiteMapChangeFreq()"})
  public void testGetSiteMapChangeFreq_thenReturnAlways() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl2 = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl2.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl2.setId(1L);
    siteMapUrlEntryImpl2
        .setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapUrlEntryImpl2.setLocation("https://example.org/example");
    siteMapUrlEntryImpl2.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl2.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);

    // Act
    SiteMapChangeFreqType actualSiteMapChangeFreq = siteMapUrlEntryImpl2.getSiteMapChangeFreq();

    // Assert
    assertSame(actualSiteMapChangeFreq.ALWAYS, actualSiteMapChangeFreq);
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}.
   * <ul>
   *   <li>Then {@link SiteMapUrlEntryImpl} (default constructor) {@link SiteMapUrlEntryImpl#changeFreq} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType)"})
  public void testSetSiteMapChangeFreq_thenSiteMapUrlEntryImplChangeFreqIsNull() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl2 = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl2.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl2.setId(1L);
    siteMapUrlEntryImpl2
        .setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapUrlEntryImpl2.setLocation("https://example.org/example");
    siteMapUrlEntryImpl2.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl2.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act
    siteMapUrlEntryImpl2.setSiteMapChangeFreq(null);

    // Assert
    assertNull(siteMapUrlEntryImpl2.changeFreq);
    assertNull(siteMapUrlEntryImpl2.getSiteMapChangeFreq());
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}.
   * <ul>
   *   <li>When {@link SiteMapChangeFreqType#ALWAYS}.</li>
   *   <li>Then {@link SiteMapUrlEntryImpl} (default constructor) {@link SiteMapUrlEntryImpl#changeFreq} is {@code ALWAYS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType)"})
  public void testSetSiteMapChangeFreq_whenAlways_thenSiteMapUrlEntryImplChangeFreqIsAlways() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl2 = new SiteMapUrlEntryImpl();
    SiteMapChangeFreqType siteMapChangeFreq = SiteMapChangeFreqType.ALWAYS;

    // Act
    siteMapUrlEntryImpl2.setSiteMapChangeFreq(siteMapChangeFreq);

    // Assert
    assertEquals("ALWAYS", siteMapUrlEntryImpl2.changeFreq);
    SiteMapChangeFreqType expectedSiteMapChangeFreq = siteMapChangeFreq.ALWAYS;
    assertSame(expectedSiteMapChangeFreq, siteMapUrlEntryImpl2.getSiteMapChangeFreq());
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#getSiteMapPriority()}.
   * <ul>
   *   <li>Given {@link SiteMapUrlEntryImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#getSiteMapPriority()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SiteMapPriorityType SiteMapUrlEntryImpl.getSiteMapPriority()"})
  public void testGetSiteMapPriority_givenSiteMapUrlEntryImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SiteMapUrlEntryImpl()).getSiteMapPriority());
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#getSiteMapPriority()}.
   * <ul>
   *   <li>Then return {@link SiteMapPriorityType#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#getSiteMapPriority()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SiteMapPriorityType SiteMapUrlEntryImpl.getSiteMapPriority()"})
  public void testGetSiteMapPriority_thenReturnOne() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl2 = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl2.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl2.setId(1L);
    siteMapUrlEntryImpl2
        .setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapUrlEntryImpl2.setLocation("https://example.org/example");
    siteMapUrlEntryImpl2.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl2.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act
    SiteMapPriorityType actualSiteMapPriority = siteMapUrlEntryImpl2.getSiteMapPriority();

    // Assert
    assertSame(actualSiteMapPriority.ONE, actualSiteMapPriority);
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#setSiteMapPriority(SiteMapPriorityType)}.
   * <ul>
   *   <li>Then {@link SiteMapUrlEntryImpl} (default constructor) {@link SiteMapUrlEntryImpl#priority} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#setSiteMapPriority(SiteMapPriorityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType)"})
  public void testSetSiteMapPriority_thenSiteMapUrlEntryImplPriorityIsNull() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl2 = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl2.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl2.setId(1L);
    siteMapUrlEntryImpl2
        .setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapUrlEntryImpl2.setLocation("https://example.org/example");
    siteMapUrlEntryImpl2.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl2.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act
    siteMapUrlEntryImpl2.setSiteMapPriority(null);

    // Assert
    assertNull(siteMapUrlEntryImpl2.priority);
    assertNull(siteMapUrlEntryImpl2.getSiteMapPriority());
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#setSiteMapPriority(SiteMapPriorityType)}.
   * <ul>
   *   <li>When {@link SiteMapPriorityType#ONE}.</li>
   *   <li>Then {@link SiteMapUrlEntryImpl} (default constructor) {@link SiteMapUrlEntryImpl#priority} is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#setSiteMapPriority(SiteMapPriorityType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType)"})
  public void testSetSiteMapPriority_whenOne_thenSiteMapUrlEntryImplPriorityIs10() {
    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl2 = new SiteMapUrlEntryImpl();
    SiteMapPriorityType siteMapPriority = SiteMapPriorityType.ONE;

    // Act
    siteMapUrlEntryImpl2.setSiteMapPriority(siteMapPriority);

    // Assert
    assertEquals("1.0", siteMapUrlEntryImpl2.priority);
    SiteMapPriorityType expectedSiteMapPriority = siteMapPriority.ONE;
    assertSame(expectedSiteMapPriority, siteMapUrlEntryImpl2.getSiteMapPriority());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SiteMapUrlEntryImpl}
   *   <li>{@link SiteMapUrlEntryImpl#setCustomUrlSiteMapGeneratorConfiguration(CustomUrlSiteMapGeneratorConfiguration)}
   *   <li>{@link SiteMapUrlEntryImpl#setId(Long)}
   *   <li>{@link SiteMapUrlEntryImpl#setLastMod(Date)}
   *   <li>{@link SiteMapUrlEntryImpl#setLocation(String)}
   *   <li>{@link SiteMapUrlEntryImpl#getCustomUrlSiteMapGeneratorConfiguration()}
   *   <li>{@link SiteMapUrlEntryImpl#getId()}
   *   <li>{@link SiteMapUrlEntryImpl#getLastMod()}
   *   <li>{@link SiteMapUrlEntryImpl#getLocation()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteMapUrlEntryImpl.<init>()",
      "CustomUrlSiteMapGeneratorConfiguration SiteMapUrlEntryImpl.getCustomUrlSiteMapGeneratorConfiguration()",
      "Long SiteMapUrlEntryImpl.getId()", "Date SiteMapUrlEntryImpl.getLastMod()",
      "String SiteMapUrlEntryImpl.getLocation()",
      "void SiteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(CustomUrlSiteMapGeneratorConfiguration)",
      "void SiteMapUrlEntryImpl.setId(Long)", "void SiteMapUrlEntryImpl.setLastMod(Date)",
      "void SiteMapUrlEntryImpl.setLocation(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    SiteMapUrlEntryImpl actualSiteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    CustomUrlSiteMapGeneratorConfigurationImpl customUrlSiteMapGeneratorConfiguration = new CustomUrlSiteMapGeneratorConfigurationImpl();
    actualSiteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(customUrlSiteMapGeneratorConfiguration);
    actualSiteMapUrlEntryImpl.setId(1L);
    Date lastModified = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualSiteMapUrlEntryImpl.setLastMod(lastModified);
    actualSiteMapUrlEntryImpl.setLocation("https://example.org/example");
    CustomUrlSiteMapGeneratorConfiguration actualCustomUrlSiteMapGeneratorConfiguration = actualSiteMapUrlEntryImpl
        .getCustomUrlSiteMapGeneratorConfiguration();
    Long actualId = actualSiteMapUrlEntryImpl.getId();
    Date actualLastMod = actualSiteMapUrlEntryImpl.getLastMod();

    // Assert
    assertEquals("https://example.org/example", actualSiteMapUrlEntryImpl.getLocation());
    assertEquals(1L, actualId.longValue());
    assertSame(customUrlSiteMapGeneratorConfiguration, actualCustomUrlSiteMapGeneratorConfiguration);
    assertSame(lastModified, actualLastMod);
  }
}
