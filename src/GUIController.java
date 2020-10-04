import com.sun.javafx.scene.control.InputField;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;

/**
 * The user interface controller that allows displaying and modifying information
 * about members, instructors, classes and scheduled classes.
 * @author Ionut, Claudiu, Maria, Cezary
 * @version 1.0
 */

public class GUIController
{
  @FXML private Button overviewButton;
  @FXML private Button instructorsButton;
  @FXML private Button registerInstructorButton;
  @FXML private Button findEditInstructorButton;
  @FXML private Button searchInstructorByNameButton;
  @FXML private Button searchInstructorByPhoneButton;
  @FXML private Button membersButton;
  @FXML private Button registerMemberButton;
  @FXML private Button findEditMemberButton;
  @FXML private Button searchMemberByNameButton;
  @FXML private Button searchMemberByPhoneButton;
  @FXML private Button classesButton;
  @FXML private Button addClassButton;
  @FXML private Button findEditClassButton;
  @FXML private Button scheduleButton;
  @FXML private Button scheduleClassButton;
  @FXML private Button findEditScheduleButton;
  @FXML private Button editScheduledClassButton;
  @FXML private Button removeScheduledClassPaneButton;
  @FXML private Button signUpMemberScheduledClassButton;
  @FXML private Button cancelMemberScheduledClassButton;
  @FXML private Button exportScheduledClassButton;
  @FXML private Button registerInstructorSaveButton;
  @FXML private Button registerInstructorAddClassButton;

  @FXML private TextField area1;
  @FXML private TextField area2;
  @FXML private TextField area3;
  @FXML private TextField registerInstructorFirstNameInput;
  @FXML private TextField registerInstructorLastNameInput;
  @FXML private TextField registerInstructorAddressInput;
  @FXML private TextField registerInstructorEmailInput;
  @FXML private TextField registerInstructorPhoneInput;
  @FXML private TextField registerInstructorClassInput;
  @FXML private TextField searchInstructorByNameFirstNameInput;
  @FXML private TextField searchInstructorByNameLastNameInput;
  @FXML private TextField searchInstructorByPhoneInput;
  @FXML private TextField editInstructorFirstNameInput;
  @FXML private TextField editInstructorLastNameInput;
  @FXML private TextField editInstructorAddressInput;
  @FXML private TextField editInstructorEmailInput;
  @FXML private TextField editInstructorPhoneInput;
  @FXML private ListView editInstructorClassesInput;
  @FXML private TextField addClassToInstructorInput;

  @FXML private TextField editMemberFirstNameInput;
  @FXML private TextField editMemberLastNameInput;
  @FXML private TextField editMemberAddressInput;
  @FXML private TextField editMemberEmailInput;
  @FXML private ComboBox<String> editMemberMembershipInput;
  @FXML private TextField editMemberPhoneInput;
  @FXML private TextField searchMemberByPhoneInput;
  @FXML private TextField searchMemberByNameFirstNameInput;
  @FXML private TextField searchMemberByNameLastNameInput;
  @FXML private TextField registerMemberPhoneInput;
  @FXML private TextField registerMemberEmailInput;
  @FXML private TextField registerMemberFirstNameInput;
  @FXML private TextField registerMemberLastNameInput;
  @FXML private TextField registerMemberAddressInput;
  @FXML private ComboBox<String> registerMemberMembershipInput;
  @FXML private Button editMemberSaveButton;
  @FXML private Button editMemberDeleteButton;
  @FXML private Button registerMemberSaveButton;
  @FXML private Button editInstructorDeleteButton;
  @FXML private Button editInstructorSaveButton;
  @FXML private Button editInstructorAddButton;

  @FXML private TextField addClassNameInput;
  @FXML private TextField addClassCapacityInput;
  @FXML private TextField searchClassNameInput;
  @FXML private TextField ediClassNameInput;
  @FXML private TextField editClassCapacityInput;
  @FXML private Button addClassSaveButton;
  @FXML private Button searchClassButton;
  @FXML private Button editClassSaveButton;
  @FXML private Button editClassRemoveButton;

  @FXML private TextField scheduleClassHourInput;
  @FXML private TextField scheduleClassMinuteInput;
  @FXML private TextField scheduleClassDurationInput;
  @FXML private TextField editScheduledClassHourInput;
  @FXML private TextField editScheduledClassMinuteInput;
  @FXML private TextField editScheduledClassDurationInput;
  @FXML private TextField scheduledClassNameOutput;
  @FXML private TextField scheduledClassDateOutput;
  @FXML private TextField scheduledClassDurationOutput;
  @FXML private TextField scheduledClassInstructorOutput;
  @FXML private TextField scheduledClassTimeOutput;
  @FXML private TextField scheduledClassCapacityOutput;
  @FXML private TextField scheduleExportYearInput;
  @FXML private ListView searchScheduledClassListView;
  @FXML private TextArea scheduledClassMembersOutput;
  @FXML private TextArea scheduleExportScheduleOutput;
  @FXML private DatePicker scheduleClassDateInput;
  @FXML private DatePicker searchScheduledClassFromInput;
  @FXML private DatePicker searchScheduledClassToInput;
  @FXML private DatePicker editScheduledClassDateInput;
  @FXML private ComboBox<String> scheduleClassClassInput;
  @FXML private ComboBox<String> scheduleClassInstructorInput;
  @FXML private ComboBox<String> editScheduledClassClassInput;
  @FXML private ComboBox<String> editScheduledClassInstructorInput;
  @FXML private ComboBox<Member> signUpScheduledClassPremiumMembersInput;
  @FXML private ComboBox<Member> cancelScheduledClassAttendingMemberInput;
  @FXML private ComboBox<String> scheduleExportMonthInput;
  @FXML private Button scheduleClassSaveButton;
  @FXML private Button searchScheduledClassButton;
  @FXML private Button editScheduledClassSaveButton;
  @FXML private Button removeScheduledClassButton;
  @FXML private Button signUpMemberButton;
  @FXML private Button scheduleExportGetScheduleButton;
  @FXML private Button scheduleExportButton;

  @FXML private Pane overviewPane;
  @FXML private Pane instructorsPane;
  @FXML private Pane registerInstructorPane;
  @FXML private Pane findInstructorPane;
  @FXML private Pane searchInstructorByNamePane;
  @FXML private Pane searchInstructorByPhonePane;
  @FXML private Pane editInstructorPane;
  @FXML private Pane membersPane;
  @FXML private Pane registerMemberPane;
  @FXML private Pane findMemberPane;
  @FXML private Pane searchMemberByNamePane;
  @FXML private Pane searchMemberByPhonePane;
  @FXML private Pane editMemberPane;
  @FXML private Pane classesPane;
  @FXML private Pane addClassPane;
  @FXML private Pane searchClassPane;
  @FXML private Pane schedulePane;
  @FXML private Pane scheduleClassPane;
  @FXML private Pane scheduleDisplayEditExportPane;
  @FXML private Pane scheduleDisplayPane;
  @FXML private Pane scheduleEditPane;
  @FXML private Pane scheduleRemovePane;
  @FXML private Pane scheduleSignUpMemberPane;
  @FXML private Pane scheduleCancelMemberPane;
  @FXML private Pane scheduleExportPane;
  @FXML private Pane scheduleLogoPane;
  @FXML private Pane screenSaverPane;

  @FXML private Label dateLabel;

  private FitnessFileAdapter adapter;
  private ArrayList<String> instrAddClasses = new ArrayList<String>();
  private ArrayList<String> indicatorArray = new ArrayList<String>();
  private int instructorIndicator = 0;
  private int classIndicator = 0;
  private int memberIndicator;
  private boolean searchMemberBy;
  private String darkBgButton = "-fx-background-color: #717171;";
  private String lightBgButton = "-fx-background-color: #b8b8b8;";
  private ArrayList<Member> premiumMembers;
  private ArrayList<String> months;

  /**
   * A method that initialize the data when the user interface is opened.
   * Firstly, declares the adapter object of type FitnessCenterFileAdapter with the specific
   * files where the data is going to be read and written. Afterwards is calling the
   * method that loads the overview pane and also calls the methods that sets the
   * values for the specific sections (e.g. number of members, instructors and classes).
   * Also, in this method loads the options for the specific ComboBoxes with the
   * types of memberships that can be chosen for a member.
   */
  public void initialize()
  {
    adapter = new FitnessFileAdapter("Members.bin", "Instructors.bin",
        "Classes.bin", "ScheduledClasses.bin");
    loadOverviewPane();
    setNumberOfMembers();
    setCurrentInstructors();
    setCurrentClasses();
    setTodayDate();
    registerMemberMembershipInput.getItems().add("Standard");
    registerMemberMembershipInput.getItems().add("Premium");
    editMemberMembershipInput.getItems().add("Standard");
    editMemberMembershipInput.getItems().add("Premium");
  }

  /**
   * A method which loads the screen saver pane when the user clicks on the logo
   * in the top right corner. It sets the visibility of the other panes to false
   * except for the screen saver one which is set to true.
   */
  //SCREEN SAVER PANE METHODS
  public void loadScreenSaver()
  {
    screenSaverPane.setVisible(true);
    overviewPane.setVisible(false);
    instructorsPane.setVisible(false);
    membersPane.setVisible(false);
    classesPane.setVisible(false);
    schedulePane.setVisible(false);
  }

  /**
   * A method which loads the overview pane. It sets the visibility of the other
   * panes to false except for the overview which is set to true.
   * Also, it sets the design for the navigation buttons.
   */
  //OVERVIEW PANE METHODS
  public void loadOverviewPane()
  {
    screenSaverPane.setVisible(false);
    overviewPane.setVisible(true);
    instructorsPane.setVisible(false);
    membersPane.setVisible(false);
    classesPane.setVisible(false);
    schedulePane.setVisible(false);
    overviewButton.setStyle(
        "-fx-background-color: #000037;-fx-font-size: 24px;fx-font-weight: bold;");
    instructorsButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    membersButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    classesButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    scheduleButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
  }

