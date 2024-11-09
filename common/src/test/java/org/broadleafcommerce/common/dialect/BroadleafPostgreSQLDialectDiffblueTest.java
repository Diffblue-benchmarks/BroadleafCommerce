/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.common.dialect;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.hibernate.dialect.function.NoArgSQLFunction;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.PostgreSQL81IdentityColumnSupport;
import org.hibernate.dialect.unique.DefaultUniqueDelegate;
import org.hibernate.engine.jdbc.env.internal.DefaultSchemaNameResolver;
import org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy;
import org.hibernate.id.IdentityGenerator;
import org.hibernate.internal.util.compare.ComparableComparator;
import org.hibernate.procedure.internal.PostgresCallableStatementSupport;
import org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorLegacyImpl;
import org.hibernate.tool.schema.internal.StandardAuxiliaryDatabaseObjectExporter;
import org.hibernate.tool.schema.internal.StandardForeignKeyExporter;
import org.hibernate.tool.schema.internal.StandardIndexExporter;
import org.hibernate.tool.schema.internal.StandardSequenceExporter;
import org.hibernate.tool.schema.internal.StandardTableExporter;
import org.hibernate.tool.schema.internal.StandardUniqueKeyExporter;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.TimeType;
import org.hibernate.type.Type;
import org.hibernate.type.descriptor.java.DoubleTypeDescriptor;
import org.hibernate.type.descriptor.java.ImmutableMutabilityPlan;
import org.hibernate.type.descriptor.java.IntegerTypeDescriptor;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.java.JdbcTimeTypeDescriptor;
import org.hibernate.type.descriptor.java.MutabilityPlan;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;
import org.hibernate.type.descriptor.sql.TimeTypeDescriptor;
import org.junit.Test;

public class BroadleafPostgreSQLDialectDiffblueTest {
  /**
   * Test {@link BroadleafPostgreSQLDialect#getSqlTypeDescriptorOverride(int)}.
   * <ul>
   *   <li>When {@code 2005}.</li>
   *   <li>Then return {@link PostgreSQLClobTypeDescriptor}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafPostgreSQLDialect#getSqlTypeDescriptorOverride(int)}
   */
  @Test
  public void testGetSqlTypeDescriptorOverride_when2005_thenReturnPostgreSQLClobTypeDescriptor() {
    // Arrange and Act
    SqlTypeDescriptor actualSqlTypeDescriptorOverride = (new BroadleafPostgreSQLDialect())
        .getSqlTypeDescriptorOverride(2005);

    // Assert
    assertTrue(actualSqlTypeDescriptorOverride instanceof PostgreSQLClobTypeDescriptor);
    assertEquals(2005, actualSqlTypeDescriptorOverride.getSqlType());
  }

