package javaPrograms.TestNGSuiteFromSpreadsheet;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.*;
import java.util.regex.Pattern;

@JacksonXmlRootElement(localName = "suite")
public class Suite {

  @JacksonXmlProperty(isAttribute = true)
  private String name;

  @JacksonXmlProperty(localName = "test")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Test> tests;

  public Suite(String name) {
    this.name = name;
    this.tests = new ArrayList<>();
  }

  public void addTest(String testname, String paramName, String paramValue, String className) {
    Test test = new Test(testname);
    test.addParam(paramName, paramValue);
    Pattern.compile(",").splitAsStream(className).forEach(test::addClass);
    this.tests.add(test);
  }

  /**
   * class for test node in xml
   *
   * @author Deepak Rai
   */
  class Test {

    @JacksonXmlProperty(isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "parameter")
    private Parameter param;

    @JacksonXmlProperty(localName = "classes")
    private Classes classes;

    public Test(String name) {
      this.name = name;
      classes = new Classes();
    }

    public void addParam(String name, String value) {
      param = new Parameter(name, value);
    }

    public void addClass(String name) {
      classes.addClasses(name);
    }
  } // End of class Test

  /*
   * class for parameter node in xml
   */
  class Parameter {
    @JacksonXmlProperty(isAttribute = true)
    private String name;

    @JacksonXmlProperty(isAttribute = true)
    private String value;

    public Parameter(String name, String value) {
      this.name = name;
      this.value = value;
    }
  } // End of class Parameter

  /*
   * class for Classes node in xml
   */
  class Classes {

    @JacksonXmlProperty(localName = "class")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Class> classes;

    public Classes() {
      this.classes = new ArrayList<>();
    }

    public void addClasses(String name) {
      this.classes.add(new Class(name));
    }
  } // End of class Classes

  /**
   * class for class node in xml
   *
   * @author Deepak Rai
   */
  class Class {

    @JacksonXmlProperty(isAttribute = true)
    private String name;

    Class(String name) {
      this.name = name;
    }
  } // End of class Class
} // End of class Suite
