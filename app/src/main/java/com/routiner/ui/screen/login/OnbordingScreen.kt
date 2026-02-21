package com.routiner.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.routiner.R
import com.routiner.ui.component.SocialButton
import com.routiner.ui.theme.blue40
import com.routiner.ui.theme.mainBlueGradient

@Composable
fun OnbordingScreen(onFinished: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(mainBlueGradient)
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box { Text("Инфографика") }
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        ),
                        onClick = onFinished) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_login),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                            Text("Continue with E-mail")
                        }
                    }

                }
                Spacer(Modifier.heightIn(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    SocialButton(
                        text = "Apple",
                        iconRes = R.drawable.ic_apple,
                        onClick = {},
                        modifier = Modifier.weight(1f)
                    )
                    SocialButton(
                        text = "Google",
                        iconRes = R.drawable.ic_google,
                        onClick = {},
                        modifier = Modifier.weight(1f)
                    )
                    SocialButton(
                        text = "Facebook",
                        iconRes = R.drawable.ic_facebook,
                        onClick = {},
                        modifier = Modifier.weight(1.3f)
                    )
                }
                Spacer(Modifier.heightIn(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        color = blue40,
                        fontSize = 12.sp,
                        text = "By continuing you agree Terms of Services & Privacy Policy"
                    )
                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnbordingSceenPreview() {
    OnbordingScreen({ return@OnbordingScreen })
}