  /**
   * A method used for displaying the number of current members. It creates a string
   * which gets the size of the ArrayList of members from the file using the adapter
   * and then sets the text of the specific field to this value.
   */
  public void setNumberOfMembers()
  {
    String numberOfMembers = String.valueOf(adapter.getAllMembers().size());
    area1.setText(numberOfMembers);
  }

  /**
   * A method used for displaying the number of current Instructors. It sets the text
   * of the specific field with the size of the ArrayList of Instructors from the file
   * using the adapter.
   */
  public void setCurrentInstructors()
  {
    area2.setText(String.valueOf(adapter.getAllInstructors().size()));
  }

  /**
   * A method used for displaying the number of current Classes. It sets the text
   * of the specific field with the size of the ArrayList of Classes from the file
   * using the adapter.
   */
  public void setCurrentClasses()
  {
    area3.setText(String.valueOf(adapter.getAllClasses().size()));
  }

  /**
   * A method used for displaying current date. It sets the text of the specific
   * field by calling today method from the adapter.
   */
  public void setTodayDate()
  {
    dateLabel.setText(adapter.today());
  }

  /**
   * A method which loads the instructor pane. It sets the visibility of the other
   * panes to false except for the instructor and register instructor which are set to true.
   * Also, it sets the design for the navigation buttons.
   */
  //INSTRUCTORS PANE METHODS
  public void loadInstructorsPane()
  {
    screenSaverPane.setVisible(false);
    overviewPane.setVisible(false);
    instructorsPane.setVisible(true);
    registerInstructorPane.setVisible(true);
    loadRegisterInstructorPane();
    searchInstructorByNameButton.setVisible(false);
    searchInstructorByPhoneButton.setVisible(false);
    editInstructorPane.setVisible(false);
    membersPane.setVisible(false);
    classesPane.setVisible(false);
    schedulePane.setVisible(false);
    overviewButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    instructorsButton.setStyle(
        "-fx-background-color: #000037;-fx-font-size: 24px;fx-font-weight: bold;");
    membersButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    classesButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    scheduleButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
  }

  /**
   * A method which loads the pane for registering an instructor. It sets the visibility of
   * the other panes to false except for the one responsible with registering which is set to true.
   * Also, it sets the design for the navigation buttons.
   */
  public void loadRegisterInstructorPane()
  {
    registerInstructorPane.setVisible(true);
    findInstructorPane.setVisible(false);

    searchInstructorByNameButton.setVisible(false);
    searchInstructorByPhoneButton.setVisible(false);

    registerInstructorButton.setStyle(darkBgButton);
    findEditInstructorButton.setStyle(lightBgButton);
  }

  /**
   * A method which loads the pane for finding an instructor. It sets the visibility of
   * the other panes to false except for the one responsible for finding which is set to true.
   * Also, it sets the design for the navigation buttons.
   */
  public void loadFindInstructorPane()
  {
    registerInstructorPane.setVisible(false);
    findInstructorPane.setVisible(true);
    loadSearchInstructorByNamePane();
    searchInstructorByPhonePane.setVisible(false);
    editInstructorPane.setVisible(false);

    searchInstructorByNameButton.setVisible(true);
    searchInstructorByPhoneButton.setVisible(true);

    registerInstructorButton.setStyle(lightBgButton);
    findEditInstructorButton.setStyle(darkBgButton);
  }

  /**
   * A method which loads the searching pane for instructor using the name.
   * It sets the visibility of the other panes to false except for the one responsible
   * for searching which is set to true. Also, it sets the design for the navigation buttons.
   */
  public void loadSearchInstructorByNamePane()
  {
    searchInstructorByNamePane.setVisible(true);
    searchInstructorByPhonePane.setVisible(false);
    editInstructorPane.setVisible(false);

    searchInstructorByNameButton.setStyle(darkBgButton);
    searchInstructorByPhoneButton.setStyle(lightBgButton);
  }

  /**
   * A method which loads the searching pane for instructor using the phone number.
   * It sets the visibility of the other panes to false except for the one responsible
   * for searching which is set to true. Also, it sets the design for the navigation buttons.
   */
  public void loadSearchInstructorByPhonePane()
  {
    searchInstructorByNamePane.setVisible(false);
    searchInstructorByPhonePane.setVisible(true);
    editInstructorPane.setVisible(false);

    searchInstructorByNameButton.setStyle(lightBgButton);
    searchInstructorByPhoneButton.setStyle(darkBgButton);
  }

  /**
   * A method which loads the editing pane for instructor.
   * It sets the visibility of the other panes to false except for the one responsible
   * for editing which is set to true.
   */
  public void loadEditInstructorPane()
  {
    editInstructorPane.setVisible(true);
    searchInstructorByNamePane.setVisible(false);
    searchInstructorByPhonePane.setVisible(false);

    searchInstructorByNameButton.setVisible(false);
    searchInstructorByPhoneButton.setVisible(false);
  }

  /**
   * A method which loads the pane for members.
   * It sets the visibility of the other panes to false except for the member
   * which is set to true. Also, it sets the design for the navigation buttons.
   */
  //MEMBERS PANE METHODS
  public void loadMembersPane()
  {
    screenSaverPane.setVisible(false);
    overviewPane.setVisible(false);
    instructorsPane.setVisible(false);
    membersPane.setVisible(true);
    loadRegisterMemberPane();
    classesPane.setVisible(false);
    schedulePane.setVisible(false);
    overviewButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    instructorsButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    membersButton.setStyle(
        "-fx-background-color: #000037;-fx-font-size: 24px;fx-font-weight: bold;");
    classesButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    scheduleButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
  }

  /**
   * A method which loads the pane for registering a member. It sets the visibility of
   * the other panes to false except for the one responsible with registering which is set to true.
   * Also, it sets the design for the navigation buttons.
   */
  public void loadRegisterMemberPane()
  {
    registerMemberPane.setVisible(true);
    findMemberPane.setVisible(false);

    searchMemberByNameButton.setVisible(false);
    searchMemberByPhoneButton.setVisible(false);

    registerMemberButton.setStyle(darkBgButton);
    findEditMemberButton.setStyle(lightBgButton);
  }

  /**
   * A method which loads the pane for finding a member. It sets the visibility of
   * the other panes to false except for the one responsible for finding which is set to true.
   * Also, it sets the design for the navigation buttons.
   */
  public void loadFindMemberPane()
  {
    registerMemberPane.setVisible(false);
    findMemberPane.setVisible(true);
    loadSearchMemberByNamePane();
    searchMemberByPhonePane.setVisible(false);
    editMemberPane.setVisible(false);
    searchMemberByNameButton.setVisible(true);
    searchMemberByPhoneButton.setVisible(true);

    registerMemberButton.setStyle(lightBgButton);
    findEditMemberButton.setStyle(darkBgButton);
  }

  /**
   * A method which loads the searching pane for member using the name.
   * It sets the visibility of the other panes to false except for the one responsible
   * for searching which is set to true. Also, it sets the design for the navigation buttons.
   */
  public void loadSearchMemberByNamePane()
  {
    searchMemberByNamePane.setVisible(true);
    searchMemberByPhonePane.setVisible(false);
    editMemberPane.setVisible(false);

    searchMemberByNameButton.setStyle(darkBgButton);
    searchMemberByPhoneButton.setStyle(lightBgButton);
  }

  /**
   * A method which loads the searching pane for member using the phone number.
   * It sets the visibility of the other panes to false except for the one responsible
   * for searching which is set to true. Also, it sets the design for the navigation buttons.
   */
  public void loadSearchMemberByPhonePane()
  {
    searchMemberByNamePane.setVisible(false);
    searchMemberByPhonePane.setVisible(true);
    editMemberPane.setVisible(false);

    searchMemberByNameButton.setStyle(lightBgButton);
    searchMemberByPhoneButton.setStyle(darkBgButton);
  }

  /**
   * A method which loads the editing pane for member.
   * It sets the visibility of the other panes to false except for the one responsible
   * for editing which is set to true.
   */
  public void loadEditMemberPane()
  {
    editMemberPane.setVisible(true);
    searchMemberByNamePane.setVisible(false);
    searchMemberByPhonePane.setVisible(false);

    searchMemberByNameButton.setVisible(false);
    searchMemberByPhoneButton.setVisible(false);
  }

  /**
   * A method which loads the edit member pane.
   */
  public void searchMember()
  {
    loadEditMemberPane();
  }

  /**
   * A method which loads the pane for the fitness classes.
   * It sets the visibility of the other panes to false except for the one responsible
   * for the fitness classes which is set to true.
   * Also, it sets the design for the navigation buttons.
   */
  //CLASSES PANE METHODS
  public void loadClassesPane()
  {
    screenSaverPane.setVisible(false);
    overviewPane.setVisible(false);
    instructorsPane.setVisible(false);
    membersPane.setVisible(false);
    classesPane.setVisible(true);
    loadAddClassPane();
    schedulePane.setVisible(false);
    overviewButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    instructorsButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    membersButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    classesButton.setStyle(
        "-fx-background-color: #000037;-fx-font-size: 24px;fx-font-weight: bold;");
    scheduleButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
  }

  /**
   * A method which loads the pane for adding a fitness class. It sets the visibility of
   * the search pane to false and the one responsible with adding is set to true.
   * Also, it sets the design for the navigation buttons.
   */
  public void loadAddClassPane()
  {
    addClassPane.setVisible(true);
    searchClassPane.setVisible(false);

    addClassButton.setStyle(darkBgButton);
    findEditClassButton.setStyle(lightBgButton);
  }

  /**
   * A method which loads the pane for searching a fitness class. It sets the visibility of
   * the add pane to false and the one responsible with searching is set to true.
   * Also, it sets the design for the navigation buttons.
   */
  public void loadSearchClassPane()
  {
    addClassPane.setVisible(false);
    searchClassPane.setVisible(true);

    addClassButton.setStyle(lightBgButton);
    findEditClassButton.setStyle(darkBgButton);
  }

