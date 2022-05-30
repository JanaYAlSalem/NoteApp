package com.janayalsalem.noteapp.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.janayalsalem.noteapp.dataLayer.model.Note
import com.janayalsalem.noteapp.ui.utils.formatDate


@Composable
fun ItemOfData(modifier: Modifier = Modifier,
               data: Note,
               onNoteClicked: (String) -> Unit) {
    Surface(
        modifier
            .padding(4.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = 33.dp,
                    bottomStart = 33.dp,
                    topStart = 33.dp,
                    bottomEnd = 33.dp
                )
            )
            .fillMaxWidth(),
        color = Color(0xFFDFE6EB),
        elevation = 6.dp) {
        Column(
            modifier
                .padding(horizontal = 14.dp, vertical = 6.dp)
                .animateContentSize(),
            horizontalAlignment = Alignment.Start) {
            Text(text = data.title,
                style = MaterialTheme.typography.subtitle2)
            Text(text = data.description, style = MaterialTheme.typography.subtitle1)
            Text(text = formatDate(data.entryDate.time),
                style = MaterialTheme.typography.caption)

            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Filled.Delete,
                        contentDescription = "Delete",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                }


            }

        }


    }
}

@Composable
fun DataColumn(data : List<Note>) {
    LazyColumn {
        items(data) { item ->
            ItemOfData(data = item, onNoteClicked = {})
        }
    }
}
@ExperimentalComposeUiApi
@Composable
fun NoteInputText( modifier: Modifier = Modifier,
               text: String,
               label: String,
               maxLine: Int = 1,
               onTextChange: (String) -> Unit,
               onImeAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent),
        maxLines = maxLine,
        label = { Text(text = label)},
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()

        }),
        modifier = modifier
    )

}

@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    Button(onClick = onClick,
        shape = CircleShape,
        enabled = enabled,
        modifier = modifier) {
        Text(text)

    }

}

