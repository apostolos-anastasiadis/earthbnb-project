package com.example.airbnbclone1;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText usernameEditText = findViewById(R.id.usernameEditText);
        final EditText passwordEditText = findViewById(R.id.passwordEditText);
        final EditText confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        final EditText firstNameEditText = findViewById(R.id.firstNameEditText);
        final EditText lastNameEditText = findViewById(R.id.lastNameEditText);
        final EditText emailEditText = findViewById(R.id.emailEditText);
        final EditText phoneNumberEditText = findViewById(R.id.phoneNumberEditText);

        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the user input from the EditText fields
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();
                String firstName = firstNameEditText.getText().toString().trim();
                String lastName = lastNameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String phoneNumber = phoneNumberEditText.getText().toString().trim();

                // Perform input validation (optional)
                if (username.isEmpty() || password.isEmpty() || firstName.isEmpty() || confirmPassword.isEmpty() || !password.equals(confirmPassword) ||
                        lastName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields and ensure the passwords match.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Create a new User instance with the provided data
                User user = new User(username, password, firstName, lastName, email, phoneNumber);

                // Now you can use the user object as needed, for example, you can display the data:
                displayUserData(user);
            }
        });
    }

    private void displayUserData(User user) {
        // Create a formatted message to display user data
        String message = "Username: " + user.getUsername() +
                "\nPassword: " + user.getPassword() +
                "\nFirst Name: " + user.getFirstName() +
                "\nLast Name: " + user.getLastName() +
                "\nEmail: " + user.getEmail() +
                "\nPhone Number: " + user.getPhoneNumber();

        // Display the message using a Toast
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
