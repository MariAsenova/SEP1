import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FitnessGUI extends Application
{
  /**
   * An abstract method which automatically calls the launch
   * @param window setting the stage
   * @throws IOException exception thrown if an IO error occurs
   */
  public void start(Stage window) throws IOException
  {
    window.setTitle("VIAFit");
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("FitnessGUI.fxml"));
    Scene scene = new Scene(loader.load());
    window.setResizable(false);
    window.setScene(scene);
    window.show();
  }

}


