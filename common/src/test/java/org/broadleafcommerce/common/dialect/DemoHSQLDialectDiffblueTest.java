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
import java.util.Map;
import java.util.Properties;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.identity.HSQLIdentityColumnSupport;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.unique.DefaultUniqueDelegate;
import org.hibernate.engine.jdbc.env.internal.DefaultSchemaNameResolver;
import org.hibernate.engine.jdbc.env.spi.NameQualifierSupport;
import org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy;
import org.hibernate.id.IdentityGenerator;
import org.hibernate.internal.util.compare.ComparableComparator;
import org.hibernate.procedure.internal.StandardCallableStatementSupport;
import org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorHSQLDBDatabaseImpl;
import org.hibernate.tool.schema.internal.StandardAuxiliaryDatabaseObjectExporter;
import org.hibernate.tool.schema.internal.StandardForeignKeyExporter;
import org.hibernate.tool.schema.internal.StandardIndexExporter;
import org.hibernate.tool.schema.internal.StandardSequenceExporter;
import org.hibernate.tool.schema.internal.StandardTableExporter;
import org.hibernate.tool.schema.internal.StandardUniqueKeyExporter;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;
import org.hibernate.type.descriptor.java.DoubleTypeDescriptor;
import org.hibernate.type.descriptor.java.ImmutableMutabilityPlan;
import org.hibernate.type.descriptor.java.IntegerTypeDescriptor;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.java.MutabilityPlan;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;
import org.junit.Test;

public class DemoHSQLDialectDiffblueTest {
  /**
   * Test {@link DemoHSQLDialect#dropConstraints()}.
   * <p>
   * Method under test: {@link DemoHSQLDialect#dropConstraints()}
   */
  @Test
  public void testDropConstraints() {
    // Arrange, Act and Assert
    assertFalse((new DemoHSQLDialect()).dropConstraints());
  }

  /**
   * Test {@link DemoHSQLDialect#getCascadeConstraintsString()}.
   * <p>
   * Method under test: {@link DemoHSQLDialect#getCascadeConstraintsString()}
   */
  @Test
  public void testGetCascadeConstraintsString() {
    // Arrange, Act and Assert
    assertEquals(" cascade ", (new DemoHSQLDialect()).getCascadeConstraintsString());
  }

  /**
   * Test {@link DemoHSQLDialect#supportsIfExistsBeforeTableName()}.
   * <p>
   * Method under test: {@link DemoHSQLDialect#supportsIfExistsBeforeTableName()}
   */
  @Test
  public void testSupportsIfExistsBeforeTableName() {
    // Arrange, Act and Assert
    assertTrue((new DemoHSQLDialect()).supportsIfExistsBeforeTableName());
  }

  /**
   * Test {@link DemoHSQLDialect#supportsIfExistsAfterTableName()}.
   * <p>
   * Method under test: {@link DemoHSQLDialect#supportsIfExistsAfterTableName()}
   */
  @Test
  public void testSupportsIfExistsAfterTableName() {
    // Arrange, Act and Assert
    assertFalse((new DemoHSQLDialect()).supportsIfExistsAfterTableName());
  }

