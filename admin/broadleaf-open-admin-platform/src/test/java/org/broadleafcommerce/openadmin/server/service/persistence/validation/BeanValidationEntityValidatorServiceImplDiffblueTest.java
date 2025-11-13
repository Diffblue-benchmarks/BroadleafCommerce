package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.validation.Validator;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.validation.beanvalidation.CustomValidatorBean;

public class BeanValidationEntityValidatorServiceImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BeanValidationEntityValidatorServiceImpl}
   *   <li>{@link BeanValidationEntityValidatorServiceImpl#setUseDefaultEntityValidations(boolean)}
   *   <li>{@link BeanValidationEntityValidatorServiceImpl#setValidator(Validator)}
   *   <li>{@link BeanValidationEntityValidatorServiceImpl#getValidator()}
   *   <li>{@link BeanValidationEntityValidatorServiceImpl#isUseDefaultEntityValidations()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BeanValidationEntityValidatorServiceImpl.<init>()",
    "Validator BeanValidationEntityValidatorServiceImpl.getValidator()",
    "boolean BeanValidationEntityValidatorServiceImpl.isUseDefaultEntityValidations()",
    "void BeanValidationEntityValidatorServiceImpl.setUseDefaultEntityValidations(boolean)",
    "void BeanValidationEntityValidatorServiceImpl.setValidator(Validator)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BeanValidationEntityValidatorServiceImpl actualBeanValidationEntityValidatorServiceImpl =
        new BeanValidationEntityValidatorServiceImpl();
    actualBeanValidationEntityValidatorServiceImpl.setUseDefaultEntityValidations(true);
    CustomValidatorBean validator = new CustomValidatorBean();
    actualBeanValidationEntityValidatorServiceImpl.setValidator(validator);
    Validator actualValidator = actualBeanValidationEntityValidatorServiceImpl.getValidator();
    boolean actualIsUseDefaultEntityValidationsResult =
        actualBeanValidationEntityValidatorServiceImpl.isUseDefaultEntityValidations();

    // Assert
    assertTrue(actualValidator instanceof CustomValidatorBean);
    assertNull(actualBeanValidationEntityValidatorServiceImpl.getGlobalEntityValidators());
    assertTrue(actualIsUseDefaultEntityValidationsResult);
    assertSame(validator, actualValidator);
  }
}
