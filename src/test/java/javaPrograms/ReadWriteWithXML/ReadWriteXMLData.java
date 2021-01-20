package javaPrograms.ReadWriteWithXML;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class ReadWriteXMLData {

  public static void main(String[] args) {

    try {
      // Read Value from XML
      ObjectMapper mapper = new XmlMapper();
      InputStream inputStream =
          new FileInputStream(
              System.getProperty("user.dir")
                  + "\\src\\test\\java\\javaPrograms\\ReadWriteWithXML\\Persons.xml");

      TypeReference<List<Person>> typeReference = new TypeReference<List<Person>>() {};
      List<Person> persons = mapper.readValue(inputStream, typeReference);

      for (Person p : persons) {
        System.out.println(
            "name is "
                + p.getFirstName()
                + " city is "
                + p.getAddress().getCity()
                + " first Car is "
                + p.getCars()[0]);
      }

      // Write Value from XML
      Person person = new Person();
      person.setFirstName("Deepak");
      person.setLastName("Rai");
      person.setAge(30);
      person.setAddress(new Address("C1404", "Pune", "411057"));
      person.setCars(new String[] {"Toyota", "Mercedez", "Jeep"});

      mapper.writeValue(
          new File(
              System.getProperty("user.dir")
                  + "\\src\\test\\java\\javaPrograms\\ReadWriteWithXML\\Persons.xml"),
          person);
      inputStream.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  } // End of method main
} // End of class ReadWriteXMLData
