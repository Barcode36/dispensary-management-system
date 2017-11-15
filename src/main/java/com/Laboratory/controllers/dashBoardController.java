package com.Laboratory.controllers;

import com.common.ControlledScreen;
import com.common.ScreenController;
import com.common.SessionListener;
import com.employeemanagement.controllers.MyScreens;
import com.jfoenix.controls.JFXButton;
import com.main.controllers.MainScreenController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import org.hibernate.Session;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by AmilaWC on 8/19/2017.
 */
public class dashBoardController implements Initializable,SessionListener {



    private Session session;
    private homeController MainScreenController;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        session = ScreenController.getSession();
    }

//    @Override
//    public void setScreenParent(ScreenController screenParent) {
//        this.controller = screenParent;
//    }

    ScreenController controller;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void setMainController(SessionListener controller) {

        this.MainScreenController = (homeController) controller;


    }
//
//    @FXML
//    private JFXButton dashBoardBtn;
//
//    @FXML
//    private JFXButton addEmployeeBtn;



//    @Override
//    public void setScreenParent(ScreenController screenParent) {
//        controller = screenParent;
//
//    }

//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//    }

//    @FXML
//    void changePanel(MouseEvent event) {
//        switch (((JFXButton) event.getSource()).getId()){
//            case "dashboardBT":
//
//                break;
//            case "ordertestBT":
//                ScreenController.changeScreen(controller, LabScreens.DASHBOARD_SCREEN, LabScreens.ORDERTEST_SCREEN);
//                break;
//            case "enter_resultBT":
//                ScreenController.changeScreen(controller, LabScreens.DASHBOARD_SCREEN, LabScreens.ENTERRESULTS_SCREEN);
//                break;
//            case "viewDB_BT":
//                ScreenController.changeScreen(controller, LabScreens.DASHBOARD_SCREEN, LabScreens.VIEWDB_SCREEN);
//                break;
//            case "extraBT":
//                ScreenController.changeScreen(controller, LabScreens.DASHBOARD_SCREEN, LabScreens.EXTRA_SCREEN);
//                break;
//
//        }
//    }
}



