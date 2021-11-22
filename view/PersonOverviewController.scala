package ch.makery.address.view
import ch.makery.address.model.Person
import ch.makery.address.MainApp
import scalafx.scene.control.{TableView, TableColumn, Label}
import scalafxml.core.macros.sfxml
import scalafx.beans.property.{StringProperty} 

@sfxml
class PersonOverviewController(
  
    private val personTable : TableView[Person],
    private val firstNameColumn: TableColumn[Person, String],
    private val lastNameColumn : TableColumn[Person, String],
    private val studentIDLabel : Label,
    private val firstNameLabel : Label,
    private val lastNameLabel : Label,
    private val courseLabel : Label,
    private val vaccinationLabel : Label,
    private val vaccinationDateLabel : Label, 
    ) {
  // initialize Table View display contents model
  personTable.items = Person.personData
  // initialize columns's cell values
  firstNameColumn.cellValueFactory = {_.value.firstName}
  lastNameColumn.cellValueFactory  = {_.value.lastName} 


    private def showPersonDetails (person : Option[Person]) = {
    person match {
      case Some(person) =>
      // Fill the labels with info from the person object.

      studentIDLabel.text = person.studentID.value.toString
      firstNameLabel.text <== person.firstName
      lastNameLabel.text  <== person.lastName
      courseLabel.text    <== person.course
      vaccinationLabel.text      <== person.vaccination;
     
      import ch.makery.address.util.DateUtil._
      vaccinationDateLabel.text = person.vaccinationDate.value.asString
      
      
      case None =>
        // Person is null, remove all the text.
        firstNameLabel.text.unbind()
        lastNameLabel.text.unbind()
        courseLabel.text.unbind()
        vaccinationLabel.text.unbind()

      studentIDLabel.text = ""
      firstNameLabel.text = ""
      lastNameLabel.text  = ""
      courseLabel.text    = ""
      vaccinationLabel.text = ""
      vaccinationDateLabel.text  = ""
    }    
  }
   
  
    }





