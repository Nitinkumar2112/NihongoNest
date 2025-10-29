package com.example.yourappname

import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.jet.japapp.R

@Composable
fun ChannelLinksCard(
    title: String,
    channels: List<LinkItem>,
    @DrawableRes imageResId: Int
) {
    val borderColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    val cardShape = RoundedCornerShape(16.dp)
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 2.dp,
                color = borderColor,
                shape = cardShape
            ),
        shape = cardShape
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            channels.forEach { channel ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(channel.title, modifier = Modifier.weight(1f))
                    IconButton(
                        onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(channel.youtubeUrl))
                            context.startActivity(intent)
                        },
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                    ) {
                        Image(
                            painter = painterResource(id = imageResId),
                            contentDescription = "Open Link"
                        )
                    }
                }
            }
        }
    }
}

// --- ADDED: The TipsCard is now in this shared file ---
@Composable
fun TipsCard() {
    val context = LocalContext.current
    val videoUrl = "https://youtu.be/5o1o7nBusWU?si=551EiTY34bWNlDni"
    val bookUrl = "https://online.flippingbook.com/view/614400196/"
    val videoIntent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl)) }
    val bookIntent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(bookUrl)) }
    val buttonBorderColor = if (isSystemInDarkTheme()) Color(0xFF283593) else Color(0xFFFFC1CC)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Tips & Practice Book! 📖",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedButton(
                onClick = { context.startActivity(videoIntent) },
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(2.dp, buttonBorderColor)
            ) {
                Text("Watch Tips Video")
            }
            OutlinedButton(
                onClick = { context.startActivity(bookIntent) },
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(2.dp, buttonBorderColor)
            ) {
                Text("Practice from Book")
            }
        }
    }
}