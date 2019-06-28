package de.seven.fate.model.builder.util;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Test;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AnnotationUtilTest {

    AnnotationUtil sut;

    @XmlElement
    String xmlElement;

    @XmlElement(required = true)
    String requiredXmlElement;

    @XmlAttribute
    String xmlAttribute;

    @XmlAttribute(required = true)
    String requiredXmlAttribute;

    @Test(expected = UnsupportedOperationException.class)
    public void utilityClassTest() throws Exception {

        Constructor<AnnotationUtil> constructor = AnnotationUtil.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        try {
            constructor.newInstance();
        } catch (InvocationTargetException e) {
            throw (UnsupportedOperationException) e.getTargetException();
        }
    }

    @Test
    public void isAnyRequiredAnnotationOnNull() {

        boolean requiredAnnotation = AnnotationUtil.isAnyRequiredAnnotation(null);

        assertFalse(requiredAnnotation);
    }

    @Test
    public void isAnyRequiredAnnotationOnXmlElement() {

        Field field = FieldUtils.getField(AnnotationUtilTest.class, "xmlElement", true);

        boolean requiredAnnotation = AnnotationUtil.isAnyRequiredAnnotation(field.getDeclaredAnnotations());

        assertTrue(requiredAnnotation);
    }

    @Test
    public void isAnyRequiredAnnotationOnXmlElementWithRequired() {

        Field field = FieldUtils.getField(AnnotationUtilTest.class, "requiredXmlElement", true);

        boolean requiredAnnotation = AnnotationUtil.isAnyRequiredAnnotation(field.getDeclaredAnnotations());

        assertTrue(requiredAnnotation);
    }

    @Test
    public void isAnyRequiredAnnotationOnXmlAttribute() {

        Field field = FieldUtils.getField(AnnotationUtilTest.class, "xmlAttribute", true);

        boolean requiredAnnotation = AnnotationUtil.isAnyRequiredAnnotation(field.getDeclaredAnnotations());

        assertTrue(requiredAnnotation);
    }

    @Test
    public void isAnyRequiredAnnotationOnXmlAttributeWithRequired() {

        Field field = FieldUtils.getField(AnnotationUtilTest.class, "requiredXmlAttribute", true);

        boolean requiredAnnotation = AnnotationUtil.isAnyRequiredAnnotation(field.getDeclaredAnnotations());

        assertTrue(requiredAnnotation);
    }

    @Test
    public void addXmlAttributePredicate() {

        assertNotNull(AnnotationUtil.addPredicate("javax.xml.bind.annotation.XmlAttribute", it -> true));
    }

    @Test
    public void addXmlElementPredicate() {

        assertNotNull(AnnotationUtil.addPredicate("javax.xml.bind.annotation.XmlElement", it -> true));
    }

    @Test
    public void addNotNullPredicate() {

        assertNotNull(AnnotationUtil.addPredicate("javax.validation.constraints.NotNull", it -> true));
    }

    @Test
    public void addNotEmptyPredicate() {

        assertNotNull(AnnotationUtil.addPredicate("javax.validation.constraints.NotEmpty", it -> true));
    }
}
