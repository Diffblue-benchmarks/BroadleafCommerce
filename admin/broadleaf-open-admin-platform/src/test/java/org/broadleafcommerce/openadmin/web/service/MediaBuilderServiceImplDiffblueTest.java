package org.broadleafcommerce.openadmin.web.service;

import static org.junit.Assert.assertNull;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.media.domain.MediaDto;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MediaBuilderServiceImplDiffblueTest {
  @Autowired
  private MediaBuilderServiceImpl mediaBuilderServiceImpl;

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   * <p>
   * Method under test:
   * {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertJsonToMedia() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16056 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.MediaBuilderServiceImpl mediaBuilderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MediaBuilderServiceImpl mediaBuilderServiceImpl2 = new MediaBuilderServiceImpl();
    Class<Object> type = Object.class;

    // Act
    mediaBuilderServiceImpl2.convertJsonToMedia("", type);
  }

  /**
   * Test {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}.
   * <ul>
   *   <li>When {@link ObjectMapper#ObjectMapper()} writeValueAsString
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaBuilderServiceImpl#convertJsonToMedia(String, Class)}
   */
  @Test
  public void testConvertJsonToMedia_whenObjectMapperWriteValueAsStringNull_thenReturnNull()
      throws JsonProcessingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaBuilderServiceImpl mediaBuilderServiceImpl = new MediaBuilderServiceImpl();
    String json = (new ObjectMapper()).writeValueAsString(null);
    Class<Object> type = Object.class;

    // Act and Assert
    assertNull(mediaBuilderServiceImpl.convertJsonToMedia(json, type));
  }

  /**
   * Test {@link MediaBuilderServiceImpl#instantiateMediaFields(Media)}.
   * <p>
   * Method under test:
   * {@link MediaBuilderServiceImpl#instantiateMediaFields(Media)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInstantiateMediaFields() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16148 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.MediaBuilderServiceImpl mediaBuilderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MediaBuilderServiceImpl mediaBuilderServiceImpl2 = new MediaBuilderServiceImpl();

    // Act
    mediaBuilderServiceImpl2.instantiateMediaFields(new MediaDto());
  }
}
