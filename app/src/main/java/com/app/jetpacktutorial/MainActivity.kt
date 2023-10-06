package com.app.jetpacktutorial

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.jetpacktutorial.ui.theme.JetpackTutorialTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTutorialTheme {
                // A surface container using the 'background' color from the theme
                Column (
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CoilImage()
                }
            }
        }
    }
}


@Composable
fun CustomText(){
    Column (modifier = Modifier.fillMaxSize()) {
        Text(
            text = stringResource(id = R.string.hello),
            modifier = Modifier
                .background(colorResource(id = R.color.background))
                .padding(16.dp)
                .width(200.dp),
            color = Color.Black,
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun CustomText2(){
    val colorSpanStyle = MaterialTheme.colorScheme.primary
    Text(
        buildAnnotatedString {
            withStyle(style = ParagraphStyle(TextAlign.Center)){
                withStyle(style = SpanStyle(
                    color = colorSpanStyle,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )){
                    append("A")
                }
                append("B")
                append("C")
                append("D")
            }
        }, modifier = Modifier
            .width(200.dp)
            .padding(20.dp)
    )
}

@Preview
@Composable
fun TextSelection(){
    SelectionContainer {
        Column {
            Text(text = "Hello World!")
            DisableSelection {
                Text(text = "Hello World!")
            }
            Text(text = "Hello World!")
        }
    }
}


@Composable
fun SuperText(
    normalText: String,
    superText: String,
    normalTextSize: TextUnit = MaterialTheme.typography.headlineLarge.fontSize,
    superTextSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize,
    superTextFontWeight: FontWeight
){
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = normalTextSize,
                    fontWeight = FontWeight.Bold,
                )
            ){
                append(normalText)
            }
            withStyle(
                style = SpanStyle(
                    fontSize = superTextSize,
                    fontWeight = superTextFontWeight,
                    baselineShift = BaselineShift.Superscript
                )
            ){
                append(superText)
            }
        }
    )
}


@Preview
@Composable
fun CustomText3(){
    Surface (modifier = Modifier
        .height(50.dp)
        .fillMaxSize()) {
        Text(text = "Hello World!".repeat(20), maxLines = 2, overflow = TextOverflow.Ellipsis)
    }
}




@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    JetpackTutorialTheme {
        Surface (modifier = Modifier.fillMaxSize()) {
            SuperText(normalText = "Hello", superText = "World!", superTextFontWeight = FontWeight.Light )
        }
    }
}
