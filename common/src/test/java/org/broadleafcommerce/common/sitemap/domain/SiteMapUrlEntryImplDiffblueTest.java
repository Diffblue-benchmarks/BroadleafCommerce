/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapChangeFreqType;
import org.broadleafcommerce.common.sitemap.service.type.SiteMapPriorityType;
import org.junit.Test;

public class SiteMapUrlEntryImplDiffblueTest {
  /**
   * Test {@link SiteMapUrlEntryImpl#getSiteMapChangeFreq()}.
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#getSiteMapChangeFreq()}
   */
  @Test
  public void testGetSiteMapChangeFreq() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl
        .setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapUrlEntryImpl.setLocation("https://example.org/example");
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);

    // Act
    SiteMapChangeFreqType actualSiteMapChangeFreq = siteMapUrlEntryImpl.getSiteMapChangeFreq();

    // Assert
    assertSame(actualSiteMapChangeFreq.ALWAYS, actualSiteMapChangeFreq);
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#getSiteMapChangeFreq()}.
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#getSiteMapChangeFreq()}
   */
  @Test
  public void testGetSiteMapChangeFreq2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(mock(CustomUrlSiteMapGeneratorConfiguration.class));
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl
        .setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapUrlEntryImpl.setLocation("https://example.org/example");
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);

    // Act
    SiteMapChangeFreqType actualSiteMapChangeFreq = siteMapUrlEntryImpl.getSiteMapChangeFreq();

    // Assert
    assertSame(actualSiteMapChangeFreq.ALWAYS, actualSiteMapChangeFreq);
  }

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
  public void testGetSiteMapChangeFreq_givenSiteMapUrlEntryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteMapUrlEntryImpl()).getSiteMapChangeFreq());
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}.
   * <ul>
   *   <li>Then {@link SiteMapUrlEntryImpl} (default constructor)
   * {@link SiteMapUrlEntryImpl#changeFreq} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapUrlEntryImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}
   */
  @Test
  public void testSetSiteMapChangeFreq_thenSiteMapUrlEntryImplChangeFreqIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl
        .setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapUrlEntryImpl.setLocation("https://example.org/example");
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act
    siteMapUrlEntryImpl.setSiteMapChangeFreq(null);

    // Assert
    assertNull(siteMapUrlEntryImpl.changeFreq);
    assertNull(siteMapUrlEntryImpl.getSiteMapChangeFreq());
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}.
   * <ul>
   *   <li>When {@link SiteMapChangeFreqType#ALWAYS}.</li>
   *   <li>Then {@link SiteMapUrlEntryImpl} (default constructor)
   * {@link SiteMapUrlEntryImpl#changeFreq} is {@code ALWAYS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapUrlEntryImpl#setSiteMapChangeFreq(SiteMapChangeFreqType)}
   */
  @Test
  public void testSetSiteMapChangeFreq_whenAlways_thenSiteMapUrlEntryImplChangeFreqIsAlways() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    SiteMapChangeFreqType siteMapChangeFreq = SiteMapChangeFreqType.ALWAYS;

    // Act
    siteMapUrlEntryImpl.setSiteMapChangeFreq(siteMapChangeFreq);

    // Assert
    assertEquals("ALWAYS", siteMapUrlEntryImpl.changeFreq);
    SiteMapChangeFreqType expectedSiteMapChangeFreq = siteMapChangeFreq.ALWAYS;
    assertSame(expectedSiteMapChangeFreq, siteMapUrlEntryImpl.getSiteMapChangeFreq());
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#getSiteMapPriority()}.
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#getSiteMapPriority()}
   */
  @Test
  public void testGetSiteMapPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl
        .setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapUrlEntryImpl.setLocation("https://example.org/example");
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act
    SiteMapPriorityType actualSiteMapPriority = siteMapUrlEntryImpl.getSiteMapPriority();

    // Assert
    assertSame(actualSiteMapPriority.ONE, actualSiteMapPriority);
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#getSiteMapPriority()}.
   * <p>
   * Method under test: {@link SiteMapUrlEntryImpl#getSiteMapPriority()}
   */
  @Test
  public void testGetSiteMapPriority2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(mock(CustomUrlSiteMapGeneratorConfiguration.class));
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl
        .setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapUrlEntryImpl.setLocation("https://example.org/example");
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act
    SiteMapPriorityType actualSiteMapPriority = siteMapUrlEntryImpl.getSiteMapPriority();

    // Assert
    assertSame(actualSiteMapPriority.ONE, actualSiteMapPriority);
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
  public void testGetSiteMapPriority_givenSiteMapUrlEntryImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteMapUrlEntryImpl()).getSiteMapPriority());
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#setSiteMapPriority(SiteMapPriorityType)}.
   * <ul>
   *   <li>Then {@link SiteMapUrlEntryImpl} (default constructor)
   * {@link SiteMapUrlEntryImpl#priority} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapUrlEntryImpl#setSiteMapPriority(SiteMapPriorityType)}
   */
  @Test
  public void testSetSiteMapPriority_thenSiteMapUrlEntryImplPriorityIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    siteMapUrlEntryImpl.setCustomUrlSiteMapGeneratorConfiguration(new CustomUrlSiteMapGeneratorConfigurationImpl());
    siteMapUrlEntryImpl.setId(1L);
    siteMapUrlEntryImpl
        .setLastMod(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    siteMapUrlEntryImpl.setLocation("https://example.org/example");
    siteMapUrlEntryImpl.setSiteMapChangeFreq(SiteMapChangeFreqType.ALWAYS);
    siteMapUrlEntryImpl.setSiteMapPriority(SiteMapPriorityType.ONE);

    // Act
    siteMapUrlEntryImpl.setSiteMapPriority(null);

    // Assert
    assertNull(siteMapUrlEntryImpl.priority);
    assertNull(siteMapUrlEntryImpl.getSiteMapPriority());
  }

  /**
   * Test {@link SiteMapUrlEntryImpl#setSiteMapPriority(SiteMapPriorityType)}.
   * <ul>
   *   <li>When {@link SiteMapPriorityType#ONE}.</li>
   *   <li>Then {@link SiteMapUrlEntryImpl} (default constructor)
   * {@link SiteMapUrlEntryImpl#priority} is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SiteMapUrlEntryImpl#setSiteMapPriority(SiteMapPriorityType)}
   */
  @Test
  public void testSetSiteMapPriority_whenOne_thenSiteMapUrlEntryImplPriorityIs10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteMapUrlEntryImpl siteMapUrlEntryImpl = new SiteMapUrlEntryImpl();
    SiteMapPriorityType siteMapPriority = SiteMapPriorityType.ONE;

    // Act
    siteMapUrlEntryImpl.setSiteMapPriority(siteMapPriority);

    // Assert
    assertEquals("1.0", siteMapUrlEntryImpl.priority);
    SiteMapPriorityType expectedSiteMapPriority = siteMapPriority.ONE;
    assertSame(expectedSiteMapPriority, siteMapUrlEntryImpl.getSiteMapPriority());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SiteMapUrlEntryImpl}
   *   <li>
   * {@link SiteMapUrlEntryImpl#setCustomUrlSiteMapGeneratorConfiguration(CustomUrlSiteMapGeneratorConfiguration)}
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

    // Assert that nothing has changed
    assertEquals("https://example.org/example", actualSiteMapUrlEntryImpl.getLocation());
    assertEquals(1L, actualId.longValue());
    assertSame(customUrlSiteMapGeneratorConfiguration, actualCustomUrlSiteMapGeneratorConfiguration);
    assertSame(lastModified, actualLastMod);
  }
}
