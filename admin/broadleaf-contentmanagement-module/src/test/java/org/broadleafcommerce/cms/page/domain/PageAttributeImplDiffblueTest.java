package org.broadleafcommerce.cms.page.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml",
    "/applicationContext-servlet-cms-contentClient.xml", "/applicationContext-servlet-cms-contentCreator.xml",
    "/bl-cms-contentClient-applicationContext.xml", "/bl-cms-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-cms-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-cms-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PageAttributeImplDiffblueTest {
  @Autowired
  private PageAttributeImpl pageAttributeImpl;

  /**
   * Test {@link PageAttributeImpl#getValue()}.
   * <p>
   * Method under test: {@link PageAttributeImpl#getValue()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11940 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.domain.PageAttributeImpl pageAttributeImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageAttributeImpl()).getValue();
  }

  /**
   * Test {@link PageAttributeImpl#getValue()}.
   * <ul>
   *   <li>Given {@link PageAttributeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#getValue()}
   */
  @Test
  public void testGetValue_givenPageAttributeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageAttributeImpl()).getValue());
  }

  /**
   * Test {@link PageAttributeImpl#getValue()}.
   * <ul>
   *   <li>Given {@link PageAttributeImpl} (default constructor) Page is
   * {@link PageImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#getValue()}
   */
  @Test
  public void testGetValue_givenPageAttributeImplPageIsPageImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setPage(mock(PageImpl.class));

    // Act and Assert
    assertNull(pageAttributeImpl.getValue());
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}, and
   * {@link PageAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageAttributeImpl#equals(Object)}
   *   <li>{@link PageAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(pageAttributeImpl, pageAttributeImpl2);
    int notExpectedHashCodeResult = pageAttributeImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, pageAttributeImpl2.hashCode());
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}, and
   * {@link PageAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageAttributeImpl#equals(Object)}
   *   <li>{@link PageAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(mock(Page.class));
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(pageAttributeImpl, pageAttributeImpl2);
    int notExpectedHashCodeResult = pageAttributeImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, pageAttributeImpl2.hashCode());
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}, and
   * {@link PageAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageAttributeImpl#equals(Object)}
   *   <li>{@link PageAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(null);
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(null);
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(pageAttributeImpl, pageAttributeImpl2);
    int expectedHashCodeResult = pageAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, pageAttributeImpl2.hashCode());
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}, and
   * {@link PageAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageAttributeImpl#equals(Object)}
   *   <li>{@link PageAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(pageAttributeImpl, pageAttributeImpl);
    int expectedHashCodeResult = pageAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, pageAttributeImpl.hashCode());
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(2L);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(null);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName(null);
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("java.lang.String");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(null);
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName(null);
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName(null);
    pageAttributeImpl2.setPage(new PageImpl());
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(null);
    pageAttributeImpl.setValue("Name");

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(null);
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(null);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(null);
    pageAttributeImpl.setValue(null);

    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    pageAttributeImpl2.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl2.setName("Name");
    pageAttributeImpl2.setPage(null);
    pageAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, pageAttributeImpl2);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, null);
  }

  /**
   * Test {@link PageAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    pageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    pageAttributeImpl.setName("Name");
    pageAttributeImpl.setPage(new PageImpl());
    pageAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(pageAttributeImpl, "Different type to PageAttributeImpl");
  }

  /**
   * Test
   * {@link PageAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link PageAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageAttributeImpl pageAttributeImpl = new PageAttributeImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<PageAttribute> actualCreateOrRetrieveCopyInstanceResult = pageAttributeImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link PageAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link PageAttributeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11876 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.domain.PageAttributeImpl pageAttributeImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PageAttributeImpl pageAttributeImpl2 = new PageAttributeImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    pageAttributeImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PageAttributeImpl}
   *   <li>{@link PageAttributeImpl#setId(Long)}
   *   <li>{@link PageAttributeImpl#setName(String)}
   *   <li>{@link PageAttributeImpl#setPage(Page)}
   *   <li>{@link PageAttributeImpl#setValue(String)}
   *   <li>{@link PageAttributeImpl#getId()}
   *   <li>{@link PageAttributeImpl#getName()}
   *   <li>{@link PageAttributeImpl#getPage()}
   *   <li>{@link PageAttributeImpl#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PageAttributeImpl actualPageAttributeImpl = new PageAttributeImpl();
    actualPageAttributeImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    actualPageAttributeImpl.setName("Name");
    PageImpl page = new PageImpl();
    actualPageAttributeImpl.setPage(page);
    actualPageAttributeImpl.setValue("42");
    Long actualId = actualPageAttributeImpl.getId();
    String actualName = actualPageAttributeImpl.getName();
    Page actualPage = actualPageAttributeImpl.getPage();
    String actualToStringResult = actualPageAttributeImpl.toString();

    // Assert that nothing has changed
    assertEquals("42", actualPageAttributeImpl.getValue());
    assertEquals("42", actualToStringResult);
    assertEquals("Name", actualName);
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(page, actualPage);
  }
}
