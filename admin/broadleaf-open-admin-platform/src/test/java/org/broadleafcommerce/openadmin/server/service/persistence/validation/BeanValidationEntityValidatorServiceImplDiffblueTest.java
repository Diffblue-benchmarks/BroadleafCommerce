package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Validator;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.beanvalidation.CustomValidatorBean;

@ContextConfiguration(classes = {BeanValidationEntityValidatorServiceImpl.class, Validator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BeanValidationEntityValidatorServiceImplDiffblueTest {
  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  private BeanValidationEntityValidatorServiceImpl beanValidationEntityValidatorServiceImpl;

  @MockBean
  private GlobalPropertyValidator globalPropertyValidator;

  @Autowired
  private List<GlobalPropertyValidator> list;

  @MockBean
  private RowLevelSecurityService rowLevelSecurityService;

  /**
   * Test
   * {@link BeanValidationEntityValidatorServiceImpl#validate(Entity, Serializable, Map, RecordHelper, boolean)}.
   * <p>
   * Method under test:
   * {@link BeanValidationEntityValidatorServiceImpl#validate(Entity, Serializable, Map, RecordHelper, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.validation;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.server.service.persistence.validation.BeanValidationEntityValidatorServiceImpl.class,javax.validation.Validator.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass959 {
    //     @org.springframework.beans.factory.annotation.Autowired org.springframework.context.ApplicationContext applicationContext;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.validation.BeanValidationEntityValidatorServiceImpl beanValidationEntityValidatorServiceImpl;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.persistence.validation.GlobalPropertyValidator globalPropertyValidator;
    //     @org.springframework.beans.factory.annotation.Autowired java.util.List<Lorg.broadleafcommerce.openadmin.server.service.persistence.validation.GlobalPropertyValidator;> list;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService rowLevelSecurityService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    Entity entity = new Entity();
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();

    // Act
    beanValidationEntityValidatorServiceImpl.validate(entity, instance, mergedProperties,
        new AdornedTargetListPersistenceModule(), true);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BeanValidationEntityValidatorServiceImpl}
   *   <li>
   * {@link BeanValidationEntityValidatorServiceImpl#setUseDefaultEntityValidations(boolean)}
   *   <li>{@link BeanValidationEntityValidatorServiceImpl#setValidator(Validator)}
   *   <li>{@link BeanValidationEntityValidatorServiceImpl#getValidator()}
   *   <li>
   * {@link BeanValidationEntityValidatorServiceImpl#isUseDefaultEntityValidations()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BeanValidationEntityValidatorServiceImpl actualBeanValidationEntityValidatorServiceImpl = new BeanValidationEntityValidatorServiceImpl();
    actualBeanValidationEntityValidatorServiceImpl.setUseDefaultEntityValidations(true);
    CustomValidatorBean validator = new CustomValidatorBean();
    actualBeanValidationEntityValidatorServiceImpl.setValidator(validator);
    Validator actualValidator = actualBeanValidationEntityValidatorServiceImpl.getValidator();

    // Assert that nothing has changed
    assertTrue(actualValidator instanceof CustomValidatorBean);
    assertTrue(actualBeanValidationEntityValidatorServiceImpl.isUseDefaultEntityValidations());
    assertSame(validator, actualValidator);
  }
}
