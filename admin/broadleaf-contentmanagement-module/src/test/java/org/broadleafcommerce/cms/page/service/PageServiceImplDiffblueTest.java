package org.broadleafcommerce.cms.page.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.cms.page.domain.Page;
import org.broadleafcommerce.cms.page.domain.PageTemplate;
import org.broadleafcommerce.cms.page.domain.PageTemplateImpl;
import org.broadleafcommerce.common.extension.ResultType;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.page.dto.NullPageDTO;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml",
    "/applicationContext-servlet-cms-contentCreator.xml", "/bl-cms-applicationContext-entity.xml",
    "/bl-cms-contentClient-applicationContext.xml", "/bl-cms-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-cms-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-cms-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PageServiceImplDiffblueTest {
  @Autowired
  private PageServiceImpl pageServiceImpl;

  /**
   * Test {@link PageServiceImpl#findPageById(Long)}.
   * <p>
   * Method under test: {@link PageServiceImpl#findPageById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindPageById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1165 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageServiceImpl()).findPageById(1L);
  }

  /**
   * Test {@link PageServiceImpl#findPageFieldMapByPageId(Long)}.
   * <p>
   * Method under test: {@link PageServiceImpl#findPageFieldMapByPageId(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindPageFieldMapByPageId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1218 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageServiceImpl()).findPageFieldMapByPageId(1L);
  }

  /**
   * Test {@link PageServiceImpl#findPageTemplateById(Long)}.
   * <p>
   * Method under test: {@link PageServiceImpl#findPageTemplateById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindPageTemplateById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1237 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageServiceImpl()).findPageTemplateById(1L);
  }

  /**
   * Test {@link PageServiceImpl#savePageTemplate(PageTemplate)}.
   * <p>
   * Method under test: {@link PageServiceImpl#savePageTemplate(PageTemplate)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSavePageTemplate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2403 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageServiceImpl pageServiceImpl2 = new PageServiceImpl();

    // Act
    pageServiceImpl2.savePageTemplate(new PageTemplateImpl());
  }

  /**
   * Test {@link PageServiceImpl#findPageByURI(Locale, String, Map, boolean)}.
   * <p>
   * Method under test:
   * {@link PageServiceImpl#findPageByURI(Locale, String, Map, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindPageByURI() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1184 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageServiceImpl pageServiceImpl2 = new PageServiceImpl();
    LocaleImpl locale = new LocaleImpl();

    // Act
    pageServiceImpl2.findPageByURI(locale, "Uri", new HashMap<>(), true);
  }

  /**
   * Test {@link PageServiceImpl#isNullPageCached(Locale, String, boolean)}.
   * <p>
   * Method under test:
   * {@link PageServiceImpl#isNullPageCached(Locale, String, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsNullPageCached() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1987 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageServiceImpl pageServiceImpl2 = new PageServiceImpl();

    // Act
    pageServiceImpl2.isNullPageCached(new LocaleImpl(), "Uri", true);
  }

  /**
   * Test {@link PageServiceImpl#getPageDTOListForURI(Locale, String, boolean)}.
   * <p>
   * Method under test:
   * {@link PageServiceImpl#getPageDTOListForURI(Locale, String, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPageDTOListForURI() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1610 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageServiceImpl pageServiceImpl2 = new PageServiceImpl();

    // Act
    pageServiceImpl2.getPageDTOListForURI(new LocaleImpl(), "Uri", true);
  }

  /**
   * Test {@link PageServiceImpl#getPageDTOListForURI(Locale, String, boolean)}.
   * <ul>
   *   <li>When {@link LocaleImpl}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#getPageDTOListForURI(Locale, String, boolean)}
   */
  @Test
  public void testGetPageDTOListForURI_whenLocaleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageServiceImpl()).getPageDTOListForURI(mock(LocaleImpl.class), null, true));
  }

  /**
   * Test {@link PageServiceImpl#addCachedDate(String)}.
   * <p>
   * Method under test: {@link PageServiceImpl#addCachedDate(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddCachedDate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass565 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageServiceImpl()).addCachedDate("Key");
  }

  /**
   * Test {@link PageServiceImpl#getCachedDate(String)}.
   * <p>
   * Method under test: {@link PageServiceImpl#getCachedDate(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCachedDate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1256 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageServiceImpl()).getCachedDate("Key");
  }

  /**
   * Test {@link PageServiceImpl#buildPageDTOList(List, boolean, String, Locale)}.
   * <p>
   * Method under test:
   * {@link PageServiceImpl#buildPageDTOList(List, boolean, String, Locale)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildPageDTOList() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1057 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageServiceImpl pageServiceImpl2 = new PageServiceImpl();
    ArrayList<Page> pageList = new ArrayList<>();

    // Act
    pageServiceImpl2.buildPageDTOList(pageList, true, "42", new LocaleImpl());
  }

  /**
   * Test
   * {@link PageServiceImpl#buildPageDTOListUsingCache(List, String, Locale, boolean)}.
   * <p>
   * Method under test:
   * {@link PageServiceImpl#buildPageDTOListUsingCache(List, String, Locale, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildPageDTOListUsingCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1088 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageServiceImpl pageServiceImpl2 = new PageServiceImpl();
    ArrayList<Page> pageList = new ArrayList<>();

    // Act
    pageServiceImpl2.buildPageDTOListUsingCache(pageList, "42", new LocaleImpl(), true);
  }

  /**
   * Test
   * {@link PageServiceImpl#getCachedPageDTOList(List, String, Locale, boolean)}.
   * <p>
   * Method under test:
   * {@link PageServiceImpl#getCachedPageDTOList(List, String, Locale, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCachedPageDTOList() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1574 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageServiceImpl pageServiceImpl2 = new PageServiceImpl();
    ArrayList<Page> pageList = new ArrayList<>();

    // Act
    pageServiceImpl2.getCachedPageDTOList(pageList, "42", new LocaleImpl(), true);
  }

  /**
   * Test {@link PageServiceImpl#addPageListToPageDTOList(List, boolean, List)}.
   * <p>
   * Method under test:
   * {@link PageServiceImpl#addPageListToPageDTOList(List, boolean, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddPageListToPageDTOList() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass914 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageServiceImpl pageServiceImpl2 = new PageServiceImpl();
    ArrayList<Page> pageList = new ArrayList<>();

    // Act
    pageServiceImpl2.addPageListToPageDTOList(pageList, true, new ArrayList<>());
  }

  /**
   * Test {@link PageServiceImpl#getPageListFromCache(String)}.
   * <p>
   * Method under test: {@link PageServiceImpl#getPageListFromCache(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPageListFromCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1637 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageServiceImpl()).getPageListFromCache("Key");
  }

  /**
   * Test {@link PageServiceImpl#getPageListFromCache(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#getPageListFromCache(String)}
   */
  @Test
  public void testGetPageListFromCache_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageServiceImpl()).getPageListFromCache(null));
  }

  /**
   * Test
   * {@link PageServiceImpl#addPageListToCache(List, String, Locale, boolean)}.
   * <p>
   * Method under test:
   * {@link PageServiceImpl#addPageListToCache(List, String, Locale, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddPageListToCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass883 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageServiceImpl pageServiceImpl2 = new PageServiceImpl();
    ArrayList<PageDTO> pageList = new ArrayList<>();

    // Act
    pageServiceImpl2.addPageListToCache(pageList, "42", new LocaleImpl(), true);
  }

  /**
   * Test {@link PageServiceImpl#addPageMapCacheEntry(String, String)}.
   * <p>
   * Method under test:
   * {@link PageServiceImpl#addPageMapCacheEntry(String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddPageMapCacheEntry() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass928 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageServiceImpl()).addPageMapCacheEntry("42", "Key");
  }

  /**
   * Test {@link PageServiceImpl#getPageMapCacheKey(String, Long)}.
   * <p>
   * Method under test: {@link PageServiceImpl#getPageMapCacheKey(String, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPageMapCacheKey() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1960 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageServiceImpl()).getPageMapCacheKey("Uri", 1L);
  }

  /**
   * Test {@link PageServiceImpl#getPageMapCacheKey(String, Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Uri-ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#getPageMapCacheKey(String, Long)}
   */
  @Test
  public void testGetPageMapCacheKey_whenNull_thenReturnUriAll() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Uri-ALL", (new PageServiceImpl()).getPageMapCacheKey("Uri", null));
  }

  /**
   * Test {@link PageServiceImpl#getPageMapCacheKey(String, Long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code Uri-1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#getPageMapCacheKey(String, Long)}
   */
  @Test
  public void testGetPageMapCacheKey_whenOne_thenReturnUri1() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Uri-1", (new PageServiceImpl()).getPageMapCacheKey("Uri", 1L));
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   * with {@code identifier}, {@code localeCode}, {@code secure},
   * {@code resultType}.
   * <p>
   * Method under test:
   * {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildKeyWithIdentifierLocaleCodeSecureResultType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass992 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageServiceImpl()).buildKey("42", "en", true, ResultType.STANDARD);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   * with {@code identifier}, {@code localeCode}, {@code secure},
   * {@code resultType}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42-en}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   */
  @Test
  public void testBuildKeyWithIdentifierLocaleCodeSecureResultType_when42_thenReturn42En() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42-en", (new PageServiceImpl()).buildKey("42", "en", null, ResultType.STANDARD));
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   * with {@code identifier}, {@code localeCode}, {@code secure},
   * {@code resultType}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42-en-true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   */
  @Test
  public void testBuildKeyWithIdentifierLocaleCodeSecureResultType_when42_thenReturn42EnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42-en-true", (new PageServiceImpl()).buildKey("42", "en", true, ResultType.STANDARD));
    assertEquals("42-en-true", (new PageServiceImpl()).buildKey("42", "en", true, null));
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   * with {@code identifier}, {@code localeCode}, {@code secure},
   * {@code resultType}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42-true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#buildKey(String, String, Boolean, ResultType)}
   */
  @Test
  public void testBuildKeyWithIdentifierLocaleCodeSecureResultType_when42_thenReturn42True() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42-true", (new PageServiceImpl()).buildKey("42", null, true, ResultType.STANDARD));
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with
   * {@code identifier}, {@code locale}, {@code secure}.
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildKeyWithIdentifierLocaleSecure() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1030 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageServiceImpl pageServiceImpl2 = new PageServiceImpl();

    // Act
    pageServiceImpl2.buildKey("42", new LocaleImpl(), true);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with
   * {@code identifier}, {@code locale}, {@code secure}.
   * <ul>
   *   <li>Given {@code en}.</li>
   *   <li>Then return {@code 42-en}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  public void testBuildKeyWithIdentifierLocaleSecure_givenEn_thenReturn42En() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    LocaleImpl locale = mock(LocaleImpl.class);
    when(locale.getLocaleCode()).thenReturn("en");

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", locale, null);

    // Assert
    verify(locale).getLocaleCode();
    assertEquals("42-en", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with
   * {@code identifier}, {@code locale}, {@code secure}.
   * <ul>
   *   <li>Given {@code en}.</li>
   *   <li>Then return {@code 42-en-true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  public void testBuildKeyWithIdentifierLocaleSecure_givenEn_thenReturn42EnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    LocaleImpl locale = mock(LocaleImpl.class);
    when(locale.getLocaleCode()).thenReturn("en");

    // Act
    String actualBuildKeyResult = pageServiceImpl.buildKey("42", locale, true);

    // Assert
    verify(locale).getLocaleCode();
    assertEquals("42-en-true", actualBuildKeyResult);
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with
   * {@code identifier}, {@code locale}, {@code secure}.
   * <ul>
   *   <li>When {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return {@code 42-true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  public void testBuildKeyWithIdentifierLocaleSecure_whenLocaleImpl_thenReturn42True() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

    // Act and Assert
    assertEquals("42-true", pageServiceImpl.buildKey("42", new LocaleImpl(), true));
  }

  /**
   * Test {@link PageServiceImpl#buildKey(String, Locale, Boolean)} with
   * {@code identifier}, {@code locale}, {@code secure}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code 42--true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#buildKey(String, Locale, Boolean)}
   */
  @Test
  public void testBuildKeyWithIdentifierLocaleSecure_whenNull_thenReturn42True() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42--true", (new PageServiceImpl()).buildKey("42", null, true));
  }

  /**
   * Test {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}.
   * <p>
   * Method under test:
   * {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildBaseKey() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass959 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageServiceImpl()).buildBaseKey("42", "en", true);
  }

  /**
   * Test {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}
   */
  @Test
  public void testBuildBaseKey_when42_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42", (new PageServiceImpl()).buildBaseKey("42", null, null));
  }

  /**
   * Test {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42-en-true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#buildBaseKey(String, String, Boolean)}
   */
  @Test
  public void testBuildBaseKey_when42_thenReturn42EnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42-en-true", (new PageServiceImpl()).buildBaseKey("42", "en", true));
  }

  /**
   * Test {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}.
   * <p>
   * Method under test: {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindLanguageOnlyLocale() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1152 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageServiceImpl pageServiceImpl2 = new PageServiceImpl();

    // Act
    pageServiceImpl2.findLanguageOnlyLocale(new LocaleImpl());
  }

  /**
   * Test {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  public void testFindLanguageOnlyLocale_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageServiceImpl()).findLanguageOnlyLocale(null));
  }

  /**
   * Test {@link PageServiceImpl#getPageCache()}.
   * <p>
   * Method under test: {@link PageServiceImpl#getPageCache()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPageCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1605 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageServiceImpl()).getPageCache();
  }

  /**
   * Test {@link PageServiceImpl#getPageMapCache()}.
   * <p>
   * Method under test: {@link PageServiceImpl#getPageMapCache()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPageMapCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1955 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageServiceImpl()).getPageMapCache();
  }

  /**
   * Test {@link PageServiceImpl#getUriCachedDateCache()}.
   * <p>
   * Method under test: {@link PageServiceImpl#getUriCachedDateCache()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetUriCachedDateCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1982 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageServiceImpl()).getUriCachedDateCache();
  }

  /**
   * Test {@link PageServiceImpl#copyDTOList(List)}.
   * <p>
   * Method under test: {@link PageServiceImpl#copyDTOList(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCopyDTOList() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1119 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageServiceImpl pageServiceImpl2 = new PageServiceImpl();

    // Act
    pageServiceImpl2.copyDTOList(new ArrayList<>());
  }

  /**
   * Test {@link PageServiceImpl#copyDTOList(List)}.
   * <ul>
   *   <li>Given {@link PageDTO} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link PageDTO} (default
   * constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#copyDTOList(List)}
   */
  @Test
  public void testCopyDTOList_givenPageDTO_whenArrayListAddPageDTO_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

    ArrayList<PageDTO> dtoList = new ArrayList<>();
    dtoList.add(new PageDTO());

    // Act
    List<PageDTO> actualCopyDTOListResult = pageServiceImpl.copyDTOList(dtoList);

    // Assert
    assertEquals(1, actualCopyDTOListResult.size());
    PageDTO getResult = actualCopyDTOListResult.get(0);
    assertNull(getResult.getPriority());
    assertNull(getResult.getId());
    assertNull(getResult.getDescription());
    assertNull(getResult.getLocaleCode());
    assertNull(getResult.getRuleExpression());
    assertNull(getResult.getTemplatePath());
    assertNull(getResult.getUrl());
    assertNull(getResult.getItemCriteriaDTOList());
    assertTrue(getResult.getForeignPageFields().isEmpty());
    assertTrue(getResult.getPageAttributes().isEmpty());
    assertTrue(getResult.getPageFields().isEmpty());
  }

  /**
   * Test {@link PageServiceImpl#copyDTOList(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#copyDTOList(List)}
   */
  @Test
  public void testCopyDTOList_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

    // Act and Assert
    assertTrue(pageServiceImpl.copyDTOList(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <p>
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEvaluatePageRules() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1128 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageServiceImpl pageServiceImpl2 = new PageServiceImpl();
    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    LocaleImpl locale = new LocaleImpl();

    // Act
    pageServiceImpl2.evaluatePageRules(pageDTOList, locale, new HashMap<>());
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <ul>
   *   <li>Given {@link PageDTO} (default constructor) LocaleCode is
   * {@code en}.</li>
   *   <li>Then calls {@link Locale#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules_givenPageDTOLocaleCodeIsEn_thenCallsGetLocaleCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

    PageDTO pageDTO = new PageDTO();
    pageDTO.setLocaleCode("en");

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    pageDTOList.add(pageDTO);
    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

    // Act
    PageDTO actualEvaluatePageRulesResult = pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>());

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    assertSame(pageDTO, actualEvaluatePageRulesResult);
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <ul>
   *   <li>Given {@link PageDTO} (default constructor).</li>
   *   <li>Then calls {@link Locale#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules_givenPageDTO_thenCallsGetLocaleCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    PageDTO pageDTO = new PageDTO();
    pageDTOList.add(pageDTO);
    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

    // Act
    PageDTO actualEvaluatePageRulesResult = pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>());

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    assertSame(pageDTO, actualEvaluatePageRulesResult);
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <ul>
   *   <li>Given {@link PageDTO} (default constructor).</li>
   *   <li>When {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return {@link PageDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules_givenPageDTO_whenLocaleImpl_thenReturnPageDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    PageDTO pageDTO = new PageDTO();
    pageDTOList.add(pageDTO);
    LocaleImpl locale = new LocaleImpl();

    // Act and Assert
    assertSame(pageDTO, pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>()));
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <ul>
   *   <li>Given {@link PageDTO} (default constructor).</li>
   *   <li>When {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return {@link PageDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules_givenPageDTO_whenLocaleImpl_thenReturnPageDTO2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    PageDTO pageDTO = new PageDTO();
    pageDTOList.add(pageDTO);
    pageDTOList.add(new PageDTO());
    LocaleImpl locale = new LocaleImpl();

    // Act and Assert
    assertSame(pageDTO, pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>()));
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <ul>
   *   <li>Then calls {@link PageDTO#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules_thenCallsGetLocaleCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    NullPageDTO nullPageDTO = mock(NullPageDTO.class);
    when(nullPageDTO.getLocaleCode()).thenReturn("en");

    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    pageDTOList.add(nullPageDTO);
    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

    // Act
    pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>());

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    verify(nullPageDTO).getLocaleCode();
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link PageServiceImpl} (default constructor)
   * {@link PageServiceImpl#NULL_PAGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules_whenArrayList_thenReturnPageServiceImplNull_page() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    LocaleImpl locale = new LocaleImpl();

    // Act and Assert
    assertSame(pageServiceImpl.NULL_PAGE, pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>()));
  }

  /**
   * Test {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}.
   * <ul>
   *   <li>When {@link LocaleImpl}.</li>
   *   <li>Then return {@link PageServiceImpl} (default constructor)
   * {@link PageServiceImpl#NULL_PAGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageServiceImpl#evaluatePageRules(List, Locale, Map)}
   */
  @Test
  public void testEvaluatePageRules_whenLocaleImpl_thenReturnPageServiceImplNull_page() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    ArrayList<PageDTO> pageDTOList = new ArrayList<>();
    LocaleImpl locale = mock(LocaleImpl.class);

    // Act and Assert
    assertSame(pageServiceImpl.NULL_PAGE, pageServiceImpl.evaluatePageRules(pageDTOList, locale, new HashMap<>()));
  }

  /**
   * Test {@link PageServiceImpl#passesPageRules(PageDTO, Map)}.
   * <p>
   * Method under test: {@link PageServiceImpl#passesPageRules(PageDTO, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPassesPageRules() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2014 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageServiceImpl pageServiceImpl2 = new PageServiceImpl();
    PageDTO page = new PageDTO();

    // Act
    pageServiceImpl2.passesPageRules(page, new HashMap<>());
  }

  /**
   * Test {@link PageServiceImpl#passesPageRules(PageDTO, Map)}.
   * <ul>
   *   <li>When {@link NullPageDTO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#passesPageRules(PageDTO, Map)}
   */
  @Test
  public void testPassesPageRules_whenNullPageDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    NullPageDTO page = mock(NullPageDTO.class);

    // Act and Assert
    assertTrue(pageServiceImpl.passesPageRules(page, new HashMap<>()));
  }

  /**
   * Test {@link PageServiceImpl#passesPageRules(PageDTO, Map)}.
   * <ul>
   *   <li>When {@link PageDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#passesPageRules(PageDTO, Map)}
   */
  @Test
  public void testPassesPageRules_whenPageDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceImpl pageServiceImpl = new PageServiceImpl();
    PageDTO page = new PageDTO();

    // Act and Assert
    assertTrue(pageServiceImpl.passesPageRules(page, new HashMap<>()));
  }

  /**
   * Test {@link PageServiceImpl#readAllPages()}.
   * <p>
   * Method under test: {@link PageServiceImpl#readAllPages()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllPages() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2047 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageServiceImpl()).readAllPages();
  }

  /**
   * Test {@link PageServiceImpl#readAllPageTemplates()}.
   * <p>
   * Method under test: {@link PageServiceImpl#readAllPageTemplates()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllPageTemplates() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2042 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageServiceImpl()).readAllPageTemplates();
  }

  /**
   * Test {@link PageServiceImpl#removePageFromCache(String)}.
   * <p>
   * Method under test: {@link PageServiceImpl#removePageFromCache(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemovePageFromCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2052 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageServiceImpl()).removePageFromCache("Map Key");
  }

  /**
   * Test {@link PageServiceImpl#removePageFromCache(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceImpl#removePageFromCache(String)}
   */
  @Test
  public void testRemovePageFromCache_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PageServiceImpl()).removePageFromCache(null));
  }

  /**
   * Test
   * {@link PageServiceImpl#removeTranslationPageFromCache(String, String, boolean)}.
   * <p>
   * Method under test:
   * {@link PageServiceImpl#removeTranslationPageFromCache(String, String, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveTranslationPageFromCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2370 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceImpl pageServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageServiceImpl()).removeTranslationPageFromCache("Uri", "en", true);
  }
}
