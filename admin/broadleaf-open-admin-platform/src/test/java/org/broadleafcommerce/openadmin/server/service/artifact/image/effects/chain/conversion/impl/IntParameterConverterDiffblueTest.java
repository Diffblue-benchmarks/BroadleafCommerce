package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.impl;

import static org.junit.Assert.assertEquals;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.ConversionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {IntParameterConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class IntParameterConverterDiffblueTest {
  @Autowired
  private IntParameterConverter intParameterConverter;

  /**
   * Test {@link IntParameterConverter#convert(String, Double, boolean)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return ParameterClass Name is {@code int}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IntParameterConverter#convert(String, Double, boolean)}
   */
  @Test
  public void testConvert_when42_thenReturnParameterClassNameIsInt() throws ConversionException {
    // Arrange, Act and Assert
    assertEquals("int", intParameterConverter.convert("42", 10.0d, true).getParameterClass().getName());
  }

  /**
   * Test {@link IntParameterConverter#convert(String, Double, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return ParameterClass Name is {@code int}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IntParameterConverter#convert(String, Double, boolean)}
   */
  @Test
  public void testConvert_whenFalse_thenReturnParameterClassNameIsInt() throws ConversionException {
    // Arrange, Act and Assert
    assertEquals("int", intParameterConverter.convert("42", 10.0d, false).getParameterClass().getName());
  }

  /**
   * Test {@link IntParameterConverter#convert(String, Double, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ParameterClass Name is {@code int}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IntParameterConverter#convert(String, Double, boolean)}
   */
  @Test
  public void testConvert_whenNull_thenReturnParameterClassNameIsInt() throws ConversionException {
    // Arrange, Act and Assert
    assertEquals("int", intParameterConverter.convert("42", null, true).getParameterClass().getName());
  }

  /**
   * Test new {@link IntParameterConverter} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link IntParameterConverter}
   */
  @Test
  public void testNewIntParameterConverter() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new IntParameterConverter();
  }
}
