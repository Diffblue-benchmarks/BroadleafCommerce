package org.broadleafcommerce.openadmin.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.presentation.model.BroadleafBindStatus;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BindException;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ErrorsProcessorDiffblueTest {
  @Autowired
  private ErrorsProcessor errorsProcessor;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorsProcessor#getName()}
   *   <li>{@link ErrorsProcessor#getPrefix()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ErrorsProcessor errorsProcessor = new ErrorsProcessor();

    // Act
    String actualName = errorsProcessor.getName();

    // Assert
    assertEquals("blc_admin", errorsProcessor.getPrefix());
    assertEquals("errors", actualName);
  }

  /**
   * Test {@link ErrorsProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link ErrorsProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10000, (new ErrorsProcessor()).getPrecedence());
  }

  /**
   * Test {@link ErrorsProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link ErrorsProcessor#getPrecedence()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPrecedence2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6057 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.processor.ErrorsProcessor errorsProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ErrorsProcessor()).getPrecedence();
  }

  /**
   * Test {@link ErrorsProcessor#getPrecedence()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorsProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, List<String>> tabErrors = new HashMap<>();
    tabErrors.computeIfPresent("foo", mock(BiFunction.class));

    ErrorsProcessor errorsProcessor = new ErrorsProcessor();
    errorsProcessor.addFieldError("Field Name", "Not all who wander are lost", tabErrors);

    // Act and Assert
    assertEquals(10000, errorsProcessor.getPrecedence());
  }

  /**
   * Test
   * {@link ErrorsProcessor#populateModelVariables(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link ErrorsProcessor#populateModelVariables(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateModelVariables() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6059 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.processor.ErrorsProcessor errorsProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ErrorsProcessor errorsProcessor2 = new ErrorsProcessor();

    // Act
    errorsProcessor2.populateModelVariables("Tag Name", new HashMap<>(), "Attribute Name", "42",
        mock(BroadleafTemplateContext.class));
  }

  /**
   * Test
   * {@link ErrorsProcessor#populateModelVariables(String, Map, String, String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ErrorsProcessor#populateModelVariables(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  public void testPopulateModelVariables_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ErrorsProcessor errorsProcessor = new ErrorsProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafBindStatus broadleafBindStatus = mock(BroadleafBindStatus.class);
    when(broadleafBindStatus.getErrors()).thenReturn(new BindException(new EntityForm(), "Object Name"));
    when(broadleafBindStatus.isError()).thenReturn(true);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.getBindStatus(Mockito.<String>any())).thenReturn(broadleafBindStatus);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult = errorsProcessor.populateModelVariables("Tag Name",
        tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(broadleafBindStatus, atLeast(1)).getErrors();
    verify(broadleafBindStatus).isError();
    verify(context).getBindStatus(eq("42"));
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get("tabErrors");
    assertTrue(getResult instanceof Map);
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }

  /**
   * Test {@link ErrorsProcessor#addFieldError(String, String, Map)}.
   * <p>
   * Method under test: {@link ErrorsProcessor#addFieldError(String, String, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddFieldError() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6031 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.processor.ErrorsProcessor errorsProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ErrorsProcessor errorsProcessor2 = new ErrorsProcessor();

    // Act
    errorsProcessor2.addFieldError("Field Name", "Not all who wander are lost", new HashMap<>());
  }

  /**
   * Test {@link ErrorsProcessor#addFieldError(String, String, Map)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then {@link HashMap#HashMap()} empty string size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorsProcessor#addFieldError(String, String, Map)}
   */
  @Test
  public void testAddFieldError_givenEmptyString_thenHashMapEmptyStringSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ErrorsProcessor errorsProcessor = new ErrorsProcessor();

    HashMap<String, List<String>> tabErrors = new HashMap<>();
    ArrayList<String> stringList = new ArrayList<>();
    tabErrors.put("", stringList);

    // Act
    errorsProcessor.addFieldError("", "Not all who wander are lost", tabErrors);

    // Assert
    assertEquals(1, tabErrors.size());
    List<String> getResult = tabErrors.get("");
    assertEquals(1, getResult.size());
    assertEquals("Not all who wander are lost", getResult.get(0));
    assertSame(stringList, getResult);
  }

  /**
   * Test {@link ErrorsProcessor#addFieldError(String, String, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorsProcessor#addFieldError(String, String, Map)}
   */
  @Test
  public void testAddFieldError_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ErrorsProcessor errorsProcessor = new ErrorsProcessor();

    HashMap<String, List<String>> tabErrors = new HashMap<>();
    tabErrors.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    errorsProcessor.addFieldError("Field Name", "Not all who wander are lost", tabErrors);

    // Assert
    assertEquals(1, tabErrors.size());
    List<String> getResult = tabErrors.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("Not all who wander are lost", getResult.get(0));
  }

  /**
   * Test {@link ErrorsProcessor#addFieldError(String, String, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link HashMap#HashMap()} {@code Field Name} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ErrorsProcessor#addFieldError(String, String, Map)}
   */
  @Test
  public void testAddFieldError_whenHashMap_thenHashMapFieldNameSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ErrorsProcessor errorsProcessor = new ErrorsProcessor();
    HashMap<String, List<String>> tabErrors = new HashMap<>();

    // Act
    errorsProcessor.addFieldError("Field Name", "Not all who wander are lost", tabErrors);

    // Assert
    assertEquals(1, tabErrors.size());
    List<String> getResult = tabErrors.get("Field Name");
    assertEquals(1, getResult.size());
    assertEquals("Not all who wander are lost", getResult.get(0));
  }
}
