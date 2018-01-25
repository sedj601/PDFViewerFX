/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfviewer;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author blj0011
 */
public class FXMLDocumentController implements Initializable
{

    @FXML
    WebView wbMain;

    WebEngine webEngine;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        webEngine = wbMain.getEngine();

        //webEngine.setUserStyleSheetLocation(getClass().getResource("resources/web/web.css").toExternalForm());
        webEngine.setJavaScriptEnabled(true);
        //webEngine.load("https://cloudspace.idrsolutions.com:8181/HTML_Page_Extraction/output/e6822934-6ac1-497e-a7a1-d0d7936e7581/test3/index.html?page=1");
        File file = new File("test3/index.html");

        if (file.exists()) {
            System.out.println("file exist!");
        }

        webEngine.load(file.toURI().toString());

    }

    @FXML
    public void handleBTNLeftOnAction(ActionEvent event)
    {

    }

    @FXML
    public void handleBTNRightOnAction(ActionEvent event)
    {

    }

    @FXML
    public void handleTFOnkeyreleased(KeyEvent event)
    {
        TextField tempTextField = (TextField) event.getSource();
        webEngine.executeScript("$('body').removeHighlight().highlight('" + tempTextField.getText() + "')");
    }
}
