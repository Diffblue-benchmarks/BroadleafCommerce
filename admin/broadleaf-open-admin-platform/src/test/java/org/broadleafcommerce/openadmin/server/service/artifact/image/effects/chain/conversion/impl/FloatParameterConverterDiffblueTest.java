package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.impl;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.ConversionException;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.Parameter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FloatParameterConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FloatParameterConverterDiffblueTest {
  @Autowired private FloatParameterConverter floatParameterConverter;

  /**
   * Test {@link FloatParameterConverter#convert(String, Double, boolean)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return ParameterInstance floatValue is {@code 4.2}.
   * </ul>
   *
   * <p>Method under test: {@link FloatParameterConverter#convert(String, Double, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Parameter FloatParameterConverter.convert(String, Double, boolean)"})
  public void testConvert_when42_thenReturnParameterInstanceFloatValueIs42()
      throws ConversionException {
    // Arrange and Act
    Parameter actualConvertResult = floatParameterConverter.convert("42", 10.0d, true);

    // Assert
    assertEquals("float", actualConvertResult.getParameterClass().getName());
    assertEquals(4.2f, ((Float) actualConvertResult.getParameterInstance()).floatValue(), 0.0f);
  }

  /**
   * Test {@link FloatParameterConverter#convert(String, Double, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return ParameterInstance floatValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link FloatParameterConverter#convert(String, Double, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Parameter FloatParameterConverter.convert(String, Double, boolean)"})
  public void testConvert_whenFalse_thenReturnParameterInstanceFloatValueIsFortyTwo()
      throws ConversionException {
    // Arrange and Act
    Parameter actualConvertResult = floatParameterConverter.convert("42", 10.0d, false);

    // Assert
    assertEquals("float", actualConvertResult.getParameterClass().getName());
    assertEquals(42.0f, ((Float) actualConvertResult.getParameterInstance()).floatValue(), 0.0f);
  }

  /**
   * Test {@link FloatParameterConverter#convert(String, Double, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ParameterInstance floatValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link FloatParameterConverter#convert(String, Double, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Parameter FloatParameterConverter.convert(String, Double, boolean)"})
  public void testConvert_whenNull_thenReturnParameterInstanceFloatValueIsFortyTwo()
      throws ConversionException {
    // Arrange and Act
    Parameter actualConvertResult = floatParameterConverter.convert("42", null, true);

    // Assert
    assertEquals("float", actualConvertResult.getParameterClass().getName());
    assertEquals(42.0f, ((Float) actualConvertResult.getParameterInstance()).floatValue(), 0.0f);
  }
}