  /**
   * A method which loads the pane for scheduling a fitness class or displaying one.
   * It sets the visibility of the other panes to false except for the scheduling one
   * which is set to true. Also, it sets the design for the navigation buttons.
   * Additionally, clears all input fields and loads the ComboBox with the fitness classes
   * from the system so the user can choose which one to schedule.
   */
  //SCHEDULE PANE METHODS
  public void loadSchedulePane()
  {
    screenSaverPane.setVisible(false);
    overviewPane.setVisible(false);
    instructorsPane.setVisible(false);
    membersPane.setVisible(false);
    classesPane.setVisible(false);
    schedulePane.setVisible(true);
    loadScheduleClassPane();
    overviewButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    instructorsButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    membersButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    classesButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    scheduleButton.setStyle(
        "-fx-background-color: #000037;-fx-font-size: 24px;fx-font-weight: bold;");

    scheduleClassDateInput.setValue(null);
    scheduleClassHourInput.clear();
    scheduleClassMinuteInput.clear();
    scheduleClassDurationInput.clear();
    scheduleClassClassInput.getItems().clear();
    for (int i = 0; i < adapter.getAllClasses().size(); i++)
    {
      scheduleClassClassInput.getItems()
          .add(adapter.getAllClasses().get(i).getName());
    }

    scheduleClassInstructorInput.getItems().clear();
  }

  /**
   * A method which loads the pane for scheduling a fitness class.
   * It sets the visibility of the pane responsible for displaying to false and the one
   * responsible for scheduling is set to true.
   * Additionally, clears all input fields and loads the ComboBox with the fitness classes
   * from the system so the user can choose which one to schedule.
   */
  public void loadScheduleClassPane()
  {
    scheduleClassPane.setVisible(true);
    scheduleDisplayEditExportPane.setVisible(false);
    scheduleClassDateInput.setValue(null);
    scheduleClassHourInput.clear();
    scheduleClassMinuteInput.clear();
    scheduleClassDurationInput.clear();
    scheduleClassClassInput.getItems().clear();
    for (int i = 0; i < adapter.getAllClasses().size(); i++)
    {
      scheduleClassClassInput.getItems()
          .add(adapter.getAllClasses().get(i).getName());
    }
    scheduleClassInstructorInput.getItems().clear();

    scheduleClassButton.setStyle(darkBgButton);
    findEditScheduleButton.setStyle(lightBgButton);
  }

  /**
   * A method which loads the pane for displaying a scheduled fitness class.
   * It sets the visibility of the other panes to false except for the displaying one
   * which is set to true. Additionally, when the pane is loaded, another options
   * appear because a scheduled class can be edited after is selected.
   * Also, sets the design for the navigation buttons and clears all input fields.
   */
  public void loadScheduleDisplayEditExportPane()
  {
    scheduleClassPane.setVisible(false);
    scheduleDisplayEditExportPane.setVisible(true);
    scheduleDisplayPane.setVisible(true);
    scheduleEditPane.setVisible(false);
    scheduleRemovePane.setVisible(false);
    scheduleSignUpMemberPane.setVisible(false);
    scheduleCancelMemberPane.setVisible(false);
    scheduleExportPane.setVisible(false);
    scheduleLogoPane.setVisible(true);

    scheduleClassButton.setStyle(lightBgButton);
    findEditScheduleButton.setStyle(darkBgButton);
    editScheduledClassButton.setStyle(lightBgButton);
    removeScheduledClassPaneButton.setStyle(lightBgButton);
    signUpMemberScheduledClassButton.setStyle(lightBgButton);
    cancelMemberScheduledClassButton.setStyle(lightBgButton);
    exportScheduledClassButton.setStyle(lightBgButton);
    searchScheduledClassFromInput.setValue(null);
    searchScheduledClassToInput.setValue(null);
    searchScheduledClassListView.getItems().clear();
  }

  /**
   * A method which loads the pane for editing a scheduled fitness class.
   * It sets the visibility of the other panes to false except for the scheduling and
   * the one which is responsible for editing, those ones are set to true.
   * Also, sets the design for the navigation buttons and clears all input fields.
   */
  public void loadScheduleEditPane()
  {
    scheduleDisplayPane.setVisible(true);
    scheduleEditPane.setVisible(true);
    scheduleRemovePane.setVisible(false);
    scheduleSignUpMemberPane.setVisible(false);
    scheduleCancelMemberPane.setVisible(false);
    scheduleExportPane.setVisible(false);
    scheduleLogoPane.setVisible(false);

    editScheduledClassButton.setStyle(darkBgButton);
    removeScheduledClassPaneButton.setStyle(lightBgButton);
    signUpMemberScheduledClassButton.setStyle(lightBgButton);
    cancelMemberScheduledClassButton.setStyle(lightBgButton);
    exportScheduledClassButton.setStyle(lightBgButton);
    editScheduledClassHourInput.clear();
    editScheduledClassMinuteInput.clear();
    editScheduledClassClassInput.getItems().clear();
    editScheduledClassDurationInput.clear();
    editScheduledClassInstructorInput.getItems().clear();
    editScheduledClassDateInput.setValue(null);

  }

  /**
   * A method which loads the pane for removing a scheduled fitness class.
   * It sets the visibility of the other panes to false except for the scheduling and
   * the one which is responsible for removing, those ones are set to true.
   * Also, clears all input fields and sets the design for the navigation buttons.
   */
  public void loadScheduleRemovePane()
  {
    scheduleDisplayPane.setVisible(true);
    scheduleEditPane.setVisible(false);
    scheduleRemovePane.setVisible(true);
    scheduleSignUpMemberPane.setVisible(false);
    scheduleCancelMemberPane.setVisible(false);
    scheduleExportPane.setVisible(false);
    scheduleLogoPane.setVisible(false);
    scheduledClassDateOutput.clear();
    scheduledClassTimeOutput.clear();
    scheduledClassNameOutput.clear();
    scheduledClassInstructorOutput.clear();
    scheduledClassDurationOutput.clear();
    scheduledClassCapacityOutput.clear();

    editScheduledClassButton.setStyle(lightBgButton);
    removeScheduledClassPaneButton.setStyle(darkBgButton);
    signUpMemberScheduledClassButton.setStyle(lightBgButton);
    cancelMemberScheduledClassButton.setStyle(lightBgButton);
    exportScheduledClassButton.setStyle(lightBgButton);
  }

  /**
   * A method which loads the pane for signing up a member to a scheduled fitness class.
   * It sets the visibility of the other panes to false except for the scheduling and
   * the one which is responsible for signing up, those ones are set to true.
   * Also, sets the design for the navigation buttons.
   */
  public void loadScheduleSignUpMemberPane()
  {
    scheduleDisplayPane.setVisible(true);
    scheduleEditPane.setVisible(false);
    scheduleRemovePane.setVisible(false);
    scheduleSignUpMemberPane.setVisible(true);
    scheduleCancelMemberPane.setVisible(false);
    scheduleExportPane.setVisible(false);
    scheduleLogoPane.setVisible(false);

    editScheduledClassButton.setStyle(lightBgButton);
    removeScheduledClassPaneButton.setStyle(lightBgButton);
    signUpMemberScheduledClassButton.setStyle(darkBgButton);
    cancelMemberScheduledClassButton.setStyle(lightBgButton);
    exportScheduledClassButton.setStyle(lightBgButton);
  }

  /**
   * A method which loads the pane for canceling the appointment of a member to
   * a scheduled fitness class. It sets the visibility of the other panes to false except
   * for the scheduling and the one which is responsible for canceling, those ones
   * are set to true. Also, sets the design for the navigation buttons.
   */
  public void loadScheduleCancelMemberPane()
  {
    scheduleDisplayPane.setVisible(true);
    scheduleEditPane.setVisible(false);
    scheduleRemovePane.setVisible(false);
    scheduleSignUpMemberPane.setVisible(false);
    scheduleCancelMemberPane.setVisible(true);
    scheduleExportPane.setVisible(false);
    scheduleLogoPane.setVisible(false);

    editScheduledClassButton.setStyle(lightBgButton);
    removeScheduledClassPaneButton.setStyle(lightBgButton);
    signUpMemberScheduledClassButton.setStyle(lightBgButton);
    cancelMemberScheduledClassButton.setStyle(darkBgButton);
    exportScheduledClassButton.setStyle(lightBgButton);
  }

  /**
   * A method which loads the pane for exporting the scheduled fitness classes from a chosen month.
   * It sets the visibility of the other panes to false except for the one responsible
   * for exporting which is set to true. Also, sets the design for the navigation buttons,
   * clears the input fields and calls the method for loading the options in the ComboBox
   * responsible for choosing the month.
   */
  public void loadScheduleExportPane()
  {
    scheduleDisplayPane.setVisible(false);
    scheduleEditPane.setVisible(false);
    scheduleRemovePane.setVisible(false);
    scheduleSignUpMemberPane.setVisible(false);
    scheduleCancelMemberPane.setVisible(false);
    scheduleExportPane.setVisible(true);
    scheduleLogoPane.setVisible(false);

    editScheduledClassButton.setStyle(lightBgButton);
    removeScheduledClassPaneButton.setStyle(lightBgButton);
    signUpMemberScheduledClassButton.setStyle(lightBgButton);
    cancelMemberScheduledClassButton.setStyle(lightBgButton);
    exportScheduledClassButton.setStyle(darkBgButton);

    scheduleExportMonthInput.setValue(null);
    scheduleExportScheduleOutput.clear();
    scheduleExportYearInput.clear();
    loadMonths();
  }
  //------------------------------------Alert Panel-----------------------------------------------

  /**
   * A method which displays an alert warning message
   * @param message the message that is going to be displayed
   */
  public void messageWarning(String message)
  {
    Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
    alert.setContentText(message);
    alert.setHeaderText("Warning!");
    alert.setTitle(null);
    alert.showAndWait();
  }

