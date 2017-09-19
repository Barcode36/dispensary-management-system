package com.employeemanagement.controllers;

import com.EntityClasses.*;
import com.common.SessionListener;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import org.controlsfx.control.Notifications;
import org.hibernate.Session;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by gayashan on 8/13/2017.
 */

@SuppressWarnings("Duplicates")
public class ViewDoctorController implements Initializable,SessionListener{



    @FXML
    private JFXTextField empID;

    @FXML
    private JFXDatePicker dateOfAppointment;


    @FXML
    private Circle empImage;

    @FXML
    private JFXTextField fullName;

    @FXML
    private JFXDatePicker dob;

    @FXML
    private JFXTextField nic;

    @FXML
    private JFXTextField contactNumber;

    @FXML
    private JFXRadioButton male;

    @FXML
    private JFXRadioButton female;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField unitNo;

    @FXML
    private JFXTextField streetAddress;

    @FXML
    private JFXTextField city;

    @FXML
    private JFXTextField zip;

    @FXML
    private TreeTableView<PreviousEmployment> priviousEmployementTable;

    @FXML
    private TreeTableColumn<PreviousEmployment, String> colcompany;

    @FXML
    private TreeTableColumn<PreviousEmployment, String> coljobTitle;

    @FXML
    private JFXTextField company;

    @FXML
    private JFXTextField jobTitle;

    @FXML
    private JFXDatePicker jobFrom;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXTextField supervisor;

    @FXML
    private JFXTextField startingSalary;

    @FXML
    private JFXTextField endingSalary;

    @FXML
    private JFXDatePicker jobTo;

    @FXML
    private JFXTextField companyAddress;

    @FXML
    private TreeTableView<Education> SchoolTable;

    @FXML
    private TreeTableColumn<Education, String> colSchoolName;

    @FXML
    private TreeTableColumn<Education, String> colSchoolAddress;

    @FXML
    private JFXTextField schoolName;

    @FXML
    private JFXRadioButton yes;

    @FXML
    private JFXRadioButton no;

    @FXML
    private JFXDatePicker schoolFrom;

    @FXML
    private JFXTextField schoolPhone;

    @FXML
    private JFXDatePicker schoolTo;

    @FXML
    private JFXTextField schoolAddress;

    @FXML
    private JFXTextField slmcRegNumber;

    @FXML
    private JFXTextField chargePerVisit;

    private Session session;

    private final ToggleGroup genderGroup = new ToggleGroup();
    private final ToggleGroup yesNOGroup = new ToggleGroup();

    private FileChooser fileChooser ;
    private Image empimage =null;
    private List<TreeItem<PreviousEmployment>> previouEmploymentList;
    private List<TreeItem<Education>> educationHistory;
    private BufferedImage employeeBufferedImage;

    private MainScreenController mainController;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initMainComponents();

