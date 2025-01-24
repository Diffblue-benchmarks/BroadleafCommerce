package org.broadleafcommerce.cms.structure.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.cms.structure.domain.StructuredContent;
import org.broadleafcommerce.cms.structure.domain.StructuredContentImpl;
import org.broadleafcommerce.cms.structure.domain.StructuredContentRule;
import org.broadleafcommerce.cms.structure.domain.StructuredContentRuleImpl;
import org.broadleafcommerce.cms.structure.domain.StructuredContentType;
import org.broadleafcommerce.cms.structure.domain.StructuredContentTypeImpl;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.rule.RuleProcessor;
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO;
import org.broadleafcommerce.common.structure.dto.StructuredContentDTO;
import org.hibernate.Criteria;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.hibernate.internal.CriteriaImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
public class StructuredContentServiceImplDiffblueTest {
  @Autowired
  private StructuredContentServiceImpl structuredContentServiceImpl;

  /**
   * Test {@link StructuredContentServiceImpl#findStructuredContentById(Long)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#findStructuredContentById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindStructuredContentById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6457 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentServiceImpl()).findStructuredContentById(1L);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#findStructuredContentTypeById(Long)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#findStructuredContentTypeById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindStructuredContentTypeById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6475 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentServiceImpl()).findStructuredContentTypeById(1L);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#findStructuredContentTypeByName(String)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#findStructuredContentTypeByName(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindStructuredContentTypeByName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6493 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentServiceImpl()).findStructuredContentTypeByName("Name");
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#retrieveAllStructuredContentTypes()}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#retrieveAllStructuredContentTypes()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRetrieveAllStructuredContentTypes() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8234 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentServiceImpl()).retrieveAllStructuredContentTypes();
  }

  /**
   * Test {@link StructuredContentServiceImpl#findContentItems(Criteria)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#findContentItems(Criteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindContentItems() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6329 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);

    // Act
    structuredContentServiceImpl2.findContentItems(new CriteriaImpl("Entity Or Class Name",
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null))));
  }

  /**
   * Test {@link StructuredContentServiceImpl#findAllContentItems()}.
   * <p>
   * Method under test: {@link StructuredContentServiceImpl#findAllContentItems()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindAllContentItems() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6325 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentServiceImpl()).findAllContentItems();
  }

  /**
   * Test {@link StructuredContentServiceImpl#countContentItems(Criteria)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#countContentItems(Criteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCountContentItems() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6190 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);

    // Act
    structuredContentServiceImpl2.countContentItems(new CriteriaImpl("Entity Or Class Name",
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null))));
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#saveStructuredContentType(StructuredContentType)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#saveStructuredContentType(StructuredContentType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSaveStructuredContentType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8238 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();

    // Act
    structuredContentServiceImpl2.saveStructuredContentType(new StructuredContentTypeImpl());
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List, boolean)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildStructuredContentDTOList() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6053 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();

    // Act
    structuredContentServiceImpl2.buildStructuredContentDTOList(new ArrayList<>(), true);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List, boolean)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List, boolean)}
   */
  @Test
  public void testBuildStructuredContentDTOList_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertTrue(structuredContentServiceImpl.buildStructuredContentDTOList(new ArrayList<>(), true).isEmpty());
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}
   */
  @Test
  public void testEvaluateAndPriortizeContent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(new ArrayList<>());
    StructuredContentDTO structuredContentDTO = mock(StructuredContentDTO.class);
    doNothing().when(structuredContentDTO).setContentName(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setContentType(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setId(Mockito.<Long>any());
    doNothing().when(structuredContentDTO).setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());
    doNothing().when(structuredContentDTO).setLocaleCode(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setPriority(Mockito.<Integer>any());
    doNothing().when(structuredContentDTO).setRuleExpression(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setValues(Mockito.<Map<String, Object>>any());
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualEvaluateAndPriortizeContentResult = structuredContentServiceImpl
        .evaluateAndPriortizeContent(structuredContentList, 3, new HashMap<>());

    // Assert
    verify(structuredContentDTO).setContentName(eq("Not all who wander are lost"));
    verify(structuredContentDTO).setContentType(eq("text/plain"));
    verify(structuredContentDTO).setId(eq(1L));
    verify(structuredContentDTO).setItemCriteriaDTOList(isA(List.class));
    verify(structuredContentDTO).setLocaleCode(eq("en"));
    verify(structuredContentDTO).setPriority(eq(1));
    verify(structuredContentDTO).setRuleExpression(eq("Rule Expression"));
    verify(structuredContentDTO).setValues(isA(Map.class));
    assertSame(structuredContentList, actualEvaluateAndPriortizeContentResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEvaluateAndPriortizeContent2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6306 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();
    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();

    // Act
    structuredContentServiceImpl2.evaluateAndPriortizeContent(structuredContentList, 3, new HashMap<>());
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}.
   * <ul>
   *   <li>Then calls {@link RuleProcessor#checkForMatch(Object, Map)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}
   */
  @Test
  public void testEvaluateAndPriortizeContent_thenCallsCheckForMatch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleProcessor<StructuredContentDTO> ruleProcessor = mock(RuleProcessor.class);
    when(ruleProcessor.checkForMatch(Mockito.<StructuredContentDTO>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(true);

    ArrayList<RuleProcessor<StructuredContentDTO>> contentRuleProcessors = new ArrayList<>();
    contentRuleProcessors.add(ruleProcessor);

    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(contentRuleProcessors);
    StructuredContentDTO structuredContentDTO = mock(StructuredContentDTO.class);
    doNothing().when(structuredContentDTO).setContentName(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setContentType(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setId(Mockito.<Long>any());
    doNothing().when(structuredContentDTO).setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());
    doNothing().when(structuredContentDTO).setLocaleCode(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setPriority(Mockito.<Integer>any());
    doNothing().when(structuredContentDTO).setRuleExpression(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setValues(Mockito.<Map<String, Object>>any());
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualEvaluateAndPriortizeContentResult = structuredContentServiceImpl
        .evaluateAndPriortizeContent(structuredContentList, 3, new HashMap<>());

    // Assert
    verify(ruleProcessor).checkForMatch(isA(StructuredContentDTO.class), isA(Map.class));
    verify(structuredContentDTO).setContentName(eq("Not all who wander are lost"));
    verify(structuredContentDTO).setContentType(eq("text/plain"));
    verify(structuredContentDTO).setId(eq(1L));
    verify(structuredContentDTO).setItemCriteriaDTOList(isA(List.class));
    verify(structuredContentDTO).setLocaleCode(eq("en"));
    verify(structuredContentDTO).setPriority(eq(1));
    verify(structuredContentDTO).setRuleExpression(eq("Rule Expression"));
    verify(structuredContentDTO).setValues(isA(Map.class));
    assertSame(structuredContentList, actualEvaluateAndPriortizeContentResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}
   */
  @Test
  public void testEvaluateAndPriortizeContent_thenReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    StructuredContentDTO structuredContentDTO = mock(StructuredContentDTO.class);
    doNothing().when(structuredContentDTO).setContentName(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setContentType(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setId(Mockito.<Long>any());
    doNothing().when(structuredContentDTO).setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());
    doNothing().when(structuredContentDTO).setLocaleCode(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setPriority(Mockito.<Integer>any());
    doNothing().when(structuredContentDTO).setRuleExpression(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setValues(Mockito.<Map<String, Object>>any());
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualEvaluateAndPriortizeContentResult = structuredContentServiceImpl
        .evaluateAndPriortizeContent(structuredContentList, 3, new HashMap<>());

    // Assert
    verify(structuredContentDTO).setContentName(eq("Not all who wander are lost"));
    verify(structuredContentDTO).setContentType(eq("text/plain"));
    verify(structuredContentDTO).setId(eq(1L));
    verify(structuredContentDTO).setItemCriteriaDTOList(isA(List.class));
    verify(structuredContentDTO).setLocaleCode(eq("en"));
    verify(structuredContentDTO).setPriority(eq(1));
    verify(structuredContentDTO).setRuleExpression(eq("Rule Expression"));
    verify(structuredContentDTO).setValues(isA(Map.class));
    assertSame(structuredContentList, actualEvaluateAndPriortizeContentResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}
   */
  @Test
  public void testEvaluateAndPriortizeContent_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualEvaluateAndPriortizeContentResult = structuredContentServiceImpl
        .evaluateAndPriortizeContent(structuredContentList, 3, new HashMap<>());

    // Assert
    assertEquals(1, actualEvaluateAndPriortizeContentResult.size());
    assertSame(structuredContentDTO, actualEvaluateAndPriortizeContentResult.get(0));
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}
   */
  @Test
  public void testProcessUnprioritizedContent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(null);

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act and Assert
    assertSame(structuredContentList,
        structuredContentServiceImpl.processUnprioritizedContent(structuredContentList, new HashMap<>()));
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}
   */
  @Test
  public void testProcessUnprioritizedContent2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(new ArrayList<>());

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act and Assert
    assertSame(structuredContentList,
        structuredContentServiceImpl.processUnprioritizedContent(structuredContentList, new HashMap<>()));
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testProcessUnprioritizedContent3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7843 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();
    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();

    // Act
    structuredContentServiceImpl2.processUnprioritizedContent(structuredContentList, new HashMap<>());
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}.
   * <ul>
   *   <li>Then calls {@link RuleProcessor#checkForMatch(Object, Map)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}
   */
  @Test
  public void testProcessUnprioritizedContent_thenCallsCheckForMatch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleProcessor<StructuredContentDTO> ruleProcessor = mock(RuleProcessor.class);
    when(ruleProcessor.checkForMatch(Mockito.<StructuredContentDTO>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(true);

    ArrayList<RuleProcessor<StructuredContentDTO>> contentRuleProcessors = new ArrayList<>();
    contentRuleProcessors.add(ruleProcessor);

    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(contentRuleProcessors);

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualProcessUnprioritizedContentResult = structuredContentServiceImpl
        .processUnprioritizedContent(structuredContentList, new HashMap<>());

    // Assert
    verify(ruleProcessor).checkForMatch(isA(StructuredContentDTO.class), isA(Map.class));
    assertSame(structuredContentList, actualProcessUnprioritizedContentResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}
   */
  @Test
  public void testProcessContentRules() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(new ArrayList<>());

    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("Rule Expression");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertTrue(structuredContentServiceImpl.processContentRules(sc, new HashMap<>()));
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testProcessContentRules2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7623 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();

    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("Rule Expression");
    sc.setValues(new HashMap<>());

    // Act
    structuredContentServiceImpl2.processContentRules(sc, new HashMap<>());
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}.
   * <ul>
   *   <li>Given {@link StructuredContentServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}
   */
  @Test
  public void testProcessContentRules_givenStructuredContentServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("Rule Expression");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertTrue(structuredContentServiceImpl.processContentRules(sc, new HashMap<>()));
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}.
   * <ul>
   *   <li>Then calls {@link RuleProcessor#checkForMatch(Object, Map)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}
   */
  @Test
  public void testProcessContentRules_thenCallsCheckForMatch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleProcessor<StructuredContentDTO> ruleProcessor = mock(RuleProcessor.class);
    when(ruleProcessor.checkForMatch(Mockito.<StructuredContentDTO>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(true);

    ArrayList<RuleProcessor<StructuredContentDTO>> contentRuleProcessors = new ArrayList<>();
    contentRuleProcessors.add(ruleProcessor);

    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(contentRuleProcessors);

    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("Rule Expression");
    sc.setValues(new HashMap<>());

    // Act
    boolean actualProcessContentRulesResult = structuredContentServiceImpl.processContentRules(sc, new HashMap<>());

    // Assert
    verify(ruleProcessor).checkForMatch(isA(StructuredContentDTO.class), isA(Map.class));
    assertTrue(actualProcessContentRulesResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#modifyStructuredContentDtoList(List)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#modifyStructuredContentDtoList(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testModifyStructuredContentDtoList() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7615 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();

    // Act
    structuredContentServiceImpl2.modifyStructuredContentDtoList(new ArrayList<>());
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#lookupStructuredContentItemsByType(StructuredContentType, Locale, Integer, Map, boolean)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#lookupStructuredContentItemsByType(StructuredContentType, Locale, Integer, Map, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testLookupStructuredContentItemsByType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7582 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();
    StructuredContentTypeImpl contentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();

    // Act
    structuredContentServiceImpl2.lookupStructuredContentItemsByType(contentType, locale, 3, new HashMap<>(), true);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#lookupStructuredContentItemsByName(String, Locale, Integer, Map, boolean)}
   * with {@code contentName}, {@code locale}, {@code count}, {@code ruleDTOs},
   * {@code secure}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#lookupStructuredContentItemsByName(String, Locale, Integer, Map, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testLookupStructuredContentItemsByNameWithContentNameLocaleCountRuleDTOsSecure() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7499 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();
    LocaleImpl locale = new LocaleImpl();

    // Act
    structuredContentServiceImpl2.lookupStructuredContentItemsByName("Not all who wander are lost", locale, 3,
        new HashMap<>(), true);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#lookupStructuredContentItemsByName(StructuredContentType, String, Locale, Integer, Map, boolean)}
   * with {@code contentType}, {@code contentName}, {@code locale}, {@code count},
   * {@code ruleDTOs}, {@code secure}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#lookupStructuredContentItemsByName(StructuredContentType, String, Locale, Integer, Map, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testLookupStructuredContentItemsByNameWithContentTypeContentNameLocaleCountRuleDTOsSecure() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7536 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();
    StructuredContentTypeImpl contentType = new StructuredContentTypeImpl();
    LocaleImpl locale = new LocaleImpl();

    // Act
    structuredContentServiceImpl2.lookupStructuredContentItemsByName(contentType, "Not all who wander are lost", locale,
        3, new HashMap<>(), true);
  }

  /**
   * Test {@link StructuredContentServiceImpl#convertToDtos(List, boolean)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#convertToDtos(List, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertToDtos() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6181 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();

    // Act
    structuredContentServiceImpl2.convertToDtos(new ArrayList<>(), true);
  }

  /**
   * Test {@link StructuredContentServiceImpl#convertToDtos(List, boolean)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#convertToDtos(List, boolean)}
   */
  @Test
  public void testConvertToDtos_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertTrue(structuredContentServiceImpl.convertToDtos(new ArrayList<>(), true).isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentServiceImpl#setContentRuleProcessors(List)}
   *   <li>{@link StructuredContentServiceImpl#getContentRuleProcessors()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    ArrayList<RuleProcessor<StructuredContentDTO>> contentRuleProcessors = new ArrayList<>();

    // Act
    structuredContentServiceImpl.setContentRuleProcessors(contentRuleProcessors);
    List<RuleProcessor<StructuredContentDTO>> actualContentRuleProcessors = structuredContentServiceImpl
        .getContentRuleProcessors();

    // Assert that nothing has changed
    assertTrue(actualContentRuleProcessors.isEmpty());
    assertSame(contentRuleProcessors, actualContentRuleProcessors);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#removeStructuredContentFromCache(SandBox, StructuredContent)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#removeStructuredContentFromCache(SandBox, StructuredContent)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveStructuredContentFromCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8202 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();
    SandBoxImpl sandBox = new SandBoxImpl();

    // Act
    structuredContentServiceImpl2.removeStructuredContentFromCache(sandBox, new StructuredContentImpl());
  }

  /**
   * Test {@link StructuredContentServiceImpl#removeItemFromCacheByKey(String)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#removeItemFromCacheByKey(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveItemFromCacheByKey() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7886 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentServiceImpl()).removeItemFromCacheByKey("Key");
  }

  /**
   * Test {@link StructuredContentServiceImpl#removeItemFromCacheByKey(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#removeItemFromCacheByKey(String)}
   */
  @Test
  public void testRemoveItemFromCacheByKey_whenEmptyString_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new StructuredContentServiceImpl()).removeItemFromCacheByKey(""));
  }

  /**
   * Test {@link StructuredContentServiceImpl#removeItemFromCacheByKey(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#removeItemFromCacheByKey(String)}
   */
  @Test
  public void testRemoveItemFromCacheByKey_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new StructuredContentServiceImpl()).removeItemFromCacheByKey(null));
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#removeItemFromCache(String, String)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#removeItemFromCache(String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveItemFromCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7858 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentServiceImpl()).removeItemFromCache("Name Key", "Type Key");
  }

  /**
   * Test {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindLanguageOnlyLocale() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6445 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();

    // Act
    structuredContentServiceImpl2.findLanguageOnlyLocale(new LocaleImpl());
  }

  /**
   * Test {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  public void testFindLanguageOnlyLocale_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StructuredContentServiceImpl()).findLanguageOnlyLocale(null));
  }

  /**
   * Test {@link StructuredContentServiceImpl#getStructuredContentCache()}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#getStructuredContentCache()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetStructuredContentCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7125 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentServiceImpl()).getStructuredContentCache();
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildRuleExpression() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6014 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();

    // Act
    structuredContentServiceImpl2.buildRuleExpression(new StructuredContentImpl());
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link StructuredContentRuleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  public void testBuildRuleExpression_givenHashMapFooIsStructuredContentRuleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    HashMap<String, StructuredContentRule> stringStructuredContentRuleMap = new HashMap<>();
    stringStructuredContentRuleMap.put("foo", new StructuredContentRuleImpl());
    StructuredContentImpl sc = mock(StructuredContentImpl.class);
    when(sc.getStructuredContentMatchRules()).thenReturn(stringStructuredContentRuleMap);

    // Act
    String actualBuildRuleExpressionResult = structuredContentServiceImpl.buildRuleExpression(sc);

    // Assert
    verify(sc).getStructuredContentMatchRules();
    assertNull(actualBuildRuleExpressionResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  public void testBuildRuleExpression_givenHashMap_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    StructuredContentImpl sc = mock(StructuredContentImpl.class);
    when(sc.getStructuredContentMatchRules()).thenReturn(new HashMap<>());

    // Act
    String actualBuildRuleExpressionResult = structuredContentServiceImpl.buildRuleExpression(sc);

    // Assert
    verify(sc).getStructuredContentMatchRules();
    assertNull(actualBuildRuleExpressionResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}.
   * <ul>
   *   <li>Given {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  public void testBuildRuleExpression_givenNotAllWhoWanderAreLost() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setLocale(new LocaleImpl());
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentType(new StructuredContentTypeImpl());
    sc.setStructuredContentMatchRules(null);

    // Act and Assert
    assertNull(structuredContentServiceImpl.buildRuleExpression(sc));
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}.
   * <ul>
   *   <li>Then return {@code Match Rule}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  public void testBuildRuleExpression_thenReturnMatchRule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    StructuredContentRuleImpl structuredContentRuleImpl = mock(StructuredContentRuleImpl.class);
    when(structuredContentRuleImpl.getMatchRule()).thenReturn("Match Rule");

    HashMap<String, StructuredContentRule> stringStructuredContentRuleMap = new HashMap<>();
    stringStructuredContentRuleMap.put("foo", structuredContentRuleImpl);
    StructuredContentImpl sc = mock(StructuredContentImpl.class);
    when(sc.getStructuredContentMatchRules()).thenReturn(stringStructuredContentRuleMap);

    // Act
    String actualBuildRuleExpressionResult = structuredContentServiceImpl.buildRuleExpression(sc);

    // Assert
    verify(sc).getStructuredContentMatchRules();
    verify(structuredContentRuleImpl, atLeast(1)).getMatchRule();
    assertEquals("Match Rule", actualBuildRuleExpressionResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}.
   * <ul>
   *   <li>Then return {@code Match Rule && Match Rule}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  public void testBuildRuleExpression_thenReturnMatchRuleMatchRule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    StructuredContentRuleImpl structuredContentRuleImpl = mock(StructuredContentRuleImpl.class);
    when(structuredContentRuleImpl.getMatchRule()).thenReturn("Match Rule");

    StructuredContentRuleImpl structuredContentRuleImpl2 = new StructuredContentRuleImpl();
    structuredContentRuleImpl2.setMatchRule("Match Rule");

    HashMap<String, StructuredContentRule> stringStructuredContentRuleMap = new HashMap<>();
    stringStructuredContentRuleMap.put("", structuredContentRuleImpl2);
    stringStructuredContentRuleMap.put("foo", structuredContentRuleImpl);
    StructuredContentImpl sc = mock(StructuredContentImpl.class);
    when(sc.getStructuredContentMatchRules()).thenReturn(stringStructuredContentRuleMap);

    // Act
    String actualBuildRuleExpressionResult = structuredContentServiceImpl.buildRuleExpression(sc);

    // Assert
    verify(sc).getStructuredContentMatchRules();
    verify(structuredContentRuleImpl, atLeast(1)).getMatchRule();
    assertEquals("Match Rule && Match Rule", actualBuildRuleExpressionResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}.
   * <ul>
   *   <li>When {@link StructuredContentImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  public void testBuildRuleExpression_whenStructuredContentImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertNull(structuredContentServiceImpl.buildRuleExpression(new StructuredContentImpl()));
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildItemCriteriaDTOList() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5817 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();

    // Act
    structuredContentServiceImpl2.buildItemCriteriaDTOList(new StructuredContentImpl());
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then calls
   * {@link StructuredContentImpl#getQualifyingItemCriteria()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}
   */
  @Test
  public void testBuildItemCriteriaDTOList_givenHashSet_thenCallsGetQualifyingItemCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    StructuredContentImpl sc = mock(StructuredContentImpl.class);
    when(sc.getQualifyingItemCriteria()).thenReturn(new HashSet<>());

    // Act
    List<ItemCriteriaDTO> actualBuildItemCriteriaDTOListResult = structuredContentServiceImpl
        .buildItemCriteriaDTOList(sc);

    // Assert
    verify(sc).getQualifyingItemCriteria();
    assertTrue(actualBuildItemCriteriaDTOListResult.isEmpty());
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}
   */
  @Test
  public void testBuildItemCriteriaDTOList_givenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setLocale(new LocaleImpl());
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(new StructuredContentTypeImpl());
    sc.setQualifyingItemCriteria(null);

    // Act and Assert
    assertTrue(structuredContentServiceImpl.buildItemCriteriaDTOList(sc).isEmpty());
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}.
   * <ul>
   *   <li>When {@link StructuredContentImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}
   */
  @Test
  public void testBuildItemCriteriaDTOList_whenStructuredContentImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertTrue(structuredContentServiceImpl.buildItemCriteriaDTOList(new StructuredContentImpl()).isEmpty());
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildFieldValues(StructuredContent, StructuredContentDTO, boolean)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildFieldValues(StructuredContent, StructuredContentDTO, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildFieldValues() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5588 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();
    StructuredContentImpl sc = new StructuredContentImpl();

    StructuredContentDTO scDTO = new StructuredContentDTO();
    scDTO.setContentName("Not all who wander are lost");
    scDTO.setContentType("text/plain");
    scDTO.setId(1L);
    scDTO.setItemCriteriaDTOList(new ArrayList<>());
    scDTO.setLocaleCode("en");
    scDTO.setPriority(1);
    scDTO.setRuleExpression("Rule Expression");
    scDTO.setValues(new HashMap<>());

    // Act
    structuredContentServiceImpl2.buildFieldValues(sc, scDTO, true);
  }

  /**
   * Test {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHasCmsPrefix() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7471 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentServiceImpl()).hasCmsPrefix("42", "Cms Prefix");
  }

  /**
   * Test {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}
   */
  @Test
  public void testHasCmsPrefix_when42_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new StructuredContentServiceImpl()).hasCmsPrefix("42", "42"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}.
   * <ul>
   *   <li>When {@code Cms Prefix}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}
   */
  @Test
  public void testHasCmsPrefix_whenCmsPrefix_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new StructuredContentServiceImpl()).hasCmsPrefix("42", "Cms Prefix"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}
   */
  @Test
  public void testHasCmsPrefix_whenEmptyString_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new StructuredContentServiceImpl()).hasCmsPrefix("", "Cms Prefix"));
  }

  /**
   * Test {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}
   */
  @Test
  public void testHasCmsPrefix_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new StructuredContentServiceImpl()).hasCmsPrefix(null, null));
    assertFalse((new StructuredContentServiceImpl()).hasCmsPrefix("42", null));
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildFieldValueWithCmsPrefix(String, StructuredContentDTO, boolean, String)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildFieldValueWithCmsPrefix(String, StructuredContentDTO, boolean, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildFieldValueWithCmsPrefix() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5350 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();

    StructuredContentDTO scDTO = new StructuredContentDTO();
    scDTO.setContentName("Not all who wander are lost");
    scDTO.setContentType("text/plain");
    scDTO.setId(1L);
    scDTO.setItemCriteriaDTOList(new ArrayList<>());
    scDTO.setLocaleCode("en");
    scDTO.setPriority(1);
    scDTO.setRuleExpression("Rule Expression");
    scDTO.setValues(new HashMap<>());

    // Act
    structuredContentServiceImpl2.buildFieldValueWithCmsPrefix("42", scDTO, true, "Field Key");
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildStructuredContentDTO(StructuredContent, boolean)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildStructuredContentDTO(StructuredContent, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildStructuredContentDTO() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6033 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();

    // Act
    structuredContentServiceImpl2.buildStructuredContentDTO(new StructuredContentImpl(), true);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)}
   * with {@code currentSandbox}, {@code site}, {@code locale},
   * {@code contentType}, {@code contentName}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)}
   */
  @Test
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals("text/plain-Not all who wander are lost-null-null-1", structuredContentServiceImpl
        .buildNameKey(currentSandbox, 1L, new LocaleImpl(), "text/plain", "Not all who wander are lost"));
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)}
   * with {@code currentSandbox}, {@code site}, {@code locale},
   * {@code contentType}, {@code contentName}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)}
   */
  @Test
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("text/plain-Not all who wander are lost", (new StructuredContentServiceImpl()).buildNameKey(null, null,
        null, "text/plain", "Not all who wander are lost"));
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)}
   * with {@code currentSandbox}, {@code site}, {@code locale},
   * {@code contentType}, {@code contentName}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)}
   */
  @Test
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = mock(SandBoxImpl.class);
    when(currentSandbox.getId()).thenReturn(1L);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(currentSandbox, 1L, new LocaleImpl(),
        "text/plain", "Not all who wander are lost");

    // Assert
    verify(currentSandbox).getId();
    assertEquals("text/plain-Not all who wander are lost-null-1-1", actualBuildNameKeyResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)}
   * with {@code currentSandbox}, {@code site}, {@code locale},
   * {@code contentType}, {@code contentName}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentName4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5836 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act
    structuredContentServiceImpl2.buildNameKey(currentSandbox, 1L, new LocaleImpl(), "text/plain",
        "Not all who wander are lost");
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String, Boolean)}
   * with {@code currentSandbox}, {@code site}, {@code locale},
   * {@code contentType}, {@code contentName}, {@code secure}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String, Boolean)}
   */
  @Test
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentNameSecure() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals("text/plain-Not all who wander are lost-null-null-1-true", structuredContentServiceImpl
        .buildNameKey(currentSandbox, 1L, new LocaleImpl(), "text/plain", "Not all who wander are lost", true));
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String, Boolean)}
   * with {@code currentSandbox}, {@code site}, {@code locale},
   * {@code contentType}, {@code contentName}, {@code secure}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String, Boolean)}
   */
  @Test
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentNameSecure2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("text/plain-Not all who wander are lost", (new StructuredContentServiceImpl()).buildNameKey(null, null,
        null, "text/plain", "Not all who wander are lost", null));
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String, Boolean)}
   * with {@code currentSandbox}, {@code site}, {@code locale},
   * {@code contentType}, {@code contentName}, {@code secure}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String, Boolean)}
   */
  @Test
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentNameSecure3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = mock(SandBoxImpl.class);
    when(currentSandbox.getId()).thenReturn(1L);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(currentSandbox, 1L, new LocaleImpl(),
        "text/plain", "Not all who wander are lost", true);

    // Assert
    verify(currentSandbox).getId();
    assertEquals("text/plain-Not all who wander are lost-null-1-1-true", actualBuildNameKeyResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String, Boolean)}
   * with {@code currentSandbox}, {@code site}, {@code locale},
   * {@code contentType}, {@code contentName}, {@code secure}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String, Boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildNameKeyWithCurrentSandboxSiteLocaleContentTypeContentNameSecure4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5892 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act
    structuredContentServiceImpl2.buildNameKey(currentSandbox, 1L, new LocaleImpl(), "text/plain",
        "Not all who wander are lost", true);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)}
   * with {@code sandBox}, {@code sc}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildNameKeyWithSandBoxSc() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5949 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();
    SandBoxImpl sandBox = new SandBoxImpl();

    // Act
    structuredContentServiceImpl2.buildNameKey(sandBox, new StructuredContentImpl());
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   * with {@code sandBox}, {@code sc}, {@code secure}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildNameKeyWithSandBoxScSecure() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5981 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();
    SandBoxImpl sandBox = new SandBoxImpl();

    // Act
    structuredContentServiceImpl2.buildNameKey(sandBox, new StructuredContentImpl(), true);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   * with {@code sandBox}, {@code sc}, {@code secure}.
   * <ul>
   *   <li>Then return {@code Name-Not all who wander are lost-1}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   */
  @Test
  public void testBuildNameKeyWithSandBoxScSecure_thenReturnNameNotAllWhoWanderAreLost1() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(null, sc, null);

    // Assert
    verify(structuredContentType).getName();
    assertEquals("Name-Not all who wander are lost-1", actualBuildNameKeyResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   * with {@code sandBox}, {@code sc}, {@code secure}.
   * <ul>
   *   <li>Then return {@code Name-Not all who wander are lost-1-null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   */
  @Test
  public void testBuildNameKeyWithSandBoxScSecure_thenReturnNameNotAllWhoWanderAreLost1Null() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl sandBox = new SandBoxImpl();
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(sandBox, sc, null);

    // Assert
    verify(structuredContentType).getName();
    assertEquals("Name-Not all who wander are lost-1-null", actualBuildNameKeyResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   * with {@code sandBox}, {@code sc}, {@code secure}.
   * <ul>
   *   <li>Then return {@code Name-Not all who wander are lost-1-true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   */
  @Test
  public void testBuildNameKeyWithSandBoxScSecure_thenReturnNameNotAllWhoWanderAreLost1True() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(null, sc, true);

    // Assert
    verify(structuredContentType).getName();
    assertEquals("Name-Not all who wander are lost-1-true", actualBuildNameKeyResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)}
   * with {@code sandBox}, {@code sc}.
   * <ul>
   *   <li>Then return {@code Name-Not all who wander are lost-1}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)}
   */
  @Test
  public void testBuildNameKeyWithSandBoxSc_thenReturnNameNotAllWhoWanderAreLost1() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(null, sc);

    // Assert
    verify(structuredContentType).getName();
    assertEquals("Name-Not all who wander are lost-1", actualBuildNameKeyResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)}
   * with {@code sandBox}, {@code sc}.
   * <ul>
   *   <li>Then return {@code Name-Not all who wander are lost-1-null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)}
   */
  @Test
  public void testBuildNameKeyWithSandBoxSc_thenReturnNameNotAllWhoWanderAreLost1Null() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl sandBox = new SandBoxImpl();
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(sandBox, sc);

    // Assert
    verify(structuredContentType).getName();
    assertEquals("Name-Not all who wander are lost-1-null", actualBuildNameKeyResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)}
   * with {@code currentSandbox}, {@code site}, {@code locale},
   * {@code contentType}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)}
   */
  @Test
  public void testBuildTypeKeyWithCurrentSandboxSiteLocaleContentType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals("text/plain-null-null-1",
        structuredContentServiceImpl.buildTypeKey(currentSandbox, 1L, new LocaleImpl(), "text/plain"));
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)}
   * with {@code currentSandbox}, {@code site}, {@code locale},
   * {@code contentType}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)}
   */
  @Test
  public void testBuildTypeKeyWithCurrentSandboxSiteLocaleContentType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = mock(SandBoxImpl.class);
    when(currentSandbox.getId()).thenReturn(1L);

    // Act
    String actualBuildTypeKeyResult = structuredContentServiceImpl.buildTypeKey(currentSandbox, 1L, new LocaleImpl(),
        "text/plain");

    // Assert
    verify(currentSandbox).getId();
    assertEquals("text/plain-null-1-1", actualBuildTypeKeyResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)}
   * with {@code currentSandbox}, {@code site}, {@code locale},
   * {@code contentType}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildTypeKeyWithCurrentSandboxSiteLocaleContentType3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6062 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act
    structuredContentServiceImpl2.buildTypeKey(currentSandbox, 1L, new LocaleImpl(), "text/plain");
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)}
   * with {@code currentSandbox}, {@code site}, {@code locale},
   * {@code contentType}.
   * <ul>
   *   <li>Then return {@code text/plain}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)}
   */
  @Test
  public void testBuildTypeKeyWithCurrentSandboxSiteLocaleContentType_thenReturnTextPlain() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("text/plain", (new StructuredContentServiceImpl()).buildTypeKey(null, null, null, "text/plain"));
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)}
   * with {@code sandBox}, {@code sc}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildTypeKeyWithSandBoxSc() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6105 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();
    SandBoxImpl sandBox = new SandBoxImpl();

    // Act
    structuredContentServiceImpl2.buildTypeKey(sandBox, new StructuredContentImpl());
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)}
   * with {@code sandBox}, {@code sc}.
   * <ul>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)}
   */
  @Test
  public void testBuildTypeKeyWithSandBoxSc_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act
    String actualBuildTypeKeyResult = structuredContentServiceImpl.buildTypeKey(null, sc);

    // Assert
    verify(structuredContentType).getName();
    assertEquals("Name", actualBuildTypeKeyResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)}
   * with {@code sandBox}, {@code sc}.
   * <ul>
   *   <li>Then return {@code Name-null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)}
   */
  @Test
  public void testBuildTypeKeyWithSandBoxSc_thenReturnNameNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl sandBox = new SandBoxImpl();
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act
    String actualBuildTypeKeyResult = structuredContentServiceImpl.buildTypeKey(sandBox, sc);

    // Assert
    verify(structuredContentType).getName();
    assertEquals("Name-null", actualBuildTypeKeyResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildTypeKeyWithSecure() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6137 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act
    structuredContentServiceImpl2.buildTypeKeyWithSecure(currentSandbox, 1L, new LocaleImpl(), "text/plain", true);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return {@code text/plain-null-1-1-true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)}
   */
  @Test
  public void testBuildTypeKeyWithSecure_givenOne_thenReturnTextPlainNull11True() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = mock(SandBoxImpl.class);
    when(currentSandbox.getId()).thenReturn(1L);

    // Act
    String actualBuildTypeKeyWithSecureResult = structuredContentServiceImpl.buildTypeKeyWithSecure(currentSandbox, 1L,
        new LocaleImpl(), "text/plain", true);

    // Assert
    verify(currentSandbox).getId();
    assertEquals("text/plain-null-1-1-true", actualBuildTypeKeyWithSecureResult);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code text/plain}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)}
   */
  @Test
  public void testBuildTypeKeyWithSecure_whenNull_thenReturnTextPlain() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("text/plain",
        (new StructuredContentServiceImpl()).buildTypeKeyWithSecure(null, null, null, "text/plain", null));
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)}.
   * <ul>
   *   <li>When {@link SandBoxImpl} (default constructor).</li>
   *   <li>Then return {@code text/plain-null-null-1-true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)}
   */
  @Test
  public void testBuildTypeKeyWithSecure_whenSandBoxImpl_thenReturnTextPlainNullNull1True() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals("text/plain-null-null-1-true",
        structuredContentServiceImpl.buildTypeKeyWithSecure(currentSandbox, 1L, new LocaleImpl(), "text/plain", true));
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#addStructuredContentListToCache(String, List)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#addStructuredContentListToCache(String, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddStructuredContentListToCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5330 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();

    // Act
    structuredContentServiceImpl2.addStructuredContentListToCache("Key", new ArrayList<>());
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#addSingleStructuredContentToCache(String, StructuredContentDTO)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#addSingleStructuredContentToCache(String, StructuredContentDTO)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddSingleStructuredContentToCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5105 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();

    StructuredContentDTO scDTO = new StructuredContentDTO();
    scDTO.setContentName("Not all who wander are lost");
    scDTO.setContentType("text/plain");
    scDTO.setId(1L);
    scDTO.setItemCriteriaDTOList(new ArrayList<>());
    scDTO.setLocaleCode("en");
    scDTO.setPriority(1);
    scDTO.setRuleExpression("Rule Expression");
    scDTO.setValues(new HashMap<>());

    // Act
    structuredContentServiceImpl2.addSingleStructuredContentToCache("Key", scDTO);
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#getSingleStructuredContentFromCache(String)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#getSingleStructuredContentFromCache(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSingleStructuredContentFromCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6809 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentServiceImpl()).getSingleStructuredContentFromCache("Key");
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#getStructuredContentListFromCache(String)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#getStructuredContentListFromCache(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetStructuredContentListFromCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7155 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new StructuredContentServiceImpl()).getStructuredContentListFromCache("Key");
  }

  /**
   * Test
   * {@link StructuredContentServiceImpl#getStructuredContentItemsByContentName(String, Locale, boolean)}.
   * <p>
   * Method under test:
   * {@link StructuredContentServiceImpl#getStructuredContentItemsByContentName(String, Locale, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetStructuredContentItemsByContentName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.structure.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7129 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.structure.service.StructuredContentServiceImpl structuredContentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl2 = new StructuredContentServiceImpl();

    // Act
    structuredContentServiceImpl2.getStructuredContentItemsByContentName("Not all who wander are lost",
        new LocaleImpl(), true);
  }
}
