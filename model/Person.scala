package ch.makery.address.model

import scalafx.beans.property.{StringProperty, IntegerProperty, ObjectProperty}
import java.time.LocalDate;
import scalafx.collections.ObservableBuffer

class Person ( firstNameS : String, lastNameS : String ){
  var firstName  = new StringProperty(firstNameS)
  var lastName   = new StringProperty(lastNameS) 
  var studentID  = ObjectProperty.apply[Int] (1234)
  var course     = new StringProperty("some course")
  //var postalCode = IntegerProperty(1234)
  var vaccination = new StringProperty("some vaccination")
  var vaccinationDate = ObjectProperty[LocalDate](LocalDate.of(1999, 2, 21))
}

object Person {
        val personData = new ObservableBuffer[Person]()
  personData += new Person("Muhammad", "Sohaib")
  personData += new Person("Ali", "Akram")
  personData += new Person("Chandler", "Bing")
  personData += new Person("Louis", "Gregory")


}