        //Initialize Table Previous Employment
        initTables();




    }


    @FXML
    void addEducationHistory(ActionEvent event) {


        Education education = new Education();
        education.setSchoolName(schoolName.getText());
        education.setAddress(schoolAddress.getText());
        education.setPhone(schoolPhone.getText());
        education.setFromDate(Date.valueOf(schoolFrom.getValue()));
        education.setToDate(Date.valueOf(schoolTo.getValue()));
        if(yes.isSelected()) {
            education.setIsGraduated("Y");
        }else {
            education.setIsGraduated("N");
        }



        educationHistory.add(new TreeItem<>(education));

        SchoolTable.getRoot().getChildren().clear();
        SchoolTable.getRoot().getChildren().addAll(educationHistory);


    }



    @FXML
    void addPreviousEmployment(ActionEvent event) {
        PreviousEmployment emplymemt = new PreviousEmployment();
        emplymemt.setCompany(company.getText());
        emplymemt.setAddress(companyAddress.getText());
        emplymemt.setJobTitle(jobTitle.getText());
        emplymemt.setPhone(phone.getText());
        emplymemt.setSupervisor(supervisor.getText());
        emplymemt.setFromDate(Date.valueOf(jobFrom.getValue()));
        emplymemt.setToDate(Date.valueOf(jobTo.getValue()));

        previouEmploymentList.add(new TreeItem<>(emplymemt));

        priviousEmployementTable.getRoot().getChildren().clear();
        priviousEmployementTable.getRoot().getChildren().addAll(previouEmploymentList);
    }





    @FXML
    void uplodePhoto(ActionEvent event) {
//        fileChooser.setTitle("Select Employee Image");
//
//
//
//
////        fileChooser.getExtensionFilters().addAll(
////
////                new FileChooser.ExtensionFilter("JPEG Files", "*.jpg"));
//
//
//
//        File selectedFile = fileChooser.showOpenDialog(null);
//
//
//        try {
//
//            empimage = new Image(selectedFile.toURI().toString());
//            empImage.setFill(new ImagePattern(empimage));
//            employeeBufferedImage = ImageIO.read(selectedFile);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }


    }

    @FXML
    void UpdatePreviousEmployment(ActionEvent event) {

        TreeItem<PreviousEmployment> employment = priviousEmployementTable.getSelectionModel().getSelectedItem();
//        previouEmploymentList.remove(employment);
        employment.getValue().setCompany(company.getText());
        employment.getValue().setAddress(companyAddress.getText());
        employment.getValue().setJobTitle(jobTitle.getText());
        employment.getValue().setPhone(phone.getText());
        employment.getValue().setSupervisor(supervisor.getText());
        employment.getValue().setFromDate(Date.valueOf(jobFrom.getValue()));
        employment.getValue().setToDate(Date.valueOf(jobTo.getValue()));

//        previouEmploymentList.add(employment);


        priviousEmployementTable.getRoot().getChildren().clear();
        priviousEmployementTable.getRoot().getChildren().addAll(previouEmploymentList);
    }



    @FXML
    void RemovePreviousEmployment(ActionEvent event) {

//        PreviousEmployment employment = priviousEmployementTable.getSelectionModel().getSelectedItem().getValue();
        previouEmploymentList.remove(priviousEmployementTable.getSelectionModel().getSelectedItem());

        priviousEmployementTable.getRoot().getChildren().clear();
        priviousEmployementTable.getRoot().getChildren().addAll(previouEmploymentList);


    }



    @FXML
    void removeEducationHistory(ActionEvent event) {

        educationHistory.remove(SchoolTable.getSelectionModel().getSelectedItem());

        SchoolTable.getRoot().getChildren().clear();
        SchoolTable.getRoot().getChildren().addAll(educationHistory);

    }

    @FXML
    void updateEducationHistory(ActionEvent event) {

        TreeItem<Education> item = SchoolTable.getSelectionModel().getSelectedItem();

        item.getValue().setSchoolName(schoolName.getText());
        item.getValue().setAddress(schoolAddress.getText());
        item.getValue().setPhone(schoolPhone.getText());
        item.getValue().setFromDate(Date.valueOf(schoolFrom.getValue()));
        item.getValue().setToDate(Date.valueOf(schoolTo.getValue()));
        if(yes.isSelected()) {
            item.getValue().setIsGraduated("Y");
        }else {
            item.getValue().setIsGraduated("N");
        }


        SchoolTable.getRoot().getChildren().clear();
        SchoolTable.getRoot().getChildren().addAll(educationHistory);
    }

    @FXML
    void previousEmployementTableSelections(MouseEvent event) {

        PreviousEmployment employment = priviousEmployementTable.getSelectionModel().getSelectedItem().getValue();
        company.setText(employment.getCompany());
        jobTitle.setText(employment.getJobTitle());
        companyAddress.setText(employment.getAddress());
        phone.setText(employment.getPhone());
        supervisor.setText(employment.getSupervisor());
        startingSalary.setText(String.valueOf(employment.getStartingSalary()));
        endingSalary.setText(String.valueOf(employment.getEndingSalary()));
        jobFrom.setUserData(employment.getFromDate().toLocalDate());
        jobTo.setUserData(employment.getToDate().toLocalDate());


    }

    @FXML

    void educationTableSelection(MouseEvent event) {
        Education education = SchoolTable.getSelectionModel().getSelectedItem().getValue();


        schoolName.setText(education.getSchoolName());
        schoolAddress.setText(education.getAddress());
        schoolPhone.setText(education.getPhone());
        schoolFrom.setValue(education.getFromDate().toLocalDate());
        schoolTo.setValue(education.getFromDate().toLocalDate());


    }

    private void initTables(){

        colcompany.setCellValueFactory(param -> param.getValue().getValue().companyProperty());
        coljobTitle.setCellValueFactory(param -> param.getValue().getValue().jobTitleProperty());

        PreviousEmployment employment = new PreviousEmployment();
        employment.setCompany("company");
        employment.setJobTitle("Job Title");
        TreeItem<PreviousEmployment> root1 = new TreeItem<>();

        priviousEmployementTable.setRoot(root1);
        priviousEmployementTable.setShowRoot(false);


        colSchoolName.setCellValueFactory(param -> param.getValue().getValue().schoolNameProperty());
        colSchoolAddress.setCellValueFactory(param -> param.getValue().getValue().addressProperty());

        Education education = new Education();
        education.setSchoolName("School Name");
        education.setAddress("Address");
        TreeItem<Education> root2 = new TreeItem<>();

        SchoolTable.setRoot(root2);
        SchoolTable.setShowRoot(false);

    }

    private void initMainComponents(){
        fileChooser = new FileChooser();
        empImage.setFill(new ImagePattern(new Image("/com/Images/user1600.png")));
        previouEmploymentList = new ArrayList<>();
        educationHistory = new ArrayList<>();
        male.setToggleGroup(genderGroup);
        female.setToggleGroup(genderGroup);

        yes.setToggleGroup(yesNOGroup);
        no.setToggleGroup(yesNOGroup);

//        new Thread(() ->
//        {
//            Platform.runLater(() -> session = UserSession.getSession());
//        }).start();


    }


    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void setMainController(SessionListener controller) {
        this.mainController = (MainScreenController) controller;
        setData();
    }

    private void setData(){

       Doctor doctor = (Doctor)mainController.getEmployee();
        empID.setText(String.valueOf(doctor.getEmployeeid()));
        fullName.setText(doctor.getName());
        //dateOfAppointment.setValue(doctor.getDateOfAppointment().toLocalDate());
        employeeBufferedImage=doctor.getImage();
        email.setText(doctor.getName());
        dob.setValue(doctor.getDateOfBirth().toLocalDate());
        contactNumber.setText(doctor.getContactNumber());
        slmcRegNumber.setText(doctor.getSLMCRegNO());
        chargePerVisit.setText(String.valueOf(doctor.getChargePerVisit()));
        unitNo.setText(doctor.getAddress().getUnitNO());

        streetAddress.setText(doctor.getAddress().getStreetAddress());
        city.setText(doctor.getAddress().getCity());
        zip.setText(doctor.getAddress().getZip());

        if(employeeBufferedImage==null){
            System.out.println("Null");
        }
      //  empImage.setFill(new ImagePattern(SwingFXUtils.toFXImage(employeeBufferedImage, null )));
//SwingFXUtils.toFXImage(tempCard, null )


        for(PreviousEmployment employment: doctor.getPreviousEmploymentList()) {
            previouEmploymentList.add(new TreeItem<>(employment));
        }
        priviousEmployementTable.getRoot().getChildren().clear();
        priviousEmployementTable.getRoot().getChildren().addAll(previouEmploymentList);


        for(Education e:doctor.getEducationList()){
            educationHistory.add(new TreeItem<>(e));
        }

        SchoolTable.getRoot().getChildren().clear();
        SchoolTable.getRoot().getChildren().addAll(educationHistory);

//        Staff s = new Staff();
//
//        for ( TreeItem<PreviousEmployment> p: previouEmploymentList
//                ) {
//
//            s.getPreviousEmploymentList().add(p.getValue());
//        }
//
//        s.setName(fullName.getText());
//        s.setDateOfAppointment(Date.valueOf(dateOfAppointment.getValue()));
//        s.setEmployeeid(Integer.parseInt(empID.getText()));
//        s.setImage(employeeBufferedImage);
//        s.setEmail(email.getText());
//        s.setDateOfBirth(Date.valueOf(dob.getValue()));
//        s.setContactNumber(contactNumber.getText());
//        s.setJobRole(jobRole.getText());
//        if(male.isSelected()) {
//            s.setGender("M");
//        }else {
//            s.setGender("F");
//        }
//
//        for ( TreeItem<Education> e: educationHistory
//                ) {
//
//            s.getEducationList().add(e.getValue());
//        }
//
//        Address address = new Address();
//        address.setUnitNO(unitNo.getText());
//        address.setStreetAddress(streetAddress.getText());
//        address.setCity(city.getText());
//        address.setZip(zip.getText());
//
//        s.setAddress(address);
    }




    @FXML
    void addNewStaff(ActionEvent event) {

        Doctor doctor = new Doctor();

        for ( TreeItem<PreviousEmployment> p: previouEmploymentList
                ) {

            doctor.getPreviousEmploymentList().add(p.getValue());
        }

        doctor.setName(fullName.getText());
        //doctor.setDateOfAppointment(Date.valueOf(dateOfAppointment.getValue()));
        doctor.setEmployeeid(Integer.parseInt(empID.getText()));
        doctor.setImage(employeeBufferedImage);
        doctor.setEmail(email.getText());
        doctor.setDateOfBirth(Date.valueOf(dob.getValue()));
        doctor.setContactNumber(contactNumber.getText());
        doctor.setChargePerVisit(Double.parseDouble(chargePerVisit.getText()));
        doctor.setSLMCRegNO(slmcRegNumber.getText());
        doctor.setNic(nic.getText());

        if(male.isSelected()) {
            doctor.setGender("M");
        }else {
            doctor.setGender("F");
        }

        for ( TreeItem<Education> e: educationHistory
                ) {

            doctor.getEducationList().add(e.getValue());
        }

        Address address = new Address();
        address.setUnitNO(unitNo.getText());
        address.setStreetAddress(streetAddress.getText());
        address.setCity(city.getText());
        address.setZip(zip.getText());

        doctor.setAddress(address);

        new Thread(() ->
        {


            try {
                session.beginTransaction();
                session.update(doctor);
                session.getTransaction().commit();

                Platform.runLater(() ->  Notifications.create()
                        .title("Updated")
                        .text("successfully Updated the Database")
                        .showInformation());
            }catch (Exception e){

                Platform.runLater(() ->  Notifications.create()
                        .title("Error Inserting Data")
                        .text("please check and try to insert again")
                        .darkStyle()
                        .showError());


            }
        }).start();

    }



}