  /**
   * A method which displays an alert error message
   * @param message the message that is going to be displayed
   */
  public void messageError(String message)
  {
    Alert alert = new Alert(Alert.AlertType.ERROR, "", ButtonType.OK);
    alert.setContentText(message);
    alert.setTitle(null);
    alert.setHeaderText("Error!");
    alert.showAndWait();
  }

  /**
   * A method which displays an alert message
   * @param message the message that is going to be displayed
   */
  public void messageNone(String message)
  {
    Alert alert = new Alert(Alert.AlertType.NONE, "", ButtonType.OK);
    alert.setContentText(message);
    alert.setHeaderText(null);
    alert.setTitle(null);
    alert.showAndWait();
  }

  /**
   * A method which displays an alert information message
   * @param message the message that is going to be displayed
   */
  public void messageInformation(String message)
  {
    Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.OK);
    alert.setContentText(message);
    alert.setHeaderText(null);
    alert.setTitle(null);
    alert.showAndWait();
  }

  /**
   * A method which displays an alert confirmation message
   * @param message the message that is going to be displayed
   * @param alertType the type of alert when the message is going to be displayed
   * @return true if the user confirms
   */
  public boolean messageConfirmation(String message, Alert.AlertType alertType)
  {
    Alert alert = new Alert(alertType, "", ButtonType.OK, ButtonType.CANCEL);
    alert.setContentText(message);
    alert.setTitle(null);
    alert.setHeaderText("Confirmation");
    alert.showAndWait();
    if (alert.getResult() == ButtonType.OK)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  //------------------------------------Instructor------------------------------------------------

  /**
   * A method which saves all the fitness classes about an instructor that he can hold.
   * The fitness classes are inserted  by the user in a text field. This method saves the
   * information until the data about instructor is saved.
   */
  public void mouseClickOnAdd()
  {
    instrAddClasses.add(registerInstructorClassInput.getText());
    registerInstructorClassInput.setText("");

  }

  /**
   * A method which is used to register an instructor. Gets the information inserted
   * by the user in the fields and store this specific data about the instructor in
   * the system. This is done by calling the saving method from the adapter which
   * saves the the information in a binary file. Finally, clears the fields and calls
   * again the method which displays the number of the instructors in the overview pane.
   */
  public void saveAndRegisterInstructor()
  {
    if (adapter.getInstructor(registerInstructorPhoneInput.getText()) == null)
    {
      Instructor tempInstructor = new Instructor(
          registerInstructorFirstNameInput.getText(),
          registerInstructorLastNameInput.getText(),
          registerInstructorAddressInput.getText(),
          registerInstructorEmailInput.getText(),
          registerInstructorPhoneInput.getText(), instrAddClasses);
      adapter.saveInstructors("Instructors.bin", tempInstructor);
      messageInformation("Instructor Added!");
      instrAddClasses.clear();
      registerInstructorFirstNameInput.setText("");
      registerInstructorLastNameInput.setText("");
      registerInstructorAddressInput.setText("");
      registerInstructorEmailInput.setText("");
      registerInstructorPhoneInput.setText("");
      setCurrentInstructors();
    }
    else
    {
      messageWarning("An instructor with this phone number already exists");
    }
  }

  /**
   * A method which searches an instructor using the first and last name. Firstly,
   * takes all the instructors from the binary file and then it loops once through
   * the list to check if the names matches. If the instructor is found an editing pane
   * is opened with the data about the instructor that can be changed. If the instructor
   * is not found an alert message is going to be displayed.
   */
  public void searchInstructorByName()
  {
    editInstructorClassesInput.getItems().clear();
    int ex = 0;
    for (int i = 0; i < adapter.getAllInstructors().size(); i++)
    {

      if (searchInstructorByNameFirstNameInput.getText()
          .equals(adapter.getAllInstructors().get(i).getFirstName())
          && searchInstructorByNameLastNameInput.getText()
          .equals(adapter.getAllInstructors().get(i).getLastName()))
      {
        instructorIndicator = i;
        ex = 1;
        editInstructorFirstNameInput
            .setText(adapter.getAllInstructors().get(i).getFirstName());
        editInstructorLastNameInput
            .setText(adapter.getAllInstructors().get(i).getLastName());
        editInstructorAddressInput
            .setText(adapter.getAllInstructors().get(i).getAddress());
        editInstructorEmailInput
            .setText(adapter.getAllInstructors().get(i).getEmail());
        editInstructorPhoneInput
            .setText(adapter.getAllInstructors().get(i).getPhoneNumber());
        for (int b = 0;
             b < adapter.getAllInstructors().get(i).getClasses().size(); b++)
        {
          editInstructorClassesInput.getItems()
              .add(adapter.getAllInstructors().get(i).getClasses().get(b));
        }
        loadEditInstructorPane();
        break;
      }

    }
    if (ex == 0)
    {
      messageWarning("Instructor not found!");
    }
    searchInstructorByNameFirstNameInput.clear();
    searchInstructorByNameLastNameInput.clear();
  }

  /**
   * A method which searches an instructor using the phone number. Firstly,
   * takes all the instructors from the binary file and then it loops once through
   * the list to check if the phone numbers matches. If the instructor is found an editing pane
   * is opened with the data about the instructor that can be changed. If the instructor
   * is not found an alert message is going to be displayed.
   */
  public void searchInstructorByPhoneNumber()
  {
    editInstructorClassesInput.getItems().clear();
    int ex = 0;
    for (int i = 0; i < adapter.getAllInstructors().size(); i++)
    {
      if (searchInstructorByPhoneInput.getText()
          .equals(adapter.getAllInstructors().get(i).getPhoneNumber()))
      {
        ex = 1;
        instructorIndicator = i;

        editInstructorFirstNameInput
            .setText(adapter.getAllInstructors().get(i).getFirstName());
        editInstructorLastNameInput
            .setText(adapter.getAllInstructors().get(i).getLastName());
        editInstructorAddressInput
            .setText(adapter.getAllInstructors().get(i).getAddress());
        editInstructorEmailInput
            .setText(adapter.getAllInstructors().get(i).getEmail());
        editInstructorPhoneInput
            .setText(adapter.getAllInstructors().get(i).getPhoneNumber());
        for (int b = 0;
             b < adapter.getAllInstructors().get(i).getClasses().size(); b++)
        {
          editInstructorClassesInput.getItems()
              .add(adapter.getAllInstructors().get(i).getClasses().get(b));
        }
        loadEditInstructorPane();
        break;
      }
    }
    if (ex == 0)
    {
      messageWarning("Instructor not found!");
    }
    searchInstructorByPhoneInput.clear();
  }

  /**
   * A method which can add more classes to an instructor when the user is editing
   * the data about him. Also, the method clears the input field and display the
   * fitness classes in the list view after the class is added.
   */
  public void addInstructorClassListView()
  {
    Instructor tempInstructor = adapter.getAllInstructors()
        .get(instructorIndicator);
    tempInstructor.getClasses().add(addClassToInstructorInput.getText());
    editInstructorClassesInput.getItems()
        .add(addClassToInstructorInput.getText());
    adapter
        .editInstructor("Instructors.bin", instructorIndicator, tempInstructor);
    addClassToInstructorInput.setText("");

  }

  /**
   * A method which can remove a class from an instructor when the user is editing
   * the data about him. Also the method clear the fields and displays the updated
   * list view of the fitness classes that the instructor can hold.
   */
  public void removeInstructorClassListView()
  {
    for (int i = 0;
         i < adapter.getAllInstructors().get(instructorIndicator).getClasses()
             .size(); i++)
    {
      if (addClassToInstructorInput.getText().equals(
          adapter.getAllInstructors().get(instructorIndicator).getClasses()
              .get(i)))
      {
        Instructor tempInstructor = adapter.getAllInstructors()
            .get(instructorIndicator);
        tempInstructor.getClasses().remove(i);

        adapter.editInstructor("Instructors.bin", instructorIndicator,
            tempInstructor);
        editInstructorClassesInput.getItems().remove(i);
        addClassToInstructorInput.setText("");
      }
    }
  }

  /**
   * A method which saves the data about an instructor after the user has made some
   * changes. Firstly, it displays a confirmation message and after that, if
   * the user confirms, the method gets all the inserted data from the fields and
   * makes the changes in the binary file by calling the editing method from adapter.
   * Also the method loads the searching pane and sets the number of the current
   * instructors from the overview pane.
   */
  public void saveEditedInstructor()
  {
    if (messageConfirmation("Do you want to save?",
        Alert.AlertType.CONFIRMATION))
    {
      Instructor tempInstructor = adapter.getAllInstructors()
          .get(instructorIndicator);
      tempInstructor.setFirstName(editInstructorFirstNameInput.getText());
      tempInstructor.setLastName(editInstructorLastNameInput.getText());
      tempInstructor.setAddress(editInstructorAddressInput.getText());
      tempInstructor.setEmail(editInstructorEmailInput.getText());
      tempInstructor.setPhoneNumber(editInstructorPhoneInput.getText());
      adapter.editInstructor("Instructors.bin", instructorIndicator,
          tempInstructor);

      loadFindInstructorPane();
      loadSearchInstructorByNamePane();
      setCurrentInstructors();

    }
  }

  /**
   * A method which removes a specific instructor from the system. Firstly, it displays
   * a confirmation message and after that, if the user confirms, the instructor is
   * removed from the system by calling the remove method from the adapter. Also all the fields
   * are cleared, the searching pane is loaded and the current number of instructors
   * is updated.
   */
  public void deleteInstructor()
  {
    if (messageConfirmation("Do you want to delete this instructor?",
        Alert.AlertType.WARNING))
    {
      adapter.removeInstructor("Instructors.bin",
          adapter.getAllInstructors().get(instructorIndicator));
      editInstructorFirstNameInput.setText("");
      editInstructorLastNameInput.setText("");
      editInstructorAddressInput.setText("");
      editInstructorEmailInput.setText("");
      editInstructorPhoneInput.setText("");
      editInstructorClassesInput.getItems().clear();
      loadFindInstructorPane();
      searchInstructorByNameFirstNameInput.setText("");
      searchInstructorByNameLastNameInput.setText("");
      loadSearchInstructorByNamePane();
      setCurrentInstructors();
    }
  }
  // -------------------------Members----------------------------------

  /**
   * A method which is used to register a member. Gets the information inserted
   * by the user in the fields and store this specific data about the member in
   * the system. This is done by calling the saving method from the adapter which
   * saves the the information in a binary file. Finally, clears the fields, calls
   * the method which displays the number of the members in the overview pane and
   * calls the method for displaying an alert message.
   */
  public void registerMember()
  {
    if (adapter.getMember(registerMemberPhoneInput.getText()) == null)
    {
      Member newMember = new Member(registerMemberFirstNameInput.getText(),
          registerMemberLastNameInput.getText(),
          registerMemberAddressInput.getText(),
          registerMemberEmailInput.getText(),
          registerMemberPhoneInput.getText());
      registerMemberFirstNameInput.clear();
      registerMemberLastNameInput.clear();
      registerMemberAddressInput.clear();
      registerMemberEmailInput.clear();
      registerMemberPhoneInput.clear();
      if (registerMemberMembershipInput.getValue().equals("Premium"))
      {
        newMember.upgradeMembership();
      }
      adapter.saveMembers("Members.bin", newMember);
      setNumberOfMembers();
      registerMemberMembershipInput.setValue(null);
      messageInformation("Member Added!");
    }
    else
    {
      messageWarning("A member with this phone number already exists");
    }

  }

  /**
   * A method which searches a member using the first and last name. Firstly,
   * takes all the members from the binary file and then it loops once through
   * the list to check if the names matches. If one member is found with this name,
   * an editing pane is opened with the data about the member that can be changed.
   * If more members with this name are found, the method is going to display an alert
   * message advising the user to search the member by phone number. If the member
   * is not found an alert message is going to be displayed.
   */
  public void searchMemberByName()
  {
    String firstName = searchMemberByNameFirstNameInput.getText();
    String lastName = searchMemberByNameLastNameInput.getText();
    ArrayList<Member> members = adapter.getAllMembers();

    int ok = 0;
    for (int i = 0; i < members.size(); i++)
    {
      if (members.get(i).getFirstName().equals(firstName) && members.get(i)
          .getLastName().equals(lastName))
      {
        ok++;
      }
    }

    int ex = 0;
    if (ok == 1)
    {
      for (int i = 0; i < members.size(); i++)
      {
        if (members.get(i).getFirstName().equals(firstName) && members.get(i)
            .getLastName().equals(lastName))
        {
          ex = 1;
          memberIndicator = i;
          searchMemberBy = true;
          editMemberFirstNameInput.setText(members.get(i).getFirstName());
          editMemberLastNameInput.setText(members.get(i).getLastName());
          editMemberAddressInput.setText(members.get(i).getAddress());
          editMemberEmailInput.setText(members.get(i).getEmail());
          editMemberPhoneInput.setText(members.get(i).getPhoneNumber());
          if (members.get(i).hasPremiumMembership())
          {
            editMemberMembershipInput.getSelectionModel().select("Premium");
          }
          else
          {
            editMemberMembershipInput.getSelectionModel().select("Standard");
          }
          loadEditMemberPane();
          break;
        }
      }
      if (ex == 0)
      {
        messageWarning("Member not found!");
      }
    }
    else
    {
      messageWarning(
          "More members with this name have been found.\n Try to search by phone number.");
    }
    searchMemberByNameFirstNameInput.clear();
    searchMemberByNameLastNameInput.clear();
  }

  /**
   * A method which searches a member using the phone number. Firstly,
   * takes all the members from the binary file and then it loops once through
   * the list to check if the phone numbers matches. If the member is found with this
   * phone number, an editing pane is opened with the data about the member that can be changed.
   * If the member is not found an alert message is going to be displayed.
   */
  public void searchMemberByPhoneNumber()
  {
    String phoneNumber = searchMemberByPhoneInput.getText();
    int ex = 0;
    ArrayList<Member> members = adapter.getAllMembers();
    for (int i = 0; i < members.size(); i++)
    {
      if (members.get(i).getPhoneNumber().equals(phoneNumber))
      {
        ex = 1;
        memberIndicator = i;
        searchMemberBy = false;
        editMemberFirstNameInput.setText(members.get(i).getFirstName());
        editMemberLastNameInput.setText(members.get(i).getLastName());
        editMemberAddressInput.setText(members.get(i).getAddress());
        editMemberEmailInput.setText(members.get(i).getEmail());
        editMemberPhoneInput.setText(members.get(i).getPhoneNumber());
        if (members.get(i).hasPremiumMembership())
        {
          editMemberMembershipInput.getSelectionModel().select("Premium");
        }
        else
        {
          editMemberMembershipInput.getSelectionModel().select("Standard");
        }
        loadEditMemberPane();
        break;
      }
    }
    if (ex == 0)
    {
      messageWarning("Member not found!");
    }
    searchMemberByPhoneInput.clear();
  }

  /**
   * A method which saves the data about a member after the user has made some
   * changes. Firstly, it displays a confirmation message and after that, if
   * the user confirms, the method gets all the inserted data from the fields and
   * makes the changes in the binary file by calling the editing method from adapter.
   * Also the method loads the searching pane that was used for finding the member
   * and sets the number of the current members from the overview pane.
   */
  public void saveMember()
  {
    if (messageConfirmation("Do you want to save?",
        Alert.AlertType.CONFIRMATION))
    {
      Member tempMember = adapter.getAllMembers().get(memberIndicator);
      tempMember.setFirstName(editMemberFirstNameInput.getText());
      tempMember.setLastName(editMemberLastNameInput.getText());
      tempMember.setAddress(editMemberAddressInput.getText());
      tempMember.setEmail(editMemberEmailInput.getText());
      tempMember.setPhoneNumber(editMemberPhoneInput.getText());
      if (editMemberMembershipInput.getValue().equals("Premium"))
      {
        tempMember.upgradeMembership();
      }
      else
      {
        tempMember.downgradeMembership();
      }

      adapter.editMember("Members.bin", memberIndicator, tempMember);
      setNumberOfMembers();
      if (searchMemberBy)
      {
        loadFindMemberPane();
        loadSearchMemberByNamePane();
        searchMemberByNameFirstNameInput.setText("");
        searchMemberByNameLastNameInput.setText("");
      }
      else
      {
        loadFindMemberPane();
        loadSearchMemberByPhonePane();
        searchMemberByPhoneInput.setText("");
      }
    }
  }

  /**
   * A method which removes a specific member from the system. Firstly, it displays
   * a confirmation message and after that, if the user confirms, the member is
   * removed from the system by calling the remove method from the adapter. Also,
   * the searching pane used for finding the member is loaded and the current number
   * of members is updated.
   */
  public void deleteMember()
  {
    if (messageConfirmation("Do you want to delete this member?",
        Alert.AlertType.WARNING))
    {
      adapter.removeMember("Members.bin",
          adapter.getAllMembers().get(memberIndicator));
      setNumberOfMembers();

      if (searchMemberBy)
      {
        loadFindMemberPane();
        loadSearchMemberByNamePane();
        searchMemberByNameFirstNameInput.setText("");
        searchMemberByNameLastNameInput.setText("");
      }
      else
      {
        loadFindMemberPane();
        loadSearchMemberByPhonePane();
        searchMemberByPhoneInput.setText("");
      }
    }
  }

  // -------------------------Classes----------------------------------

  /**
   * A method which is used for saving the data about a new fitness class. Firstly, the method
   * verifies if the user inserted the proper data and after that it gets the data
   * from the input fields and saves them in the system by calling the saving method
   * from the adapter. Also, clears all the fields and updated the number of the classes.
   */
  public void saveAddedClasses()
  {
    if (addClassCapacityInput.getText().matches("[0-9]+"))
    {
      Class tempClass = new Class("No Name", 0);
      tempClass.setName(addClassNameInput.getText());
      int a = Integer.parseInt(addClassCapacityInput.getText());
      tempClass.setMaxCapacity(a);
      adapter.saveClasses("Classes.bin", tempClass);
      setCurrentClasses();
      addClassNameInput.clear();
      addClassCapacityInput.clear();
    }
    else
    {
      messageWarning("Maximum capacity needs to be a number!");
    }
  }

  /**
   * A method which searches a fitness class using the name. It loops once through
   * the list to check if the names matches. If the class is found the editing pane
   * is opened and the data about the class is displayed. If the class is not found
   * an alert message is displayed.
   */
  public void searchClassesByName()
  {
    int ex = 0;
    for (int i = 0; i < adapter.getAllClasses().size(); i++)
    {
      if (searchClassNameInput.getText()
          .equals(adapter.getAllClasses().get(i).getName()))
      {
        ex = 1;
        classIndicator = i;
        ediClassNameInput.setText(adapter.getAllClasses().get(i).getName());
        editClassCapacityInput.setText(
            String.valueOf(adapter.getAllClasses().get(i).getMaxCapacity()));
      }
    }
    if (ex == 0)
    {
      messageWarning("Class not found!");
    }
  }

  /**
   * A method which saves the data about a fitness class after the user made some changes.
   * Firstly, it displays a confirmation message after that, if the user confirms,
   * the method gets the data from the fields and calls the editing method from the
   * adapter to save the changes. Also, updates the number of the current classes
   * by calling the method responsible for setting the number in the overview pane.
   */
  public void saveEditedClass()
  {
    if (messageConfirmation("Do you want to save?",
        Alert.AlertType.CONFIRMATION))
    {
      Class tempClass = new Class(ediClassNameInput.getText(),
          Integer.parseInt(editClassCapacityInput.getText()));
      adapter.editClass("Classes.bin", classIndicator, tempClass);
      setCurrentClasses();
    }
  }

  /**
   * A method which removes a fitness class from the system. Firstly, it displays a confirmation
   * message after that, if the user confirms, the method deletes the class by
   * calling the removing method from the adapter. Also the method updates the number
   * of the current classes and clear the fields.
   */
  public void removeClass()
  {
    if (messageConfirmation("Do you want to delete this class?",
        Alert.AlertType.WARNING))
    {
      adapter.removeClass("Classes.bin",
          adapter.getAllClasses().get(classIndicator));
      setCurrentClasses();
      ediClassNameInput.clear();
      editClassCapacityInput.clear();
      searchClassNameInput.clear();
    }
  }

  // -------------------------Schedule----------------------------------

  /**
   * A method which calls the comboBoxDependency method if the user selects a fitness
   * class otherwise the list of items in the ComboBox is cleared.
   */
  public void comboBoxClass()
  {
    if (scheduleClassClassInput.getSelectionModel().getSelectedItem() != null)
    {
      comboBoxDependency();
    }
    else
    {
      scheduleClassClassInput.getItems().clear();
    }
  }

  /**
   * A method which checks which instructors can hold the selected fitness
   * class and adds them to the ComboBox. Afterwards, the user can choose the
   * available instructors from that ComboBox.
   */
  public void comboBoxDependency()
  {
    scheduleClassInstructorInput.getItems().clear();
    String tempString = scheduleClassClassInput.getSelectionModel()
        .getSelectedItem();
    for (int i = 0; i < adapter.getAllInstructors().size(); i++)
    {
      if (adapter.getAllInstructors().get(i).hasClass(tempString))
      {
        String instrName = adapter.getAllInstructors().get(i).getFullName();
        if (!scheduleClassInstructorInput.getItems().contains(instrName))
        {
          scheduleClassInstructorInput.getItems()
              .add(adapter.getAllInstructors().get(i).getFullName());
        }
      }
    }

  }

  /**
   * A method which saves the data about a new scheduled fitness class.
   * Firstly, it checks if the user inserted a date, if a date is not inserted
   * the method will display an alert warning message. However, if the user inserts
   * a date then the method will take all the inserted values from the fields and
   * it is going to save them by calling the saving method from the adapter.
   */
  public void schedule()
  {
    if (scheduleClassDateInput.getValue() != null)
    {
      int test = -1;
      for (int i = 0; i < adapter.getAllInstructors().size(); i++)
      {
        if (adapter.getAllInstructors().get(i).getFullName().equals(
            scheduleClassInstructorInput.getSelectionModel().getSelectedItem()))
        {
          test = i;
        }
      }

      DateTime tempDateTime = new DateTime(0, 0, 0, 0, 0);
      tempDateTime
          .setMinute(Integer.parseInt(scheduleClassMinuteInput.getText()));
      tempDateTime.setHour(Integer.parseInt(scheduleClassHourInput.getText()));
      tempDateTime.setYear(scheduleClassDateInput.getValue().getYear());
      tempDateTime.setMonth(scheduleClassDateInput.getValue().getMonthValue());
      tempDateTime.setDay(scheduleClassDateInput.getValue().getDayOfMonth());
      Class tempClass = adapter.getAllClasses()
          .get(scheduleClassClassInput.getSelectionModel().getSelectedIndex());
      Instructor tempInstructor = adapter.getAllInstructors().get(test);

      ArrayList<Member> tempMembers = new ArrayList<Member>();

      ScheduledClass tempScheduledClass = new ScheduledClass(tempClass,
          tempInstructor, tempDateTime, tempMembers,
          Integer.parseInt(scheduleClassDurationInput.getText()));
      adapter.saveScheduleClasses("ScheduledClasses.bin", tempScheduledClass);

      messageInformation("Class Scheduled!");
      scheduleClassDateInput.setValue(null);
      scheduleClassHourInput.clear();
      scheduleClassMinuteInput.clear();
      scheduleClassDurationInput.clear();
      scheduleClassClassInput.getItems().clear();
      for (int i = 0; i < adapter.getAllClasses().size(); i++)
      {
        scheduleClassClassInput.getItems()
            .add(adapter.getAllClasses().get(i).getName());
      }
      scheduleClassInstructorInput.getItems().clear();
    }
    else
    {
      messageWarning("You did not enter a date!");
    }
  }

  /**
   * A method which searches and displays the scheduled fitness classes within a
   * time period chosen by the user. Firstly, the method clears the list view and
   * uses two DateTime objects with the values inserted by the user to search for
   * scheduled fitness classes in that time period. After that, the classes are
   * identified and displayed in the list view. Also, the method loads the edit
   * schedule pane.
   */
  public void searchForScheduledClasses()
  {
    searchScheduledClassListView.getItems().clear();
    DateTime tempDateTime = new DateTime(0, 0, 0, 0, 0);
    DateTime tempDateTime2 = new DateTime(0, 0, 0, 0, 0);
    tempDateTime.setYear(searchScheduledClassFromInput.getValue().getYear());
    tempDateTime
        .setMonth(searchScheduledClassFromInput.getValue().getMonthValue());
    tempDateTime
        .setDay(searchScheduledClassFromInput.getValue().getDayOfMonth());
    tempDateTime2.setYear(searchScheduledClassToInput.getValue().getYear());
    tempDateTime2
        .setMonth(searchScheduledClassToInput.getValue().getMonthValue());
    tempDateTime2
        .setDay(searchScheduledClassToInput.getValue().getDayOfMonth());
    ArrayList<ScheduledClass> tempScheduledClass = adapter
        .getScheduledClassesInTimeInterval(tempDateTime, tempDateTime2);
    for (int i = 0; i < tempScheduledClass.size(); i++)
    {
      searchScheduledClassListView.getItems().add(
          tempScheduledClass.get(i).getClassItem().getName() + ", "
              + tempScheduledClass.get(i).getDateTime());
    }
    loadScheduleEditPane();
  }


  /**
   * A method which fills the fields in the edit, remove, sign up and cancel attendance
   * panes when the user selects a scheduled fitness class from the list view.
   * Firstly, the method identifies the selected scheduled fitness class from
   * the list view and then fills the fields from the different panes with the
   * specific data required for that field.
   */
  public void editSchedule()
  {
    DateTime tempDateTime = new DateTime(0, 0, 0, 0, 0);
    DateTime tempDateTime2 = new DateTime(0, 0, 0, 0, 0);
    tempDateTime.setYear(searchScheduledClassFromInput.getValue().getYear());
    tempDateTime
        .setMonth(searchScheduledClassFromInput.getValue().getMonthValue());
    tempDateTime
        .setDay(searchScheduledClassFromInput.getValue().getDayOfMonth());
    tempDateTime2.setYear(searchScheduledClassToInput.getValue().getYear());
    tempDateTime2
        .setMonth(searchScheduledClassToInput.getValue().getMonthValue());
    tempDateTime2
        .setDay(searchScheduledClassToInput.getValue().getDayOfMonth());
    ArrayList<ScheduledClass> tempScheduledClass = adapter
        .getScheduledClassesInTimeInterval(tempDateTime, tempDateTime2);
    int index = searchScheduledClassListView.getSelectionModel()
        .getSelectedIndex();

    scheduledClassDateOutput
        .setText(tempScheduledClass.get(index).getDateTime().getDate());
    scheduledClassTimeOutput
        .setText(tempScheduledClass.get(index).getDateTime().getTime());
    scheduledClassNameOutput
        .setText(tempScheduledClass.get(index).getClassItem().getName());
    scheduledClassInstructorOutput
        .setText(tempScheduledClass.get(index).getInstructor().getFullName());
    scheduledClassDurationOutput
        .setText(String.valueOf(tempScheduledClass.get(index).getDuration()));
    scheduledClassCapacityOutput.setText(String.valueOf(
        tempScheduledClass.get(index).getClassItem().getMaxCapacity()));
    String membersOutput = "";
    for (int j = 0; j < tempScheduledClass.get(index).getMembers().size(); j++)
    {
      membersOutput += tempScheduledClass.get(index).getMembers().get(j) + "\n";
    }
    scheduledClassMembersOutput.setText(membersOutput);

    signUpScheduledClassPremiumMembersInput.getItems().clear();
    updatePremiumMembers();
    loadPremiumMembersForSignUp();

    cancelScheduledClassAttendingMemberInput.getItems().clear();
    loadMemberAttendanceList();

    LocalDate tempLocal = LocalDate
        .of(tempScheduledClass.get(index).getDateTime().getYear(),
            tempScheduledClass.get(index).getDateTime().getMonth(),
            tempScheduledClass.get(index).getDateTime().getDay());
    editScheduledClassDateInput.setValue(tempLocal);

    editScheduledClassHourInput.setText(
        String.valueOf(tempScheduledClass.get(index).getDateTime().getHour()));
    editScheduledClassMinuteInput.setText(String
        .valueOf(tempScheduledClass.get(index).getDateTime().getMinute()));
    editScheduledClassDurationInput
        .setText(String.valueOf(tempScheduledClass.get(index).getDuration()));

    //Classes
    for (int i = 0; i < adapter.getAllClasses().size(); i++)
    {
      if (!(editScheduledClassClassInput.getItems()
          .contains(adapter.getAllClasses().get(i).getName())))
      {
        editScheduledClassClassInput.getItems()
            .add(adapter.getAllClasses().get(i).getName());
      }

    }
    for (int b = 0; b < editScheduledClassClassInput.getItems().size(); b++)
    {
      if (editScheduledClassClassInput.getItems().get(b)
          .contains(tempScheduledClass.get(index).getClassItem().getName()))
      {
        editScheduledClassClassInput.getSelectionModel().select(b);
      }
    }
    //Instructor

    editScheduledClassInstructorInput.getItems().clear();
    String tempClass = editScheduledClassClassInput.getSelectionModel()
        .getSelectedItem();
    for (int c = 0; c < adapter.getAllInstructors().size(); c++)
    {
      if (adapter.getAllInstructors().get(c).hasClass(tempClass))
      {
        if (!editScheduledClassInstructorInput.getItems()
            .contains(adapter.getAllInstructors().get(c).getFullName()))
        {
          editScheduledClassInstructorInput.getItems()
              .add(adapter.getAllInstructors().get(c).getFullName());
        }
      }
    }
    for (int i = 0; i < tempScheduledClass.size(); i++)
    {
      for (int b = 0;
           b < editScheduledClassInstructorInput.getItems().size(); b++)
      {
        try
        {
          if (tempScheduledClass.get(index).getInstructor().getFullName()
              .equals(editScheduledClassInstructorInput.getItems().get(b)))
          {
            editScheduledClassInstructorInput.getSelectionModel().select(b);
            break;
          }
        }
        catch (NullPointerException e)
        {
          System.out.println("No instructor assigned");
        }
      }
      break;
    }

  }

  /**
   * A method which saves the scheduled fitness class after the user made some changes
   * at it. Firstly, the method identifies the selected scheduled fitness class from
   * the list view and then identifies its position in the system. Furthermore, gets
   * the data from the fields and saves the changes in the system by calling the
   * editing method from the adapter.
   */
  public void saveEditedScheduledClass()
  {
    DateTime tempDateTime = new DateTime(0, 0, 0, 0, 0);
    DateTime tempDateTime2 = new DateTime(0, 0, 0, 0, 0);
    tempDateTime.setYear(searchScheduledClassFromInput.getValue().getYear());
    tempDateTime
        .setMonth(searchScheduledClassFromInput.getValue().getMonthValue());
    tempDateTime
        .setDay(searchScheduledClassFromInput.getValue().getDayOfMonth());
    tempDateTime2.setYear(searchScheduledClassToInput.getValue().getYear());
    tempDateTime2
        .setMonth(searchScheduledClassToInput.getValue().getMonthValue());
    tempDateTime2
        .setDay(searchScheduledClassToInput.getValue().getDayOfMonth());

    ArrayList<ScheduledClass> tempScheduledClasses = adapter
        .getScheduledClassesInTimeInterval(tempDateTime, tempDateTime2);
    int index = searchScheduledClassListView.getSelectionModel()
        .getSelectedIndex();
    ScheduledClass tempScheduledClass = tempScheduledClasses.get(index);

    DateTime tempDate = new DateTime(1, 1, 1, 1, 1);
    tempDate.setDay(editScheduledClassDateInput.getValue().getDayOfMonth());
    tempDate.setMonth(editScheduledClassDateInput.getValue().getMonthValue());
    tempDate.setYear(editScheduledClassDateInput.getValue().getYear());
    tempDate.setHour(Integer.parseInt(editScheduledClassHourInput.getText()));
    tempDate
        .setMinute(Integer.parseInt(editScheduledClassMinuteInput.getText()));
    ArrayList<ScheduledClass> tempArray = adapter.getAllScheduledClasses();
    ScheduledClass tempScheduledClass2;
    for (int i = 0; i < tempArray.size(); i++)
    {
      if ((tempArray.get(i).getClassItem().getName())
          .equals(tempScheduledClass.getClassItem().getName()) && (tempArray
          .get(i).getDateTime()).equals(tempScheduledClass.getDateTime()))
      {
        index = i;
        break;
      }
    }
    Class tempClass = adapter.getAllClasses().get(
        editScheduledClassClassInput.getSelectionModel().getSelectedIndex());

    ArrayList<Instructor> tempInstructors = adapter.getAllInstructors();
    Instructor tempInstructor = null;
    String tempInstructorName = editScheduledClassInstructorInput
        .getSelectionModel().getSelectedItem();
    for (int j = 0; j < tempInstructors.size(); j++)
    {
      if (tempInstructors.get(j).getFullName().equals(tempInstructorName))
      {
        tempInstructor = tempInstructors.get(j);
        break;
      }
    }
    try
    {
      tempScheduledClass2 = new ScheduledClass(tempClass, tempInstructor,
          tempDate,
          Integer.parseInt(editScheduledClassDurationInput.getText()));
      adapter.editScheduledClasses("ScheduledClasses.bin", index,
          tempScheduledClass2);
    }
    catch (NullPointerException e)
    {
      System.out.println(
          "Instructor not found (is null), saveEditedScheduledClass method");
    }

    searchForScheduledClasses();
    editScheduledClassHourInput.clear();
    editScheduledClassMinuteInput.clear();
    editScheduledClassClassInput.getItems().clear();
    editScheduledClassDurationInput.clear();
    editScheduledClassInstructorInput.getItems().clear();
    editScheduledClassDateInput.setValue(null);
  }

  /**
   * A method which is used for removing a scheduled fitness class. Firstly, the
   * method identifies the selected class from the list view and then displays an
   * alert confirmation message. If the user confirms, the scheduled fitness class
   * is going to be removed by calling the removing method from adapter and fields
   * are going to be cleared. Also, the list view is loaded again to be updated.
   */
  public void removeScheduledClass()
  {
    DateTime tempDateTime = new DateTime(0, 0, 0, 0, 0);
    DateTime tempDateTime2 = new DateTime(0, 0, 0, 0, 0);
    tempDateTime.setYear(searchScheduledClassFromInput.getValue().getYear());
    tempDateTime
        .setMonth(searchScheduledClassFromInput.getValue().getMonthValue());
    tempDateTime
        .setDay(searchScheduledClassFromInput.getValue().getDayOfMonth());
    tempDateTime2.setYear(searchScheduledClassToInput.getValue().getYear());
    tempDateTime2
        .setMonth(searchScheduledClassToInput.getValue().getMonthValue());
    tempDateTime2
        .setDay(searchScheduledClassToInput.getValue().getDayOfMonth());

    ArrayList<ScheduledClass> tempScheduledClasses = adapter
        .getScheduledClassesInTimeInterval(tempDateTime, tempDateTime2);

    int index = searchScheduledClassListView.getSelectionModel()
        .getSelectedIndex();

    ScheduledClass tempScheduledClass = tempScheduledClasses.get(index);

    if (messageConfirmation(
        "Are you sure you want to remove this class from the schedule?",
        Alert.AlertType.CONFIRMATION))
    {
      adapter.removeScheduledClass("ScheduledClasses.bin", tempScheduledClass);
      scheduledClassDateOutput.clear();
      scheduledClassTimeOutput.clear();
      scheduledClassNameOutput.clear();
      scheduledClassInstructorOutput.clear();
      scheduledClassDurationOutput.clear();
      scheduledClassCapacityOutput.clear();
      searchForScheduledClasses();
    }
  }

  /**
   * A method which updates the list of premium members every time when it is called.
   * Gets all the members registered in the system and selects selects the ones with
   * premium membership to add them to the list of premium members. This list is used
   * for knowing which members can be signed up for scheduled fitness classes.
   */
  public void updatePremiumMembers()
  {
    ArrayList<Member> allMembers = adapter.getAllMembers();
    premiumMembers = new ArrayList<Member>();
    for (int i = 0; i < allMembers.size(); i++)
    {
      if (allMembers.get(i).hasPremiumMembership())
      {
        premiumMembers.add(allMembers.get(i));
      }
    }
  }

  /**
   * A method which loads the members with premium membership to the ComboBox for
   * the sign up pane. If a member has premium membership but is already assigned
   * to the selected class, the method will not load him to the ComboBox because
   * each member can be assigned just one time. Firstly, the method identifies the
   * selected class from the list view and then gets the list of the signed up
   * members. After that, the ones that have premium membership and are not already
   * assigned are loaded to the ComboBoc for the sign up pane.
   */
  public void loadPremiumMembersForSignUp()
  {
    DateTime tempDateTime = new DateTime(0, 0, 0, 0, 0);
    DateTime tempDateTime2 = new DateTime(0, 0, 0, 0, 0);
    tempDateTime.setYear(searchScheduledClassFromInput.getValue().getYear());
    tempDateTime
        .setMonth(searchScheduledClassFromInput.getValue().getMonthValue());
    tempDateTime
        .setDay(searchScheduledClassFromInput.getValue().getDayOfMonth());
    tempDateTime2.setYear(searchScheduledClassToInput.getValue().getYear());
    tempDateTime2
        .setMonth(searchScheduledClassToInput.getValue().getMonthValue());
    tempDateTime2
        .setDay(searchScheduledClassToInput.getValue().getDayOfMonth());
    ArrayList<ScheduledClass> tempScheduledClasses = adapter
        .getScheduledClassesInTimeInterval(tempDateTime, tempDateTime2);
    int index = searchScheduledClassListView.getSelectionModel()
        .getSelectedIndex();
    ScheduledClass tempScheduledClass = tempScheduledClasses.get(index);

    ArrayList<Member> memberList = tempScheduledClass.getMembers();

    if (memberList.size() > 0)
    {
      for (int j = 0; j < memberList.size(); j++)
      {
        premiumMembers.remove(memberList.get(j));
      }
    }

    for (int i = 0; i < premiumMembers.size(); i++)
    {
      signUpScheduledClassPremiumMembersInput.getItems()
          .add(premiumMembers.get(i));
    }

  }

  /**
   * A method which signs up a selected member to a selected scheduled fitness class.
   * Firstly, the method gets the selected member from the ComboBox and the selected
   * class from the list view. After that finds the position of the selected scheduled
   * fitness class in the system, adds the member to the list and saves the changes
   * by calling the editing method from the adapter. Also, clears the field in the end.
   */
  public void addPremiumMemberToScheduledClass()
  {
    Member tempMember = signUpScheduledClassPremiumMembersInput
        .getSelectionModel().getSelectedItem();

    DateTime tempDateTime = new DateTime(0, 0, 0, 0, 0);
    DateTime tempDateTime2 = new DateTime(0, 0, 0, 0, 0);
    tempDateTime.setYear(searchScheduledClassFromInput.getValue().getYear());
    tempDateTime
        .setMonth(searchScheduledClassFromInput.getValue().getMonthValue());
    tempDateTime
        .setDay(searchScheduledClassFromInput.getValue().getDayOfMonth());
    tempDateTime2.setYear(searchScheduledClassToInput.getValue().getYear());
    tempDateTime2
        .setMonth(searchScheduledClassToInput.getValue().getMonthValue());
    tempDateTime2
        .setDay(searchScheduledClassToInput.getValue().getDayOfMonth());
    ArrayList<ScheduledClass> tempScheduledClasses = adapter
        .getScheduledClassesInTimeInterval(tempDateTime, tempDateTime2);
    int index = searchScheduledClassListView.getSelectionModel()
        .getSelectedIndex();
    ScheduledClass tempScheduledClass = tempScheduledClasses.get(index);

    ArrayList<ScheduledClass> tempArray = adapter.getAllScheduledClasses();
    for (int i = 0; i < tempArray.size(); i++)
    {
      if ((tempArray.get(i).getClassItem().getName())
          .equals(tempScheduledClass.getClassItem().getName()) && (tempArray
          .get(i).getDateTime()).equals(tempScheduledClass.getDateTime()))
      {
        index = i;
        break;
      }
    }

    tempScheduledClass.addMember(tempMember);
    adapter.editScheduledClasses("ScheduledClasses.bin", index,
        tempScheduledClass);
    signUpScheduledClassPremiumMembersInput.setValue(null);
  }

  /**
   * A method which loads the members that have signed up for a selected class to
   * the ComboBox for the removing member's attendance pane. Firstly, the method
   * identifies the selected class from the list view and then gets the list of the
   * signed up members from the system an loads them to the ComboBox.
   */
  public void loadMemberAttendanceList()
  {
    DateTime tempDateTime = new DateTime(0, 0, 0, 0, 0);
    DateTime tempDateTime2 = new DateTime(0, 0, 0, 0, 0);
    tempDateTime.setYear(searchScheduledClassFromInput.getValue().getYear());
    tempDateTime
        .setMonth(searchScheduledClassFromInput.getValue().getMonthValue());
    tempDateTime
        .setDay(searchScheduledClassFromInput.getValue().getDayOfMonth());
    tempDateTime2.setYear(searchScheduledClassToInput.getValue().getYear());
    tempDateTime2
        .setMonth(searchScheduledClassToInput.getValue().getMonthValue());
    tempDateTime2
        .setDay(searchScheduledClassToInput.getValue().getDayOfMonth());
    ArrayList<ScheduledClass> tempScheduledClasses = adapter
        .getScheduledClassesInTimeInterval(tempDateTime, tempDateTime2);
    int index = searchScheduledClassListView.getSelectionModel()
        .getSelectedIndex();
    ScheduledClass tempScheduledClass = tempScheduledClasses.get(index);

    ArrayList<Member> memberList = tempScheduledClass.getMembers();
    for (int j = 0; j < memberList.size(); j++)
    {
      cancelScheduledClassAttendingMemberInput.getItems()
          .add(memberList.get(j));
    }
  }

  /**
   * A method which removes a member's attendance at a fitness class. Firstly, the method
   * identifies the selected class from the list view and then it loops through the
   * list of all scheduled classes to identify its position in the system. After that,
   * the member is removed by calling the removing method from the ScheduledClass class
   * and then the class is saved in the system by calling the editing method from the adapter.
   * Also, at the end of the method the field is cleared.
   */
  public void cancelMemberAttendance()
  {
    DateTime tempDateTime = new DateTime(0, 0, 0, 0, 0);
    DateTime tempDateTime2 = new DateTime(0, 0, 0, 0, 0);
    tempDateTime.setYear(searchScheduledClassFromInput.getValue().getYear());
    tempDateTime
        .setMonth(searchScheduledClassFromInput.getValue().getMonthValue());
    tempDateTime
        .setDay(searchScheduledClassFromInput.getValue().getDayOfMonth());
    tempDateTime2.setYear(searchScheduledClassToInput.getValue().getYear());
    tempDateTime2
        .setMonth(searchScheduledClassToInput.getValue().getMonthValue());
    tempDateTime2
        .setDay(searchScheduledClassToInput.getValue().getDayOfMonth());

    ArrayList<ScheduledClass> tempScheduledClasses = adapter
        .getScheduledClassesInTimeInterval(tempDateTime, tempDateTime2);

    int index = searchScheduledClassListView.getSelectionModel().getSelectedIndex();

    ScheduledClass tempScheduledClass = tempScheduledClasses.get(index);

    ArrayList<ScheduledClass> tempArray = adapter.getAllScheduledClasses();

    for (int i = 0; i < tempArray.size(); i++)
    {
      if (((tempArray.get(i).getClassItem().getName())
          .equals(tempScheduledClass.getClassItem().getName())) && ((tempArray
          .get(i).getDateTime()).equals(tempScheduledClass.getDateTime())))
      {
        index = i;
        break;
      }
    }
    Member tempMember = cancelScheduledClassAttendingMemberInput
        .getSelectionModel().getSelectedItem();
    tempScheduledClass.removeMember(tempMember);
    adapter.editScheduledClasses("ScheduledClasses.bin", index,
        tempScheduledClass);
    cancelScheduledClassAttendingMemberInput.setValue(null);
  }

  //--------------------------------------------------------------------------------------------

  /**
   * A method which loads the ComboBox from the export pane with the month of the year.
   * Firstly adds all the months in an ArrayList of type String and then loads each element
   * to the ComboBox.
   */
  public void loadMonths()
  {
    months = new ArrayList<String>();
    months.add("January");
    months.add("February");
    months.add("March");
    months.add("April");
    months.add("May");
    months.add("June");
    months.add("July");
    months.add("August");
    months.add("September");
    months.add("October");
    months.add("November");
    months.add("December");
    for (int i = 0; i < months.size(); i++)
    {
      scheduleExportMonthInput.getItems().add(months.get(i));
    }
  }

  /**
   * A method which displays the scheduled fitness classes from a chosen month of
   * a year in a text area for the user. Firstly, the method gets the inserted month and
   * year from the fields and then calls the method from the DateTime which returns
   * the last they of that month. Furthermore, it gets all the scheduled fitness
   * classes from that time period and assembles the data in a string variable which
   * is displayed in the text area of the user interface.
   */
  public void getSchedule()
  {
    String month = scheduleExportMonthInput.getSelectionModel()
        .getSelectedItem();
    int year = Integer.parseInt(scheduleExportYearInput.getText());
    int c = 0;
    for (int i = 0; i < months.size(); i++)
    {
      if (month.equals(months.get(i)))
      {
        c = i;
        break;
      }
    }
    int lastDay = DateTime.lastDayOfTheMonth(c + 1, year);
    ArrayList<ScheduledClass> tempScheduledClasses = adapter
        .getAllScheduledClasses();
    String returnScheduledClasses = "";
    DateTime tempDateTime;
    for (int j = 1; j <= lastDay; j++)
    {
      tempDateTime = new DateTime(j, c + 1, year, 0, 0);
      for (int i = 0; i < tempScheduledClasses.size(); i++)
      {
        if (tempDateTime.equalsDate(tempScheduledClasses.get(i).getDateTime()))
        {
          returnScheduledClasses +=
              tempScheduledClasses.get(i).getClassItem().getName() + ", "
                  + tempScheduledClasses.get(i).getDateTime() + ", with "
                  + tempScheduledClasses.get(i).getInstructor().getFullName()
                  + "\n";
        }
      }
    }
    scheduleExportScheduleOutput.setText(returnScheduledClasses);
  }

  // Exporting to xml

  /**
   * A method which exports the scheduled classes from a chosen month and year
   * to a file with an XML format. Firstly, the method gets the inserted month and
   * year from the fields and then calls the method from the DateTime which returns
   * the last they of that month. Furthermore, it gets all the scheduled fitness
   * classes from that time period and assembles the data in a string variable with
   * an XML format. The string variable is exported to the file by calling the
   * method from adapter.
   */
  public void exportToXml()
  {
    ArrayList<ScheduledClass> scheduledClasses = new ArrayList<ScheduledClass>();
    String month = scheduleExportMonthInput.getSelectionModel()
        .getSelectedItem();
    int year = Integer.parseInt(scheduleExportYearInput.getText());
    int c = 0;
    for (int i = 0; i < months.size(); i++)
    {
      if (month.equals(months.get(i)))
      {
        c = i;
        break;
      }
    }
    int lastDay = DateTime.lastDayOfTheMonth(c + 1, year);
    ArrayList<ScheduledClass> tempScheduledClasses = adapter
        .getAllScheduledClasses();
    DateTime tempDateTime;
    for (int j = 1; j <= lastDay; j++)
    {
      tempDateTime = new DateTime(j, c + 1, year, 0, 0);
      for (int i = 0; i < tempScheduledClasses.size(); i++)
      {
        if (tempDateTime.equalsDate(tempScheduledClasses.get(i).getDateTime()))
        {
          scheduledClasses.add(tempScheduledClasses.get(i));
        }
      }
    }

    MyTextFileIO textFileIO = new MyTextFileIO();
    String xmlFile = "scheduleExport.xml";
    String stringToAppend = "";
    try
    {
      textFileIO
          .writeToFile(xmlFile, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
      textFileIO.writeToFile(xmlFile, "<schedule>");
      for (ScheduledClass scheduledClass : scheduledClasses)
      {
        stringToAppend +=
            "<scheduledClass>" + "<class>" + "<name>" + scheduledClass
                .getClassItem().getName() + "</name>" + "</class>" + "<instructor>" + "<firstName>" + scheduledClass
                .getInstructor().getFirstName() + "</firstName>" + "</instructor>" + "<date>" + "<day>" + scheduledClass
                .getDateTime().getDay() + "</day>" + "<month>" + scheduledClass
                .getDateTime().getMonth() + "</month>" + "</date>" + "<time>"
                + "<hour>" + scheduledClass.getDateTime().displayHour()
                + "</hour>" + "<minute>" + scheduledClass.getDateTime()
                .displayMinute() + "</minute>" + "</time>"
                + "</scheduledClass>";
      }
      textFileIO.appendToFile(xmlFile, stringToAppend);
      textFileIO.appendToFile(xmlFile, "</schedule>");
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found.");
      System.exit(1);
    }
    scheduleExportMonthInput.setValue(null);
    scheduleExportScheduleOutput.clear();
    scheduleExportYearInput.clear();
    loadMonths();
  }
}



