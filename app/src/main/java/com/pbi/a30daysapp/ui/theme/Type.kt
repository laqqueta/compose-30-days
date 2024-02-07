package com.pbi.a30daysapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.pbi.a30daysapp.R


private val Sarabun = FontFamily(
    Font(R.font.sarabun_regular, FontWeight.Normal),
    Font(R.font.sarabun_medium, FontWeight.Medium),
    Font(R.font.sarabun_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    titleMedium = TextStyle(
        fontFamily = Sarabun,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Sarabun,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Sarabun,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        textAlign = TextAlign.Justify
    ),
    labelMedium = TextStyle(
        fontFamily = Sarabun,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp
    )
)