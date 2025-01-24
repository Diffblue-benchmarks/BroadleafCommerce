package org.broadleafcommerce.cms.web.deeplink;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import org.broadleafcommerce.common.structure.dto.StructuredContentDTO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-cms-contentClient-applicationContext.xml",
    "/applicationContext-servlet-cms-contentClient.xml", "/applicationContext-servlet-cms-contentCreator.xml",
    "/bl-cms-applicationContext-entity.xml", "/bl-cms-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-cms-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-cms-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ContentDeepLinkServiceImplDiffblueTest {
  @Autowired
  private ContentDeepLinkServiceImpl contentDeepLinkServiceImpl;

  /**
   * Test
   * {@link ContentDeepLinkServiceImpl#getLinksInternal(StructuredContentDTO)}
   * with {@code StructuredContentDTO}.
   * <p>
   * Method under test:
   * {@link ContentDeepLinkServiceImpl#getLinksInternal(StructuredContentDTO)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetLinksInternalWithStructuredContentDTO() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.deeplink;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-contentClient-applicationContext.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1996 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.deeplink.ContentDeepLinkServiceImpl contentDeepLinkServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ContentDeepLinkServiceImpl contentDeepLinkServiceImpl2 = new ContentDeepLinkServiceImpl();

    StructuredContentDTO item = new StructuredContentDTO();
    item.setContentName("Not all who wander are lost");
    item.setContentType("text/plain");
    item.setId(1L);
    item.setItemCriteriaDTOList(new ArrayList<>());
    item.setLocaleCode("en");
    item.setPriority(1);
    item.setRuleExpression("Rule Expression");
    item.setValues(new HashMap<>());

    // Act
    contentDeepLinkServiceImpl2.getLinksInternal(item);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ContentDeepLinkServiceImpl}
   *   <li>{@link ContentDeepLinkServiceImpl#setStructuredContentAdminPath(String)}
   *   <li>{@link ContentDeepLinkServiceImpl#getStructuredContentAdminPath()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ContentDeepLinkServiceImpl actualContentDeepLinkServiceImpl = new ContentDeepLinkServiceImpl();
    actualContentDeepLinkServiceImpl.setStructuredContentAdminPath("Not all who wander are lost");

    // Assert that nothing has changed
    assertEquals("Not all who wander are lost", actualContentDeepLinkServiceImpl.getStructuredContentAdminPath());
  }
}
