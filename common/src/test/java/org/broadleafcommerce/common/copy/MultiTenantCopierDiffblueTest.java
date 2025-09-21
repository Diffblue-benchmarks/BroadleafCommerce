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
package org.broadleafcommerce.common.copy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.broadleafcommerce.common.config.domain.SystemPropertyImpl;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.persistence.EntityDuplicatorImpl;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.Catalog;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class MultiTenantCopierDiffblueTest {
  @InjectMocks private EntityDuplicatorImpl entityDuplicatorImpl;

  @Mock private GenericEntityService genericEntityService;

  /**
   * Test {@link MultiTenantCopier#getOrder()}.
   *
   * <p>Method under test: {@link MultiTenantCopier#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int MultiTenantCopier.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(0, new EntityDuplicatorImpl().getOrder());
  }

  /**
   * Test {@link MultiTenantCopier#setOrder(int)}.
   *
   * <p>Method under test: {@link MultiTenantCopier#setOrder(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiTenantCopier.setOrder(int)"})
  public void testSetOrder() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();

    // Act
    entityDuplicatorImpl.setOrder(1);

    // Assert
    assertEquals(1, entityDuplicatorImpl.getOrder());
  }

  /**
   * Test {@link MultiTenantCopier#persistCopyObjectTreeInternal(Object, Set,
   * MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given empty array of {@link Field}.
   *   <li>Then calls {@link MultiTenantCopyContext#getAllFields(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#persistCopyObjectTreeInternal(Object, Set,
   * MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MultiTenantCopier.persistCopyObjectTreeInternal(Object, Set, MultiTenantCopyContext)"
  })
  public void testPersistCopyObjectTreeInternal_givenEmptyArrayOfField_thenCallsGetAllFields() {
    // Arrange
    when(genericEntityService.sessionContains(Mockito.<Object>any())).thenReturn(true);
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    HashSet<Integer> library = new HashSet<>();

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getAllFields(Mockito.<Class<?>>any())).thenReturn(new Field[] {});

    // Act
    entityDuplicatorImpl.persistCopyObjectTreeInternal(systemPropertyImpl, library, context);

    // Assert
    verify(context).getAllFields(isA(Class.class));
    verify(genericEntityService).sessionContains(isA(Object.class));
    assertEquals(1, library.size());
  }

  /**
   * Test {@link MultiTenantCopier#excludeFromCopyRegexPattern(Object)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor) addPattern compile {@code
   *       .*\.txt}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#excludeFromCopyRegexPattern(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean MultiTenantCopier.excludeFromCopyRegexPattern(Object)"})
  public void testExcludeFromCopyRegexPattern_givenEntityDuplicatorImplAddPatternCompileTxt() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    entityDuplicatorImpl.addPattern(Pattern.compile(".*\\.txt"));

    // Act and Assert
    assertFalse(entityDuplicatorImpl.excludeFromCopyRegexPattern(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link MultiTenantCopier#excludeFromCopyRegexPattern(Object)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#excludeFromCopyRegexPattern(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean MultiTenantCopier.excludeFromCopyRegexPattern(Object)"})
  public void testExcludeFromCopyRegexPattern_givenEntityDuplicatorImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EntityDuplicatorImpl().excludeFromCopyRegexPattern(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link MultiTenantCopier#readCount(Class, Site, Catalog)}.
   *
   * <ul>
   *   <li>Then return longValue is three.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#readCount(Class, Site, Catalog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MultiTenantCopier.readCount(Class, Site, Catalog)"})
  public void testReadCount_thenReturnLongValueIsThree() throws ServiceException {
    // Arrange
    when(genericEntityService.readCountGenericEntity(Mockito.<Class<Object>>any())).thenReturn(3L);
    Class<Object> clazz = Object.class;
    SiteImpl site = new SiteImpl();

    // Act
    Long actualReadCountResult = entityDuplicatorImpl.readCount(clazz, site, new CatalogImpl());

    // Assert
    verify(genericEntityService).readCountGenericEntity(isA(Class.class));
    assertEquals(3L, actualReadCountResult.longValue());
  }

  /**
   * Test {@link MultiTenantCopier#readCount(Class, Site, Catalog)}.
   *
   * <ul>
   *   <li>Then return longValue is three.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#readCount(Class, Site, Catalog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MultiTenantCopier.readCount(Class, Site, Catalog)"})
  public void testReadCount_thenReturnLongValueIsThree2() throws ServiceException {
    // Arrange
    when(genericEntityService.readCountGenericEntity(Mockito.<Class<Object>>any())).thenReturn(3L);
    Class<Object> clazz = Object.class;

    // Act
    Long actualReadCountResult = entityDuplicatorImpl.readCount(clazz, null, new CatalogImpl());

    // Assert
    verify(genericEntityService).readCountGenericEntity(isA(Class.class));
    assertEquals(3L, actualReadCountResult.longValue());
  }

  /**
   * Test {@link MultiTenantCopier#readAllIds(Class, Site, Catalog)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#readAllIds(Class, Site, Catalog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List MultiTenantCopier.readAllIds(Class, Site, Catalog)"})
  public void testReadAllIds_thenReturnEmpty() throws ServiceException {
    // Arrange
    when(genericEntityService.readAllGenericEntityId(Mockito.<Class<?>>any()))
        .thenReturn(new ArrayList<>());
    Class<Object> clazz = Object.class;
    SiteImpl site = new SiteImpl();

    // Act
    List<Long> actualReadAllIdsResult =
        entityDuplicatorImpl.readAllIds(clazz, site, new CatalogImpl());

    // Assert
    verify(genericEntityService).readAllGenericEntityId(isA(Class.class));
    assertTrue(actualReadAllIdsResult.isEmpty());
  }

  /**
   * Test {@link MultiTenantCopier#readAllIds(Class, Site, Catalog)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#readAllIds(Class, Site, Catalog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List MultiTenantCopier.readAllIds(Class, Site, Catalog)"})
  public void testReadAllIds_thenReturnEmpty2() throws ServiceException {
    // Arrange
    when(genericEntityService.readAllGenericEntityId(Mockito.<Class<?>>any()))
        .thenReturn(new ArrayList<>());
    Class<Object> clazz = Object.class;

    // Act
    List<Long> actualReadAllIdsResult =
        entityDuplicatorImpl.readAllIds(clazz, null, new CatalogImpl());

    // Assert
    verify(genericEntityService).readAllGenericEntityId(isA(Class.class));
    assertTrue(actualReadAllIdsResult.isEmpty());
  }

  /**
   * Test {@link MultiTenantCopier#addPattern(Pattern)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#addPattern(Pattern)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiTenantCopier.addPattern(Pattern)"})
  public void testAddPattern_givenEntityDuplicatorImpl() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    Pattern pattern = Pattern.compile(".*\\.txt");

    // Act
    entityDuplicatorImpl.addPattern(pattern);

    // Assert
    List<Pattern> patternList = entityDuplicatorImpl.classExcludeRegexPatternList;
    assertEquals(1, patternList.size());
    assertSame(pattern, patternList.get(0));
  }

  /**
   * Test {@link MultiTenantCopier#addPattern(Pattern)}.
   *
   * <ul>
   *   <li>Then {@link EntityDuplicatorImpl} (default constructor) {@link
   *       MultiTenantCopier#classExcludeRegexPatternList} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#addPattern(Pattern)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiTenantCopier.addPattern(Pattern)"})
  public void testAddPattern_thenEntityDuplicatorImplClassExcludeRegexPatternListSizeIsOne() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    Pattern pattern = Pattern.compile(".*\\.txt");
    entityDuplicatorImpl.addPattern(pattern);

    // Act
    entityDuplicatorImpl.addPattern(Pattern.compile(".*\\.txt"));

    // Assert that nothing has changed
    List<Pattern> patternList = entityDuplicatorImpl.classExcludeRegexPatternList;
    assertEquals(1, patternList.size());
    assertSame(pattern, patternList.get(0));
  }

  /**
   * Test {@link MultiTenantCopier#addPattern(Pattern)}.
   *
   * <ul>
   *   <li>Then {@link EntityDuplicatorImpl} (default constructor) {@link
   *       MultiTenantCopier#classExcludeRegexPatternList} size is two.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#addPattern(Pattern)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiTenantCopier.addPattern(Pattern)"})
  public void testAddPattern_thenEntityDuplicatorImplClassExcludeRegexPatternListSizeIsTwo() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    Pattern pattern = Pattern.compile("foo");
    entityDuplicatorImpl.addPattern(pattern);
    entityDuplicatorImpl.addPattern(Pattern.compile(".*\\.txt"));

    // Act
    entityDuplicatorImpl.addPattern(Pattern.compile(".*\\.txt"));

    // Assert that nothing has changed
    List<Pattern> patternList = entityDuplicatorImpl.classExcludeRegexPatternList;
    assertEquals(2, patternList.size());
    assertSame(pattern, patternList.get(0));
  }

  /**
   * Test {@link MultiTenantCopier#needToAdd(Pattern)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor) addPattern compile {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#needToAdd(Pattern)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultiTenantCopier.needToAdd(Pattern)"})
  public void testNeedToAdd_givenEntityDuplicatorImplAddPatternCompileFoo_thenReturnFalse() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    entityDuplicatorImpl.addPattern(Pattern.compile("foo"));
    entityDuplicatorImpl.addPattern(Pattern.compile(".*\\.txt"));

    // Act and Assert
    assertFalse(entityDuplicatorImpl.needToAdd(Pattern.compile(".*\\.txt")));
  }

  /**
   * Test {@link MultiTenantCopier#needToAdd(Pattern)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor) addPattern compile {@code
   *       .*\.txt}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#needToAdd(Pattern)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultiTenantCopier.needToAdd(Pattern)"})
  public void testNeedToAdd_givenEntityDuplicatorImplAddPatternCompileTxt_thenReturnFalse() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    entityDuplicatorImpl.addPattern(Pattern.compile(".*\\.txt"));

    // Act and Assert
    assertFalse(entityDuplicatorImpl.needToAdd(Pattern.compile(".*\\.txt")));
  }

  /**
   * Test {@link MultiTenantCopier#needToAdd(Pattern)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor).
   *   <li>When compile {@code .*\.txt}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MultiTenantCopier#needToAdd(Pattern)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultiTenantCopier.needToAdd(Pattern)"})
  public void testNeedToAdd_givenEntityDuplicatorImpl_whenCompileTxt_thenReturnTrue() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();

    // Act and Assert
    assertTrue(entityDuplicatorImpl.needToAdd(Pattern.compile(".*\\.txt")));
  }
}