  /**
   * Test new {@link DemoHSQLDialect} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link DemoHSQLDialect}
   */
  @Test
  public void testNewDemoHSQLDialect() {
    // Arrange and Act
    DemoHSQLDialect actualDemoHSQLDialect = new DemoHSQLDialect();

    // Assert
    Map<String, SQLFunction> functions = actualDemoHSQLDialect.getFunctions();
    assertEquals(77, functions.size());
    SQLFunction getResult = functions.get("cos");
    assertTrue(getResult instanceof StandardSQLFunction);
    SQLFunction getResult2 = functions.get("cot");
    assertTrue(getResult2 instanceof StandardSQLFunction);
    SQLFunction getResult3 = functions.get("mod");
    assertTrue(getResult3 instanceof StandardSQLFunction);
    SQLFunction getResult4 = functions.get("sign");
    assertTrue(getResult4 instanceof StandardSQLFunction);
    SQLFunction getResult5 = functions.get("upper");
    assertTrue(getResult5 instanceof StandardSQLFunction);
    SQLFunction getResult6 = functions.get("year");
    assertTrue(getResult6 instanceof StandardSQLFunction);
    IdentityColumnSupport identityColumnSupport = actualDemoHSQLDialect.getIdentityColumnSupport();
    assertTrue(identityColumnSupport instanceof HSQLIdentityColumnSupport);
    assertTrue(actualDemoHSQLDialect.getUniqueDelegate() instanceof DefaultUniqueDelegate);
    assertTrue(actualDemoHSQLDialect.getSchemaNameResolver() instanceof DefaultSchemaNameResolver);
    assertTrue(actualDemoHSQLDialect.getDefaultMultiTableBulkIdStrategy() instanceof LocalTemporaryTableBulkIdStrategy);
    Type type = ((StandardSQLFunction) getResult3).getType();
    Comparator<Integer> comparator = ((IntegerType) type).getComparator();
    assertTrue(comparator instanceof ComparableComparator);
    assertTrue(actualDemoHSQLDialect.getCallableStatementSupport() instanceof StandardCallableStatementSupport);
    assertTrue(actualDemoHSQLDialect
        .getSequenceInformationExtractor() instanceof SequenceInformationExtractorHSQLDBDatabaseImpl);
    assertTrue(
        actualDemoHSQLDialect.getAuxiliaryDatabaseObjectExporter() instanceof StandardAuxiliaryDatabaseObjectExporter);
    assertTrue(actualDemoHSQLDialect.getForeignKeyExporter() instanceof StandardForeignKeyExporter);
    assertTrue(actualDemoHSQLDialect.getIndexExporter() instanceof StandardIndexExporter);
    assertTrue(actualDemoHSQLDialect.getSequenceExporter() instanceof StandardSequenceExporter);
    assertTrue(actualDemoHSQLDialect.getTableExporter() instanceof StandardTableExporter);
    assertTrue(actualDemoHSQLDialect.getUniqueKeyExporter() instanceof StandardUniqueKeyExporter);
    Type type2 = ((StandardSQLFunction) getResult).getType();
    assertTrue(type2 instanceof DoubleType);
    assertTrue(type instanceof IntegerType);
    JavaTypeDescriptor<Double> javaTypeDescriptor = ((DoubleType) type2).getJavaTypeDescriptor();
    assertTrue(javaTypeDescriptor instanceof DoubleTypeDescriptor);
    JavaTypeDescriptor<Integer> javaTypeDescriptor2 = ((IntegerType) type).getJavaTypeDescriptor();
    MutabilityPlan<Integer> mutabilityPlan = javaTypeDescriptor2.getMutabilityPlan();
    assertTrue(mutabilityPlan instanceof ImmutableMutabilityPlan);
    assertTrue(javaTypeDescriptor2 instanceof IntegerTypeDescriptor);
    SqlTypeDescriptor sqlTypeDescriptor = ((DoubleType) type2).getSqlTypeDescriptor();
    assertTrue(sqlTypeDescriptor instanceof org.hibernate.type.descriptor.sql.DoubleTypeDescriptor);
    SqlTypeDescriptor sqlTypeDescriptor2 = ((IntegerType) type).getSqlTypeDescriptor();
    assertTrue(sqlTypeDescriptor2 instanceof org.hibernate.type.descriptor.sql.IntegerTypeDescriptor);
    assertEquals(" cascade ", actualDemoHSQLDialect.getCascadeConstraintsString());
    assertEquals(" cross join ", actualDemoHSQLDialect.getCrossJoinSeparator());
    assertEquals(" drop constraint ", actualDemoHSQLDialect.getDropForeignKeyString());
    assertEquals(" for update", actualDemoHSQLDialect.getForUpdateNowaitString());
    assertEquals(" for update", actualDemoHSQLDialect.getForUpdateSkipLockedString());
    assertEquals(" for update", actualDemoHSQLDialect.getForUpdateString());
    assertEquals("", actualDemoHSQLDialect.getAddColumnSuffixString());
    assertEquals("", actualDemoHSQLDialect.getNullColumnString());
    assertEquals("", actualDemoHSQLDialect.getTableTypeString());
    Properties defaultProperties = actualDemoHSQLDialect.getDefaultProperties();
    assertEquals(1, defaultProperties.size());
    assertEquals("15", defaultProperties.get("hibernate.jdbc.batch_size"));
    assertEquals("add column", actualDemoHSQLDialect.getAddColumnString());
    assertEquals("call current_timestamp", actualDemoHSQLDialect.getCurrentTimestampSelectString());
    assertEquals("cos", getResult.toString());
    assertEquals("cos", ((StandardSQLFunction) getResult).getName());
    assertEquals("cot", getResult2.toString());
    assertEquals("cot", ((StandardSQLFunction) getResult2).getName());
    assertEquals("create table", actualDemoHSQLDialect.getCreateMultisetTableString());
    assertEquals("create table", actualDemoHSQLDialect.getCreateTableString());
    assertEquals("current_timestamp", actualDemoHSQLDialect.getCurrentTimestampSQLFunctionName());
    assertEquals("default", identityColumnSupport.getIdentityInsertString());
    assertEquals("double", ((DoubleType) type2).getPrimitiveClass().getName());
    assertEquals("double", type2.getName());
    assertEquals("identity", actualDemoHSQLDialect.getNativeIdentifierGeneratorStrategy());
    assertEquals("int", ((IntegerType) type).getPrimitiveClass().getName());
    assertEquals("integer", type.getName());
    assertEquals("like", actualDemoHSQLDialect.getCaseInsensitiveLike());
    assertEquals("lower", actualDemoHSQLDialect.getLowercaseFunction());
    assertEquals("mod", getResult3.toString());
    assertEquals("mod", ((StandardSQLFunction) getResult3).getName());
    assertEquals("select * from information_schema.sequences", actualDemoHSQLDialect.getQuerySequencesString());
    assertEquals("sign", getResult4.toString());
    assertEquals("sign", ((StandardSQLFunction) getResult4).getName());
    assertEquals("upper", getResult5.toString());
    assertEquals("upper", ((StandardSQLFunction) getResult5).getName());
    assertEquals("values ( )", actualDemoHSQLDialect.getNoColumnsInsertString());
    assertEquals("year", getResult6.toString());
    assertEquals("year", ((StandardSQLFunction) getResult6).getName());
    assertNull(actualDemoHSQLDialect.getCurrentSchemaCommand());
    assertNull(((StandardSQLFunction) getResult5).getType());
    assertEquals(0, actualDemoHSQLDialect.getInExpressionCountLimit());
    assertEquals(0.0d, ((Double) ((DoubleType) type2).getDefaultValue()).doubleValue(), 0.0);
    assertEquals(10, actualDemoHSQLDialect.getMaxAliasLength());
    assertEquals(4, sqlTypeDescriptor2.getSqlType());
    assertEquals(8, sqlTypeDescriptor.getSqlType());
    assertEquals(NameQualifierSupport.SCHEMA, actualDemoHSQLDialect.getNameQualifierSupport());
    assertFalse(actualDemoHSQLDialect.hasSelfReferentialForeignKeyBug());
    assertFalse(actualDemoHSQLDialect.isLegacyLimitHandlerBehaviorEnabled());
    assertFalse(actualDemoHSQLDialect.isLockTimeoutParameterized());
    assertFalse(actualDemoHSQLDialect.isCurrentTimestampSelectStringCallable());
    assertFalse(((DoubleType) type2).isXMLElement());
    assertFalse(((IntegerType) type).isXMLElement());
    assertFalse(type2.isAnyType());
    assertFalse(type.isAnyType());
    assertFalse(type2.isAssociationType());
    assertFalse(type.isAssociationType());
    assertFalse(type2.isCollectionType());
    assertFalse(type.isCollectionType());
    assertFalse(type2.isComponentType());
    assertFalse(type.isComponentType());
    assertFalse(type2.isEntityType());
    assertFalse(type.isEntityType());
    assertFalse(type2.isMutable());
    assertFalse(type.isMutable());
    assertFalse(mutabilityPlan.isMutable());
    assertTrue(actualDemoHSQLDialect.getKeywords().isEmpty());
    assertTrue(actualDemoHSQLDialect.hasAlterTable());
    assertTrue(actualDemoHSQLDialect.isJdbcLogWarningsEnabledByDefault());
    assertTrue(getResult.hasArguments());
    assertTrue(getResult2.hasArguments());
    assertTrue(getResult3.hasArguments());
    assertTrue(getResult4.hasArguments());
    assertTrue(getResult5.hasArguments());
    assertTrue(getResult6.hasArguments());
    assertTrue(getResult.hasParenthesesIfNoArguments());
    assertTrue(getResult2.hasParenthesesIfNoArguments());
    assertTrue(getResult3.hasParenthesesIfNoArguments());
    assertTrue(getResult4.hasParenthesesIfNoArguments());
    assertTrue(getResult5.hasParenthesesIfNoArguments());
    assertTrue(getResult6.hasParenthesesIfNoArguments());
    assertTrue(identityColumnSupport.hasDataTypeInIdentityColumn());
    Class<Double> expectedReturnedClass = Double.class;
    Class returnedClass = type2.getReturnedClass();
    assertEquals(expectedReturnedClass, returnedClass);
    Class<Integer> expectedReturnedClass2 = Integer.class;
    Class returnedClass2 = type.getReturnedClass();
    assertEquals(expectedReturnedClass2, returnedClass2);
    Class<IdentityGenerator> expectedNativeIdentifierGeneratorClass = IdentityGenerator.class;
    assertEquals(expectedNativeIdentifierGeneratorClass, actualDemoHSQLDialect.getNativeIdentifierGeneratorClass());
    assertSame(returnedClass, javaTypeDescriptor.getJavaType());
    assertSame(returnedClass, javaTypeDescriptor.getJavaTypeClass());
    assertSame(returnedClass2, javaTypeDescriptor2.getJavaType());
    assertSame(returnedClass2, javaTypeDescriptor2.getJavaTypeClass());
    assertSame(comparator, javaTypeDescriptor.getComparator());
    assertSame(comparator, javaTypeDescriptor2.getComparator());
    assertSame(type2, ((StandardSQLFunction) getResult2).getType());
    assertSame(type, ((StandardSQLFunction) getResult4).getType());
    assertSame(type, ((StandardSQLFunction) getResult6).getType());
    assertSame(mutabilityPlan, javaTypeDescriptor.getMutabilityPlan());
    assertArrayEquals(new String[]{"double", "double", "java.lang.Double"}, ((DoubleType) type2).getRegistrationKeys());
    assertArrayEquals(new String[]{"integer", "int", "java.lang.Integer"}, ((IntegerType) type).getRegistrationKeys());
  }
}
