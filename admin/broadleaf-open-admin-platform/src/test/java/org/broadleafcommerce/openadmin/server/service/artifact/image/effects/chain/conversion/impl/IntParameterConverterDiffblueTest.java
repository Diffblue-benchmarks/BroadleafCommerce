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

@ContextConfiguration(classes = {IntParameterConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class IntParameterConverterDiffblueTest {
  @Autowired private IntParameterConverter intParameterConverter;

  /**
   * Test {@link IntParameterConverter#convert(String, Double, boolean)}.
   *
   * <ul>
   *   <li>When {@code 1}.
   *   <li>Then return ParameterInstance intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link IntParameterConverter#convert(String, Double, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Parameter IntParameterConverter.convert(String, Double, boolean)"})
  public void testConvert_when1_thenReturnParameterInstanceIntValueIsOne()
      throws ConversionException {
    // Arrange and Act
    Parameter actualConvertResult = intParameterConverter.convert("1", 10.0d, false);

    // Assert
    assertEquals("int", actualConvertResult.getParameterClass().getName());
    assertEquals(1, ((Integer) actualConvertResult.getParameterInstance()).intValue());
  }

  /**
   * Test {@link IntParameterConverter#convert(String, Double, boolean)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return ParameterInstance intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link IntParameterConverter#convert(String, Double, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Parameter IntParameterConverter.convert(String, Double, boolean)"})
  public void testConvert_when42_thenReturnParameterInstanceIntValueIsFortyTwo()
      throws ConversionException {
    // Arrange and Act
    Parameter actualConvertResult = intParameterConverter.convert("42", null, true);

    // Assert
    assertEquals("int", actualConvertResult.getParameterClass().getName());
    assertEquals(42, ((Integer) actualConvertResult.getParameterInstance()).intValue());
  }

  /**
   * Test {@link IntParameterConverter#convert(String, Double, boolean)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return ParameterInstance intValue is four.
   * </ul>
   *
   * <p>Method under test: {@link IntParameterConverter#convert(String, Double, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Parameter IntParameterConverter.convert(String, Double, boolean)"})
  public void testConvert_when42_thenReturnParameterInstanceIntValueIsFour()
      throws ConversionException {
    // Arrange and Act
    Parameter actualConvertResult = intParameterConverter.convert("42", 10.0d, true);

    // Assert
    assertEquals("int", actualConvertResult.getParameterClass().getName());
    assertEquals(4, ((Integer) actualConvertResult.getParameterInstance()).intValue());
  }
}
