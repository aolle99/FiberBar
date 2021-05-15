package cat.fiberfarra.fiberbar.data;

import android.widget.EditText;
import android.widget.TextView;

import cat.fiberfarra.fiberbar.R;
import cat.fiberfarra.fiberbar.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            /**
            EditText editText = findViewById(R.id.username);
            String value = editText.getText().toString();*/

            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}