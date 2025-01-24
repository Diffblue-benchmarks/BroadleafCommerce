package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.impl;

import static org.junit.Assert.assertEquals;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.ConversionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BooleanParameterConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BooleanParameterConverterDiffblueTest {
  @Autowired
  private BooleanParameterConverter booleanParameterConverter;

  /**
   * Test {@link BooleanParameterConverter#convert(String, Double, boolean)}.
   * <p>
   * Method under test:
   * {@link BooleanParameterConverter#convert(String, Double, boolean)}
   */
  @Test
  public void testConvert() throws ConversionException {
    // Arrange, Act and Assert
    assertEquals("boolean", booleanParameterConverter.convert("42", 10.0d, true).getParameterClass().getName());
  }

  /**
   * Test new {@link BooleanParameterConverter} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BooleanParameterConverter}
   */
  @Test
  public void testNewBooleanParameterConverter() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new BooleanParameterConverter();
  }
}
