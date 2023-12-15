package com.example.loginpage.ui.loginscreen

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpage.R

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginScreen()
}

@Composable
fun LoginScreen() {
    MaterialTheme {
        ShowLoginScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun ShowLoginScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            // Header Text
            Text(
                text = stringResource(
                    R.string.label_sign_in_to_account
                ), fontSize = 24.sp, fontWeight = FontWeight.Black

            )

            Spacer(modifier = Modifier.height(32.dp))

            val passwordFocusRequester = FocusRequester()
            // Card layout for username and password
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                elevation = CardDefaults.cardElevation(35.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Username field
                    EmailInput(
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(passwordFocusRequester)
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    // Password field
                    PasswordInput(
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(passwordFocusRequester)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    val context = LocalContext.current
                    Button(onClick = {
                    }) {
                        Toast.makeText(context, "Sign in", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput(
    modifier: Modifier = Modifier
) {
    TextField(modifier = modifier.testTag(""), keyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Done, keyboardType = KeyboardType.Password
    ), value = "" ?: "", onValueChange = {}, label = { Text(text = stringResource(id = R.string.label_password)) }, leadingIcon = {
        Icon(
            imageVector = Icons.Default.Lock, contentDescription = null
        )
    })

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailInput(
    modifier: Modifier = Modifier
) {
    TextField(
        modifier = modifier.testTag("TAG_INPUT_EMAIL"),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email,
        ),
        value = "" ?: "",
        onValueChange = {},
        label = { Text(text = stringResource(id = R.string.username)) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.AccountBox, contentDescription = null
            )
        },
        singleLine = true
    )
}