  /**
   * Test {@link BroadleafPostgreSQLDialect#getSqlTypeDescriptorOverride(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafPostgreSQLDialect#getSqlTypeDescriptorOverride(int)}
   */
  @Test
  public void testGetSqlTypeDescriptorOverride_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new BroadleafPostgreSQLDialect()).getSqlTypeDescriptorOverride(1));
  }

  /**
   * Test new {@link BroadleafPostgreSQLDialect} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafPostgreSQLDialect}
   */
  @Test
  public void testNewBroadleafPostgreSQLDialect() {
    // Arrange and Act
    BroadleafPostgreSQLDialect actualBroadleafPostgreSQLDialect = new BroadleafPostgreSQLDialect();

    // Assert
    Map<String, SQLFunction> functions = actualBroadleafPostgreSQLDialect.getFunctions();
    assertEquals(82, functions.size());
    SQLFunction getResult = functions.get("localtime");
    assertTrue(getResult instanceof NoArgSQLFunction);
    SQLFunction getResult2 = functions.get("year");
    assertTrue(getResult2 instanceof SQLFunctionTemplate);
    SQLFunction getResult3 = functions.get("cos");
    assertTrue(getResult3 instanceof StandardSQLFunction);
    SQLFunction getResult4 = functions.get("ln");
    assertTrue(getResult4 instanceof StandardSQLFunction);
    SQLFunction getResult5 = functions.get("make_time");
    assertTrue(getResult5 instanceof StandardSQLFunction);
    SQLFunction getResult6 = functions.get("mod");
    assertTrue(getResult6 instanceof StandardSQLFunction);
    IdentityColumnSupport identityColumnSupport = actualBroadleafPostgreSQLDialect.getIdentityColumnSupport();
    assertTrue(identityColumnSupport instanceof PostgreSQL81IdentityColumnSupport);
    assertTrue(actualBroadleafPostgreSQLDialect.getUniqueDelegate() instanceof DefaultUniqueDelegate);
    assertTrue(actualBroadleafPostgreSQLDialect.getSchemaNameResolver() instanceof DefaultSchemaNameResolver);
    assertTrue(actualBroadleafPostgreSQLDialect
        .getDefaultMultiTableBulkIdStrategy() instanceof LocalTemporaryTableBulkIdStrategy);
    Type type = ((StandardSQLFunction) getResult6).getType();
    Comparator<Integer> comparator = ((IntegerType) type).getComparator();
    assertTrue(comparator instanceof ComparableComparator);
    assertTrue(
        actualBroadleafPostgreSQLDialect.getCallableStatementSupport() instanceof PostgresCallableStatementSupport);
    assertTrue(actualBroadleafPostgreSQLDialect
        .getSequenceInformationExtractor() instanceof SequenceInformationExtractorLegacyImpl);
    assertTrue(actualBroadleafPostgreSQLDialect
        .getAuxiliaryDatabaseObjectExporter() instanceof StandardAuxiliaryDatabaseObjectExporter);
    assertTrue(actualBroadleafPostgreSQLDialect.getForeignKeyExporter() instanceof StandardForeignKeyExporter);
    assertTrue(actualBroadleafPostgreSQLDialect.getIndexExporter() instanceof StandardIndexExporter);
    assertTrue(actualBroadleafPostgreSQLDialect.getSequenceExporter() instanceof StandardSequenceExporter);
    assertTrue(actualBroadleafPostgreSQLDialect.getTableExporter() instanceof StandardTableExporter);
    assertTrue(actualBroadleafPostgreSQLDialect.getUniqueKeyExporter() instanceof StandardUniqueKeyExporter);
    Type type2 = ((StandardSQLFunction) getResult4).getType();
    assertTrue(type2 instanceof DoubleType);
    assertTrue(type instanceof IntegerType);
    Type type3 = ((StandardSQLFunction) getResult5).getType();
    assertTrue(type3 instanceof TimeType);
    JavaTypeDescriptor<Double> javaTypeDescriptor = ((DoubleType) type2).getJavaTypeDescriptor();
    assertTrue(javaTypeDescriptor instanceof DoubleTypeDescriptor);
    MutabilityPlan<Double> mutabilityPlan = javaTypeDescriptor.getMutabilityPlan();
    assertTrue(mutabilityPlan instanceof ImmutableMutabilityPlan);
    JavaTypeDescriptor<Integer> javaTypeDescriptor2 = ((IntegerType) type).getJavaTypeDescriptor();
    assertTrue(javaTypeDescriptor2 instanceof IntegerTypeDescriptor);
    JavaTypeDescriptor<Date> javaTypeDescriptor3 = ((TimeType) type3).getJavaTypeDescriptor();
    assertTrue(javaTypeDescriptor3 instanceof JdbcTimeTypeDescriptor);
    MutabilityPlan<Date> mutabilityPlan2 = javaTypeDescriptor3.getMutabilityPlan();
    assertTrue(mutabilityPlan2 instanceof JdbcTimeTypeDescriptor.TimeMutabilityPlan);
    SqlTypeDescriptor sqlTypeDescriptor = ((DoubleType) type2).getSqlTypeDescriptor();
    assertTrue(sqlTypeDescriptor instanceof org.hibernate.type.descriptor.sql.DoubleTypeDescriptor);
    SqlTypeDescriptor sqlTypeDescriptor2 = ((IntegerType) type).getSqlTypeDescriptor();
    assertTrue(sqlTypeDescriptor2 instanceof org.hibernate.type.descriptor.sql.IntegerTypeDescriptor);
    SqlTypeDescriptor sqlTypeDescriptor3 = ((TimeType) type3).getSqlTypeDescriptor();
    assertTrue(sqlTypeDescriptor3 instanceof TimeTypeDescriptor);
    assertEquals(" cascade", actualBroadleafPostgreSQLDialect.getCascadeConstraintsString());
    assertEquals(" cross join ", actualBroadleafPostgreSQLDialect.getCrossJoinSeparator());
    assertEquals(" drop constraint ", actualBroadleafPostgreSQLDialect.getDropForeignKeyString());
    assertEquals(" for update nowait ", actualBroadleafPostgreSQLDialect.getForUpdateNowaitString());
    assertEquals(" for update skip locked", actualBroadleafPostgreSQLDialect.getForUpdateSkipLockedString());
    assertEquals(" for update", actualBroadleafPostgreSQLDialect.getForUpdateString());
    assertEquals("", actualBroadleafPostgreSQLDialect.getAddColumnSuffixString());
    assertEquals("", actualBroadleafPostgreSQLDialect.getNullColumnString());
    assertEquals("", actualBroadleafPostgreSQLDialect.getTableTypeString());
    Properties defaultProperties = actualBroadleafPostgreSQLDialect.getDefaultProperties();
    assertEquals(2, defaultProperties.size());
    assertEquals("15", defaultProperties.get("hibernate.jdbc.batch_size"));
    assertEquals("add column", actualBroadleafPostgreSQLDialect.getAddColumnString());
    assertEquals("cos", getResult3.toString());
    assertEquals("cos", ((StandardSQLFunction) getResult3).getName());
    assertEquals("create table", actualBroadleafPostgreSQLDialect.getCreateMultisetTableString());
    assertEquals("create table", actualBroadleafPostgreSQLDialect.getCreateTableString());
    assertEquals("current_timestamp", actualBroadleafPostgreSQLDialect.getCurrentTimestampSQLFunctionName());
    assertEquals("default values", actualBroadleafPostgreSQLDialect.getNoColumnsInsertString());
    assertEquals("double", ((DoubleType) type2).getPrimitiveClass().getName());
    assertEquals("double", type2.getName());
    assertEquals("ilike", actualBroadleafPostgreSQLDialect.getCaseInsensitiveLike());
    assertEquals("int", ((IntegerType) type).getPrimitiveClass().getName());
    assertEquals("integer", type.getName());
    assertEquals("ln", getResult4.toString());
    assertEquals("ln", ((StandardSQLFunction) getResult4).getName());
    assertEquals("lower", actualBroadleafPostgreSQLDialect.getLowercaseFunction());
    assertEquals("make_time", getResult5.toString());
    assertEquals("make_time", ((StandardSQLFunction) getResult5).getName());
    assertEquals("mod", getResult6.toString());
    assertEquals("mod", ((StandardSQLFunction) getResult6).getName());
    assertEquals("select * from information_schema.sequences",
        actualBroadleafPostgreSQLDialect.getQuerySequencesString());
    assertEquals("select now()", actualBroadleafPostgreSQLDialect.getCurrentTimestampSelectString());
    assertEquals("sequence", actualBroadleafPostgreSQLDialect.getNativeIdentifierGeneratorStrategy());
    assertEquals("time", type3.getName());
    assertNull(actualBroadleafPostgreSQLDialect.getCurrentSchemaCommand());
    assertNull(identityColumnSupport.getIdentityInsertString());
    assertNull(actualBroadleafPostgreSQLDialect.getNameQualifierSupport());
    assertEquals(0, actualBroadleafPostgreSQLDialect.getInExpressionCountLimit());
    assertEquals(0.0d, ((Double) ((DoubleType) type2).getDefaultValue()).doubleValue(), 0.0);
    Set<String> keywords = actualBroadleafPostgreSQLDialect.getKeywords();
    assertEquals(1, keywords.size());
    assertEquals(10, actualBroadleafPostgreSQLDialect.getMaxAliasLength());
    assertEquals(4, sqlTypeDescriptor2.getSqlType());
    assertEquals(8, sqlTypeDescriptor.getSqlType());
    assertEquals(92, sqlTypeDescriptor3.getSqlType());
    assertFalse(actualBroadleafPostgreSQLDialect.hasSelfReferentialForeignKeyBug());
    assertFalse(actualBroadleafPostgreSQLDialect.isLegacyLimitHandlerBehaviorEnabled());
    assertFalse(actualBroadleafPostgreSQLDialect.isLockTimeoutParameterized());
    assertFalse(actualBroadleafPostgreSQLDialect.isCurrentTimestampSelectStringCallable());
    assertFalse(getResult.hasArguments());
    assertFalse(getResult.hasParenthesesIfNoArguments());
    assertFalse(identityColumnSupport.hasDataTypeInIdentityColumn());
    assertFalse(((DoubleType) type2).isXMLElement());
    assertFalse(((IntegerType) type).isXMLElement());
    assertFalse(((TimeType) type3).isXMLElement());
    assertFalse(type2.isAnyType());
    assertFalse(type3.isAnyType());
    assertFalse(type.isAnyType());
    assertFalse(type2.isAssociationType());
    assertFalse(type3.isAssociationType());
    assertFalse(type.isAssociationType());
    assertFalse(type2.isCollectionType());
    assertFalse(type3.isCollectionType());
    assertFalse(type.isCollectionType());
    assertFalse(type2.isComponentType());
    assertFalse(type3.isComponentType());
    assertFalse(type.isComponentType());
    assertFalse(type2.isEntityType());
    assertFalse(type3.isEntityType());
    assertFalse(type.isEntityType());
    assertFalse(type2.isMutable());
    assertFalse(type.isMutable());
    assertFalse(mutabilityPlan.isMutable());
    assertTrue(keywords.contains("partition"));
    assertTrue(actualBroadleafPostgreSQLDialect.hasAlterTable());
    assertTrue(actualBroadleafPostgreSQLDialect.isJdbcLogWarningsEnabledByDefault());
    assertTrue(getResult3.hasArguments());
    assertTrue(getResult4.hasArguments());
    assertTrue(getResult5.hasArguments());
    assertTrue(getResult6.hasArguments());
    assertTrue(getResult2.hasArguments());
    assertTrue(getResult3.hasParenthesesIfNoArguments());
    assertTrue(getResult4.hasParenthesesIfNoArguments());
    assertTrue(getResult5.hasParenthesesIfNoArguments());
    assertTrue(getResult6.hasParenthesesIfNoArguments());
    assertTrue(getResult2.hasParenthesesIfNoArguments());
    assertTrue(type3.isMutable());
    assertTrue(mutabilityPlan2.isMutable());
    String expectedString = Boolean.TRUE.toString();
    assertEquals(expectedString, defaultProperties.get("hibernate.jdbc.lob.non_contextual_creation"));
    Class<Double> expectedReturnedClass = Double.class;
    Class returnedClass = type2.getReturnedClass();
    assertEquals(expectedReturnedClass, returnedClass);
    Class<Integer> expectedReturnedClass2 = Integer.class;
    Class returnedClass2 = type.getReturnedClass();
    assertEquals(expectedReturnedClass2, returnedClass2);
    Class<Date> expectedReturnedClass3 = Date.class;
    Class returnedClass3 = type3.getReturnedClass();
    assertEquals(expectedReturnedClass3, returnedClass3);
    Class<IdentityGenerator> expectedNativeIdentifierGeneratorClass = IdentityGenerator.class;
    assertEquals(expectedNativeIdentifierGeneratorClass,
        actualBroadleafPostgreSQLDialect.getNativeIdentifierGeneratorClass());
    assertSame(returnedClass, javaTypeDescriptor.getJavaType());
    assertSame(returnedClass, javaTypeDescriptor.getJavaTypeClass());
    assertSame(returnedClass3, javaTypeDescriptor3.getJavaType());
    assertSame(returnedClass3, javaTypeDescriptor3.getJavaTypeClass());
    assertSame(returnedClass2, javaTypeDescriptor2.getJavaType());
    assertSame(returnedClass2, javaTypeDescriptor2.getJavaTypeClass());
    assertSame(comparator, javaTypeDescriptor.getComparator());
    assertSame(comparator, javaTypeDescriptor2.getComparator());
    assertSame(comparator, javaTypeDescriptor3.getComparator());
    assertSame(type2, ((StandardSQLFunction) getResult3).getType());
    assertSame(mutabilityPlan, javaTypeDescriptor2.getMutabilityPlan());
    assertArrayEquals(new String[]{"time", "java.sql.Time"}, ((TimeType) type3).getRegistrationKeys());
    assertArrayEquals(new String[]{"double", "double", "java.lang.Double"}, ((DoubleType) type2).getRegistrationKeys());
    assertArrayEquals(new String[]{"integer", "int", "java.lang.Integer"}, ((IntegerType) type).getRegistrationKeys());
  }
}
