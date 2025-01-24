package org.broadleafcommerce.core.search.redirect.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchRedirectImplDiffblueTest {
  @Autowired
  private SearchRedirectImpl searchRedirectImpl;

  /**
   * Test {@link SearchRedirectImpl#isActive()}.
   * <p>
   * Method under test: {@link SearchRedirectImpl#isActive()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsActive() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.redirect.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1877 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.redirect.domain.SearchRedirectImpl searchRedirectImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SearchRedirectImpl()).isActive();
  }

  /**
   * Test {@link SearchRedirectImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link SearchRedirectImpl#getMainEntityName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMainEntityName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.redirect.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1869 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.redirect.domain.SearchRedirectImpl searchRedirectImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SearchRedirectImpl()).getMainEntityName();
  }

  /**
   * Test {@link SearchRedirectImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link SearchRedirectImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchRedirectImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenSearchRedirectImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SearchRedirectImpl()).getMainEntityName());
  }

  /**
   * Test {@link SearchRedirectImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link SearchRedirectImpl} (default constructor) ActiveStartDate is
   * {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchRedirectImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenSearchRedirectImplActiveStartDateIsDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRedirectImpl searchRedirectImpl = new SearchRedirectImpl();
    searchRedirectImpl.setActiveStartDate(mock(java.sql.Date.class));

    // Act and Assert
    assertNull(searchRedirectImpl.getMainEntityName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SearchRedirectImpl}
   *   <li>{@link SearchRedirectImpl#setActiveEndDate(Date)}
   *   <li>{@link SearchRedirectImpl#setActiveStartDate(Date)}
   *   <li>{@link SearchRedirectImpl#setId(Long)}
   *   <li>{@link SearchRedirectImpl#setSearchPriority(Integer)}
   *   <li>{@link SearchRedirectImpl#setSearchTerm(String)}
   *   <li>{@link SearchRedirectImpl#setUrl(String)}
   *   <li>{@link SearchRedirectImpl#getActiveEndDate()}
   *   <li>{@link SearchRedirectImpl#getActiveStartDate()}
   *   <li>{@link SearchRedirectImpl#getId()}
   *   <li>{@link SearchRedirectImpl#getSearchPriority()}
   *   <li>{@link SearchRedirectImpl#getSearchTerm()}
   *   <li>{@link SearchRedirectImpl#getUrl()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SearchRedirectImpl actualSearchRedirectImpl = new SearchRedirectImpl();
    Date activeEndDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualSearchRedirectImpl.setActiveEndDate(activeEndDate);
    Date activeStartDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualSearchRedirectImpl.setActiveStartDate(activeStartDate);
    actualSearchRedirectImpl.setId(1L);
    actualSearchRedirectImpl.setSearchPriority(1);
    actualSearchRedirectImpl.setSearchTerm("Search Term");
    actualSearchRedirectImpl.setUrl("https://example.org/example");
    Date actualActiveEndDate = actualSearchRedirectImpl.getActiveEndDate();
    Date actualActiveStartDate = actualSearchRedirectImpl.getActiveStartDate();
    Long actualId = actualSearchRedirectImpl.getId();
    Integer actualSearchPriority = actualSearchRedirectImpl.getSearchPriority();
    String actualSearchTerm = actualSearchRedirectImpl.getSearchTerm();

    // Assert that nothing has changed
    assertEquals("Search Term", actualSearchTerm);
    assertEquals("https://example.org/example", actualSearchRedirectImpl.getUrl());
    assertEquals(1, actualSearchPriority.intValue());
    assertEquals(1L, actualId.longValue());
    assertSame(activeEndDate, actualActiveEndDate);
    assertSame(activeStartDate, actualActiveStartDate);
  }
}
