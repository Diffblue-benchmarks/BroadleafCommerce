/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.validation.Validator;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.validation.beanvalidation.CustomValidatorBean;

public class BeanValidationEntityValidatorServiceImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BeanValidationEntityValidatorServiceImpl}
   *   <li>{@link BeanValidationEntityValidatorServiceImpl#setUseDefaultEntityValidations(boolean)}
   *   <li>{@link BeanValidationEntityValidatorServiceImpl#setValidator(Validator)}
   *   <li>{@link BeanValidationEntityValidatorServiceImpl#getValidator()}
   *   <li>{@link BeanValidationEntityValidatorServiceImpl#isUseDefaultEntityValidations()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BeanValidationEntityValidatorServiceImpl.<init>()",
      "Validator BeanValidationEntityValidatorServiceImpl.getValidator()",
      "boolean BeanValidationEntityValidatorServiceImpl.isUseDefaultEntityValidations()",
      "void BeanValidationEntityValidatorServiceImpl.setUseDefaultEntityValidations(boolean)",
      "void BeanValidationEntityValidatorServiceImpl.setValidator(Validator)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    BeanValidationEntityValidatorServiceImpl actualBeanValidationEntityValidatorServiceImpl = new BeanValidationEntityValidatorServiceImpl();
    actualBeanValidationEntityValidatorServiceImpl.setUseDefaultEntityValidations(true);
    CustomValidatorBean validator = new CustomValidatorBean();
    actualBeanValidationEntityValidatorServiceImpl.setValidator(validator);
    Validator actualValidator = actualBeanValidationEntityValidatorServiceImpl.getValidator();
    boolean actualIsUseDefaultEntityValidationsResult = actualBeanValidationEntityValidatorServiceImpl
        .isUseDefaultEntityValidations();

    // Assert
    assertTrue(actualValidator instanceof CustomValidatorBean);
    assertNull(actualBeanValidationEntityValidatorServiceImpl.getGlobalEntityValidators());
    assertTrue(actualIsUseDefaultEntityValidationsResult);
    assertSame(validator, actualValidator);
  }
}
