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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
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

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class MultiTenantCopierDiffblueTest {
  @Mock
  private Collection collection;

  @InjectMocks
  private EntityDuplicatorImpl entityDuplicatorImpl;

  @Mock
  private GenericEntityService genericEntityService;

  /**
   * Test {@link MultiTenantCopier#getOrder()}.
   * <p>
   * Method under test: {@link MultiTenantCopier#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MultiTenantCopier.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(0, (new EntityDuplicatorImpl()).getOrder());
  }

  /**
   * Test {@link MultiTenantCopier#setOrder(int)}.
   * <p>
   * Method under test: {@link MultiTenantCopier#setOrder(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * Test {@link MultiTenantCopier#excludeFromCopyRegexPattern(Object)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopier#excludeFromCopyRegexPattern(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean MultiTenantCopier.excludeFromCopyRegexPattern(Object)"})
  public void testExcludeFromCopyRegexPattern_givenEntityDuplicatorImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new EntityDuplicatorImpl()).excludeFromCopyRegexPattern(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link MultiTenantCopier#excludeFromCopyRegexPattern(Object)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopier#excludeFromCopyRegexPattern(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean MultiTenantCopier.excludeFromCopyRegexPattern(Object)"})
  public void testExcludeFromCopyRegexPattern_thenReturnFalse() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    entityDuplicatorImpl.addPattern(Pattern.compile(".*\\.txt"));

    // Act and Assert
    assertFalse(entityDuplicatorImpl.excludeFromCopyRegexPattern(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link MultiTenantCopier#save(MultiTenantCopyContext, Object)}.
   * <ul>
   *   <li>Given {@link CatalogImpl} (default constructor).</li>
   *   <li>Then calls {@link MultiTenantCopyContext#getToCatalog()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopier#save(MultiTenantCopyContext, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object MultiTenantCopier.save(MultiTenantCopyContext, Object)"})
  public void testSave_givenCatalogImpl_thenCallsGetToCatalog() throws ServiceException {
    // Arrange
    when(genericEntityService.save(Mockito.<Object>any())).thenReturn(BLCFieldUtils.NULL_FIELD);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getToCatalog()).thenReturn(new CatalogImpl());
    when(context.getToSite()).thenReturn(new SiteImpl());
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    Object actualSaveResult = entityDuplicatorImpl.save(context, object);

    // Assert
    verify(context).getToCatalog();
    verify(context, atLeast(1)).getToSite();
    verify(genericEntityService).save(isA(Object.class));
    assertSame(object, actualSaveResult);
  }

  /**
   * Test {@link MultiTenantCopier#readCount(Class, Site, Catalog)}.
   * <ul>
   *   <li>Then return longValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopier#readCount(Class, Site, Catalog)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * Test {@link MultiTenantCopier#readAllIds(Class, Site, Catalog)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopier#readAllIds(Class, Site, Catalog)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MultiTenantCopier.readAllIds(Class, Site, Catalog)"})
  public void testReadAllIds_thenReturnEmpty() throws ServiceException {
    // Arrange
    when(genericEntityService.readAllGenericEntityId(Mockito.<Class<Object>>any())).thenReturn(new ArrayList<>());
    Class<Object> clazz = Object.class;
    SiteImpl site = new SiteImpl();

    // Act
    List<Long> actualReadAllIdsResult = entityDuplicatorImpl.readAllIds(clazz, site, new CatalogImpl());

    // Assert
    verify(genericEntityService).readAllGenericEntityId(isA(Class.class));
    assertTrue(actualReadAllIdsResult.isEmpty());
  }

  /**
   * Test {@link MultiTenantCopier#addPattern(Pattern)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopier#addPattern(Pattern)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then {@link EntityDuplicatorImpl} (default constructor) {@link MultiTenantCopier#classExcludeRegexPatternList} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopier#addPattern(Pattern)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then {@link EntityDuplicatorImpl} (default constructor) {@link MultiTenantCopier#classExcludeRegexPatternList} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopier#addPattern(Pattern)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MultiTenantCopier.addPattern(Pattern)"})
  public void testAddPattern_thenEntityDuplicatorImplClassExcludeRegexPatternListSizeIsTwo() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    Pattern pattern = Pattern.compile("foo");
    entityDuplicatorImpl.addPattern(pattern);
    Pattern pattern2 = Pattern.compile(".*\\.txt");

    // Act
    entityDuplicatorImpl.addPattern(pattern2);

    // Assert
    List<Pattern> patternList = entityDuplicatorImpl.classExcludeRegexPatternList;
    assertEquals(2, patternList.size());
    assertSame(pattern2, patternList.get(1));
    assertSame(pattern, patternList.get(0));
  }

  /**
   * Test {@link MultiTenantCopier#needToAdd(Pattern)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor) addPattern compile {@code foo}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopier#needToAdd(Pattern)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MultiTenantCopier.needToAdd(Pattern)"})
  public void testNeedToAdd_givenEntityDuplicatorImplAddPatternCompileFoo_thenReturnTrue() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();
    entityDuplicatorImpl.addPattern(Pattern.compile("foo"));

    // Act and Assert
    assertTrue(entityDuplicatorImpl.needToAdd(Pattern.compile(".*\\.txt")));
  }

  /**
   * Test {@link MultiTenantCopier#needToAdd(Pattern)}.
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor) addPattern compile {@code .*\.txt}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopier#needToAdd(Pattern)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Given {@link EntityDuplicatorImpl} (default constructor).</li>
   *   <li>When compile {@code .*\.txt}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultiTenantCopier#needToAdd(Pattern)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MultiTenantCopier.needToAdd(Pattern)"})
  public void testNeedToAdd_givenEntityDuplicatorImpl_whenCompileTxt_thenReturnTrue() {
    // Arrange
    EntityDuplicatorImpl entityDuplicatorImpl = new EntityDuplicatorImpl();

    // Act and Assert
    assertTrue(entityDuplicatorImpl.needToAdd(Pattern.compile(".*\\.txt")));
  }
}
