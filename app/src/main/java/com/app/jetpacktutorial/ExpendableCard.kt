@file:OptIn(ExperimentalMaterialApi::class)

package com.app.jetpacktutorial

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

import androidx.compose.ui.unit.dp
import java.security.AllPermission


//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun CardExpandable(){
//    var expanded by remember { mutableStateOf(false) }
//    val rotateState by animateFloatAsState(targetValue = if (expanded) 180f else 0f, label = "")
//
//    Card (
//        modifier = Modifier
//            .fillMaxWidth()
//            .animateContentSize(
//                animationSpec = tween(
//                    delayMillis = 300,
//                    easing = LinearOutSlowInEasing
//                )
//            ),
//        shape = RoundedCornerShape(4.dp),
//        onClick = {
//            expanded = !expanded
//        }
//    ) {
//        Column (
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(12.dp)
//        ) {
//            Row (verticalAlignment = Alignment.CenterVertically) {
//                Text(
//                    modifier = Modifier
//                        .weight(6f),
//                    text = "My Title",
//                    fontSize = MaterialTheme.typography.h6.fontSize,
//                    fontWeight = FontWeight.Bold,
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis
//                )
//                IconButton(
//                    modifier = Modifier
//                        .alpha(ContentAlpha.medium)
//                        .weight(1f)
//                        .rotate(rotateState),
//                    onClick = { expanded = !expanded }
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.ArrowDropDown,
//                        contentDescription = "Drop-Down Arrow"
//                    )
//                }
//            }
//        }
//    }
//}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardExpendableImage(
    titleText: String,
    titleFontSize: TextUnit = MaterialTheme.typography.h6.fontSize,
    titleFontWeight: FontWeight = FontWeight.Bold,
    description: String,
    descriptionFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    descriptionFontWeight: FontWeight = FontWeight.Normal,
    descriptionMaxLine: Int = 5,
    shape: CornerBasedShape = RoundedCornerShape(4.dp),
    padding: Dp = 12.dp
){
    var expanded by remember { mutableStateOf(false) }
    val rotateState by animateFloatAsState(targetValue = if (expanded) 180f else 0f, label = "")

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .padding(padding),
        shape = shape,
        onClick = {
            expanded = !expanded
        }
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = titleText,
                    fontSize = titleFontSize,
                    fontWeight = titleFontWeight,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotateState),
                    onClick = { expanded = !expanded }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.dropdown),
                        contentDescription = "Drop-down icon",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(4.dp)),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
            if (expanded){
                Text(
                    text = description,
                    fontSize = descriptionFontSize,
                    fontWeight = descriptionFontWeight,
                    maxLines = descriptionMaxLine,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var text by remember { mutableStateOf("")}
        var passwordText by remember{ mutableStateOf("")}


        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Your Email") },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Icon")
                }
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Check, contentDescription = "Check Icon")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { Log.i("onSearch","Clicked") }
            )
        )
        OutlinedTextField(
            value = passwordText,
            onValueChange = { passwordText = it },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Password") },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock Icon")
                }
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Edit, contentDescription = "Edit Icon")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onSearch = { Log.i("Password","Clicked") }
            ),
            visualTransformation = PasswordVisualTransformation()
        )
    }
}



@Preview(showBackground = true)
@Composable
fun TextPreview(){
    TextField()
}

