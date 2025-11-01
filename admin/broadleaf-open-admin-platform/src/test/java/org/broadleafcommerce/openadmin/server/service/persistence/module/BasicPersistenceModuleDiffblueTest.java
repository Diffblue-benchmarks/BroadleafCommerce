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
package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.config.domain.SystemPropertyImpl;
import org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
import org.broadleafcommerce.common.util.dao.TQRestriction;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.ValidationException;
import org.broadleafcommerce.openadmin.server.service.persistence.ParentEntityPersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaConversionException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslator;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslatorImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPath;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter.FilterValueConverter;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.predicate.PredicateProvider;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.BasicFieldPersistenceProvider;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.FieldPersistenceProvider;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.BeanValidationEntityValidatorServiceImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.EntityValidatorService;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class BasicPersistenceModuleDiffblueTest {
  /**
   * Method under test: {@link BasicPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  public void testIsCompatible() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new BasicPersistenceModule()).isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
    assertTrue((new BasicPersistenceModule()).isCompatible(OperationType.BASIC));
    assertFalse((new AdornedTargetListPersistenceModule()).isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
    assertFalse((new BasicPersistenceModule()).isCompatible(OperationType.ADORNEDTARGETLIST));
  }

  /**
   * Method under test: {@link BasicPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  public void testIsCompatible2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));

    // Act and Assert
    assertTrue(basicPersistenceModule.isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getFieldManager()}
   */
  @Test
  public void testGetFieldManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    FieldManager actualFieldManager = basicPersistenceModule.getFieldManager();

    // Assert
    verify(persistenceManager).getDynamicEntityDao();
    assertNull(actualFieldManager.entityManager);
    assertNull(actualFieldManager.getEntityConfiguration());
    assertTrue(basicPersistenceModule.getFieldPersistenceProviders().isEmpty());
    assertTrue(actualFieldManager.middleFields.isEmpty());
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getFieldManager()}
   */
  @Test
  public void testGetFieldManager2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    FieldManager actualFieldManager = basicPersistenceModule.getFieldManager();

    // Assert
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
    assertTrue(basicPersistenceModule.getFieldPersistenceProviders().isEmpty());
    assertSame(fieldManager, actualFieldManager);
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getFieldManager(boolean)}
   */
  @Test
  public void testGetFieldManager3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    FieldManager actualFieldManager = basicPersistenceModule.getFieldManager(true);

    // Assert
    verify(persistenceManager).getDynamicEntityDao();
    assertNull(actualFieldManager.entityManager);
    assertNull(actualFieldManager.getEntityConfiguration());
    assertTrue(basicPersistenceModule.getFieldPersistenceProviders().isEmpty());
    assertTrue(actualFieldManager.middleFields.isEmpty());
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getFieldManager(boolean)}
   */
  @Test
  public void testGetFieldManager4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    when(dynamicEntityDaoImpl.getFieldManager(anyBoolean())).thenReturn(fieldManager);
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    FieldManager actualFieldManager = basicPersistenceModule.getFieldManager(true);

    // Assert
    verify(dynamicEntityDaoImpl).getFieldManager(eq(true));
    verify(persistenceManager).getDynamicEntityDao();
    assertTrue(basicPersistenceModule.getFieldPersistenceProviders().isEmpty());
    assertSame(fieldManager, actualFieldManager);
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getDecimalFormatter()}
   */
  @Test
  public void testGetDecimalFormatter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    DecimalFormat actualDecimalFormatter = (new BasicPersistenceModule()).getDecimalFormatter();

    // Assert
    assertEquals("", actualDecimalFormatter.getNegativeSuffix());
    assertEquals("", actualDecimalFormatter.getPositivePrefix());
    assertEquals("", actualDecimalFormatter.getPositiveSuffix());
    assertEquals("#0.########", actualDecimalFormatter.toLocalizedPattern());
    assertEquals("#0.########", actualDecimalFormatter.toPattern());
    assertEquals("-", actualDecimalFormatter.getNegativePrefix());
    DecimalFormatSymbols decimalFormatSymbols = actualDecimalFormatter.getDecimalFormatSymbols();
    assertEquals("E", decimalFormatSymbols.getExponentSeparator());
    assertEquals("NaN", decimalFormatSymbols.getNaN());
    Currency currency = actualDecimalFormatter.getCurrency();
    assertEquals("Unknown Currency", currency.getDisplayName());
    assertEquals("XXX", decimalFormatSymbols.getInternationalCurrencySymbol());
    assertEquals("XXX", currency.getCurrencyCode());
    assertEquals("XXX", currency.toString());
    assertEquals("¤", decimalFormatSymbols.getCurrencySymbol());
    assertEquals("¤", currency.getSymbol());
    assertEquals("∞", decimalFormatSymbols.getInfinity());
    assertEquals('#', decimalFormatSymbols.getDigit());
    assertEquals('%', decimalFormatSymbols.getPercent());
    assertEquals(',', decimalFormatSymbols.getGroupingSeparator());
    assertEquals('-', decimalFormatSymbols.getMinusSign());
    assertEquals('.', decimalFormatSymbols.getDecimalSeparator());
    assertEquals('.', decimalFormatSymbols.getMonetaryDecimalSeparator());
    assertEquals('0', decimalFormatSymbols.getZeroDigit());
    assertEquals(';', decimalFormatSymbols.getPatternSeparator());
    assertEquals('‰', decimalFormatSymbols.getPerMill());
    assertEquals(-1, currency.getDefaultFractionDigits());
    assertEquals(0, actualDecimalFormatter.getGroupingSize());
    assertEquals(0, actualDecimalFormatter.getMinimumFractionDigits());
    assertEquals(1, actualDecimalFormatter.getMinimumIntegerDigits());
    assertEquals(1, actualDecimalFormatter.getMultiplier());
    assertEquals(8, actualDecimalFormatter.getMaximumFractionDigits());
    assertEquals(999, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN, actualDecimalFormatter.getRoundingMode());
    assertFalse(actualDecimalFormatter.isDecimalSeparatorAlwaysShown());
    assertFalse(actualDecimalFormatter.isParseBigDecimal());
    assertFalse(actualDecimalFormatter.isGroupingUsed());
    assertFalse(actualDecimalFormatter.isParseIntegerOnly());
    assertEquals(Integer.MAX_VALUE, actualDecimalFormatter.getMaximumIntegerDigits());
    assertSame(currency, decimalFormatSymbols.getCurrency());
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getDecimalFormatter()}
   */
  @Test
  public void testGetDecimalFormatter2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));

    // Act
    DecimalFormat actualDecimalFormatter = basicPersistenceModule.getDecimalFormatter();

    // Assert
    assertEquals("", actualDecimalFormatter.getNegativeSuffix());
    assertEquals("", actualDecimalFormatter.getPositivePrefix());
    assertEquals("", actualDecimalFormatter.getPositiveSuffix());
    assertEquals("#0.########", actualDecimalFormatter.toLocalizedPattern());
    assertEquals("#0.########", actualDecimalFormatter.toPattern());
    assertEquals("-", actualDecimalFormatter.getNegativePrefix());
    DecimalFormatSymbols decimalFormatSymbols = actualDecimalFormatter.getDecimalFormatSymbols();
    assertEquals("E", decimalFormatSymbols.getExponentSeparator());
    assertEquals("NaN", decimalFormatSymbols.getNaN());
    Currency currency = actualDecimalFormatter.getCurrency();
    assertEquals("Unknown Currency", currency.getDisplayName());
    assertEquals("XXX", decimalFormatSymbols.getInternationalCurrencySymbol());
    assertEquals("XXX", currency.getCurrencyCode());
    assertEquals("XXX", currency.toString());
    assertEquals("¤", decimalFormatSymbols.getCurrencySymbol());
    assertEquals("¤", currency.getSymbol());
    assertEquals("∞", decimalFormatSymbols.getInfinity());
    assertEquals('#', decimalFormatSymbols.getDigit());
    assertEquals('%', decimalFormatSymbols.getPercent());
    assertEquals(',', decimalFormatSymbols.getGroupingSeparator());
    assertEquals('-', decimalFormatSymbols.getMinusSign());
    assertEquals('.', decimalFormatSymbols.getDecimalSeparator());
    assertEquals('.', decimalFormatSymbols.getMonetaryDecimalSeparator());
    assertEquals('0', decimalFormatSymbols.getZeroDigit());
    assertEquals(';', decimalFormatSymbols.getPatternSeparator());
    assertEquals('‰', decimalFormatSymbols.getPerMill());
    assertEquals(-1, currency.getDefaultFractionDigits());
    assertEquals(0, actualDecimalFormatter.getGroupingSize());
    assertEquals(0, actualDecimalFormatter.getMinimumFractionDigits());
    assertEquals(1, actualDecimalFormatter.getMinimumIntegerDigits());
    assertEquals(1, actualDecimalFormatter.getMultiplier());
    assertEquals(8, actualDecimalFormatter.getMaximumFractionDigits());
    assertEquals(999, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN, actualDecimalFormatter.getRoundingMode());
    assertFalse(actualDecimalFormatter.isDecimalSeparatorAlwaysShown());
    assertFalse(actualDecimalFormatter.isParseBigDecimal());
    assertFalse(actualDecimalFormatter.isGroupingUsed());
    assertFalse(actualDecimalFormatter.isParseIntegerOnly());
    assertEquals(Integer.MAX_VALUE, actualDecimalFormatter.getMaximumIntegerDigits());
    assertSame(currency, decimalFormatSymbols.getCurrency());
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getSimpleDateFormatter()}
   */
  @Test
  public void testGetSimpleDateFormatter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SimpleDateFormat actualSimpleDateFormatter = (new BasicPersistenceModule()).getSimpleDateFormatter();

    // Assert
    NumberFormat numberFormat = actualSimpleDateFormatter.getNumberFormat();
    assertTrue(numberFormat instanceof DecimalFormat);
    Calendar calendar = actualSimpleDateFormatter.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertEquals("", ((DecimalFormat) numberFormat).getNegativeSuffix());
    assertEquals("", ((DecimalFormat) numberFormat).getPositivePrefix());
    assertEquals("", ((DecimalFormat) numberFormat).getPositiveSuffix());
    assertEquals("###0", ((DecimalFormat) numberFormat).toLocalizedPattern());
    assertEquals("###0", ((DecimalFormat) numberFormat).toPattern());
    assertEquals("-", ((DecimalFormat) numberFormat).getNegativePrefix());
    DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormat).getDecimalFormatSymbols();
    assertEquals("E", decimalFormatSymbols.getExponentSeparator());
    DateFormatSymbols dateFormatSymbols = actualSimpleDateFormatter.getDateFormatSymbols();
    assertEquals("GyMdkHmsSEDFwWahKzZ", dateFormatSymbols.getLocalPatternChars());
    assertEquals("NaN", decimalFormatSymbols.getNaN());
    Currency currency = numberFormat.getCurrency();
    assertEquals("Unknown Currency", currency.getDisplayName());
    assertEquals("XXX", decimalFormatSymbols.getInternationalCurrencySymbol());
    assertEquals("XXX", currency.getCurrencyCode());
    assertEquals("XXX", currency.toString());
    assertEquals("¤", decimalFormatSymbols.getCurrencySymbol());
    assertEquals("¤", currency.getSymbol());
    assertEquals("∞", decimalFormatSymbols.getInfinity());
    assertEquals("gregory", calendar.getCalendarType());
    assertEquals("yyyy.MM.dd HH:mm:ss", actualSimpleDateFormatter.toPattern());
    assertEquals('#', decimalFormatSymbols.getDigit());
    assertEquals('%', decimalFormatSymbols.getPercent());
    assertEquals(',', decimalFormatSymbols.getGroupingSeparator());
    assertEquals('-', decimalFormatSymbols.getMinusSign());
    assertEquals('.', decimalFormatSymbols.getDecimalSeparator());
    assertEquals('.', decimalFormatSymbols.getMonetaryDecimalSeparator());
    assertEquals('0', decimalFormatSymbols.getZeroDigit());
    assertEquals(';', decimalFormatSymbols.getPatternSeparator());
    assertEquals('‰', decimalFormatSymbols.getPerMill());
    assertNull(actualSimpleDateFormatter.getTimeZone());
    assertNull(calendar.getTimeZone());
    assertEquals(-1, currency.getDefaultFractionDigits());
    assertEquals(0, numberFormat.getMaximumFractionDigits());
    assertEquals(0, numberFormat.getMinimumFractionDigits());
    assertEquals(1, ((DecimalFormat) numberFormat).getMultiplier());
    assertEquals(1, numberFormat.getMinimumIntegerDigits());
    assertEquals(1, calendar.getFirstDayOfWeek());
    assertEquals(1, calendar.getMinimalDaysInFirstWeek());
    assertEquals(3, ((DecimalFormat) numberFormat).getGroupingSize());
    String[][] zoneStrings = dateFormatSymbols.getZoneStrings();
    assertEquals(602, zoneStrings.length);
    assertEquals(999, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN, numberFormat.getRoundingMode());
    assertFalse(((DecimalFormat) numberFormat).isDecimalSeparatorAlwaysShown());
    assertFalse(((DecimalFormat) numberFormat).isParseBigDecimal());
    assertFalse(numberFormat.isGroupingUsed());
    assertTrue(actualSimpleDateFormatter.isLenient());
    assertTrue(numberFormat.isParseIntegerOnly());
    assertTrue(calendar.isLenient());
    assertTrue(calendar.isWeekDateSupported());
    assertEquals(Integer.MAX_VALUE, numberFormat.getMaximumIntegerDigits());
    assertSame(currency, decimalFormatSymbols.getCurrency());
    assertArrayEquals(new String[]{"AM", "PM"}, dateFormatSymbols.getAmPmStrings());
    assertArrayEquals(new String[]{"BC", "AD"}, dateFormatSymbols.getEras());
    assertArrayEquals(new String[]{"ACT", "Australian Central Standard Time", "ACST",
        "Australian Central Daylight Time", "ACDT", "Central Australia Time", "ACT"}, zoneStrings[18]);
    assertArrayEquals(new String[]{"AET", "Australian Eastern Standard Time", "AEST",
        "Australian Eastern Daylight Time", "AEDT", "Eastern Australia Time", "AET"}, zoneStrings[19]);
    assertArrayEquals(new String[]{"ART", "Eastern European Standard Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[20]);
    assertArrayEquals(
        new String[]{"AST", "Alaska Standard Time", "AKST", "Alaska Daylight Time", "AKDT", "Alaska Time", "AKT"},
        zoneStrings[21]);
    assertArrayEquals(new String[]{"America/Anchorage", "Alaska Standard Time", "AKST", "Alaska Daylight Time", "AKDT",
        "Alaska Time", "AKT"}, zoneStrings[7]);
    assertArrayEquals(new String[]{"America/Argentina/Buenos_Aires", "Argentina Standard Time", "ART",
        "Argentina Summer Time", "ARST", "Argentina Time", "ART"}, zoneStrings[599]);
    assertArrayEquals(new String[]{"America/Argentina/ComodRivadavia", "Argentina Standard Time", "ART",
        "Argentina Summer Time", "ARST", "Argentina Time", "ART"}, zoneStrings[588]);
    assertArrayEquals(new String[]{"America/Chicago", "Central Standard Time", "CST", "Central Daylight Time", "CDT",
        "Central Time", "CT"}, zoneStrings[3]);
    assertArrayEquals(new String[]{"America/Denver", "Mountain Standard Time", "MST", "Mountain Daylight Time", "MDT",
        "Mountain Time", "MT"}, zoneStrings[1]);
    assertArrayEquals(new String[]{"America/Ensenada", "Pacific Standard Time", "PST", "Pacific Daylight Time", "PDT",
        "Pacific Time", "PT"}, zoneStrings[582]);
    assertArrayEquals(new String[]{"America/Halifax", "Atlantic Standard Time", "AST", "Atlantic Daylight Time", "ADT",
        "Atlantic Time", "AT"}, zoneStrings[8]);
    assertArrayEquals(new String[]{"America/Indianapolis", "Eastern Standard Time", "EST", "Eastern Daylight Time",
        "EDT", "Eastern Time", "ET"}, zoneStrings[5]);
    assertArrayEquals(new String[]{"America/Los_Angeles", "Pacific Standard Time", "PST", "Pacific Daylight Time",
        "PDT", "Pacific Time", "PT"}, zoneStrings[0]);
    assertArrayEquals(new String[]{"America/New_York", "Eastern Standard Time", "EST", "Eastern Daylight Time", "EDT",
        "Eastern Time", "ET"}, zoneStrings[4]);
    assertArrayEquals(new String[]{"America/Nuuk", "West Greenland Standard Time", "WGT", "West Greenland Summer Time",
        "WGST", "West Greenland Time", "WGT"}, zoneStrings[591]);
    assertArrayEquals(new String[]{"America/Phoenix", "Mountain Standard Time", "MST", "Mountain Daylight Time", "MDT",
        "Mountain Time", "MT"}, zoneStrings[2]);
    assertArrayEquals(new String[]{"America/Rosario", "Argentina Standard Time", "ART", "Argentina Summer Time", "ARST",
        "Argentina Time", "ART"}, zoneStrings[595]);
    assertArrayEquals(new String[]{"America/Sitka", "Alaska Standard Time", "AKST", "Alaska Daylight Time", "AKDT",
        "Alaska Time", "AKT"}, zoneStrings[9]);
    assertArrayEquals(new String[]{"America/St_Johns", "Newfoundland Standard Time", "NST",
        "Newfoundland Daylight Time", "NDT", "Newfoundland Time", "NT"}, zoneStrings[10]);
    assertArrayEquals(new String[]{"America/Virgin", "Atlantic Standard Time", "AST", "Atlantic Daylight Time", "ADT",
        "Atlantic Time", "AT"}, zoneStrings[583]);
    assertArrayEquals(new String[]{"Asia/Famagusta", "Eastern European Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[589]);
    assertArrayEquals(new String[]{"Asia/Jerusalem", "Israel Standard Time", "IST", "Israel Daylight Time", "IDT",
        "Israel Time", "IT"}, zoneStrings[13]);
    assertArrayEquals(
        new String[]{"Asia/Shanghai", "China Standard Time", "CST", "China Daylight Time", "CDT", "China Time", "CT"},
        zoneStrings[Short.SIZE]);
    assertArrayEquals(new String[]{"Asia/Srednekolymsk", "Srednekolymsk Time", "SRET", "Srednekolymsk Daylight Time",
        "SREDT", "Srednekolymsk Time", "SRET"}, zoneStrings[598]);
    assertArrayEquals(
        new String[]{"Asia/Tokyo", "Japan Standard Time", "JST", "Japan Daylight Time", "JDT", "Japan Time", "JT"},
        zoneStrings[14]);
    assertArrayEquals(
        new String[]{"BET", "Brasilia Standard Time", "BRT", "Brasilia Summer Time", "BRST", "Brasilia Time", "BRT"},
        zoneStrings[22]);
    assertArrayEquals(new String[]{"BST", "Bangladesh Standard Time", "BDT", "Bangladesh Summer Time", "BDST",
        "Bangladesh Time", "BDT"}, zoneStrings[23]);
    assertArrayEquals(new String[]{"CAT", "Central Africa Time", "CAT", "Central African Summer Time", "CAST",
        "Central Africa Time", "CAT"}, zoneStrings[24]);
    assertArrayEquals(new String[]{"Canada/Saskatchewan", "Central Standard Time", "CST", "Central Daylight Time",
        "CDT", "Central Time", "CT"}, zoneStrings[596]);
    assertArrayEquals(new String[]{"EET", "Eastern European Time", "EET", "Eastern European Summer Time", "EEST",
        "Eastern European Time", "EET"}, zoneStrings[594]);
    assertArrayEquals(new String[]{"Egypt", "Eastern European Standard Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[597]);
    assertArrayEquals(new String[]{"Etc/Greenwich", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT",
        "Greenwich Mean Time", "GMT"}, zoneStrings[581]);
    assertArrayEquals(new String[]{"Europe/Astrakhan", "Astrakhan Standard Time", "GMT+04:00",
        "Astrakhan Standard Time", "GMT+04:00", "Astrakhan Time", "GMT+04:00"}, zoneStrings[580]);
    assertArrayEquals(new String[]{"Europe/Bucharest", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[15]);
    assertArrayEquals(new String[]{"Europe/Kyiv", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[585]);
    assertArrayEquals(new String[]{"Europe/Nicosia", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[600]);
    assertArrayEquals(new String[]{"Europe/Paris", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[11]);
    assertArrayEquals(new String[]{"Europe/Ulyanovsk", "Ulyanovsk Standard Time", "GMT+04:00",
        "Ulyanovsk Standard Time", "GMT+04:00", "Ulyanovsk Time", "GMT+04:00"}, zoneStrings[592]);
    assertArrayEquals(
        new String[]{"GMT", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT"},
        zoneStrings[12]);
    assertArrayEquals(new String[]{"Hongkong", "Hong Kong Standard Time", "HKT", "Hong Kong Summer Time", "HKST",
        "Hong Kong Time", "HKT"}, zoneStrings[586]);
    assertArrayEquals(
        new String[]{"Jamaica", "Eastern Standard Time", "EST", "Eastern Daylight Time", "EDT", "Eastern Time", "ET"},
        zoneStrings[578]);
    assertArrayEquals(
        new String[]{"Japan", "Japan Standard Time", "JST", "Japan Daylight Time", "JDT", "Japan Time", "JT"},
        zoneStrings[590]);
    assertArrayEquals(new String[]{"MST", "Mountain Standard Time", "MST", "Mountain Standard Time", "MST",
        "Mountain Standard Time", "MST"}, zoneStrings[584]);
    assertArrayEquals(new String[]{"Pacific/Honolulu", "Hawaii-Aleutian Standard Time", "HST",
        "Hawaii-Aleutian Daylight Time", "HDT", "Hawaii-Aleutian Time", "HST"}, zoneStrings[6]);
    assertArrayEquals(new String[]{"Turkey", "Turkey Time", "TRT", "Turkey Summer Time", "TRST", "Turkey Time", "TRT"},
        zoneStrings[577]);
    assertArrayEquals(new String[]{"UCT", "Coordinated Universal Time", "UTC", "Coordinated Universal Time", "UTC",
        "Coordinated Universal Time", "UTC"}, zoneStrings[587]);
    assertArrayEquals(new String[]{"US/Pacific", "Pacific Standard Time", "PST", "Pacific Daylight Time", "PDT",
        "Pacific Time", "PT"}, zoneStrings[601]);
    assertArrayEquals(new String[]{"UTC", "Coordinated Universal Time", "UTC", "Coordinated Universal Time", "UTC",
        "Coordinated Universal Time", "UTC"}, zoneStrings[17]);
    assertArrayEquals(
        new String[]{"W-SU", "Moscow Standard Time", "MSK", "Moscow Summer Time", "MSD", "Moscow Time", "MT"},
        zoneStrings[593]);
    assertArrayEquals(new String[]{"WET", "Western European Time", "WET", "Western European Summer Time", "WEST",
        "Western European Time", "WET"}, zoneStrings[579]);
    assertArrayEquals(new String[]{"", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"},
        dateFormatSymbols.getShortWeekdays());
    assertArrayEquals(new String[]{"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"},
        dateFormatSymbols.getWeekdays());
    assertArrayEquals(
        new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", ""},
        dateFormatSymbols.getShortMonths());
    assertArrayEquals(new String[]{"January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December", ""}, dateFormatSymbols.getMonths());
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getSimpleDateFormatter()}
   */
  @Test
  public void testGetSimpleDateFormatter2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));

    // Act
    SimpleDateFormat actualSimpleDateFormatter = basicPersistenceModule.getSimpleDateFormatter();

    // Assert
    NumberFormat numberFormat = actualSimpleDateFormatter.getNumberFormat();
    assertTrue(numberFormat instanceof DecimalFormat);
    Calendar calendar = actualSimpleDateFormatter.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertEquals("", ((DecimalFormat) numberFormat).getNegativeSuffix());
    assertEquals("", ((DecimalFormat) numberFormat).getPositivePrefix());
    assertEquals("", ((DecimalFormat) numberFormat).getPositiveSuffix());
    assertEquals("###0", ((DecimalFormat) numberFormat).toLocalizedPattern());
    assertEquals("###0", ((DecimalFormat) numberFormat).toPattern());
    assertEquals("-", ((DecimalFormat) numberFormat).getNegativePrefix());
    DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormat).getDecimalFormatSymbols();
    assertEquals("E", decimalFormatSymbols.getExponentSeparator());
    DateFormatSymbols dateFormatSymbols = actualSimpleDateFormatter.getDateFormatSymbols();
    assertEquals("GyMdkHmsSEDFwWahKzZ", dateFormatSymbols.getLocalPatternChars());
    assertEquals("NaN", decimalFormatSymbols.getNaN());
    Currency currency = numberFormat.getCurrency();
    assertEquals("Unknown Currency", currency.getDisplayName());
    assertEquals("XXX", decimalFormatSymbols.getInternationalCurrencySymbol());
    assertEquals("XXX", currency.getCurrencyCode());
    assertEquals("XXX", currency.toString());
    assertEquals("¤", decimalFormatSymbols.getCurrencySymbol());
    assertEquals("¤", currency.getSymbol());
    assertEquals("∞", decimalFormatSymbols.getInfinity());
    assertEquals("gregory", calendar.getCalendarType());
    assertEquals("yyyy.MM.dd HH:mm:ss", actualSimpleDateFormatter.toPattern());
    assertEquals('#', decimalFormatSymbols.getDigit());
    assertEquals('%', decimalFormatSymbols.getPercent());
    assertEquals(',', decimalFormatSymbols.getGroupingSeparator());
    assertEquals('-', decimalFormatSymbols.getMinusSign());
    assertEquals('.', decimalFormatSymbols.getDecimalSeparator());
    assertEquals('.', decimalFormatSymbols.getMonetaryDecimalSeparator());
    assertEquals('0', decimalFormatSymbols.getZeroDigit());
    assertEquals(';', decimalFormatSymbols.getPatternSeparator());
    assertEquals('‰', decimalFormatSymbols.getPerMill());
    assertNull(actualSimpleDateFormatter.getTimeZone());
    assertNull(calendar.getTimeZone());
    assertEquals(-1, currency.getDefaultFractionDigits());
    assertEquals(0, numberFormat.getMaximumFractionDigits());
    assertEquals(0, numberFormat.getMinimumFractionDigits());
    assertEquals(1, ((DecimalFormat) numberFormat).getMultiplier());
    assertEquals(1, numberFormat.getMinimumIntegerDigits());
    assertEquals(1, calendar.getFirstDayOfWeek());
    assertEquals(1, calendar.getMinimalDaysInFirstWeek());
    assertEquals(3, ((DecimalFormat) numberFormat).getGroupingSize());
    String[][] zoneStrings = dateFormatSymbols.getZoneStrings();
    assertEquals(602, zoneStrings.length);
    assertEquals(999, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN, numberFormat.getRoundingMode());
    assertFalse(((DecimalFormat) numberFormat).isDecimalSeparatorAlwaysShown());
    assertFalse(((DecimalFormat) numberFormat).isParseBigDecimal());
    assertFalse(numberFormat.isGroupingUsed());
    assertTrue(actualSimpleDateFormatter.isLenient());
    assertTrue(numberFormat.isParseIntegerOnly());
    assertTrue(calendar.isLenient());
    assertTrue(calendar.isWeekDateSupported());
    assertEquals(Integer.MAX_VALUE, numberFormat.getMaximumIntegerDigits());
    assertSame(currency, decimalFormatSymbols.getCurrency());
    assertArrayEquals(new String[]{"AM", "PM"}, dateFormatSymbols.getAmPmStrings());
    assertArrayEquals(new String[]{"BC", "AD"}, dateFormatSymbols.getEras());
    assertArrayEquals(new String[]{"ACT", "Australian Central Standard Time", "ACST",
        "Australian Central Daylight Time", "ACDT", "Central Australia Time", "ACT"}, zoneStrings[18]);
    assertArrayEquals(new String[]{"AET", "Australian Eastern Standard Time", "AEST",
        "Australian Eastern Daylight Time", "AEDT", "Eastern Australia Time", "AET"}, zoneStrings[19]);
    assertArrayEquals(new String[]{"ART", "Eastern European Standard Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[20]);
    assertArrayEquals(
        new String[]{"AST", "Alaska Standard Time", "AKST", "Alaska Daylight Time", "AKDT", "Alaska Time", "AKT"},
        zoneStrings[21]);
    assertArrayEquals(new String[]{"America/Anchorage", "Alaska Standard Time", "AKST", "Alaska Daylight Time", "AKDT",
        "Alaska Time", "AKT"}, zoneStrings[7]);
    assertArrayEquals(new String[]{"America/Argentina/Buenos_Aires", "Argentina Standard Time", "ART",
        "Argentina Summer Time", "ARST", "Argentina Time", "ART"}, zoneStrings[599]);
    assertArrayEquals(new String[]{"America/Argentina/ComodRivadavia", "Argentina Standard Time", "ART",
        "Argentina Summer Time", "ARST", "Argentina Time", "ART"}, zoneStrings[588]);
    assertArrayEquals(new String[]{"America/Chicago", "Central Standard Time", "CST", "Central Daylight Time", "CDT",
        "Central Time", "CT"}, zoneStrings[3]);
    assertArrayEquals(new String[]{"America/Denver", "Mountain Standard Time", "MST", "Mountain Daylight Time", "MDT",
        "Mountain Time", "MT"}, zoneStrings[1]);
    assertArrayEquals(new String[]{"America/Ensenada", "Pacific Standard Time", "PST", "Pacific Daylight Time", "PDT",
        "Pacific Time", "PT"}, zoneStrings[582]);
    assertArrayEquals(new String[]{"America/Halifax", "Atlantic Standard Time", "AST", "Atlantic Daylight Time", "ADT",
        "Atlantic Time", "AT"}, zoneStrings[8]);
    assertArrayEquals(new String[]{"America/Indianapolis", "Eastern Standard Time", "EST", "Eastern Daylight Time",
        "EDT", "Eastern Time", "ET"}, zoneStrings[5]);
    assertArrayEquals(new String[]{"America/Los_Angeles", "Pacific Standard Time", "PST", "Pacific Daylight Time",
        "PDT", "Pacific Time", "PT"}, zoneStrings[0]);
    assertArrayEquals(new String[]{"America/New_York", "Eastern Standard Time", "EST", "Eastern Daylight Time", "EDT",
        "Eastern Time", "ET"}, zoneStrings[4]);
    assertArrayEquals(new String[]{"America/Nuuk", "West Greenland Standard Time", "WGT", "West Greenland Summer Time",
        "WGST", "West Greenland Time", "WGT"}, zoneStrings[591]);
    assertArrayEquals(new String[]{"America/Phoenix", "Mountain Standard Time", "MST", "Mountain Daylight Time", "MDT",
        "Mountain Time", "MT"}, zoneStrings[2]);
    assertArrayEquals(new String[]{"America/Rosario", "Argentina Standard Time", "ART", "Argentina Summer Time", "ARST",
        "Argentina Time", "ART"}, zoneStrings[595]);
    assertArrayEquals(new String[]{"America/Sitka", "Alaska Standard Time", "AKST", "Alaska Daylight Time", "AKDT",
        "Alaska Time", "AKT"}, zoneStrings[9]);
    assertArrayEquals(new String[]{"America/St_Johns", "Newfoundland Standard Time", "NST",
        "Newfoundland Daylight Time", "NDT", "Newfoundland Time", "NT"}, zoneStrings[10]);
    assertArrayEquals(new String[]{"America/Virgin", "Atlantic Standard Time", "AST", "Atlantic Daylight Time", "ADT",
        "Atlantic Time", "AT"}, zoneStrings[583]);
    assertArrayEquals(new String[]{"Asia/Famagusta", "Eastern European Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[589]);
    assertArrayEquals(new String[]{"Asia/Jerusalem", "Israel Standard Time", "IST", "Israel Daylight Time", "IDT",
        "Israel Time", "IT"}, zoneStrings[13]);
    assertArrayEquals(
        new String[]{"Asia/Shanghai", "China Standard Time", "CST", "China Daylight Time", "CDT", "China Time", "CT"},
        zoneStrings[Short.SIZE]);
    assertArrayEquals(new String[]{"Asia/Srednekolymsk", "Srednekolymsk Time", "SRET", "Srednekolymsk Daylight Time",
        "SREDT", "Srednekolymsk Time", "SRET"}, zoneStrings[598]);
    assertArrayEquals(
        new String[]{"Asia/Tokyo", "Japan Standard Time", "JST", "Japan Daylight Time", "JDT", "Japan Time", "JT"},
        zoneStrings[14]);
    assertArrayEquals(
        new String[]{"BET", "Brasilia Standard Time", "BRT", "Brasilia Summer Time", "BRST", "Brasilia Time", "BRT"},
        zoneStrings[22]);
    assertArrayEquals(new String[]{"BST", "Bangladesh Standard Time", "BDT", "Bangladesh Summer Time", "BDST",
        "Bangladesh Time", "BDT"}, zoneStrings[23]);
    assertArrayEquals(new String[]{"CAT", "Central Africa Time", "CAT", "Central African Summer Time", "CAST",
        "Central Africa Time", "CAT"}, zoneStrings[24]);
    assertArrayEquals(new String[]{"Canada/Saskatchewan", "Central Standard Time", "CST", "Central Daylight Time",
        "CDT", "Central Time", "CT"}, zoneStrings[596]);
    assertArrayEquals(new String[]{"EET", "Eastern European Time", "EET", "Eastern European Summer Time", "EEST",
        "Eastern European Time", "EET"}, zoneStrings[594]);
    assertArrayEquals(new String[]{"Egypt", "Eastern European Standard Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[597]);
    assertArrayEquals(new String[]{"Etc/Greenwich", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT",
        "Greenwich Mean Time", "GMT"}, zoneStrings[581]);
    assertArrayEquals(new String[]{"Europe/Astrakhan", "Astrakhan Standard Time", "GMT+04:00",
        "Astrakhan Standard Time", "GMT+04:00", "Astrakhan Time", "GMT+04:00"}, zoneStrings[580]);
    assertArrayEquals(new String[]{"Europe/Bucharest", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[15]);
    assertArrayEquals(new String[]{"Europe/Kyiv", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[585]);
    assertArrayEquals(new String[]{"Europe/Nicosia", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[600]);
    assertArrayEquals(new String[]{"Europe/Paris", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[11]);
    assertArrayEquals(new String[]{"Europe/Ulyanovsk", "Ulyanovsk Standard Time", "GMT+04:00",
        "Ulyanovsk Standard Time", "GMT+04:00", "Ulyanovsk Time", "GMT+04:00"}, zoneStrings[592]);
    assertArrayEquals(
        new String[]{"GMT", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT"},
        zoneStrings[12]);
    assertArrayEquals(new String[]{"Hongkong", "Hong Kong Standard Time", "HKT", "Hong Kong Summer Time", "HKST",
        "Hong Kong Time", "HKT"}, zoneStrings[586]);
    assertArrayEquals(
        new String[]{"Jamaica", "Eastern Standard Time", "EST", "Eastern Daylight Time", "EDT", "Eastern Time", "ET"},
        zoneStrings[578]);
    assertArrayEquals(
        new String[]{"Japan", "Japan Standard Time", "JST", "Japan Daylight Time", "JDT", "Japan Time", "JT"},
        zoneStrings[590]);
    assertArrayEquals(new String[]{"MST", "Mountain Standard Time", "MST", "Mountain Standard Time", "MST",
        "Mountain Standard Time", "MST"}, zoneStrings[584]);
    assertArrayEquals(new String[]{"Pacific/Honolulu", "Hawaii-Aleutian Standard Time", "HST",
        "Hawaii-Aleutian Daylight Time", "HDT", "Hawaii-Aleutian Time", "HST"}, zoneStrings[6]);
    assertArrayEquals(new String[]{"Turkey", "Turkey Time", "TRT", "Turkey Summer Time", "TRST", "Turkey Time", "TRT"},
        zoneStrings[577]);
    assertArrayEquals(new String[]{"UCT", "Coordinated Universal Time", "UTC", "Coordinated Universal Time", "UTC",
        "Coordinated Universal Time", "UTC"}, zoneStrings[587]);
    assertArrayEquals(new String[]{"US/Pacific", "Pacific Standard Time", "PST", "Pacific Daylight Time", "PDT",
        "Pacific Time", "PT"}, zoneStrings[601]);
    assertArrayEquals(new String[]{"UTC", "Coordinated Universal Time", "UTC", "Coordinated Universal Time", "UTC",
        "Coordinated Universal Time", "UTC"}, zoneStrings[17]);
    assertArrayEquals(
        new String[]{"W-SU", "Moscow Standard Time", "MSK", "Moscow Summer Time", "MSD", "Moscow Time", "MT"},
        zoneStrings[593]);
    assertArrayEquals(new String[]{"WET", "Western European Time", "WET", "Western European Summer Time", "WEST",
        "Western European Time", "WET"}, zoneStrings[579]);
    assertArrayEquals(new String[]{"", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"},
        dateFormatSymbols.getShortWeekdays());
    assertArrayEquals(new String[]{"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"},
        dateFormatSymbols.getWeekdays());
    assertArrayEquals(
        new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", ""},
        dateFormatSymbols.getShortMonths());
    assertArrayEquals(new String[]{"January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December", ""}, dateFormatSymbols.getMonths());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}
   */
  @Test
  public void testFilterOutCollectionMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    // Act and Assert
    assertTrue(basicPersistenceModule.filterOutCollectionMetadata(new HashMap<>()).isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}
   */
  @Test
  public void testFilterOutCollectionMetadata2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BasicPersistenceModule()).filterOutCollectionMetadata(null));
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}
   */
  @Test
  public void testFilterOutCollectionMetadata3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.put("foo", new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertTrue(basicPersistenceModule.filterOutCollectionMetadata(metadata).isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}
   */
  @Test
  public void testFilterOutCollectionMetadata4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));
    metadata.put("foo", new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertTrue(basicPersistenceModule.filterOutCollectionMetadata(metadata).isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}
   */
  @Test
  public void testFilterOutCollectionMetadata5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.put("foo", new BasicFieldMetadata());

    // Act and Assert
    assertEquals(metadata, basicPersistenceModule.filterOutCollectionMetadata(metadata));
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicBroadleafType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BasicPersistenceModule()).getBasicBroadleafType(SupportedFieldType.UNKNOWN));
    assertEquals("boolean", (new BasicPersistenceModule()).getBasicBroadleafType(SupportedFieldType.BOOLEAN).getName());
    assertEquals("int", (new BasicPersistenceModule()).getBasicBroadleafType(SupportedFieldType.INTEGER).getName());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicBroadleafType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualBasicBroadleafType = (new BasicPersistenceModule()).getBasicBroadleafType(SupportedFieldType.DATE);

    // Assert
    Class<Date> expectedBasicBroadleafType = Date.class;
    assertEquals(expectedBasicBroadleafType, actualBasicBroadleafType);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicBroadleafType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualBasicBroadleafType = (new BasicPersistenceModule())
        .getBasicBroadleafType(SupportedFieldType.DECIMAL);

    // Assert
    Class<BigDecimal> expectedBasicBroadleafType = BigDecimal.class;
    assertEquals(expectedBasicBroadleafType, actualBasicBroadleafType);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicBroadleafType4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualBasicBroadleafType = (new BasicPersistenceModule()).getBasicBroadleafType(SupportedFieldType.MONEY);

    // Assert
    Class<Money> expectedBasicBroadleafType = Money.class;
    assertEquals(expectedBasicBroadleafType, actualBasicBroadleafType);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicBroadleafType5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualBasicBroadleafType = (new BasicPersistenceModule()).getBasicBroadleafType(SupportedFieldType.ID);

    // Assert
    Class<String> expectedBasicBroadleafType = String.class;
    assertEquals(expectedBasicBroadleafType, actualBasicBroadleafType);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicBroadleafType6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));

    // Act and Assert
    assertNull(basicPersistenceModule.getBasicBroadleafType(SupportedFieldType.UNKNOWN));
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#createPopulatedInstance(Serializable, Entity, Map, Boolean)}
   */
  @Test
  public void testCreatePopulatedInstance() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    Entity entity = new Entity();

    HashMap<String, FieldMetadata> unfilteredProperties = new HashMap<>();
    unfilteredProperties.put("42", new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.createPopulatedInstance(instance, entity, unfilteredProperties, true));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#createPopulatedInstance(Serializable, Entity, Map, Boolean, Boolean)}
   */
  @Test
  public void testCreatePopulatedInstance2() throws ValidationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    Entity entity = new Entity();

    HashMap<String, FieldMetadata> unfilteredProperties = new HashMap<>();
    unfilteredProperties.put("42", new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.createPopulatedInstance(instance, entity, unfilteredProperties, true, true));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  public void testIsLate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    // Act and Assert
    assertFalse(basicPersistenceModule.isLate(new BasicFieldMetadata(), "Name"));
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  public void testIsLate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BasicPersistenceModule()).isLate(null, FieldManager.MAPFIELDSEPARATOR));
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  public void testIsLate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.UNKNOWN);
    metadata.setName(null);

    // Act and Assert
    assertFalse(basicPersistenceModule.isLate(metadata, FieldManager.MAPFIELDSEPARATOR));
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  public void testIsLate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.UNKNOWN);
    metadata.setName("Metadata");

    // Act and Assert
    assertTrue(basicPersistenceModule.isLate(metadata, FieldManager.MAPFIELDSEPARATOR));
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  public void testIsLate5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getName()).thenReturn("Name");
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    boolean actualIsLateResult = basicPersistenceModule.isLate(metadata, "Name");

    // Assert
    verify(metadata, atLeast(1)).getFieldType();
    verify(metadata).getName();
    assertFalse(actualIsLateResult);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecord(Class, PersistencePerspective, Serializable)}
   */
  @Test
  public void testGetRecord() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act
    Entity actualRecord = basicPersistenceModule.getRecord(ceilingEntityClass, persistencePerspective,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(dynamicEntityDaoImpl).getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    assertNull(actualRecord.getDeployDate());
    assertEquals(0, actualRecord.getProperties().length);
    assertFalse(actualRecord.getActive());
    assertFalse(actualRecord.getDeleted());
    assertFalse(actualRecord.getInactive());
    assertFalse(actualRecord.isDirty());
    assertFalse(actualRecord.isMultiPartAvailableOnThread());
    assertFalse(actualRecord.isPreAdd());
    assertTrue(actualRecord.getGlobalValidationErrors().isEmpty());
    assertTrue(actualRecord.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = actualRecord.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, actualRecord.getValidationErrors());
    assertArrayEquals(new String[]{"java.text.SimpleDateFormat"}, actualRecord.getType());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  public void testGetRecord2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act and Assert
    assertThrows(PersistenceException.class, () -> basicPersistenceModule.getRecord(primaryMergedProperties,
        resultRecord, new HashMap<>(), "Path To Target Object"));
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  public void testGetRecord3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act and Assert
    assertThrows(PersistenceException.class, () -> basicPersistenceModule.getRecord(primaryMergedProperties,
        resultRecord, new HashMap<>(), "Path To Target Object"));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  public void testGetRecord4() throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Field Value");
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Entity actualRecord = basicPersistenceModule.getRecord(primaryMergedProperties, resultRecord, new HashMap<>(),
        "Path To Target Object");

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    assertNull(actualRecord.getDeployDate());
    assertEquals(0, actualRecord.getProperties().length);
    assertFalse(actualRecord.getActive());
    assertFalse(actualRecord.getDeleted());
    assertFalse(actualRecord.getInactive());
    assertFalse(actualRecord.isDirty());
    assertFalse(actualRecord.isMultiPartAvailableOnThread());
    assertFalse(actualRecord.isPreAdd());
    assertTrue(actualRecord.getGlobalValidationErrors().isEmpty());
    assertTrue(actualRecord.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = actualRecord.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, actualRecord.getValidationErrors());
    assertArrayEquals(new String[]{"java.lang.String"}, actualRecord.getType());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  public void testGetRecord5() throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setFriendlyGroup(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setFriendlyName(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setFriendlyTab(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setId(1L);
    systemPropertyImpl.setName(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl.setPropertyType(new SystemPropertyFieldType(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY,
        BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY));
    systemPropertyImpl.setValue("42");
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(systemPropertyImpl);
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Entity actualRecord = basicPersistenceModule.getRecord(primaryMergedProperties, resultRecord, new HashMap<>(),
        "Path To Target Object");

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    Map<String, Property> pMap = actualRecord.getPMap();
    assertEquals(2, pMap.size());
    Property getResult = pMap.get("__adminMainEntity");
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    Property getResult2 = pMap.get(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    FieldMetadata metadata2 = getResult2.getMetadata();
    assertTrue(metadata2 instanceof BasicFieldMetadata);
    assertEquals("__adminMainEntity", getResult.getName());
    assertNull(((BasicFieldMetadata) metadata2).getCustomCriteria());
    assertNull(metadata2.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata2).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata2).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata2).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata2).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata2).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata2).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata2).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata2).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata2).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata2).getMutable());
    assertNull(((BasicFieldMetadata) metadata2).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata2).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata2).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata2).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata2).getSearchable());
    assertNull(((BasicFieldMetadata) metadata2).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata2).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata2).getUnique());
    assertNull(((BasicFieldMetadata) metadata2).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata2).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata2).isProminent());
    assertNull(metadata2.getChildrenExcluded());
    assertNull(metadata2.getExcluded());
    assertNull(metadata2.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata2).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata2).getLength());
    assertNull(((BasicFieldMetadata) metadata2).getPrecision());
    assertNull(((BasicFieldMetadata) metadata2).getScale());
    assertNull(metadata2.getGroupOrder());
    assertNull(metadata2.getOrder());
    assertNull(metadata2.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata2).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata2).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata2).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata2).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata2).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata2).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata2).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata2).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata2).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata2).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata2).getHelpText());
    assertNull(((BasicFieldMetadata) metadata2).getHint());
    assertNull(((BasicFieldMetadata) metadata2).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata2).getManyToField());
    assertNull(((BasicFieldMetadata) metadata2).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata2).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata2).getName());
    assertNull(((BasicFieldMetadata) metadata2).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata2).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata2).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata2).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata2).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata2).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata2).getTooltip());
    assertNull(metadata2.getAddFriendlyName());
    assertNull(metadata2.getCurrencyCodeField());
    assertNull(metadata2.getFieldName());
    assertNull(metadata2.getFriendlyName());
    assertNull(metadata2.getGroup());
    assertNull(metadata2.getInheritedFromType());
    assertNull(metadata2.getOwningClass());
    assertNull(metadata2.getOwningClassFriendlyName());
    assertNull(metadata2.getPrefix());
    assertNull(metadata2.getSecurityLevel());
    assertNull(metadata2.getShowIfProperty());
    assertNull(metadata2.getTab());
    assertNull(metadata2.getTargetClass());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult2.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult2.getOriginalValue());
    assertNull(actualRecord.getDeployDate());
    assertNull(getResult.getDeployDate());
    assertNull(getResult2.getDeployDate());
    assertNull(metadata2.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata2).getLookupType());
    assertNull(((BasicFieldMetadata) metadata2).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata2).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata2).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata2).getFieldType());
    assertNull(((BasicFieldMetadata) metadata2).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata2).getVisibility());
    assertNull(((BasicFieldMetadata) metadata2).getMergedPropertyType());
    Property[] properties = actualRecord.getProperties();
    assertEquals(2, properties.length);
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata2).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata2).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata2).getRequired());
    assertFalse(actualRecord.getActive());
    assertFalse(actualRecord.getDeleted());
    assertFalse(actualRecord.getInactive());
    assertFalse(actualRecord.isDirty());
    assertFalse(actualRecord.isMultiPartAvailableOnThread());
    assertFalse(actualRecord.isPreAdd());
    assertFalse(metadata2.getManualFetch());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult2.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertFalse(getResult2.isAdvancedCollection());
    assertTrue(actualRecord.getGlobalValidationErrors().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata2).getValidationConfigurations().isEmpty());
    Map<String, List<String>> propertyValidationErrors = actualRecord.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertTrue(metadata2.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata2).getAllowNoValueEnumOption());
    assertTrue(getResult.getEnabled());
    assertTrue(getResult2.getEnabled());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getName());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult.getRawValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getRawValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult.getUnHtmlEncodedValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getUnHtmlEncodedValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult.getValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getValue());
    assertEquals(metadata2, metadata);
    assertSame(getResult, properties[0]);
    assertSame(getResult2, properties[1]);
    assertSame(propertyValidationErrors, actualRecord.getValidationErrors());
    assertArrayEquals(new String[]{"org.broadleafcommerce.common.config.domain.SystemPropertyImpl"},
        actualRecord.getType());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  public void testGetRecord6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(mock(FieldManager.class));
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Entity actualRecord = basicPersistenceModule.getRecord(primaryMergedProperties, resultRecord, new HashMap<>(),
        null);

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    assertNull(actualRecord.getDeployDate());
    assertEquals(0, actualRecord.getProperties().length);
    assertFalse(actualRecord.getActive());
    assertFalse(actualRecord.getDeleted());
    assertFalse(actualRecord.getInactive());
    assertFalse(actualRecord.isDirty());
    assertFalse(actualRecord.isMultiPartAvailableOnThread());
    assertFalse(actualRecord.isPreAdd());
    assertTrue(actualRecord.getGlobalValidationErrors().isEmpty());
    assertTrue(actualRecord.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = actualRecord.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, actualRecord.getValidationErrors());
    assertArrayEquals(new String[]{"java.text.SimpleDateFormat"}, actualRecord.getType());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)}
   */
  @Test
  public void testGetRecords() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(ceilingEntityClass, persistencePerspective,
        new ArrayList<>());

    // Assert
    verify(dynamicEntityDaoImpl).getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager).getDynamicEntityDao();
    assertEquals(0, actualRecords.length);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)}
   */
  @Test
  public void testGetRecords2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", new AdornedTargetCollectionMetadata());
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(ceilingEntityClass, persistencePerspective,
        new ArrayList<>());

    // Assert
    verify(dynamicEntityDaoImpl).getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager).getDynamicEntityDao();
    assertEquals(0, actualRecords.length);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)}
   */
  @Test
  public void testGetRecords3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(ceilingEntityClass, persistencePerspective, records);

    // Assert
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(dynamicEntityDaoImpl).getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    Entity entity = actualRecords[0];
    assertNull(entity.getDeployDate());
    assertEquals(0, entity.getProperties().length);
    assertEquals(1, actualRecords.length);
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(entity.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
    assertArrayEquals(new String[]{"java.text.SimpleDateFormat"}, entity.getType());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)}
   */
  @Test
  public void testGetRecords4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.getRecords(ceilingEntityClass, persistencePerspective, records));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(dynamicEntityDaoImpl).getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)}
   */
  @Test
  public void testGetRecords5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.getRecords(ceilingEntityClass, persistencePerspective, records));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(dynamicEntityDaoImpl).getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  public void testGetRecords6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryMergedProperties, new ArrayList<>()).length);
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  public void testGetRecords7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    primaryMergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryMergedProperties, new ArrayList<>()).length);
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  public void testGetRecords8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    primaryMergedProperties.computeIfPresent("foo", mock(BiFunction.class));
    primaryMergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryMergedProperties, new ArrayList<>()).length);
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  public void testGetRecords9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    primaryMergedProperties.put("foo", new BasicFieldMetadata());

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryMergedProperties, new ArrayList<>()).length);
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  public void testGetRecords10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryMergedProperties, records);

    // Assert
    verify(persistenceManager).getDynamicEntityDao();
    Entity entity = actualRecords[0];
    assertNull(entity.getDeployDate());
    assertEquals(0, entity.getProperties().length);
    assertEquals(1, actualRecords.length);
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(entity.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
    assertArrayEquals(new String[]{"java.text.SimpleDateFormat"}, entity.getType());
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  public void testGetRecords11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryMergedProperties, records);

    // Assert
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
    Entity entity = actualRecords[0];
    assertNull(entity.getDeployDate());
    assertEquals(0, entity.getProperties().length);
    assertEquals(1, actualRecords.length);
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(entity.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
    assertArrayEquals(new String[]{"java.text.SimpleDateFormat"}, entity.getType());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecords12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object").length);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecords13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    primaryUnfilteredMergedProperties.put("foo", new AdornedTargetCollectionMetadata());
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object").length);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecords14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    primaryUnfilteredMergedProperties.computeIfPresent("foo", mock(BiFunction.class));
    primaryUnfilteredMergedProperties.put("foo", new AdornedTargetCollectionMetadata());
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object").length);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecords15() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    primaryUnfilteredMergedProperties.put("foo", new BasicFieldMetadata());
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object").length);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecords16() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act and Assert
    assertThrows(PersistenceException.class, () -> basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties,
        records, new HashMap<>(), "Path To Target Object"));
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecords17() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act and Assert
    assertThrows(PersistenceException.class, () -> basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties,
        records, new HashMap<>(), "Path To Target Object"));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecords18() throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Field Value");
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records,
        new HashMap<>(), "Path To Target Object");

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    Entity entity = actualRecords[0];
    assertNull(entity.getDeployDate());
    assertEquals(0, entity.getProperties().length);
    assertEquals(1, actualRecords.length);
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(entity.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
    assertArrayEquals(new String[]{"java.lang.String"}, entity.getType());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecords19() throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setFriendlyGroup(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setFriendlyName(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setFriendlyTab(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setId(1L);
    systemPropertyImpl.setName(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl.setPropertyType(new SystemPropertyFieldType(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY,
        BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY));
    systemPropertyImpl.setValue("42");
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(systemPropertyImpl);
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records,
        new HashMap<>(), "Path To Target Object");

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    Entity entity = actualRecords[0];
    Map<String, Property> pMap = entity.getPMap();
    assertEquals(2, pMap.size());
    Property getResult = pMap.get("__adminMainEntity");
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    Property getResult2 = pMap.get(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    FieldMetadata metadata2 = getResult2.getMetadata();
    assertTrue(metadata2 instanceof BasicFieldMetadata);
    assertEquals("__adminMainEntity", getResult.getName());
    assertNull(((BasicFieldMetadata) metadata2).getCustomCriteria());
    assertNull(metadata2.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata2).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata2).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata2).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata2).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata2).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata2).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata2).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata2).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata2).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata2).getMutable());
    assertNull(((BasicFieldMetadata) metadata2).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata2).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata2).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata2).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata2).getSearchable());
    assertNull(((BasicFieldMetadata) metadata2).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata2).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata2).getUnique());
    assertNull(((BasicFieldMetadata) metadata2).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata2).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata2).isProminent());
    assertNull(metadata2.getChildrenExcluded());
    assertNull(metadata2.getExcluded());
    assertNull(metadata2.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata2).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata2).getLength());
    assertNull(((BasicFieldMetadata) metadata2).getPrecision());
    assertNull(((BasicFieldMetadata) metadata2).getScale());
    assertNull(metadata2.getGroupOrder());
    assertNull(metadata2.getOrder());
    assertNull(metadata2.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata2).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata2).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata2).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata2).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata2).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata2).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata2).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata2).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata2).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata2).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata2).getHelpText());
    assertNull(((BasicFieldMetadata) metadata2).getHint());
    assertNull(((BasicFieldMetadata) metadata2).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata2).getManyToField());
    assertNull(((BasicFieldMetadata) metadata2).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata2).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata2).getName());
    assertNull(((BasicFieldMetadata) metadata2).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata2).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata2).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata2).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata2).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata2).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata2).getTooltip());
    assertNull(metadata2.getAddFriendlyName());
    assertNull(metadata2.getCurrencyCodeField());
    assertNull(metadata2.getFieldName());
    assertNull(metadata2.getFriendlyName());
    assertNull(metadata2.getGroup());
    assertNull(metadata2.getInheritedFromType());
    assertNull(metadata2.getOwningClass());
    assertNull(metadata2.getOwningClassFriendlyName());
    assertNull(metadata2.getPrefix());
    assertNull(metadata2.getSecurityLevel());
    assertNull(metadata2.getShowIfProperty());
    assertNull(metadata2.getTab());
    assertNull(metadata2.getTargetClass());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult2.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult2.getOriginalValue());
    assertNull(entity.getDeployDate());
    assertNull(getResult.getDeployDate());
    assertNull(getResult2.getDeployDate());
    assertNull(metadata2.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata2).getLookupType());
    assertNull(((BasicFieldMetadata) metadata2).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata2).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata2).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata2).getFieldType());
    assertNull(((BasicFieldMetadata) metadata2).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata2).getVisibility());
    assertNull(((BasicFieldMetadata) metadata2).getMergedPropertyType());
    assertEquals(1, actualRecords.length);
    Property[] properties = entity.getProperties();
    assertEquals(2, properties.length);
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata2).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata2).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata2).getRequired());
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertFalse(metadata2.getManualFetch());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult2.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertFalse(getResult2.isAdvancedCollection());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata2).getValidationConfigurations().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertTrue(metadata2.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata2).getAllowNoValueEnumOption());
    assertTrue(getResult.getEnabled());
    assertTrue(getResult2.getEnabled());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getName());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult.getRawValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getRawValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult.getUnHtmlEncodedValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getUnHtmlEncodedValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult.getValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getValue());
    assertEquals(metadata2, metadata);
    assertSame(getResult, properties[0]);
    assertSame(getResult2, properties[1]);
    assertSame(propertyValidationErrors, entity.getValidationErrors());
    assertArrayEquals(new String[]{"org.broadleafcommerce.common.config.domain.SystemPropertyImpl"}, entity.getType());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  public void testGetRecords20() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(mock(FieldManager.class));
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records,
        new HashMap<>(), null);

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    Entity entity = actualRecords[0];
    assertNull(entity.getDeployDate());
    assertEquals(0, entity.getProperties().length);
    assertEquals(1, actualRecords.length);
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(entity.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
    assertArrayEquals(new String[]{"java.text.SimpleDateFormat"}, entity.getType());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecords21() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object", new String[]{"Custom Criteria"}).length);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecords22() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    primaryUnfilteredMergedProperties.put("ProductList", new AdornedTargetCollectionMetadata());
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object", new String[]{"Custom Criteria"}).length);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecords23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    primaryUnfilteredMergedProperties.computeIfPresent("ProductList", mock(BiFunction.class));
    primaryUnfilteredMergedProperties.put("ProductList", new AdornedTargetCollectionMetadata());
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object", new String[]{"Custom Criteria"}).length);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecords24() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object", new String[]{"ProductList"}).length);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecords25() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object", null).length);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecords26() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    primaryUnfilteredMergedProperties.put("ProductList", new BasicFieldMetadata());
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(0, basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records, new HashMap<>(),
        "Path To Target Object", new String[]{"Custom Criteria"}).length);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecords27() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act and Assert
    assertThrows(PersistenceException.class, () -> basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties,
        records, new HashMap<>(), "Path To Target Object", new String[]{"Custom Criteria"}));
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecords28() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act and Assert
    assertThrows(PersistenceException.class, () -> basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties,
        records, new HashMap<>(), "Path To Target Object", new String[]{"Custom Criteria"}));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecords29() throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Field Value");
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records,
        new HashMap<>(), "Path To Target Object", new String[]{"Custom Criteria"});

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    Entity entity = actualRecords[0];
    assertNull(entity.getDeployDate());
    assertEquals(0, entity.getProperties().length);
    assertEquals(1, actualRecords.length);
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(entity.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
    assertArrayEquals(new String[]{"java.lang.String"}, entity.getType());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecords30() throws IllegalAccessException, FieldNotAvailableException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setFriendlyGroup("ProductList");
    systemPropertyImpl.setFriendlyName("ProductList");
    systemPropertyImpl.setFriendlyTab("ProductList");
    systemPropertyImpl.setId(1L);
    systemPropertyImpl.setName("ProductList");
    systemPropertyImpl.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl.setPropertyType(new SystemPropertyFieldType("ProductList", "ProductList"));
    systemPropertyImpl.setValue("42");
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(systemPropertyImpl);
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records,
        new HashMap<>(), "Path To Target Object", new String[]{"Custom Criteria"});

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    Entity entity = actualRecords[0];
    Map<String, Property> pMap = entity.getPMap();
    assertEquals(2, pMap.size());
    Property getResult = pMap.get("__adminMainEntity");
    FieldMetadata metadata = getResult.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    Property getResult2 = pMap.get(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    FieldMetadata metadata2 = getResult2.getMetadata();
    assertTrue(metadata2 instanceof BasicFieldMetadata);
    assertEquals("ProductList", getResult.getRawValue());
    assertEquals("ProductList", getResult2.getRawValue());
    assertEquals("ProductList", getResult.getUnHtmlEncodedValue());
    assertEquals("ProductList", getResult2.getUnHtmlEncodedValue());
    assertEquals("ProductList", getResult.getValue());
    assertEquals("ProductList", getResult2.getValue());
    assertEquals("__adminMainEntity", getResult.getName());
    assertNull(((BasicFieldMetadata) metadata2).getCustomCriteria());
    assertNull(metadata2.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata2).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata2).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata2).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata2).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata2).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata2).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata2).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata2).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata2).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata2).getMutable());
    assertNull(((BasicFieldMetadata) metadata2).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata2).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata2).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata2).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata2).getSearchable());
    assertNull(((BasicFieldMetadata) metadata2).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata2).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata2).getUnique());
    assertNull(((BasicFieldMetadata) metadata2).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata2).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata2).isProminent());
    assertNull(metadata2.getChildrenExcluded());
    assertNull(metadata2.getExcluded());
    assertNull(metadata2.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata2).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata2).getLength());
    assertNull(((BasicFieldMetadata) metadata2).getPrecision());
    assertNull(((BasicFieldMetadata) metadata2).getScale());
    assertNull(metadata2.getGroupOrder());
    assertNull(metadata2.getOrder());
    assertNull(metadata2.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata2).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata2).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata2).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata2).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata2).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata2).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata2).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata2).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata2).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata2).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata2).getHelpText());
    assertNull(((BasicFieldMetadata) metadata2).getHint());
    assertNull(((BasicFieldMetadata) metadata2).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata2).getManyToField());
    assertNull(((BasicFieldMetadata) metadata2).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata2).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata2).getName());
    assertNull(((BasicFieldMetadata) metadata2).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata2).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata2).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata2).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata2).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata2).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata2).getTooltip());
    assertNull(metadata2.getAddFriendlyName());
    assertNull(metadata2.getCurrencyCodeField());
    assertNull(metadata2.getFieldName());
    assertNull(metadata2.getFriendlyName());
    assertNull(metadata2.getGroup());
    assertNull(metadata2.getInheritedFromType());
    assertNull(metadata2.getOwningClass());
    assertNull(metadata2.getOwningClassFriendlyName());
    assertNull(metadata2.getPrefix());
    assertNull(metadata2.getSecurityLevel());
    assertNull(metadata2.getShowIfProperty());
    assertNull(metadata2.getTab());
    assertNull(metadata2.getTargetClass());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult2.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult2.getOriginalValue());
    assertNull(entity.getDeployDate());
    assertNull(getResult.getDeployDate());
    assertNull(getResult2.getDeployDate());
    assertNull(metadata2.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata2).getLookupType());
    assertNull(((BasicFieldMetadata) metadata2).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata2).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata2).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata2).getFieldType());
    assertNull(((BasicFieldMetadata) metadata2).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata2).getVisibility());
    assertNull(((BasicFieldMetadata) metadata2).getMergedPropertyType());
    assertEquals(1, actualRecords.length);
    Property[] properties = entity.getProperties();
    assertEquals(2, properties.length);
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata2).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata2).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata2).getRequired());
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertFalse(metadata2.getManualFetch());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult2.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertFalse(getResult2.isAdvancedCollection());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata2).getValidationConfigurations().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertTrue(metadata2.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata2).getAllowNoValueEnumOption());
    assertTrue(getResult.getEnabled());
    assertTrue(getResult2.getEnabled());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getName());
    assertEquals(metadata2, metadata);
    assertSame(getResult, properties[0]);
    assertSame(getResult2, properties[1]);
    assertSame(propertyValidationErrors, entity.getValidationErrors());
    assertArrayEquals(new String[]{"org.broadleafcommerce.common.config.domain.SystemPropertyImpl"}, entity.getType());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])}
   */
  @Test
  public void testGetRecords31() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(mock(FieldManager.class));
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryUnfilteredMergedProperties, records,
        new HashMap<>(), null, new String[]{"Custom Criteria"});

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    Entity entity = actualRecords[0];
    assertNull(entity.getDeployDate());
    assertEquals(0, entity.getProperties().length);
    assertEquals(1, actualRecords.length);
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(entity.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
    assertArrayEquals(new String[]{"java.text.SimpleDateFormat"}, entity.getType());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getSimpleMergedProperties(String, PersistencePerspective)}
   */
  @Test
  public void testGetSimpleMergedProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    Map<String, FieldMetadata> actualSimpleMergedProperties = basicPersistenceModule
        .getSimpleMergedProperties("Entity Name", new PersistencePerspective());

    // Assert
    verify(dynamicEntityDaoImpl).getSimpleMergedProperties(eq("Entity Name"), isA(PersistencePerspective.class));
    verify(persistenceManager).getDynamicEntityDao();
    assertTrue(actualSimpleMergedProperties.isEmpty());
    assertSame(stringFieldMetadataMap, actualSimpleMergedProperties);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromPersistentEntity(Map, Serializable, List, String[])}
   */
  @Test
  public void testExtractPropertiesFromPersistentEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    SimpleDateFormat entity = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    basicPersistenceModule.extractPropertiesFromPersistentEntity(mergedProperties, entity, new ArrayList<>(),
        new String[]{"Custom Criteria"});

    // Assert
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromPersistentEntity(Map, Serializable, List, String[])}
   */
  @Test
  public void testExtractPropertiesFromPersistentEntity2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(new FieldManager(new EntityConfiguration(), null));
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    SimpleDateFormat entity = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    basicPersistenceModule.extractPropertiesFromPersistentEntity(mergedProperties, entity, new ArrayList<>(),
        new String[]{"Custom Criteria"});

    // Assert
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromPersistentEntity(Map, Serializable, List, String[])}
   */
  @Test
  public void testExtractPropertiesFromPersistentEntity3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    SimpleDateFormat entity = new SimpleDateFormat("yyyy/mm/dd");

    ArrayList<Property> props = new ArrayList<>();
    props.add(new Property());

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class, () -> basicPersistenceModule
        .extractPropertiesFromPersistentEntity(mergedProperties, entity, props, new String[]{"Custom Criteria"}));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getStringValueFromGetter(Serializable, String)}
   */
  @Test
  public void testGetStringValueFromGetter()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    // Act and Assert
    assertNull(basicPersistenceModule.getStringValueFromGetter(new HashMap<>(), "Property Name"));
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getStringValueFromGetter(Serializable, String)}
   */
  @Test
  public void testGetStringValueFromGetter2()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<Object, Object> instance = new HashMap<>();
    instance.put("", "42");

    // Act and Assert
    assertEquals("42", basicPersistenceModule.getStringValueFromGetter(instance, ""));
  }

  /**
   * Method under test: {@link BasicPersistenceModule#formatValue(Object)}
   */
  @Test
  public void testFormatValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Value", (new BasicPersistenceModule()).formatValue("Value"));
    assertNull((new BasicPersistenceModule()).formatValue(null));
  }

  /**
   * Method under test: {@link BasicPersistenceModule#formatValue(Object)}
   */
  @Test
  public void testFormatValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));

    // Act and Assert
    assertEquals("Value", basicPersistenceModule.formatValue("Value"));
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getIdPropertyName(String)}
   */
  @Test
  public void testGetIdPropertyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getIdPropertyName(Mockito.<String>any())).thenReturn("Id Property Name");

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    String actualIdPropertyName = basicPersistenceModule.getIdPropertyName("Entity Class");

    // Assert
    verify(persistenceManager).getIdPropertyName(eq("Entity Class"));
    assertEquals("Id Property Name", actualIdPropertyName);
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  public void testGetIdPropertyName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> basicPersistenceModule.getIdPropertyName(new HashMap<>()));
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  public void testGetIdPropertyName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed merged properties list",
        new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> basicPersistenceModule.getIdPropertyName(mergedUnfilteredProperties));
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  public void testGetIdPropertyName4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.computeIfPresent(
        "Could not find a primary key property in the passed merged properties list", mock(BiFunction.class));
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed merged properties list",
        new BasicFieldMetadata());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> basicPersistenceModule.getIdPropertyName(mergedUnfilteredProperties));
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  public void testGetIdPropertyName5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.computeIfPresent(
        "Could not find a primary key property in the passed merged properties list", mock(BiFunction.class));
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed merged properties list",
        basicFieldMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> basicPersistenceModule.getIdPropertyName(mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  public void testGetIdPropertyName6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.computeIfPresent(
        "Could not find a primary key property in the passed merged properties list", mock(BiFunction.class));
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed merged properties list",
        basicFieldMetadata);

    // Act
    String actualIdPropertyName = basicPersistenceModule.getIdPropertyName(mergedUnfilteredProperties);

    // Assert
    verify(basicFieldMetadata).getFieldType();
    assertEquals("Could not find a primary key property in the passed merged properties list", actualIdPropertyName);
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  public void testGetIdPropertyName7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenThrow(new ParentEntityPersistenceException("An error occurred"));

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.computeIfPresent(
        "Could not find a primary key property in the passed merged properties list", mock(BiFunction.class));
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed merged properties list",
        basicFieldMetadata);

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.getIdPropertyName(mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  public void testGetIdPropertyName8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.computeIfPresent(
        "Could not find a primary key property in the passed merged properties list", mock(BiFunction.class));
    mergedUnfilteredProperties.put(".", basicFieldMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> basicPersistenceModule.getIdPropertyName(mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  public void testGetPrimaryKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> basicPersistenceModule.getPrimaryKey(entity, new HashMap<>()));
    verify(entity).getType();
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  public void testGetPrimaryKey2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed entity with type: ",
        new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(entity).getType();
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  public void testGetPrimaryKey3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed entity with type: ",
        new BasicFieldMetadata());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(entity).getType();
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  public void testGetPrimaryKey4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed entity with type: ",
        basicFieldMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
    verify(entity).getType();
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  public void testGetPrimaryKey5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property(".", "42")});
    when(entity.getType()).thenReturn(new String[]{"Type"});
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed entity with type: ",
        basicFieldMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
    verify(entity).getProperties();
    verify(entity).getType();
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  public void testGetPrimaryKey6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});
    when(entity.getType()).thenReturn(new String[]{"Type"});
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed entity with type: ",
        basicFieldMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
    verify(entity).getProperties();
    verify(entity).getType();
    verify(property).getName();
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  public void testGetPrimaryKey7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Could not find a primary key property in the passed entity with type: ");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});
    when(entity.getType()).thenReturn(new String[]{"Type"});
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getSecondaryType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed entity with type: ",
        basicFieldMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
    verify(basicFieldMetadata).getSecondaryType();
    verify(entity).getProperties();
    verify(entity).getType();
    verify(property).getName();
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  public void testGetPrimaryKey8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put(".", basicFieldMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
    verify(entity).getType();
  }

  /**
   * Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  public void testGetPrimaryKey9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Could not find a primary key property in the passed entity with type: ");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getSecondaryType()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("Could not find a primary key property in the passed entity with type: ",
        basicFieldMetadata);

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
    verify(basicFieldMetadata).getSecondaryType();
    verify(entity).getProperties();
    verify(property).getName();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)}
   */
  @Test
  public void testGetFilterMappings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act and Assert
    assertTrue(basicPersistenceModule.getFilterMappings(persistencePerspective, cto, "Dr Jane Doe", new HashMap<>())
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)}
   */
  @Test
  public void testGetFilterMappings2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act and Assert
    assertTrue(basicPersistenceModule.getFilterMappings(persistencePerspective, cto, "Dr Jane Doe", new HashMap<>())
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)}
   */
  @Test
  public void testGetFilterMappings3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());

    // Act
    List<FilterMapping> actualFilterMappings = basicPersistenceModule.getFilterMappings(persistencePerspective, cto,
        "Dr Jane Doe", new HashMap<>());

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)}
   */
  @Test
  public void testGetFilterMappings4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    HashMap<String, FilterAndSortCriteria> stringFilterAndSortCriteriaMap = new HashMap<>();
    stringFilterAndSortCriteriaMap.put("foo", new FilterAndSortCriteria("42"));
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(stringFilterAndSortCriteriaMap);

    // Act
    List<FilterMapping> actualFilterMappings = basicPersistenceModule.getFilterMappings(persistencePerspective, cto,
        "Dr Jane Doe", new HashMap<>());

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)}
   */
  @Test
  public void testGetFilterMappings5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    List<FilterMapping> actualFilterMappings = basicPersistenceModule.getFilterMappings(persistencePerspective, cto,
        "Dr Jane Doe", mergedUnfilteredProperties);

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)}
   */
  @Test
  public void testGetFilterMappings6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act and Assert
    assertTrue(basicPersistenceModule
        .getFilterMappings(persistencePerspective, cto, "Dr Jane Doe", new HashMap<>(), mock(RestrictionFactory.class))
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)}
   */
  @Test
  public void testGetFilterMappings7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());

    // Act
    List<FilterMapping> actualFilterMappings = basicPersistenceModule.getFilterMappings(persistencePerspective, cto,
        "Dr Jane Doe", new HashMap<>(), mock(RestrictionFactory.class));

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)}
   */
  @Test
  public void testGetFilterMappings8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    HashMap<String, FilterAndSortCriteria> stringFilterAndSortCriteriaMap = new HashMap<>();
    stringFilterAndSortCriteriaMap.put("foo", new FilterAndSortCriteria("42"));
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(stringFilterAndSortCriteriaMap);

    // Act
    List<FilterMapping> actualFilterMappings = basicPersistenceModule.getFilterMappings(persistencePerspective, cto,
        "Dr Jane Doe", new HashMap<>(), mock(RestrictionFactory.class));

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)}
   */
  @Test
  public void testGetFilterMappings9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    List<FilterMapping> actualFilterMappings = basicPersistenceModule.getFilterMappings(persistencePerspective, cto,
        "Dr Jane Doe", mergedUnfilteredProperties, mock(RestrictionFactory.class));

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.PRIMARY, new HashMap<>());
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertTrue(properties.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.computeIfPresent(MergedPropertyType.PRIMARY, mock(BiFunction.class));
    mergedProperties.put(MergedPropertyType.PRIMARY, new HashMap<>());
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertTrue(properties.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.PRIMARY, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(1, properties.size());
    Property getResult = properties.get(0);
    assertEquals("foo", getResult.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("42", adornedTargetCollectionMetadata);
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata2);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.PRIMARY, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(2, properties.size());
    Property getResult = properties.get(0);
    assertEquals("42", getResult.getName());
    Property getResult2 = properties.get(1);
    assertEquals("foo", getResult2.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult2.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult2.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult2.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult2.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult2.getValue());
    assertNull(getResult.getDeployDate());
    assertNull(getResult2.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult2.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertFalse(getResult2.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
    assertTrue(getResult2.getEnabled());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
    assertSame(adornedTargetCollectionMetadata2, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  public void testExtractProperties5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("", adornedTargetCollectionMetadata);
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("42", adornedTargetCollectionMetadata2);
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata3 = new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata3);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.PRIMARY, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractProperties(new Class[]{forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(3, properties.size());
    Property getResult = properties.get(0);
    assertEquals("", getResult.getName());
    Property getResult2 = properties.get(1);
    assertEquals("42", getResult2.getName());
    Property getResult3 = properties.get(2);
    assertEquals("foo", getResult3.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult3.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult2.getOriginalDisplayValue());
    assertNull(getResult3.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult2.getOriginalValue());
    assertNull(getResult3.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult2.getRawValue());
    assertNull(getResult3.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult2.getUnHtmlEncodedValue());
    assertNull(getResult3.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult2.getValue());
    assertNull(getResult3.getValue());
    assertNull(getResult.getDeployDate());
    assertNull(getResult2.getDeployDate());
    assertNull(getResult3.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult2.getIsDirty());
    assertFalse(getResult3.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertFalse(getResult2.isAdvancedCollection());
    assertFalse(getResult3.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
    assertTrue(getResult2.getEnabled());
    assertTrue(getResult3.getEnabled());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
    assertSame(adornedTargetCollectionMetadata2, getResult2.getMetadata());
    assertSame(adornedTargetCollectionMetadata3, getResult3.getMetadata());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  public void testExtractPropertiesFromMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties, properties, true,
        MergedPropertyType.PRIMARY);

    // Assert
    assertTrue(properties.isEmpty());
    assertTrue(mergedProperties.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  public void testExtractPropertiesFromMetadata2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    mergedProperties.put("foo", adornedTargetCollectionMetadata);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties, properties, true,
        MergedPropertyType.PRIMARY);

    // Assert
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("foo");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertEquals(1, properties.size());
    Property getResult2 = properties.get(0);
    assertEquals("foo", getResult2.getName());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult2.getOriginalDisplayValue());
    assertNull(getResult2.getOriginalValue());
    assertNull(getResult2.getRawValue());
    assertNull(getResult2.getUnHtmlEncodedValue());
    assertNull(getResult2.getValue());
    assertNull(getResult2.getDeployDate());
    assertFalse(getResult2.getIsDirty());
    assertFalse(getResult2.isAdvancedCollection());
    assertTrue(getResult2.getEnabled());
    assertSame(adornedTargetCollectionMetadata, getResult);
    assertSame(adornedTargetCollectionMetadata, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  public void testExtractPropertiesFromMetadata3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    mergedProperties.put("42", adornedTargetCollectionMetadata);
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 = new AdornedTargetCollectionMetadata();
    mergedProperties.put("foo", adornedTargetCollectionMetadata2);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties, properties, true,
        MergedPropertyType.PRIMARY);

    // Assert
    assertEquals(2, properties.size());
    Property getResult = properties.get(0);
    assertEquals("42", getResult.getName());
    Property getResult2 = properties.get(1);
    assertEquals("foo", getResult2.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult2.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult2.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult2.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult2.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult2.getValue());
    assertNull(getResult.getDeployDate());
    assertNull(getResult2.getDeployDate());
    assertEquals(2, mergedProperties.size());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult2.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertFalse(getResult2.isAdvancedCollection());
    assertTrue(mergedProperties.containsKey("42"));
    assertTrue(getResult.getEnabled());
    assertTrue(getResult2.getEnabled());
    assertSame(adornedTargetCollectionMetadata2, mergedProperties.get("foo"));
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
    assertSame(adornedTargetCollectionMetadata2, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  public void testExtractPropertiesFromMetadata4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.computeIfPresent("foo", mock(BiFunction.class));
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    mergedProperties.put("foo", adornedTargetCollectionMetadata);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties, properties, true,
        MergedPropertyType.PRIMARY);

    // Assert
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("foo");
    assertTrue(getResult instanceof AdornedTargetCollectionMetadata);
    assertEquals(1, properties.size());
    Property getResult2 = properties.get(0);
    assertEquals("foo", getResult2.getName());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult2.getOriginalDisplayValue());
    assertNull(getResult2.getOriginalValue());
    assertNull(getResult2.getRawValue());
    assertNull(getResult2.getUnHtmlEncodedValue());
    assertNull(getResult2.getValue());
    assertNull(getResult2.getDeployDate());
    assertFalse(getResult2.getIsDirty());
    assertFalse(getResult2.isAdvancedCollection());
    assertTrue(getResult2.getEnabled());
    assertSame(adornedTargetCollectionMetadata, getResult);
    assertSame(adornedTargetCollectionMetadata, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  public void testExtractPropertiesFromMetadata5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    mergedProperties.put("", adornedTargetCollectionMetadata);
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 = new AdornedTargetCollectionMetadata();
    mergedProperties.put("42", adornedTargetCollectionMetadata2);
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata3 = new AdornedTargetCollectionMetadata();
    mergedProperties.put("foo", adornedTargetCollectionMetadata3);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties, properties, true,
        MergedPropertyType.PRIMARY);

    // Assert
    assertEquals(3, properties.size());
    Property getResult = properties.get(0);
    assertEquals("", getResult.getName());
    Property getResult2 = properties.get(1);
    assertEquals("42", getResult2.getName());
    Property getResult3 = properties.get(2);
    assertEquals("foo", getResult3.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult3.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult2.getOriginalDisplayValue());
    assertNull(getResult3.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult2.getOriginalValue());
    assertNull(getResult3.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult2.getRawValue());
    assertNull(getResult3.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult2.getUnHtmlEncodedValue());
    assertNull(getResult3.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult2.getValue());
    assertNull(getResult3.getValue());
    assertNull(getResult.getDeployDate());
    assertNull(getResult2.getDeployDate());
    assertNull(getResult3.getDeployDate());
    assertEquals(3, mergedProperties.size());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult2.getIsDirty());
    assertFalse(getResult3.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertFalse(getResult2.isAdvancedCollection());
    assertFalse(getResult3.isAdvancedCollection());
    assertTrue(mergedProperties.containsKey(""));
    assertTrue(mergedProperties.containsKey("42"));
    assertTrue(getResult.getEnabled());
    assertTrue(getResult2.getEnabled());
    assertTrue(getResult3.getEnabled());
    assertSame(adornedTargetCollectionMetadata3, mergedProperties.get("foo"));
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
    assertSame(adornedTargetCollectionMetadata2, getResult2.getMetadata());
    assertSame(adornedTargetCollectionMetadata3, getResult3.getMetadata());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  public void testExtractPropertiesFromMetadata6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    mergedProperties.put("foo", basicFieldMetadata);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties, properties, true,
        MergedPropertyType.PRIMARY);

    // Assert
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("foo");
    assertTrue(getResult instanceof BasicFieldMetadata);
    assertEquals(1, properties.size());
    Property getResult2 = properties.get(0);
    assertEquals("foo", getResult2.getName());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult2.getOriginalDisplayValue());
    assertNull(getResult2.getOriginalValue());
    assertNull(getResult2.getRawValue());
    assertNull(getResult2.getUnHtmlEncodedValue());
    assertNull(getResult2.getValue());
    assertNull(getResult2.getDeployDate());
    assertEquals(VisibilityEnum.HIDDEN_ALL, ((BasicFieldMetadata) getResult).getVisibility());
    assertFalse(getResult2.getIsDirty());
    assertFalse(getResult2.isAdvancedCollection());
    assertTrue(getResult2.getEnabled());
    assertSame(basicFieldMetadata, getResult);
    assertSame(basicFieldMetadata, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  public void testExtractPropertiesFromMetadata7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    doNothing().when(basicFieldMetadata).setVisibility(Mockito.<VisibilityEnum>any());

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", basicFieldMetadata);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties, properties, true,
        MergedPropertyType.PRIMARY);

    // Assert
    verify(basicFieldMetadata).setVisibility(eq(VisibilityEnum.HIDDEN_ALL));
    assertEquals(1, properties.size());
    Property getResult = properties.get(0);
    assertEquals("foo", getResult.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertEquals(1, mergedProperties.size());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(mergedProperties.containsKey("foo"));
    assertTrue(getResult.getEnabled());
    FieldMetadata expectedMetadata = mergedProperties.get("foo");
    assertSame(expectedMetadata, getResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  public void testExtractPropertiesFromMetadata8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", mock(BasicFieldMetadata.class));
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties, properties,
        false, MergedPropertyType.PRIMARY);

    // Assert
    assertEquals(1, properties.size());
    Property getResult = properties.get(0);
    assertEquals("foo", getResult.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertEquals(1, mergedProperties.size());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(mergedProperties.containsKey("foo"));
    assertTrue(getResult.getEnabled());
    FieldMetadata expectedMetadata = mergedProperties.get("foo");
    assertSame(expectedMetadata, getResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)}
   */
  @Test
  public void testExtractPropertiesFromMetadata9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    Class<Object> forNameResult = Object.class;
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    doThrow(new ParentEntityPersistenceException("An error occurred")).when(basicFieldMetadata)
        .setVisibility(Mockito.<VisibilityEnum>any());

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", basicFieldMetadata);

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.extractPropertiesFromMetadata(new Class[]{forNameResult}, mergedProperties,
            new ArrayList<>(), true, MergedPropertyType.PRIMARY));
    verify(basicFieldMetadata).setVisibility(eq(VisibilityEnum.HIDDEN_ALL));
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getTotalRecords(String, List)}
   */
  @Test
  public void testGetTotalRecords() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao())
        .thenThrow(new CriteriaConversionException("An error occurred", fieldPath));

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act and Assert
    assertThrows(CriteriaConversionException.class,
        () -> basicPersistenceModule.getTotalRecords("Ceiling Entity", new ArrayList<>()));
    verify(persistenceManager).getDynamicEntityDao();
    verify(fieldPath).getTargetProperty();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getPersistentRecords(String, List, Integer, Integer)}
   */
  @Test
  public void testGetPersistentRecords() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao())
        .thenThrow(new CriteriaConversionException("An error occurred", fieldPath));

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act and Assert
    assertThrows(CriteriaConversionException.class,
        () -> basicPersistenceModule.getPersistentRecords("Ceiling Entity", new ArrayList<>(), 1, 3));
    verify(persistenceManager).getDynamicEntityDao();
    verify(fieldPath).getTargetProperty();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#validate(Entity, Serializable, Map)}
   */
  @Test
  public void testValidate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorService entityValidatorService = mock(EntityValidatorService.class);
    doNothing().when(entityValidatorService)
        .validate(Mockito.<Entity>any(), Mockito.<Serializable>any(), Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(), anyBoolean());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setEntityValidatorService(entityValidatorService);
    Entity entity = new Entity();
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult = basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>());

    // Assert
    verify(entityValidatorService).validate(isA(Entity.class), isA(Serializable.class), isA(Map.class),
        isA(RecordHelper.class), eq(true));
    assertTrue(actualValidateResult);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#validate(Entity, Serializable, Map)}
   */
  @Test
  public void testValidate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorService entityValidatorService = mock(EntityValidatorService.class);
    doNothing().when(entityValidatorService)
        .validate(Mockito.<Entity>any(), Mockito.<Serializable>any(), Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(), anyBoolean());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setEntityValidatorService(entityValidatorService);
    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(true);
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult = basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>());

    // Assert
    verify(entity).isValidationFailure();
    verify(entityValidatorService).validate(isA(Entity.class), isA(Serializable.class), isA(Map.class),
        isA(RecordHelper.class), eq(true));
    assertFalse(actualValidateResult);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#validate(Entity, Serializable, Map, boolean)}
   */
  @Test
  public void testValidate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorService entityValidatorService = mock(EntityValidatorService.class);
    doNothing().when(entityValidatorService)
        .validate(Mockito.<Entity>any(), Mockito.<Serializable>any(), Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(), anyBoolean());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setEntityValidatorService(entityValidatorService);
    Entity entity = new Entity();
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult = basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>(), true);

    // Assert
    verify(entityValidatorService).validate(isA(Entity.class), isA(Serializable.class), isA(Map.class),
        isA(RecordHelper.class), eq(true));
    assertTrue(actualValidateResult);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#validate(Entity, Serializable, Map, boolean)}
   */
  @Test
  public void testValidate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityValidatorService entityValidatorService = mock(EntityValidatorService.class);
    doNothing().when(entityValidatorService)
        .validate(Mockito.<Entity>any(), Mockito.<Serializable>any(), Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(), anyBoolean());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setEntityValidatorService(entityValidatorService);
    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(true);
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult = basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>(), true);

    // Assert
    verify(entity).isValidationFailure();
    verify(entityValidatorService).validate(isA(Entity.class), isA(Serializable.class), isA(Map.class),
        isA(RecordHelper.class), eq(true));
    assertFalse(actualValidateResult);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getCompatibleModule(OperationType)}
   */
  @Test
  public void testGetCompatibleModule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = new AdornedTargetListPersistenceModule();
    when(persistenceManager.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    PersistenceModule actualCompatibleModule = basicPersistenceModule
        .getCompatibleModule(OperationType.NONDESTRUCTIVEREMOVE);

    // Assert
    verify(persistenceManager).getCompatibleModule(eq(OperationType.NONDESTRUCTIVEREMOVE));
    assertSame(adornedTargetListPersistenceModule, actualCompatibleModule);
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getSpecialCaseQueryBuilder(FieldPath, List, String)}
   */
  @Test
  public void testGetSpecialCaseQueryBuilder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn("Target Property");

    // Act and Assert
    assertThrows(CriteriaConversionException.class, () -> basicPersistenceModule
        .getSpecialCaseQueryBuilder(embeddedCollectionPath, new ArrayList<>(), "Collection Class"));
    verify(embeddedCollectionPath).getTargetProperty();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getSpecialCaseQueryBuilder(FieldPath, List, String)}
   */
  @Test
  public void testGetSpecialCaseQueryBuilder2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn("Target Property");

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertThrows(CriteriaConversionException.class, () -> basicPersistenceModule
        .getSpecialCaseQueryBuilder(embeddedCollectionPath, filterMappings, "Collection Class"));
    verify(embeddedCollectionPath).getTargetProperty();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#getSpecialCaseQueryBuilder(FieldPath, List, String)}
   */
  @Test
  public void testGetSpecialCaseQueryBuilder3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn("Target Property");

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertThrows(CriteriaConversionException.class, () -> basicPersistenceModule
        .getSpecialCaseQueryBuilder(embeddedCollectionPath, filterMappings, "Collection Class"));
    verify(embeddedCollectionPath).getTargetProperty();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult = basicPersistenceModule
        .buildStandardRestrictions(embeddedCollectionPath, new ArrayList<>());

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult = basicPersistenceModule
        .buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getRestriction()).thenReturn(new Restriction());
    when(filterMapping.getFullPropertyName()).thenReturn("Dr Jane Doe");
    when(filterMapping.getFieldPath()).thenReturn(new FieldPath());

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult = basicPersistenceModule
        .buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFullPropertyName();
    verify(filterMapping).getRestriction();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getRestriction()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(filterMapping.getFullPropertyName()).thenReturn("Dr Jane Doe");
    when(filterMapping.getFieldPath()).thenReturn(new FieldPath());

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings));
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFullPropertyName();
    verify(filterMapping).getRestriction();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(mock(FilterValueConverter.class));
    when(restriction.getPredicateProvider()).thenReturn(mock(PredicateProvider.class));
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(new ArrayList<>());
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFullPropertyName()).thenReturn("Dr Jane Doe");
    when(filterMapping.getFieldPath()).thenReturn(new FieldPath());

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult = basicPersistenceModule
        .buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFilterValues();
    verify(filterMapping).getFullPropertyName();
    verify(filterMapping, atLeast(1)).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(restriction).getPredicateProvider();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(mock(FilterValueConverter.class));
    when(restriction.getPredicateProvider()).thenReturn(mock(PredicateProvider.class));
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFullPropertyName()).thenReturn("Dr Jane Doe");
    when(filterMapping.getFieldPath()).thenReturn(new FieldPath());

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings));
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFilterValues();
    verify(filterMapping).getFullPropertyName();
    verify(filterMapping, atLeast(1)).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(restriction).getPredicateProvider();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");
    FilterValueConverter filterValueConverter = mock(FilterValueConverter.class);
    when(filterValueConverter.convert(Mockito.<String>any())).thenReturn("Convert");
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(filterValueConverter);
    when(restriction.getPredicateProvider()).thenReturn(mock(PredicateProvider.class));

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(".");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(stringList);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFullPropertyName()).thenReturn("Dr Jane Doe");
    when(filterMapping.getFieldPath()).thenReturn(new FieldPath());

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult = basicPersistenceModule
        .buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getFilterValues();
    verify(filterMapping).getFullPropertyName();
    verify(filterMapping, atLeast(1)).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(restriction).getPredicateProvider();
    verify(filterValueConverter).convert(eq("."));
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFullPropertyName()).thenReturn(".");
    when(filterMapping.getFieldPath()).thenReturn(new FieldPath());

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult = basicPersistenceModule
        .buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFullPropertyName();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFullPropertyName()).thenReturn("");
    when(filterMapping.getFieldPath()).thenReturn(new FieldPath());

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult = basicPersistenceModule
        .buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFullPropertyName();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    FilterValueConverter filterValueConverter = mock(FilterValueConverter.class);
    when(filterValueConverter.convert(Mockito.<String>any())).thenReturn("Convert");
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(filterValueConverter);
    when(restriction.getPredicateProvider()).thenReturn(mock(PredicateProvider.class));

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(".");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(stringList);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult = basicPersistenceModule
        .buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(fieldPath).getTargetProperty();
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getFilterValues();
    verify(filterMapping, atLeast(1)).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(restriction).getPredicateProvider();
    verify(filterValueConverter).convert(eq("."));
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  public void testBuildStandardRestrictions11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings));
    verify(fieldPath).getTargetProperty();
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    // Act and Assert
    assertTrue(basicPersistenceModule.buildSpecialRestrictions("Special Expression", new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertTrue(basicPersistenceModule.buildSpecialRestrictions("Special Expression", filterMappings).isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertTrue(basicPersistenceModule.buildSpecialRestrictions("Special Expression", filterMappings).isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setRestrictionFactory(mock(RestrictionFactory.class));

    // Act and Assert
    assertTrue(basicPersistenceModule.buildSpecialRestrictions("Special Expression", new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFieldPath()).thenReturn(new FieldPath());

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult = basicPersistenceModule
        .buildSpecialRestrictions("Special Expression", filterMappings);

    // Assert
    verify(filterMapping, atLeast(1)).getFieldPath();
    assertTrue(actualBuildSpecialRestrictionsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult = basicPersistenceModule
        .buildSpecialRestrictions("Special Expression", filterMappings);

    // Assert
    verify(fieldPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    assertTrue(actualBuildSpecialRestrictionsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getRestriction()).thenReturn(new Restriction());
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult = basicPersistenceModule.buildSpecialRestrictions("",
        filterMappings);

    // Assert
    verify(fieldPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getRestriction();
    assertTrue(actualBuildSpecialRestrictionsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(mock(FilterValueConverter.class));
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(new ArrayList<>());
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult = basicPersistenceModule.buildSpecialRestrictions("",
        filterMappings);

    // Assert
    verify(fieldPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFilterValues();
    verify(filterMapping).getRestriction();
    verify(restriction).getFilterValueConverter();
    assertTrue(actualBuildSpecialRestrictionsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(mock(FilterValueConverter.class));
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.buildSpecialRestrictions("", filterMappings));
    verify(fieldPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFilterValues();
    verify(filterMapping).getRestriction();
    verify(restriction).getFilterValueConverter();
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    FilterValueConverter filterValueConverter = mock(FilterValueConverter.class);
    when(filterValueConverter.convert(Mockito.<String>any())).thenReturn("Convert");
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(filterValueConverter);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(stringList);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult = basicPersistenceModule.buildSpecialRestrictions("",
        filterMappings);

    // Assert
    verify(fieldPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getFilterValues();
    verify(filterMapping).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(filterValueConverter).convert(eq("foo"));
    assertEquals(1, actualBuildSpecialRestrictionsResult.size());
  }

  /**
   * Method under test:
   * {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  public void testBuildSpecialRestrictions11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    FilterValueConverter filterValueConverter = mock(FilterValueConverter.class);
    when(filterValueConverter.convert(Mockito.<String>any()))
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));
    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(filterValueConverter);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(stringList);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.buildSpecialRestrictions("", filterMappings));
    verify(fieldPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getFilterValues();
    verify(filterMapping).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(filterValueConverter).convert(eq("foo"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BasicPersistenceModule#setApplicationContext(ApplicationContext)}
   *   <li>{@link BasicPersistenceModule#setCriteriaTranslator(CriteriaTranslator)}
   *   <li>
   * {@link BasicPersistenceModule#setDefaultFieldPersistenceProvider(FieldPersistenceProvider)}
   *   <li>
   * {@link BasicPersistenceModule#setEntityValidatorService(EntityValidatorService)}
   *   <li>{@link BasicPersistenceModule#setFieldPersistenceProviders(List)}
   *   <li>{@link BasicPersistenceModule#setPersistenceManager(PersistenceManager)}
   *   <li>{@link BasicPersistenceModule#setRestrictionFactory(RestrictionFactory)}
   *   <li>{@link BasicPersistenceModule#getCriteriaTranslator()}
   *   <li>{@link BasicPersistenceModule#getDefaultFieldPersistenceProvider()}
   *   <li>{@link BasicPersistenceModule#getEntityValidatorService()}
   *   <li>{@link BasicPersistenceModule#getFieldPersistenceProviders()}
   *   <li>{@link BasicPersistenceModule#getPersistenceManager()}
   *   <li>{@link BasicPersistenceModule#getRestrictionFactory()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    // Act
    basicPersistenceModule.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    CriteriaTranslatorImpl criteriaTranslator = new CriteriaTranslatorImpl();
    basicPersistenceModule.setCriteriaTranslator(criteriaTranslator);
    BasicFieldPersistenceProvider defaultFieldPersistenceProvider = new BasicFieldPersistenceProvider();
    basicPersistenceModule.setDefaultFieldPersistenceProvider(defaultFieldPersistenceProvider);
    BeanValidationEntityValidatorServiceImpl entityValidatorService = new BeanValidationEntityValidatorServiceImpl();
    basicPersistenceModule.setEntityValidatorService(entityValidatorService);
    ArrayList<FieldPersistenceProvider> fieldPersistenceProviders = new ArrayList<>();
    basicPersistenceModule.setFieldPersistenceProviders(fieldPersistenceProviders);
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    RestrictionFactory restrictionFactory = mock(RestrictionFactory.class);
    basicPersistenceModule.setRestrictionFactory(restrictionFactory);
    CriteriaTranslator actualCriteriaTranslator = basicPersistenceModule.getCriteriaTranslator();
    FieldPersistenceProvider actualDefaultFieldPersistenceProvider = basicPersistenceModule
        .getDefaultFieldPersistenceProvider();
    EntityValidatorService actualEntityValidatorService = basicPersistenceModule.getEntityValidatorService();
    List<FieldPersistenceProvider> actualFieldPersistenceProviders = basicPersistenceModule
        .getFieldPersistenceProviders();
    PersistenceManager actualPersistenceManager = basicPersistenceModule.getPersistenceManager();
    RestrictionFactory actualRestrictionFactory = basicPersistenceModule.getRestrictionFactory();

    // Assert that nothing has changed
    assertTrue(actualCriteriaTranslator instanceof CriteriaTranslatorImpl);
    assertTrue(actualDefaultFieldPersistenceProvider instanceof BasicFieldPersistenceProvider);
    assertTrue(actualFieldPersistenceProviders.isEmpty());
    assertSame(fieldPersistenceProviders, actualFieldPersistenceProviders);
    assertSame(persistenceManager, actualPersistenceManager);
    assertSame(criteriaTranslator, actualCriteriaTranslator);
    assertSame(defaultFieldPersistenceProvider, actualDefaultFieldPersistenceProvider);
    assertSame(entityValidatorService, actualEntityValidatorService);
    assertSame(restrictionFactory, actualRestrictionFactory);
  }
}
